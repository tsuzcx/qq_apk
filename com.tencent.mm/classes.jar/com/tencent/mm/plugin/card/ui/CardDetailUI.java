package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.vp;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
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
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.ui.view.x;
import com.tencent.mm.protocal.protobuf.eml;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.protocal.protobuf.vc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.s;
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
  implements com.tencent.mm.an.i, c.a, d.a, j.a, ScreenShotUtil.ScreenShotCallback
{
  private final String TAG;
  private View Xd;
  private float iQD;
  private float iQE;
  private b.a iQJ;
  private int jaR;
  private s jhZ;
  private com.tencent.mm.modelgeo.d lEL;
  private String lnb;
  MMHandler mHandler;
  private long mStartTime;
  private Vibrator rqC;
  private String tmG;
  private com.tencent.mm.plugin.card.base.b tmU;
  private String tnT;
  private ArrayList<uu> tnb;
  private boolean tog;
  private int tsD;
  private boolean tsQ;
  private boolean ttL;
  private int tuE;
  private String tuF;
  private String tuG;
  private String tuH;
  e tuX;
  private String tuY;
  private String tuZ;
  private String tva;
  private boolean tvb;
  private boolean tvc;
  private boolean tvd;
  private String tve;
  private e.a tvf;
  private boolean tvg;
  private boolean tvh;
  private boolean tvi;
  private boolean tvj;
  private String tvk;
  private com.tencent.mm.plugin.card.b.i tvl;
  
  public CardDetailUI()
  {
    AppMethodBeat.i(113213);
    this.TAG = "MicroMsg.CardDetailUI";
    this.jhZ = null;
    this.tmG = "";
    this.tnT = "";
    this.tuY = "";
    this.tuZ = "";
    this.tva = "";
    this.tuF = "";
    this.tuG = "";
    this.tuH = "";
    this.tog = false;
    this.tvb = false;
    this.tvc = false;
    this.tvd = false;
    this.lnb = "";
    this.tve = "";
    this.tsQ = false;
    this.mHandler = new MMHandler();
    this.jaR = 3;
    this.tuE = 0;
    this.tsD = -1;
    this.tvg = false;
    this.tvh = true;
    this.mStartTime = 0L;
    this.tvi = false;
    this.ttL = false;
    this.tvj = false;
    this.iQD = -85.0F;
    this.iQE = -1000.0F;
    this.tvk = "";
    this.tvl = new com.tencent.mm.plugin.card.b.i();
    this.iQJ = new b.a()
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
          am.cHy().T(CardDetailUI.a(CardDetailUI.this), CardDetailUI.b(CardDetailUI.this));
        }
        com.tencent.mm.plugin.card.b.i locali = CardDetailUI.c(CardDetailUI.this);
        paramAnonymousFloat1 = CardDetailUI.b(CardDetailUI.this);
        paramAnonymousFloat2 = CardDetailUI.a(CardDetailUI.this);
        synchronized (locali.tnh)
        {
          locali.iQD = paramAnonymousFloat2;
          locali.iQE = paramAnonymousFloat1;
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
  
  private void F(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(113233);
    Intent localIntent;
    if (paramInt == 1)
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.tvk);
      localIntent.putExtra("key_card_id", this.tmG);
      localIntent.putExtra("key_finish_action", paramInt);
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.tsD == 7) || (this.tsD == 8) || (this.tsD == 16) || (this.tsD == 26)) && (this.jaR == 3))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.tvk);
      if (paramInt > 0)
      {
        localIntent.putExtra("key_card_id", this.tmG);
        localIntent.putExtra("key_finish_action", paramInt);
      }
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.tsD == 7) && (this.jaR == 7)) || ((this.tsD == 16) && (this.jaR == 16)) || ((this.tsD == 8) && (this.jaR == 8)) || ((this.tsD == 26) && (this.jaR == 26)))
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
  
  private void HS(int paramInt)
  {
    AppMethodBeat.i(113234);
    if ((this.tsD != 7) && (this.tsD != 16))
    {
      Log.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
      AppMethodBeat.o(113234);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new com.tencent.mm.plugin.card.model.e();
    ((com.tencent.mm.plugin.card.model.e)localObject).tnX = this.tmU.cGx();
    ((com.tencent.mm.plugin.card.model.e)localObject).fUM = this.tva;
    ((com.tencent.mm.plugin.card.model.e)localObject).code = this.tvk;
    localLinkedList.add(localObject);
    localObject = new com.tencent.mm.f.a.b();
    ((com.tencent.mm.f.a.b)localObject).fuo.resultCode = paramInt;
    if (paramInt == -1) {}
    for (((com.tencent.mm.f.a.b)localObject).fuo.fup = com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.tsD);; ((com.tencent.mm.f.a.b)localObject).fuo.fup = com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.tsD))
    {
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(113234);
      return;
    }
  }
  
  private void a(j.b paramb)
  {
    AppMethodBeat.i(113247);
    if (this.tuX.fEs)
    {
      Log.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
      AppMethodBeat.o(113247);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
    this.tuX.a(this.tvd, paramb, true);
    AppMethodBeat.o(113247);
  }
  
  /* Error */
  private void aqO(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 320
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 127	com/tencent/mm/plugin/card/ui/CardDetailUI:tsQ	Z
    //   12: ifeq +20 -> 32
    //   15: ldc 91
    //   17: ldc_w 322
    //   20: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 320
    //   26: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: ldc 91
    //   34: ldc_w 327
    //   37: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 127	com/tencent/mm/plugin/card/ui/CardDetailUI:tsQ	Z
    //   45: new 176	android/content/Intent
    //   48: dup
    //   49: aload_0
    //   50: ldc_w 329
    //   53: invokespecial 332	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   56: astore_2
    //   57: aload_2
    //   58: ldc_w 334
    //   61: aload_0
    //   62: getfield 216	com/tencent/mm/plugin/card/ui/CardDetailUI:tmU	Lcom/tencent/mm/plugin/card/base/b;
    //   65: invokeinterface 296 1 0
    //   70: invokevirtual 183	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   73: pop
    //   74: aload_2
    //   75: ldc_w 336
    //   78: aload_1
    //   79: invokevirtual 183	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   82: pop
    //   83: aload_2
    //   84: ldc_w 338
    //   87: aload_0
    //   88: getfield 216	com/tencent/mm/plugin/card/ui/CardDetailUI:tmU	Lcom/tencent/mm/plugin/card/base/b;
    //   91: invokeinterface 342 1 0
    //   96: getfield 347	com/tencent/mm/protocal/protobuf/vb:lmL	Ljava/lang/String;
    //   99: invokevirtual 183	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   102: pop
    //   103: aload_2
    //   104: ldc_w 349
    //   107: aload_0
    //   108: getfield 134	com/tencent/mm/plugin/card/ui/CardDetailUI:jaR	I
    //   111: invokevirtual 190	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   114: pop
    //   115: aload_2
    //   116: ldc_w 351
    //   119: iconst_0
    //   120: invokevirtual 190	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   123: pop
    //   124: new 353	com/tencent/mm/hellhoundlib/b/a
    //   127: dup
    //   128: invokespecial 354	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   131: aload_2
    //   132: invokevirtual 358	com/tencent/mm/hellhoundlib/b/a:bm	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   135: astore_1
    //   136: aload_0
    //   137: aload_1
    //   138: invokevirtual 362	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
    //   141: ldc_w 363
    //   144: ldc_w 365
    //   147: ldc_w 366
    //   150: ldc_w 368
    //   153: ldc_w 370
    //   156: ldc_w 372
    //   159: invokestatic 378	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_0
    //   163: aload_1
    //   164: iconst_0
    //   165: invokevirtual 382	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
    //   168: checkcast 176	android/content/Intent
    //   171: invokevirtual 384	com/tencent/mm/plugin/card/ui/CardDetailUI:startActivity	(Landroid/content/Intent;)V
    //   174: aload_0
    //   175: ldc_w 363
    //   178: ldc_w 365
    //   181: ldc_w 366
    //   184: ldc_w 368
    //   187: ldc_w 370
    //   190: ldc_w 372
    //   193: invokestatic 388	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   196: ldc_w 320
    //   199: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: goto -173 -> 29
    //   205: astore_1
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_1
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	CardDetailUI
    //   0	210	1	paramString	String
    //   56	76	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   2	29	205	finally
    //   32	202	205	finally
  }
  
  private void c(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(113226);
    Log.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + paramInt1 + " errMsg = " + paramString1 + " ret_code:" + paramInt2 + " ret_msg:" + paramString2);
    if (paramInt2 == 10000)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = getString(a.g.tjz);
      }
      this.tmU.cGt().status = 4;
      cIg();
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
          paramString1 = getString(a.g.tjC);
        }
        this.tmU.cGt().status = 5;
        cIg();
      }
      else if (paramInt2 == 10002)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(a.g.tlh);
        }
      }
      else
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(a.g.tjx);
        }
      }
    }
  }
  
  private void cFN()
  {
    AppMethodBeat.i(113235);
    if (this.lEL == null) {
      this.lEL = com.tencent.mm.modelgeo.d.blq();
    }
    this.lEL.a(this.iQJ, true);
    AppMethodBeat.o(113235);
  }
  
  private void cFQ()
  {
    AppMethodBeat.i(113236);
    if (this.lEL != null) {
      this.lEL.b(this.iQJ);
    }
    AppMethodBeat.o(113236);
  }
  
  private void cIF()
  {
    AppMethodBeat.i(113219);
    com.tencent.mm.kernel.h.aHF().kcd.a(1057, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1037, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1058, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1045, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1077, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1099, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(902, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1051, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1163, this);
    AppMethodBeat.o(113219);
  }
  
  private void cIG()
  {
    AppMethodBeat.i(113220);
    com.tencent.mm.kernel.h.aHF().kcd.b(1057, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1037, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1058, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1045, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1077, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1099, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(902, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1051, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1163, this);
    AppMethodBeat.o(113220);
  }
  
  private void cIH()
  {
    AppMethodBeat.i(113222);
    this.tsD = this.jaR;
    this.tvf = new e.a();
    this.tvf.jaR = this.jaR;
    this.tvf.tsD = this.tsD;
    this.tvf.tmG = this.tmG;
    this.tvf.tuY = this.tuY;
    this.tvf.tva = this.tva;
    this.tvf.tuZ = this.tuZ;
    this.tvf.tuF = this.tuF;
    this.tvf.tuG = this.tuG;
    this.tvf.tog = this.tog;
    this.tvf.tvW = getIntent().getIntExtra("key_from_appbrand_type", 0);
    AppMethodBeat.o(113222);
  }
  
  private void cII()
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113223);
    if ((this.tvi) || (this.tmU == null))
    {
      AppMethodBeat.o(113223);
      return;
    }
    this.tvi = true;
    if (this.tog)
    {
      localh = com.tencent.mm.plugin.report.service.h.IzE;
      j = this.tmU.cGs().qJt;
      str1 = this.tmU.cGx();
      str2 = this.tmU.cGw();
      k = this.tsD;
      str3 = this.tuY;
      if (this.tmU.cGq()) {}
      for (;;)
      {
        localh.a(11324, new Object[] { "ShareCardDetailUI", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
        AppMethodBeat.o(113223);
        return;
        i = 0;
      }
    }
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    int k = this.tmU.cGs().qJt;
    String str1 = this.tmU.cGx();
    String str2 = this.tmU.cGw();
    int m = this.tsD;
    String str3 = this.tuY;
    if (this.tmU.cGq()) {}
    for (i = j;; i = 0)
    {
      localh.a(11324, new Object[] { "CardDetailView", Integer.valueOf(k), str1, str2, Integer.valueOf(0), Integer.valueOf(m), str3, Integer.valueOf(i), "" });
      AppMethodBeat.o(113223);
      return;
    }
  }
  
  private void cIJ()
  {
    AppMethodBeat.i(113229);
    Object localObject = new eml();
    ((eml)localObject).UoY = this.lnb;
    ((eml)localObject).tpq = this.tve;
    Log.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", new Object[] { this.lnb });
    localObject = new aa(this.tmG, this.jaR, this.tuY, this.tva, this.tuF, this.tuG, this.tuE, this.tuH, (eml)localObject);
    com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject, 0);
    AppMethodBeat.o(113229);
  }
  
  private void cIK()
  {
    AppMethodBeat.i(113230);
    Object localObject;
    if (!TextUtils.isEmpty(this.tmU.cGx())) {
      localObject = this.tmU.cGx();
    }
    while ((this.tmU != null) && (this.tmU.cGs().SfT == 1))
    {
      float f2 = this.iQD;
      float f3 = this.iQE;
      float f1;
      if (f2 != -85.0F)
      {
        f1 = f3;
        if (f3 != -1000.0F) {}
      }
      else
      {
        f2 = am.cHy().iQD;
        f1 = am.cHy().iQE;
      }
      localObject = new v((String)localObject, f1, f2, this.tmU.cGw());
      com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject, 0);
      AppMethodBeat.o(113230);
      return;
      if (!TextUtils.isEmpty(this.tmG))
      {
        localObject = this.tmG;
      }
      else
      {
        Log.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
        AppMethodBeat.o(113230);
        return;
      }
    }
    if ((this.tmU != null) && (this.tmU.cGs().SfT > 1))
    {
      if ((this.iQD != -85.0F) && (this.iQE != -1000.0F))
      {
        this.tvj = false;
        localObject = new v((String)localObject, this.iQE, this.iQD, this.tmU.cGw());
        com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject, 0);
        AppMethodBeat.o(113230);
        return;
      }
      if (!this.tvj)
      {
        this.tvj = true;
        if (this.ttL)
        {
          cFN();
          AppMethodBeat.o(113230);
        }
      }
    }
    else if (this.tmU != null)
    {
      this.tmU.a(null);
      cIg();
      if (this.tmU.cFX())
      {
        localObject = am.cHA().arn(this.tmG);
        if (localObject != null)
        {
          ((ShareCardInfo)localObject).a(null);
          am.cHA().update((IAutoDBItem)localObject, new String[] { this.tmG });
        }
        AppMethodBeat.o(113230);
        return;
      }
      localObject = am.cHs().aqX(this.tmG);
      if (localObject != null)
      {
        ((CardInfo)localObject).a(null);
        am.cHs().update((IAutoDBItem)localObject, new String[] { this.tmG });
      }
    }
    AppMethodBeat.o(113230);
  }
  
  private void cIL()
  {
    AppMethodBeat.i(113231);
    com.tencent.mm.plugin.card.sharecard.model.c localc = new com.tencent.mm.plugin.card.sharecard.model.c(this.tmG);
    com.tencent.mm.kernel.h.aHF().kcd.a(localc, 0);
    AppMethodBeat.o(113231);
  }
  
  private void cIg()
  {
    AppMethodBeat.i(113224);
    this.tvf.jaR = this.jaR;
    this.tvf.tsD = this.tsD;
    this.tvf.tmG = this.tmG;
    this.tuX.a(this.tmU, this.tvf, this.tnb);
    this.tuX.cIg();
    am.cHD().tmU = this.tmU;
    AppMethodBeat.o(113224);
  }
  
  private void cIp()
  {
    AppMethodBeat.i(113237);
    this.lEL = com.tencent.mm.modelgeo.d.blq();
    cFN();
    AppMethodBeat.o(113237);
  }
  
  private void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(113227);
    if (paramBoolean)
    {
      this.jhZ = s.a(this, getString(a.g.loading_tips), true, 0, null);
      AppMethodBeat.o(113227);
      return;
    }
    if ((this.jhZ != null) && (this.jhZ.isShowing()))
    {
      this.jhZ.dismiss();
      this.jhZ = null;
    }
    AppMethodBeat.o(113227);
  }
  
  private void lI(boolean paramBoolean)
  {
    AppMethodBeat.i(113228);
    if (paramBoolean) {
      com.tencent.mm.plugin.card.d.l.fP(this.tuX.tvL, this.tuX.tvK);
    }
    AppMethodBeat.o(113228);
  }
  
  public final void aqM(String paramString)
  {
    AppMethodBeat.i(113249);
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    }
    AppMethodBeat.o(113249);
  }
  
  public final void aqP(final String paramString)
  {
    AppMethodBeat.i(113243);
    if (!this.tuX.cJq())
    {
      Log.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
      AppMethodBeat.o(113243);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
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
  
  public final void aqS(String paramString)
  {
    AppMethodBeat.i(113246);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.tmG)))
    {
      Log.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113246);
      return;
    }
    this.tvb = false;
    AppMethodBeat.o(113246);
  }
  
  public final void b(String paramString, j.b paramb)
  {
    AppMethodBeat.i(113244);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.tmG)))
    {
      Log.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113244);
      return;
    }
    lG(false);
    Log.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
    Log.i("MicroMsg.CardDetailUI", "markSucc:" + paramb.tnL + " markCardId: " + paramb.tnM);
    this.tvc = false;
    if (paramb.tnL == 1)
    {
      if ((!TextUtils.isEmpty(paramb.tnM)) && (!this.tmU.cGw().equals(paramb.tnM)))
      {
        Log.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
        if (this.tmU.cFX())
        {
          paramString = am.cHA().arn(paramb.tnM);
          if (paramString != null)
          {
            this.tmU = paramString;
            this.tmG = paramb.tnM;
            cIg();
            am.cHD().b(this.tmU);
            Log.i("MicroMsg.CardDetailUI", "update the mCardInfo");
            this.tvb = true;
            a(paramb);
            AppMethodBeat.o(113244);
            return;
          }
          Log.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
          com.tencent.mm.plugin.card.d.d.c(this, getString(a.g.tkT));
          this.tvb = false;
          AppMethodBeat.o(113244);
        }
      }
      else
      {
        Log.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
        this.tvb = true;
        a(paramb);
        AppMethodBeat.o(113244);
      }
    }
    else
    {
      this.tvb = false;
      com.tencent.mm.plugin.card.d.d.c(this, getString(a.g.tkU));
    }
    AppMethodBeat.o(113244);
  }
  
  public final void cGM()
  {
    AppMethodBeat.i(113248);
    Log.i("MicroMsg.CardDetailUI", "code change");
    if ((this.tuX.tvv instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.tuX.tvv).tzM = am.cHF().getCode();
      this.tuX.cIg();
    }
    AppMethodBeat.o(113248);
  }
  
  public final void cGR()
  {
    AppMethodBeat.i(113241);
    Log.i("MicroMsg.CardDetailUI", "onVibrate");
    this.rqC.vibrate(300L);
    AppMethodBeat.o(113241);
  }
  
  public final void cGS()
  {
    AppMethodBeat.i(113242);
    Log.i("MicroMsg.CardDetailUI", "onFinishUI");
    AppMethodBeat.o(113242);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113240);
    if (paramb == null)
    {
      Log.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if ((this.tmU == null) || (!this.tmU.cGw().equals(paramb.cGw())))
    {
      Log.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if (!this.tuX.cJq())
    {
      Log.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "onDataChange");
    this.tmU = paramb;
    this.tmG = this.tmU.cGw();
    if ((this.tmU.cGl()) && (am.cHF().isEmpty())) {
      am.cHF().aqN(this.tmU.cGw());
    }
    cIg();
    AppMethodBeat.o(113240);
  }
  
  public final void fE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113245);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.tmG)))
    {
      Log.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113245);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "onMarkFail()");
    this.tvb = false;
    this.tvc = false;
    lG(false);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(a.g.tkT);
    }
    com.tencent.mm.plugin.card.d.d.c(this, paramString1);
    AppMethodBeat.o(113245);
  }
  
  public int getLayoutId()
  {
    return a.e.thZ;
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
    this.rqC = ((Vibrator)getSystemService("vibrator"));
    this.Xd = findViewById(a.d.tbN);
    Object localObject2;
    if (this.tuX == null)
    {
      this.tuX = new e(this, getContentView());
      localObject1 = this.tuX;
      ((e)localObject1).tvH = new j(((e)localObject1).tmY);
      localObject2 = ((e)localObject1).tvH;
      ((j)localObject2).tsz = ((j)localObject2).tzD.getWindow().getAttributes().screenBrightness;
      if (((j)localObject2).nmy == null)
      {
        View localView = View.inflate(((j)localObject2).tzD, a.e.tiZ, null);
        ((j)localObject2).nmA = localView.findViewById(a.d.popupwd_qrcode_layout);
        ((j)localObject2).nmz = ((ImageView)localView.findViewById(a.d.popupwd_qrcode_iv));
        ((j)localObject2).tzF = ((TextView)localView.findViewById(a.d.tgu));
        ((j)localObject2).tzG = ((TextView)localView.findViewById(a.d.tgt));
        ((j)localObject2).tzH = localView.findViewById(a.d.popupwd_barcode_layout);
        ((j)localObject2).tzI = ((ImageView)localView.findViewById(a.d.popupwd_barcode_iv));
        ((j)localObject2).tzJ = ((MMVerticalTextView)localView.findViewById(a.d.vertical_barcode_text));
        ((j)localObject2).tzK = ((MMVerticalTextView)localView.findViewById(a.d.thG));
        localView.setOnClickListener(new j.2((j)localObject2));
        ((j)localObject2).nmy = new com.tencent.mm.ui.base.r(localView, -1, -1, true);
        ((j)localObject2).nmy.update();
        ((j)localObject2).nmy.setBackgroundDrawable(new ColorDrawable(16777215));
        ((j)localObject2).nmy.setOnDismissListener(new j.3((j)localObject2));
      }
      ((e)localObject1).tmY.setMMTitle("");
      ((e)localObject1).tmY.setActionbarColor(((e)localObject1).tmY.getResources().getColor(a.a.white));
      ((e)localObject1).tvJ = new com.tencent.mm.plugin.card.b.f(((e)localObject1).tmY);
      ((e)localObject1).tmY.mmSetOnActivityResultCallback((MMActivity.a)localObject1);
      EventCenter.instance.addListener(((e)localObject1).tvS);
      localObject1 = this.tuX;
      if (((e)localObject1).tvp == null)
      {
        ((e)localObject1).tvp = new x();
        ((e)localObject1).tvp.a((n)localObject1);
      }
      if (((e)localObject1).tvr == null)
      {
        ((e)localObject1).tvr = new com.tencent.mm.plugin.card.ui.view.o();
        ((e)localObject1).tvr.a((n)localObject1);
      }
      if (((e)localObject1).tvs == null)
      {
        ((e)localObject1).tvs = new com.tencent.mm.plugin.card.ui.view.a();
        ((e)localObject1).tvs.a((n)localObject1);
      }
      ((e)localObject1).mListView = ((ListView)((e)localObject1).findViewById(a.d.tdL));
      ((e)localObject1).tvw = new m(((e)localObject1).tmY.getContext());
      ((e)localObject1).tvw.tAq = ((e)localObject1).nmC;
      ((e)localObject1).mListView.setAdapter(((e)localObject1).tvw);
      ((e)localObject1).tvw.notifyDataSetChanged();
      ((e)localObject1).mListView.setOnItemClickListener(new e.1((e)localObject1));
      Log.i("MicroMsg.CardDetailUIContoller", "initMenu");
      ((e)localObject1).tmY.addIconOptionMenu(0, a.f.icons_outlined_more, new e.5((e)localObject1));
      ((e)localObject1).tvu = ((LinearLayout)((e)localObject1).findViewById(a.d.header_view));
      ((e)localObject1).tvF = new com.tencent.mm.plugin.card.ui.view.d();
      ((e)localObject1).tvF.a((n)localObject1);
      ((e)localObject1).tvH.tmU = ((e)localObject1).tmU;
    }
    int i = getIntent().getIntExtra("key_from_scene", -1);
    Log.i("MicroMsg.CardDetailUI", "scene:%d", new Object[] { Integer.valueOf(i) });
    int j;
    if ((i == 2) || (i == 6) || (i == 5))
    {
      this.jaR = i;
      localObject1 = getIntent().getStringExtra("key_card_app_msg");
      localObject2 = com.tencent.mm.plugin.card.d.g.arM((String)localObject1);
      if (localObject2 != null)
      {
        this.tmG = ((com.tencent.mm.plugin.card.model.d)localObject2).fUL;
        this.tuY = ((com.tencent.mm.plugin.card.model.d)localObject2).from_username;
        this.tva = ((com.tencent.mm.plugin.card.model.d)localObject2).fUM;
        j = ((com.tencent.mm.plugin.card.model.d)localObject2).tpp;
        Log.i("MicroMsg.CardDetailUI", "scene is " + i + ", isRecommend is " + j);
        if ((j == 1) && (i == 2)) {
          this.jaR = 23;
        }
        this.tve = ((com.tencent.mm.plugin.card.model.d)localObject2).tpq;
        Log.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.tve);
      }
      this.tuZ = com.tencent.mm.plugin.card.d.g.arN((String)localObject1);
      cIH();
      if (!TextUtils.isEmpty(this.tmG)) {
        break label1859;
      }
      Log.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
      F(true, -1);
    }
    for (;;)
    {
      this.tuX.a(this.tmU, this.tvf, this.tnb);
      this.tuX.tvP = new e.d()
      {
        public final void ars(String paramAnonymousString)
        {
          AppMethodBeat.i(113202);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousString);
          AppMethodBeat.o(113202);
        }
        
        public final void b(com.tencent.mm.plugin.card.base.b paramAnonymousb)
        {
          AppMethodBeat.i(113207);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousb);
          CardDetailUI.b(CardDetailUI.this, paramAnonymousb.cGw());
          CardDetailUI.m(CardDetailUI.this).tmG = CardDetailUI.n(CardDetailUI.this);
          AppMethodBeat.o(113207);
        }
        
        public final void cIL()
        {
          AppMethodBeat.i(113208);
          CardDetailUI.o(CardDetailUI.this);
          AppMethodBeat.o(113208);
        }
        
        public final void cIM()
        {
          AppMethodBeat.i(113201);
          CardDetailUI.i(CardDetailUI.this);
          AppMethodBeat.o(113201);
        }
        
        public final void cIN()
        {
          AppMethodBeat.i(113203);
          CardDetailUI.j(CardDetailUI.this);
          AppMethodBeat.o(113203);
        }
        
        public final void cIO()
        {
          AppMethodBeat.i(113204);
          CardDetailUI.k(CardDetailUI.this);
          AppMethodBeat.o(113204);
        }
        
        public final void cIP()
        {
          AppMethodBeat.i(113205);
          CardDetailUI.h(CardDetailUI.this);
          AppMethodBeat.o(113205);
        }
        
        public final void cIQ()
        {
          AppMethodBeat.i(113206);
          CardDetailUI.l(CardDetailUI.this);
          AppMethodBeat.o(113206);
        }
        
        public final void cIR()
        {
          AppMethodBeat.i(113209);
          Log.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
          AppMethodBeat.o(113209);
        }
        
        public final void lJ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(113210);
          Log.i("MicroMsg.CardDetailUI", "doMark()");
          CardDetailUI.p(CardDetailUI.this);
          CardDetailUI.q(CardDetailUI.this);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousBoolean);
          if (CardDetailUI.r(CardDetailUI.this).cGk())
          {
            am.cHE().X(CardDetailUI.n(CardDetailUI.this), com.tencent.mm.plugin.card.d.l.arX(CardDetailUI.r(CardDetailUI.this).cGy()), 2);
            AppMethodBeat.o(113210);
            return;
          }
          am.cHE().X(CardDetailUI.n(CardDetailUI.this), com.tencent.mm.plugin.card.d.l.arX(CardDetailUI.r(CardDetailUI.this).cGy()), 1);
          AppMethodBeat.o(113210);
        }
      };
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, null, null);
      Log.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      this.ttL = bool;
      if (this.ttL)
      {
        this.lEL = com.tencent.mm.modelgeo.d.blq();
        cFN();
      }
      AppMethodBeat.o(113221);
      return;
      if ((com.tencent.mm.plugin.card.d.l.Ij(i)) || (i == 0) || (i == 1) || (i == 3) || (i == 4) || (i == 9) || (i == 12) || (i == 15) || (i == 17) || (i == 21))
      {
        this.jaR = i;
        this.tmG = getIntent().getStringExtra("key_card_id");
        this.tva = getIntent().getStringExtra("key_card_ext");
        this.tog = getIntent().getBooleanExtra("key_is_share_card", false);
        this.tuE = getIntent().getIntExtra("key_stastic_scene", 0);
        this.tuH = getIntent().getStringExtra("key_consumed_card_id");
        if ((i == 7) || (i == 16))
        {
          this.tuF = getIntent().getStringExtra("src_username");
          this.tuG = getIntent().getStringExtra("js_url");
          this.lnb = getIntent().getStringExtra("key_template_id");
          break;
        }
        if ((this.tog) && (i == 3))
        {
          this.tnT = getIntent().getStringExtra("key_card_tp_id");
          this.tmG = com.tencent.mm.plugin.card.sharecard.a.b.fI(this.tmG, this.tnT);
          break;
        }
        if (i != 8) {
          break;
        }
        this.tvg = getIntent().getBooleanExtra("key_is_sms_add_card", false);
        break;
      }
      if ((i == 50) || (i == 27))
      {
        this.jaR = getIntent().getIntExtra("key_previous_scene", 50);
        if ((this.jaR != 26) && (this.jaR != 27)) {
          this.jaR = 3;
        }
        this.lnb = getIntent().getStringExtra("key_template_id");
        if (this.jaR == 27)
        {
          localObject1 = (com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info");
          if (localObject1 != null)
          {
            this.tmU = ((com.tencent.mm.plugin.card.base.b)localObject1);
            this.tmG = this.tmU.cGw();
            cIH();
            cIK();
            if (this.tmU.cGl()) {
              am.cHF().aqN(this.tmU.cGw());
            }
            cIg();
          }
          cII();
          com.tencent.mm.plugin.card.d.l.cLg();
        }
        else
        {
          localObject1 = getIntent().getStringExtra("card_list");
          localObject2 = getIntent().getStringExtra("key_app_id");
          localObject1 = com.tencent.mm.plugin.card.d.k.H((String)localObject1, this.jaR, (String)localObject2);
          if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
          {
            Log.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
            F(true, -1);
          }
          for (;;)
          {
            cIH();
            break;
            lG(true);
            this.tmG = ((vc)((LinkedList)localObject1).get(0)).tnX;
            i = getIntent().getIntExtra("key_previous_scene", 51);
            localObject2 = new eml();
            ((eml)localObject2).UoY = this.lnb;
            Log.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.lnb });
            localObject1 = new com.tencent.mm.plugin.card.model.t((LinkedList)localObject1, (eml)localObject2, i, this.tmG);
            com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject1, 0);
          }
        }
      }
      else if (i == 51)
      {
        if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {}
        for (this.jaR = 26;; this.jaR = 3)
        {
          this.tmG = getIntent().getStringExtra("key_card_id");
          this.tmU = am.cHx().tmy;
          if (this.tmU == null) {
            this.tmU = am.cHs().aqX(this.tmG);
          }
          cIH();
          if (this.tmU != null) {
            break label1708;
          }
          Log.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
          F(true, -1);
          break;
        }
        label1708:
        cIK();
        cIg();
        cII();
        if (this.tmU.cGl()) {
          am.cHF().aqN(this.tmU.cGw());
        }
      }
      else
      {
        if (i == 26)
        {
          this.jaR = i;
          this.tmG = getIntent().getStringExtra("key_card_id");
          this.tva = getIntent().getStringExtra("key_card_ext");
          break;
        }
        this.jaR = i;
        localObject1 = getIntent().getStringExtra("key_card_app_msg");
        localObject2 = com.tencent.mm.plugin.card.d.g.arM((String)localObject1);
        if (localObject2 != null)
        {
          this.tmG = ((com.tencent.mm.plugin.card.model.d)localObject2).fUL;
          this.tuY = ((com.tencent.mm.plugin.card.model.d)localObject2).from_username;
          this.tva = ((com.tencent.mm.plugin.card.model.d)localObject2).fUM;
        }
        this.tuZ = com.tencent.mm.plugin.card.d.g.arN((String)localObject1);
        break;
        label1859:
        if ((i == 2) || (i == 6) || ((i == 4) && (!this.tog)) || (i == 5) || (i == 17) || (i == 21) || (i == 23)) {
          i = 1;
        }
        for (;;)
        {
          if ((i == 0) && (this.tmU != null)) {
            break label2084;
          }
          Log.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.tmG + " isShareCard is " + this.tog);
          lG(true);
          this.Xd.setVisibility(0);
          if (!this.tog) {
            break label2077;
          }
          cIL();
          break;
          if (i == 15)
          {
            localObject1 = am.cHx().getValue("key_accept_card_info");
            if ((localObject1 != null) && ((localObject1 instanceof CardInfo)))
            {
              this.tmU = ((CardInfo)localObject1);
              i = 0;
            }
            else
            {
              i = 1;
            }
          }
          else if (this.tog)
          {
            this.tmU = am.cHA().arn(this.tmG);
            i = 0;
          }
          else
          {
            this.tmU = am.cHs().aqX(this.tmG);
            i = 0;
          }
        }
        label2077:
        cIJ();
      }
    }
    label2084:
    Log.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.tmG);
    Object localObject1 = this.tmU.cGv();
    if (localObject1 != null)
    {
      this.tnb = new ArrayList();
      this.tnb.add(localObject1);
    }
    cIg();
    if (this.tmU.cGl()) {
      am.cHF().aqN(this.tmU.cGw());
    }
    if (this.tog)
    {
      this.tvh = true;
      i = 1;
      label2191:
      if (i == 0) {
        break label2327;
      }
      Log.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.tmG + " isShareCard is " + this.tog);
      if (!this.tog) {
        break label2320;
      }
      cIL();
    }
    for (;;)
    {
      cII();
      break;
      if ((int)(System.currentTimeMillis() / 1000L) - this.tmU.cGz() >= 86400L) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label2298;
        }
        this.tvh = true;
        i = 1;
        break;
      }
      label2298:
      if (!this.tmU.cGi()) {
        break label2191;
      }
      this.tvh = true;
      i = 1;
      break label2191;
      label2320:
      cIJ();
      continue;
      label2327:
      cIK();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113214);
    super.onCreate(paramBundle);
    this.mStartTime = System.currentTimeMillis();
    cIF();
    paramBundle = am.cHD();
    AppCompatActivity localAppCompatActivity = getContext();
    com.tencent.mm.kernel.h.aHF().kcd.a(910, paramBundle);
    am.cHz().a(paramBundle);
    com.tencent.mm.plugin.card.b.b localb = am.cHr();
    if (localb.cSF == null) {
      localb.cSF = new ArrayList();
    }
    localb.cSF.add(new WeakReference(paramBundle));
    paramBundle.mContextRef = new WeakReference(localAppCompatActivity);
    am.cHD().a(this);
    am.cHE().a(this);
    paramBundle = am.cHF();
    com.tencent.mm.kernel.h.aHF().kcd.a(577, paramBundle);
    paramBundle.tmH.clear();
    paramBundle.tmI = 0;
    am.cHF().a(this);
    initView();
    AppMethodBeat.o(113214);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113218);
    am.cHD().c(this);
    cIG();
    am.cHD().b(this);
    am.cHD().release();
    am.cHE().b(this);
    am.cHF().b(this);
    am.cHF().release();
    Object localObject1 = this.tuX;
    Object localObject2 = ((e)localObject1).tvJ;
    ((com.tencent.mm.plugin.card.b.f)localObject2).tmU = null;
    ((com.tencent.mm.plugin.card.b.f)localObject2).tmZ.clear();
    ((e)localObject1).tvJ = null;
    localObject2 = ((e)localObject1).tvH;
    com.tencent.mm.plugin.card.d.l.X(((j)localObject2).tzE);
    int i = ((j)localObject2).tzL.size() - 1;
    while (i >= 0)
    {
      com.tencent.mm.plugin.card.d.l.X((Bitmap)((j)localObject2).tzL.remove(i));
      i -= 1;
    }
    ((j)localObject2).tzL.clear();
    if (((j)localObject2).nmy.isShowing()) {
      ((j)localObject2).nmy.dismiss();
    }
    ((j)localObject2).nmy = null;
    ((j)localObject2).cJL();
    ((j)localObject2).tzD = null;
    ((j)localObject2).tmU = null;
    ((e)localObject1).tvH = null;
    if (((e)localObject1).tvt != null) {
      ((e)localObject1).tvt.release();
    }
    ((e)localObject1).tmY.mmSetOnActivityResultCallback(null);
    EventCenter.instance.removeListener(((e)localObject1).tvS);
    ((e)localObject1).tvp.destroy();
    ((e)localObject1).tvs.destroy();
    ((e)localObject1).tvr.destroy();
    ((e)localObject1).tvF.destroy();
    if (((e)localObject1).tvG != null) {
      ((e)localObject1).tvG.destroy();
    }
    if (((e)localObject1).tvy != null) {
      ((e)localObject1).tvy.destroy();
    }
    if (((e)localObject1).tvx != null) {
      ((e)localObject1).tvx.destroy();
    }
    if (((e)localObject1).tvz != null) {
      ((e)localObject1).tvz.destroy();
    }
    if (((e)localObject1).tvA != null) {
      ((e)localObject1).tvA.destroy();
    }
    if (((e)localObject1).tvB != null) {
      ((e)localObject1).tvB.destroy();
    }
    if (((e)localObject1).tvC != null) {
      ((e)localObject1).tvC.destroy();
    }
    if (((e)localObject1).tvD != null) {
      ((e)localObject1).tvD.destroy();
    }
    if (((e)localObject1).tvE != null) {
      ((e)localObject1).tvE.destroy();
    }
    if (((e)localObject1).tvv != null) {
      ((e)localObject1).tvv.destroy();
    }
    ((e)localObject1).tvo = null;
    localObject2 = am.cHI();
    if (((com.tencent.mm.plugin.card.b.g)localObject2).cSF != null)
    {
      i = 0;
      if (i < ((com.tencent.mm.plugin.card.b.g)localObject2).cSF.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.card.b.g)localObject2).cSF.get(i);
        if (localWeakReference == null) {
          break label748;
        }
        g.a locala = (g.a)localWeakReference.get();
        if ((locala == null) || (!locala.equals(localObject1))) {
          break label748;
        }
        ((com.tencent.mm.plugin.card.b.g)localObject2).cSF.remove(localWeakReference);
      }
    }
    am.cHI().release();
    this.rqC.cancel();
    cFQ();
    long l = System.currentTimeMillis() - this.mStartTime;
    if (this.tmU != null)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(13219, new Object[] { "CardDetailView", Integer.valueOf(this.jaR), this.tmU.cGx(), this.tmU.cGw(), Long.valueOf(l) });
      label611:
      if (((this.tvb) || (this.tvc)) && (this.tmU != null) && (this.tmU.cFX()))
      {
        if (!this.tmU.cGk()) {
          break label808;
        }
        am.cHE().di(this.tmG, 2);
      }
      label667:
      localObject1 = this.tvl;
      Log.i("MicroMsg.CardLbsOrBluetooth", "uninit");
      if (((com.tencent.mm.plugin.card.b.i)localObject1).tnn != null)
      {
        localObject2 = ((com.tencent.mm.plugin.card.b.i)localObject1).tnn;
        if (((i.a)localObject2).oGW != null) {
          break label822;
        }
        Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.b.i)localObject1).tnn = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).cGZ();
      ((com.tencent.mm.plugin.card.b.i)localObject1).tns = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).tnf = null;
      super.onDestroy();
      AppMethodBeat.o(113218);
      return;
      label748:
      i += 1;
      break;
      com.tencent.mm.plugin.report.service.h.IzE.a(13219, new Object[] { "CardDetailView", Integer.valueOf(this.jaR), this.tmG, this.tmG, Long.valueOf(l) });
      break label611;
      label808:
      am.cHE().di(this.tmG, 1);
      break label667;
      label822:
      MMApplicationContext.getContext().unregisterReceiver(((i.a)localObject2).oGW);
      ((i.a)localObject2).oGW = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113232);
    if (paramInt == 4)
    {
      Log.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
      F(false, -1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113232);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113216);
    cIG();
    super.onPause();
    this.tuX.fEs = true;
    am.cHD().a(this, false);
    ScreenShotUtil.setScreenShotCallback(this, null);
    com.tencent.mm.plugin.card.b.i locali = this.tvl;
    if (locali.cHc())
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "stop");
      if (locali.tnn != null) {
        locali.tnn.cHf();
      }
      locali.cGZ();
      com.tencent.mm.kernel.h.aHF().kcd.b(2574, locali);
    }
    AppMethodBeat.o(113216);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(113238);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(113238);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113238);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.ttL);
        if (!this.ttL)
        {
          this.ttL = true;
          cIp();
        }
        AppMethodBeat.o(113238);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(a.g.permission_location_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.confirm_dialog_cancel), false, new CardDetailUI.4(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113215);
    super.onResume();
    cIF();
    if (this.lEL != null) {
      this.lEL.a(this.iQJ, true);
    }
    this.tuX.fEs = false;
    ScreenShotUtil.setScreenShotCallback(this, this);
    am.cHD().a(this, true);
    Object localObject;
    int i;
    if (((this.tvb) || (this.tvc)) && (this.tmU.cFX()))
    {
      if (!this.tmU.cGk()) {
        break label224;
      }
      am.cHE().di(this.tmG, 2);
      localObject = am.cHD();
      String str = this.tmG;
      localObject = (Boolean)((com.tencent.mm.plugin.card.b.d)localObject).tmT.get(str);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
        break label208;
      }
      i = 1;
      if ((i == 0) || (TextUtils.isEmpty(am.cHD().tmW))) {
        break label213;
      }
      Log.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
      aqP(am.cHD().tmW);
      label171:
      this.tuX.tvv.d(com.tencent.mm.plugin.card.d.c.tGN);
    }
    for (;;)
    {
      if (this.tvl.isInit) {
        this.tvl.start();
      }
      AppMethodBeat.o(113215);
      return;
      label208:
      i = 0;
      break;
      label213:
      Log.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
      break label171;
      label224:
      am.cHE().di(this.tmG, 1);
      localObject = this.tuX.tvv;
      if (localObject != null) {
        ((com.tencent.mm.plugin.card.ui.view.g)localObject).d(com.tencent.mm.plugin.card.d.c.tGN);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(113225);
    Log.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      lG(false);
      this.Xd.setVisibility(8);
      Object localObject;
      if ((paramq instanceof aa))
      {
        paramString = ((aa)paramq).tpZ;
        if (TextUtils.isEmpty(paramString))
        {
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramq = this.tmU;
        localObject = new CardInfo();
        com.tencent.mm.plugin.card.d.f.a((CardInfo)localObject, paramString);
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).cGw()))
        {
          this.tmG = ((com.tencent.mm.plugin.card.base.b)localObject).cGw();
          this.tmU = ((com.tencent.mm.plugin.card.base.b)localObject);
          cIK();
          if (this.jaR == 3)
          {
            if (paramq != null)
            {
              ((CardInfo)this.tmU).field_stickyAnnouncement = ((CardInfo)paramq).field_stickyAnnouncement;
              ((CardInfo)this.tmU).field_stickyEndTime = ((CardInfo)paramq).field_stickyEndTime;
              ((CardInfo)this.tmU).field_stickyIndex = ((CardInfo)paramq).field_stickyIndex;
              ((CardInfo)this.tmU).field_label_wording = ((CardInfo)paramq).field_label_wording;
              this.tmU.a(paramq.cGv());
            }
            if (!this.tvh) {
              break label405;
            }
            com.tencent.mm.plugin.card.d.l.h(this.tmU);
          }
        }
        for (;;)
        {
          cIg();
          cII();
          if (this.tmU.cGl()) {
            am.cHF().aqN(this.tmU.cGw());
          }
          this.tvl.a(this, this.tmG, this.tmU, this.iQD, this.iQE);
          AppMethodBeat.o(113225);
          return;
          if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).cGw())) || (this.tmG.equals(((com.tencent.mm.plugin.card.base.b)localObject).cGx()))) {
            break;
          }
          Log.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.tmG, ((com.tencent.mm.plugin.card.base.b)localObject).cGx() });
          AppMethodBeat.o(113225);
          return;
          label405:
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.model.o))
      {
        if (this.tsD == 26) {
          lG(false);
        }
        localObject = ((com.tencent.mm.plugin.card.model.o)paramq).tpZ;
        paramInt1 = ((com.tencent.mm.plugin.card.model.o)paramq).tqa;
        paramq = ((com.tencent.mm.plugin.card.model.o)paramq).tqb;
        if (paramInt1 != 0) {
          c(paramInt2, paramString, paramInt1, paramq);
        }
        while (TextUtils.isEmpty((CharSequence)localObject))
        {
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
          AppMethodBeat.o(113225);
          return;
          com.tencent.mm.ui.base.h.cO(this, getResources().getString(a.g.tjI));
        }
        this.jaR = 3;
        if (this.tmU == null) {
          this.tmU = new CardInfo();
        }
        com.tencent.mm.plugin.card.d.f.a((CardInfo)this.tmU, (String)localObject);
        if (!TextUtils.isEmpty(this.tmU.cGw())) {
          this.tmG = this.tmU.cGw();
        }
        if (this.tuX.cJp() == 1)
        {
          paramString = this.tuX;
          if (paramString.tvJ != null)
          {
            paramString = paramString.tvJ;
            if (paramString.tna != null) {
              paramString.tna.toj = false;
            }
          }
        }
        if (this.tsD != 26)
        {
          cIK();
          cIg();
        }
        com.tencent.mm.plugin.card.d.l.cLg();
        paramString = this.tmU;
        if (paramString.cFY())
        {
          paramq = (Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vig, Integer.valueOf(0));
          if ((paramq == null) || (paramq.intValue() != 1))
          {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vig, Integer.valueOf(1));
            if (!com.tencent.mm.plugin.card.d.l.cLj()) {
              break label907;
            }
            com.tencent.mm.plugin.card.d.d.c(this, a.e.tjj, a.g.tjG, paramString.cGs().tpo);
          }
          label737:
          this.tvk = this.tmU.cGC();
          if ((this.tsD != 7) && (this.tsD != 16)) {
            break label929;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.tvk);
          setResult(-1, paramString);
          HS(-1);
        }
        for (;;)
        {
          if (this.tmU.cGl()) {
            am.cHF().aqN(this.tmU.cGw());
          }
          this.tvl.a(this, this.tmG, this.tmU, this.iQD, this.iQE);
          AppMethodBeat.o(113225);
          return;
          paramq = (Integer)com.tencent.mm.kernel.h.aHG().aHp().b(282884, null);
          if ((paramq != null) && (paramq.intValue() == 1)) {
            break label737;
          }
          com.tencent.mm.kernel.h.aHG().aHp().i(282884, Integer.valueOf(1));
          break;
          label907:
          com.tencent.mm.plugin.card.d.d.c(this, a.e.tji, a.g.tjF, paramString.cGs().tpo);
          break label737;
          label929:
          if ((!this.tvg) && (this.tsD == 8)) {
            F(true, -1);
          } else if ((this.tsD == 26) && (paramInt1 == 0)) {
            F(true, -1);
          }
        }
      }
      if ((paramq instanceof v))
      {
        this.tnb = ((v)paramq).tqh;
        if ((this.tmU != null) && (this.tnb != null) && (this.tnb.size() > 0))
        {
          this.tmU.a((uu)this.tnb.get(0));
          cIg();
          if (this.tmU.cFX())
          {
            paramString = am.cHA().arn(this.tmG);
            if (paramString != null)
            {
              paramString.a((uu)this.tnb.get(0));
              am.cHA().update(paramString, new String[] { this.tmG });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.cHs().aqX(this.tmG);
          if (paramString != null)
          {
            paramString.a((uu)this.tnb.get(0));
            am.cHs().update(paramString, new String[] { this.tmG });
          }
          AppMethodBeat.o(113225);
          return;
        }
        if ((this.tmU != null) && (this.tnb == null))
        {
          this.tmU.a(null);
          cIg();
          if (this.tmU.cFX())
          {
            paramString = am.cHA().arn(this.tmG);
            if (paramString != null)
            {
              paramString.a(null);
              am.cHA().update(paramString, new String[] { this.tmG });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.cHs().aqX(this.tmG);
          if (paramString != null)
          {
            paramString.a(null);
            am.cHs().update(paramString, new String[] { this.tmG });
          }
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramq instanceof af))
      {
        paramInt1 = ((af)paramq).tqa;
        localObject = ((af)paramq).tqb;
        if (paramInt1 == 10000)
        {
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = getString(a.g.tkk);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          AppMethodBeat.o(113225);
          return;
        }
        this.tva = ((af)paramq).fUM;
        lI(true);
        paramString = this.tmU.cGt();
        paramString.status = 3;
        this.tmU.a(paramString);
        com.tencent.mm.plugin.card.d.l.h(this.tmU);
        cIg();
        if (this.tsD == 3)
        {
          F(true, 2);
          AppMethodBeat.o(113225);
          return;
        }
        if (this.tsD == 15)
        {
          paramString = new vp();
          EventCenter.instance.publish(paramString);
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.model.r))
      {
        com.tencent.mm.ui.base.h.cO(this, getResources().getString(a.g.tjZ));
        am.cHr();
        com.tencent.mm.plugin.card.b.b.HG(4);
        F(true, 1);
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.model.t))
      {
        paramString = (com.tencent.mm.plugin.card.model.t)paramq;
        paramq = paramString.tqf;
        if ((paramq != null) && (paramq.size() > 0))
        {
          paramq = (com.tencent.mm.plugin.card.base.b)paramq.get(0);
          if ((paramq != null) && (!this.tmG.equals(paramString.cardId)))
          {
            Log.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.tmG, paramString.cardId });
            AppMethodBeat.o(113225);
            return;
          }
          this.tmU = paramq;
          if (this.tmU != null)
          {
            this.tmG = this.tmU.cGw();
            cIK();
            if (this.tmU.cGl()) {
              am.cHF().aqN(this.tmU.cGw());
            }
          }
          if (this.jaR == 26) {
            this.jaR = 3;
          }
          cIg();
        }
        cII();
        com.tencent.mm.plugin.card.d.l.cLg();
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramq).tpZ;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramq).tqa;
        paramq = ((com.tencent.mm.plugin.card.sharecard.model.g)paramq).tqb;
        if (paramInt1 != 0)
        {
          paramString = paramq;
          if (TextUtils.isEmpty(paramq)) {
            paramString = getString(a.g.tjy);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          Log.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", new Object[] { paramString });
          AppMethodBeat.o(113225);
          return;
        }
        com.tencent.mm.ui.base.h.cO(this, getResources().getString(a.g.tjB));
        if (TextUtils.isEmpty(paramString))
        {
          Log.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
          AppMethodBeat.o(113225);
          return;
        }
        this.jaR = 3;
        if (this.tmU == null)
        {
          this.tmU = new ShareCardInfo();
          com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)this.tmU, paramString);
          paramq = (ShareCardInfo)this.tmU;
          if (!TextUtils.isEmpty(paramString)) {
            break label2147;
          }
          Log.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
          label1884:
          if (!TextUtils.isEmpty(this.tmU.cGw())) {
            this.tmG = this.tmU.cGw();
          }
          if (TextUtils.isEmpty(this.tmU.cGy())) {
            ((ShareCardInfo)this.tmU).field_from_username = z.bcZ();
          }
          com.tencent.mm.plugin.card.d.l.a((ShareCardInfo)this.tmU);
          cIK();
          cIg();
          com.tencent.mm.plugin.card.d.l.cLi();
          am.cHz().onChange();
          this.tvk = this.tmU.cGC();
          if ((this.tsD != 7) && (this.tsD != 16)) {
            break label2239;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.tvk);
          setResult(-1, paramString);
          HS(-1);
        }
        for (;;)
        {
          for (;;)
          {
            paramString = (Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vie, Integer.valueOf(0));
            if ((paramString == null) || (paramString.intValue() != 1))
            {
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vie, Integer.valueOf(1));
              com.tencent.mm.plugin.card.d.d.c(this, a.e.tjl, a.g.tlF, "");
            }
            if (this.tmU.cGl()) {
              am.cHF().aqN(this.tmU.cGw());
            }
            AppMethodBeat.o(113225);
            return;
            if (!(this.tmU instanceof CardInfo)) {
              break;
            }
            this.tmU = new ShareCardInfo();
            break;
            try
            {
              label2147:
              paramString = new JSONObject(paramString).optJSONArray("card_list");
              if (paramString == null) {
                break label1884;
              }
              paramq.toa = paramString.optJSONObject(0).optString("encrypt_code");
              Log.i("MicroMsg.CardInfoParser", "encrypt_code:" + paramq.toa);
            }
            catch (JSONException paramString)
            {
              Log.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
              Log.e("MicroMsg.CardInfoParser", paramString.getMessage());
            }
          }
          break label1884;
          label2239:
          if ((!this.tvg) && (this.tsD == 8)) {
            F(true, -1);
          }
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.c))
      {
        paramq = ((com.tencent.mm.plugin.card.sharecard.model.c)paramq).tpZ;
        if (TextUtils.isEmpty(paramq))
        {
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramString = this.tmU;
        this.tmU = new ShareCardInfo();
        localObject = (ShareCardInfo)this.tmU;
        if (TextUtils.isEmpty(paramq))
        {
          Log.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
          if (paramString != null)
          {
            if (!TextUtils.isEmpty(paramString.cGy())) {
              ((ShareCardInfo)this.tmU).field_from_username = ((ShareCardInfo)paramString).field_from_username;
            }
            ((ShareCardInfo)this.tmU).field_app_id = ((ShareCardInfo)paramString).field_app_id;
            ((ShareCardInfo)this.tmU).field_consumer = ((ShareCardInfo)paramString).field_consumer;
            ((ShareCardInfo)this.tmU).field_share_time = ((ShareCardInfo)paramString).field_share_time;
            ((ShareCardInfo)this.tmU).field_updateTime = ((ShareCardInfo)paramString).field_updateTime;
            ((ShareCardInfo)this.tmU).field_begin_time = ((ShareCardInfo)paramString).field_begin_time;
            ((ShareCardInfo)this.tmU).field_end_time = ((ShareCardInfo)paramString).field_end_time;
            ((ShareCardInfo)this.tmU).field_block_mask = ((ShareCardInfo)paramString).field_block_mask;
            this.tmU.a(paramString.cGv());
            ((ShareCardInfo)this.tmU).field_categoryType = ((ShareCardInfo)paramString).field_categoryType;
            ((ShareCardInfo)this.tmU).field_itemIndex = ((ShareCardInfo)paramString).field_itemIndex;
            if (((ShareCardInfo)paramString).field_status != ((ShareCardInfo)this.tmU).field_status)
            {
              Log.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo)this.tmU).field_status);
              com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.tmU);
            }
          }
          if (!TextUtils.isEmpty(this.tmU.cGw())) {
            this.tmG = this.tmU.cGw();
          }
          cIg();
          cIK();
          cII();
          if (this.jaR == 3)
          {
            if (!this.tvh) {
              break label2740;
            }
            com.tencent.mm.plugin.card.d.l.h(this.tmU);
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (this.tmU.cGl()) {
              am.cHF().aqN(this.tmU.cGw());
            }
            AppMethodBeat.o(113225);
            return;
            try
            {
              com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)localObject, new JSONObject(paramq));
            }
            catch (JSONException paramq)
            {
              Log.printErrStackTrace("MicroMsg.CardInfoParser", paramq, "", new Object[0]);
            }
          }
          break;
          label2740:
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.a))
      {
        if (((com.tencent.mm.plugin.card.sharecard.model.a)paramq).tqa != 0)
        {
          com.tencent.mm.plugin.card.d.d.c(this, getString(a.g.tjX));
          AppMethodBeat.o(113225);
          return;
        }
        Log.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.tmU.cGw());
        com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.tmU);
        com.tencent.mm.ui.base.h.cO(this, getResources().getString(a.g.tjZ));
        am.cHz().cHW();
        F(true, -1);
        AppMethodBeat.o(113225);
      }
    }
    else
    {
      Log.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " cmd:" + paramq.getType());
      lG(false);
      if (!(paramq instanceof af)) {
        break label3008;
      }
      lI(false);
      paramInt1 = ((af)paramq).tqa;
      paramq = ((af)paramq).tqb;
      if (paramInt1 != 10000) {
        break label3065;
      }
      paramString = paramq;
      if (TextUtils.isEmpty(paramq)) {
        paramString = getString(a.g.tkk);
      }
    }
    label3008:
    label3065:
    for (;;)
    {
      paramq = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramq = getString(a.g.tmj);
      }
      Toast.makeText(getContext(), paramq, 0).show();
      AppMethodBeat.o(113225);
      return;
      if ((paramq instanceof com.tencent.mm.plugin.card.model.o))
      {
        HS(0);
        c(paramInt2, paramString, ((com.tencent.mm.plugin.card.model.o)paramq).tqa, ((com.tencent.mm.plugin.card.model.o)paramq).tqb);
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramq instanceof v))
      {
        AppMethodBeat.o(113225);
        return;
      }
    }
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(250988);
    paramString = this.tuX.tvv;
    if (paramString != null) {
      paramString.cAE();
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(16827, new Object[] { this.tmG, Long.valueOf(System.currentTimeMillis() / 1000L) });
    AppMethodBeat.o(250988);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113250);
    if ((this.tuX.tvv instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.tuX.tvv).tzM = am.cHF().getCode();
      this.tuX.cIg();
    }
    Log.i("MicroMsg.CardDetailUI", "code get success");
    AppMethodBeat.o(113250);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI
 * JD-Core Version:    0.7.0.1
 */