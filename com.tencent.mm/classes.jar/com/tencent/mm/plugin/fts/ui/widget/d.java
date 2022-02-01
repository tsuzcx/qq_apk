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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.cvr;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.protocal.protobuf.qx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public final class d
  implements View.OnFocusChangeListener, com.tencent.mm.al.f
{
  public View contentView;
  public boolean dlh;
  public ImageView fOf;
  public long lND;
  public String query;
  public ap tCW;
  public View tCk;
  public TextView tCl;
  public FTSMainUI tDV;
  public View tDW;
  private int tDX;
  private int tDY;
  private int tDZ;
  public r tEA;
  public b tEB;
  public boolean tEC;
  public boolean tED;
  private boolean tEE;
  private boolean tEF;
  private com.tencent.mm.plugin.websearch.api.q tEG;
  private long tEH;
  private long tEI;
  private View.OnClickListener tEJ;
  private View.OnClickListener tEK;
  private com.tencent.mm.sdk.b.c<mf> tEL;
  public View tEa;
  public TextView tEb;
  public TextView tEc;
  public TextView tEd;
  public View tEe;
  public View tEf;
  public TextView tEg;
  public TextView tEh;
  public View tEi;
  public ImageView tEj;
  public TextView tEk;
  public TextView tEl;
  public TextView tEm;
  public TextView tEn;
  public View tEo;
  public ImageView tEp;
  public TextView tEq;
  public TextView tEr;
  public TextView tEs;
  public View tEt;
  public ImageView tEu;
  public ImageView tEv;
  public TextView tEw;
  public TextView tEx;
  public TextView tEy;
  public e tEz;
  private long twc;
  public int tyD;
  public long tyS;
  private View tzg;
  private View tzh;
  public View tzi;
  private View tzj;
  public LinearLayout tzk;
  public TextView tzl;
  private TextView tzm;
  private cie tzn;
  public long tzp;
  
  public d(FTSMainUI paramFTSMainUI)
  {
    AppMethodBeat.i(112351);
    this.tDX = 0;
    this.tDY = 0;
    this.tDZ = 0;
    this.tEB = b.tEO;
    this.tEC = false;
    this.tED = false;
    this.dlh = false;
    this.tEE = false;
    this.tEF = false;
    this.tyD = 1;
    this.tCW = new ap(Looper.getMainLooper())
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
          if (paramAnonymousMessage.obj.equals(Long.valueOf(d.a(d.this))))
          {
            d.this.a(d.b.tET);
            d.a(d.this, System.currentTimeMillis());
            ad.i("MicroMsg.FTS.PardusSearchLogic", "cancel Time %d", new Object[] { Long.valueOf(d.b(d.this) - d.c(d.this)) });
            l.O(d.a(d.this), 5);
            d.this.cSS();
            d.this.chU();
          }
        }
      }
    };
    this.tEI = 60L;
    this.tEJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112336);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = (aix)paramAnonymousView.getTag();
        d.this.A(paramAnonymousView.Gga.HdP, 22, paramAnonymousView.Gga.HbR);
        d.d(d.this).tAf.tzH = true;
        l.a(d.e(d.this), 1, 1, d.d(d.this).ljZ, d.d(d.this).tAf.tzM, 28, "", "", "");
        d.d(d.this).tAf.tzM.GY(28);
        d.a(d.this, 0, "", "", "", paramAnonymousView.Gga.HbR, paramAnonymousView.FCk + 1, "");
        d.this.Hc(6);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112336);
      }
    };
    this.tEK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112343);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        paramAnonymousView = (qx)paramAnonymousView.getTag();
        switch (paramAnonymousView.nEf)
        {
        default: 
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112343);
          return;
        }
        int j = 2;
        if (!d.f(d.this)) {
          j = 1;
        }
        localObject1 = (cia)paramAnonymousView.FMP.getFirst();
        Object localObject2 = ((cia)localObject1).HbO;
        d.this.a((cib)localObject2);
        int i;
        if (paramAnonymousView.nEf == 512) {
          i = 7;
        }
        for (;;)
        {
          localObject2 = l.akO(((cia)localObject1).HbN.Title);
          l.a(d.e(d.this), j, 1, d.d(d.this).ljZ, d.d(d.this).tAf.tzM, 27, i + "$" + (String)localObject2, ((cia)localObject1).HbN.HbR, "");
          d.d(d.this).tAf.tzM.GY(27);
          d.a(d.this, paramAnonymousView.nEf, ((cia)localObject1).HbN.HbR, (String)localObject2, "", "", 0, "");
          ad.i("MicroMsg.FTS.PardusSearchLogic", "click result %d %s %s", new Object[] { Integer.valueOf(i), localObject2, ((cia)localObject1).HbN.HbR });
          break;
          if (paramAnonymousView.nEf == 4194304) {
            i = 6;
          } else {
            i = 0;
          }
        }
      }
    };
    this.tEL = new com.tencent.mm.sdk.b.c() {};
    this.tDV = paramFTSMainUI;
    this.tDX = (com.tencent.mm.cc.a.ip(paramFTSMainUI.getContext()) - com.tencent.mm.cc.a.fromDPToPix(paramFTSMainUI.getContext(), 100));
    this.tDY = (com.tencent.mm.cc.a.ip(paramFTSMainUI.getContext()) - com.tencent.mm.cc.a.fromDPToPix(paramFTSMainUI.getContext(), 116));
    this.tDZ = (com.tencent.mm.cc.a.ip(paramFTSMainUI.getContext()) - com.tencent.mm.cc.a.fromDPToPix(paramFTSMainUI.getContext(), 48));
    cUn();
    AppMethodBeat.o(112351);
  }
  
  public static com.tencent.mm.az.f a(String paramString1, TimeLineObject paramTimeLineObject, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(112368);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.HAT == null) || (paramTimeLineObject.HAT.GaQ == null) || (paramTimeLineObject.HAT.GaQ.size() <= 0))
    {
      AppMethodBeat.o(112368);
      return null;
    }
    byn localbyn = (byn)paramTimeLineObject.HAT.GaQ.get(0);
    if (localbyn == null)
    {
      AppMethodBeat.o(112368);
      return null;
    }
    com.tencent.mm.az.f localf = new com.tencent.mm.az.f();
    localf.ihe = 9;
    localf.ihg = paramString2;
    localf.ihh = 0.0F;
    localf.ihk = "";
    if (!TextUtils.isEmpty(localbyn.songAlbumUrl)) {
      localf.ihx = localbyn.songAlbumUrl;
    }
    localf.ihl = localbyn.GSI;
    localf.ihq = null;
    localf.ihf = 1;
    localf.ihp = localbyn.songLyric;
    localf.ihi = localbyn.Title;
    localf.ihj = localbyn.Desc;
    paramString2 = localObject;
    if (paramTimeLineObject.HAT != null) {
      paramString2 = paramTimeLineObject.HAT.Url;
    }
    localf.iho = paramString2;
    localf.ihn = localbyn.GSM;
    localf.ihm = localbyn.Url;
    localf.ihu = localbyn.GSJ;
    localf.ihw = localbyn.Id;
    localf.ihr = paramString1;
    localf.iht = paramTimeLineObject.HAS.Id;
    localf.ihA = paramTimeLineObject.nDo;
    localf.ihH = paramTimeLineObject.Id;
    AppMethodBeat.o(112368);
    return localf;
  }
  
  private void cUn()
  {
    AppMethodBeat.i(112355);
    if (System.currentTimeMillis() - this.tEH > this.tEI * 1000L)
    {
      ad.i("MicroMsg.FTS.PardusSearchLogic", "start to request pre search");
      cUo();
      this.tEG = new com.tencent.mm.plugin.websearch.api.q(new chy());
      g.aiU().a(1417, this);
      g.aiU().a(this.tEG, 0);
      this.tEH = System.currentTimeMillis();
    }
    AppMethodBeat.o(112355);
  }
  
  @SuppressLint({"ResourceType"})
  private void cUq()
  {
    AppMethodBeat.i(176933);
    Object localObject1;
    int j;
    Object localObject2;
    int i;
    if ((this.tzn == null) || (this.tzn.HbW == null))
    {
      localObject1 = null;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label523;
      }
      this.tED = true;
      this.tEa.setVisibility(0);
      j = ((dla)((List)localObject1).get(0)).HdP.length() + 0;
      localObject2 = new aix();
      ((aix)localObject2).Gga = ((dla)((List)localObject1).get(0));
      ((aix)localObject2).FCk = 0;
      this.tEb.setTag(localObject2);
      this.tEb.setText(((dla)((List)localObject1).get(0)).HdP);
      this.tEb.setOnClickListener(this.tEJ);
      this.tEb.setVisibility(0);
      this.tDV.tAf.tzM.p(System.currentTimeMillis(), "PardusSug");
      if (((List)localObject1).size() <= 1) {
        break label485;
      }
      j += ((dla)((List)localObject1).get(1)).HdP.length();
      this.tEc.setOnClickListener(this.tEJ);
      localObject2 = new aix();
      ((aix)localObject2).Gga = ((dla)((List)localObject1).get(1));
      ((aix)localObject2).FCk = 1;
      this.tEc.setTag(localObject2);
      this.tEc.setText(((dla)((List)localObject1).get(1)).HdP);
      this.tEc.setVisibility(0);
      i = 2;
      label286:
      if (((List)localObject1).size() <= 2) {
        break label511;
      }
      if (((dla)((List)localObject1).get(2)).HdP.length() + j > 24) {
        break label499;
      }
      this.tEd.setOnClickListener(this.tEJ);
      localObject2 = new aix();
      ((aix)localObject2).Gga = ((dla)((List)localObject1).get(2));
      ((aix)localObject2).FCk = 2;
      this.tEd.setTag(localObject2);
      this.tEd.setText(((dla)((List)localObject1).get(2)).HdP);
      this.tEd.setVisibility(0);
      i += 1;
    }
    label523:
    for (;;)
    {
      label405:
      if (this.tED)
      {
        localObject2 = "";
        j = 0;
        for (;;)
        {
          if (j < i)
          {
            localObject2 = (String)localObject2 + ((dla)((List)localObject1).get(j)).HbR + "_";
            j += 1;
            continue;
            localObject1 = this.tzn.HbW.Fys;
            break;
            label485:
            this.tEc.setVisibility(8);
            i = 1;
            break label286;
            label499:
            this.tEd.setVisibility(8);
            break label405;
            label511:
            this.tEd.setVisibility(8);
            break label405;
            this.tEa.setVisibility(8);
            i = 0;
            break label405;
          }
        }
        e(0, "", "", (String)localObject2, "");
      }
    }
    int k = 2;
    if (!this.tED) {
      k = 1;
    }
    if (this.tzn.HbX.size() > 0) {}
    for (qx localqx = (qx)this.tzn.HbX.getFirst();; localqx = null)
    {
      Object localObject4;
      String str2;
      Object localObject5;
      String str1;
      Object localObject3;
      if (localqx != null)
      {
        localObject4 = "";
        localObject2 = "";
        str2 = "";
        this.tEf.setTag(localqx);
        switch (localqx.nEf)
        {
        default: 
          localObject5 = "";
          localObject1 = "";
          str1 = "";
          localObject3 = "";
          switch (localqx.nEf)
          {
          default: 
            this.dlh = false;
            this.tEe.setVisibility(8);
            this.contentView.measure(-2147483648, 0);
            label785:
            this.tEf.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112338);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
                d.this.dF(d.e(d.this), 21);
                qx localqx = (qx)paramAnonymousView.getTag();
                paramAnonymousView = "";
                localObject = "";
                String str1;
                String str2;
                switch (localqx.nEf)
                {
                default: 
                  str1 = "";
                  str2 = "";
                }
                for (;;)
                {
                  int i = 2;
                  if (!d.f(d.this)) {
                    i = 1;
                  }
                  l.a(d.e(d.this), i, 2, d.d(d.this).ljZ, d.d(d.this).tAf.tzM, 27, paramAnonymousView, (String)localObject, "");
                  d.d(d.this).tAf.tzM.GY(27);
                  d.d(d.this).tAf.tzH = true;
                  d.a(d.this, localqx.nEf, "more", str2, str1, "", 0, "");
                  d.this.Hc(5);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112338);
                  return;
                  localObject = (ot)localqx.FMJ.getFirst();
                  str2 = l.akO(((ot)localObject).FKc.Title);
                  paramAnonymousView = "1$".concat(String.valueOf(str2));
                  localObject = ((ot)localObject).FKc.HbR;
                  str1 = "";
                  continue;
                  localObject = (ecf)localqx.FMK.getFirst();
                  str2 = l.akO(((ecf)localObject).FKc.Title);
                  paramAnonymousView = "2$".concat(String.valueOf(str2));
                  localObject = ((ecf)localObject).FKc.HbR;
                  str1 = "";
                  continue;
                  localObject = (aez)localqx.FML.getFirst();
                  str1 = ((aez)localObject).ueY;
                  str2 = l.akO(((aez)localObject).FKc.Title);
                  paramAnonymousView = "4$".concat(String.valueOf(str2));
                  localObject = ((aez)localObject).FKc.HbR;
                  continue;
                  localObject = (cia)localqx.FMP.getFirst();
                  str2 = l.akO(((cia)localObject).HbN.Title);
                  paramAnonymousView = "8$".concat(String.valueOf(str2));
                  localObject = ((cia)localObject).HbN.HbR;
                  str1 = "";
                  continue;
                  localObject = (cia)localqx.FMP.getFirst();
                  str2 = l.akO(((cia)localObject).HbN.Title);
                  paramAnonymousView = "7$".concat(String.valueOf(str2));
                  localObject = ((cia)localObject).HbN.HbR;
                  str1 = "";
                  continue;
                  localObject = (cia)localqx.FMP.getFirst();
                  str2 = l.akO(((cia)localObject).HbN.Title);
                  paramAnonymousView = "6$".concat(String.valueOf(str2));
                  localObject = ((cia)localObject).HbN.HbR;
                  str1 = "";
                }
              }
            });
            this.tCk.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112339);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
                if (!d.f(d.this)) {}
                for (int i = 1;; i = 2) {
                  try
                  {
                    paramAnonymousView = (qx)paramAnonymousView.getTag();
                    if (paramAnonymousView.nEf == 64)
                    {
                      localObject1 = (ecf)paramAnonymousView.FMK.getFirst();
                      localObject2 = new vm();
                      ((vm)localObject2).dJF.userName = ((ecf)localObject1).nDo;
                      ((vm)localObject2).dJF.scene = 1027;
                      ((vm)localObject2).dJF.dkh = "2";
                      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
                      localObject2 = l.akO(((ecf)localObject1).FKc.Title);
                      l.a(d.e(d.this), i, 1, d.d(d.this).ljZ, d.d(d.this).tAf.tzM, 27, "2$".concat(String.valueOf(localObject2)), ((ecf)localObject1).FKc.HbR, ((ecf)localObject1).nDo);
                      d.d(d.this).tAf.tzM.GY(27);
                      d.a(d.this, paramAnonymousView.nEf, ((ecf)localObject1).FKc.HbR, (String)localObject2, "", "", 0, "");
                      ad.i("MicroMsg.FTS.PardusSearchLogic", "click result weapp %s %s", new Object[] { ((ecf)localObject1).nDo, ((ecf)localObject1).FKc.HbR });
                      d.this.Hc(4);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(112339);
                      return;
                    }
                    if (paramAnonymousView.nEf == 1)
                    {
                      localObject1 = (ot)paramAnonymousView.FMJ.getFirst();
                      localObject2 = new JSONObject(((ot)localObject1).FKd);
                      localObject3 = new Intent();
                      ((Intent)localObject3).putExtra("Contact_User", ((JSONObject)localObject2).optString("userName", ""));
                      ((Intent)localObject3).putExtra("Contact_Nick", ((JSONObject)localObject2).optString("nickName", ""));
                      ((Intent)localObject3).putExtra("Contact_Alias", ((JSONObject)localObject2).optString("aliasName", ""));
                      ((Intent)localObject3).putExtra("Contact_BrandIconURL", ((JSONObject)localObject2).optString("iconUrl", ""));
                      ((Intent)localObject3).putExtra("Contact_Signature", ((JSONObject)localObject2).optString("signature", ""));
                      ((Intent)localObject3).putExtra("Contact_VUser_Info_Flag", ((JSONObject)localObject2).optInt("verifyFlag", 0));
                      ((Intent)localObject3).putExtra("Contact_Scene", 3);
                      localObject4 = new acf();
                      ((acf)localObject4).jdq = ((JSONObject)localObject2).optInt("brandFlag", 0);
                      ((acf)localObject4).jdt = ((JSONObject)localObject2).optString("iconUrl", "");
                      ((acf)localObject4).jds = ((JSONObject)localObject2).optString("brandInfo", "");
                      ((acf)localObject4).jdr = ((JSONObject)localObject2).optString("externalInfo", "");
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
                          ((Intent)localObject3).putExtra("Contact_customInfo", ((acf)localObject4).toByteArray());
                          Object localObject4 = new Bundle();
                          ((Bundle)localObject4).putString("Contact_Ext_Args_Search_Id", String.valueOf(d.a(d.this)));
                          ((Bundle)localObject4).putString("Contact_Ext_Args_Query_String", d.e(d.this));
                          ((Bundle)localObject4).putInt("Contact_Scene", 3);
                          ((Bundle)localObject4).putInt("Contact_Ext_Args_Index", 0);
                          ((Bundle)localObject4).putString("Contact_Ext_Extra_Params", "");
                          ((Intent)localObject3).putExtra("preChatTYPE", 10);
                          ((Intent)localObject3).putExtra("Contact_Ext_Args", (Bundle)localObject4);
                          com.tencent.mm.bs.d.b(aj.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject3);
                          Object localObject3 = l.akO(((ot)localObject1).FKc.Title);
                          l.a(d.e(d.this), i, 1, d.d(d.this).ljZ, d.d(d.this).tAf.tzM, 27, "1$".concat(String.valueOf(localObject3)), ((ot)localObject1).FKc.HbR, "");
                          d.this.Hc(4);
                          d.d(d.this).tAf.tzM.GY(27);
                          d.d(d.this).tAf.tzH = true;
                          d.a(d.this, paramAnonymousView.nEf, ((ot)localObject1).FKc.HbR, (String)localObject3, "", "", 0, "");
                          ad.i("MicroMsg.FTS.PardusSearchLogic", "click result biz %s %s", new Object[] { ((JSONObject)localObject2).optString("userName", ""), ((ot)localObject1).FKc.HbR });
                          continue;
                          paramAnonymousView = paramAnonymousView;
                          ad.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                        }
                      } while (paramAnonymousView.nEf != 5);
                      localObject1 = (cia)paramAnonymousView.FMP.getFirst();
                      Object localObject2 = ((cia)localObject1).HbO;
                      d.this.a((cib)localObject2);
                      localObject2 = l.akO(((cia)localObject1).HbN.Title);
                      l.a(d.e(d.this), i, 1, d.d(d.this).ljZ, d.d(d.this).tAf.tzM, 27, "8$".concat(String.valueOf(localObject2)), ((cia)localObject1).HbN.HbR, "");
                      d.d(d.this).tAf.tzM.GY(27);
                      d.a(d.this, paramAnonymousView.nEf, ((cia)localObject1).HbN.HbR, (String)localObject2, "", "", 0, "");
                      ad.i("MicroMsg.FTS.PardusSearchLogic", "click result game %s %s", new Object[] { localObject2, ((cia)localObject1).HbN.HbR });
                    }
                    catch (IOException localIOException)
                    {
                      break label527;
                    }
                  }
                }
              }
            });
            this.tEi.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112340);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
                int i = 2;
                if (!d.f(d.this)) {
                  i = 1;
                }
                for (;;)
                {
                  try
                  {
                    paramAnonymousView = (qx)paramAnonymousView.getTag();
                    localObject1 = (aez)paramAnonymousView.FML.getFirst();
                    if (((aez)localObject1).ugz != 1) {
                      continue;
                    }
                    localObject2 = new vm();
                    ((vm)localObject2).dJF.userName = ((aez)localObject1).nDo;
                    ((vm)localObject2).dJF.dJH = ((aez)localObject1).Gde;
                    ((vm)localObject2).dJF.aDD = ((aez)localObject1).Gdf;
                    ((vm)localObject2).dJF.scene = 1027;
                    ((vm)localObject2).dJF.dkh = (((aez)localObject1).Gdg + ":2");
                    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
                    localObject2 = l.akO(((aez)localObject1).FKc.Title);
                    l.a(d.e(d.this), i, 1, d.d(d.this).ljZ, d.d(d.this).tAf.tzM, 27, "4$".concat(String.valueOf(localObject2)), ((aez)localObject1).FKc.HbR, "");
                    d.this.Hc(4);
                    d.d(d.this).tAf.tzM.GY(27);
                    d.d(d.this).tAf.tzH = true;
                    d.a(d.this, paramAnonymousView.nEf, ((aez)localObject1).FKc.HbR, (String)localObject2, ((aez)localObject1).ueY, "", 0, "");
                    ad.i("MicroMsg.FTS.PardusSearchLogic", "click result article %s", new Object[] { ((aez)localObject1).FKc.HbR });
                  }
                  catch (Exception paramAnonymousView)
                  {
                    Object localObject2;
                    ad.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                    continue;
                  }
                  d.this.Hc(4);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112340);
                  return;
                  if (((aez)localObject1).ugz == 0)
                  {
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("rawUrl", ((aez)localObject1).ueY);
                    com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebviewMpUI", (Intent)localObject2);
                  }
                }
              }
            });
            this.tEu.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112341);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
                int i = 2;
                if (!d.f(d.this)) {
                  i = 1;
                }
                paramAnonymousView = (qx)paramAnonymousView.getTag();
                localObject1 = (cia)paramAnonymousView.FMP.getFirst();
                Object localObject2 = ((cia)localObject1).HbN.HbR;
                if (com.tencent.mm.az.a.aJG())
                {
                  com.tencent.mm.az.f localf = com.tencent.mm.az.a.aJJ();
                  if ((localf.ihe == 9) && (localf.ihg.equals(localObject2)))
                  {
                    com.tencent.mm.az.a.aJE();
                    d.g(d.this).setImageResource(2131691022);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(112341);
                    return;
                  }
                }
                localObject2 = ((com.tencent.mm.plugin.sns.b.n)g.ab(com.tencent.mm.plugin.sns.b.n.class)).Gx(((cia)paramAnonymousView.FMP.getFirst()).HbO.HbQ);
                g.ajD();
                com.tencent.mm.az.a.c(d.a(g.ajC().gBm, (TimeLineObject)localObject2, ((cia)localObject1).HbN.HbR));
                d.g(d.this).setImageResource(2131691021);
                localObject2 = l.akO(((cia)localObject1).HbN.Title);
                l.a(d.e(d.this), i, 1, d.d(d.this).ljZ, d.d(d.this).tAf.tzM, 27, "7$".concat(String.valueOf(localObject2)), ((cia)localObject1).HbN.HbR, "");
                d.d(d.this).tAf.tzM.GY(27);
                d.a(d.this, paramAnonymousView.nEf, ((cia)localObject1).HbN.HbR, (String)localObject2, "", "", 0, "");
                ad.i("MicroMsg.FTS.PardusSearchLogic", "click music play %d %s %s", new Object[] { Integer.valueOf(7), localObject2, ((cia)localObject1).HbN.HbR });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112341);
              }
            });
            this.tEt.setOnClickListener(this.tEK);
            this.tEo.setOnClickListener(this.tEK);
            label867:
            if (this.dlh) {
              this.tyD = 2;
            }
            localObject1 = this.tDV.tAf.tzM;
            if (!this.dlh) {}
            break;
          }
          break;
        }
      }
      for (j = 2;; j = 0)
      {
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).gg(i, j);
        if ((!this.tED) && (!this.dlh)) {
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
            ad.i("MicroMsg.FTS.PardusSearchLogic", "native onAnimationUpdate %d", new Object[] { Integer.valueOf(i) });
            d.h(d.this).getLayoutParams().height = i;
            d.h(d.this).requestLayout();
            AppMethodBeat.o(176930);
          }
        });
        ((ValueAnimator)localObject1).addListener(new a(this.tzp));
        ((ValueAnimator)localObject1).setDuration(400L);
        ((ValueAnimator)localObject1).start();
        this.contentView.setVisibility(0);
        ad.i("MicroMsg.FTS.PardusSearchLogic", "updateHeaderView measureHeight:%s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(176933);
        return;
        localObject1 = (ot)localqx.FMJ.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.akt(((ot)localObject1).FKc.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.akt(((ot)localObject1).FKc.Desc);
        localObject2 = ((ot)localObject1).FKc.IconUrl;
        str1 = ((ot)localObject1).FKc.HbS;
        this.tDV.tAf.tzM.a(k, System.currentTimeMillis(), "PardusMore", 1, ((ot)localObject1).FKc.HbR);
        this.tDV.tAf.tzM.a(k + 1, System.currentTimeMillis(), ((ot)localObject1).FKc.HbR, 1, ((ot)localObject1).FKc.HbR);
        e(localqx.nEf, ((ot)localObject1).FKc.HbR, l.akO(((ot)localObject1).FKc.Title), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject1 = (ecf)localqx.FMK.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.akt(((ecf)localObject1).FKc.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.akt(((ecf)localObject1).FKc.Desc);
        localObject2 = ((ecf)localObject1).FKc.IconUrl;
        str1 = ((ecf)localObject1).FKc.HbS;
        this.tDV.tAf.tzM.a(k, System.currentTimeMillis(), "PardusMore", 2, ((ecf)localObject1).FKc.HbR);
        this.tDV.tAf.tzM.a(k + 1, System.currentTimeMillis(), ((ecf)localObject1).FKc.HbR, 2, ((ecf)localObject1).FKc.HbR);
        e(localqx.nEf, ((ecf)localObject1).FKc.HbR, l.akO(((ecf)localObject1).FKc.Title), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject5 = (aez)localqx.FML.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.akt(((aez)localObject5).FKc.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.akt(((aez)localObject5).FKc.Desc);
        localObject2 = ((aez)localObject5).FKc.IconUrl;
        str1 = ((aez)localObject5).FKc.HbS;
        localObject1 = ((aez)localObject5).Gdd;
        this.tDV.tAf.tzM.a(k, System.currentTimeMillis(), "PardusMore", 4, ((aez)localObject5).FKc.HbR);
        this.tDV.tAf.tzM.a(k + 1, System.currentTimeMillis(), ((aez)localObject5).FKc.HbR, 4, ((aez)localObject5).FKc.HbR);
        e(localqx.nEf, ((aez)localObject5).FKc.HbR, l.akO(((aez)localObject5).FKc.Title), "", "");
        localObject5 = "";
        break;
        cia localcia = (cia)localqx.FMP.getFirst();
        localObject5 = localcia.HbN.HbR;
        localObject4 = com.tencent.mm.plugin.fts.a.f.akt(localcia.HbN.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.akt(localcia.HbN.Desc);
        localObject2 = localcia.HbN.IconUrl;
        str1 = localcia.HbN.HbS;
        j = localcia.HbN.tSt;
        if ((j <= 0) || (j >= 86400L))
        {
          str2 = null;
          j = 0;
          if (localqx.nEf != 5) {
            break label1782;
          }
          j = 8;
        }
        for (;;)
        {
          this.tDV.tAf.tzM.a(k, System.currentTimeMillis(), "PardusMore", j, (String)localObject5);
          this.tDV.tAf.tzM.a(k + 1, System.currentTimeMillis(), (String)localObject5, j, (String)localObject5);
          e(localqx.nEf, (String)localObject5, l.akO(localcia.HbN.Title), "", "");
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
          if (localqx.nEf == 4194304) {
            j = 6;
          } else if (localqx.nEf == 512) {
            j = 7;
          }
        }
        this.dlh = true;
        this.tEe.setVisibility(0);
        this.tCk.setVisibility(0);
        this.tCk.setTag(localqx);
        this.tEi.setVisibility(8);
        this.tEo.setVisibility(8);
        this.tEt.setVisibility(8);
        this.tEg.setText((CharSequence)localObject4);
        if (!bt.ai((CharSequence)localObject3)) {
          if (this.tCl.getPaint().measureText(((CharSequence)localObject3).toString()) >= this.tDX)
          {
            this.tCl.setMaxLines(2);
            label1924:
            this.tCl.setText((CharSequence)localObject3);
            this.tCl.setVisibility(0);
            label1941:
            localObject1 = this.tDV.getContext();
            localObject3 = this.fOf;
            if (localqx.nEf == 5) {
              break label2029;
            }
          }
        }
        label2029:
        for (boolean bool = true;; bool = false)
        {
          com.tencent.mm.plugin.fts.ui.n.a((Context)localObject1, (ImageView)localObject3, (String)localObject2, null, 2131231342, bool);
          this.tEh.setText(str1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.tCl.setMaxLines(1);
          break label1924;
          this.tCl.setVisibility(8);
          break label1941;
        }
        this.dlh = true;
        this.tEe.setVisibility(0);
        this.tCk.setVisibility(8);
        this.tEi.setVisibility(0);
        this.tEo.setVisibility(8);
        this.tEt.setVisibility(8);
        this.tEi.setTag(localqx);
        if (!bt.ai((CharSequence)localObject4)) {
          if (!bt.isNullOrNil((String)localObject2))
          {
            this.tEk.setMaxLines(1);
            this.tEl.setMaxLines(2);
            this.tEj.setVisibility(0);
            localObject5 = new c.a();
            ((c.a)localObject5).idq = true;
            ((c.a)localObject5).idD = 2131231879;
            ((c.a)localObject5).idK = 1.0F;
            ((c.a)localObject5).hfi = true;
            localObject5 = ((c.a)localObject5).aJc();
            com.tencent.mm.aw.q.aIJ().a((String)localObject2, this.tEj, (com.tencent.mm.aw.a.a.c)localObject5);
            label2188:
            this.tEk.setText((CharSequence)localObject4);
            this.tEk.setVisibility(0);
            label2205:
            if (bt.ai((CharSequence)localObject3)) {
              break label2347;
            }
            this.tEl.setText((CharSequence)localObject3);
            this.tEl.setVisibility(0);
          }
        }
        for (;;)
        {
          this.tEm.setText(str1);
          this.tEn.setText((CharSequence)localObject1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.tEj.setVisibility(8);
          if (this.tEk.getPaint().measureText(((CharSequence)localObject4).toString()) >= this.tDZ)
          {
            this.tEk.setMaxLines(2);
            this.tEl.setMaxLines(1);
            break label2188;
          }
          this.tEk.setMaxLines(1);
          this.tEl.setMaxLines(2);
          break label2188;
          this.tEk.setVisibility(8);
          break label2205;
          label2347:
          this.tEl.setVisibility(8);
        }
        this.dlh = true;
        this.tEe.setVisibility(0);
        this.tCk.setVisibility(8);
        this.tEi.setVisibility(8);
        this.tEt.setVisibility(8);
        this.tEo.setVisibility(0);
        this.tEo.setTag(localqx);
        this.tEr.setText((CharSequence)localObject4);
        this.tEs.setText(str1);
        this.tEq.setText(str2);
        localObject1 = new c.a();
        ((c.a)localObject1).idq = true;
        ((c.a)localObject1).idD = 2131231884;
        ((c.a)localObject1).idK = 1.0F;
        ((c.a)localObject1).hfi = true;
        localObject1 = ((c.a)localObject1).aJc();
        com.tencent.mm.aw.q.aIJ().a((String)localObject2, this.tEp, (com.tencent.mm.aw.a.a.c)localObject1);
        this.contentView.measure(-2147483648, 0);
        break label785;
        this.dlh = true;
        this.tEe.setVisibility(0);
        this.tCk.setVisibility(8);
        this.tEi.setVisibility(8);
        this.tEo.setVisibility(8);
        this.tEt.setVisibility(0);
        this.tEt.setTag(localqx);
        this.tEu.setTag(localqx);
        this.tEw.setText((CharSequence)localObject4);
        this.tEx.setText((CharSequence)localObject3);
        this.tEy.setText(str1);
        if ((com.tencent.mm.az.a.aJG()) && (com.tencent.mm.az.a.aJJ().ihg.equals(localObject5))) {
          this.tEu.setImageResource(2131691021);
        }
        for (;;)
        {
          localObject1 = new c.a();
          ((c.a)localObject1).idq = true;
          ((c.a)localObject1).idD = 2131231882;
          ((c.a)localObject1).idK = 1.0F;
          ((c.a)localObject1).hfi = true;
          localObject1 = ((c.a)localObject1).aJc();
          com.tencent.mm.aw.q.aIJ().a((String)localObject2, this.tEv, (com.tencent.mm.aw.a.a.c)localObject1);
          this.contentView.measure(-2147483648, 0);
          this.tEL.alive();
          break;
          this.tEu.setImageResource(2131691022);
        }
        this.tEe.setVisibility(8);
        this.contentView.measure(0, 0);
        break label867;
      }
      label2753:
      this.contentView.setVisibility(8);
      AppMethodBeat.o(176933);
      return;
    }
  }
  
  private void gN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112363);
    this.tDV.tAf.tzH = true;
    if ((paramString1 == null) || (bt.isNullOrNil(paramString1.trim())))
    {
      AppMethodBeat.o(112363);
      return;
    }
    if (System.currentTimeMillis() - this.lND <= 1000L)
    {
      AppMethodBeat.o(112363);
      return;
    }
    this.lND = System.currentTimeMillis();
    long l = com.tencent.mm.plugin.fts.a.e.ttw;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneActionType", "1");
    localHashMap.put("parentSearchID", paramString2);
    localHashMap.put("clickType", "17");
    ((h)g.ab(h.class)).a(this.tDV.getContext(), 3, paramString1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(112363);
  }
  
  private String getSearchId()
  {
    AppMethodBeat.i(112366);
    if (this.tzn != null)
    {
      String str = this.tzn.GRx;
      AppMethodBeat.o(112366);
      return str;
    }
    long l = this.tzp;
    AppMethodBeat.o(112366);
    return String.valueOf(l);
  }
  
  public final void A(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184533);
    String str = "";
    if (this.tzn != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.tzn.GRx, paramString2, Long.valueOf(this.tzp) });
    }
    paramString2 = new HashMap();
    paramString2.put("prefixSug", this.query);
    if (!bt.isNullOrNil(str)) {
      paramString2.put("parentSearchID", str);
    }
    paramString2.put("sceneActionType", "6");
    l(paramString2, paramString1);
    AppMethodBeat.o(184533);
  }
  
  public final void Hc(int paramInt)
  {
    AppMethodBeat.i(184532);
    if ((!this.tEF) && (!bt.isNullOrNil(this.query)))
    {
      am.p(this.query, this.tyD, paramInt, 3);
      this.tEF = true;
    }
    AppMethodBeat.o(184532);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(112367);
    ad.i("MicroMsg.FTS.PardusSearchLogic", "change status from %s to %s", new Object[] { this.tEB, paramb });
    this.tEB = paramb;
    AppMethodBeat.o(112367);
  }
  
  public final void a(cib paramcib)
  {
    AppMethodBeat.i(176934);
    switch (paramcib.FJz)
    {
    }
    for (;;)
    {
      Hc(4);
      AppMethodBeat.o(176934);
      return;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramcib.ueY);
      com.tencent.mm.bs.d.b(this.tDV, "webview", ".ui.tools.WebviewMpUI", (Intent)localObject);
      continue;
      localObject = new vm();
      ((vm)localObject).dJF.userName = paramcib.nDo;
      ((vm)localObject).dJF.dJH = paramcib.Gde;
      ((vm)localObject).dJF.aDD = paramcib.Gdf;
      ((vm)localObject).dJF.dkh = paramcib.Gdg;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
  }
  
  public final View cJS()
  {
    AppMethodBeat.i(112361);
    if (this.tzg == null)
    {
      this.tzg = this.tDV.getLayoutInflater().inflate(2131494224, null, false);
      this.tzi = this.tzg.findViewById(2131306903);
      this.tzh = this.tzg.findViewById(2131306906);
      this.tzj = this.tzg.findViewById(2131306905);
      this.tzl = ((TextView)this.tzg.findViewById(2131306907));
      this.tzm = ((TextView)this.tzg.findViewById(2131306904));
      this.tzk = ((LinearLayout)this.tzh.findViewById(2131303971));
    }
    try
    {
      Object localObject = af.aFP("webSearchBar").optString("wording");
      ad.i("MicroMsg.FTS.PardusSearchLogic", "set searchNetworkTips %s", new Object[] { localObject });
      this.tzm.setText((CharSequence)localObject);
      label163:
      this.tzi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(112333);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          d.d(d.this).tAf.tzH = true;
          if (!d.d(d.this).tAf.tzy)
          {
            d.d(d.this).tAf.tzy = true;
            l.a(d.e(d.this), true, d.d(d.this).tAf.getCount(), 0, d.d(d.this).tAf.tzM);
          }
          d.this.dF(d.e(d.this), 15);
          d.d(d.this).tAf.tzH = true;
          d.this.Hc(2);
          am.Wl(3);
          d.d(d.this).tAf.tzM.GY(18);
          l.a(d.e(d.this), d.d(d.this).tAf.getCount(), d.d(d.this).ljZ, d.d(d.this).tAf.tzM, 18);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112333);
        }
      });
      localObject = this.tzg;
      AppMethodBeat.o(112361);
      return localObject;
    }
    catch (Exception localException)
    {
      break label163;
    }
  }
  
  public final void cSS()
  {
    AppMethodBeat.i(112352);
    this.tCW.removeMessages(1);
    if (this.tEA != null)
    {
      g.aiU().a(this.tEA);
      g.aiU().b(1076, this);
      this.tEA = null;
    }
    AppMethodBeat.o(112352);
  }
  
  public final void cUo()
  {
    AppMethodBeat.i(112356);
    if (this.tEG != null)
    {
      g.aiU().a(this.tEG);
      g.aiU().b(1417, this);
      this.tEG = null;
    }
    AppMethodBeat.o(112356);
  }
  
  @TargetApi(8)
  public final void cUp()
  {
    AppMethodBeat.i(112357);
    if (this.contentView != null)
    {
      this.tDV.mJ(true);
      this.contentView.clearAnimation();
      this.contentView.setVisibility(8);
    }
    if (this.tzk != null)
    {
      this.tzk.removeAllViews();
      this.tzk.setVisibility(8);
    }
    if (this.tzh != null) {
      this.tzh.setVisibility(8);
    }
    if (this.tzi != null) {
      this.tzi.setVisibility(8);
    }
    if (this.tEz != null) {
      this.tEz.cUr();
    }
    AppMethodBeat.o(112357);
  }
  
  public final void chU()
  {
    AppMethodBeat.i(112360);
    if (!this.dlh)
    {
      this.tzk.removeAllViews();
      LinkedList localLinkedList;
      if ((this.tzn == null) || (this.tzn.Hcb == null)) {
        localLinkedList = null;
      }
      while ((!this.tED) && (localLinkedList != null) && (localLinkedList.size() > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < localLinkedList.size())
          {
            dla localdla = (dla)localLinkedList.get(i);
            aix localaix = new aix();
            localaix.Gga = localdla;
            localaix.FCk = i;
            View localView = this.tDV.getLayoutInflater().inflate(2131494228, this.tzk, false);
            localView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112337);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
                paramAnonymousView = (aix)paramAnonymousView.getTag();
                d.this.A(paramAnonymousView.Gga.HdP, 7, paramAnonymousView.Gga.HbR);
                localObject = d.d(d.this).tAf.tzM;
                l.a(d.e(d.this), d.d(d.this).tAf.getCount(), d.d(d.this).ljZ, (com.tencent.mm.plugin.fts.ui.c.b)localObject, 23);
                d.d(d.this).tAf.tzH = true;
                if (!d.d(d.this).tAf.tzy)
                {
                  d.d(d.this).tAf.tzy = true;
                  l.a(paramAnonymousView.Gga.HdP, true, d.d(d.this).tAf.getCount(), 0, (com.tencent.mm.plugin.fts.ui.c.b)localObject);
                }
                d.this.Hc(7);
                am.Wl(3);
                d.d(d.this).tAf.tzM.GY(23);
                d.a(d.this, 0, "", "", "", "", paramAnonymousView.FCk + 1, paramAnonymousView.Gga.HbR);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112337);
              }
            });
            ((TextView)localView.findViewById(2131298739)).setText(localdla.HdP);
            localView.setTag(localaix);
            this.tzk.addView(localView);
            i += 1;
            continue;
            localLinkedList = this.tzn.Hcb.Fys;
            break;
          }
        }
        this.tDV.tAf.tzM.gh(localLinkedList.size(), 1);
        this.tzk.setVisibility(0);
        this.tDV.tAf.tzM.dW(localLinkedList);
      }
      for (;;)
      {
        this.tzh.setVisibility(0);
        this.tzi.setVisibility(0);
        this.tDV.tAf.tzM.cTL();
        AppMethodBeat.o(112360);
        return;
        this.tDV.tAf.tzM.gh(0, 1);
        this.tzk.setVisibility(8);
      }
    }
    this.tDV.tAf.tzM.gh(0, 0);
    this.tzi.setVisibility(8);
    this.tzh.setVisibility(8);
    AppMethodBeat.o(112360);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(112353);
    this.tEB = b.tEO;
    this.tyD = 1;
    this.tzp = 0L;
    this.tyS = 0L;
    this.twc = 0L;
    this.tEC = false;
    this.tED = false;
    this.dlh = false;
    this.tEF = false;
    this.query = null;
    this.tzn = null;
    this.tEL.dead();
    if (this.tEz != null) {
      this.tEz.clearData();
    }
    AppMethodBeat.o(112353);
  }
  
  public final void dF(String paramString, int paramInt)
  {
    AppMethodBeat.i(176935);
    String str = "";
    if (this.tzn != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.tzn.GRx, paramString, Long.valueOf(this.tzp) });
    }
    gN(paramString, str);
    AppMethodBeat.o(176935);
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
      ad.i("MicroMsg.FTS.PardusSearchLogic", "realtimeSearchExposeReport %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new cup();
      paramString1.Hmu = localStringBuffer.toString();
      paramString1 = new z(paramString1);
      g.aiU().a(paramString1, 0);
      AppMethodBeat.o(112365);
      return;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramString1, "realtimeSearchExposeReport", new Object[0]);
      AppMethodBeat.o(112365);
    }
  }
  
  public final void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112362);
    if ((paramBoolean2) || (paramInt != 0)) {
      this.tzj.setVisibility(0);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class);
        b.a locala = b.a.qDu;
        com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
        if (localb.a(locala, com.tencent.mm.util.c.fNJ()) == 0) {
          chU();
        }
      }
      AppMethodBeat.o(112362);
      return;
      this.tzj.setVisibility(8);
    }
  }
  
  public final void l(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(176936);
    this.tDV.tAf.tzH = true;
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176936);
      return;
    }
    if (System.currentTimeMillis() - this.lND <= 1000L)
    {
      AppMethodBeat.o(176936);
      return;
    }
    this.lND = System.currentTimeMillis();
    long l = com.tencent.mm.plugin.fts.a.e.ttw;
    paramMap.put("clickType", "7");
    ((h)g.ab(h.class)).a(this.tDV.getContext(), paramString, String.valueOf(l), paramMap);
    AppMethodBeat.o(176936);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112354);
    ad.i("MicroMsg.FTS.PardusSearchLogic", "onFocusChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      cUn();
    }
    AppMethodBeat.o(112354);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    int i = 0;
    AppMethodBeat.i(112359);
    boolean bool;
    label230:
    Object localObject;
    if (paramn.equals(this.tEG))
    {
      g.aiU().b(1417, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.tEI = this.tEG.DAW.HbM;
        ad.i("MicroMsg.FTS.PardusSearchLogic", "pardusCacheExpireTime %d", new Object[] { Long.valueOf(this.tEI) });
        AppMethodBeat.o(112359);
      }
    }
    else if ((paramn.equals(this.tEA)) && (this.tEA.DAY.HbT.equals(String.valueOf(this.tzp))))
    {
      a(b.tEQ);
      this.tCW.removeMessages(1);
      g.aiU().b(1076, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label412;
      }
      l.O(this.tzp, 4);
      this.tzn = this.tEA.DAX;
      if ((this.tzn == null) || (bt.isNullOrNil(this.tzn.Hcc))) {
        break label333;
      }
      bool = true;
      this.tEE = bool;
      bool = this.tEE;
      paramInt2 = this.tzn.HbX.size();
      if (this.tzn.HbW != null) {
        break label339;
      }
      paramInt1 = i;
      ad.i("MicroMsg.FTS.PardusSearchLogic", "searchResponse hasWebViewResult %b result:%d sug:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (!this.tEC)
      {
        if (!this.tEE) {
          break label405;
        }
        paramString = this.tEz;
        paramn = this.tzn.Hcc;
        localObject = this.query;
        if (paramString.tEX) {
          break label356;
        }
        ad.i("MicroMsg.FTS.PardusWebViewLogic", "webview not ready");
      }
    }
    for (;;)
    {
      if (!this.tEE) {
        chU();
      }
      AppMethodBeat.o(112359);
      return;
      label333:
      bool = false;
      break;
      label339:
      paramInt1 = this.tzn.HbW.Fys.size();
      break label230;
      label356:
      paramString.dBF = ((String)localObject);
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("info", paramn);
        label382:
        paramString.tzN.tDV.runOnUiThread(new e.1(paramString, (JSONObject)localObject));
        continue;
        label405:
        cUq();
        continue;
        label412:
        l.O(this.tzp, 5);
      }
      catch (Exception paramn)
      {
        break label382;
      }
    }
  }
  
  final class a
    implements Animator.AnimatorListener
  {
    private long tEN;
    
    public a(long paramLong)
    {
      this.tEN = paramLong;
    }
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(176932);
      ad.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationEnd listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.tEN), Long.valueOf(d.a(d.this)) });
      if (this.tEN == d.a(d.this))
      {
        d.d(d.this).mJ(true);
        if (d.i(d.this) == d.b.tER)
        {
          d.this.a(d.b.tES);
          l.O(d.a(d.this), 7);
        }
      }
      AppMethodBeat.o(176932);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(176931);
      ad.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationStart listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.tEN), Long.valueOf(d.a(d.this)) });
      if (this.tEN == d.a(d.this))
      {
        d.d(d.this).mJ(false);
        d.this.a(d.b.tER);
        l.O(d.a(d.this), 6);
      }
      AppMethodBeat.o(176931);
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(112350);
      tEO = new b("None", 0);
      tEP = new b("StartSearch", 1);
      tEQ = new b("ReturnResult", 2);
      tER = new b("StartAnimation", 3);
      tES = new b("ShowResult", 4);
      tET = new b("Timeout", 5);
      tEU = new b[] { tEO, tEP, tEQ, tER, tES, tET };
      AppMethodBeat.o(112350);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */