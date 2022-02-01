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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.y;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView
  extends LinearLayout
  implements View.OnClickListener
{
  private static Map<String, Integer> trw;
  private static int jdField_try;
  private static int trz;
  private int count;
  private Context mContext;
  private int tfA;
  private LinkedList<com.tencent.mm.pluginsdk.model.app.g> tge;
  private k.a toP;
  private int trA;
  private int trB;
  private int trC;
  private a trD;
  private LinkedList<com.tencent.mm.plugin.game.model.c> trE;
  LinearLayout.LayoutParams trF;
  private LinearLayout trs;
  private ImageView trt;
  private TextView tru;
  private TextView trv;
  private final DisplayMetrics trx;
  
  static
  {
    AppMethodBeat.i(42192);
    trw = new HashMap();
    jdField_try = 6;
    trz = 7;
    AppMethodBeat.o(42192);
  }
  
  public GameInstalledView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42186);
    this.tge = new LinkedList();
    this.trx = new DisplayMetrics();
    this.trA = 4;
    this.count = 0;
    this.tfA = 0;
    this.trB = 1;
    this.trC = 999;
    this.trF = new LinearLayout.LayoutParams(-1, -2);
    this.toP = new k.a()
    {
      public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
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
          ((d)com.tencent.mm.kernel.g.ab(d.class)).cOk().init(GameInstalledView.d(GameInstalledView.this));
          GameInstalledView.this.refresh(false);
        }
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(42186);
  }
  
  private void cRu()
  {
    AppMethodBeat.i(42189);
    if (bs.gY(this.tge))
    {
      setVisibility(8);
      AppMethodBeat.o(42189);
      return;
    }
    setVisibility(0);
    this.trs.removeAllViews();
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
    if (this.tge.size() >= this.trA - 1)
    {
      trz = 7;
      jdField_try = 6;
      j = BackwardSupportUtil.b.g(this.mContext, (jdField_try << 1) + 84);
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.trx);
      i = (int)(this.trx.widthPixels * 160 / this.trx.densityDpi);
      this.trA = ((this.trx.widthPixels - 1) / j + 1);
      if (this.trA == 3) {
        trz = 3;
      }
      j = (jdField_try << 1) + 84;
      k = jdField_try + 6 + trz;
      i = (i - 16) % j;
      if (i < k)
      {
        jdField_try -= 2;
        BackwardSupportUtil.b.g(this.mContext, (jdField_try << 1) + 84);
      }
    }
    else
    {
      this.trF.setMargins(BackwardSupportUtil.b.g(this.mContext, jdField_try), 0, BackwardSupportUtil.b.g(this.mContext, jdField_try), 0);
      localObject2 = this.tge.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label700;
      }
      localObject3 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject2).next();
      localObject4 = ((LayoutInflater)localObject1).inflate(2131494485, null);
      this.trt = ((ImageView)((View)localObject4).findViewById(2131300462));
      this.tru = ((TextView)((View)localObject4).findViewById(2131300524));
      this.trv = ((TextView)((View)localObject4).findViewById(2131300548));
      localObject5 = com.tencent.mm.pluginsdk.model.app.h.c(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId, 1, com.tencent.mm.cc.a.getDensity(this.mContext));
      if (localObject5 == null) {
        break label582;
      }
      this.trt.setImageBitmap((Bitmap)localObject5);
      label380:
      this.tru.setText(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3, null));
      if (!com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3)) {
        break label667;
      }
      i = com.tencent.mm.plugin.game.f.c.ahP(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_packageName);
      if ((!trw.containsKey(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)) || (((Integer)trw.get(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)).intValue() <= i)) {
        break label608;
      }
      localObject5 = f.bXJ().WB(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId);
      this.trv.setTextColor(this.mContext.getResources().getColor(2131100436));
      if (((FileDownloadTaskInfo)localObject5).status != 1) {
        break label595;
      }
      this.trv.setText(2131759832);
    }
    label667:
    for (;;)
    {
      ((View)localObject4).setTag(localObject3);
      ((View)localObject4).setOnClickListener(this);
      this.trs.addView((View)localObject4, this.trF);
      break label274;
      if (i <= j - k) {
        break;
      }
      jdField_try = (i - (j >> 1)) / this.trA + jdField_try;
      BackwardSupportUtil.b.g(this.mContext, (jdField_try << 1) + 84);
      break;
      label582:
      this.trt.setImageResource(2131231052);
      break label380;
      label595:
      this.trv.setText(2131759831);
      continue;
      label608:
      if (!bs.isNullOrNil(((y)localObject3).eqo))
      {
        this.trv.setText(((y)localObject3).eqo);
        this.trv.setTextColor(this.mContext.getResources().getColor(2131100453));
      }
      else
      {
        this.trv.setText("");
        continue;
        this.trv.setTextColor(this.mContext.getResources().getColor(2131100436));
        this.trv.setText(2131759906);
      }
    }
    label700:
    if ((this.trD != null) && (this.trD.iconUrl != null) && (this.trD.title != null))
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(2131494485, null);
      this.trt = ((ImageView)((View)localObject1).findViewById(2131300462));
      this.tru = ((TextView)((View)localObject1).findViewById(2131300524));
      this.trv = ((TextView)((View)localObject1).findViewById(2131300548));
      localObject2 = o.aFB();
      localObject3 = this.trD.iconUrl;
      localObject4 = this.trt;
      localObject5 = new c.a();
      ((c.a)localObject5).hKw = true;
      ((com.tencent.mm.av.a.a)localObject2).a((String)localObject3, (ImageView)localObject4, ((c.a)localObject5).aFT(), new com.tencent.mm.av.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(42184);
          if (paramAnonymousb.status == 0) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42183);
                if (GameInstalledView.a(GameInstalledView.this) == 0)
                {
                  GameInstalledView.b(GameInstalledView.this);
                  GameInstalledView.c(GameInstalledView.this).addView(GameInstalledView.1.this.val$view, GameInstalledView.this.trF);
                }
                AppMethodBeat.o(42183);
              }
            });
          }
          AppMethodBeat.o(42184);
        }
      });
      this.tru.setText(this.trD.title);
      this.trv.setVisibility(8);
      ((View)localObject1).setTag(this.trD);
      ((View)localObject1).setOnClickListener(this);
    }
    AppMethodBeat.o(42189);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42191);
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(42191);
      return;
    }
    Object localObject;
    if ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.model.app.g))
    {
      paramView = (com.tencent.mm.pluginsdk.model.app.g)paramView.getTag();
      if ((paramView == null) || (bs.isNullOrNil(paramView.field_appId)))
      {
        ac.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
        AppMethodBeat.o(42191);
        return;
      }
      if (com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView))
      {
        i = com.tencent.mm.plugin.game.f.c.ahP(paramView.field_packageName);
        if ((trw.containsKey(paramView.field_appId)) && (((Integer)trw.get(paramView.field_appId)).intValue() > i))
        {
          localObject = f.bXJ().WB(paramView.field_appId);
          if (((FileDownloadTaskInfo)localObject).status == 1) {
            f.bXJ().rS(((FileDownloadTaskInfo)localObject).id);
          }
        }
        for (;;)
        {
          refresh(false);
          AppMethodBeat.o(42191);
          return;
          if (((FileDownloadTaskInfo)localObject).status == 3)
          {
            if ((i.eA(((FileDownloadTaskInfo)localObject).path)) && (com.tencent.mm.plugin.game.f.c.ahQ(((FileDownloadTaskInfo)localObject).path) > i)) {
              r.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
            } else {
              f.bXJ().rS(((FileDownloadTaskInfo)localObject).id);
            }
          }
          else
          {
            k.o(paramView.eqk, paramView.eqp, paramView.field_appId, "");
            localObject = new g.a();
            ((g.a)localObject).WD(paramView.eqk);
            ((g.a)localObject).WF(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView, null));
            ((g.a)localObject).setAppId(paramView.field_appId);
            ((g.a)localObject).WG(paramView.eqp);
            ((g.a)localObject).jF(true);
            ((g.a)localObject).AG(1);
            f.bXJ().a(((g.a)localObject).oJg);
            continue;
            com.tencent.mm.plugin.game.model.e.aj(this.mContext, paramView.field_appId);
            com.tencent.mm.game.report.e.a(this.mContext, 10, 1002, this.trB, 3, 0, paramView.field_appId, this.tfA, 0, null, null, null);
            this.tge.remove(paramView);
            this.tge.addFirst(paramView);
          }
        }
      }
      localObject = f.bXJ().WB(paramView.field_appId);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3))
      {
        if ((!bs.isNullOrNil(((FileDownloadTaskInfo)localObject).path)) && (i.eA(((FileDownloadTaskInfo)localObject).path)))
        {
          r.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
          AppMethodBeat.o(42191);
          return;
        }
        ac.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[] { ((FileDownloadTaskInfo)localObject).path });
        f.bXJ().rS(((FileDownloadTaskInfo)localObject).id);
        refresh(false);
        AppMethodBeat.o(42191);
        return;
      }
      ac.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", new Object[] { paramView.field_appName });
      refresh(false);
      AppMethodBeat.o(42191);
      return;
    }
    if ((paramView.getTag() instanceof a))
    {
      localObject = (a)paramView.getTag();
      paramView = new Intent();
      if (!bs.isNullOrNil(((a)localObject).kbL)) {
        break label681;
      }
      paramView.setClass(this.mContext, GameLibraryUI.class);
      paramView.putExtra("game_report_from_scene", 1002);
      localObject = this.mContext;
      paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.aeD(), "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    label681:
    for (int i = 6;; i = com.tencent.mm.plugin.game.f.c.z(this.mContext, ((a)localObject).kbL, "game_center_installed_more"))
    {
      com.tencent.mm.game.report.e.a(this.mContext, 10, 1002, this.trC, i, 0, null, this.tfA, 0, null, null, null);
      AppMethodBeat.o(42191);
      return;
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42187);
    super.onFinishInflate();
    this.trs = ((LinearLayout)findViewById(2131300473));
    k.a(this.toP);
    AppMethodBeat.o(42187);
  }
  
  public final void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(42188);
    if (bs.gY(this.trE))
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
      this.tge = com.tencent.mm.plugin.game.model.e.cPU();
      if ((!bs.gY(this.trE)) && (!bs.gY(this.tge)))
      {
        localObject1 = this.trE.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.model.c)((Iterator)localObject1).next();
          if (this.tge.contains(localObject2))
          {
            this.tge.remove(localObject2);
            this.tge.addFirst(localObject2);
          }
        }
      }
    }
    else
    {
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).addAll(this.tge);
      Object localObject3 = new LinkedList();
      ((LinkedList)localObject3).addAll(com.tencent.mm.plugin.game.model.e.cPU());
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
        ((LinkedList)localObject2).add(com.tencent.mm.pluginsdk.model.app.h.k(((com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject1).next()).field_appId, true, false));
      }
      this.tge = ((LinkedList)localObject2);
    }
    cRu();
    AppMethodBeat.o(42188);
  }
  
  public void setInstalledGameInfo(LinkedList<com.tencent.mm.plugin.game.model.c> paramLinkedList)
  {
    this.trE = paramLinkedList;
  }
  
  public void setMoreGameInfo(a parama)
  {
    this.trD = parama;
  }
  
  public void setSourceScene(int paramInt)
  {
    this.tfA = paramInt;
  }
  
  public void setVersionCodes(Map<String, Integer> paramMap)
  {
    AppMethodBeat.i(42190);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(42190);
      return;
    }
    trw = paramMap;
    AppMethodBeat.o(42190);
  }
  
  public static final class a
  {
    public String iconUrl = "";
    public String kbL = "";
    public String title = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInstalledView
 * JD-Core Version:    0.7.0.1
 */