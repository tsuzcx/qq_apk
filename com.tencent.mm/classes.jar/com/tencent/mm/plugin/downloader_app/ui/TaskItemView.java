package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.c.b.r;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.plugin.downloader_app.e.a;
import com.tencent.mm.plugin.downloader_app.e.b;
import com.tencent.mm.plugin.downloader_app.e.c;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.plugin.downloader_app.e.g;
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.Iterator;

public class TaskItemView
  extends LinearLayout
{
  i unJ;
  private AppIconView unT;
  private TextView unU;
  private TextView unV;
  private TextView unW;
  private FrameLayout unX;
  private ProgressImageView unY;
  private FrameLayout unZ;
  ImageView unl;
  private Button uoa;
  private Button uob;
  private DownloadUpdateDescView uoc;
  private LinearLayout uod;
  private ImageView uoe;
  private TextView uof;
  boolean uog = false;
  private a uoh;
  
  public TaskItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private long getFileSize()
  {
    AppMethodBeat.i(9048);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.asU(this.unJ.appId);
    if ((locala != null) && (locala.field_fileSize > 0L))
    {
      l = locala.field_fileSize;
      AppMethodBeat.o(9048);
      return l;
    }
    long l = this.unJ.umu.ufr;
    AppMethodBeat.o(9048);
    return l;
  }
  
  private void p(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(184795);
    long l = getFileSize();
    float f2 = (float)l / 1.073742E+009F;
    float f1 = (float)l / 1048576.0F;
    if (paramLong >= l)
    {
      if (f2 >= 1.0F)
      {
        this.unW.setText(String.format("%.1fGB", new Object[] { Float.valueOf(f2) }));
        AppMethodBeat.o(184795);
        return;
      }
      this.unW.setText(String.format("%.1fMB", new Object[] { Float.valueOf(f1) }));
      AppMethodBeat.o(184795);
      return;
    }
    f2 = (float)paramLong / 1048576.0F;
    this.unW.setText(String.format("%.1fMB / %.1fMB", new Object[] { Float.valueOf(f2), Float.valueOf(f1) }));
    if (paramBoolean)
    {
      int i = (int)(100L * paramLong / l);
      this.unY.setProgress(i);
    }
    AppMethodBeat.o(184795);
  }
  
  private void setButtonText(int paramInt)
  {
    AppMethodBeat.i(183831);
    if (paramInt == e.h.uld)
    {
      this.uoa.setVisibility(8);
      this.uob.setVisibility(0);
    }
    for (;;)
    {
      this.unZ.setVisibility(0);
      AppMethodBeat.o(183831);
      return;
      this.uob.setVisibility(8);
      this.uoa.setVisibility(0);
      this.uoa.setText(paramInt);
    }
  }
  
  private void setTaskSize(long paramLong)
  {
    AppMethodBeat.i(9046);
    p(paramLong, false);
    AppMethodBeat.o(9046);
  }
  
  final void cQV()
  {
    boolean bool = false;
    AppMethodBeat.i(9045);
    Log.d("MicroMsg.TaskItemView", "updateDownloadStatus: %s", new Object[] { this.unJ.appId });
    this.unZ.setVisibility(8);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.asU(this.unJ.appId);
    if ((locala == null) || (locala.field_status == 5))
    {
      setTaskSize(getFileSize());
      this.unX.setVisibility(8);
      setButtonText(e.h.ukN);
      AppMethodBeat.o(9045);
      return;
    }
    if (locala.field_status == 3)
    {
      this.unX.setVisibility(8);
      setButtonText(e.h.uld);
    }
    for (;;)
    {
      p(locala.field_downloadedSize, bool);
      AppMethodBeat.o(9045);
      return;
      if (locala.field_status == 6)
      {
        this.unX.setVisibility(8);
        if (e.IJ(locala.field_downloadId)) {
          setButtonText(e.h.ulg);
        } else {
          setButtonText(e.h.uld);
        }
      }
      else
      {
        this.unX.setVisibility(0);
        if (this.uog)
        {
          this.unY.cQT();
        }
        else if (locala.field_status == 1)
        {
          this.uog = false;
          this.unY.setProgressColor(e.b.Brand);
          this.unY.setImageResource(e.g.downloading);
          bool = true;
        }
        else if ((locala.field_reserveInWifi) && (!NetStatusUtil.isWifi(getContext())))
        {
          this.unX.setVisibility(0);
          this.unY.setProgressColor(e.b.FG_1);
          this.unY.cQU();
        }
        else if (locala.field_status == 4)
        {
          this.unX.setVisibility(8);
          setButtonText(e.h.ukT);
        }
        else
        {
          this.unY.setProgressColor(e.b.FG_1);
          this.unY.setImageResource("download_app_pause");
          bool = true;
        }
      }
    }
  }
  
  public int getNamePaddingLeft()
  {
    AppMethodBeat.i(9047);
    if (this.unl.getVisibility() == 0)
    {
      i = getResources().getDimensionPixelSize(e.c.ujI);
      AppMethodBeat.o(9047);
      return i;
    }
    int i = getResources().getDimensionPixelSize(e.c.ujH);
    AppMethodBeat.o(9047);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(9042);
    super.onAttachedToWindow();
    AppMethodBeat.o(9042);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(9041);
    super.onDetachedFromWindow();
    AppMethodBeat.o(9041);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9040);
    super.onFinishInflate();
    this.unl = ((ImageView)findViewById(e.e.ujS));
    this.unT = ((AppIconView)findViewById(e.e.icon));
    this.unU = ((TextView)findViewById(e.e.item_name));
    this.unV = ((TextView)findViewById(e.e.uki));
    this.unW = ((TextView)findViewById(e.e.dKn));
    this.unX = ((FrameLayout)findViewById(e.e.ukl));
    this.unY = ((ProgressImageView)findViewById(e.e.uks));
    this.unY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((TaskItemView.a(TaskItemView.this) != null) && (TaskItemView.a(TaskItemView.this).cQR()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9028);
          return;
        }
        paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.asU(TaskItemView.b(TaskItemView.this).appId);
        if (paramAnonymousView.field_status == 1) {
          com.tencent.mm.plugin.downloader_app.a.c.b(TaskItemView.this.getContext(), TaskItemView.b(TaskItemView.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9028);
          return;
          if (TaskItemView.c(TaskItemView.this).unN) {
            com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), paramAnonymousView.field_downloadId, new a.b()
            {
              public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
              {
                AppMethodBeat.i(183827);
                if (paramAnonymous2a != a.a.ulC) {
                  TaskItemView.d(TaskItemView.this);
                }
                AppMethodBeat.o(183827);
              }
            });
          } else {
            com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.b(TaskItemView.this), new a.b()
            {
              public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
              {
                AppMethodBeat.i(184794);
                if (paramAnonymous2a == a.a.ulC) {
                  TaskItemView.d(TaskItemView.this);
                }
                AppMethodBeat.o(184794);
              }
            });
          }
        }
      }
    });
    this.unZ = ((FrameLayout)findViewById(e.e.ujR));
    this.uoa = ((Button)findViewById(e.e.ukk));
    this.uoa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9031);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((TaskItemView.a(TaskItemView.this) != null) && (TaskItemView.a(TaskItemView.this).cQR()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9031);
          return;
        }
        if (TaskItemView.b(TaskItemView.this).type == 6) {
          com.tencent.mm.plugin.downloader_app.a.c.d(TaskItemView.this.getContext(), TaskItemView.b(TaskItemView.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9031);
          return;
          paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.asU(TaskItemView.b(TaskItemView.this).appId);
          if (paramAnonymousView != null)
          {
            if (TaskItemView.e(TaskItemView.this).getText().equals(TaskItemView.this.getResources().getString(e.h.ulg))) {
              if (u.agG(paramAnonymousView.field_filePath)) {
                continue;
              }
            }
          }
          else
          {
            com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.b(TaskItemView.this));
            continue;
          }
          com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.b(TaskItemView.this));
        }
      }
    });
    this.uob = ((Button)findViewById(e.e.ukg));
    this.uob.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((TaskItemView.a(TaskItemView.this) != null) && (TaskItemView.a(TaskItemView.this).cQR()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9033);
          return;
        }
        com.tencent.mm.plugin.downloader_app.a.c.c(TaskItemView.this.getContext(), TaskItemView.b(TaskItemView.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(9033);
      }
    });
    this.uoc = ((DownloadUpdateDescView)findViewById(e.e.ukt));
    this.uod = ((LinearLayout)findViewById(e.e.ujX));
    this.uoe = ((ImageView)findViewById(e.e.ujZ));
    this.uof = ((TextView)findViewById(e.e.ujY));
    this.uod.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183828);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((TaskItemView.b(TaskItemView.this) != null) && (TaskItemView.b(TaskItemView.this).umw != null) && (!Util.isNullOrNil(TaskItemView.b(TaskItemView.this).umw.ufp)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("rawUrl", TaskItemView.b(TaskItemView.this).umw.ufp);
          ((com.tencent.mm.plugin.downloader_app.api.c)h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).f(TaskItemView.this.getContext(), paramAnonymousView);
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, TaskItemView.b(TaskItemView.this).position, 40, TaskItemView.b(TaskItemView.this).appId, "", "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183828);
      }
    });
    AppMethodBeat.o(9040);
  }
  
  public void setData(i parami)
  {
    AppMethodBeat.i(9044);
    this.unJ = parami;
    if (parami == null)
    {
      setVisibility(8);
      AppMethodBeat.o(9044);
      return;
    }
    setVisibility(0);
    this.unX.setVisibility(8);
    this.unZ.setVisibility(8);
    this.uoc.setVisibility(8);
    this.uod.setVisibility(8);
    new c.a().lRD = true;
    q.bml().loadImage(this.unJ.iconUrl, this.unT);
    this.unU.setText(this.unJ.appName);
    parami = com.tencent.mm.plugin.downloader.model.d.asU(this.unJ.appId);
    if ((parami != null) && (parami.field_autoDownload)) {
      this.unV.setVisibility(0);
    }
    while (this.unJ.toj)
    {
      if (this.unl.getVisibility() != 0)
      {
        this.unl.setVisibility(0);
        this.unl.startAnimation(AnimationUtils.loadAnimation(getContext(), e.a.ujw));
      }
      setSelected(this.unJ.isSelected);
      setTaskSize(getFileSize());
      AppMethodBeat.o(9044);
      return;
      this.unV.setVisibility(8);
    }
    this.unl.setVisibility(8);
    if (this.unJ.umw != null)
    {
      parami = (LinearLayout.LayoutParams)this.uod.getLayoutParams();
      if (this.unJ.toj)
      {
        parami.leftMargin = getResources().getDimensionPixelSize(e.c.ujI);
        this.uod.setLayoutParams(parami);
        this.uod.setVisibility(0);
        new c.a().lRD = true;
        q.bml().loadImage(this.unJ.umw.icon, this.uoe);
        if (this.unJ.umw.ufn != null) {
          this.uof.setText(this.unJ.umw.ufn.value);
        }
        if (!this.unJ.umr)
        {
          this.unJ.umr = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, this.unJ.position, 1, this.unJ.appId, "", "");
        }
      }
    }
    for (;;)
    {
      setTaskSize(getFileSize());
      this.uoc.setVisibility(8);
      if (this.unJ.type != 4) {
        break label537;
      }
      parami = com.tencent.mm.plugin.downloader.model.d.asU(this.unJ.appId);
      if ((parami != null) && (parami.field_status != 0) && (parami.field_status != 5)) {
        break label526;
      }
      this.unX.setVisibility(8);
      setButtonText(e.h.ulv);
      this.uoc.setData(this.unJ);
      AppMethodBeat.o(9044);
      return;
      parami.leftMargin = getResources().getDimensionPixelSize(e.c.ujH);
      break;
      this.uod.setVisibility(8);
    }
    label526:
    cQV();
    AppMethodBeat.o(9044);
    return;
    label537:
    if (this.unJ.type == 6)
    {
      this.unX.setVisibility(8);
      setButtonText(e.h.ulf);
      AppMethodBeat.o(9044);
      return;
    }
    cQV();
    AppMethodBeat.o(9044);
  }
  
  public void setOnItemOpButtonClickListener(a parama)
  {
    this.uoh = parama;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(9043);
    Log.d("MicroMsg.TaskItemView", "setSelected selected: %b, appid: %s", new Object[] { Boolean.valueOf(paramBoolean), this.unJ.appId });
    this.unJ.isSelected = paramBoolean;
    if (paramBoolean) {
      com.tencent.mm.plugin.downloader_app.b.e(this.unl, "checkbox_cell_on");
    }
    Object localObject;
    for (;;)
    {
      localObject = getParent();
      if (localObject == null) {
        break label219;
      }
      if (!(localObject instanceof TaskListView)) {
        break label209;
      }
      localObject = (TaskListView)localObject;
      Iterator localIterator = ((TaskListView)localObject).uos.uok.iterator();
      paramBoolean = false;
      i = 1;
      for (;;)
      {
        label94:
        if (!localIterator.hasNext()) {
          break label155;
        }
        i locali = (i)localIterator.next();
        if (!locali.cQH()) {
          break label226;
        }
        if (!locali.isSelected) {
          break;
        }
        paramBoolean = true;
      }
      com.tencent.mm.plugin.downloader_app.b.e(this.unl, "checkbox_cell_off");
    }
    int i = 0;
    label155:
    label209:
    label219:
    label226:
    for (;;)
    {
      break label94;
      com.tencent.mm.plugin.downloader_app.a.d.mk(paramBoolean);
      if (i != 0)
      {
        if ((((TaskListView)localObject).getContext() instanceof DownloadMainUI))
        {
          ((DownloadMainUI)((TaskListView)localObject).getContext()).mp(true);
          AppMethodBeat.o(9043);
        }
      }
      else {
        ((DownloadMainUI)((TaskListView)localObject).getContext()).mp(false);
      }
      AppMethodBeat.o(9043);
      return;
      localObject = ((ViewParent)localObject).getParent();
      break;
      AppMethodBeat.o(9043);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean cQR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView
 * JD-Core Version:    0.7.0.1
 */