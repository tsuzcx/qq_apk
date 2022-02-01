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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.b.r;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Iterator;

public class TaskItemView
  extends LinearLayout
{
  ImageView pwI;
  private LinearLayout pxA;
  private ImageView pxB;
  private TextView pxC;
  boolean pxD = false;
  i pxg;
  private AppIconView pxq;
  private TextView pxr;
  private TextView pxs;
  private TextView pxt;
  private FrameLayout pxu;
  private ProgressImageView pxv;
  private FrameLayout pxw;
  private Button pxx;
  private Button pxy;
  private DownloadUpdateDescView pxz;
  
  public TaskItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private long getFileSize()
  {
    AppMethodBeat.i(9048);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.aaU(this.pxg.appId);
    if ((locala != null) && (locala.field_fileSize > 0L))
    {
      l = locala.field_fileSize;
      AppMethodBeat.o(9048);
      return l;
    }
    long l = this.pxg.pvR.pqL;
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
        this.pxt.setText(String.format("%.1fGB", new Object[] { Float.valueOf(f2) }));
        AppMethodBeat.o(184795);
        return;
      }
      this.pxt.setText(String.format("%.1fMB", new Object[] { Float.valueOf(f1) }));
      AppMethodBeat.o(184795);
      return;
    }
    f2 = (float)paramLong / 1048576.0F;
    this.pxt.setText(String.format("%.1fMB / %.1fMB", new Object[] { Float.valueOf(f2), Float.valueOf(f1) }));
    if (paramBoolean)
    {
      int i = (int)(100L * paramLong / l);
      this.pxv.setProgress(i);
    }
    AppMethodBeat.o(184795);
  }
  
  private void setButtonText(int paramInt)
  {
    AppMethodBeat.i(183831);
    if (paramInt == 2131760341)
    {
      this.pxx.setVisibility(8);
      this.pxy.setVisibility(0);
    }
    for (;;)
    {
      this.pxw.setVisibility(0);
      AppMethodBeat.o(183831);
      return;
      this.pxy.setVisibility(8);
      this.pxx.setVisibility(0);
      this.pxx.setText(paramInt);
    }
  }
  
  private void setTaskSize(long paramLong)
  {
    AppMethodBeat.i(9046);
    p(paramLong, false);
    AppMethodBeat.o(9046);
  }
  
  final void ceA()
  {
    boolean bool = false;
    AppMethodBeat.i(9045);
    ae.d("MicroMsg.TaskItemView", "updateDownloadStatus: %s", new Object[] { this.pxg.appId });
    this.pxw.setVisibility(8);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.aaU(this.pxg.appId);
    if ((locala == null) || (locala.field_status == 5))
    {
      setTaskSize(getFileSize());
      this.pxu.setVisibility(8);
      setButtonText(2131758091);
      AppMethodBeat.o(9045);
      return;
    }
    if (locala.field_status == 3)
    {
      this.pxu.setVisibility(8);
      setButtonText(2131760341);
    }
    for (;;)
    {
      p(locala.field_downloadedSize, bool);
      AppMethodBeat.o(9045);
      return;
      if (locala.field_status == 6)
      {
        this.pxu.setVisibility(8);
        if (e.uv(locala.field_downloadId)) {
          setButtonText(2131761210);
        } else {
          setButtonText(2131760341);
        }
      }
      else
      {
        this.pxu.setVisibility(0);
        if (this.pxD)
        {
          this.pxv.cey();
        }
        else if (locala.field_status == 1)
        {
          this.pxD = false;
          this.pxv.setProgressColor(2131099699);
          this.pxv.setImageResource(2131690078);
          bool = true;
        }
        else if ((locala.field_reserveInWifi) && (!az.isWifi(getContext())))
        {
          this.pxu.setVisibility(0);
          this.pxv.cez();
        }
        else if (locala.field_status == 4)
        {
          this.pxu.setVisibility(8);
          setButtonText(2131758118);
        }
        else
        {
          this.pxv.setProgressColor(2131099734);
          this.pxv.setImageResource("download_app_pause");
          bool = true;
        }
      }
    }
  }
  
  public int getNamePaddingLeft()
  {
    AppMethodBeat.i(9047);
    if (this.pwI.getVisibility() == 0)
    {
      i = getResources().getDimensionPixelSize(2131166044);
      AppMethodBeat.o(9047);
      return i;
    }
    int i = getResources().getDimensionPixelSize(2131166043);
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
    this.pwI = ((ImageView)findViewById(2131298219));
    this.pxq = ((AppIconView)findViewById(2131300874));
    this.pxr = ((TextView)findViewById(2131301169));
    this.pxs = ((TextView)findViewById(2131301170));
    this.pxt = ((TextView)findViewById(2131301191));
    this.pxu = ((FrameLayout)findViewById(2131303520));
    this.pxv = ((ProgressImageView)findViewById(2131305673));
    this.pxv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.aaU(TaskItemView.a(TaskItemView.this).appId);
        if (paramAnonymousView.field_status == 1) {
          com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.a(TaskItemView.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9028);
          return;
          if (TaskItemView.b(TaskItemView.this).pxk) {
            com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), paramAnonymousView.field_downloadId, new a.b()
            {
              public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
              {
                AppMethodBeat.i(183827);
                if (paramAnonymous2a != a.a.puE) {
                  TaskItemView.c(TaskItemView.this);
                }
                AppMethodBeat.o(183827);
              }
            });
          } else {
            com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this), new a.b()
            {
              public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
              {
                AppMethodBeat.i(184794);
                if (paramAnonymous2a == a.a.puE) {
                  TaskItemView.c(TaskItemView.this);
                }
                AppMethodBeat.o(184794);
              }
            });
          }
        }
      }
    });
    this.pxw = ((FrameLayout)findViewById(2131297655));
    this.pxx = ((Button)findViewById(2131303016));
    this.pxx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9031);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (TaskItemView.a(TaskItemView.this).type == 6) {
          com.tencent.mm.plugin.downloader_app.a.c.c(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9031);
          return;
          paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.aaU(TaskItemView.a(TaskItemView.this).appId);
          if (paramAnonymousView != null)
          {
            if (TaskItemView.d(TaskItemView.this).getText().equals(TaskItemView.this.getResources().getString(2131761210))) {
              if (o.fB(paramAnonymousView.field_filePath)) {
                continue;
              }
            }
          }
          else
          {
            com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
            continue;
          }
          com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
        }
      }
    });
    this.pxy = ((Button)findViewById(2131301037));
    this.pxy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.downloader_app.a.c.b(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(9033);
      }
    });
    this.pxz = ((DownloadUpdateDescView)findViewById(2131306203));
    this.pxA = ((LinearLayout)findViewById(2131299191));
    this.pxB = ((ImageView)findViewById(2131299193));
    this.pxC = ((TextView)findViewById(2131299192));
    this.pxA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183828);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((TaskItemView.a(TaskItemView.this) != null) && (TaskItemView.a(TaskItemView.this).pvT != null) && (!bu.isNullOrNil(TaskItemView.a(TaskItemView.this).pvT.pqJ)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("rawUrl", TaskItemView.a(TaskItemView.this).pvT.pqJ);
          ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).e(TaskItemView.this.getContext(), paramAnonymousView);
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, TaskItemView.a(TaskItemView.this).position, 40, TaskItemView.a(TaskItemView.this).appId, "", "");
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
    this.pxg = parami;
    if (parami == null)
    {
      setVisibility(8);
      AppMethodBeat.o(9044);
      return;
    }
    setVisibility(0);
    this.pxu.setVisibility(8);
    this.pxw.setVisibility(8);
    this.pxz.setVisibility(8);
    this.pxA.setVisibility(8);
    new c.a().igk = true;
    q.aJb().loadImage(this.pxg.iconUrl, this.pxq);
    this.pxr.setText(this.pxg.appName);
    parami = com.tencent.mm.plugin.downloader.model.d.aaU(this.pxg.appId);
    if ((parami != null) && (parami.field_autoDownload)) {
      this.pxs.setVisibility(0);
    }
    while (this.pxg.oEB)
    {
      if (this.pwI.getVisibility() != 0)
      {
        this.pwI.setVisibility(0);
        this.pwI.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772123));
      }
      setSelected(this.pxg.isSelected);
      setTaskSize(getFileSize());
      AppMethodBeat.o(9044);
      return;
      this.pxs.setVisibility(8);
    }
    this.pwI.setVisibility(8);
    if (this.pxg.pvT != null)
    {
      parami = (LinearLayout.LayoutParams)this.pxA.getLayoutParams();
      if (this.pxg.oEB)
      {
        parami.leftMargin = getResources().getDimensionPixelSize(2131166044);
        this.pxA.setLayoutParams(parami);
        this.pxA.setVisibility(0);
        new c.a().igk = true;
        q.aJb().loadImage(this.pxg.pvT.dEM, this.pxB);
        if (this.pxg.pvT.pqH != null) {
          this.pxC.setText(this.pxg.pvT.pqH.value);
        }
        if (!this.pxg.pvO)
        {
          this.pxg.pvO = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, this.pxg.position, 1, this.pxg.appId, "", "");
        }
      }
    }
    for (;;)
    {
      setTaskSize(getFileSize());
      this.pxz.setVisibility(8);
      if (this.pxg.type != 4) {
        break label537;
      }
      parami = com.tencent.mm.plugin.downloader.model.d.aaU(this.pxg.appId);
      if ((parami != null) && (parami.field_status != 0) && (parami.field_status != 5)) {
        break label526;
      }
      this.pxu.setVisibility(8);
      setButtonText(2131764584);
      this.pxz.setData(this.pxg);
      AppMethodBeat.o(9044);
      return;
      parami.leftMargin = getResources().getDimensionPixelSize(2131166043);
      break;
      this.pxA.setVisibility(8);
    }
    label526:
    ceA();
    AppMethodBeat.o(9044);
    return;
    label537:
    if (this.pxg.type == 6)
    {
      this.pxu.setVisibility(8);
      setButtonText(2131760670);
      AppMethodBeat.o(9044);
      return;
    }
    ceA();
    AppMethodBeat.o(9044);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(9043);
    ae.d("MicroMsg.TaskItemView", "setSelected selected: %b, appid: %s", new Object[] { Boolean.valueOf(paramBoolean), this.pxg.appId });
    this.pxg.isSelected = paramBoolean;
    if (paramBoolean) {
      com.tencent.mm.plugin.downloader_app.b.e(this.pwI, "checkbox_cell_on");
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
      Iterator localIterator = ((TaskListView)localObject).pxO.pxG.iterator();
      paramBoolean = false;
      i = 1;
      for (;;)
      {
        label94:
        if (!localIterator.hasNext()) {
          break label155;
        }
        i locali = (i)localIterator.next();
        if (!locali.cen()) {
          break label226;
        }
        if (!locali.isSelected) {
          break;
        }
        paramBoolean = true;
      }
      com.tencent.mm.plugin.downloader_app.b.e(this.pwI, "checkbox_cell_off");
    }
    int i = 0;
    label155:
    label209:
    label219:
    label226:
    for (;;)
    {
      break label94;
      com.tencent.mm.plugin.downloader_app.a.d.jV(paramBoolean);
      if (i != 0)
      {
        if ((((TaskListView)localObject).getContext() instanceof DownloadMainUI))
        {
          ((DownloadMainUI)((TaskListView)localObject).getContext()).ka(true);
          AppMethodBeat.o(9043);
        }
      }
      else {
        ((DownloadMainUI)((TaskListView)localObject).getContext()).ka(false);
      }
      AppMethodBeat.o(9043);
      return;
      localObject = ((ViewParent)localObject).getParent();
      break;
      AppMethodBeat.o(9043);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView
 * JD-Core Version:    0.7.0.1
 */