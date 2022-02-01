package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.czc;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dpe;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.protocal.protobuf.efl;
import com.tencent.mm.protocal.protobuf.eye;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.ps;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public final class i
  implements View.OnFocusChangeListener, com.tencent.mm.ak.i
{
  public View contentView;
  public boolean dDz;
  public ImageView gvv;
  public long mZq;
  public String query;
  private long wXS;
  public long xaI;
  private View xaW;
  private View xaX;
  public View xaY;
  private View xaZ;
  public int xat;
  public LinearLayout xba;
  public TextView xbb;
  private TextView xbc;
  private czf xbd;
  public long xbf;
  public MMHandler xeO;
  public View xeb;
  public TextView xec;
  public FTSMainUI xfV;
  private final int xfX;
  public View xfY;
  private int xfZ;
  public TextView xgA;
  public j xgB;
  public u xgC;
  public b xgD;
  public boolean xgE;
  public boolean xgF;
  private boolean xgG;
  private boolean xgH;
  private com.tencent.mm.plugin.websearch.api.t xgI;
  private long xgJ;
  private long xgK;
  private View.OnClickListener xgL;
  private View.OnClickListener xgM;
  private IListener<mx> xgN;
  private int xga;
  private int xgb;
  public View xgc;
  public TextView xgd;
  public TextView xge;
  public TextView xgf;
  public View xgg;
  public View xgh;
  public TextView xgi;
  public TextView xgj;
  public View xgk;
  public ImageView xgl;
  public TextView xgm;
  public TextView xgn;
  public TextView xgo;
  public TextView xgp;
  public View xgq;
  public ImageView xgr;
  public TextView xgs;
  public TextView xgt;
  public TextView xgu;
  public View xgv;
  public ImageView xgw;
  public ImageView xgx;
  public TextView xgy;
  public TextView xgz;
  
  public i(FTSMainUI paramFTSMainUI)
  {
    AppMethodBeat.i(112351);
    this.xfX = 3;
    this.xfZ = 0;
    this.xga = 0;
    this.xgb = 0;
    this.xgD = b.xgQ;
    this.xgE = false;
    this.xgF = false;
    this.dDz = false;
    this.xgG = false;
    this.xgH = false;
    this.xat = 1;
    this.xeO = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(112332);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(112332);
          return;
          if (paramAnonymousMessage.obj.equals(Long.valueOf(i.a(i.this))))
          {
            i.this.a(i.b.xgV);
            i.a(i.this, System.currentTimeMillis());
            Log.i("MicroMsg.FTS.PardusSearchLogic", "cancel Time %d", new Object[] { Long.valueOf(i.b(i.this) - i.c(i.this)) });
            l.N(i.a(i.this), 5);
            i.this.dOG();
            i.this.cHi();
          }
        }
      }
    };
    this.xgK = 60L;
    this.xgL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112336);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = (alv)paramAnonymousView.getTag();
        i.this.J(paramAnonymousView.Lux.MGp, 22, paramAnonymousView.Lux.MEq);
        i.d(i.this).xbX.xby = true;
        l.a(i.e(i.this), 1, 1, i.d(i.this).mve, i.d(i.this).xbX.xbD, 28, "", "", "");
        i.d(i.this).xbX.xbD.Nv(28);
        i.a(i.this, 0, "", "", "", paramAnonymousView.Lux.MEq, paramAnonymousView.xuA + 1, "");
        i.this.Nz(6);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112336);
      }
    };
    this.xgM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112343);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramAnonymousView = (sa)paramAnonymousView.getTag();
        switch (paramAnonymousView.oUv)
        {
        default: 
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112343);
          return;
        }
        int j = 2;
        if (!i.f(i.this)) {
          j = 1;
        }
        localObject1 = (czb)paramAnonymousView.KZF.getFirst();
        Object localObject2 = ((czb)localObject1).MEm;
        i.this.a((czc)localObject2);
        int i;
        if (paramAnonymousView.oUv == 512) {
          i = 7;
        }
        for (;;)
        {
          localObject2 = l.ayQ(((czb)localObject1).MEl.Title);
          l.a(i.e(i.this), j, 1, i.d(i.this).mve, i.d(i.this).xbX.xbD, 27, i + "$" + (String)localObject2, ((czb)localObject1).MEl.MEq, "");
          i.d(i.this).xbX.xbD.Nv(27);
          i.a(i.this, paramAnonymousView.oUv, ((czb)localObject1).MEl.MEq, (String)localObject2, "", "", 0, "");
          Log.i("MicroMsg.FTS.PardusSearchLogic", "click result %d %s %s", new Object[] { Integer.valueOf(i), localObject2, ((czb)localObject1).MEl.MEq });
          break;
          if (paramAnonymousView.oUv == 4194304) {
            i = 6;
          } else {
            i = 0;
          }
        }
      }
    };
    this.xgN = new i.4(this);
    this.xfV = paramFTSMainUI;
    this.xfZ = (com.tencent.mm.cb.a.jn(paramFTSMainUI.getContext()) - com.tencent.mm.cb.a.fromDPToPix(paramFTSMainUI.getContext(), 100));
    this.xga = (com.tencent.mm.cb.a.jn(paramFTSMainUI.getContext()) - com.tencent.mm.cb.a.fromDPToPix(paramFTSMainUI.getContext(), 116));
    this.xgb = (com.tencent.mm.cb.a.jn(paramFTSMainUI.getContext()) - com.tencent.mm.cb.a.fromDPToPix(paramFTSMainUI.getContext(), 48));
    dQb();
    AppMethodBeat.o(112351);
  }
  
  public static com.tencent.mm.ay.f a(String paramString1, TimeLineObject paramTimeLineObject, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(112368);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.LoV == null) || (paramTimeLineObject.ContentObj.LoV.size() <= 0))
    {
      AppMethodBeat.o(112368);
      return null;
    }
    cnb localcnb = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
    if (localcnb == null)
    {
      AppMethodBeat.o(112368);
      return null;
    }
    com.tencent.mm.ay.f localf = new com.tencent.mm.ay.f();
    localf.jeT = 9;
    localf.jeV = paramString2;
    localf.jeW = 0.0F;
    localf.jeZ = "";
    if (!TextUtils.isEmpty(localcnb.songAlbumUrl)) {
      localf.jfm = localcnb.songAlbumUrl;
    }
    localf.jfa = localcnb.Msz;
    localf.jff = null;
    localf.jeU = 1;
    localf.jfe = localcnb.songLyric;
    localf.jeX = localcnb.Title;
    localf.jeY = localcnb.Desc;
    paramString2 = localObject;
    if (paramTimeLineObject.ContentObj != null) {
      paramString2 = paramTimeLineObject.ContentObj.Url;
    }
    localf.jfd = paramString2;
    localf.jfc = localcnb.MsC;
    localf.jfb = localcnb.Url;
    localf.jfj = localcnb.MsA;
    localf.jfl = localcnb.Id;
    localf.jfg = paramString1;
    localf.jfi = paramTimeLineObject.AppInfo.Id;
    localf.jfp = paramTimeLineObject.UserName;
    localf.jfw = paramTimeLineObject.Id;
    AppMethodBeat.o(112368);
    return localf;
  }
  
  private void dQb()
  {
    AppMethodBeat.i(112355);
    if (System.currentTimeMillis() - this.xgJ > this.xgK * 1000L)
    {
      Log.i("MicroMsg.FTS.PardusSearchLogic", "start to request pre search");
      dQc();
      this.xgI = new com.tencent.mm.plugin.websearch.api.t(new cyz());
      g.azz().a(1417, this);
      g.azz().a(this.xgI, 0);
      this.xgJ = System.currentTimeMillis();
    }
    AppMethodBeat.o(112355);
  }
  
  @SuppressLint({"ResourceType"})
  private void dQe()
  {
    AppMethodBeat.i(176933);
    Object localObject1;
    int j;
    Object localObject2;
    int i;
    if ((this.xbd == null) || (this.xbd.MlS == null))
    {
      localObject1 = null;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label523;
      }
      this.xgF = true;
      this.xgc.setVisibility(0);
      j = ((efk)((List)localObject1).get(0)).MGp.length() + 0;
      localObject2 = new alv();
      ((alv)localObject2).Lux = ((efk)((List)localObject1).get(0));
      ((alv)localObject2).xuA = 0;
      this.xgd.setTag(localObject2);
      this.xgd.setText(((efk)((List)localObject1).get(0)).MGp);
      this.xgd.setOnClickListener(this.xgL);
      this.xgd.setVisibility(0);
      this.xfV.xbX.xbD.t(System.currentTimeMillis(), "PardusSug");
      if (((List)localObject1).size() <= 1) {
        break label485;
      }
      j += ((efk)((List)localObject1).get(1)).MGp.length();
      this.xge.setOnClickListener(this.xgL);
      localObject2 = new alv();
      ((alv)localObject2).Lux = ((efk)((List)localObject1).get(1));
      ((alv)localObject2).xuA = 1;
      this.xge.setTag(localObject2);
      this.xge.setText(((efk)((List)localObject1).get(1)).MGp);
      this.xge.setVisibility(0);
      i = 2;
      label286:
      if (((List)localObject1).size() <= 2) {
        break label511;
      }
      if (((efk)((List)localObject1).get(2)).MGp.length() + j > 24) {
        break label499;
      }
      this.xgf.setOnClickListener(this.xgL);
      localObject2 = new alv();
      ((alv)localObject2).Lux = ((efk)((List)localObject1).get(2));
      ((alv)localObject2).xuA = 2;
      this.xgf.setTag(localObject2);
      this.xgf.setText(((efk)((List)localObject1).get(2)).MGp);
      this.xgf.setVisibility(0);
      i += 1;
    }
    label523:
    for (;;)
    {
      label405:
      if (this.xgF)
      {
        localObject2 = "";
        j = 0;
        for (;;)
        {
          if (j < i)
          {
            localObject2 = (String)localObject2 + ((efk)((List)localObject1).get(j)).MEq + "_";
            j += 1;
            continue;
            localObject1 = this.xbd.MlS.KKx;
            break;
            label485:
            this.xge.setVisibility(8);
            i = 1;
            break label286;
            label499:
            this.xgf.setVisibility(8);
            break label405;
            label511:
            this.xgf.setVisibility(8);
            break label405;
            this.xgc.setVisibility(8);
            i = 0;
            break label405;
          }
        }
        e(0, "", "", (String)localObject2, "");
      }
    }
    int k = 2;
    if (!this.xgF) {
      k = 1;
    }
    if (this.xbd.MEu.size() > 0) {}
    for (sa localsa = (sa)this.xbd.MEu.getFirst();; localsa = null)
    {
      Object localObject4;
      String str2;
      Object localObject5;
      String str1;
      Object localObject3;
      if (localsa != null)
      {
        localObject4 = "";
        localObject2 = "";
        str2 = "";
        this.xgh.setTag(localsa);
        switch (localsa.oUv)
        {
        default: 
          localObject5 = "";
          localObject1 = "";
          str1 = "";
          localObject3 = "";
          switch (localsa.oUv)
          {
          default: 
            this.dDz = false;
            this.xgg.setVisibility(8);
            this.contentView.measure(-2147483648, 0);
            label785:
            this.xgh.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112338);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                i.this.dY(i.e(i.this), 21);
                sa localsa = (sa)paramAnonymousView.getTag();
                paramAnonymousView = "";
                localObject = "";
                String str1;
                String str2;
                switch (localsa.oUv)
                {
                default: 
                  str1 = "";
                  str2 = "";
                }
                for (;;)
                {
                  int i = 2;
                  if (!i.f(i.this)) {
                    i = 1;
                  }
                  l.a(i.e(i.this), i, 2, i.d(i.this).mve, i.d(i.this).xbX.xbD, 27, paramAnonymousView, (String)localObject, "");
                  i.d(i.this).xbX.xbD.Nv(27);
                  i.d(i.this).xbX.xby = true;
                  i.a(i.this, localsa.oUv, "more", str2, str1, "", 0, "");
                  i.this.Nz(5);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112338);
                  return;
                  localObject = (ps)localsa.KZz.getFirst();
                  str2 = l.ayQ(((ps)localObject).KWG.Title);
                  paramAnonymousView = "1$".concat(String.valueOf(str2));
                  localObject = ((ps)localObject).KWG.MEq;
                  str1 = "";
                  continue;
                  localObject = (eye)localsa.KZA.getFirst();
                  str2 = l.ayQ(((eye)localObject).KWG.Title);
                  paramAnonymousView = "2$".concat(String.valueOf(str2));
                  localObject = ((eye)localObject).KWG.MEq;
                  str1 = "";
                  continue;
                  localObject = (ahp)localsa.KZB.getFirst();
                  str1 = ((ahp)localObject).xIy;
                  str2 = l.ayQ(((ahp)localObject).KWG.Title);
                  paramAnonymousView = "4$".concat(String.valueOf(str2));
                  localObject = ((ahp)localObject).KWG.MEq;
                  continue;
                  localObject = (czb)localsa.KZF.getFirst();
                  str2 = l.ayQ(((czb)localObject).MEl.Title);
                  paramAnonymousView = "8$".concat(String.valueOf(str2));
                  localObject = ((czb)localObject).MEl.MEq;
                  str1 = "";
                  continue;
                  localObject = (czb)localsa.KZF.getFirst();
                  str2 = l.ayQ(((czb)localObject).MEl.Title);
                  paramAnonymousView = "7$".concat(String.valueOf(str2));
                  localObject = ((czb)localObject).MEl.MEq;
                  str1 = "";
                  continue;
                  localObject = (czb)localsa.KZF.getFirst();
                  str2 = l.ayQ(((czb)localObject).MEl.Title);
                  paramAnonymousView = "6$".concat(String.valueOf(str2));
                  localObject = ((czb)localObject).MEl.MEq;
                  str1 = "";
                }
              }
            });
            this.xeb.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112339);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
                if (!i.f(i.this)) {}
                for (int i = 1;; i = 2) {
                  try
                  {
                    paramAnonymousView = (sa)paramAnonymousView.getTag();
                    if (paramAnonymousView.oUv == 64)
                    {
                      localObject1 = (eye)paramAnonymousView.KZA.getFirst();
                      localObject2 = new wq();
                      ((wq)localObject2).ecI.userName = ((eye)localObject1).UserName;
                      ((wq)localObject2).ecI.scene = 1027;
                      ((wq)localObject2).ecI.dCw = "2";
                      EventCenter.instance.publish((IEvent)localObject2);
                      localObject2 = l.ayQ(((eye)localObject1).KWG.Title);
                      l.a(i.e(i.this), i, 1, i.d(i.this).mve, i.d(i.this).xbX.xbD, 27, "2$".concat(String.valueOf(localObject2)), ((eye)localObject1).KWG.MEq, ((eye)localObject1).UserName);
                      i.d(i.this).xbX.xbD.Nv(27);
                      i.a(i.this, paramAnonymousView.oUv, ((eye)localObject1).KWG.MEq, (String)localObject2, "", "", 0, "");
                      Log.i("MicroMsg.FTS.PardusSearchLogic", "click result weapp %s %s", new Object[] { ((eye)localObject1).UserName, ((eye)localObject1).KWG.MEq });
                      i.this.Nz(4);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(112339);
                      return;
                    }
                    if (paramAnonymousView.oUv == 1)
                    {
                      localObject1 = (ps)paramAnonymousView.KZz.getFirst();
                      localObject2 = new JSONObject(((ps)localObject1).KWH);
                      localObject3 = new Intent();
                      ((Intent)localObject3).putExtra("Contact_User", ((JSONObject)localObject2).optString("userName", ""));
                      ((Intent)localObject3).putExtra("Contact_Nick", ((JSONObject)localObject2).optString("nickName", ""));
                      ((Intent)localObject3).putExtra("Contact_Alias", ((JSONObject)localObject2).optString("aliasName", ""));
                      ((Intent)localObject3).putExtra("Contact_BrandIconURL", ((JSONObject)localObject2).optString("iconUrl", ""));
                      ((Intent)localObject3).putExtra("Contact_Signature", ((JSONObject)localObject2).optString("signature", ""));
                      ((Intent)localObject3).putExtra("Contact_VUser_Info_Flag", ((JSONObject)localObject2).optInt("verifyFlag", 0));
                      ((Intent)localObject3).putExtra("Contact_Scene", 3);
                      localObject4 = new aeq();
                      ((aeq)localObject4).kem = ((JSONObject)localObject2).optInt("brandFlag", 0);
                      ((aeq)localObject4).kep = ((JSONObject)localObject2).optString("iconUrl", "");
                      ((aeq)localObject4).keo = ((JSONObject)localObject2).optString("brandInfo", "");
                      ((aeq)localObject4).ken = ((JSONObject)localObject2).optString("externalInfo", "");
                    }
                  }
                  catch (Exception paramAnonymousView)
                  {
                    try
                    {
                      label527:
                      do
                      {
                        for (;;)
                        {
                          ((Intent)localObject3).putExtra("Contact_customInfo", ((aeq)localObject4).toByteArray());
                          Object localObject4 = new Bundle();
                          ((Bundle)localObject4).putString("Contact_Ext_Args_Search_Id", String.valueOf(i.a(i.this)));
                          ((Bundle)localObject4).putString("Contact_Ext_Args_Query_String", i.e(i.this));
                          ((Bundle)localObject4).putInt("Contact_Scene", 3);
                          ((Bundle)localObject4).putInt("Contact_Ext_Args_Index", 0);
                          ((Bundle)localObject4).putString("Contact_Ext_Extra_Params", "");
                          ((Intent)localObject3).putExtra("preChatTYPE", 10);
                          ((Intent)localObject3).putExtra("Contact_Ext_Args", (Bundle)localObject4);
                          com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject3);
                          Object localObject3 = l.ayQ(((ps)localObject1).KWG.Title);
                          l.a(i.e(i.this), i, 1, i.d(i.this).mve, i.d(i.this).xbX.xbD, 27, "1$".concat(String.valueOf(localObject3)), ((ps)localObject1).KWG.MEq, "");
                          i.this.Nz(4);
                          i.d(i.this).xbX.xbD.Nv(27);
                          i.d(i.this).xbX.xby = true;
                          i.a(i.this, paramAnonymousView.oUv, ((ps)localObject1).KWG.MEq, (String)localObject3, "", "", 0, "");
                          Log.i("MicroMsg.FTS.PardusSearchLogic", "click result biz %s %s", new Object[] { ((JSONObject)localObject2).optString("userName", ""), ((ps)localObject1).KWG.MEq });
                          continue;
                          paramAnonymousView = paramAnonymousView;
                          Log.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                        }
                      } while (paramAnonymousView.oUv != 5);
                      localObject1 = (czb)paramAnonymousView.KZF.getFirst();
                      Object localObject2 = ((czb)localObject1).MEm;
                      i.this.a((czc)localObject2);
                      localObject2 = l.ayQ(((czb)localObject1).MEl.Title);
                      l.a(i.e(i.this), i, 1, i.d(i.this).mve, i.d(i.this).xbX.xbD, 27, "8$".concat(String.valueOf(localObject2)), ((czb)localObject1).MEl.MEq, "");
                      i.d(i.this).xbX.xbD.Nv(27);
                      i.a(i.this, paramAnonymousView.oUv, ((czb)localObject1).MEl.MEq, (String)localObject2, "", "", 0, "");
                      Log.i("MicroMsg.FTS.PardusSearchLogic", "click result game %s %s", new Object[] { localObject2, ((czb)localObject1).MEl.MEq });
                    }
                    catch (IOException localIOException)
                    {
                      break label527;
                    }
                  }
                }
              }
            });
            this.xgk.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112340);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
                int i = 2;
                if (!i.f(i.this)) {
                  i = 1;
                }
                for (;;)
                {
                  try
                  {
                    paramAnonymousView = (sa)paramAnonymousView.getTag();
                    localObject1 = (ahp)paramAnonymousView.KZB.getFirst();
                    if (((ahp)localObject1).xJa != 1) {
                      continue;
                    }
                    localObject2 = new wq();
                    ((wq)localObject2).ecI.userName = ((ahp)localObject1).UserName;
                    ((wq)localObject2).ecI.ecK = ((ahp)localObject1).Lrs;
                    ((wq)localObject2).ecI.appVersion = ((ahp)localObject1).Lrt;
                    ((wq)localObject2).ecI.scene = 1027;
                    ((wq)localObject2).ecI.dCw = (((ahp)localObject1).Lru + ":2");
                    EventCenter.instance.publish((IEvent)localObject2);
                    localObject2 = l.ayQ(((ahp)localObject1).KWG.Title);
                    l.a(i.e(i.this), i, 1, i.d(i.this).mve, i.d(i.this).xbX.xbD, 27, "4$".concat(String.valueOf(localObject2)), ((ahp)localObject1).KWG.MEq, "");
                    i.this.Nz(4);
                    i.d(i.this).xbX.xbD.Nv(27);
                    i.d(i.this).xbX.xby = true;
                    i.a(i.this, paramAnonymousView.oUv, ((ahp)localObject1).KWG.MEq, (String)localObject2, ((ahp)localObject1).xIy, "", 0, "");
                    Log.i("MicroMsg.FTS.PardusSearchLogic", "click result article %s", new Object[] { ((ahp)localObject1).KWG.MEq });
                  }
                  catch (Exception paramAnonymousView)
                  {
                    Object localObject2;
                    Log.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                    continue;
                  }
                  i.this.Nz(4);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112340);
                  return;
                  if (((ahp)localObject1).xJa == 0)
                  {
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("rawUrl", ((ahp)localObject1).xIy);
                    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebviewMpUI", (Intent)localObject2);
                  }
                }
              }
            });
            this.xgw.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112341);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
                int i = 2;
                if (!i.f(i.this)) {
                  i = 1;
                }
                paramAnonymousView = (sa)paramAnonymousView.getTag();
                localObject1 = (czb)paramAnonymousView.KZF.getFirst();
                Object localObject2 = ((czb)localObject1).MEl.MEq;
                if (com.tencent.mm.ay.a.bec())
                {
                  com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.bef();
                  if ((localf.jeT == 9) && (localf.jeV.equals(localObject2)))
                  {
                    com.tencent.mm.ay.a.bea();
                    i.g(i.this).setImageResource(2131691321);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(112341);
                    return;
                  }
                }
                localObject2 = ((com.tencent.mm.plugin.sns.b.n)g.af(com.tencent.mm.plugin.sns.b.n.class)).PM(((czb)paramAnonymousView.KZF.getFirst()).MEm.MEo);
                g.aAi();
                com.tencent.mm.ay.a.c(i.a(g.aAh().hqG, (TimeLineObject)localObject2, ((czb)localObject1).MEl.MEq));
                i.g(i.this).setImageResource(2131691320);
                localObject2 = l.ayQ(((czb)localObject1).MEl.Title);
                l.a(i.e(i.this), i, 1, i.d(i.this).mve, i.d(i.this).xbX.xbD, 27, "7$".concat(String.valueOf(localObject2)), ((czb)localObject1).MEl.MEq, "");
                i.d(i.this).xbX.xbD.Nv(27);
                i.a(i.this, paramAnonymousView.oUv, ((czb)localObject1).MEl.MEq, (String)localObject2, "", "", 0, "");
                Log.i("MicroMsg.FTS.PardusSearchLogic", "click music play %d %s %s", new Object[] { Integer.valueOf(7), localObject2, ((czb)localObject1).MEl.MEq });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112341);
              }
            });
            this.xgv.setOnClickListener(this.xgM);
            this.xgq.setOnClickListener(this.xgM);
            label867:
            if (this.dDz) {
              this.xat = 2;
            }
            localObject1 = this.xfV.xbX.xbD;
            if (!this.dDz) {}
            break;
          }
          break;
        }
      }
      for (j = 2;; j = 0)
      {
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).gF(i, j);
        if ((!this.xgF) && (!this.dDz)) {
          break label2753;
        }
        i = this.contentView.getMeasuredHeight();
        localObject1 = ValueAnimator.ofInt(new int[] { 0, i });
        ((ValueAnimator)localObject1).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(176930);
            int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            Log.i("MicroMsg.FTS.PardusSearchLogic", "native onAnimationUpdate %d", new Object[] { Integer.valueOf(i) });
            i.h(i.this).getLayoutParams().height = i;
            i.h(i.this).requestLayout();
            AppMethodBeat.o(176930);
          }
        });
        ((ValueAnimator)localObject1).addListener(new a(this.xbf));
        ((ValueAnimator)localObject1).setDuration(400L);
        ((ValueAnimator)localObject1).start();
        this.contentView.setVisibility(0);
        Log.i("MicroMsg.FTS.PardusSearchLogic", "updateHeaderView measureHeight:%s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(176933);
        return;
        localObject1 = (ps)localsa.KZz.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.ayv(((ps)localObject1).KWG.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.ayv(((ps)localObject1).KWG.Desc);
        localObject2 = ((ps)localObject1).KWG.IconUrl;
        str1 = ((ps)localObject1).KWG.MEr;
        this.xfV.xbX.xbD.a(k, System.currentTimeMillis(), "PardusMore", 1, ((ps)localObject1).KWG.MEq);
        this.xfV.xbX.xbD.a(k + 1, System.currentTimeMillis(), ((ps)localObject1).KWG.MEq, 1, ((ps)localObject1).KWG.MEq);
        e(localsa.oUv, ((ps)localObject1).KWG.MEq, l.ayQ(((ps)localObject1).KWG.Title), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject1 = (eye)localsa.KZA.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.ayv(((eye)localObject1).KWG.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.ayv(((eye)localObject1).KWG.Desc);
        localObject2 = ((eye)localObject1).KWG.IconUrl;
        str1 = ((eye)localObject1).KWG.MEr;
        this.xfV.xbX.xbD.a(k, System.currentTimeMillis(), "PardusMore", 2, ((eye)localObject1).KWG.MEq);
        this.xfV.xbX.xbD.a(k + 1, System.currentTimeMillis(), ((eye)localObject1).KWG.MEq, 2, ((eye)localObject1).KWG.MEq);
        e(localsa.oUv, ((eye)localObject1).KWG.MEq, l.ayQ(((eye)localObject1).KWG.Title), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject5 = (ahp)localsa.KZB.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.ayv(((ahp)localObject5).KWG.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.ayv(((ahp)localObject5).KWG.Desc);
        localObject2 = ((ahp)localObject5).KWG.IconUrl;
        str1 = ((ahp)localObject5).KWG.MEr;
        localObject1 = ((ahp)localObject5).Lrr;
        this.xfV.xbX.xbD.a(k, System.currentTimeMillis(), "PardusMore", 4, ((ahp)localObject5).KWG.MEq);
        this.xfV.xbX.xbD.a(k + 1, System.currentTimeMillis(), ((ahp)localObject5).KWG.MEq, 4, ((ahp)localObject5).KWG.MEq);
        e(localsa.oUv, ((ahp)localObject5).KWG.MEq, l.ayQ(((ahp)localObject5).KWG.Title), "", "");
        localObject5 = "";
        break;
        czb localczb = (czb)localsa.KZF.getFirst();
        localObject5 = localczb.MEl.MEq;
        localObject4 = com.tencent.mm.plugin.fts.a.f.ayv(localczb.MEl.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.ayv(localczb.MEl.Desc);
        localObject2 = localczb.MEl.IconUrl;
        str1 = localczb.MEl.MEr;
        j = localczb.MEl.xuX;
        if ((j <= 0) || (j >= 86400L))
        {
          str2 = null;
          j = 0;
          if (localsa.oUv != 5) {
            break label1782;
          }
          j = 8;
        }
        for (;;)
        {
          this.xfV.xbX.xbD.a(k, System.currentTimeMillis(), "PardusMore", j, (String)localObject5);
          this.xfV.xbX.xbD.a(k + 1, System.currentTimeMillis(), (String)localObject5, j, (String)localObject5);
          e(localsa.oUv, (String)localObject5, l.ayQ(localczb.MEl.Title), "", "");
          localObject1 = "";
          break;
          if (j < 3600L) {}
          for (localObject1 = "mm:ss";; localObject1 = "HH:mm:ss")
          {
            localObject1 = new SimpleDateFormat((String)localObject1);
            ((SimpleDateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
            str2 = ((SimpleDateFormat)localObject1).format(Long.valueOf(j * 1000L));
            break;
          }
          label1782:
          if (localsa.oUv == 4194304) {
            j = 6;
          } else if (localsa.oUv == 512) {
            j = 7;
          }
        }
        this.dDz = true;
        this.xgg.setVisibility(0);
        this.xeb.setVisibility(0);
        this.xeb.setTag(localsa);
        this.xgk.setVisibility(8);
        this.xgq.setVisibility(8);
        this.xgv.setVisibility(8);
        this.xgi.setText((CharSequence)localObject4);
        if (!Util.isNullOrNil((CharSequence)localObject3)) {
          if (this.xec.getPaint().measureText(((CharSequence)localObject3).toString()) >= this.xfZ)
          {
            this.xec.setMaxLines(2);
            label1924:
            this.xec.setText((CharSequence)localObject3);
            this.xec.setVisibility(0);
            label1941:
            localObject1 = this.xfV.getContext();
            localObject3 = this.gvv;
            if (localsa.oUv == 5) {
              break label2029;
            }
          }
        }
        label2029:
        for (boolean bool = true;; bool = false)
        {
          com.tencent.mm.plugin.fts.ui.n.a((Context)localObject1, (ImageView)localObject3, (String)localObject2, null, 2131231405, bool);
          this.xgj.setText(str1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.xec.setMaxLines(1);
          break label1924;
          this.xec.setVisibility(8);
          break label1941;
        }
        this.dDz = true;
        this.xgg.setVisibility(0);
        this.xeb.setVisibility(8);
        this.xgk.setVisibility(0);
        this.xgq.setVisibility(8);
        this.xgv.setVisibility(8);
        this.xgk.setTag(localsa);
        if (!Util.isNullOrNil((CharSequence)localObject4)) {
          if (!Util.isNullOrNil((String)localObject2))
          {
            this.xgm.setMaxLines(1);
            this.xgn.setMaxLines(2);
            this.xgl.setVisibility(0);
            localObject5 = new c.a();
            ((c.a)localObject5).jbe = true;
            ((c.a)localObject5).jbq = 2131231961;
            ((c.a)localObject5).jbx = 1.0F;
            ((c.a)localObject5).iaT = true;
            localObject5 = ((c.a)localObject5).bdv();
            com.tencent.mm.av.q.bcV().a((String)localObject2, this.xgl, (com.tencent.mm.av.a.a.c)localObject5);
            label2188:
            this.xgm.setText((CharSequence)localObject4);
            this.xgm.setVisibility(0);
            label2205:
            if (Util.isNullOrNil((CharSequence)localObject3)) {
              break label2347;
            }
            this.xgn.setText((CharSequence)localObject3);
            this.xgn.setVisibility(0);
          }
        }
        for (;;)
        {
          this.xgo.setText(str1);
          this.xgp.setText((CharSequence)localObject1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.xgl.setVisibility(8);
          if (this.xgm.getPaint().measureText(((CharSequence)localObject4).toString()) >= this.xgb)
          {
            this.xgm.setMaxLines(2);
            this.xgn.setMaxLines(1);
            break label2188;
          }
          this.xgm.setMaxLines(1);
          this.xgn.setMaxLines(2);
          break label2188;
          this.xgm.setVisibility(8);
          break label2205;
          label2347:
          this.xgn.setVisibility(8);
        }
        this.dDz = true;
        this.xgg.setVisibility(0);
        this.xeb.setVisibility(8);
        this.xgk.setVisibility(8);
        this.xgv.setVisibility(8);
        this.xgq.setVisibility(0);
        this.xgq.setTag(localsa);
        this.xgt.setText((CharSequence)localObject4);
        this.xgu.setText(str1);
        this.xgs.setText(str2);
        localObject1 = new c.a();
        ((c.a)localObject1).jbe = true;
        ((c.a)localObject1).jbq = 2131231967;
        ((c.a)localObject1).jbx = 1.0F;
        ((c.a)localObject1).iaT = true;
        localObject1 = ((c.a)localObject1).bdv();
        com.tencent.mm.av.q.bcV().a((String)localObject2, this.xgr, (com.tencent.mm.av.a.a.c)localObject1);
        this.contentView.measure(-2147483648, 0);
        break label785;
        this.dDz = true;
        this.xgg.setVisibility(0);
        this.xeb.setVisibility(8);
        this.xgk.setVisibility(8);
        this.xgq.setVisibility(8);
        this.xgv.setVisibility(0);
        this.xgv.setTag(localsa);
        this.xgw.setTag(localsa);
        this.xgy.setText((CharSequence)localObject4);
        this.xgz.setText((CharSequence)localObject3);
        this.xgA.setText(str1);
        if ((com.tencent.mm.ay.a.bec()) && (com.tencent.mm.ay.a.bef().jeV.equals(localObject5))) {
          this.xgw.setImageResource(2131691320);
        }
        for (;;)
        {
          localObject1 = new c.a();
          ((c.a)localObject1).jbe = true;
          ((c.a)localObject1).jbq = 2131231964;
          ((c.a)localObject1).jbx = 1.0F;
          ((c.a)localObject1).iaT = true;
          localObject1 = ((c.a)localObject1).bdv();
          com.tencent.mm.av.q.bcV().a((String)localObject2, this.xgx, (com.tencent.mm.av.a.a.c)localObject1);
          this.contentView.measure(-2147483648, 0);
          this.xgN.alive();
          break;
          this.xgw.setImageResource(2131691321);
        }
        this.xgg.setVisibility(8);
        this.contentView.measure(0, 0);
        break label867;
      }
      label2753:
      this.contentView.setVisibility(8);
      AppMethodBeat.o(176933);
      return;
    }
  }
  
  private String getSearchId()
  {
    AppMethodBeat.i(112366);
    if (this.xbd != null)
    {
      String str = this.xbd.Mbb;
      AppMethodBeat.o(112366);
      return str;
    }
    long l = this.xbf;
    AppMethodBeat.o(112366);
    return String.valueOf(l);
  }
  
  private void hy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112363);
    this.xfV.xbX.xby = true;
    if ((paramString1 == null) || (Util.isNullOrNil(paramString1.trim())))
    {
      AppMethodBeat.o(112363);
      return;
    }
    if (System.currentTimeMillis() - this.mZq <= 1000L)
    {
      AppMethodBeat.o(112363);
      return;
    }
    this.mZq = System.currentTimeMillis();
    long l = com.tencent.mm.plugin.fts.a.e.wVm;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneActionType", "1");
    localHashMap.put("parentSearchID", paramString2);
    localHashMap.put("clickType", "17");
    ((h)g.af(h.class)).a(this.xfV.getContext(), 3, paramString1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(112363);
  }
  
  public final void J(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184533);
    String str = "";
    if (this.xbd != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.xbd.Mbb, paramString2, Long.valueOf(this.xbf) });
    }
    paramString2 = new HashMap();
    paramString2.put("prefixSug", this.query);
    if (!Util.isNullOrNil(str)) {
      paramString2.put("parentSearchID", str);
    }
    paramString2.put("sceneActionType", "6");
    m(paramString2, paramString1);
    AppMethodBeat.o(184533);
  }
  
  public final void Nz(int paramInt)
  {
    AppMethodBeat.i(184532);
    if ((!this.xgH) && (!Util.isNullOrNil(this.query)))
    {
      ar.q(this.query, this.xat, paramInt, 3);
      this.xgH = true;
    }
    AppMethodBeat.o(184532);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(112367);
    Log.i("MicroMsg.FTS.PardusSearchLogic", "change status from %s to %s", new Object[] { this.xgD, paramb });
    this.xgD = paramb;
    AppMethodBeat.o(112367);
  }
  
  public final void a(czc paramczc)
  {
    AppMethodBeat.i(176934);
    switch (paramczc.KWb)
    {
    }
    for (;;)
    {
      Nz(4);
      AppMethodBeat.o(176934);
      return;
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramczc.xIy);
      com.tencent.mm.br.c.b(this.xfV, "webview", ".ui.tools.WebviewMpUI", (Intent)localObject1);
      continue;
      localObject1 = new wq();
      ((wq)localObject1).ecI.userName = paramczc.UserName;
      ((wq)localObject1).ecI.ecK = paramczc.Lrs;
      ((wq)localObject1).ecI.appVersion = paramczc.Lrt;
      ((wq)localObject1).ecI.dCw = paramczc.Lru;
      EventCenter.instance.publish((IEvent)localObject1);
      continue;
      localObject1 = paramczc.query;
      Object localObject2 = paramczc.MEp;
      paramczc = new HashMap();
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        Iterator localIterator = ((JSONObject)localObject2).keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramczc.put(str, ((JSONObject)localObject2).optString(str));
        }
      }
      catch (Exception localException)
      {
        ((h)g.af(h.class)).a(this.xfV, 3, (String)localObject1, String.valueOf(com.tencent.mm.plugin.fts.a.e.wVm), paramczc);
      }
    }
  }
  
  public final void cHi()
  {
    AppMethodBeat.i(112360);
    if (!this.dDz)
    {
      this.xba.removeAllViews();
      LinkedList localLinkedList;
      if ((this.xbd == null) || (this.xbd.MEy == null)) {
        localLinkedList = null;
      }
      while ((!this.xgF) && (localLinkedList != null) && (localLinkedList.size() > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < localLinkedList.size())
          {
            efk localefk = (efk)localLinkedList.get(i);
            alv localalv = new alv();
            localalv.Lux = localefk;
            localalv.xuA = i;
            View localView = this.xfV.getLayoutInflater().inflate(2131494784, this.xba, false);
            localView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112337);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                paramAnonymousView = (alv)paramAnonymousView.getTag();
                if (paramAnonymousView.Lux.xJa == 3) {
                  if ((paramAnonymousView.Lux.NfH != null) && (!Util.isNullOrNil(paramAnonymousView.Lux.NfH.yO()))) {
                    i.hz(paramAnonymousView.Lux.NfH.yO(), i.e(i.this));
                  }
                }
                for (;;)
                {
                  localObject = i.d(i.this).xbX.xbD;
                  l.a(i.e(i.this), i.d(i.this).xbX.getCount(), i.d(i.this).mve, (com.tencent.mm.plugin.fts.ui.c.b)localObject, 23);
                  i.d(i.this).xbX.xby = true;
                  if (!i.d(i.this).xbX.xbo)
                  {
                    i.d(i.this).xbX.xbo = true;
                    l.a(paramAnonymousView.Lux.MGp, true, i.d(i.this).xbX.getCount(), 0, (com.tencent.mm.plugin.fts.ui.c.b)localObject);
                  }
                  i.this.Nz(7);
                  ar.afA(3);
                  i.d(i.this).xbX.xbD.Nv(23);
                  i.a(i.this, 0, "", "", "", "", paramAnonymousView.xuA + 1, paramAnonymousView.Lux.MEq);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112337);
                  return;
                  Log.e("MicroMsg.FTS.PardusSearchLogic", "updateFooterView, fts h5 relatedItem.Item.JumpType = " + paramAnonymousView.Lux.xJa + ", but JumpUrl = " + paramAnonymousView.Lux.NfH);
                  continue;
                  i.this.J(paramAnonymousView.Lux.MGp, 7, paramAnonymousView.Lux.MEq);
                }
              }
            });
            ((TextView)localView.findViewById(2131299180)).setText(localefk.MGp);
            localView.setTag(localalv);
            this.xba.addView(localView);
            i += 1;
            continue;
            localLinkedList = this.xbd.MEy.KKx;
            break;
          }
        }
        this.xfV.xbX.xbD.gG(localLinkedList.size(), 1);
        this.xba.setVisibility(0);
        this.xfV.xbX.xbD.eS(localLinkedList);
      }
      for (;;)
      {
        this.xaX.setVisibility(0);
        this.xaY.setVisibility(0);
        this.xfV.xbX.xbD.dPB();
        AppMethodBeat.o(112360);
        return;
        this.xfV.xbX.xbD.gG(0, 1);
        this.xba.setVisibility(8);
      }
    }
    this.xfV.xbX.xbD.gG(0, 0);
    this.xaY.setVisibility(8);
    this.xaX.setVisibility(8);
    AppMethodBeat.o(112360);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(112353);
    this.xgD = b.xgQ;
    this.xat = 1;
    this.xbf = 0L;
    this.xaI = 0L;
    this.wXS = 0L;
    this.xgE = false;
    this.xgF = false;
    this.dDz = false;
    this.xgH = false;
    this.query = null;
    this.xbd = null;
    this.xgN.dead();
    if (this.xgB != null) {
      this.xgB.clearData();
    }
    AppMethodBeat.o(112353);
  }
  
  public final void dOG()
  {
    AppMethodBeat.i(112352);
    this.xeO.removeMessages(1);
    if (this.xgC != null)
    {
      g.azz().a(this.xgC);
      g.azz().b(1076, this);
      this.xgC = null;
    }
    AppMethodBeat.o(112352);
  }
  
  public final void dQc()
  {
    AppMethodBeat.i(112356);
    if (this.xgI != null)
    {
      g.azz().a(this.xgI);
      g.azz().b(1417, this);
      this.xgI = null;
    }
    AppMethodBeat.o(112356);
  }
  
  @TargetApi(8)
  public final void dQd()
  {
    AppMethodBeat.i(112357);
    if (this.contentView != null)
    {
      this.xfV.pu(true);
      this.contentView.clearAnimation();
      this.contentView.setVisibility(8);
    }
    if (this.xba != null)
    {
      this.xba.removeAllViews();
      this.xba.setVisibility(8);
    }
    if (this.xaX != null) {
      this.xaX.setVisibility(8);
    }
    if (this.xaY != null) {
      this.xaY.setVisibility(8);
    }
    if (this.xgB != null) {
      this.xgB.dQf();
    }
    AppMethodBeat.o(112357);
  }
  
  public final void dY(String paramString, int paramInt)
  {
    AppMethodBeat.i(176935);
    String str = "";
    if (this.xbd != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.xbd.Mbb, paramString, Long.valueOf(this.xbf) });
    }
    hy(paramString, str);
    AppMethodBeat.o(176935);
  }
  
  public final View dzK()
  {
    AppMethodBeat.i(112361);
    if (this.xaW == null)
    {
      this.xaW = this.xfV.getLayoutInflater().inflate(2131494780, null, false);
      this.xaY = this.xaW.findViewById(2131310374);
      this.xaX = this.xaW.findViewById(2131310377);
      this.xaZ = this.xaW.findViewById(2131310376);
      this.xbb = ((TextView)this.xaW.findViewById(2131310378));
      this.xbc = ((TextView)this.xaW.findViewById(2131310375));
      this.xba = ((LinearLayout)this.xaX.findViewById(2131306825));
    }
    try
    {
      Object localObject = ak.aXe("webSearchBar").optString("wording");
      Log.i("MicroMsg.FTS.PardusSearchLogic", "set searchNetworkTips %s", new Object[] { localObject });
      this.xbc.setText((CharSequence)localObject);
      label163:
      this.xaY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(112333);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!WeChatBrands.Business.Entries.ContextSearch.checkAvailable(paramAnonymousView.getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(112333);
            return;
          }
          i.d(i.this).xbX.xby = true;
          if (!i.d(i.this).xbX.xbo)
          {
            i.d(i.this).xbX.xbo = true;
            l.a(i.e(i.this), true, i.d(i.this).xbX.getCount(), 0, i.d(i.this).xbX.xbD);
          }
          i.this.dY(i.e(i.this), 15);
          i.d(i.this).xbX.xby = true;
          i.this.Nz(2);
          ar.afA(3);
          i.d(i.this).xbX.xbD.Nv(18);
          l.a(i.e(i.this), i.d(i.this).xbX.getCount(), i.d(i.this).mve, i.d(i.this).xbX.xbD, 18);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112333);
        }
      });
      localObject = this.xaW;
      AppMethodBeat.o(112361);
      return localObject;
    }
    catch (Exception localException)
    {
      break label163;
    }
  }
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(112365);
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("pardussearch=expose&searchid=");
      localStringBuffer.append(getSearchId());
      localStringBuffer.append("&query=");
      localStringBuffer.append(com.tencent.mm.compatible.util.q.encode(this.query, "utf8"));
      localStringBuffer.append("&type=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&docid=");
      localStringBuffer.append(paramString1);
      localStringBuffer.append("&title=");
      localStringBuffer.append(com.tencent.mm.compatible.util.q.encode(paramString2, "utf8"));
      localStringBuffer.append("&clienttimestamp=");
      localStringBuffer.append(System.currentTimeMillis());
      localStringBuffer.append("&sug=");
      localStringBuffer.append(com.tencent.mm.compatible.util.q.encode(paramString3, "utf8"));
      localStringBuffer.append("&relatedsug=");
      localStringBuffer.append(com.tencent.mm.compatible.util.q.encode(paramString4, "utf8"));
      Log.i("MicroMsg.FTS.PardusSearchLogic", "realtimeSearchExposeReport %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new doc();
      paramString1.MRe = localStringBuffer.toString();
      paramString1 = new ad(paramString1);
      g.azz().a(paramString1, 0);
      AppMethodBeat.o(112365);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramString1, "realtimeSearchExposeReport", new Object[0]);
      AppMethodBeat.o(112365);
    }
  }
  
  public final void f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112362);
    if ((paramBoolean2) || (paramInt != 0)) {
      this.xaZ.setVisibility(0);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
        b.a locala = b.a.sgV;
        com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
        if (localb.a(locala, com.tencent.mm.util.c.hdd()) == 0) {
          cHi();
        }
      }
      AppMethodBeat.o(112362);
      return;
      this.xaZ.setVisibility(8);
    }
  }
  
  public final void m(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(176936);
    this.xfV.xbX.xby = true;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176936);
      return;
    }
    if (System.currentTimeMillis() - this.mZq <= 1000L)
    {
      AppMethodBeat.o(176936);
      return;
    }
    this.mZq = System.currentTimeMillis();
    long l = com.tencent.mm.plugin.fts.a.e.wVm;
    paramMap.put("clickType", "7");
    ((h)g.af(h.class)).a(this.xfV.getContext(), paramString, String.valueOf(l), paramMap);
    AppMethodBeat.o(176936);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112354);
    Log.i("MicroMsg.FTS.PardusSearchLogic", "onFocusChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      dQb();
    }
    AppMethodBeat.o(112354);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    int i = 0;
    AppMethodBeat.i(112359);
    boolean bool;
    if (paramq.equals(this.xgI))
    {
      g.azz().b(1417, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.xgK = this.xgI.IDB.MEk;
        Log.i("MicroMsg.FTS.PardusSearchLogic", "pardusCacheExpireTime %d", new Object[] { Long.valueOf(this.xgK) });
        AppMethodBeat.o(112359);
      }
    }
    else if ((paramq.equals(this.xgC)) && (this.xgC.IDD.Mba.equals(String.valueOf(this.xbf))))
    {
      a(b.xgS);
      this.xeO.removeMessages(1);
      g.azz().b(1076, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label389;
      }
      l.N(this.xbf, 4);
      this.xbd = this.xgC.IDC;
      if ((this.xbd == null) || (Util.isNullOrNil(this.xbd.MEz))) {
        break label359;
      }
      bool = true;
    }
    for (;;)
    {
      this.xgG = bool;
      bool = this.xgG;
      paramInt2 = this.xbd.MEu.size();
      label230:
      String str;
      if (this.xbd.MlS == null)
      {
        paramInt1 = i;
        Log.i("MicroMsg.FTS.PardusSearchLogic", "searchResponse hasWebViewResult %b result:%d sug:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        if (!this.xgE)
        {
          if (!this.xgG) {
            break label382;
          }
          paramString = this.xgB;
          str = this.xbd.MEz;
          paramString.dUA = this.query;
          paramq = new JSONObject();
        }
      }
      try
      {
        paramq.put("info", str);
        label321:
        paramString.xbE.xfV.runOnUiThread(new j.1(paramString, paramq));
        for (;;)
        {
          if (!this.xgG) {
            cHi();
          }
          AppMethodBeat.o(112359);
          return;
          label359:
          bool = false;
          break;
          paramInt1 = this.xbd.MlS.KKx.size();
          break label230;
          label382:
          dQe();
          continue;
          label389:
          l.N(this.xbf, 5);
        }
      }
      catch (Exception localException)
      {
        break label321;
      }
    }
  }
  
  final class a
    implements Animator.AnimatorListener
  {
    private long xgP;
    
    public a(long paramLong)
    {
      this.xgP = paramLong;
    }
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(176932);
      Log.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationEnd listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.xgP), Long.valueOf(i.a(i.this)) });
      if (this.xgP == i.a(i.this))
      {
        i.d(i.this).pu(true);
        if (i.i(i.this) == i.b.xgT)
        {
          i.this.a(i.b.xgU);
          l.N(i.a(i.this), 7);
        }
      }
      AppMethodBeat.o(176932);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(176931);
      Log.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationStart listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.xgP), Long.valueOf(i.a(i.this)) });
      if (this.xgP == i.a(i.this))
      {
        i.d(i.this).pu(false);
        i.this.a(i.b.xgT);
        l.N(i.a(i.this), 6);
      }
      AppMethodBeat.o(176931);
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(112350);
      xgQ = new b("None", 0);
      xgR = new b("StartSearch", 1);
      xgS = new b("ReturnResult", 2);
      xgT = new b("StartAnimation", 3);
      xgU = new b("ShowResult", 4);
      xgV = new b("Timeout", 5);
      xgW = new b[] { xgQ, xgR, xgS, xgT, xgU, xgV };
      AppMethodBeat.o(112350);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.i
 * JD-Core Version:    0.7.0.1
 */