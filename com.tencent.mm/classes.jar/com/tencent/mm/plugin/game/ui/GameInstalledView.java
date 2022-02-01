package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.z;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.d;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView
  extends LinearLayout
  implements View.OnClickListener
{
  private static Map<String, Integer> IRO;
  private static int IRQ;
  private static int IRR;
  private LinkedList<com.tencent.mm.pluginsdk.model.app.g> IFF;
  private int IFc;
  private k.a IPj;
  private LinearLayout IRK;
  private ImageView IRL;
  private TextView IRM;
  private TextView IRN;
  private final DisplayMetrics IRP;
  private int IRS;
  private int IRT;
  private int IRU;
  private a IRV;
  private LinkedList<com.tencent.mm.plugin.game.model.c> IRW;
  LinearLayout.LayoutParams IRX;
  private int count;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(42192);
    IRO = new HashMap();
    IRQ = 6;
    IRR = 7;
    AppMethodBeat.o(42192);
  }
  
  public GameInstalledView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42186);
    this.IFF = new LinkedList();
    this.IRP = new DisplayMetrics();
    this.IRS = 4;
    this.count = 0;
    this.IFc = 0;
    this.IRT = 1;
    this.IRU = 999;
    this.IRX = new LinearLayout.LayoutParams(-1, -2);
    this.IPj = new k.a()
    {
      public final void f(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(42185);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(42185);
          return;
          AppMethodBeat.o(42185);
          return;
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCf().init(GameInstalledView.d(GameInstalledView.this));
          GameInstalledView.this.refresh(false);
        }
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(42186);
  }
  
  private void fHv()
  {
    AppMethodBeat.i(42189);
    if (Util.isNullOrNil(this.IFF))
    {
      setVisibility(8);
      AppMethodBeat.o(42189);
      return;
    }
    setVisibility(0);
    this.IRK.removeAllViews();
    this.count = 0;
    Object localObject1 = (LayoutInflater)getContext().getSystemService("layout_inflater");
    int j;
    int i;
    int k;
    Object localObject2;
    label274:
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (this.IFF.size() >= this.IRS - 1)
    {
      IRR = 7;
      IRQ = 6;
      j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (IRQ << 1) + 84);
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.IRP);
      i = (int)(this.IRP.widthPixels * 160 / this.IRP.densityDpi);
      this.IRS = ((this.IRP.widthPixels - 1) / j + 1);
      if (this.IRS == 3) {
        IRR = 3;
      }
      j = (IRQ << 1) + 84;
      k = IRQ + 6 + IRR;
      i = (i - 16) % j;
      if (i < k)
      {
        IRQ -= 2;
        BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (IRQ << 1) + 84);
      }
    }
    else
    {
      this.IRX.setMargins(BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, IRQ), 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, IRQ), 0);
      localObject2 = this.IFF.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label704;
      }
      localObject3 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject2).next();
      localObject4 = ((LayoutInflater)localObject1).inflate(h.f.Iaw, null);
      this.IRL = ((ImageView)((View)localObject4).findViewById(h.e.HVB));
      this.IRM = ((TextView)((View)localObject4).findViewById(h.e.HWm));
      this.IRN = ((TextView)((View)localObject4).findViewById(h.e.HWx));
      localObject5 = com.tencent.mm.pluginsdk.model.app.h.c(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId, 1, com.tencent.mm.cd.a.getDensity(this.mContext));
      if (localObject5 == null) {
        break label586;
      }
      this.IRL.setImageBitmap((Bitmap)localObject5);
      label384:
      this.IRM.setText(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3, null));
      if (!com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3)) {
        break label671;
      }
      i = com.tencent.mm.plugin.game.d.c.aHj(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_packageName);
      if ((!IRO.containsKey(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)) || (((Integer)IRO.get(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)).intValue() <= i)) {
        break label612;
      }
      localObject5 = f.duv().amO(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId);
      this.IRN.setTextColor(this.mContext.getResources().getColor(h.b.HSR));
      if (((FileDownloadTaskInfo)localObject5).status != 1) {
        break label599;
      }
      this.IRN.setText(h.i.IaD);
    }
    label671:
    for (;;)
    {
      ((View)localObject4).setTag(localObject3);
      ((View)localObject4).setOnClickListener(this);
      this.IRK.addView((View)localObject4, this.IRX);
      break label274;
      if (i <= j - k) {
        break;
      }
      IRQ = (i - (j >> 1)) / this.IRS + IRQ;
      BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (IRQ << 1) + 84);
      break;
      label586:
      this.IRL.setImageResource(h.d.app_panel_unknowed_icon);
      break label384;
      label599:
      this.IRN.setText(h.i.IaC);
      continue;
      label612:
      if (!Util.isNullOrNil(((z)localObject3).jOu))
      {
        this.IRN.setText(((z)localObject3).jOu);
        this.IRN.setTextColor(this.mContext.getResources().getColor(h.b.HSU));
      }
      else
      {
        this.IRN.setText("");
        continue;
        this.IRN.setTextColor(this.mContext.getResources().getColor(h.b.HSR));
        this.IRN.setText(h.i.Ibh);
      }
    }
    label704:
    if ((this.IRV != null) && (this.IRV.iconUrl != null) && (this.IRV.title != null))
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(h.f.Iaw, null);
      this.IRL = ((ImageView)((View)localObject1).findViewById(h.e.HVB));
      this.IRM = ((TextView)((View)localObject1).findViewById(h.e.HWm));
      this.IRN = ((TextView)((View)localObject1).findViewById(h.e.HWx));
      localObject2 = r.bKe();
      localObject3 = this.IRV.iconUrl;
      localObject4 = this.IRL;
      localObject5 = new c.a();
      ((c.a)localObject5).oKo = true;
      ((com.tencent.mm.modelimage.loader.a)localObject2).a((String)localObject3, (ImageView)localObject4, ((c.a)localObject5).bKx(), new com.tencent.mm.modelimage.loader.b.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          AppMethodBeat.i(42184);
          if (paramAnonymousb.status == 0) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42183);
                if (GameInstalledView.a(GameInstalledView.this) == 0)
                {
                  GameInstalledView.b(GameInstalledView.this);
                  GameInstalledView.c(GameInstalledView.this).addView(GameInstalledView.1.this.val$view, GameInstalledView.this.IRX);
                }
                AppMethodBeat.o(42183);
              }
            });
          }
          AppMethodBeat.o(42184);
        }
        
        public final void c(String paramAnonymousString, View paramAnonymousView) {}
      });
      this.IRM.setText(this.IRV.title);
      this.IRN.setVisibility(8);
      ((View)localObject1).setTag(this.IRV);
      ((View)localObject1).setOnClickListener(this);
    }
    AppMethodBeat.o(42189);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42191);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (paramView.getTag() == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42191);
      return;
    }
    if ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.model.app.g))
    {
      paramView = (com.tencent.mm.pluginsdk.model.app.g)paramView.getTag();
      if ((paramView == null) || (Util.isNullOrNil(paramView.field_appId)))
      {
        Log.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42191);
        return;
      }
      if (com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView))
      {
        i = com.tencent.mm.plugin.game.d.c.aHj(paramView.field_packageName);
        if ((IRO.containsKey(paramView.field_appId)) && (((Integer)IRO.get(paramView.field_appId)).intValue() > i))
        {
          localObject = f.duv().amO(paramView.field_appId);
          if (((FileDownloadTaskInfo)localObject).status == 1) {
            f.duv().kR(((FileDownloadTaskInfo)localObject).id);
          }
        }
        for (;;)
        {
          refresh(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42191);
          return;
          if (((FileDownloadTaskInfo)localObject).status == 3)
          {
            if ((y.ZC(((FileDownloadTaskInfo)localObject).path)) && (com.tencent.mm.plugin.game.d.c.aHl(((FileDownloadTaskInfo)localObject).path) > i)) {
              v.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
            } else {
              f.duv().kR(((FileDownloadTaskInfo)localObject).id);
            }
          }
          else
          {
            k.y(paramView.jOq, paramView.jOv, paramView.field_appId, "");
            localObject = new g.a();
            ((g.a)localObject).amR(paramView.jOq);
            ((g.a)localObject).amT(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView, null));
            ((g.a)localObject).setAppId(paramView.field_appId);
            ((g.a)localObject).setFileMD5(paramView.jOv);
            ((g.a)localObject).nA(true);
            ((g.a)localObject).JA(1);
            f.duv().a(((g.a)localObject).xoe);
            continue;
            com.tencent.mm.plugin.game.model.e.au(this.mContext, paramView.field_appId);
            com.tencent.mm.game.report.g.a(this.mContext, 10, 1002, this.IRT, 3, 0, paramView.field_appId, this.IFc, 0, null, null, null);
            this.IFF.remove(paramView);
            this.IFF.addFirst(paramView);
          }
        }
      }
      localObject = f.duv().amO(paramView.field_appId);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3))
      {
        if ((!Util.isNullOrNil(((FileDownloadTaskInfo)localObject).path)) && (y.ZC(((FileDownloadTaskInfo)localObject).path))) {
          v.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42191);
          return;
          Log.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[] { ((FileDownloadTaskInfo)localObject).path });
          f.duv().kR(((FileDownloadTaskInfo)localObject).id);
          refresh(false);
        }
      }
      Log.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", new Object[] { paramView.field_appName });
      refresh(false);
    }
    while (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42191);
      return;
    }
    localObject = (a)paramView.getTag();
    paramView = new Intent();
    if (Util.isNullOrNil(((a)localObject).rDm))
    {
      paramView.setClass(this.mContext, GameLibraryUI.class);
      paramView.putExtra("game_report_from_scene", 1002);
      localObject = this.mContext;
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aYi(), "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (int i = 6;; i = com.tencent.mm.plugin.game.d.c.I(this.mContext, ((a)localObject).rDm, "game_center_installed_more"))
    {
      com.tencent.mm.game.report.g.a(this.mContext, 10, 1002, this.IRU, i, 0, null, this.IFc, 0, null, null, null);
      break;
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42187);
    super.onFinishInflate();
    this.IRK = ((LinearLayout)findViewById(h.e.HVG));
    k.a(this.IPj);
    AppMethodBeat.o(42187);
  }
  
  public final void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(42188);
    if (Util.isNullOrNil(this.IRW))
    {
      setVisibility(8);
      AppMethodBeat.o(42188);
      return;
    }
    setVisibility(0);
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      this.IFF = com.tencent.mm.plugin.game.model.e.fFT();
      if ((!Util.isNullOrNil(this.IRW)) && (!Util.isNullOrNil(this.IFF)))
      {
        localObject1 = this.IRW.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.model.c)((Iterator)localObject1).next();
          if (this.IFF.contains(localObject2))
          {
            this.IFF.remove(localObject2);
            this.IFF.addFirst(localObject2);
          }
        }
      }
    }
    else
    {
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).addAll(this.IFF);
      Object localObject3 = new LinkedList();
      ((LinkedList)localObject3).addAll(com.tencent.mm.plugin.game.model.e.fFT());
      localObject2 = new LinkedList();
      Object localObject4 = ((LinkedList)localObject1).iterator();
      com.tencent.mm.pluginsdk.model.app.g localg;
      while (((Iterator)localObject4).hasNext())
      {
        localg = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject4).next();
        if ((!((LinkedList)localObject3).contains(localg)) && (!((LinkedList)localObject2).contains(localg))) {
          ((LinkedList)localObject2).add(localg);
        }
      }
      localObject4 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localg = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject4).next();
        if (((LinkedList)localObject3).contains(localg)) {
          ((LinkedList)localObject3).remove(localg);
        } else if (!com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, localg)) {
          ((LinkedList)localObject2).add(localg);
        }
      }
      if (((LinkedList)localObject3).size() > 0)
      {
        localObject3 = ((LinkedList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject3).next();
          if (!((LinkedList)localObject1).contains(localObject4)) {
            ((LinkedList)localObject1).addFirst(localObject4);
          }
        }
      }
      if (((LinkedList)localObject2).size() > 0) {
        ((LinkedList)localObject1).removeAll((Collection)localObject2);
      }
      localObject2 = new LinkedList();
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((LinkedList)localObject2).add(com.tencent.mm.pluginsdk.model.app.h.s(((com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject1).next()).field_appId, true, false));
      }
      this.IFF = ((LinkedList)localObject2);
    }
    fHv();
    AppMethodBeat.o(42188);
  }
  
  public void setInstalledGameInfo(LinkedList<com.tencent.mm.plugin.game.model.c> paramLinkedList)
  {
    this.IRW = paramLinkedList;
  }
  
  public void setMoreGameInfo(a parama)
  {
    this.IRV = parama;
  }
  
  public void setSourceScene(int paramInt)
  {
    this.IFc = paramInt;
  }
  
  public void setVersionCodes(Map<String, Integer> paramMap)
  {
    AppMethodBeat.i(42190);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(42190);
      return;
    }
    IRO = paramMap;
    AppMethodBeat.o(42190);
  }
  
  public static class a
  {
    public String iconUrl = "";
    public String rDm = "";
    public String title = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInstalledView
 * JD-Core Version:    0.7.0.1
 */