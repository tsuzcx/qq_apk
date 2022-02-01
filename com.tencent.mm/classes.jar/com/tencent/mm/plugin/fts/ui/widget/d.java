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
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.j;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.protocal.protobuf.byi;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.clf;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.protocal.protobuf.dac;
import com.tencent.mm.protocal.protobuf.dqo;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.protocal.protobuf.zh;
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
  implements View.OnFocusChangeListener, com.tencent.mm.al.g
{
  public View contentView;
  public boolean dcq;
  public ImageView frr;
  public long kOJ;
  public String query;
  private long rqH;
  public int rti;
  public long rty;
  public View rwy;
  public TextView rwz;
  public long rxi;
  public ap rxl;
  public TextView ryA;
  public TextView ryB;
  public TextView ryC;
  public View ryD;
  public ImageView ryE;
  public TextView ryF;
  public TextView ryG;
  public TextView ryH;
  public View ryI;
  public ImageView ryJ;
  public ImageView ryK;
  public TextView ryL;
  public TextView ryM;
  public TextView ryN;
  public e ryO;
  private byk ryP;
  public com.tencent.mm.plugin.websearch.api.p ryQ;
  public b ryR;
  public boolean ryS;
  public boolean ryT;
  private boolean ryU;
  private boolean ryV;
  private com.tencent.mm.plugin.websearch.api.o ryW;
  private long ryX;
  private long ryY;
  private View.OnClickListener ryZ;
  public FTSMainUI ryk;
  public View ryl;
  private int rym;
  private int ryn;
  private int ryo;
  public View ryp;
  public TextView ryq;
  public TextView ryr;
  public TextView rys;
  public View ryt;
  public View ryu;
  public TextView ryv;
  public TextView ryw;
  public View ryx;
  public ImageView ryy;
  public TextView ryz;
  private View.OnClickListener rza;
  private View rzb;
  private View rzc;
  public View rzd;
  private View rze;
  public LinearLayout rzf;
  public TextView rzg;
  private TextView rzh;
  private com.tencent.mm.sdk.b.c<ln> rzi;
  
  public d(FTSMainUI paramFTSMainUI)
  {
    AppMethodBeat.i(112351);
    this.rym = 0;
    this.ryn = 0;
    this.ryo = 0;
    this.ryR = b.rzl;
    this.ryS = false;
    this.ryT = false;
    this.dcq = false;
    this.ryU = false;
    this.ryV = false;
    this.rti = 1;
    this.rxl = new ap(Looper.getMainLooper())
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
            d.this.a(d.b.rzq);
            d.a(d.this, System.currentTimeMillis());
            ad.i("MicroMsg.FTS.PardusSearchLogic", "cancel Time %d", new Object[] { Long.valueOf(d.b(d.this) - d.c(d.this)) });
            k.H(d.a(d.this), 5);
            d.this.cxr();
            d.this.bWe();
          }
        }
      }
    };
    this.ryY = 60L;
    this.ryZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112336);
        paramAnonymousView = (afi)paramAnonymousView.getTag();
        d.this.A(paramAnonymousView.Dfi.EgD, 22, paramAnonymousView.Dfi.DUZ);
        d.d(d.this).ruy.rtZ = true;
        k.a(d.e(d.this), 1, 1, d.d(d.this).kme, d.d(d.this).ruy.rue, 28, "", "", "");
        d.d(d.this).ruy.rue.DN(28);
        d.a(d.this, 0, "", "", "", paramAnonymousView.Dfi.DUZ, paramAnonymousView.CEo + 1, "");
        d.this.DR(6);
        AppMethodBeat.o(112336);
      }
    };
    this.rza = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112343);
        paramAnonymousView = (pl)paramAnonymousView.getTag();
        switch (paramAnonymousView.mBH)
        {
        default: 
          AppMethodBeat.o(112343);
          return;
        }
        int j = 2;
        if (!d.f(d.this)) {
          j = 1;
        }
        byg localbyg = (byg)paramAnonymousView.CNO.getFirst();
        Object localObject = localbyg.DUW;
        d.this.a((byh)localObject);
        int i;
        if (paramAnonymousView.mBH == 512) {
          i = 7;
        }
        for (;;)
        {
          localObject = k.aby(localbyg.DUV.Title);
          k.a(d.e(d.this), j, 1, d.d(d.this).kme, d.d(d.this).ruy.rue, 27, i + "$" + (String)localObject, localbyg.DUV.DUZ, "");
          d.d(d.this).ruy.rue.DN(27);
          d.a(d.this, paramAnonymousView.mBH, localbyg.DUV.DUZ, (String)localObject, "", "", 0, "");
          ad.i("MicroMsg.FTS.PardusSearchLogic", "click result %d %s %s", new Object[] { Integer.valueOf(i), localObject, localbyg.DUV.DUZ });
          break;
          if (paramAnonymousView.mBH == 4194304) {
            i = 6;
          } else {
            i = 0;
          }
        }
      }
    };
    this.rzi = new com.tencent.mm.sdk.b.c() {};
    this.ryk = paramFTSMainUI;
    this.rym = (com.tencent.mm.cd.a.hV(paramFTSMainUI.getContext()) - com.tencent.mm.cd.a.fromDPToPix(paramFTSMainUI.getContext(), 100));
    this.ryn = (com.tencent.mm.cd.a.hV(paramFTSMainUI.getContext()) - com.tencent.mm.cd.a.fromDPToPix(paramFTSMainUI.getContext(), 116));
    this.ryo = (com.tencent.mm.cd.a.hV(paramFTSMainUI.getContext()) - com.tencent.mm.cd.a.fromDPToPix(paramFTSMainUI.getContext(), 48));
    cyI();
    AppMethodBeat.o(112351);
  }
  
  public static com.tencent.mm.az.f a(String paramString1, TimeLineObject paramTimeLineObject, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(112368);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.Etm == null) || (paramTimeLineObject.Etm.DaC == null) || (paramTimeLineObject.Etm.DaC.size() <= 0))
    {
      AppMethodBeat.o(112368);
      return null;
    }
    bpi localbpi = (bpi)paramTimeLineObject.Etm.DaC.get(0);
    if (localbpi == null)
    {
      AppMethodBeat.o(112368);
      return null;
    }
    com.tencent.mm.az.f localf = new com.tencent.mm.az.f();
    localf.hnn = 9;
    localf.hnp = paramString2;
    localf.hnq = 0.0F;
    localf.hnt = "";
    if (!TextUtils.isEmpty(localbpi.songAlbumUrl)) {
      localf.hnG = localbpi.songAlbumUrl;
    }
    localf.hnu = localbpi.DMQ;
    localf.hnz = null;
    localf.hno = 1;
    localf.hny = localbpi.songLyric;
    localf.hnr = localbpi.Title;
    localf.hns = localbpi.Desc;
    paramString2 = localObject;
    if (paramTimeLineObject.Etm != null) {
      paramString2 = paramTimeLineObject.Etm.Url;
    }
    localf.hnx = paramString2;
    localf.hnw = localbpi.DMU;
    localf.hnv = localbpi.Url;
    localf.hnD = localbpi.DMR;
    localf.hnF = localbpi.Id;
    localf.hnA = paramString1;
    localf.hnC = paramTimeLineObject.Etl.Id;
    localf.hnJ = paramTimeLineObject.mAQ;
    localf.hnQ = paramTimeLineObject.Id;
    AppMethodBeat.o(112368);
    return localf;
  }
  
  private void cyI()
  {
    AppMethodBeat.i(112355);
    if (System.currentTimeMillis() - this.ryX > this.ryY * 1000L)
    {
      ad.i("MicroMsg.FTS.PardusSearchLogic", "start to request pre search");
      cyJ();
      this.ryW = new com.tencent.mm.plugin.websearch.api.o(new bye());
      com.tencent.mm.kernel.g.aeS().a(1417, this);
      com.tencent.mm.kernel.g.aeS().a(this.ryW, 0);
      this.ryX = System.currentTimeMillis();
    }
    AppMethodBeat.o(112355);
  }
  
  @SuppressLint({"ResourceType"})
  private void cyL()
  {
    AppMethodBeat.i(176933);
    Object localObject1;
    int j;
    Object localObject2;
    int i;
    if ((this.ryP == null) || (this.ryP.DVe == null))
    {
      localObject1 = null;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label523;
      }
      this.ryT = true;
      this.ryp.setVisibility(0);
      j = ((dab)((List)localObject1).get(0)).EgD.length() + 0;
      localObject2 = new afi();
      ((afi)localObject2).Dfi = ((dab)((List)localObject1).get(0));
      ((afi)localObject2).CEo = 0;
      this.ryq.setTag(localObject2);
      this.ryq.setText(((dab)((List)localObject1).get(0)).EgD);
      this.ryq.setOnClickListener(this.ryZ);
      this.ryq.setVisibility(0);
      this.ryk.ruy.rue.q(System.currentTimeMillis(), "PardusSug");
      if (((List)localObject1).size() <= 1) {
        break label485;
      }
      j += ((dab)((List)localObject1).get(1)).EgD.length();
      this.ryr.setOnClickListener(this.ryZ);
      localObject2 = new afi();
      ((afi)localObject2).Dfi = ((dab)((List)localObject1).get(1));
      ((afi)localObject2).CEo = 1;
      this.ryr.setTag(localObject2);
      this.ryr.setText(((dab)((List)localObject1).get(1)).EgD);
      this.ryr.setVisibility(0);
      i = 2;
      label286:
      if (((List)localObject1).size() <= 2) {
        break label511;
      }
      if (((dab)((List)localObject1).get(2)).EgD.length() + j > 24) {
        break label499;
      }
      this.rys.setOnClickListener(this.ryZ);
      localObject2 = new afi();
      ((afi)localObject2).Dfi = ((dab)((List)localObject1).get(2));
      ((afi)localObject2).CEo = 2;
      this.rys.setTag(localObject2);
      this.rys.setText(((dab)((List)localObject1).get(2)).EgD);
      this.rys.setVisibility(0);
      i += 1;
    }
    label523:
    for (;;)
    {
      label405:
      if (this.ryT)
      {
        localObject2 = "";
        j = 0;
        for (;;)
        {
          if (j < i)
          {
            localObject2 = (String)localObject2 + ((dab)((List)localObject1).get(j)).DUZ + "_";
            j += 1;
            continue;
            localObject1 = this.ryP.DVe.CAD;
            break;
            label485:
            this.ryr.setVisibility(8);
            i = 1;
            break label286;
            label499:
            this.rys.setVisibility(8);
            break label405;
            label511:
            this.rys.setVisibility(8);
            break label405;
            this.ryp.setVisibility(8);
            i = 0;
            break label405;
          }
        }
        e(0, "", "", (String)localObject2, "");
      }
    }
    int k = 2;
    if (!this.ryT) {
      k = 1;
    }
    if (this.ryP.DVf.size() > 0) {}
    for (pl localpl = (pl)this.ryP.DVf.getFirst();; localpl = null)
    {
      Object localObject4;
      String str2;
      Object localObject5;
      String str1;
      Object localObject3;
      if (localpl != null)
      {
        localObject4 = "";
        localObject2 = "";
        str2 = "";
        this.ryu.setTag(localpl);
        switch (localpl.mBH)
        {
        default: 
          localObject5 = "";
          localObject1 = "";
          str1 = "";
          localObject3 = "";
          switch (localpl.mBH)
          {
          default: 
            this.dcq = false;
            this.ryt.setVisibility(8);
            this.contentView.measure(-2147483648, 0);
            label785:
            this.ryu.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112338);
                d.this.dj(d.e(d.this), 21);
                pl localpl = (pl)paramAnonymousView.getTag();
                paramAnonymousView = "";
                Object localObject = "";
                String str1;
                String str2;
                switch (localpl.mBH)
                {
                default: 
                  str1 = "";
                  str2 = "";
                  if (d.f(d.this)) {
                    break;
                  }
                }
                for (int i = 1;; i = 2)
                {
                  k.a(d.e(d.this), i, 2, d.d(d.this).kme, d.d(d.this).ruy.rue, 27, paramAnonymousView, (String)localObject, "");
                  d.d(d.this).ruy.rue.DN(27);
                  d.d(d.this).ruy.rtZ = true;
                  d.a(d.this, localpl.mBH, "more", str2, str1, "", 0, "");
                  d.this.DR(5);
                  AppMethodBeat.o(112338);
                  return;
                  localObject = (nh)localpl.CNI.getFirst();
                  str2 = k.aby(((nh)localObject).CLb.Title);
                  paramAnonymousView = "1$".concat(String.valueOf(str2));
                  localObject = ((nh)localObject).CLb.DUZ;
                  str1 = "";
                  break;
                  localObject = (dqo)localpl.CNJ.getFirst();
                  str2 = k.aby(((dqo)localObject).CLb.Title);
                  paramAnonymousView = "2$".concat(String.valueOf(str2));
                  localObject = ((dqo)localObject).CLb.DUZ;
                  str1 = "";
                  break;
                  localObject = (abz)localpl.CNK.getFirst();
                  str1 = ((abz)localObject).rZo;
                  str2 = k.aby(((abz)localObject).CLb.Title);
                  paramAnonymousView = "4$".concat(String.valueOf(str2));
                  localObject = ((abz)localObject).CLb.DUZ;
                  break;
                  localObject = (byg)localpl.CNO.getFirst();
                  str2 = k.aby(((byg)localObject).DUV.Title);
                  paramAnonymousView = "8$".concat(String.valueOf(str2));
                  localObject = ((byg)localObject).DUV.DUZ;
                  str1 = "";
                  break;
                  localObject = (byg)localpl.CNO.getFirst();
                  str2 = k.aby(((byg)localObject).DUV.Title);
                  paramAnonymousView = "7$".concat(String.valueOf(str2));
                  localObject = ((byg)localObject).DUV.DUZ;
                  str1 = "";
                  break;
                  localObject = (byg)localpl.CNO.getFirst();
                  str2 = k.aby(((byg)localObject).DUV.Title);
                  paramAnonymousView = "6$".concat(String.valueOf(str2));
                  localObject = ((byg)localObject).DUV.DUZ;
                  str1 = "";
                  break;
                }
              }
            });
            this.rwy.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                int i = 2;
                AppMethodBeat.i(112339);
                if (!d.f(d.this)) {
                  i = 1;
                }
                try
                {
                  paramAnonymousView = (pl)paramAnonymousView.getTag();
                  if (paramAnonymousView.mBH == 64)
                  {
                    localObject1 = (dqo)paramAnonymousView.CNJ.getFirst();
                    localObject2 = new uj();
                    ((uj)localObject2).dzH.userName = ((dqo)localObject1).mAQ;
                    ((uj)localObject2).dzH.scene = 1027;
                    ((uj)localObject2).dzH.dbt = "2";
                    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
                    localObject2 = k.aby(((dqo)localObject1).CLb.Title);
                    k.a(d.e(d.this), i, 1, d.d(d.this).kme, d.d(d.this).ruy.rue, 27, "2$".concat(String.valueOf(localObject2)), ((dqo)localObject1).CLb.DUZ, ((dqo)localObject1).mAQ);
                    d.d(d.this).ruy.rue.DN(27);
                    d.a(d.this, paramAnonymousView.mBH, ((dqo)localObject1).CLb.DUZ, (String)localObject2, "", "", 0, "");
                    ad.i("MicroMsg.FTS.PardusSearchLogic", "click result weapp %s %s", new Object[] { ((dqo)localObject1).mAQ, ((dqo)localObject1).CLb.DUZ });
                    d.this.DR(4);
                    AppMethodBeat.o(112339);
                    return;
                  }
                  if (paramAnonymousView.mBH == 1)
                  {
                    localObject1 = (nh)paramAnonymousView.CNI.getFirst();
                    localObject2 = new JSONObject(((nh)localObject1).CLc);
                    localObject3 = new Intent();
                    ((Intent)localObject3).putExtra("Contact_User", ((JSONObject)localObject2).optString("userName", ""));
                    ((Intent)localObject3).putExtra("Contact_Nick", ((JSONObject)localObject2).optString("nickName", ""));
                    ((Intent)localObject3).putExtra("Contact_Alias", ((JSONObject)localObject2).optString("aliasName", ""));
                    ((Intent)localObject3).putExtra("Contact_BrandIconURL", ((JSONObject)localObject2).optString("iconUrl", ""));
                    ((Intent)localObject3).putExtra("Contact_Signature", ((JSONObject)localObject2).optString("signature", ""));
                    ((Intent)localObject3).putExtra("Contact_VUser_Info_Flag", ((JSONObject)localObject2).optInt("verifyFlag", 0));
                    ((Intent)localObject3).putExtra("Contact_Scene", 3);
                    localObject4 = new zh();
                    ((zh)localObject4).ika = ((JSONObject)localObject2).optInt("brandFlag", 0);
                    ((zh)localObject4).ikd = ((JSONObject)localObject2).optString("iconUrl", "");
                    ((zh)localObject4).ikc = ((JSONObject)localObject2).optString("brandInfo", "");
                    ((zh)localObject4).ikb = ((JSONObject)localObject2).optString("externalInfo", "");
                  }
                }
                catch (Exception paramAnonymousView)
                {
                  try
                  {
                    label483:
                    do
                    {
                      for (;;)
                      {
                        ((Intent)localObject3).putExtra("Contact_customInfo", ((zh)localObject4).toByteArray());
                        Object localObject4 = new Bundle();
                        ((Bundle)localObject4).putString("Contact_Ext_Args_Search_Id", String.valueOf(d.a(d.this)));
                        ((Bundle)localObject4).putString("Contact_Ext_Args_Query_String", d.e(d.this));
                        ((Bundle)localObject4).putInt("Contact_Scene", 3);
                        ((Bundle)localObject4).putInt("Contact_Ext_Args_Index", 0);
                        ((Bundle)localObject4).putString("Contact_Ext_Extra_Params", "");
                        ((Intent)localObject3).putExtra("preChatTYPE", 10);
                        ((Intent)localObject3).putExtra("Contact_Ext_Args", (Bundle)localObject4);
                        com.tencent.mm.bs.d.b(aj.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject3);
                        Object localObject3 = k.aby(((nh)localObject1).CLb.Title);
                        k.a(d.e(d.this), i, 1, d.d(d.this).kme, d.d(d.this).ruy.rue, 27, "1$".concat(String.valueOf(localObject3)), ((nh)localObject1).CLb.DUZ, "");
                        d.this.DR(4);
                        d.d(d.this).ruy.rue.DN(27);
                        d.d(d.this).ruy.rtZ = true;
                        d.a(d.this, paramAnonymousView.mBH, ((nh)localObject1).CLb.DUZ, (String)localObject3, "", "", 0, "");
                        ad.i("MicroMsg.FTS.PardusSearchLogic", "click result biz %s %s", new Object[] { ((JSONObject)localObject2).optString("userName", ""), ((nh)localObject1).CLb.DUZ });
                        continue;
                        paramAnonymousView = paramAnonymousView;
                        ad.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                      }
                    } while (paramAnonymousView.mBH != 5);
                    Object localObject1 = (byg)paramAnonymousView.CNO.getFirst();
                    Object localObject2 = ((byg)localObject1).DUW;
                    d.this.a((byh)localObject2);
                    localObject2 = k.aby(((byg)localObject1).DUV.Title);
                    k.a(d.e(d.this), i, 1, d.d(d.this).kme, d.d(d.this).ruy.rue, 27, "8$".concat(String.valueOf(localObject2)), ((byg)localObject1).DUV.DUZ, "");
                    d.d(d.this).ruy.rue.DN(27);
                    d.a(d.this, paramAnonymousView.mBH, ((byg)localObject1).DUV.DUZ, (String)localObject2, "", "", 0, "");
                    ad.i("MicroMsg.FTS.PardusSearchLogic", "click result game %s %s", new Object[] { localObject2, ((byg)localObject1).DUV.DUZ });
                  }
                  catch (IOException localIOException)
                  {
                    break label483;
                  }
                }
              }
            });
            this.ryx.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112340);
                int i = 2;
                if (!d.f(d.this)) {
                  i = 1;
                }
                for (;;)
                {
                  try
                  {
                    paramAnonymousView = (pl)paramAnonymousView.getTag();
                    localabz = (abz)paramAnonymousView.CNK.getFirst();
                    if (localabz.saK != 1) {
                      continue;
                    }
                    localObject = new uj();
                    ((uj)localObject).dzH.userName = localabz.mAQ;
                    ((uj)localObject).dzH.dzJ = localabz.DcB;
                    ((uj)localObject).dzH.aAS = localabz.DcC;
                    ((uj)localObject).dzH.scene = 1027;
                    ((uj)localObject).dzH.dbt = (localabz.DcD + ":2");
                    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                    localObject = k.aby(localabz.CLb.Title);
                    k.a(d.e(d.this), i, 1, d.d(d.this).kme, d.d(d.this).ruy.rue, 27, "4$".concat(String.valueOf(localObject)), localabz.CLb.DUZ, "");
                    d.this.DR(4);
                    d.d(d.this).ruy.rue.DN(27);
                    d.d(d.this).ruy.rtZ = true;
                    d.a(d.this, paramAnonymousView.mBH, localabz.CLb.DUZ, (String)localObject, localabz.rZo, "", 0, "");
                    ad.i("MicroMsg.FTS.PardusSearchLogic", "click result article %s", new Object[] { localabz.CLb.DUZ });
                  }
                  catch (Exception paramAnonymousView)
                  {
                    abz localabz;
                    Object localObject;
                    ad.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                    continue;
                  }
                  d.this.DR(4);
                  AppMethodBeat.o(112340);
                  return;
                  if (localabz.saK == 0)
                  {
                    localObject = new Intent();
                    ((Intent)localObject).putExtra("rawUrl", localabz.rZo);
                    com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebviewMpUI", (Intent)localObject);
                  }
                }
              }
            });
            this.ryJ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112341);
                int i = 2;
                if (!d.f(d.this)) {
                  i = 1;
                }
                paramAnonymousView = (pl)paramAnonymousView.getTag();
                byg localbyg = (byg)paramAnonymousView.CNO.getFirst();
                Object localObject = localbyg.DUV.DUZ;
                if (com.tencent.mm.az.a.azF())
                {
                  com.tencent.mm.az.f localf = com.tencent.mm.az.a.azI();
                  if ((localf.hnn == 9) && (localf.hnp.equals(localObject)))
                  {
                    com.tencent.mm.az.a.azD();
                    d.g(d.this).setImageResource(2131691022);
                    AppMethodBeat.o(112341);
                    return;
                  }
                }
                localObject = ((com.tencent.mm.plugin.sns.c.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.c.n.class)).zn(((byg)paramAnonymousView.CNO.getFirst()).DUW.DUY);
                com.tencent.mm.kernel.g.afC();
                com.tencent.mm.az.a.c(d.a(com.tencent.mm.kernel.g.afB().gcW, (TimeLineObject)localObject, localbyg.DUV.DUZ));
                d.g(d.this).setImageResource(2131691021);
                localObject = k.aby(localbyg.DUV.Title);
                k.a(d.e(d.this), i, 1, d.d(d.this).kme, d.d(d.this).ruy.rue, 27, "7$".concat(String.valueOf(localObject)), localbyg.DUV.DUZ, "");
                d.d(d.this).ruy.rue.DN(27);
                d.a(d.this, paramAnonymousView.mBH, localbyg.DUV.DUZ, (String)localObject, "", "", 0, "");
                ad.i("MicroMsg.FTS.PardusSearchLogic", "click music play %d %s %s", new Object[] { Integer.valueOf(7), localObject, localbyg.DUV.DUZ });
                AppMethodBeat.o(112341);
              }
            });
            this.ryI.setOnClickListener(this.rza);
            this.ryD.setOnClickListener(this.rza);
            label867:
            if (this.dcq) {
              this.rti = 2;
            }
            localObject1 = this.ryk.ruy.rue;
            if (!this.dcq) {}
            break;
          }
          break;
        }
      }
      for (j = 2;; j = 0)
      {
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).fJ(i, j);
        if ((!this.ryT) && (!this.dcq)) {
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
        ((ValueAnimator)localObject1).addListener(new a(this.rxi));
        ((ValueAnimator)localObject1).setDuration(400L);
        ((ValueAnimator)localObject1).start();
        this.contentView.setVisibility(0);
        ad.i("MicroMsg.FTS.PardusSearchLogic", "updateHeaderView measureHeight:%s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(176933);
        return;
        localObject1 = (nh)localpl.CNI.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.abd(((nh)localObject1).CLb.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.abd(((nh)localObject1).CLb.Desc);
        localObject2 = ((nh)localObject1).CLb.IconUrl;
        str1 = ((nh)localObject1).CLb.DVa;
        this.ryk.ruy.rue.a(k, System.currentTimeMillis(), "PardusMore", 1, ((nh)localObject1).CLb.DUZ);
        this.ryk.ruy.rue.a(k + 1, System.currentTimeMillis(), ((nh)localObject1).CLb.DUZ, 1, ((nh)localObject1).CLb.DUZ);
        e(localpl.mBH, ((nh)localObject1).CLb.DUZ, k.aby(((nh)localObject1).CLb.Title), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject1 = (dqo)localpl.CNJ.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.abd(((dqo)localObject1).CLb.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.abd(((dqo)localObject1).CLb.Desc);
        localObject2 = ((dqo)localObject1).CLb.IconUrl;
        str1 = ((dqo)localObject1).CLb.DVa;
        this.ryk.ruy.rue.a(k, System.currentTimeMillis(), "PardusMore", 2, ((dqo)localObject1).CLb.DUZ);
        this.ryk.ruy.rue.a(k + 1, System.currentTimeMillis(), ((dqo)localObject1).CLb.DUZ, 2, ((dqo)localObject1).CLb.DUZ);
        e(localpl.mBH, ((dqo)localObject1).CLb.DUZ, k.aby(((dqo)localObject1).CLb.Title), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject5 = (abz)localpl.CNK.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.abd(((abz)localObject5).CLb.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.abd(((abz)localObject5).CLb.Desc);
        localObject2 = ((abz)localObject5).CLb.IconUrl;
        str1 = ((abz)localObject5).CLb.DVa;
        localObject1 = ((abz)localObject5).DcA;
        this.ryk.ruy.rue.a(k, System.currentTimeMillis(), "PardusMore", 4, ((abz)localObject5).CLb.DUZ);
        this.ryk.ruy.rue.a(k + 1, System.currentTimeMillis(), ((abz)localObject5).CLb.DUZ, 4, ((abz)localObject5).CLb.DUZ);
        e(localpl.mBH, ((abz)localObject5).CLb.DUZ, k.aby(((abz)localObject5).CLb.Title), "", "");
        localObject5 = "";
        break;
        byg localbyg = (byg)localpl.CNO.getFirst();
        localObject5 = localbyg.DUV.DUZ;
        localObject4 = com.tencent.mm.plugin.fts.a.f.abd(localbyg.DUV.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.abd(localbyg.DUV.Desc);
        localObject2 = localbyg.DUV.IconUrl;
        str1 = localbyg.DUV.DVa;
        j = localbyg.DUV.rNX;
        if ((j <= 0) || (j >= 86400L))
        {
          str2 = null;
          j = 0;
          if (localpl.mBH != 5) {
            break label1782;
          }
          j = 8;
        }
        for (;;)
        {
          this.ryk.ruy.rue.a(k, System.currentTimeMillis(), "PardusMore", j, (String)localObject5);
          this.ryk.ruy.rue.a(k + 1, System.currentTimeMillis(), (String)localObject5, j, (String)localObject5);
          e(localpl.mBH, (String)localObject5, k.aby(localbyg.DUV.Title), "", "");
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
          if (localpl.mBH == 4194304) {
            j = 6;
          } else if (localpl.mBH == 512) {
            j = 7;
          }
        }
        this.dcq = true;
        this.ryt.setVisibility(0);
        this.rwy.setVisibility(0);
        this.rwy.setTag(localpl);
        this.ryx.setVisibility(8);
        this.ryD.setVisibility(8);
        this.ryI.setVisibility(8);
        this.ryv.setText((CharSequence)localObject4);
        if (!bt.ai((CharSequence)localObject3)) {
          if (this.rwz.getPaint().measureText(((CharSequence)localObject3).toString()) >= this.rym)
          {
            this.rwz.setMaxLines(2);
            label1924:
            this.rwz.setText((CharSequence)localObject3);
            this.rwz.setVisibility(0);
            label1941:
            localObject1 = this.ryk.getContext();
            localObject3 = this.frr;
            if (localpl.mBH == 5) {
              break label2029;
            }
          }
        }
        label2029:
        for (boolean bool = true;; bool = false)
        {
          m.a((Context)localObject1, (ImageView)localObject3, (String)localObject2, null, 2131231342, bool);
          this.ryw.setText(str1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.rwz.setMaxLines(1);
          break label1924;
          this.rwz.setVisibility(8);
          break label1941;
        }
        this.dcq = true;
        this.ryt.setVisibility(0);
        this.rwy.setVisibility(8);
        this.ryx.setVisibility(0);
        this.ryD.setVisibility(8);
        this.ryI.setVisibility(8);
        this.ryx.setTag(localpl);
        if (!bt.ai((CharSequence)localObject4)) {
          if (!bt.isNullOrNil((String)localObject2))
          {
            this.ryz.setMaxLines(1);
            this.ryA.setMaxLines(2);
            this.ryy.setVisibility(0);
            localObject5 = new c.a();
            ((c.a)localObject5).hjT = true;
            ((c.a)localObject5).hkf = 2131231879;
            ((c.a)localObject5).hkm = 1.0F;
            ((c.a)localObject5).gkG = true;
            localObject5 = ((c.a)localObject5).azc();
            com.tencent.mm.aw.o.ayJ().a((String)localObject2, this.ryy, (com.tencent.mm.aw.a.a.c)localObject5);
            label2188:
            this.ryz.setText((CharSequence)localObject4);
            this.ryz.setVisibility(0);
            label2205:
            if (bt.ai((CharSequence)localObject3)) {
              break label2347;
            }
            this.ryA.setText((CharSequence)localObject3);
            this.ryA.setVisibility(0);
          }
        }
        for (;;)
        {
          this.ryB.setText(str1);
          this.ryC.setText((CharSequence)localObject1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.ryy.setVisibility(8);
          if (this.ryz.getPaint().measureText(((CharSequence)localObject4).toString()) >= this.ryo)
          {
            this.ryz.setMaxLines(2);
            this.ryA.setMaxLines(1);
            break label2188;
          }
          this.ryz.setMaxLines(1);
          this.ryA.setMaxLines(2);
          break label2188;
          this.ryz.setVisibility(8);
          break label2205;
          label2347:
          this.ryA.setVisibility(8);
        }
        this.dcq = true;
        this.ryt.setVisibility(0);
        this.rwy.setVisibility(8);
        this.ryx.setVisibility(8);
        this.ryI.setVisibility(8);
        this.ryD.setVisibility(0);
        this.ryD.setTag(localpl);
        this.ryG.setText((CharSequence)localObject4);
        this.ryH.setText(str1);
        this.ryF.setText(str2);
        localObject1 = new c.a();
        ((c.a)localObject1).hjT = true;
        ((c.a)localObject1).hkf = 2131231884;
        ((c.a)localObject1).hkm = 1.0F;
        ((c.a)localObject1).gkG = true;
        localObject1 = ((c.a)localObject1).azc();
        com.tencent.mm.aw.o.ayJ().a((String)localObject2, this.ryE, (com.tencent.mm.aw.a.a.c)localObject1);
        this.contentView.measure(-2147483648, 0);
        break label785;
        this.dcq = true;
        this.ryt.setVisibility(0);
        this.rwy.setVisibility(8);
        this.ryx.setVisibility(8);
        this.ryD.setVisibility(8);
        this.ryI.setVisibility(0);
        this.ryI.setTag(localpl);
        this.ryJ.setTag(localpl);
        this.ryL.setText((CharSequence)localObject4);
        this.ryM.setText((CharSequence)localObject3);
        this.ryN.setText(str1);
        if ((com.tencent.mm.az.a.azF()) && (com.tencent.mm.az.a.azI().hnp.equals(localObject5))) {
          this.ryJ.setImageResource(2131691021);
        }
        for (;;)
        {
          localObject1 = new c.a();
          ((c.a)localObject1).hjT = true;
          ((c.a)localObject1).hkf = 2131231882;
          ((c.a)localObject1).hkm = 1.0F;
          ((c.a)localObject1).gkG = true;
          localObject1 = ((c.a)localObject1).azc();
          com.tencent.mm.aw.o.ayJ().a((String)localObject2, this.ryK, (com.tencent.mm.aw.a.a.c)localObject1);
          this.contentView.measure(-2147483648, 0);
          this.rzi.alive();
          break;
          this.ryJ.setImageResource(2131691022);
        }
        this.ryt.setVisibility(8);
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
    if (this.ryP != null)
    {
      String str = this.ryP.DLH;
      AppMethodBeat.o(112366);
      return str;
    }
    long l = this.rxi;
    AppMethodBeat.o(112366);
    return String.valueOf(l);
  }
  
  private void gl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112363);
    this.ryk.ruy.rtZ = true;
    if ((paramString1 == null) || (bt.isNullOrNil(paramString1.trim())))
    {
      AppMethodBeat.o(112363);
      return;
    }
    if (System.currentTimeMillis() - this.kOJ <= 1000L)
    {
      AppMethodBeat.o(112363);
      return;
    }
    this.kOJ = System.currentTimeMillis();
    long l = com.tencent.mm.plugin.fts.a.e.rob;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneActionType", "1");
    localHashMap.put("parentSearchID", paramString2);
    localHashMap.put("clickType", "17");
    ((com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class)).a(this.ryk.getContext(), 3, paramString1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(112363);
  }
  
  public final void A(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184533);
    String str = "";
    if (this.ryP != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.ryP.DLH, paramString2, Long.valueOf(this.rxi) });
    }
    paramString2 = new HashMap();
    paramString2.put("prefixSug", this.query);
    if (!bt.isNullOrNil(str)) {
      paramString2.put("parentSearchID", str);
    }
    paramString2.put("sceneActionType", "6");
    k(paramString2, paramString1);
    AppMethodBeat.o(184533);
  }
  
  public final void DR(int paramInt)
  {
    AppMethodBeat.i(184532);
    if ((!this.ryV) && (!bt.isNullOrNil(this.query)))
    {
      ak.p(this.query, this.rti, paramInt, 3);
      this.ryV = true;
    }
    AppMethodBeat.o(184532);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(112367);
    ad.i("MicroMsg.FTS.PardusSearchLogic", "change status from %s to %s", new Object[] { this.ryR, paramb });
    this.ryR = paramb;
    AppMethodBeat.o(112367);
  }
  
  public final void a(byh parambyh)
  {
    AppMethodBeat.i(176934);
    switch (parambyh.CKO)
    {
    }
    for (;;)
    {
      DR(4);
      AppMethodBeat.o(176934);
      return;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", parambyh.rZo);
      com.tencent.mm.bs.d.b(this.ryk, "webview", ".ui.tools.WebviewMpUI", (Intent)localObject);
      continue;
      localObject = new uj();
      ((uj)localObject).dzH.userName = parambyh.mAQ;
      ((uj)localObject).dzH.dzJ = parambyh.DcB;
      ((uj)localObject).dzH.aAS = parambyh.DcC;
      ((uj)localObject).dzH.dbt = parambyh.DcD;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
  }
  
  public final void bWe()
  {
    AppMethodBeat.i(112360);
    if (!this.dcq)
    {
      this.rzf.removeAllViews();
      LinkedList localLinkedList;
      if ((this.ryP == null) || (this.ryP.DVj == null)) {
        localLinkedList = null;
      }
      while ((!this.ryT) && (localLinkedList != null) && (localLinkedList.size() > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < localLinkedList.size())
          {
            dab localdab = (dab)localLinkedList.get(i);
            afi localafi = new afi();
            localafi.Dfi = localdab;
            localafi.CEo = i;
            View localView = this.ryk.getLayoutInflater().inflate(2131494228, this.rzf, false);
            localView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112337);
                paramAnonymousView = (afi)paramAnonymousView.getTag();
                d.this.A(paramAnonymousView.Dfi.EgD, 7, paramAnonymousView.Dfi.DUZ);
                com.tencent.mm.plugin.fts.ui.c.b localb = d.d(d.this).ruy.rue;
                k.a(d.e(d.this), d.d(d.this).ruy.getCount(), d.d(d.this).kme, localb, 23);
                d.d(d.this).ruy.rtZ = true;
                if (!d.d(d.this).ruy.rtQ)
                {
                  d.d(d.this).ruy.rtQ = true;
                  k.a(paramAnonymousView.Dfi.EgD, true, d.d(d.this).ruy.getCount(), 0, localb);
                }
                d.this.DR(7);
                ak.Sj(3);
                d.d(d.this).ruy.rue.DN(23);
                d.a(d.this, 0, "", "", "", "", paramAnonymousView.CEo + 1, paramAnonymousView.Dfi.DUZ);
                AppMethodBeat.o(112337);
              }
            });
            ((TextView)localView.findViewById(2131298739)).setText(localdab.EgD);
            localView.setTag(localafi);
            this.rzf.addView(localView);
            i += 1;
            continue;
            localLinkedList = this.ryP.DVj.CAD;
            break;
          }
        }
        this.ryk.ruy.rue.fK(localLinkedList.size(), 1);
        this.rzf.setVisibility(0);
        this.ryk.ruy.rue.dI(localLinkedList);
      }
      for (;;)
      {
        this.rzc.setVisibility(0);
        this.rzd.setVisibility(0);
        this.ryk.ruy.rue.cyg();
        AppMethodBeat.o(112360);
        return;
        this.ryk.ruy.rue.fK(0, 1);
        this.rzf.setVisibility(8);
      }
    }
    this.ryk.ruy.rue.fK(0, 0);
    this.rzd.setVisibility(8);
    this.rzc.setVisibility(8);
    AppMethodBeat.o(112360);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(112353);
    this.ryR = b.rzl;
    this.rti = 1;
    this.rxi = 0L;
    this.rty = 0L;
    this.rqH = 0L;
    this.ryS = false;
    this.ryT = false;
    this.dcq = false;
    this.ryV = false;
    this.query = null;
    this.ryP = null;
    this.rzi.dead();
    if (this.ryO != null) {
      this.ryO.clearData();
    }
    AppMethodBeat.o(112353);
  }
  
  public final View crg()
  {
    AppMethodBeat.i(112361);
    if (this.rzb == null)
    {
      this.rzb = this.ryk.getLayoutInflater().inflate(2131494224, null, false);
      this.rzd = this.rzb.findViewById(2131306903);
      this.rzc = this.rzb.findViewById(2131306906);
      this.rze = this.rzb.findViewById(2131306905);
      this.rzg = ((TextView)this.rzb.findViewById(2131306907));
      this.rzh = ((TextView)this.rzb.findViewById(2131306904));
      this.rzf = ((LinearLayout)this.rzc.findViewById(2131303971));
    }
    try
    {
      Object localObject = ac.ave("webSearchBar").optString("wording");
      ad.i("MicroMsg.FTS.PardusSearchLogic", "set searchNetworkTips %s", new Object[] { localObject });
      this.rzh.setText((CharSequence)localObject);
      label163:
      this.rzd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(112333);
          d.d(d.this).ruy.rtZ = true;
          if (!d.d(d.this).ruy.rtQ)
          {
            d.d(d.this).ruy.rtQ = true;
            k.a(d.e(d.this), true, d.d(d.this).ruy.getCount(), 0, d.d(d.this).ruy.rue);
          }
          d.this.dj(d.e(d.this), 15);
          d.d(d.this).ruy.rtZ = true;
          d.this.DR(2);
          ak.Sj(3);
          d.d(d.this).ruy.rue.DN(18);
          k.a(d.e(d.this), d.d(d.this).ruy.getCount(), d.d(d.this).kme, d.d(d.this).ruy.rue, 18);
          AppMethodBeat.o(112333);
        }
      });
      localObject = this.rzb;
      AppMethodBeat.o(112361);
      return localObject;
    }
    catch (Exception localException)
    {
      break label163;
    }
  }
  
  public final void cxr()
  {
    AppMethodBeat.i(112352);
    this.rxl.removeMessages(1);
    if (this.ryQ != null)
    {
      com.tencent.mm.kernel.g.aeS().a(this.ryQ);
      com.tencent.mm.kernel.g.aeS().b(1076, this);
      this.ryQ = null;
    }
    AppMethodBeat.o(112352);
  }
  
  public final void cyJ()
  {
    AppMethodBeat.i(112356);
    if (this.ryW != null)
    {
      com.tencent.mm.kernel.g.aeS().a(this.ryW);
      com.tencent.mm.kernel.g.aeS().b(1417, this);
      this.ryW = null;
    }
    AppMethodBeat.o(112356);
  }
  
  @TargetApi(8)
  public final void cyK()
  {
    AppMethodBeat.i(112357);
    if (this.contentView != null)
    {
      this.ryk.lA(true);
      this.contentView.clearAnimation();
      this.contentView.setVisibility(8);
    }
    if (this.rzf != null)
    {
      this.rzf.removeAllViews();
      this.rzf.setVisibility(8);
    }
    if (this.rzc != null) {
      this.rzc.setVisibility(8);
    }
    if (this.rzd != null) {
      this.rzd.setVisibility(8);
    }
    if (this.ryO != null) {
      this.ryO.cyM();
    }
    AppMethodBeat.o(112357);
  }
  
  public final void d(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112362);
    if ((paramBoolean2) || (paramInt != 0)) {
      this.rze.setVisibility(0);
    }
    for (;;)
    {
      if ((paramBoolean1) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pua, com.tencent.mm.util.c.fgV()) == 0)) {
        bWe();
      }
      AppMethodBeat.o(112362);
      return;
      this.rze.setVisibility(8);
    }
  }
  
  public final void dj(String paramString, int paramInt)
  {
    AppMethodBeat.i(176935);
    String str = "";
    if (this.ryP != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.ryP.DLH, paramString, Long.valueOf(this.rxi) });
    }
    gl(paramString, str);
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
      localStringBuffer.append(com.tencent.mm.compatible.util.p.encode(this.query, "utf8"));
      localStringBuffer.append("&type=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&docid=");
      localStringBuffer.append(paramString1);
      localStringBuffer.append("&title=");
      localStringBuffer.append(com.tencent.mm.compatible.util.p.encode(paramString2, "utf8"));
      localStringBuffer.append("&clienttimestamp=");
      localStringBuffer.append(System.currentTimeMillis());
      localStringBuffer.append("&sug=");
      localStringBuffer.append(com.tencent.mm.compatible.util.p.encode(paramString3, "utf8"));
      localStringBuffer.append("&relatedsug=");
      localStringBuffer.append(com.tencent.mm.compatible.util.p.encode(paramString4, "utf8"));
      ad.i("MicroMsg.FTS.PardusSearchLogic", "realtimeSearchExposeReport %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new ckd();
      paramString1.Eff = localStringBuffer.toString();
      paramString1 = new w(paramString1);
      com.tencent.mm.kernel.g.aeS().a(paramString1, 0);
      AppMethodBeat.o(112365);
      return;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramString1, "realtimeSearchExposeReport", new Object[0]);
      AppMethodBeat.o(112365);
    }
  }
  
  public final void k(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(176936);
    this.ryk.ruy.rtZ = true;
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176936);
      return;
    }
    if (System.currentTimeMillis() - this.kOJ <= 1000L)
    {
      AppMethodBeat.o(176936);
      return;
    }
    this.kOJ = System.currentTimeMillis();
    long l = com.tencent.mm.plugin.fts.a.e.rob;
    paramMap.put("clickType", "7");
    ((com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class)).a(this.ryk.getContext(), paramString, String.valueOf(l), paramMap);
    AppMethodBeat.o(176936);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112354);
    ad.i("MicroMsg.FTS.PardusSearchLogic", "onFocusChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      cyI();
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
    if (paramn.equals(this.ryW))
    {
      com.tencent.mm.kernel.g.aeS().b(1417, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.ryY = this.ryW.AFK.DUU;
        ad.i("MicroMsg.FTS.PardusSearchLogic", "pardusCacheExpireTime %d", new Object[] { Long.valueOf(this.ryY) });
        AppMethodBeat.o(112359);
      }
    }
    else if ((paramn.equals(this.ryQ)) && (this.ryQ.AFM.DVb.equals(String.valueOf(this.rxi))))
    {
      a(b.rzn);
      this.rxl.removeMessages(1);
      com.tencent.mm.kernel.g.aeS().b(1076, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label412;
      }
      k.H(this.rxi, 4);
      this.ryP = this.ryQ.AFL;
      if ((this.ryP == null) || (bt.isNullOrNil(this.ryP.DVk))) {
        break label333;
      }
      bool = true;
      this.ryU = bool;
      bool = this.ryU;
      paramInt2 = this.ryP.DVf.size();
      if (this.ryP.DVe != null) {
        break label339;
      }
      paramInt1 = i;
      ad.i("MicroMsg.FTS.PardusSearchLogic", "searchResponse hasWebViewResult %b result:%d sug:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (!this.ryS)
      {
        if (!this.ryU) {
          break label405;
        }
        paramString = this.ryO;
        paramn = this.ryP.DVk;
        localObject = this.query;
        if (paramString.rzu) {
          break label356;
        }
        ad.i("MicroMsg.FTS.PardusWebViewLogic", "webview not ready");
      }
    }
    for (;;)
    {
      if (!this.ryU) {
        bWe();
      }
      AppMethodBeat.o(112359);
      return;
      label333:
      bool = false;
      break;
      label339:
      paramInt1 = this.ryP.DVe.CAD.size();
      break label230;
      label356:
      paramString.dsh = ((String)localObject);
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("info", paramn);
        label382:
        paramString.ruf.ryk.runOnUiThread(new e.1(paramString, (JSONObject)localObject));
        continue;
        label405:
        cyL();
        continue;
        label412:
        k.H(this.rxi, 5);
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
    private long rzk;
    
    public a(long paramLong)
    {
      this.rzk = paramLong;
    }
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(176932);
      ad.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationEnd listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.rzk), Long.valueOf(d.a(d.this)) });
      if (this.rzk == d.a(d.this))
      {
        d.d(d.this).lA(true);
        if (d.i(d.this) == d.b.rzo)
        {
          d.this.a(d.b.rzp);
          k.H(d.a(d.this), 7);
        }
      }
      AppMethodBeat.o(176932);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(176931);
      ad.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationStart listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.rzk), Long.valueOf(d.a(d.this)) });
      if (this.rzk == d.a(d.this))
      {
        d.d(d.this).lA(false);
        d.this.a(d.b.rzo);
        k.H(d.a(d.this), 6);
      }
      AppMethodBeat.o(176931);
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(112350);
      rzl = new b("None", 0);
      rzm = new b("StartSearch", 1);
      rzn = new b("ReturnResult", 2);
      rzo = new b("StartAnimation", 3);
      rzp = new b("ShowResult", 4);
      rzq = new b("Timeout", 5);
      rzr = new b[] { rzl, rzm, rzn, rzo, rzp, rzq };
      AppMethodBeat.o(112350);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */