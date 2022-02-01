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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.b.r;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;

public class TaskItemView
  extends LinearLayout
{
  com.tencent.mm.plugin.downloader_app.a.i pqA;
  private AppIconView pqK;
  private TextView pqL;
  private TextView pqM;
  private TextView pqN;
  private FrameLayout pqO;
  private ProgressImageView pqP;
  private FrameLayout pqQ;
  private Button pqR;
  private Button pqS;
  private DownloadUpdateDescView pqT;
  private LinearLayout pqU;
  private ImageView pqV;
  private TextView pqW;
  boolean pqX = false;
  ImageView pqc;
  
  public TaskItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private long getFileSize()
  {
    AppMethodBeat.i(9048);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.aad(this.pqA.appId);
    if ((locala != null) && (locala.field_fileSize > 0L))
    {
      l = locala.field_fileSize;
      AppMethodBeat.o(9048);
      return l;
    }
    long l = this.pqA.ppl.pkg;
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
        this.pqN.setText(String.format("%.1fGB", new Object[] { Float.valueOf(f2) }));
        AppMethodBeat.o(184795);
        return;
      }
      this.pqN.setText(String.format("%.1fMB", new Object[] { Float.valueOf(f1) }));
      AppMethodBeat.o(184795);
      return;
    }
    f2 = (float)paramLong / 1048576.0F;
    this.pqN.setText(String.format("%.1fMB / %.1fMB", new Object[] { Float.valueOf(f2), Float.valueOf(f1) }));
    if (paramBoolean)
    {
      int i = (int)(100L * paramLong / l);
      this.pqP.setProgress(i);
    }
    AppMethodBeat.o(184795);
  }
  
  private void setButtonText(int paramInt)
  {
    AppMethodBeat.i(183831);
    if (paramInt == 2131760341)
    {
      this.pqR.setVisibility(8);
      this.pqS.setVisibility(0);
    }
    for (;;)
    {
      this.pqQ.setVisibility(0);
      AppMethodBeat.o(183831);
      return;
      this.pqS.setVisibility(8);
      this.pqR.setVisibility(0);
      this.pqR.setText(paramInt);
    }
  }
  
  private void setTaskSize(long paramLong)
  {
    AppMethodBeat.i(9046);
    p(paramLong, false);
    AppMethodBeat.o(9046);
  }
  
  final void cdl()
  {
    boolean bool = false;
    AppMethodBeat.i(9045);
    ad.d("MicroMsg.TaskItemView", "updateDownloadStatus: %s", new Object[] { this.pqA.appId });
    this.pqQ.setVisibility(8);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.aad(this.pqA.appId);
    if ((locala == null) || (locala.field_status == 5))
    {
      setTaskSize(getFileSize());
      this.pqO.setVisibility(8);
      setButtonText(2131758091);
      AppMethodBeat.o(9045);
      return;
    }
    if (locala.field_status == 3)
    {
      this.pqO.setVisibility(8);
      setButtonText(2131760341);
    }
    for (;;)
    {
      p(locala.field_downloadedSize, bool);
      AppMethodBeat.o(9045);
      return;
      if (locala.field_status == 6)
      {
        this.pqO.setVisibility(8);
        if (e.ue(locala.field_downloadId)) {
          setButtonText(2131761210);
        } else {
          setButtonText(2131760341);
        }
      }
      else
      {
        this.pqO.setVisibility(0);
        if (this.pqX)
        {
          this.pqP.cdj();
        }
        else if (locala.field_status == 1)
        {
          this.pqX = false;
          this.pqP.setProgressColor(2131099699);
          this.pqP.setImageResource(2131690078);
          bool = true;
        }
        else if ((locala.field_reserveInWifi) && (!ay.isWifi(getContext())))
        {
          this.pqO.setVisibility(0);
          this.pqP.cdk();
        }
        else if (locala.field_status == 4)
        {
          this.pqO.setVisibility(8);
          setButtonText(2131758118);
        }
        else
        {
          this.pqP.setProgressColor(2131099734);
          this.pqP.setImageResource("download_app_pause");
          bool = true;
        }
      }
    }
  }
  
  public int getNamePaddingLeft()
  {
    AppMethodBeat.i(9047);
    if (this.pqc.getVisibility() == 0)
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
    this.pqc = ((ImageView)findViewById(2131298219));
    this.pqK = ((AppIconView)findViewById(2131300874));
    this.pqL = ((TextView)findViewById(2131301169));
    this.pqM = ((TextView)findViewById(2131301170));
    this.pqN = ((TextView)findViewById(2131301191));
    this.pqO = ((FrameLayout)findViewById(2131303520));
    this.pqP = ((ProgressImageView)findViewById(2131305673));
    this.pqP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.aad(TaskItemView.a(TaskItemView.this).appId);
        if (paramAnonymousView.field_status == 1) {
          com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.a(TaskItemView.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9028);
          return;
          if (TaskItemView.b(TaskItemView.this).pqE) {
            com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), paramAnonymousView.field_downloadId, new a.b()
            {
              public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
              {
                AppMethodBeat.i(183827);
                if (paramAnonymous2a != a.a.pnX) {
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
                if (paramAnonymous2a == a.a.pnX) {
                  TaskItemView.c(TaskItemView.this);
                }
                AppMethodBeat.o(184794);
              }
            });
          }
        }
      }
    });
    this.pqQ = ((FrameLayout)findViewById(2131297655));
    this.pqR = ((Button)findViewById(2131303016));
    this.pqR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9031);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (TaskItemView.a(TaskItemView.this).type == 6) {
          com.tencent.mm.plugin.downloader_app.a.c.c(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9031);
          return;
          paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.aad(TaskItemView.a(TaskItemView.this).appId);
          if (paramAnonymousView != null)
          {
            if (TaskItemView.d(TaskItemView.this).getText().equals(TaskItemView.this.getResources().getString(2131761210))) {
              if (com.tencent.mm.vfs.i.fv(paramAnonymousView.field_filePath)) {
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
    this.pqS = ((Button)findViewById(2131301037));
    this.pqS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.downloader_app.a.c.b(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(9033);
      }
    });
    this.pqT = ((DownloadUpdateDescView)findViewById(2131306203));
    this.pqU = ((LinearLayout)findViewById(2131299191));
    this.pqV = ((ImageView)findViewById(2131299193));
    this.pqW = ((TextView)findViewById(2131299192));
    this.pqU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183828);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((TaskItemView.a(TaskItemView.this) != null) && (TaskItemView.a(TaskItemView.this).ppn != null) && (!bt.isNullOrNil(TaskItemView.a(TaskItemView.this).ppn.pke)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("rawUrl", TaskItemView.a(TaskItemView.this).ppn.pke);
          ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).e(TaskItemView.this.getContext(), paramAnonymousView);
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, TaskItemView.a(TaskItemView.this).position, 40, TaskItemView.a(TaskItemView.this).appId, "", "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183828);
      }
    });
    AppMethodBeat.o(9040);
  }
  
  public void setData(com.tencent.mm.plugin.downloader_app.a.i parami)
  {
    AppMethodBeat.i(9044);
    this.pqA = parami;
    if (parami == null)
    {
      setVisibility(8);
      AppMethodBeat.o(9044);
      return;
    }
    setVisibility(0);
    this.pqO.setVisibility(8);
    this.pqQ.setVisibility(8);
    this.pqT.setVisibility(8);
    this.pqU.setVisibility(8);
    new c.a().idr = true;
    q.aIJ().loadImage(this.pqA.iconUrl, this.pqK);
    this.pqL.setText(this.pqA.appName);
    parami = com.tencent.mm.plugin.downloader.model.d.aad(this.pqA.appId);
    if ((parami != null) && (parami.field_autoDownload)) {
      this.pqM.setVisibility(0);
    }
    while (this.pqA.oxZ)
    {
      if (this.pqc.getVisibility() != 0)
      {
        this.pqc.setVisibility(0);
        this.pqc.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772123));
      }
      setSelected(this.pqA.isSelected);
      setTaskSize(getFileSize());
      AppMethodBeat.o(9044);
      return;
      this.pqM.setVisibility(8);
    }
    this.pqc.setVisibility(8);
    if (this.pqA.ppn != null)
    {
      parami = (LinearLayout.LayoutParams)this.pqU.getLayoutParams();
      if (this.pqA.oxZ)
      {
        parami.leftMargin = getResources().getDimensionPixelSize(2131166044);
        this.pqU.setLayoutParams(parami);
        this.pqU.setVisibility(0);
        new c.a().idr = true;
        q.aIJ().loadImage(this.pqA.ppn.dDH, this.pqV);
        if (this.pqA.ppn.pkc != null) {
          this.pqW.setText(this.pqA.ppn.pkc.value);
        }
        if (!this.pqA.ppi)
        {
          this.pqA.ppi = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, this.pqA.position, 1, this.pqA.appId, "", "");
        }
      }
    }
    for (;;)
    {
      setTaskSize(getFileSize());
      this.pqT.setVisibility(8);
      if (this.pqA.type != 4) {
        break label537;
      }
      parami = com.tencent.mm.plugin.downloader.model.d.aad(this.pqA.appId);
      if ((parami != null) && (parami.field_status != 0) && (parami.field_status != 5)) {
        break label526;
      }
      this.pqO.setVisibility(8);
      setButtonText(2131764584);
      this.pqT.setData(this.pqA);
      AppMethodBeat.o(9044);
      return;
      parami.leftMargin = getResources().getDimensionPixelSize(2131166043);
      break;
      this.pqU.setVisibility(8);
    }
    label526:
    cdl();
    AppMethodBeat.o(9044);
    return;
    label537:
    if (this.pqA.type == 6)
    {
      this.pqO.setVisibility(8);
      setButtonText(2131760670);
      AppMethodBeat.o(9044);
      return;
    }
    cdl();
    AppMethodBeat.o(9044);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(9043);
    ad.d("MicroMsg.TaskItemView", "setSelected selected: %b, appid: %s", new Object[] { Boolean.valueOf(paramBoolean), this.pqA.appId });
    this.pqA.isSelected = paramBoolean;
    if (paramBoolean) {
      com.tencent.mm.plugin.downloader_app.b.e(this.pqc, "checkbox_cell_on");
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
      Iterator localIterator = ((TaskListView)localObject).pri.pra.iterator();
      paramBoolean = false;
      i = 1;
      for (;;)
      {
        label94:
        if (!localIterator.hasNext()) {
          break label155;
        }
        com.tencent.mm.plugin.downloader_app.a.i locali = (com.tencent.mm.plugin.downloader_app.a.i)localIterator.next();
        if (!locali.ccY()) {
          break label226;
        }
        if (!locali.isSelected) {
          break;
        }
        paramBoolean = true;
      }
      com.tencent.mm.plugin.downloader_app.b.e(this.pqc, "checkbox_cell_off");
    }
    int i = 0;
    label155:
    label209:
    label219:
    label226:
    for (;;)
    {
      break label94;
      com.tencent.mm.plugin.downloader_app.a.d.jW(paramBoolean);
      if (i != 0)
      {
        if ((((TaskListView)localObject).getContext() instanceof DownloadMainUI))
        {
          ((DownloadMainUI)((TaskListView)localObject).getContext()).kb(true);
          AppMethodBeat.o(9043);
        }
      }
      else {
        ((DownloadMainUI)((TaskListView)localObject).getContext()).kb(false);
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