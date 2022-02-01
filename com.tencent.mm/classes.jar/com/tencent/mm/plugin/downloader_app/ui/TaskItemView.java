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
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.plugin.downloader_app.e.a;
import com.tencent.mm.plugin.downloader_app.e.b;
import com.tencent.mm.plugin.downloader_app.e.c;
import com.tencent.mm.plugin.downloader_app.e.d;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.plugin.downloader_app.e.g;
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.vfs.y;
import java.util.Iterator;

public class TaskItemView
  extends LinearLayout
{
  public TextView xsY;
  public TextView xsZ;
  ImageView xtH;
  public TextView xta;
  public TextView xtb;
  public ImageView xtc;
  private ImageView xuA;
  private TextView xuB;
  public View xuC;
  boolean xuD = false;
  private a xuE;
  i xuf;
  private AppIconView xup;
  private TextView xuq;
  private TextView xur;
  private TextView xus;
  private FrameLayout xut;
  private ProgressImageView xuu;
  private FrameLayout xuv;
  private Button xuw;
  private Button xux;
  private DownloadUpdateDescView xuy;
  private LinearLayout xuz;
  
  public TaskItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private long getFileSize()
  {
    AppMethodBeat.i(9048);
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.amJ(this.xuf.appId);
    if ((locala != null) && (locala.field_fileSize > 0L))
    {
      l = locala.field_fileSize;
      AppMethodBeat.o(9048);
      return l;
    }
    long l = this.xuf.xsG.xls;
    AppMethodBeat.o(9048);
    return l;
  }
  
  private void setButtonText(int paramInt)
  {
    AppMethodBeat.i(183831);
    if (paramInt == e.h.xrp)
    {
      this.xuw.setVisibility(8);
      this.xux.setVisibility(0);
    }
    for (;;)
    {
      this.xuv.setVisibility(0);
      AppMethodBeat.o(183831);
      return;
      this.xux.setVisibility(8);
      this.xuw.setVisibility(0);
      this.xuw.setText(paramInt);
    }
  }
  
  private void setTaskSize(long paramLong)
  {
    AppMethodBeat.i(9046);
    v(paramLong, false);
    AppMethodBeat.o(9046);
  }
  
  private void v(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(184795);
    long l = getFileSize();
    float f2 = (float)l / 1.073742E+009F;
    float f1 = (float)l / 1048576.0F;
    if (paramLong >= l)
    {
      if (f2 >= 1.0F)
      {
        this.xus.setText(String.format("%.1fGB", new Object[] { Float.valueOf(f2) }));
        AppMethodBeat.o(184795);
        return;
      }
      this.xus.setText(String.format("%.1fMB", new Object[] { Float.valueOf(f1) }));
      AppMethodBeat.o(184795);
      return;
    }
    f2 = (float)paramLong / 1048576.0F;
    this.xus.setText(String.format("%.1fMB / %.1fMB", new Object[] { Float.valueOf(f2), Float.valueOf(f1) }));
    if (paramBoolean)
    {
      int i = (int)(100L * paramLong / l);
      this.xuu.setProgress(i);
    }
    AppMethodBeat.o(184795);
  }
  
  final void dvo()
  {
    boolean bool = false;
    AppMethodBeat.i(9045);
    Log.d("MicroMsg.TaskItemView", "updateDownloadStatus: %s", new Object[] { this.xuf.appId });
    this.xuv.setVisibility(8);
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.amJ(this.xuf.appId);
    if ((locala == null) || (locala.field_status == 5))
    {
      setTaskSize(getFileSize());
      this.xut.setVisibility(8);
      setButtonText(e.h.xqZ);
      AppMethodBeat.o(9045);
      return;
    }
    if (locala.field_status == 3)
    {
      this.xut.setVisibility(8);
      setButtonText(e.h.xrp);
    }
    for (;;)
    {
      v(locala.field_downloadedSize, bool);
      AppMethodBeat.o(9045);
      return;
      if (locala.field_status == 6)
      {
        this.xut.setVisibility(8);
        if (e.le(locala.field_downloadId)) {
          setButtonText(e.h.xrs);
        } else {
          setButtonText(e.h.xrp);
        }
      }
      else
      {
        this.xut.setVisibility(0);
        if (this.xuD)
        {
          this.xuu.dvm();
        }
        else if (locala.field_status == 1)
        {
          this.xuD = false;
          this.xuu.setProgressColor(e.b.Brand);
          this.xuu.setImageResource(e.g.downloading);
          bool = true;
        }
        else if ((locala.field_reserveInWifi) && (!NetStatusUtil.isWifi(getContext())))
        {
          this.xut.setVisibility(0);
          this.xuu.setProgressColor(e.b.FG_1);
          this.xuu.dvn();
        }
        else if (locala.field_status == 4)
        {
          this.xut.setVisibility(8);
          setButtonText(e.h.xrf);
        }
        else
        {
          this.xuu.setProgressColor(e.b.FG_1);
          this.xuu.setImageResource("download_app_pause");
          bool = true;
        }
      }
    }
  }
  
  public int getIconPaddingLeft()
  {
    AppMethodBeat.i(269762);
    if (this.xtH.getVisibility() == 0)
    {
      i = getResources().getDimensionPixelSize(e.c.Edge_A);
      int j = getResources().getDimensionPixelSize(e.c.xpL);
      AppMethodBeat.o(269762);
      return i * 2 + j;
    }
    int i = getResources().getDimensionPixelSize(e.c.Edge_A);
    AppMethodBeat.o(269762);
    return i * 2;
  }
  
  public int getNamePaddingLeft()
  {
    AppMethodBeat.i(9047);
    if (this.xtH.getVisibility() == 0)
    {
      i = getResources().getDimensionPixelSize(e.c.xpM);
      AppMethodBeat.o(9047);
      return i;
    }
    int i = getResources().getDimensionPixelSize(e.c.xpK);
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
    this.xtH = ((ImageView)findViewById(e.e.xpY));
    this.xup = ((AppIconView)findViewById(e.e.icon));
    this.xuq = ((TextView)findViewById(e.e.item_name));
    this.xur = ((TextView)findViewById(e.e.xqs));
    this.xus = ((TextView)findViewById(e.e.fLI));
    this.xut = ((FrameLayout)findViewById(e.e.xqx));
    this.xuu = ((ProgressImageView)findViewById(e.e.xqE));
    this.xuu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((TaskItemView.a(TaskItemView.this) != null) && (TaskItemView.a(TaskItemView.this).dvk()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9028);
          return;
        }
        paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.amJ(TaskItemView.b(TaskItemView.this).appId);
        if (paramAnonymousView.field_status == 1) {
          com.tencent.mm.plugin.downloader_app.a.c.b(TaskItemView.this.getContext(), TaskItemView.b(TaskItemView.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9028);
          return;
          if (TaskItemView.c(TaskItemView.this).xuj) {
            com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), paramAnonymousView.field_downloadId, new a.b()
            {
              public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
              {
                AppMethodBeat.i(183827);
                if (paramAnonymous2a != a.a.xrO) {
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
                if (paramAnonymous2a == a.a.xrO) {
                  TaskItemView.d(TaskItemView.this);
                }
                AppMethodBeat.o(184794);
              }
            });
          }
        }
      }
    });
    this.xuv = ((FrameLayout)findViewById(e.e.xpX));
    this.xuw = ((Button)findViewById(e.e.xqu));
    this.xuw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9031);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((TaskItemView.a(TaskItemView.this) != null) && (TaskItemView.a(TaskItemView.this).dvk()))
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
          paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.amJ(TaskItemView.b(TaskItemView.this).appId);
          if (paramAnonymousView != null)
          {
            if (TaskItemView.e(TaskItemView.this).getText().equals(TaskItemView.this.getResources().getString(e.h.xrs))) {
              if (y.ZC(paramAnonymousView.field_filePath)) {
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
    this.xux = ((Button)findViewById(e.e.xqq));
    this.xux.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((TaskItemView.a(TaskItemView.this) != null) && (TaskItemView.a(TaskItemView.this).dvk()))
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
    this.xuy = ((DownloadUpdateDescView)findViewById(e.e.xqF));
    this.xuz = ((LinearLayout)findViewById(e.e.xqd));
    this.xuA = ((ImageView)findViewById(e.e.xqf));
    this.xuB = ((TextView)findViewById(e.e.xqe));
    this.xuz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183828);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((TaskItemView.b(TaskItemView.this) != null) && (TaskItemView.b(TaskItemView.this).xsI != null) && (!Util.isNullOrNil(TaskItemView.b(TaskItemView.this).xsI.xlq)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("rawUrl", TaskItemView.b(TaskItemView.this).xsI.xlq);
          ((com.tencent.mm.plugin.downloader_app.api.c)h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).f(TaskItemView.this.getContext(), paramAnonymousView);
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, TaskItemView.b(TaskItemView.this).position, 40, TaskItemView.b(TaskItemView.this).appId, "", "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183828);
      }
    });
    this.xuC = findViewById(e.e.xqm);
    this.xsY = ((TextView)findViewById(e.e.xqn));
    this.xsZ = ((TextView)findViewById(e.e.xqo));
    this.xta = ((TextView)findViewById(e.e.xqv));
    this.xtb = ((TextView)findViewById(e.e.xqw));
    this.xtc = ((ImageView)findViewById(e.e.xpQ));
    if (aw.isDarkMode())
    {
      this.xtc.setImageResource(e.d.xpR);
      AppMethodBeat.o(9040);
      return;
    }
    this.xtc.setImageResource(e.d.xpQ);
    AppMethodBeat.o(9040);
  }
  
  public void setData(i parami)
  {
    AppMethodBeat.i(9044);
    this.xuf = parami;
    if (parami == null)
    {
      setVisibility(8);
      AppMethodBeat.o(9044);
      return;
    }
    setVisibility(0);
    this.xut.setVisibility(8);
    this.xuv.setVisibility(8);
    this.xuy.setVisibility(8);
    this.xuz.setVisibility(8);
    new c.a().oKp = true;
    com.tencent.mm.modelimage.r.bKe().loadImage(this.xuf.iconUrl, this.xup);
    this.xuq.setText(this.xuf.appName);
    parami = com.tencent.mm.plugin.downloader.model.d.amJ(this.xuf.appId);
    if ((parami != null) && (parami.field_autoDownload)) {
      this.xur.setVisibility(0);
    }
    while (this.xuf.wsK)
    {
      if (this.xtH.getVisibility() != 0)
      {
        this.xtH.setVisibility(0);
        this.xtH.startAnimation(AnimationUtils.loadAnimation(getContext(), e.a.xpz));
      }
      setSelected(this.xuf.isSelected);
      setTaskSize(getFileSize());
      this.xuC.setVisibility(8);
      AppMethodBeat.o(9044);
      return;
      this.xur.setVisibility(8);
    }
    this.xtH.setVisibility(8);
    if (this.xuf.xsI != null)
    {
      parami = (LinearLayout.LayoutParams)this.xuz.getLayoutParams();
      if (this.xuf.wsK)
      {
        parami.leftMargin = getResources().getDimensionPixelSize(e.c.xpM);
        this.xuz.setLayoutParams(parami);
        this.xuz.setVisibility(0);
        new c.a().oKp = true;
        com.tencent.mm.modelimage.r.bKe().loadImage(this.xuf.xsI.icon, this.xuA);
        if (this.xuf.xsI.xlo != null) {
          this.xuB.setText(this.xuf.xsI.xlo.value);
        }
        if (!this.xuf.xsD)
        {
          this.xuf.xsD = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, this.xuf.position, 1, this.xuf.appId, "", "");
        }
        label414:
        setTaskSize(getFileSize());
        this.xuy.setVisibility(8);
        if (this.xuf.type != 4) {
          break label561;
        }
        parami = com.tencent.mm.plugin.downloader.model.d.amJ(this.xuf.appId);
        if ((parami != null) && (parami.field_status != 0) && (parami.field_status != 5)) {
          break label554;
        }
        this.xut.setVisibility(8);
        setButtonText(e.h.xrH);
        this.xuy.setData(this.xuf);
      }
    }
    for (;;)
    {
      if (this.xuf.xsG != null) {
        break label599;
      }
      this.xuC.setVisibility(8);
      AppMethodBeat.o(9044);
      return;
      parami.leftMargin = getResources().getDimensionPixelSize(e.c.xpK);
      break;
      this.xuz.setVisibility(8);
      break label414;
      label554:
      dvo();
      continue;
      label561:
      if (this.xuf.type == 6)
      {
        this.xut.setVisibility(8);
        setButtonText(e.h.xrr);
      }
      else
      {
        dvo();
      }
    }
    label599:
    this.xuC.setVisibility(0);
    this.xsY.setText(this.xuf.xsG.xlI);
    this.xsZ.setText(this.xuf.appName + " " + this.xuf.xsG.xlC);
    this.xta.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9035);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("rawUrl", TaskItemView.b(TaskItemView.this).xsG.xlG);
        ((com.tencent.mm.plugin.downloader_app.api.c)h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).f(TaskItemView.this.getContext(), paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(9035);
      }
    });
    this.xtb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("rawUrl", TaskItemView.b(TaskItemView.this).xsG.xlH);
        ((com.tencent.mm.plugin.downloader_app.api.c)h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).f(TaskItemView.this.getContext(), paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(9036);
      }
    });
    AppMethodBeat.o(9044);
  }
  
  public void setOnItemOpButtonClickListener(a parama)
  {
    this.xuE = parama;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(9043);
    Log.d("MicroMsg.TaskItemView", "setSelected selected: %b, appid: %s", new Object[] { Boolean.valueOf(paramBoolean), this.xuf.appId });
    this.xuf.isSelected = paramBoolean;
    if (paramBoolean) {
      com.tencent.mm.plugin.downloader_app.b.i(this.xtH, "checkbox_cell_on");
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
      Iterator localIterator = ((TaskListView)localObject).xuP.xuH.iterator();
      paramBoolean = false;
      i = 1;
      for (;;)
      {
        label94:
        if (!localIterator.hasNext()) {
          break label155;
        }
        i locali = (i)localIterator.next();
        if (!locali.dva()) {
          break label226;
        }
        if (!locali.isSelected) {
          break;
        }
        paramBoolean = true;
      }
      com.tencent.mm.plugin.downloader_app.b.i(this.xtH, "checkbox_cell_off");
    }
    int i = 0;
    label155:
    label209:
    label219:
    label226:
    for (;;)
    {
      break label94;
      com.tencent.mm.plugin.downloader_app.a.d.nG(paramBoolean);
      if (i != 0)
      {
        if ((((TaskListView)localObject).getContext() instanceof DownloadMainUI))
        {
          ((DownloadMainUI)((TaskListView)localObject).getContext()).nL(true);
          AppMethodBeat.o(9043);
        }
      }
      else {
        ((DownloadMainUI)((TaskListView)localObject).getContext()).nL(false);
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
    public abstract boolean dvk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView
 * JD-Core Version:    0.7.0.1
 */