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
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.a.np;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.fts.ui.o.c;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.plugin.fts.ui.o.f;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dim;
import com.tencent.mm.protocal.protobuf.din;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dip;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.dir;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.protocal.protobuf.epm;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.fiv;
import com.tencent.mm.protocal.protobuf.po;
import com.tencent.mm.protocal.protobuf.rt;
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
  implements View.OnFocusChangeListener, com.tencent.mm.an.i
{
  private long BJO;
  public long BMI;
  private View BMW;
  private View BMX;
  public View BMY;
  private View BMZ;
  public int BMs;
  public LinearLayout BNa;
  public TextView BNb;
  private TextView BNc;
  private dir BNd;
  public long BNf;
  public View BPZ;
  public MMHandler BQX;
  public TextView BQa;
  public TextView BSA;
  public View BSB;
  public ImageView BSC;
  public TextView BSD;
  public TextView BSE;
  public TextView BSF;
  public View BSG;
  public ImageView BSH;
  public ImageView BSI;
  public TextView BSJ;
  public TextView BSK;
  public TextView BSL;
  public j BSM;
  public u BSN;
  public b BSO;
  public boolean BSP;
  public boolean BSQ;
  private boolean BSR;
  private boolean BSS;
  private com.tencent.mm.plugin.websearch.api.t BST;
  private long BSU;
  private long BSV;
  private View.OnClickListener BSW;
  private View.OnClickListener BSX;
  private IListener<np> BSY;
  public FTSMainUI BSg;
  private final int BSi;
  public View BSj;
  private int BSk;
  private int BSl;
  private int BSm;
  public View BSn;
  public TextView BSo;
  public TextView BSp;
  public TextView BSq;
  public View BSr;
  public View BSs;
  public TextView BSt;
  public TextView BSu;
  public View BSv;
  public ImageView BSw;
  public TextView BSx;
  public TextView BSy;
  public TextView BSz;
  public View contentView;
  public boolean fwi;
  public ImageView iZG;
  public long pZO;
  public String query;
  
  public i(FTSMainUI paramFTSMainUI)
  {
    AppMethodBeat.i(112351);
    this.BSi = 3;
    this.BSk = 0;
    this.BSl = 0;
    this.BSm = 0;
    this.BSO = b.BTd;
    this.BSP = false;
    this.BSQ = false;
    this.fwi = false;
    this.BSR = false;
    this.BSS = false;
    this.BMs = 1;
    this.BQX = new MMHandler(Looper.getMainLooper())
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
            i.this.a(i.b.BTi);
            i.a(i.this, System.currentTimeMillis());
            Log.i("MicroMsg.FTS.PardusSearchLogic", "cancel Time %d", new Object[] { Long.valueOf(i.b(i.this) - i.c(i.this)) });
            l.U(i.a(i.this), 5);
            i.this.eqZ();
            i.this.cVU();
          }
        }
      }
    };
    this.BSV = 60L;
    this.BSW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112336);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = (amw)paramAnonymousView.getTag();
        i.this.N(paramAnonymousView.SwV.TSb, 22, paramAnonymousView.SwV.TPZ);
        i.d(i.this).BNX.BNy = true;
        l.a(i.e(i.this), 1, 1, i.d(i.this).ptD, i.d(i.this).BNX.BND, 28, "", "", "");
        i.d(i.this).BNX.BND.SJ(28);
        i.a(i.this, 0, "", "", "", paramAnonymousView.SwV.TPZ, paramAnonymousView.CqR + 1, "");
        i.this.SN(6);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112336);
      }
    };
    this.BSX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112343);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramAnonymousView = (rt)paramAnonymousView.getTag();
        switch (paramAnonymousView.rWu)
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
        localObject1 = (din)paramAnonymousView.SaO.getFirst();
        Object localObject2 = ((din)localObject1).TPV;
        i.this.a((dio)localObject2);
        int i;
        if (paramAnonymousView.rWu == 512) {
          i = 7;
        }
        for (;;)
        {
          localObject2 = l.aIm(((din)localObject1).TPU.fwr);
          l.a(i.e(i.this), j, 1, i.d(i.this).ptD, i.d(i.this).BNX.BND, 27, i + "$" + (String)localObject2, ((din)localObject1).TPU.TPZ, "");
          i.d(i.this).BNX.BND.SJ(27);
          i.a(i.this, paramAnonymousView.rWu, ((din)localObject1).TPU.TPZ, (String)localObject2, "", "", 0, "");
          Log.i("MicroMsg.FTS.PardusSearchLogic", "click result %d %s %s", new Object[] { Integer.valueOf(i), localObject2, ((din)localObject1).TPU.TPZ });
          break;
          if (paramAnonymousView.rWu == 4194304) {
            i = 6;
          } else {
            i = 0;
          }
        }
      }
    };
    this.BSY = new IListener() {};
    this.BSg = paramFTSMainUI;
    this.BSk = (com.tencent.mm.ci.a.kr(paramFTSMainUI.getContext()) - com.tencent.mm.ci.a.fromDPToPix(paramFTSMainUI.getContext(), 100));
    this.BSl = (com.tencent.mm.ci.a.kr(paramFTSMainUI.getContext()) - com.tencent.mm.ci.a.fromDPToPix(paramFTSMainUI.getContext(), 116));
    this.BSm = (com.tencent.mm.ci.a.kr(paramFTSMainUI.getContext()) - com.tencent.mm.ci.a.fromDPToPix(paramFTSMainUI.getContext(), 48));
    esB();
    AppMethodBeat.o(112351);
  }
  
  public static com.tencent.mm.bb.f a(String paramString1, TimeLineObject paramTimeLineObject, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(112368);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.Sqr == null) || (paramTimeLineObject.ContentObj.Sqr.size() <= 0))
    {
      AppMethodBeat.o(112368);
      return null;
    }
    cvt localcvt = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
    if (localcvt == null)
    {
      AppMethodBeat.o(112368);
      return null;
    }
    com.tencent.mm.bb.f localf = new com.tencent.mm.bb.f();
    localf.lVr = 9;
    localf.lVt = paramString2;
    localf.lVu = 0.0F;
    localf.lVx = "";
    if (!TextUtils.isEmpty(localcvt.songAlbumUrl)) {
      localf.lVK = localcvt.songAlbumUrl;
    }
    localf.lVy = localcvt.TDF;
    localf.lVD = null;
    localf.lVs = 1;
    localf.lVC = localcvt.songLyric;
    localf.lVv = localcvt.fwr;
    localf.lVw = localcvt.CMB;
    paramString2 = localObject;
    if (paramTimeLineObject.ContentObj != null) {
      paramString2 = paramTimeLineObject.ContentObj.Url;
    }
    localf.lVB = paramString2;
    localf.lVA = localcvt.TDI;
    localf.lVz = localcvt.Url;
    localf.lVH = localcvt.TDG;
    localf.lVJ = localcvt.Id;
    localf.lVE = paramString1;
    localf.lVG = paramTimeLineObject.AppInfo.Id;
    localf.lVN = paramTimeLineObject.UserName;
    localf.lVU = paramTimeLineObject.Id;
    AppMethodBeat.o(112368);
    return localf;
  }
  
  private void esB()
  {
    AppMethodBeat.i(112355);
    if (System.currentTimeMillis() - this.BSU > this.BSV * 1000L)
    {
      Log.i("MicroMsg.FTS.PardusSearchLogic", "start to request pre search");
      esC();
      this.BST = new com.tencent.mm.plugin.websearch.api.t(new dil());
      com.tencent.mm.kernel.h.aGY().a(1417, this);
      com.tencent.mm.kernel.h.aGY().a(this.BST, 0);
      this.BSU = System.currentTimeMillis();
    }
    AppMethodBeat.o(112355);
  }
  
  @SuppressLint({"ResourceType"})
  private void esE()
  {
    AppMethodBeat.i(176933);
    Object localObject1;
    int j;
    Object localObject2;
    int i;
    if ((this.BNd == null) || (this.BNd.TwM == null))
    {
      localObject1 = null;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label523;
      }
      this.BSQ = true;
      this.BSn.setVisibility(0);
      j = ((epl)((List)localObject1).get(0)).TSb.length() + 0;
      localObject2 = new amw();
      ((amw)localObject2).SwV = ((epl)((List)localObject1).get(0));
      ((amw)localObject2).CqR = 0;
      this.BSo.setTag(localObject2);
      this.BSo.setText(((epl)((List)localObject1).get(0)).TSb);
      this.BSo.setOnClickListener(this.BSW);
      this.BSo.setVisibility(0);
      this.BSg.BNX.BND.A(System.currentTimeMillis(), "PardusSug");
      if (((List)localObject1).size() <= 1) {
        break label485;
      }
      j += ((epl)((List)localObject1).get(1)).TSb.length();
      this.BSp.setOnClickListener(this.BSW);
      localObject2 = new amw();
      ((amw)localObject2).SwV = ((epl)((List)localObject1).get(1));
      ((amw)localObject2).CqR = 1;
      this.BSp.setTag(localObject2);
      this.BSp.setText(((epl)((List)localObject1).get(1)).TSb);
      this.BSp.setVisibility(0);
      i = 2;
      label286:
      if (((List)localObject1).size() <= 2) {
        break label511;
      }
      if (((epl)((List)localObject1).get(2)).TSb.length() + j > 24) {
        break label499;
      }
      this.BSq.setOnClickListener(this.BSW);
      localObject2 = new amw();
      ((amw)localObject2).SwV = ((epl)((List)localObject1).get(2));
      ((amw)localObject2).CqR = 2;
      this.BSq.setTag(localObject2);
      this.BSq.setText(((epl)((List)localObject1).get(2)).TSb);
      this.BSq.setVisibility(0);
      i += 1;
    }
    label523:
    for (;;)
    {
      label405:
      if (this.BSQ)
      {
        localObject2 = "";
        j = 0;
        for (;;)
        {
          if (j < i)
          {
            localObject2 = (String)localObject2 + ((epl)((List)localObject1).get(j)).TPZ + "_";
            j += 1;
            continue;
            localObject1 = this.BNd.TwM.RLp;
            break;
            label485:
            this.BSp.setVisibility(8);
            i = 1;
            break label286;
            label499:
            this.BSq.setVisibility(8);
            break label405;
            label511:
            this.BSq.setVisibility(8);
            break label405;
            this.BSn.setVisibility(8);
            i = 0;
            break label405;
          }
        }
        g(0, "", "", (String)localObject2, "");
      }
    }
    int k = 2;
    if (!this.BSQ) {
      k = 1;
    }
    if (this.BNd.TQd.size() > 0) {}
    for (rt localrt = (rt)this.BNd.TQd.getFirst();; localrt = null)
    {
      Object localObject4;
      String str2;
      Object localObject5;
      String str1;
      Object localObject3;
      if (localrt != null)
      {
        localObject4 = "";
        localObject2 = "";
        str2 = "";
        this.BSs.setTag(localrt);
        switch (localrt.rWu)
        {
        default: 
          localObject5 = "";
          localObject1 = "";
          str1 = "";
          localObject3 = "";
          switch (localrt.rWu)
          {
          default: 
            this.fwi = false;
            this.BSr.setVisibility(8);
            this.contentView.measure(-2147483648, 0);
            label785:
            this.BSs.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112338);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                i.this.ev(i.e(i.this), 21);
                rt localrt = (rt)paramAnonymousView.getTag();
                paramAnonymousView = "";
                localObject = "";
                String str1;
                String str2;
                switch (localrt.rWu)
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
                  l.a(i.e(i.this), i, 2, i.d(i.this).ptD, i.d(i.this).BNX.BND, 27, paramAnonymousView, (String)localObject, "");
                  i.d(i.this).BNX.BND.SJ(27);
                  i.d(i.this).BNX.BNy = true;
                  i.a(i.this, localrt.rWu, "more", str2, str1, "", 0, "");
                  i.this.SN(5);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112338);
                  return;
                  localObject = (po)localrt.SaI.getFirst();
                  str2 = l.aIm(((po)localObject).RXU.fwr);
                  paramAnonymousView = "1$".concat(String.valueOf(str2));
                  localObject = ((po)localObject).RXU.TPZ;
                  str1 = "";
                  continue;
                  localObject = (fiv)localrt.SaJ.getFirst();
                  str2 = l.aIm(((fiv)localObject).RXU.fwr);
                  paramAnonymousView = "2$".concat(String.valueOf(str2));
                  localObject = ((fiv)localObject).RXU.TPZ;
                  str1 = "";
                  continue;
                  localObject = (aia)localrt.SaK.getFirst();
                  str1 = ((aia)localObject).CMD;
                  str2 = l.aIm(((aia)localObject).RXU.fwr);
                  paramAnonymousView = "4$".concat(String.valueOf(str2));
                  localObject = ((aia)localObject).RXU.TPZ;
                  continue;
                  localObject = (din)localrt.SaO.getFirst();
                  str2 = l.aIm(((din)localObject).TPU.fwr);
                  paramAnonymousView = "8$".concat(String.valueOf(str2));
                  localObject = ((din)localObject).TPU.TPZ;
                  str1 = "";
                  continue;
                  localObject = (din)localrt.SaO.getFirst();
                  str2 = l.aIm(((din)localObject).TPU.fwr);
                  paramAnonymousView = "7$".concat(String.valueOf(str2));
                  localObject = ((din)localObject).TPU.TPZ;
                  str1 = "";
                  continue;
                  localObject = (din)localrt.SaO.getFirst();
                  str2 = l.aIm(((din)localObject).TPU.fwr);
                  paramAnonymousView = "6$".concat(String.valueOf(str2));
                  localObject = ((din)localObject).TPU.TPZ;
                  str1 = "";
                }
              }
            });
            this.BPZ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112339);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
                if (!i.f(i.this)) {}
                for (int i = 1;; i = 2) {
                  try
                  {
                    paramAnonymousView = (rt)paramAnonymousView.getTag();
                    if (paramAnonymousView.rWu == 64)
                    {
                      localObject1 = (fiv)paramAnonymousView.SaJ.getFirst();
                      localObject2 = new xw();
                      ((xw)localObject2).fWN.userName = ((fiv)localObject1).UserName;
                      ((xw)localObject2).fWN.scene = 1027;
                      ((xw)localObject2).fWN.fvd = "2";
                      EventCenter.instance.publish((IEvent)localObject2);
                      localObject2 = l.aIm(((fiv)localObject1).RXU.fwr);
                      l.a(i.e(i.this), i, 1, i.d(i.this).ptD, i.d(i.this).BNX.BND, 27, "2$".concat(String.valueOf(localObject2)), ((fiv)localObject1).RXU.TPZ, ((fiv)localObject1).UserName);
                      i.d(i.this).BNX.BND.SJ(27);
                      i.a(i.this, paramAnonymousView.rWu, ((fiv)localObject1).RXU.TPZ, (String)localObject2, "", "", 0, "");
                      Log.i("MicroMsg.FTS.PardusSearchLogic", "click result weapp %s %s", new Object[] { ((fiv)localObject1).UserName, ((fiv)localObject1).RXU.TPZ });
                      i.this.SN(4);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(112339);
                      return;
                    }
                    if (paramAnonymousView.rWu == 1)
                    {
                      localObject1 = (po)paramAnonymousView.SaI.getFirst();
                      localObject2 = new JSONObject(((po)localObject1).RXV);
                      localObject3 = new Intent();
                      ((Intent)localObject3).putExtra("Contact_User", ((JSONObject)localObject2).optString("userName", ""));
                      ((Intent)localObject3).putExtra("Contact_Nick", ((JSONObject)localObject2).optString("nickName", ""));
                      ((Intent)localObject3).putExtra("Contact_Alias", ((JSONObject)localObject2).optString("aliasName", ""));
                      ((Intent)localObject3).putExtra("Contact_BrandIconURL", ((JSONObject)localObject2).optString("iconUrl", ""));
                      ((Intent)localObject3).putExtra("Contact_Signature", ((JSONObject)localObject2).optString("signature", ""));
                      ((Intent)localObject3).putExtra("Contact_VUser_Info_Flag", ((JSONObject)localObject2).optInt("verifyFlag", 0));
                      ((Intent)localObject3).putExtra("Contact_Scene", 3);
                      localObject4 = new aez();
                      ((aez)localObject4).mVM = ((JSONObject)localObject2).optInt("brandFlag", 0);
                      ((aez)localObject4).mVP = ((JSONObject)localObject2).optString("iconUrl", "");
                      ((aez)localObject4).mVO = ((JSONObject)localObject2).optString("brandInfo", "");
                      ((aez)localObject4).mVN = ((JSONObject)localObject2).optString("externalInfo", "");
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
                          ((Intent)localObject3).putExtra("Contact_customInfo", ((aez)localObject4).toByteArray());
                          Object localObject4 = new Bundle();
                          ((Bundle)localObject4).putString("Contact_Ext_Args_Search_Id", String.valueOf(i.a(i.this)));
                          ((Bundle)localObject4).putString("Contact_Ext_Args_Query_String", i.e(i.this));
                          ((Bundle)localObject4).putInt("Contact_Scene", 3);
                          ((Bundle)localObject4).putInt("Contact_Ext_Args_Index", 0);
                          ((Bundle)localObject4).putString("Contact_Ext_Extra_Params", "");
                          ((Intent)localObject3).putExtra("preChatTYPE", 10);
                          ((Intent)localObject3).putExtra("Contact_Ext_Args", (Bundle)localObject4);
                          com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject3);
                          Object localObject3 = l.aIm(((po)localObject1).RXU.fwr);
                          l.a(i.e(i.this), i, 1, i.d(i.this).ptD, i.d(i.this).BNX.BND, 27, "1$".concat(String.valueOf(localObject3)), ((po)localObject1).RXU.TPZ, "");
                          i.this.SN(4);
                          i.d(i.this).BNX.BND.SJ(27);
                          i.d(i.this).BNX.BNy = true;
                          i.a(i.this, paramAnonymousView.rWu, ((po)localObject1).RXU.TPZ, (String)localObject3, "", "", 0, "");
                          Log.i("MicroMsg.FTS.PardusSearchLogic", "click result biz %s %s", new Object[] { ((JSONObject)localObject2).optString("userName", ""), ((po)localObject1).RXU.TPZ });
                          continue;
                          paramAnonymousView = paramAnonymousView;
                          Log.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                        }
                      } while (paramAnonymousView.rWu != 5);
                      localObject1 = (din)paramAnonymousView.SaO.getFirst();
                      Object localObject2 = ((din)localObject1).TPV;
                      i.this.a((dio)localObject2);
                      localObject2 = l.aIm(((din)localObject1).TPU.fwr);
                      l.a(i.e(i.this), i, 1, i.d(i.this).ptD, i.d(i.this).BNX.BND, 27, "8$".concat(String.valueOf(localObject2)), ((din)localObject1).TPU.TPZ, "");
                      i.d(i.this).BNX.BND.SJ(27);
                      i.a(i.this, paramAnonymousView.rWu, ((din)localObject1).TPU.TPZ, (String)localObject2, "", "", 0, "");
                      Log.i("MicroMsg.FTS.PardusSearchLogic", "click result game %s %s", new Object[] { localObject2, ((din)localObject1).TPU.TPZ });
                    }
                    catch (IOException localIOException)
                    {
                      break label527;
                    }
                  }
                }
              }
            });
            this.BSv.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112340);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
                int i = 2;
                if (!i.f(i.this)) {
                  i = 1;
                }
                for (;;)
                {
                  try
                  {
                    paramAnonymousView = (rt)paramAnonymousView.getTag();
                    localObject1 = (aia)paramAnonymousView.SaK.getFirst();
                    if (((aia)localObject1).CNg != 1) {
                      continue;
                    }
                    localObject2 = new xw();
                    ((xw)localObject2).fWN.userName = ((aia)localObject1).UserName;
                    ((xw)localObject2).fWN.fWP = ((aia)localObject1).SsP;
                    ((xw)localObject2).fWN.appVersion = ((aia)localObject1).SsQ;
                    ((xw)localObject2).fWN.scene = 1027;
                    ((xw)localObject2).fWN.fvd = (((aia)localObject1).SsR + ":2");
                    EventCenter.instance.publish((IEvent)localObject2);
                    localObject2 = l.aIm(((aia)localObject1).RXU.fwr);
                    l.a(i.e(i.this), i, 1, i.d(i.this).ptD, i.d(i.this).BNX.BND, 27, "4$".concat(String.valueOf(localObject2)), ((aia)localObject1).RXU.TPZ, "");
                    i.this.SN(4);
                    i.d(i.this).BNX.BND.SJ(27);
                    i.d(i.this).BNX.BNy = true;
                    i.a(i.this, paramAnonymousView.rWu, ((aia)localObject1).RXU.TPZ, (String)localObject2, ((aia)localObject1).CMD, "", 0, "");
                    Log.i("MicroMsg.FTS.PardusSearchLogic", "click result article %s", new Object[] { ((aia)localObject1).RXU.TPZ });
                  }
                  catch (Exception paramAnonymousView)
                  {
                    Object localObject2;
                    Log.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                    continue;
                  }
                  i.this.SN(4);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112340);
                  return;
                  if (((aia)localObject1).CNg == 0)
                  {
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("rawUrl", ((aia)localObject1).CMD);
                    com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebviewMpUI", (Intent)localObject2);
                  }
                }
              }
            });
            this.BSH.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112341);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
                int i = 2;
                if (!i.f(i.this)) {
                  i = 1;
                }
                paramAnonymousView = (rt)paramAnonymousView.getTag();
                localObject1 = (din)paramAnonymousView.SaO.getFirst();
                Object localObject2 = ((din)localObject1).TPU.TPZ;
                if (com.tencent.mm.bb.a.bnx())
                {
                  com.tencent.mm.bb.f localf = com.tencent.mm.bb.a.bnA();
                  if ((localf.lVr == 9) && (localf.lVt.equals(localObject2)))
                  {
                    com.tencent.mm.bb.a.bnv();
                    i.g(i.this).setImageResource(o.f.pardus_music_video_icon);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(112341);
                    return;
                  }
                }
                localObject2 = ((o)com.tencent.mm.kernel.h.ae(o.class)).Xk(((din)paramAnonymousView.SaO.getFirst()).TPV.TPX);
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.bb.a.c(i.a(com.tencent.mm.kernel.h.aHG().kcB, (TimeLineObject)localObject2, ((din)localObject1).TPU.TPZ));
                i.g(i.this).setImageResource(o.f.pardus_music_pause_icon);
                localObject2 = l.aIm(((din)localObject1).TPU.fwr);
                l.a(i.e(i.this), i, 1, i.d(i.this).ptD, i.d(i.this).BNX.BND, 27, "7$".concat(String.valueOf(localObject2)), ((din)localObject1).TPU.TPZ, "");
                i.d(i.this).BNX.BND.SJ(27);
                i.a(i.this, paramAnonymousView.rWu, ((din)localObject1).TPU.TPZ, (String)localObject2, "", "", 0, "");
                Log.i("MicroMsg.FTS.PardusSearchLogic", "click music play %d %s %s", new Object[] { Integer.valueOf(7), localObject2, ((din)localObject1).TPU.TPZ });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112341);
              }
            });
            this.BSG.setOnClickListener(this.BSX);
            this.BSB.setOnClickListener(this.BSX);
            label867:
            if (this.fwi) {
              this.BMs = 2;
            }
            localObject1 = this.BSg.BNX.BND;
            if (!this.fwi) {}
            break;
          }
          break;
        }
      }
      for (j = 2;; j = 0)
      {
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).hy(i, j);
        if ((!this.BSQ) && (!this.fwi)) {
          break label2755;
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
        ((ValueAnimator)localObject1).addListener(new a(this.BNf));
        ((ValueAnimator)localObject1).setDuration(400L);
        ((ValueAnimator)localObject1).start();
        this.contentView.setVisibility(0);
        Log.i("MicroMsg.FTS.PardusSearchLogic", "updateHeaderView measureHeight:%s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(176933);
        return;
        localObject1 = (po)localrt.SaI.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.aHP(((po)localObject1).RXU.fwr);
        localObject3 = com.tencent.mm.plugin.fts.a.f.aHP(((po)localObject1).RXU.CMB);
        localObject2 = ((po)localObject1).RXU.CNj;
        str1 = ((po)localObject1).RXU.TQa;
        this.BSg.BNX.BND.a(k, System.currentTimeMillis(), "PardusMore", 1, ((po)localObject1).RXU.TPZ);
        this.BSg.BNX.BND.a(k + 1, System.currentTimeMillis(), ((po)localObject1).RXU.TPZ, 1, ((po)localObject1).RXU.TPZ);
        g(localrt.rWu, ((po)localObject1).RXU.TPZ, l.aIm(((po)localObject1).RXU.fwr), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject1 = (fiv)localrt.SaJ.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.aHP(((fiv)localObject1).RXU.fwr);
        localObject3 = com.tencent.mm.plugin.fts.a.f.aHP(((fiv)localObject1).RXU.CMB);
        localObject2 = ((fiv)localObject1).RXU.CNj;
        str1 = ((fiv)localObject1).RXU.TQa;
        this.BSg.BNX.BND.a(k, System.currentTimeMillis(), "PardusMore", 2, ((fiv)localObject1).RXU.TPZ);
        this.BSg.BNX.BND.a(k + 1, System.currentTimeMillis(), ((fiv)localObject1).RXU.TPZ, 2, ((fiv)localObject1).RXU.TPZ);
        g(localrt.rWu, ((fiv)localObject1).RXU.TPZ, l.aIm(((fiv)localObject1).RXU.fwr), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject5 = (aia)localrt.SaK.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.aHP(((aia)localObject5).RXU.fwr);
        localObject3 = com.tencent.mm.plugin.fts.a.f.aHP(((aia)localObject5).RXU.CMB);
        localObject2 = ((aia)localObject5).RXU.CNj;
        str1 = ((aia)localObject5).RXU.TQa;
        localObject1 = ((aia)localObject5).SsO;
        this.BSg.BNX.BND.a(k, System.currentTimeMillis(), "PardusMore", 4, ((aia)localObject5).RXU.TPZ);
        this.BSg.BNX.BND.a(k + 1, System.currentTimeMillis(), ((aia)localObject5).RXU.TPZ, 4, ((aia)localObject5).RXU.TPZ);
        g(localrt.rWu, ((aia)localObject5).RXU.TPZ, l.aIm(((aia)localObject5).RXU.fwr), "", "");
        localObject5 = "";
        break;
        din localdin = (din)localrt.SaO.getFirst();
        localObject5 = localdin.TPU.TPZ;
        localObject4 = com.tencent.mm.plugin.fts.a.f.aHP(localdin.TPU.fwr);
        localObject3 = com.tencent.mm.plugin.fts.a.f.aHP(localdin.TPU.CMB);
        localObject2 = localdin.TPU.CNj;
        str1 = localdin.TPU.TQa;
        j = localdin.TPU.Crq;
        if ((j <= 0) || (j >= 86400L))
        {
          str2 = null;
          j = 0;
          if (localrt.rWu != 5) {
            break label1782;
          }
          j = 8;
        }
        for (;;)
        {
          this.BSg.BNX.BND.a(k, System.currentTimeMillis(), "PardusMore", j, (String)localObject5);
          this.BSg.BNX.BND.a(k + 1, System.currentTimeMillis(), (String)localObject5, j, (String)localObject5);
          g(localrt.rWu, (String)localObject5, l.aIm(localdin.TPU.fwr), "", "");
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
          if (localrt.rWu == 4194304) {
            j = 6;
          } else if (localrt.rWu == 512) {
            j = 7;
          }
        }
        this.fwi = true;
        this.BSr.setVisibility(0);
        this.BPZ.setVisibility(0);
        this.BPZ.setTag(localrt);
        this.BSv.setVisibility(8);
        this.BSB.setVisibility(8);
        this.BSG.setVisibility(8);
        this.BSt.setText((CharSequence)localObject4);
        if (!Util.isNullOrNil((CharSequence)localObject3)) {
          if (this.BQa.getPaint().measureText(((CharSequence)localObject3).toString()) >= this.BSk)
          {
            this.BQa.setMaxLines(2);
            label1924:
            this.BQa.setText((CharSequence)localObject3);
            this.BQa.setVisibility(0);
            label1941:
            localObject1 = this.BSg.getContext();
            localObject3 = this.iZG;
            j = o.c.brand_default_head;
            if (localrt.rWu == 5) {
              break label2031;
            }
          }
        }
        label2031:
        for (boolean bool = true;; bool = false)
        {
          n.a((Context)localObject1, (ImageView)localObject3, (String)localObject2, null, j, bool);
          this.BSu.setText(str1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.BQa.setMaxLines(1);
          break label1924;
          this.BQa.setVisibility(8);
          break label1941;
        }
        this.fwi = true;
        this.BSr.setVisibility(0);
        this.BPZ.setVisibility(8);
        this.BSv.setVisibility(0);
        this.BSB.setVisibility(8);
        this.BSG.setVisibility(8);
        this.BSv.setTag(localrt);
        if (!Util.isNullOrNil((CharSequence)localObject4)) {
          if (!Util.isNullOrNil((String)localObject2))
          {
            this.BSx.setMaxLines(1);
            this.BSy.setMaxLines(2);
            this.BSw.setVisibility(0);
            localObject5 = new c.a();
            ((c.a)localObject5).lRC = true;
            ((c.a)localObject5).lRP = o.c.default_icon;
            ((c.a)localObject5).lRW = 1.0F;
            ((c.a)localObject5).kPz = true;
            localObject5 = ((c.a)localObject5).bmL();
            com.tencent.mm.ay.q.bml().a((String)localObject2, this.BSw, (com.tencent.mm.ay.a.a.c)localObject5);
            label2190:
            this.BSx.setText((CharSequence)localObject4);
            this.BSx.setVisibility(0);
            label2207:
            if (Util.isNullOrNil((CharSequence)localObject3)) {
              break label2349;
            }
            this.BSy.setText((CharSequence)localObject3);
            this.BSy.setVisibility(0);
          }
        }
        for (;;)
        {
          this.BSz.setText(str1);
          this.BSA.setText((CharSequence)localObject1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.BSw.setVisibility(8);
          if (this.BSx.getPaint().measureText(((CharSequence)localObject4).toString()) >= this.BSm)
          {
            this.BSx.setMaxLines(2);
            this.BSy.setMaxLines(1);
            break label2190;
          }
          this.BSx.setMaxLines(1);
          this.BSy.setMaxLines(2);
          break label2190;
          this.BSx.setVisibility(8);
          break label2207;
          label2349:
          this.BSy.setVisibility(8);
        }
        this.fwi = true;
        this.BSr.setVisibility(0);
        this.BPZ.setVisibility(8);
        this.BSv.setVisibility(8);
        this.BSG.setVisibility(8);
        this.BSB.setVisibility(0);
        this.BSB.setTag(localrt);
        this.BSE.setText((CharSequence)localObject4);
        this.BSF.setText(str1);
        this.BSD.setText(str2);
        localObject1 = new c.a();
        ((c.a)localObject1).lRC = true;
        ((c.a)localObject1).lRP = o.c.default_video_icon;
        ((c.a)localObject1).lRW = 1.0F;
        ((c.a)localObject1).kPz = true;
        localObject1 = ((c.a)localObject1).bmL();
        com.tencent.mm.ay.q.bml().a((String)localObject2, this.BSC, (com.tencent.mm.ay.a.a.c)localObject1);
        this.contentView.measure(-2147483648, 0);
        break label785;
        this.fwi = true;
        this.BSr.setVisibility(0);
        this.BPZ.setVisibility(8);
        this.BSv.setVisibility(8);
        this.BSB.setVisibility(8);
        this.BSG.setVisibility(0);
        this.BSG.setTag(localrt);
        this.BSH.setTag(localrt);
        this.BSJ.setText((CharSequence)localObject4);
        this.BSK.setText((CharSequence)localObject3);
        this.BSL.setText(str1);
        if ((com.tencent.mm.bb.a.bnx()) && (com.tencent.mm.bb.a.bnA().lVt.equals(localObject5))) {
          this.BSH.setImageResource(o.f.pardus_music_pause_icon);
        }
        for (;;)
        {
          localObject1 = new c.a();
          ((c.a)localObject1).lRC = true;
          ((c.a)localObject1).lRP = o.c.default_music_icon;
          ((c.a)localObject1).lRW = 1.0F;
          ((c.a)localObject1).kPz = true;
          localObject1 = ((c.a)localObject1).bmL();
          com.tencent.mm.ay.q.bml().a((String)localObject2, this.BSI, (com.tencent.mm.ay.a.a.c)localObject1);
          this.contentView.measure(-2147483648, 0);
          this.BSY.alive();
          break;
          this.BSH.setImageResource(o.f.pardus_music_video_icon);
        }
        this.BSr.setVisibility(8);
        this.contentView.measure(0, 0);
        break label867;
      }
      label2755:
      this.contentView.setVisibility(8);
      AppMethodBeat.o(176933);
      return;
    }
  }
  
  private String getSearchId()
  {
    AppMethodBeat.i(112366);
    if (this.BNd != null)
    {
      String str = this.BNd.Tky;
      AppMethodBeat.o(112366);
      return str;
    }
    long l = this.BNf;
    AppMethodBeat.o(112366);
    return String.valueOf(l);
  }
  
  private void hF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112363);
    this.BSg.BNX.BNy = true;
    if ((paramString1 == null) || (Util.isNullOrNil(paramString1.trim())))
    {
      AppMethodBeat.o(112363);
      return;
    }
    if (System.currentTimeMillis() - this.pZO <= 1000L)
    {
      AppMethodBeat.o(112363);
      return;
    }
    this.pZO = System.currentTimeMillis();
    long l = e.BHi;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneActionType", "1");
    localHashMap.put("parentSearchID", paramString2);
    localHashMap.put("clickType", "17");
    ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a(this.BSg.getContext(), 3, paramString1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(112363);
  }
  
  public final void N(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184533);
    String str = "";
    if (this.BNd != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.BNd.Tky, paramString2, Long.valueOf(this.BNf) });
    }
    paramString2 = new HashMap();
    paramString2.put("prefixSug", this.query);
    if (!Util.isNullOrNil(str)) {
      paramString2.put("parentSearchID", str);
    }
    paramString2.put("sceneActionType", "6");
    l(paramString2, paramString1);
    AppMethodBeat.o(184533);
  }
  
  public final void SN(int paramInt)
  {
    AppMethodBeat.i(184532);
    if ((!this.BSS) && (!Util.isNullOrNil(this.query)))
    {
      ar.u(this.query, this.BMs, paramInt, 3);
      this.BSS = true;
    }
    AppMethodBeat.o(184532);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(112367);
    Log.i("MicroMsg.FTS.PardusSearchLogic", "change status from %s to %s", new Object[] { this.BSO, paramb });
    this.BSO = paramb;
    AppMethodBeat.o(112367);
  }
  
  public final void a(dio paramdio)
  {
    AppMethodBeat.i(176934);
    switch (paramdio.RXp)
    {
    }
    for (;;)
    {
      SN(4);
      AppMethodBeat.o(176934);
      return;
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramdio.CMD);
      com.tencent.mm.by.c.b(this.BSg, "webview", ".ui.tools.WebviewMpUI", (Intent)localObject1);
      continue;
      localObject1 = new xw();
      ((xw)localObject1).fWN.userName = paramdio.UserName;
      ((xw)localObject1).fWN.fWP = paramdio.SsP;
      ((xw)localObject1).fWN.appVersion = paramdio.SsQ;
      ((xw)localObject1).fWN.fvd = paramdio.SsR;
      EventCenter.instance.publish((IEvent)localObject1);
      continue;
      localObject1 = paramdio.query;
      Object localObject2 = paramdio.TPY;
      paramdio = new HashMap();
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        Iterator localIterator = ((JSONObject)localObject2).keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramdio.put(str, ((JSONObject)localObject2).optString(str));
        }
      }
      catch (Exception localException)
      {
        ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a(this.BSg, 3, (String)localObject1, String.valueOf(e.BHi), paramdio);
      }
    }
  }
  
  public final void cVU()
  {
    AppMethodBeat.i(112360);
    if (!this.fwi)
    {
      this.BNa.removeAllViews();
      LinkedList localLinkedList;
      if ((this.BNd == null) || (this.BNd.TQh == null)) {
        localLinkedList = null;
      }
      while ((!this.BSQ) && (localLinkedList != null) && (localLinkedList.size() > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < localLinkedList.size())
          {
            epl localepl = (epl)localLinkedList.get(i);
            amw localamw = new amw();
            localamw.SwV = localepl;
            localamw.CqR = i;
            View localView = this.BSg.getLayoutInflater().inflate(o.e.fts_websearch_relevant_item, this.BNa, false);
            localView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112337);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                paramAnonymousView = (amw)paramAnonymousView.getTag();
                if (paramAnonymousView.SwV.CNg == 3) {
                  if ((paramAnonymousView.SwV.Usk != null) && (!Util.isNullOrNil(paramAnonymousView.SwV.Usk.Ap()))) {
                    i.hG(paramAnonymousView.SwV.Usk.Ap(), i.e(i.this));
                  }
                }
                for (;;)
                {
                  localObject = i.d(i.this).BNX.BND;
                  l.a(i.e(i.this), i.d(i.this).BNX.getCount(), i.d(i.this).ptD, (com.tencent.mm.plugin.fts.ui.c.b)localObject, 23);
                  i.d(i.this).BNX.BNy = true;
                  if (!i.d(i.this).BNX.BNo)
                  {
                    i.d(i.this).BNX.BNo = true;
                    l.a(paramAnonymousView.SwV.TSb, true, i.d(i.this).BNX.getCount(), 0, (com.tencent.mm.plugin.fts.ui.c.b)localObject);
                  }
                  i.this.SN(7);
                  ar.ano(3);
                  i.d(i.this).BNX.BND.SJ(23);
                  i.a(i.this, 0, "", "", "", "", paramAnonymousView.CqR + 1, paramAnonymousView.SwV.TPZ);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112337);
                  return;
                  Log.e("MicroMsg.FTS.PardusSearchLogic", "updateFooterView, fts h5 relatedItem.Item.JumpType = " + paramAnonymousView.SwV.CNg + ", but JumpUrl = " + paramAnonymousView.SwV.Usk);
                  continue;
                  i.this.N(paramAnonymousView.SwV.TSb, 7, paramAnonymousView.SwV.TPZ);
                }
              }
            });
            ((TextView)localView.findViewById(o.d.content)).setText(localepl.TSb);
            localView.setTag(localamw);
            this.BNa.addView(localView);
            i += 1;
            continue;
            localLinkedList = this.BNd.TQh.RLp;
            break;
          }
        }
        this.BSg.BNX.BND.hz(localLinkedList.size(), 1);
        this.BNa.setVisibility(0);
        this.BSg.BNX.BND.fi(localLinkedList);
      }
      for (;;)
      {
        this.BMX.setVisibility(0);
        this.BMY.setVisibility(0);
        this.BSg.BNX.BND.esa();
        AppMethodBeat.o(112360);
        return;
        this.BSg.BNX.BND.hz(0, 1);
        this.BNa.setVisibility(8);
      }
    }
    this.BSg.BNX.BND.hz(0, 0);
    this.BMY.setVisibility(8);
    this.BMX.setVisibility(8);
    AppMethodBeat.o(112360);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(112353);
    this.BSO = b.BTd;
    this.BMs = 1;
    this.BNf = 0L;
    this.BMI = 0L;
    this.BJO = 0L;
    this.BSP = false;
    this.BSQ = false;
    this.fwi = false;
    this.BSS = false;
    this.query = null;
    this.BNd = null;
    this.BSY.dead();
    if (this.BSM != null) {
      this.BSM.clearData();
    }
    AppMethodBeat.o(112353);
  }
  
  public final View eaA()
  {
    AppMethodBeat.i(112361);
    if (this.BMW == null)
    {
      this.BMW = this.BSg.getLayoutInflater().inflate(o.e.fts_web_search_footer, null, false);
      this.BMY = this.BMW.findViewById(o.d.web_search_bar_layout);
      this.BMX = this.BMW.findViewById(o.d.web_search_layout);
      this.BMZ = this.BMW.findViewById(o.d.web_search_divider);
      this.BNb = ((TextView)this.BMW.findViewById(o.d.web_search_title_tv));
      this.BNc = ((TextView)this.BMW.findViewById(o.d.web_search_desc_tv));
      this.BNa = ((LinearLayout)this.BMX.findViewById(o.d.relevant_search_layout));
    }
    try
    {
      Object localObject = ak.biP("webSearchBar").optString("wording");
      Log.i("MicroMsg.FTS.PardusSearchLogic", "set searchNetworkTips %s", new Object[] { localObject });
      this.BNc.setText((CharSequence)localObject);
      label163:
      this.BMY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(112333);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!WeChatBrands.Business.Entries.ContextSearch.checkAvailable(paramAnonymousView.getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(112333);
            return;
          }
          i.d(i.this).BNX.BNy = true;
          if (!i.d(i.this).BNX.BNo)
          {
            i.d(i.this).BNX.BNo = true;
            l.a(i.e(i.this), true, i.d(i.this).BNX.getCount(), 0, i.d(i.this).BNX.BND);
          }
          i.this.ev(i.e(i.this), 15);
          i.d(i.this).BNX.BNy = true;
          i.this.SN(2);
          ar.ano(3);
          i.d(i.this).BNX.BND.SJ(18);
          l.a(i.e(i.this), i.d(i.this).BNX.getCount(), i.d(i.this).ptD, i.d(i.this).BNX.BND, 18);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112333);
        }
      });
      localObject = this.BMW;
      AppMethodBeat.o(112361);
      return localObject;
    }
    catch (Exception localException)
    {
      break label163;
    }
  }
  
  public final void eqZ()
  {
    AppMethodBeat.i(112352);
    this.BQX.removeMessages(1);
    if (this.BSN != null)
    {
      com.tencent.mm.kernel.h.aGY().a(this.BSN);
      com.tencent.mm.kernel.h.aGY().b(1076, this);
      this.BSN = null;
    }
    AppMethodBeat.o(112352);
  }
  
  public final void esC()
  {
    AppMethodBeat.i(112356);
    if (this.BST != null)
    {
      com.tencent.mm.kernel.h.aGY().a(this.BST);
      com.tencent.mm.kernel.h.aGY().b(1417, this);
      this.BST = null;
    }
    AppMethodBeat.o(112356);
  }
  
  @TargetApi(8)
  public final void esD()
  {
    AppMethodBeat.i(112357);
    if (this.contentView != null)
    {
      this.BSg.rP(true);
      this.contentView.clearAnimation();
      this.contentView.setVisibility(8);
    }
    if (this.BNa != null)
    {
      this.BNa.removeAllViews();
      this.BNa.setVisibility(8);
    }
    if (this.BMX != null) {
      this.BMX.setVisibility(8);
    }
    if (this.BMY != null) {
      this.BMY.setVisibility(8);
    }
    if (this.BSM != null) {
      this.BSM.esF();
    }
    AppMethodBeat.o(112357);
  }
  
  public final void ev(String paramString, int paramInt)
  {
    AppMethodBeat.i(176935);
    String str = "";
    if (this.BNd != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.BNd.Tky, paramString, Long.valueOf(this.BNf) });
    }
    hF(paramString, str);
    AppMethodBeat.o(176935);
  }
  
  public final void g(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(112365);
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("pardussearch=expose&searchid=");
      localStringBuffer.append(getSearchId());
      localStringBuffer.append("&query=");
      localStringBuffer.append(com.tencent.mm.compatible.util.q.an(this.query, "utf8"));
      localStringBuffer.append("&type=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&docid=");
      localStringBuffer.append(paramString1);
      localStringBuffer.append("&title=");
      localStringBuffer.append(com.tencent.mm.compatible.util.q.an(paramString2, "utf8"));
      localStringBuffer.append("&clienttimestamp=");
      localStringBuffer.append(System.currentTimeMillis());
      localStringBuffer.append("&sug=");
      localStringBuffer.append(com.tencent.mm.compatible.util.q.an(paramString3, "utf8"));
      localStringBuffer.append("&relatedsug=");
      localStringBuffer.append(com.tencent.mm.compatible.util.q.an(paramString4, "utf8"));
      Log.i("MicroMsg.FTS.PardusSearchLogic", "realtimeSearchExposeReport %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new dxu();
      paramString1.Udk = localStringBuffer.toString();
      paramString1 = new ad(paramString1);
      com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
      AppMethodBeat.o(112365);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramString1, "realtimeSearchExposeReport", new Object[0]);
      AppMethodBeat.o(112365);
    }
  }
  
  public final void h(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112362);
    if ((paramBoolean2) || (paramInt != 0)) {
      this.BMZ.setVisibility(0);
    }
    for (;;)
    {
      if ((paramBoolean1) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQV, 0) == 0)) {
        cVU();
      }
      AppMethodBeat.o(112362);
      return;
      this.BMZ.setVisibility(8);
    }
  }
  
  public final void l(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(176936);
    this.BSg.BNX.BNy = true;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176936);
      return;
    }
    if (System.currentTimeMillis() - this.pZO <= 1000L)
    {
      AppMethodBeat.o(176936);
      return;
    }
    this.pZO = System.currentTimeMillis();
    long l = e.BHi;
    paramMap.put("clickType", "7");
    ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a(this.BSg.getContext(), paramString, String.valueOf(l), paramMap);
    AppMethodBeat.o(176936);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112354);
    Log.i("MicroMsg.FTS.PardusSearchLogic", "onFocusChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      esB();
    }
    AppMethodBeat.o(112354);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    int i = 0;
    AppMethodBeat.i(112359);
    boolean bool;
    if (paramq.equals(this.BST))
    {
      com.tencent.mm.kernel.h.aGY().b(1417, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.BSV = this.BST.PxR.TPT;
        Log.i("MicroMsg.FTS.PardusSearchLogic", "pardusCacheExpireTime %d", new Object[] { Long.valueOf(this.BSV) });
        AppMethodBeat.o(112359);
      }
    }
    else if ((paramq.equals(this.BSN)) && (this.BSN.PxT.Tkx.equals(String.valueOf(this.BNf))))
    {
      a(b.BTf);
      this.BQX.removeMessages(1);
      com.tencent.mm.kernel.h.aGY().b(1076, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label389;
      }
      l.U(this.BNf, 4);
      this.BNd = this.BSN.PxS;
      if ((this.BNd == null) || (Util.isNullOrNil(this.BNd.TQi))) {
        break label359;
      }
      bool = true;
    }
    for (;;)
    {
      this.BSR = bool;
      bool = this.BSR;
      paramInt2 = this.BNd.TQd.size();
      label230:
      String str;
      if (this.BNd.TwM == null)
      {
        paramInt1 = i;
        Log.i("MicroMsg.FTS.PardusSearchLogic", "searchResponse hasWebViewResult %b result:%d sug:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        if (!this.BSP)
        {
          if (!this.BSR) {
            break label382;
          }
          paramString = this.BSM;
          str = this.BNd.TQi;
          paramString.fOc = this.query;
          paramq = new JSONObject();
        }
      }
      try
      {
        paramq.put("info", str);
        label321:
        paramString.BNE.BSg.runOnUiThread(new j.1(paramString, paramq));
        for (;;)
        {
          if (!this.BSR) {
            cVU();
          }
          AppMethodBeat.o(112359);
          return;
          label359:
          bool = false;
          break;
          paramInt1 = this.BNd.TwM.RLp.size();
          break label230;
          label382:
          esE();
          continue;
          label389:
          l.U(this.BNf, 5);
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
    private long BTc;
    
    public a(long paramLong)
    {
      this.BTc = paramLong;
    }
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(176932);
      Log.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationEnd listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.BTc), Long.valueOf(i.a(i.this)) });
      if (this.BTc == i.a(i.this))
      {
        i.d(i.this).rP(true);
        if (i.i(i.this) == i.b.BTg)
        {
          i.this.a(i.b.BTh);
          l.U(i.a(i.this), 7);
        }
      }
      AppMethodBeat.o(176932);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(176931);
      Log.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationStart listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.BTc), Long.valueOf(i.a(i.this)) });
      if (this.BTc == i.a(i.this))
      {
        i.d(i.this).rP(false);
        i.this.a(i.b.BTg);
        l.U(i.a(i.this), 6);
      }
      AppMethodBeat.o(176931);
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(112350);
      BTd = new b("None", 0);
      BTe = new b("StartSearch", 1);
      BTf = new b("ReturnResult", 2);
      BTg = new b("StartAnimation", 3);
      BTh = new b("ShowResult", 4);
      BTi = new b("Timeout", 5);
      BTj = new b[] { BTd, BTe, BTf, BTg, BTh, BTi };
      AppMethodBeat.o(112350);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.i
 * JD-Core Version:    0.7.0.1
 */