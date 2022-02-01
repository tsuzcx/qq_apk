package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.model.u;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.card.b.c.a;
import com.tencent.mm.plugin.card.b.d.a;
import com.tencent.mm.plugin.card.b.g.a;
import com.tencent.mm.plugin.card.b.i.a;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.ui.view.x;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.protocal.protobuf.tt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CardDetailUI
  extends MMActivity
  implements com.tencent.mm.al.f, c.a, d.a, j.a, bh.a
{
  private View GG;
  private final String TAG;
  private float fFf;
  private float fFg;
  private b.a fFl;
  private int fPp;
  private p fQJ;
  private String hAT;
  private com.tencent.mm.modelgeo.d hQo;
  ap mHandler;
  private long mStartTime;
  private Vibrator nKv;
  private boolean oCD;
  private int oCq;
  private boolean oDz;
  e oEL;
  private String oEM;
  private String oEN;
  private String oEO;
  private boolean oEP;
  private boolean oEQ;
  private boolean oER;
  private String oES;
  private e.a oET;
  private boolean oEU;
  private boolean oEV;
  private boolean oEW;
  private boolean oEX;
  private String oEY;
  private com.tencent.mm.plugin.card.b.i oEZ;
  private int oEs;
  private String oEt;
  private String oEu;
  private String oEv;
  private com.tencent.mm.plugin.card.base.b owK;
  private ArrayList<tl> owR;
  private String oww;
  private String oxI;
  private boolean oxW;
  
  public CardDetailUI()
  {
    AppMethodBeat.i(113213);
    this.TAG = "MicroMsg.CardDetailUI";
    this.fQJ = null;
    this.oww = "";
    this.oxI = "";
    this.oEM = "";
    this.oEN = "";
    this.oEO = "";
    this.oEt = "";
    this.oEu = "";
    this.oEv = "";
    this.oxW = false;
    this.oEP = false;
    this.oEQ = false;
    this.oER = false;
    this.hAT = "";
    this.oES = "";
    this.oCD = false;
    this.mHandler = new ap();
    this.fPp = 3;
    this.oEs = 0;
    this.oCq = -1;
    this.oEU = false;
    this.oEV = true;
    this.mStartTime = 0L;
    this.oEW = false;
    this.oDz = false;
    this.oEX = false;
    this.fFf = -85.0F;
    this.fFg = -1000.0F;
    this.oEY = "";
    this.oEZ = new com.tencent.mm.plugin.card.b.i();
    this.fFl = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(113199);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(113199);
          return true;
        }
        if ((CardDetailUI.a(CardDetailUI.this) == -85.0F) && (CardDetailUI.b(CardDetailUI.this) == -1000.0F))
        {
          CardDetailUI.a(CardDetailUI.this, paramAnonymousFloat2);
          CardDetailUI.b(CardDetailUI.this, paramAnonymousFloat1);
          am.bUT().N(CardDetailUI.a(CardDetailUI.this), CardDetailUI.b(CardDetailUI.this));
        }
        com.tencent.mm.plugin.card.b.i locali = CardDetailUI.c(CardDetailUI.this);
        paramAnonymousFloat1 = CardDetailUI.b(CardDetailUI.this);
        paramAnonymousFloat2 = CardDetailUI.a(CardDetailUI.this);
        synchronized (locali.diV)
        {
          locali.fFf = paramAnonymousFloat2;
          locali.fFg = paramAnonymousFloat1;
          if (CardDetailUI.d(CardDetailUI.this))
          {
            CardDetailUI.e(CardDetailUI.this);
            CardDetailUI.f(CardDetailUI.this);
          }
          CardDetailUI.g(CardDetailUI.this);
          AppMethodBeat.o(113199);
          return false;
        }
      }
    };
    AppMethodBeat.o(113213);
  }
  
  private void AA(int paramInt)
  {
    AppMethodBeat.i(113234);
    if ((this.oCq != 7) && (this.oCq != 16))
    {
      ad.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
      AppMethodBeat.o(113234);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new com.tencent.mm.plugin.card.model.e();
    ((com.tencent.mm.plugin.card.model.e)localObject).oxM = this.owK.bTS();
    ((com.tencent.mm.plugin.card.model.e)localObject).dHY = this.oEO;
    ((com.tencent.mm.plugin.card.model.e)localObject).code = this.oEY;
    localLinkedList.add(localObject);
    localObject = new com.tencent.mm.g.a.b();
    ((com.tencent.mm.g.a.b)localObject).djA.bZU = paramInt;
    if (paramInt == -1) {}
    for (((com.tencent.mm.g.a.b)localObject).djA.djB = com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.oCq);; ((com.tencent.mm.g.a.b)localObject).djA.djB = com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.oCq))
    {
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(113234);
      return;
    }
  }
  
  /* Error */
  private void Yf(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 242
    //   4: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 127	com/tencent/mm/plugin/card/ui/CardDetailUI:oCD	Z
    //   11: ifeq +18 -> 29
    //   14: ldc 91
    //   16: ldc 244
    //   18: invokestatic 247	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 242
    //   23: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: ldc 91
    //   31: ldc 249
    //   33: invokestatic 181	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 127	com/tencent/mm/plugin/card/ui/CardDetailUI:oCD	Z
    //   41: new 251	android/content/Intent
    //   44: dup
    //   45: aload_0
    //   46: ldc 253
    //   48: invokespecial 256	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   51: astore_2
    //   52: aload_2
    //   53: ldc_w 258
    //   56: aload_0
    //   57: getfield 189	com/tencent/mm/plugin/card/ui/CardDetailUI:owK	Lcom/tencent/mm/plugin/card/base/b;
    //   60: invokeinterface 261 1 0
    //   65: invokevirtual 265	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   68: pop
    //   69: aload_2
    //   70: ldc_w 267
    //   73: aload_1
    //   74: invokevirtual 265	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   77: pop
    //   78: aload_2
    //   79: ldc_w 269
    //   82: aload_0
    //   83: getfield 189	com/tencent/mm/plugin/card/ui/CardDetailUI:owK	Lcom/tencent/mm/plugin/card/base/b;
    //   86: invokeinterface 273 1 0
    //   91: getfield 278	com/tencent/mm/protocal/protobuf/ts:hAD	Ljava/lang/String;
    //   94: invokevirtual 265	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   97: pop
    //   98: aload_2
    //   99: ldc_w 280
    //   102: aload_0
    //   103: getfield 134	com/tencent/mm/plugin/card/ui/CardDetailUI:fPp	I
    //   106: invokevirtual 283	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   109: pop
    //   110: aload_2
    //   111: ldc_w 285
    //   114: iconst_0
    //   115: invokevirtual 283	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   118: pop
    //   119: new 287	com/tencent/mm/hellhoundlib/b/a
    //   122: dup
    //   123: invokespecial 288	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   126: aload_2
    //   127: invokevirtual 292	com/tencent/mm/hellhoundlib/b/a:bc	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   130: astore_1
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 296	com/tencent/mm/hellhoundlib/b/a:ahp	()[Ljava/lang/Object;
    //   136: ldc_w 297
    //   139: ldc_w 299
    //   142: ldc_w 300
    //   145: ldc_w 302
    //   148: ldc_w 304
    //   151: ldc_w 306
    //   154: invokestatic 311	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_0
    //   158: aload_1
    //   159: iconst_0
    //   160: invokevirtual 315	com/tencent/mm/hellhoundlib/b/a:mq	(I)Ljava/lang/Object;
    //   163: checkcast 251	android/content/Intent
    //   166: invokevirtual 317	com/tencent/mm/plugin/card/ui/CardDetailUI:startActivity	(Landroid/content/Intent;)V
    //   169: aload_0
    //   170: ldc_w 297
    //   173: ldc_w 299
    //   176: ldc_w 300
    //   179: ldc_w 302
    //   182: ldc_w 304
    //   185: ldc_w 306
    //   188: invokestatic 320	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   191: ldc 242
    //   193: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: goto -170 -> 26
    //   199: astore_1
    //   200: aload_0
    //   201: monitorexit
    //   202: aload_1
    //   203: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	CardDetailUI
    //   0	204	1	paramString	String
    //   51	76	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   2	26	199	finally
    //   29	196	199	finally
  }
  
  private void a(j.b paramb)
  {
    AppMethodBeat.i(113247);
    if (this.oEL.dtm)
    {
      ad.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
      AppMethodBeat.o(113247);
      return;
    }
    ad.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
    this.oEL.a(this.oER, paramb, true);
    AppMethodBeat.o(113247);
  }
  
  private void bTk()
  {
    AppMethodBeat.i(113235);
    if (this.hQo == null) {
      this.hQo = com.tencent.mm.modelgeo.d.aHQ();
    }
    this.hQo.a(this.fFl, true);
    AppMethodBeat.o(113235);
  }
  
  private void bTm()
  {
    AppMethodBeat.i(113236);
    if (this.hQo != null) {
      this.hQo.c(this.fFl);
    }
    AppMethodBeat.o(113236);
  }
  
  private void bVI()
  {
    AppMethodBeat.i(113237);
    this.hQo = com.tencent.mm.modelgeo.d.aHQ();
    bTk();
    AppMethodBeat.o(113237);
  }
  
  private void bVY()
  {
    AppMethodBeat.i(113219);
    com.tencent.mm.kernel.g.ajB().gAO.a(1057, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1037, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1058, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1045, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1077, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1099, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(902, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1051, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1163, this);
    AppMethodBeat.o(113219);
  }
  
  private void bVZ()
  {
    AppMethodBeat.i(113220);
    com.tencent.mm.kernel.g.ajB().gAO.b(1057, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1037, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1058, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1045, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1077, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1099, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(902, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1051, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1163, this);
    AppMethodBeat.o(113220);
  }
  
  private void bVy()
  {
    AppMethodBeat.i(113224);
    this.oET.fPp = this.fPp;
    this.oET.oCq = this.oCq;
    this.oET.oww = this.oww;
    this.oEL.a(this.owK, this.oET, this.owR);
    this.oEL.bVy();
    am.bUY().owK = this.owK;
    AppMethodBeat.o(113224);
  }
  
  private void bWa()
  {
    AppMethodBeat.i(113222);
    this.oCq = this.fPp;
    this.oET = new e.a();
    this.oET.fPp = this.fPp;
    this.oET.oCq = this.oCq;
    this.oET.oww = this.oww;
    this.oET.oEM = this.oEM;
    this.oET.oEO = this.oEO;
    this.oET.oEN = this.oEN;
    this.oET.oEt = this.oEt;
    this.oET.oEu = this.oEu;
    this.oET.oxW = this.oxW;
    this.oET.oFK = getIntent().getIntExtra("key_from_appbrand_type", 0);
    AppMethodBeat.o(113222);
  }
  
  private void bWb()
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113223);
    if ((this.oEW) || (this.owK == null))
    {
      AppMethodBeat.o(113223);
      return;
    }
    this.oEW = true;
    if (this.oxW)
    {
      localg = com.tencent.mm.plugin.report.service.g.yhR;
      j = this.owK.bTN().mrl;
      str1 = this.owK.bTS();
      str2 = this.owK.bTR();
      k = this.oCq;
      str3 = this.oEM;
      if (this.owK.bTL()) {}
      for (;;)
      {
        localg.f(11324, new Object[] { "ShareCardDetailUI", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
        AppMethodBeat.o(113223);
        return;
        i = 0;
      }
    }
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
    int k = this.owK.bTN().mrl;
    String str1 = this.owK.bTS();
    String str2 = this.owK.bTR();
    int m = this.oCq;
    String str3 = this.oEM;
    if (this.owK.bTL()) {}
    for (i = j;; i = 0)
    {
      localg.f(11324, new Object[] { "CardDetailView", Integer.valueOf(k), str1, str2, Integer.valueOf(0), Integer.valueOf(m), str3, Integer.valueOf(i), "" });
      AppMethodBeat.o(113223);
      return;
    }
  }
  
  private void bWc()
  {
    AppMethodBeat.i(113229);
    Object localObject = new did();
    ((did)localObject).HwU = this.hAT;
    ((did)localObject).ozg = this.oES;
    ad.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", new Object[] { this.hAT });
    localObject = new aa(this.oww, this.fPp, this.oEM, this.oEO, this.oEt, this.oEu, this.oEs, this.oEv, (did)localObject);
    com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject, 0);
    AppMethodBeat.o(113229);
  }
  
  private void bWd()
  {
    AppMethodBeat.i(113230);
    Object localObject;
    if (!TextUtils.isEmpty(this.owK.bTS())) {
      localObject = this.owK.bTS();
    }
    while ((this.owK != null) && (this.owK.bTN().FRD == 1))
    {
      float f2 = this.fFf;
      float f3 = this.fFg;
      float f1;
      if (f2 != -85.0F)
      {
        f1 = f3;
        if (f3 != -1000.0F) {}
      }
      else
      {
        f2 = am.bUT().fFf;
        f1 = am.bUT().fFg;
      }
      localObject = new v((String)localObject, f1, f2, this.owK.bTR());
      com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject, 0);
      AppMethodBeat.o(113230);
      return;
      if (!TextUtils.isEmpty(this.oww))
      {
        localObject = this.oww;
      }
      else
      {
        ad.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
        AppMethodBeat.o(113230);
        return;
      }
    }
    if ((this.owK != null) && (this.owK.bTN().FRD > 1))
    {
      if ((this.fFf != -85.0F) && (this.fFg != -1000.0F))
      {
        this.oEX = false;
        localObject = new v((String)localObject, this.fFg, this.fFf, this.owK.bTR());
        com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject, 0);
        AppMethodBeat.o(113230);
        return;
      }
      if (!this.oEX)
      {
        this.oEX = true;
        if (this.oDz)
        {
          bTk();
          AppMethodBeat.o(113230);
        }
      }
    }
    else if (this.owK != null)
    {
      this.owK.a(null);
      bVy();
      if (this.owK.bTt())
      {
        localObject = am.bUV().YE(this.oww);
        if (localObject != null)
        {
          ((ShareCardInfo)localObject).a(null);
          am.bUV().update((com.tencent.mm.sdk.e.c)localObject, new String[] { this.oww });
        }
        AppMethodBeat.o(113230);
        return;
      }
      localObject = am.bUN().Yo(this.oww);
      if (localObject != null)
      {
        ((CardInfo)localObject).a(null);
        am.bUN().update((com.tencent.mm.sdk.e.c)localObject, new String[] { this.oww });
      }
    }
    AppMethodBeat.o(113230);
  }
  
  private void bWe()
  {
    AppMethodBeat.i(113231);
    com.tencent.mm.plugin.card.sharecard.model.c localc = new com.tencent.mm.plugin.card.sharecard.model.c(this.oww);
    com.tencent.mm.kernel.g.ajB().gAO.a(localc, 0);
    AppMethodBeat.o(113231);
  }
  
  private void c(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(113226);
    ad.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + paramInt1 + " errMsg = " + paramString1 + " ret_code:" + paramInt2 + " ret_msg:" + paramString2);
    if (paramInt2 == 10000)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = getString(2131756791);
      }
      this.owK.bTO().status = 4;
      bVy();
    }
    for (;;)
    {
      com.tencent.mm.plugin.card.d.d.c(this, paramString1);
      AppMethodBeat.o(113226);
      return;
      if (paramInt2 == 10001)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131756795);
        }
        this.owK.bTO().status = 5;
        bVy();
      }
      else if (paramInt2 == 10002)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131756946);
        }
      }
      else
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131756789);
        }
      }
    }
  }
  
  private void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(113227);
    if (paramBoolean)
    {
      this.fQJ = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(113227);
      return;
    }
    if ((this.fQJ != null) && (this.fQJ.isShowing()))
    {
      this.fQJ.dismiss();
      this.fQJ = null;
    }
    AppMethodBeat.o(113227);
  }
  
  private void jv(boolean paramBoolean)
  {
    AppMethodBeat.i(113228);
    if (paramBoolean) {
      com.tencent.mm.plugin.card.d.l.fg(this.oEL.oFz, this.oEL.oFy);
    }
    AppMethodBeat.o(113228);
  }
  
  private void z(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(113233);
    Intent localIntent;
    if (paramInt == 1)
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.oEY);
      localIntent.putExtra("key_card_id", this.oww);
      localIntent.putExtra("key_finish_action", paramInt);
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.oCq == 7) || (this.oCq == 8) || (this.oCq == 16) || (this.oCq == 26)) && (this.fPp == 3))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.oEY);
      if (paramInt > 0)
      {
        localIntent.putExtra("key_card_id", this.oww);
        localIntent.putExtra("key_finish_action", paramInt);
      }
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.oCq == 7) && (this.fPp == 7)) || ((this.oCq == 16) && (this.fPp == 16)) || ((this.oCq == 8) && (this.fPp == 8)) || ((this.oCq == 26) && (this.fPp == 26)))
    {
      setResult(0);
      if (paramBoolean)
      {
        finish();
        AppMethodBeat.o(113233);
      }
    }
    else if (paramBoolean)
    {
      finish();
    }
    AppMethodBeat.o(113233);
  }
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(215396);
    paramString = this.oEL.oFj;
    if (paramString != null) {
      paramString.bYv();
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(16827, new Object[] { this.oww, Long.valueOf(System.currentTimeMillis() / 1000L) });
    AppMethodBeat.o(215396);
  }
  
  public final void Yd(String paramString)
  {
    AppMethodBeat.i(113249);
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    }
    AppMethodBeat.o(113249);
  }
  
  public final void Yg(final String paramString)
  {
    AppMethodBeat.i(113243);
    if (!this.oEL.bWJ())
    {
      ad.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
      AppMethodBeat.o(113243);
      return;
    }
    ad.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113212);
        CardDetailUI.c(CardDetailUI.this, paramString);
        AppMethodBeat.o(113212);
      }
    });
    AppMethodBeat.o(113243);
  }
  
  public final void Yj(String paramString)
  {
    AppMethodBeat.i(113246);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.oww)))
    {
      ad.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113246);
      return;
    }
    this.oEP = false;
    AppMethodBeat.o(113246);
  }
  
  public final void b(String paramString, j.b paramb)
  {
    AppMethodBeat.i(113244);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.oww)))
    {
      ad.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113244);
      return;
    }
    jt(false);
    ad.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
    ad.i("MicroMsg.CardDetailUI", "markSucc:" + paramb.oxA + " markCardId: " + paramb.oxB);
    this.oEQ = false;
    if (paramb.oxA == 1)
    {
      if ((!TextUtils.isEmpty(paramb.oxB)) && (!this.owK.bTR().equals(paramb.oxB)))
      {
        ad.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
        if (this.owK.bTt())
        {
          paramString = am.bUV().YE(paramb.oxB);
          if (paramString != null)
          {
            this.owK = paramString;
            this.oww = paramb.oxB;
            bVy();
            am.bUY().b(this.owK);
            ad.i("MicroMsg.CardDetailUI", "update the mCardInfo");
            this.oEP = true;
            a(paramb);
            AppMethodBeat.o(113244);
            return;
          }
          ad.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
          com.tencent.mm.plugin.card.d.d.c(this, getString(2131756926));
          this.oEP = false;
          AppMethodBeat.o(113244);
        }
      }
      else
      {
        ad.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
        this.oEP = true;
        a(paramb);
        AppMethodBeat.o(113244);
      }
    }
    else
    {
      this.oEP = false;
      com.tencent.mm.plugin.card.d.d.c(this, getString(2131756927));
    }
    AppMethodBeat.o(113244);
  }
  
  public final void bUh()
  {
    AppMethodBeat.i(113248);
    ad.i("MicroMsg.CardDetailUI", "code change");
    if ((this.oEL.oFj instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.oEL.oFj).oJz = am.bVa().getCode();
      this.oEL.bVy();
    }
    AppMethodBeat.o(113248);
  }
  
  public final void bUm()
  {
    AppMethodBeat.i(113241);
    ad.i("MicroMsg.CardDetailUI", "onVibrate");
    this.nKv.vibrate(300L);
    AppMethodBeat.o(113241);
  }
  
  public final void bUn()
  {
    AppMethodBeat.i(113242);
    ad.i("MicroMsg.CardDetailUI", "onFinishUI");
    AppMethodBeat.o(113242);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113240);
    if (paramb == null)
    {
      ad.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if ((this.owK == null) || (!this.owK.bTR().equals(paramb.bTR())))
    {
      ad.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if (!this.oEL.bWJ())
    {
      ad.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    ad.i("MicroMsg.CardDetailUI", "onDataChange");
    this.owK = paramb;
    this.oww = this.owK.bTR();
    if ((this.owK.bTH()) && (am.bVa().isEmpty())) {
      am.bVa().Ye(this.owK.bTR());
    }
    bVy();
    AppMethodBeat.o(113240);
  }
  
  public final void eV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113245);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.oww)))
    {
      ad.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113245);
      return;
    }
    ad.i("MicroMsg.CardDetailUI", "onMarkFail()");
    this.oEP = false;
    this.oEQ = false;
    jt(false);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(2131756926);
    }
    com.tencent.mm.plugin.card.d.d.c(this, paramString1);
    AppMethodBeat.o(113245);
  }
  
  public int getLayoutId()
  {
    return 2131493272;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113221);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113200);
        CardDetailUI.h(CardDetailUI.this);
        AppMethodBeat.o(113200);
        return true;
      }
    });
    this.nKv = ((Vibrator)getSystemService("vibrator"));
    this.GG = findViewById(2131297780);
    Object localObject2;
    if (this.oEL == null)
    {
      this.oEL = new e(this, getContentView());
      localObject1 = this.oEL;
      ((e)localObject1).oFv = new j(((e)localObject1).owO);
      localObject2 = ((e)localObject1).oFv;
      ((j)localObject2).oCm = ((j)localObject2).oJq.getWindow().getAttributes().screenBrightness;
      if (((j)localObject2).jtC == null)
      {
        View localView = View.inflate(((j)localObject2).oJq, 2131493329, null);
        ((j)localObject2).jtE = localView.findViewById(2131303351);
        ((j)localObject2).jtD = ((ImageView)localView.findViewById(2131303350));
        ((j)localObject2).oJs = ((TextView)localView.findViewById(2131303353));
        ((j)localObject2).oJt = ((TextView)localView.findViewById(2131303352));
        ((j)localObject2).oJu = localView.findViewById(2131303347);
        ((j)localObject2).oJv = ((ImageView)localView.findViewById(2131303346));
        ((j)localObject2).oJw = ((MMVerticalTextView)localView.findViewById(2131306295));
        ((j)localObject2).oJx = ((MMVerticalTextView)localView.findViewById(2131306296));
        localView.setOnClickListener(new j.2((j)localObject2));
        ((j)localObject2).jtC = new com.tencent.mm.ui.base.o(localView, -1, -1, true);
        ((j)localObject2).jtC.update();
        ((j)localObject2).jtC.setBackgroundDrawable(new ColorDrawable(16777215));
        ((j)localObject2).jtC.setOnDismissListener(new j.3((j)localObject2));
      }
      ((e)localObject1).owO.setMMTitle("");
      ((e)localObject1).owO.setActionbarColor(((e)localObject1).owO.getResources().getColor(2131101179));
      ((e)localObject1).oFx = new com.tencent.mm.plugin.card.b.f(((e)localObject1).owO);
      ((e)localObject1).owO.mmSetOnActivityResultCallback((MMActivity.a)localObject1);
      com.tencent.mm.sdk.b.a.IbL.c(((e)localObject1).oFG);
      localObject1 = this.oEL;
      if (((e)localObject1).oFd == null)
      {
        ((e)localObject1).oFd = new x();
        ((e)localObject1).oFd.a((n)localObject1);
      }
      if (((e)localObject1).oFf == null)
      {
        ((e)localObject1).oFf = new com.tencent.mm.plugin.card.ui.view.o();
        ((e)localObject1).oFf.a((n)localObject1);
      }
      if (((e)localObject1).oFg == null)
      {
        ((e)localObject1).oFg = new com.tencent.mm.plugin.card.ui.view.a();
        ((e)localObject1).oFg.a((n)localObject1);
      }
      ((e)localObject1).mListView = ((ListView)((e)localObject1).findViewById(2131297930));
      ((e)localObject1).oFk = new m(((e)localObject1).owO.getContext());
      ((e)localObject1).oFk.oKd = ((e)localObject1).jtG;
      ((e)localObject1).mListView.setAdapter(((e)localObject1).oFk);
      ((e)localObject1).oFk.notifyDataSetChanged();
      ((e)localObject1).mListView.setOnItemClickListener(new e.1((e)localObject1));
      ad.i("MicroMsg.CardDetailUIContoller", "initMenu");
      ((e)localObject1).owO.addIconOptionMenu(0, 2131690603, new e.5((e)localObject1));
      ((e)localObject1).oFi = ((LinearLayout)((e)localObject1).findViewById(2131300735));
      ((e)localObject1).oFt = new com.tencent.mm.plugin.card.ui.view.d();
      ((e)localObject1).oFt.a((n)localObject1);
      ((e)localObject1).oFv.owK = ((e)localObject1).owK;
    }
    int i = getIntent().getIntExtra("key_from_scene", -1);
    ad.i("MicroMsg.CardDetailUI", "scene:%d", new Object[] { Integer.valueOf(i) });
    int j;
    if ((i == 2) || (i == 6) || (i == 5))
    {
      this.fPp = i;
      localObject1 = getIntent().getStringExtra("key_card_app_msg");
      localObject2 = com.tencent.mm.plugin.card.d.g.Zc((String)localObject1);
      if (localObject2 != null)
      {
        this.oww = ((com.tencent.mm.plugin.card.model.d)localObject2).dHX;
        this.oEM = ((com.tencent.mm.plugin.card.model.d)localObject2).ovl;
        this.oEO = ((com.tencent.mm.plugin.card.model.d)localObject2).dHY;
        j = ((com.tencent.mm.plugin.card.model.d)localObject2).ozf;
        ad.i("MicroMsg.CardDetailUI", "scene is " + i + ", isRecommend is " + j);
        if ((j == 1) && (i == 2)) {
          this.fPp = 23;
        }
        this.oES = ((com.tencent.mm.plugin.card.model.d)localObject2).ozg;
        ad.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.oES);
      }
      this.oEN = com.tencent.mm.plugin.card.d.g.Zd((String)localObject1);
      bWa();
      if (!TextUtils.isEmpty(this.oww)) {
        break label1849;
      }
      ad.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
      z(true, -1);
    }
    for (;;)
    {
      this.oEL.a(this.owK, this.oET, this.owR);
      this.oEL.oFD = new e.d()
      {
        public final void YJ(String paramAnonymousString)
        {
          AppMethodBeat.i(113202);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousString);
          AppMethodBeat.o(113202);
        }
        
        public final void b(com.tencent.mm.plugin.card.base.b paramAnonymousb)
        {
          AppMethodBeat.i(113207);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousb);
          CardDetailUI.b(CardDetailUI.this, paramAnonymousb.bTR());
          CardDetailUI.m(CardDetailUI.this).oww = CardDetailUI.n(CardDetailUI.this);
          AppMethodBeat.o(113207);
        }
        
        public final void bWe()
        {
          AppMethodBeat.i(113208);
          CardDetailUI.o(CardDetailUI.this);
          AppMethodBeat.o(113208);
        }
        
        public final void bWf()
        {
          AppMethodBeat.i(113201);
          CardDetailUI.i(CardDetailUI.this);
          AppMethodBeat.o(113201);
        }
        
        public final void bWg()
        {
          AppMethodBeat.i(113203);
          CardDetailUI.j(CardDetailUI.this);
          AppMethodBeat.o(113203);
        }
        
        public final void bWh()
        {
          AppMethodBeat.i(113204);
          CardDetailUI.k(CardDetailUI.this);
          AppMethodBeat.o(113204);
        }
        
        public final void bWi()
        {
          AppMethodBeat.i(113205);
          CardDetailUI.h(CardDetailUI.this);
          AppMethodBeat.o(113205);
        }
        
        public final void bWj()
        {
          AppMethodBeat.i(113206);
          CardDetailUI.l(CardDetailUI.this);
          AppMethodBeat.o(113206);
        }
        
        public final void bWk()
        {
          AppMethodBeat.i(113209);
          ad.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
          AppMethodBeat.o(113209);
        }
        
        public final void jw(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(113210);
          ad.i("MicroMsg.CardDetailUI", "doMark()");
          CardDetailUI.p(CardDetailUI.this);
          CardDetailUI.q(CardDetailUI.this);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousBoolean);
          if (CardDetailUI.r(CardDetailUI.this).bTG())
          {
            am.bUZ().U(CardDetailUI.n(CardDetailUI.this), com.tencent.mm.plugin.card.d.l.Zn(CardDetailUI.r(CardDetailUI.this).bTT()), 2);
            AppMethodBeat.o(113210);
            return;
          }
          am.bUZ().U(CardDetailUI.n(CardDetailUI.this), com.tencent.mm.plugin.card.d.l.Zn(CardDetailUI.r(CardDetailUI.this).bTT()), 1);
          AppMethodBeat.o(113210);
        }
      };
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
      ad.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      this.oDz = bool;
      if (this.oDz)
      {
        this.hQo = com.tencent.mm.modelgeo.d.aHQ();
        bTk();
      }
      AppMethodBeat.o(113221);
      return;
      if ((com.tencent.mm.plugin.card.d.l.AO(i)) || (i == 0) || (i == 1) || (i == 3) || (i == 4) || (i == 9) || (i == 12) || (i == 15) || (i == 17) || (i == 21))
      {
        this.fPp = i;
        this.oww = getIntent().getStringExtra("key_card_id");
        this.oEO = getIntent().getStringExtra("key_card_ext");
        this.oxW = getIntent().getBooleanExtra("key_is_share_card", false);
        this.oEs = getIntent().getIntExtra("key_stastic_scene", 0);
        this.oEv = getIntent().getStringExtra("key_consumed_card_id");
        if ((i == 7) || (i == 16))
        {
          this.oEt = getIntent().getStringExtra("src_username");
          this.oEu = getIntent().getStringExtra("js_url");
          this.hAT = getIntent().getStringExtra("key_template_id");
          break;
        }
        if ((this.oxW) && (i == 3))
        {
          this.oxI = getIntent().getStringExtra("key_card_tp_id");
          this.oww = com.tencent.mm.plugin.card.sharecard.a.b.eZ(this.oww, this.oxI);
          break;
        }
        if (i != 8) {
          break;
        }
        this.oEU = getIntent().getBooleanExtra("key_is_sms_add_card", false);
        break;
      }
      if ((i == 50) || (i == 27))
      {
        this.fPp = getIntent().getIntExtra("key_previous_scene", 50);
        if ((this.fPp != 26) && (this.fPp != 27)) {
          this.fPp = 3;
        }
        this.hAT = getIntent().getStringExtra("key_template_id");
        if (this.fPp == 27)
        {
          localObject1 = (com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info");
          if (localObject1 != null)
          {
            this.owK = ((com.tencent.mm.plugin.card.base.b)localObject1);
            this.oww = this.owK.bTR();
            bWa();
            bWd();
            if (this.owK.bTH()) {
              am.bVa().Ye(this.owK.bTR());
            }
            bVy();
          }
          bWb();
          com.tencent.mm.plugin.card.d.l.bYA();
        }
        else
        {
          localObject1 = getIntent().getStringExtra("card_list");
          localObject2 = getIntent().getStringExtra("key_app_id");
          localObject1 = com.tencent.mm.plugin.card.d.k.x((String)localObject1, this.fPp, (String)localObject2);
          if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
          {
            ad.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
            z(true, -1);
          }
          for (;;)
          {
            bWa();
            break;
            jt(true);
            this.oww = ((tt)((LinkedList)localObject1).get(0)).oxM;
            i = getIntent().getIntExtra("key_previous_scene", 51);
            localObject2 = new did();
            ((did)localObject2).HwU = this.hAT;
            ad.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.hAT });
            localObject1 = new t((LinkedList)localObject1, (did)localObject2, i, this.oww);
            com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject1, 0);
          }
        }
      }
      else if (i == 51)
      {
        if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {}
        for (this.fPp = 26;; this.fPp = 3)
        {
          this.oww = getIntent().getStringExtra("key_card_id");
          this.owK = am.bUS().own;
          if (this.owK == null) {
            this.owK = am.bUN().Yo(this.oww);
          }
          bWa();
          if (this.owK != null) {
            break label1697;
          }
          ad.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
          z(true, -1);
          break;
        }
        label1697:
        bWd();
        bVy();
        bWb();
        if (this.owK.bTH()) {
          am.bVa().Ye(this.owK.bTR());
        }
      }
      else
      {
        if (i == 26)
        {
          this.fPp = i;
          this.oww = getIntent().getStringExtra("key_card_id");
          this.oEO = getIntent().getStringExtra("key_card_ext");
          break;
        }
        this.fPp = i;
        localObject1 = getIntent().getStringExtra("key_card_app_msg");
        localObject2 = com.tencent.mm.plugin.card.d.g.Zc((String)localObject1);
        if (localObject2 != null)
        {
          this.oww = ((com.tencent.mm.plugin.card.model.d)localObject2).dHX;
          this.oEM = ((com.tencent.mm.plugin.card.model.d)localObject2).ovl;
          this.oEO = ((com.tencent.mm.plugin.card.model.d)localObject2).dHY;
        }
        this.oEN = com.tencent.mm.plugin.card.d.g.Zd((String)localObject1);
        break;
        label1849:
        if ((i == 2) || (i == 6) || ((i == 4) && (!this.oxW)) || (i == 5) || (i == 17) || (i == 21) || (i == 23)) {
          i = 1;
        }
        for (;;)
        {
          if ((i == 0) && (this.owK != null)) {
            break label2074;
          }
          ad.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.oww + " isShareCard is " + this.oxW);
          jt(true);
          this.GG.setVisibility(0);
          if (!this.oxW) {
            break label2067;
          }
          bWe();
          break;
          if (i == 15)
          {
            localObject1 = am.bUS().getValue("key_accept_card_info");
            if ((localObject1 != null) && ((localObject1 instanceof CardInfo)))
            {
              this.owK = ((CardInfo)localObject1);
              i = 0;
            }
            else
            {
              i = 1;
            }
          }
          else if (this.oxW)
          {
            this.owK = am.bUV().YE(this.oww);
            i = 0;
          }
          else
          {
            this.owK = am.bUN().Yo(this.oww);
            i = 0;
          }
        }
        label2067:
        bWc();
      }
    }
    label2074:
    ad.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.oww);
    Object localObject1 = this.owK.bTQ();
    if (localObject1 != null)
    {
      this.owR = new ArrayList();
      this.owR.add(localObject1);
    }
    bVy();
    if (this.owK.bTH()) {
      am.bVa().Ye(this.owK.bTR());
    }
    if (this.oxW)
    {
      this.oEV = true;
      i = 1;
      label2181:
      if (i == 0) {
        break label2317;
      }
      ad.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.oww + " isShareCard is " + this.oxW);
      if (!this.oxW) {
        break label2310;
      }
      bWe();
    }
    for (;;)
    {
      bWb();
      break;
      if ((int)(System.currentTimeMillis() / 1000L) - this.owK.bTU() >= 86400L) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label2288;
        }
        this.oEV = true;
        i = 1;
        break;
      }
      label2288:
      if (!this.owK.bTE()) {
        break label2181;
      }
      this.oEV = true;
      i = 1;
      break label2181;
      label2310:
      bWc();
      continue;
      label2317:
      bWd();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113214);
    super.onCreate(paramBundle);
    this.mStartTime = System.currentTimeMillis();
    bVY();
    paramBundle = am.bUY();
    AppCompatActivity localAppCompatActivity = getContext();
    com.tencent.mm.kernel.g.ajB().gAO.a(910, paramBundle);
    am.bUU().a(paramBundle);
    com.tencent.mm.plugin.card.b.b localb = am.bUM();
    if (localb.owv == null) {
      localb.owv = new ArrayList();
    }
    localb.owv.add(new WeakReference(paramBundle));
    paramBundle.mContextRef = new WeakReference(localAppCompatActivity);
    am.bUY().a(this);
    am.bUZ().a(this);
    paramBundle = am.bVa();
    com.tencent.mm.kernel.g.ajB().gAO.a(577, paramBundle);
    paramBundle.owx.clear();
    paramBundle.owy = 0;
    am.bVa().a(this);
    initView();
    AppMethodBeat.o(113214);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113218);
    am.bUY().c(this);
    bVZ();
    am.bUY().b(this);
    am.bUY().release();
    am.bUZ().b(this);
    am.bVa().b(this);
    am.bVa().release();
    Object localObject1 = this.oEL;
    Object localObject2 = ((e)localObject1).oFx;
    ((com.tencent.mm.plugin.card.b.f)localObject2).owK = null;
    ((com.tencent.mm.plugin.card.b.f)localObject2).owP.clear();
    ((e)localObject1).oFx = null;
    localObject2 = ((e)localObject1).oFv;
    com.tencent.mm.plugin.card.d.l.T(((j)localObject2).oJr);
    int i = ((j)localObject2).oJy.size() - 1;
    while (i >= 0)
    {
      com.tencent.mm.plugin.card.d.l.T((Bitmap)((j)localObject2).oJy.remove(i));
      i -= 1;
    }
    ((j)localObject2).oJy.clear();
    if (((j)localObject2).jtC.isShowing()) {
      ((j)localObject2).jtC.dismiss();
    }
    ((j)localObject2).jtC = null;
    ((j)localObject2).bXe();
    ((j)localObject2).oJq = null;
    ((j)localObject2).owK = null;
    ((e)localObject1).oFv = null;
    if (((e)localObject1).oFh != null) {
      ((e)localObject1).oFh.release();
    }
    ((e)localObject1).owO.mmSetOnActivityResultCallback(null);
    com.tencent.mm.sdk.b.a.IbL.d(((e)localObject1).oFG);
    ((e)localObject1).oFd.destroy();
    ((e)localObject1).oFg.destroy();
    ((e)localObject1).oFf.destroy();
    ((e)localObject1).oFt.destroy();
    if (((e)localObject1).oFu != null) {
      ((e)localObject1).oFu.destroy();
    }
    if (((e)localObject1).oFm != null) {
      ((e)localObject1).oFm.destroy();
    }
    if (((e)localObject1).oFl != null) {
      ((e)localObject1).oFl.destroy();
    }
    if (((e)localObject1).oFn != null) {
      ((e)localObject1).oFn.destroy();
    }
    if (((e)localObject1).oFo != null) {
      ((e)localObject1).oFo.destroy();
    }
    if (((e)localObject1).oFp != null) {
      ((e)localObject1).oFp.destroy();
    }
    if (((e)localObject1).oFq != null) {
      ((e)localObject1).oFq.destroy();
    }
    if (((e)localObject1).oFr != null) {
      ((e)localObject1).oFr.destroy();
    }
    if (((e)localObject1).oFs != null) {
      ((e)localObject1).oFs.destroy();
    }
    if (((e)localObject1).oFj != null) {
      ((e)localObject1).oFj.destroy();
    }
    ((e)localObject1).oFc = null;
    localObject2 = am.bVd();
    if (((com.tencent.mm.plugin.card.b.g)localObject2).owv != null)
    {
      i = 0;
      if (i < ((com.tencent.mm.plugin.card.b.g)localObject2).owv.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.card.b.g)localObject2).owv.get(i);
        if (localWeakReference == null) {
          break label748;
        }
        g.a locala = (g.a)localWeakReference.get();
        if ((locala == null) || (!locala.equals(localObject1))) {
          break label748;
        }
        ((com.tencent.mm.plugin.card.b.g)localObject2).owv.remove(localWeakReference);
      }
    }
    am.bVd().release();
    this.nKv.cancel();
    bTm();
    long l = System.currentTimeMillis() - this.mStartTime;
    if (this.owK != null)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(13219, new Object[] { "CardDetailView", Integer.valueOf(this.fPp), this.owK.bTS(), this.owK.bTR(), Long.valueOf(l) });
      label611:
      if (((this.oEP) || (this.oEQ)) && (this.owK != null) && (this.owK.bTt()))
      {
        if (!this.owK.bTG()) {
          break label808;
        }
        am.bUZ().cE(this.oww, 2);
      }
      label667:
      localObject1 = this.oEZ;
      ad.i("MicroMsg.CardLbsOrBluetooth", "uninit");
      if (((com.tencent.mm.plugin.card.b.i)localObject1).oxc != null)
      {
        localObject2 = ((com.tencent.mm.plugin.card.b.i)localObject1).oxc;
        if (((i.a)localObject2).kCT != null) {
          break label822;
        }
        ad.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.b.i)localObject1).oxc = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).bUu();
      ((com.tencent.mm.plugin.card.b.i)localObject1).oxh = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).owV = null;
      super.onDestroy();
      AppMethodBeat.o(113218);
      return;
      label748:
      i += 1;
      break;
      com.tencent.mm.plugin.report.service.g.yhR.f(13219, new Object[] { "CardDetailView", Integer.valueOf(this.fPp), this.oww, this.oww, Long.valueOf(l) });
      break label611;
      label808:
      am.bUZ().cE(this.oww, 1);
      break label667;
      label822:
      aj.getContext().unregisterReceiver(((i.a)localObject2).kCT);
      ((i.a)localObject2).kCT = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113232);
    if (paramInt == 4)
    {
      ad.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
      z(false, -1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113232);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113216);
    bVZ();
    super.onPause();
    this.oEL.dtm = true;
    am.bUY().a(this, false);
    bh.a(this, null);
    com.tencent.mm.plugin.card.b.i locali = this.oEZ;
    if (locali.bUx())
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "stop");
      if (locali.oxc != null) {
        locali.oxc.bUA();
      }
      locali.bUu();
      com.tencent.mm.kernel.g.ajB().gAO.b(2574, locali);
    }
    AppMethodBeat.o(113216);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(113238);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(113238);
      return;
    }
    ad.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113238);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ad.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.oDz);
        if (!this.oDz)
        {
          this.oDz = true;
          bVI();
        }
        AppMethodBeat.o(113238);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131757558), false, new CardDetailUI.4(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113215);
    super.onResume();
    bVY();
    if (this.hQo != null) {
      this.hQo.a(this.fFl, true);
    }
    this.oEL.dtm = false;
    bh.a(this, this);
    am.bUY().a(this, true);
    Object localObject;
    int i;
    if (((this.oEP) || (this.oEQ)) && (this.owK.bTt()))
    {
      if (!this.owK.bTG()) {
        break label224;
      }
      am.bUZ().cE(this.oww, 2);
      localObject = am.bUY();
      String str = this.oww;
      localObject = (Boolean)((com.tencent.mm.plugin.card.b.d)localObject).owJ.get(str);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
        break label208;
      }
      i = 1;
      if ((i == 0) || (TextUtils.isEmpty(am.bUY().owM))) {
        break label213;
      }
      ad.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
      Yg(am.bUY().owM);
      label171:
      this.oEL.oFj.d(com.tencent.mm.plugin.card.d.c.oPv);
    }
    for (;;)
    {
      if (this.oEZ.cAX) {
        this.oEZ.start();
      }
      AppMethodBeat.o(113215);
      return;
      label208:
      i = 0;
      break;
      label213:
      ad.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
      break label171;
      label224:
      am.bUZ().cE(this.oww, 1);
      localObject = this.oEL.oFj;
      if (localObject != null) {
        ((com.tencent.mm.plugin.card.ui.view.g)localObject).d(com.tencent.mm.plugin.card.d.c.oPv);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(113225);
    ad.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      jt(false);
      this.GG.setVisibility(8);
      Object localObject;
      if ((paramn instanceof aa))
      {
        paramString = ((aa)paramn).ozQ;
        if (TextUtils.isEmpty(paramString))
        {
          ad.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramn = this.owK;
        localObject = new CardInfo();
        com.tencent.mm.plugin.card.d.f.a((CardInfo)localObject, paramString);
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bTR()))
        {
          this.oww = ((com.tencent.mm.plugin.card.base.b)localObject).bTR();
          this.owK = ((com.tencent.mm.plugin.card.base.b)localObject);
          bWd();
          if (this.fPp == 3)
          {
            if (paramn != null)
            {
              ((CardInfo)this.owK).field_stickyAnnouncement = ((CardInfo)paramn).field_stickyAnnouncement;
              ((CardInfo)this.owK).field_stickyEndTime = ((CardInfo)paramn).field_stickyEndTime;
              ((CardInfo)this.owK).field_stickyIndex = ((CardInfo)paramn).field_stickyIndex;
              ((CardInfo)this.owK).field_label_wording = ((CardInfo)paramn).field_label_wording;
              this.owK.a(paramn.bTQ());
            }
            if (!this.oEV) {
              break label405;
            }
            com.tencent.mm.plugin.card.d.l.h(this.owK);
          }
        }
        for (;;)
        {
          bVy();
          bWb();
          if (this.owK.bTH()) {
            am.bVa().Ye(this.owK.bTR());
          }
          this.oEZ.a(this, this.oww, this.owK, this.fFf, this.fFg);
          AppMethodBeat.o(113225);
          return;
          if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bTR())) || (this.oww.equals(((com.tencent.mm.plugin.card.base.b)localObject).bTS()))) {
            break;
          }
          ad.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.oww, ((com.tencent.mm.plugin.card.base.b)localObject).bTS() });
          AppMethodBeat.o(113225);
          return;
          label405:
          ad.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.o))
      {
        if (this.oCq == 26) {
          jt(false);
        }
        localObject = ((com.tencent.mm.plugin.card.model.o)paramn).ozQ;
        paramInt1 = ((com.tencent.mm.plugin.card.model.o)paramn).ozR;
        paramn = ((com.tencent.mm.plugin.card.model.o)paramn).ozS;
        if (paramInt1 != 0) {
          c(paramInt2, paramString, paramInt1, paramn);
        }
        while (TextUtils.isEmpty((CharSequence)localObject))
        {
          ad.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
          AppMethodBeat.o(113225);
          return;
          com.tencent.mm.ui.base.h.cl(this, getResources().getString(2131756802));
        }
        this.fPp = 3;
        if (this.owK == null) {
          this.owK = new CardInfo();
        }
        com.tencent.mm.plugin.card.d.f.a((CardInfo)this.owK, (String)localObject);
        if (!TextUtils.isEmpty(this.owK.bTR())) {
          this.oww = this.owK.bTR();
        }
        if (this.oEL.bWI() == 1)
        {
          paramString = this.oEL;
          if (paramString.oFx != null)
          {
            paramString = paramString.oFx;
            if (paramString.owQ != null) {
              paramString.owQ.oxZ = false;
            }
          }
        }
        if (this.oCq != 26)
        {
          bWd();
          bVy();
        }
        com.tencent.mm.plugin.card.d.l.bYA();
        paramString = this.owK;
        if (paramString.bTu())
        {
          paramn = (Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrI, Integer.valueOf(0));
          if ((paramn == null) || (paramn.intValue() != 1))
          {
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IrI, Integer.valueOf(1));
            if (!com.tencent.mm.plugin.card.d.l.bYD()) {
              break label908;
            }
            com.tencent.mm.plugin.card.d.d.c(this, 2131493349, 2131756799, paramString.bTN().ozd);
          }
          label737:
          this.oEY = this.owK.bTX();
          if ((this.oCq != 7) && (this.oCq != 16)) {
            break label930;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.oEY);
          setResult(-1, paramString);
          AA(-1);
        }
        for (;;)
        {
          if (this.owK.bTH()) {
            am.bVa().Ye(this.owK.bTR());
          }
          this.oEZ.a(this, this.oww, this.owK, this.fFf, this.fFg);
          AppMethodBeat.o(113225);
          return;
          paramn = (Integer)com.tencent.mm.kernel.g.ajC().ajl().get(282884, null);
          if ((paramn != null) && (paramn.intValue() == 1)) {
            break label737;
          }
          com.tencent.mm.kernel.g.ajC().ajl().set(282884, Integer.valueOf(1));
          break;
          label908:
          com.tencent.mm.plugin.card.d.d.c(this, 2131493348, 2131756798, paramString.bTN().ozd);
          break label737;
          label930:
          if ((!this.oEU) && (this.oCq == 8)) {
            z(true, -1);
          } else if ((this.oCq == 26) && (paramInt1 == 0)) {
            z(true, -1);
          }
        }
      }
      if ((paramn instanceof v))
      {
        this.owR = ((v)paramn).ozY;
        if ((this.owK != null) && (this.owR != null) && (this.owR.size() > 0))
        {
          this.owK.a((tl)this.owR.get(0));
          bVy();
          if (this.owK.bTt())
          {
            paramString = am.bUV().YE(this.oww);
            if (paramString != null)
            {
              paramString.a((tl)this.owR.get(0));
              am.bUV().update(paramString, new String[] { this.oww });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.bUN().Yo(this.oww);
          if (paramString != null)
          {
            paramString.a((tl)this.owR.get(0));
            am.bUN().update(paramString, new String[] { this.oww });
          }
          AppMethodBeat.o(113225);
          return;
        }
        if ((this.owK != null) && (this.owR == null))
        {
          this.owK.a(null);
          bVy();
          if (this.owK.bTt())
          {
            paramString = am.bUV().YE(this.oww);
            if (paramString != null)
            {
              paramString.a(null);
              am.bUV().update(paramString, new String[] { this.oww });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.bUN().Yo(this.oww);
          if (paramString != null)
          {
            paramString.a(null);
            am.bUN().update(paramString, new String[] { this.oww });
          }
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof af))
      {
        paramInt1 = ((af)paramn).ozR;
        localObject = ((af)paramn).ozS;
        if (paramInt1 == 10000)
        {
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = getString(2131756852);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          AppMethodBeat.o(113225);
          return;
        }
        this.oEO = ((af)paramn).dHY;
        jv(true);
        paramString = this.owK.bTO();
        paramString.status = 3;
        this.owK.a(paramString);
        com.tencent.mm.plugin.card.d.l.h(this.owK);
        bVy();
        if (this.oCq == 3)
        {
          z(true, 2);
          AppMethodBeat.o(113225);
          return;
        }
        if (this.oCq == 15)
        {
          paramString = new tn();
          com.tencent.mm.sdk.b.a.IbL.l(paramString);
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof r))
      {
        com.tencent.mm.ui.base.h.cl(this, getResources().getString(2131756828));
        am.bUM();
        com.tencent.mm.plugin.card.b.b.Ao(4);
        z(true, 1);
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof t))
      {
        paramString = (t)paramn;
        paramn = paramString.ozW;
        if ((paramn != null) && (paramn.size() > 0))
        {
          paramn = (com.tencent.mm.plugin.card.base.b)paramn.get(0);
          if ((paramn != null) && (!this.oww.equals(paramString.cardId)))
          {
            ad.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.oww, paramString.cardId });
            AppMethodBeat.o(113225);
            return;
          }
          this.owK = paramn;
          if (this.owK != null)
          {
            this.oww = this.owK.bTR();
            bWd();
            if (this.owK.bTH()) {
              am.bVa().Ye(this.owK.bTR());
            }
          }
          if (this.fPp == 26) {
            this.fPp = 3;
          }
          bVy();
        }
        bWb();
        com.tencent.mm.plugin.card.d.l.bYA();
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).ozQ;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).ozR;
        paramn = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).ozS;
        if (paramInt1 != 0)
        {
          paramString = paramn;
          if (TextUtils.isEmpty(paramn)) {
            paramString = getString(2131756790);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          ad.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", new Object[] { paramString });
          AppMethodBeat.o(113225);
          return;
        }
        com.tencent.mm.ui.base.h.cl(this, getResources().getString(2131756794));
        if (TextUtils.isEmpty(paramString))
        {
          ad.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
          AppMethodBeat.o(113225);
          return;
        }
        this.fPp = 3;
        if (this.owK == null)
        {
          this.owK = new ShareCardInfo();
          com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)this.owK, paramString);
          paramn = (ShareCardInfo)this.owK;
          if (!TextUtils.isEmpty(paramString)) {
            break label2149;
          }
          ad.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
          label1885:
          if (!TextUtils.isEmpty(this.owK.bTR())) {
            this.oww = this.owK.bTR();
          }
          if (TextUtils.isEmpty(this.owK.bTT())) {
            ((ShareCardInfo)this.owK).field_from_username = u.aAm();
          }
          com.tencent.mm.plugin.card.d.l.a((ShareCardInfo)this.owK);
          bWd();
          bVy();
          com.tencent.mm.plugin.card.d.l.bYC();
          am.bUU().onChange();
          this.oEY = this.owK.bTX();
          if ((this.oCq != 7) && (this.oCq != 16)) {
            break label2241;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.oEY);
          setResult(-1, paramString);
          AA(-1);
        }
        for (;;)
        {
          for (;;)
          {
            paramString = (Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrG, Integer.valueOf(0));
            if ((paramString == null) || (paramString.intValue() != 1))
            {
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IrG, Integer.valueOf(1));
              com.tencent.mm.plugin.card.d.d.c(this, 2131493351, 2131756987, "");
            }
            if (this.owK.bTH()) {
              am.bVa().Ye(this.owK.bTR());
            }
            AppMethodBeat.o(113225);
            return;
            if (!(this.owK instanceof CardInfo)) {
              break;
            }
            this.owK = new ShareCardInfo();
            break;
            try
            {
              label2149:
              paramString = new JSONObject(paramString).optJSONArray("card_list");
              if (paramString == null) {
                break label1885;
              }
              paramn.oxP = paramString.optJSONObject(0).optString("encrypt_code");
              ad.i("MicroMsg.CardInfoParser", "encrypt_code:" + paramn.oxP);
            }
            catch (JSONException paramString)
            {
              ad.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
              ad.e("MicroMsg.CardInfoParser", paramString.getMessage());
            }
          }
          break label1885;
          label2241:
          if ((!this.oEU) && (this.oCq == 8)) {
            z(true, -1);
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.c))
      {
        paramn = ((com.tencent.mm.plugin.card.sharecard.model.c)paramn).ozQ;
        if (TextUtils.isEmpty(paramn))
        {
          ad.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramString = this.owK;
        this.owK = new ShareCardInfo();
        localObject = (ShareCardInfo)this.owK;
        if (TextUtils.isEmpty(paramn))
        {
          ad.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
          if (paramString != null)
          {
            if (!TextUtils.isEmpty(paramString.bTT())) {
              ((ShareCardInfo)this.owK).field_from_username = ((ShareCardInfo)paramString).field_from_username;
            }
            ((ShareCardInfo)this.owK).field_app_id = ((ShareCardInfo)paramString).field_app_id;
            ((ShareCardInfo)this.owK).field_consumer = ((ShareCardInfo)paramString).field_consumer;
            ((ShareCardInfo)this.owK).field_share_time = ((ShareCardInfo)paramString).field_share_time;
            ((ShareCardInfo)this.owK).field_updateTime = ((ShareCardInfo)paramString).field_updateTime;
            ((ShareCardInfo)this.owK).field_begin_time = ((ShareCardInfo)paramString).field_begin_time;
            ((ShareCardInfo)this.owK).field_end_time = ((ShareCardInfo)paramString).field_end_time;
            ((ShareCardInfo)this.owK).field_block_mask = ((ShareCardInfo)paramString).field_block_mask;
            this.owK.a(paramString.bTQ());
            ((ShareCardInfo)this.owK).field_categoryType = ((ShareCardInfo)paramString).field_categoryType;
            ((ShareCardInfo)this.owK).field_itemIndex = ((ShareCardInfo)paramString).field_itemIndex;
            if (((ShareCardInfo)paramString).field_status != ((ShareCardInfo)this.owK).field_status)
            {
              ad.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo)this.owK).field_status);
              com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.owK);
            }
          }
          if (!TextUtils.isEmpty(this.owK.bTR())) {
            this.oww = this.owK.bTR();
          }
          bVy();
          bWd();
          bWb();
          if (this.fPp == 3)
          {
            if (!this.oEV) {
              break label2742;
            }
            com.tencent.mm.plugin.card.d.l.h(this.owK);
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (this.owK.bTH()) {
              am.bVa().Ye(this.owK.bTR());
            }
            AppMethodBeat.o(113225);
            return;
            try
            {
              com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)localObject, new JSONObject(paramn));
            }
            catch (JSONException paramn)
            {
              ad.printErrStackTrace("MicroMsg.CardInfoParser", paramn, "", new Object[0]);
            }
          }
          break;
          label2742:
          ad.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.a))
      {
        if (((com.tencent.mm.plugin.card.sharecard.model.a)paramn).ozR != 0)
        {
          com.tencent.mm.plugin.card.d.d.c(this, getString(2131756826));
          AppMethodBeat.o(113225);
          return;
        }
        ad.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.owK.bTR());
        com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.owK);
        com.tencent.mm.ui.base.h.cl(this, getResources().getString(2131756828));
        am.bUU().bVo();
        z(true, -1);
        AppMethodBeat.o(113225);
      }
    }
    else
    {
      ad.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " cmd:" + paramn.getType());
      jt(false);
      if (!(paramn instanceof af)) {
        break label3010;
      }
      jv(false);
      paramInt1 = ((af)paramn).ozR;
      paramn = ((af)paramn).ozS;
      if (paramInt1 != 10000) {
        break label3067;
      }
      paramString = paramn;
      if (TextUtils.isEmpty(paramn)) {
        paramString = getString(2131756852);
      }
    }
    label3010:
    label3067:
    for (;;)
    {
      paramn = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramn = getString(2131757027);
      }
      Toast.makeText(getContext(), paramn, 0).show();
      AppMethodBeat.o(113225);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.card.model.o))
      {
        AA(0);
        c(paramInt2, paramString, ((com.tencent.mm.plugin.card.model.o)paramn).ozR, ((com.tencent.mm.plugin.card.model.o)paramn).ozS);
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof v))
      {
        AppMethodBeat.o(113225);
        return;
      }
    }
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113250);
    if ((this.oEL.oFj instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.oEL.oFj).oJz = am.bVa().getCode();
      this.oEL.bVy();
    }
    ad.i("MicroMsg.CardDetailUI", "code get success");
    AppMethodBeat.o(113250);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI
 * JD-Core Version:    0.7.0.1
 */