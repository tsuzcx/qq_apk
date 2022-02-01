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
import com.tencent.mm.g.a.um;
import com.tencent.mm.model.z;
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
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.ui.view.x;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.protocal.protobuf.va;
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
  implements com.tencent.mm.ak.i, c.a, d.a, j.a, ScreenShotUtil.ScreenShotCallback
{
  private View GQ;
  private final String TAG;
  private b.a gmA;
  private float gmu;
  private float gmv;
  private int gwE;
  private com.tencent.mm.ui.base.q gxX;
  private com.tencent.mm.modelgeo.d iOv;
  private String ixM;
  MMHandler mHandler;
  private long mStartTime;
  private String pQH;
  private com.tencent.mm.plugin.card.base.b pQV;
  private String pRT;
  private ArrayList<us> pRc;
  private boolean pSh;
  private int pWG;
  private boolean pWT;
  private boolean pXP;
  private int pYI;
  private String pYJ;
  private String pYK;
  private String pYL;
  e pZb;
  private String pZc;
  private String pZd;
  private String pZe;
  private boolean pZf;
  private boolean pZg;
  private boolean pZh;
  private String pZi;
  private e.a pZj;
  private boolean pZk;
  private boolean pZl;
  private boolean pZm;
  private boolean pZn;
  private String pZo;
  private com.tencent.mm.plugin.card.b.i pZp;
  private Vibrator paT;
  
  public CardDetailUI()
  {
    AppMethodBeat.i(113213);
    this.TAG = "MicroMsg.CardDetailUI";
    this.gxX = null;
    this.pQH = "";
    this.pRT = "";
    this.pZc = "";
    this.pZd = "";
    this.pZe = "";
    this.pYJ = "";
    this.pYK = "";
    this.pYL = "";
    this.pSh = false;
    this.pZf = false;
    this.pZg = false;
    this.pZh = false;
    this.ixM = "";
    this.pZi = "";
    this.pWT = false;
    this.mHandler = new MMHandler();
    this.gwE = 3;
    this.pYI = 0;
    this.pWG = -1;
    this.pZk = false;
    this.pZl = true;
    this.mStartTime = 0L;
    this.pZm = false;
    this.pXP = false;
    this.pZn = false;
    this.gmu = -85.0F;
    this.gmv = -1000.0F;
    this.pZo = "";
    this.pZp = new com.tencent.mm.plugin.card.b.i();
    this.gmA = new b.a()
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
          am.ctW().R(CardDetailUI.a(CardDetailUI.this), CardDetailUI.b(CardDetailUI.this));
        }
        com.tencent.mm.plugin.card.b.i locali = CardDetailUI.c(CardDetailUI.this);
        paramAnonymousFloat1 = CardDetailUI.b(CardDetailUI.this);
        paramAnonymousFloat2 = CardDetailUI.a(CardDetailUI.this);
        synchronized (locali.dBh)
        {
          locali.gmu = paramAnonymousFloat2;
          locali.gmv = paramAnonymousFloat1;
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
  
  private void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(113233);
    Intent localIntent;
    if (paramInt == 1)
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.pZo);
      localIntent.putExtra("key_card_id", this.pQH);
      localIntent.putExtra("key_finish_action", paramInt);
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.pWG == 7) || (this.pWG == 8) || (this.pWG == 16) || (this.pWG == 26)) && (this.gwE == 3))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.pZo);
      if (paramInt > 0)
      {
        localIntent.putExtra("key_card_id", this.pQH);
        localIntent.putExtra("key_finish_action", paramInt);
      }
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.pWG == 7) && (this.gwE == 7)) || ((this.pWG == 16) && (this.gwE == 16)) || ((this.pWG == 8) && (this.gwE == 8)) || ((this.pWG == 26) && (this.gwE == 26)))
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
  
  private void Er(int paramInt)
  {
    AppMethodBeat.i(113234);
    if ((this.pWG != 7) && (this.pWG != 16))
    {
      Log.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
      AppMethodBeat.o(113234);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new com.tencent.mm.plugin.card.model.e();
    ((com.tencent.mm.plugin.card.model.e)localObject).pRX = this.pQV.csV();
    ((com.tencent.mm.plugin.card.model.e)localObject).eaP = this.pZe;
    ((com.tencent.mm.plugin.card.model.e)localObject).code = this.pZo;
    localLinkedList.add(localObject);
    localObject = new com.tencent.mm.g.a.b();
    ((com.tencent.mm.g.a.b)localObject).dBM.resultCode = paramInt;
    if (paramInt == -1) {}
    for (((com.tencent.mm.g.a.b)localObject).dBM.dBN = com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.pWG);; ((com.tencent.mm.g.a.b)localObject).dBM.dBN = com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.pWG))
    {
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(113234);
      return;
    }
  }
  
  private void a(j.b paramb)
  {
    AppMethodBeat.i(113247);
    if (this.pZb.dLD)
    {
      Log.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
      AppMethodBeat.o(113247);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
    this.pZb.a(this.pZh, paramb, true);
    AppMethodBeat.o(113247);
  }
  
  /* Error */
  private void ajb(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 321
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 127	com/tencent/mm/plugin/card/ui/CardDetailUI:pWT	Z
    //   12: ifeq +20 -> 32
    //   15: ldc 91
    //   17: ldc_w 323
    //   20: invokestatic 326	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 321
    //   26: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: ldc 91
    //   34: ldc_w 328
    //   37: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 127	com/tencent/mm/plugin/card/ui/CardDetailUI:pWT	Z
    //   45: new 177	android/content/Intent
    //   48: dup
    //   49: aload_0
    //   50: ldc_w 330
    //   53: invokespecial 333	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   56: astore_2
    //   57: aload_2
    //   58: ldc_w 335
    //   61: aload_0
    //   62: getfield 217	com/tencent/mm/plugin/card/ui/CardDetailUI:pQV	Lcom/tencent/mm/plugin/card/base/b;
    //   65: invokeinterface 297 1 0
    //   70: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   73: pop
    //   74: aload_2
    //   75: ldc_w 337
    //   78: aload_1
    //   79: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   82: pop
    //   83: aload_2
    //   84: ldc_w 339
    //   87: aload_0
    //   88: getfield 217	com/tencent/mm/plugin/card/ui/CardDetailUI:pQV	Lcom/tencent/mm/plugin/card/base/b;
    //   91: invokeinterface 343 1 0
    //   96: getfield 348	com/tencent/mm/protocal/protobuf/uz:ixw	Ljava/lang/String;
    //   99: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   102: pop
    //   103: aload_2
    //   104: ldc_w 350
    //   107: aload_0
    //   108: getfield 134	com/tencent/mm/plugin/card/ui/CardDetailUI:gwE	I
    //   111: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   114: pop
    //   115: aload_2
    //   116: ldc_w 352
    //   119: iconst_0
    //   120: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   123: pop
    //   124: new 354	com/tencent/mm/hellhoundlib/b/a
    //   127: dup
    //   128: invokespecial 355	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   131: aload_2
    //   132: invokevirtual 359	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   135: astore_1
    //   136: aload_0
    //   137: aload_1
    //   138: invokevirtual 363	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   141: ldc_w 364
    //   144: ldc_w 366
    //   147: ldc_w 367
    //   150: ldc_w 369
    //   153: ldc_w 371
    //   156: ldc_w 373
    //   159: invokestatic 378	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_0
    //   163: aload_1
    //   164: iconst_0
    //   165: invokevirtual 382	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   168: checkcast 177	android/content/Intent
    //   171: invokevirtual 384	com/tencent/mm/plugin/card/ui/CardDetailUI:startActivity	(Landroid/content/Intent;)V
    //   174: aload_0
    //   175: ldc_w 364
    //   178: ldc_w 366
    //   181: ldc_w 367
    //   184: ldc_w 369
    //   187: ldc_w 371
    //   190: ldc_w 373
    //   193: invokestatic 387	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   196: ldc_w 321
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
        paramString1 = getString(2131756956);
      }
      this.pQV.csR().status = 4;
      cuE();
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
          paramString1 = getString(2131756960);
        }
        this.pQV.csR().status = 5;
        cuE();
      }
      else if (paramInt2 == 10002)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131757116);
        }
      }
      else
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131756954);
        }
      }
    }
  }
  
  private void csn()
  {
    AppMethodBeat.i(113235);
    if (this.iOv == null) {
      this.iOv = com.tencent.mm.modelgeo.d.bca();
    }
    this.iOv.a(this.gmA, true);
    AppMethodBeat.o(113235);
  }
  
  private void csp()
  {
    AppMethodBeat.i(113236);
    if (this.iOv != null) {
      this.iOv.c(this.gmA);
    }
    AppMethodBeat.o(113236);
  }
  
  private void cuE()
  {
    AppMethodBeat.i(113224);
    this.pZj.gwE = this.gwE;
    this.pZj.pWG = this.pWG;
    this.pZj.pQH = this.pQH;
    this.pZb.a(this.pQV, this.pZj, this.pRc);
    this.pZb.cuE();
    am.cub().pQV = this.pQV;
    AppMethodBeat.o(113224);
  }
  
  private void cuN()
  {
    AppMethodBeat.i(113237);
    this.iOv = com.tencent.mm.modelgeo.d.bca();
    csn();
    AppMethodBeat.o(113237);
  }
  
  private void cvd()
  {
    AppMethodBeat.i(113219);
    com.tencent.mm.kernel.g.aAg().hqi.a(1057, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1037, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1058, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1045, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1077, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1099, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(902, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1051, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1163, this);
    AppMethodBeat.o(113219);
  }
  
  private void cve()
  {
    AppMethodBeat.i(113220);
    com.tencent.mm.kernel.g.aAg().hqi.b(1057, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1037, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1058, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1045, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1077, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1099, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(902, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1051, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1163, this);
    AppMethodBeat.o(113220);
  }
  
  private void cvf()
  {
    AppMethodBeat.i(113222);
    this.pWG = this.gwE;
    this.pZj = new e.a();
    this.pZj.gwE = this.gwE;
    this.pZj.pWG = this.pWG;
    this.pZj.pQH = this.pQH;
    this.pZj.pZc = this.pZc;
    this.pZj.pZe = this.pZe;
    this.pZj.pZd = this.pZd;
    this.pZj.pYJ = this.pYJ;
    this.pZj.pYK = this.pYK;
    this.pZj.pSh = this.pSh;
    this.pZj.qaa = getIntent().getIntExtra("key_from_appbrand_type", 0);
    AppMethodBeat.o(113222);
  }
  
  private void cvg()
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113223);
    if ((this.pZm) || (this.pQV == null))
    {
      AppMethodBeat.o(113223);
      return;
    }
    this.pZm = true;
    if (this.pSh)
    {
      localh = com.tencent.mm.plugin.report.service.h.CyF;
      j = this.pQV.csQ().nHh;
      str1 = this.pQV.csV();
      str2 = this.pQV.csU();
      k = this.pWG;
      str3 = this.pZc;
      if (this.pQV.csO()) {}
      for (;;)
      {
        localh.a(11324, new Object[] { "ShareCardDetailUI", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
        AppMethodBeat.o(113223);
        return;
        i = 0;
      }
    }
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
    int k = this.pQV.csQ().nHh;
    String str1 = this.pQV.csV();
    String str2 = this.pQV.csU();
    int m = this.pWG;
    String str3 = this.pZc;
    if (this.pQV.csO()) {}
    for (i = j;; i = 0)
    {
      localh.a(11324, new Object[] { "CardDetailView", Integer.valueOf(k), str1, str2, Integer.valueOf(0), Integer.valueOf(m), str3, Integer.valueOf(i), "" });
      AppMethodBeat.o(113223);
      return;
    }
  }
  
  private void cvh()
  {
    AppMethodBeat.i(113229);
    Object localObject = new eck();
    ((eck)localObject).NcB = this.ixM;
    ((eck)localObject).pTp = this.pZi;
    Log.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", new Object[] { this.ixM });
    localObject = new aa(this.pQH, this.gwE, this.pZc, this.pZe, this.pYJ, this.pYK, this.pYI, this.pYL, (eck)localObject);
    com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
    AppMethodBeat.o(113229);
  }
  
  private void cvi()
  {
    AppMethodBeat.i(113230);
    Object localObject;
    if (!TextUtils.isEmpty(this.pQV.csV())) {
      localObject = this.pQV.csV();
    }
    while ((this.pQV != null) && (this.pQV.csQ().LeF == 1))
    {
      float f2 = this.gmu;
      float f3 = this.gmv;
      float f1;
      if (f2 != -85.0F)
      {
        f1 = f3;
        if (f3 != -1000.0F) {}
      }
      else
      {
        f2 = am.ctW().gmu;
        f1 = am.ctW().gmv;
      }
      localObject = new v((String)localObject, f1, f2, this.pQV.csU());
      com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
      AppMethodBeat.o(113230);
      return;
      if (!TextUtils.isEmpty(this.pQH))
      {
        localObject = this.pQH;
      }
      else
      {
        Log.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
        AppMethodBeat.o(113230);
        return;
      }
    }
    if ((this.pQV != null) && (this.pQV.csQ().LeF > 1))
    {
      if ((this.gmu != -85.0F) && (this.gmv != -1000.0F))
      {
        this.pZn = false;
        localObject = new v((String)localObject, this.gmv, this.gmu, this.pQV.csU());
        com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
        AppMethodBeat.o(113230);
        return;
      }
      if (!this.pZn)
      {
        this.pZn = true;
        if (this.pXP)
        {
          csn();
          AppMethodBeat.o(113230);
        }
      }
    }
    else if (this.pQV != null)
    {
      this.pQV.a(null);
      cuE();
      if (this.pQV.csw())
      {
        localObject = am.ctY().ajA(this.pQH);
        if (localObject != null)
        {
          ((ShareCardInfo)localObject).a(null);
          am.ctY().update((IAutoDBItem)localObject, new String[] { this.pQH });
        }
        AppMethodBeat.o(113230);
        return;
      }
      localObject = am.ctQ().ajk(this.pQH);
      if (localObject != null)
      {
        ((CardInfo)localObject).a(null);
        am.ctQ().update((IAutoDBItem)localObject, new String[] { this.pQH });
      }
    }
    AppMethodBeat.o(113230);
  }
  
  private void cvj()
  {
    AppMethodBeat.i(113231);
    com.tencent.mm.plugin.card.sharecard.model.c localc = new com.tencent.mm.plugin.card.sharecard.model.c(this.pQH);
    com.tencent.mm.kernel.g.aAg().hqi.a(localc, 0);
    AppMethodBeat.o(113231);
  }
  
  private void ku(boolean paramBoolean)
  {
    AppMethodBeat.i(113227);
    if (paramBoolean)
    {
      this.gxX = com.tencent.mm.ui.base.q.a(this, getString(2131762446), true, 0, null);
      AppMethodBeat.o(113227);
      return;
    }
    if ((this.gxX != null) && (this.gxX.isShowing()))
    {
      this.gxX.dismiss();
      this.gxX = null;
    }
    AppMethodBeat.o(113227);
  }
  
  private void kw(boolean paramBoolean)
  {
    AppMethodBeat.i(113228);
    if (paramBoolean) {
      com.tencent.mm.plugin.card.d.l.fB(this.pZb.pZP, this.pZb.pZO);
    }
    AppMethodBeat.o(113228);
  }
  
  public final void aiZ(String paramString)
  {
    AppMethodBeat.i(113249);
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    }
    AppMethodBeat.o(113249);
  }
  
  public final void ajc(final String paramString)
  {
    AppMethodBeat.i(113243);
    if (!this.pZb.cvO())
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
  
  public final void ajf(String paramString)
  {
    AppMethodBeat.i(113246);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.pQH)))
    {
      Log.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113246);
      return;
    }
    this.pZf = false;
    AppMethodBeat.o(113246);
  }
  
  public final void b(String paramString, j.b paramb)
  {
    AppMethodBeat.i(113244);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.pQH)))
    {
      Log.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113244);
      return;
    }
    ku(false);
    Log.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
    Log.i("MicroMsg.CardDetailUI", "markSucc:" + paramb.pRL + " markCardId: " + paramb.pRM);
    this.pZg = false;
    if (paramb.pRL == 1)
    {
      if ((!TextUtils.isEmpty(paramb.pRM)) && (!this.pQV.csU().equals(paramb.pRM)))
      {
        Log.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
        if (this.pQV.csw())
        {
          paramString = am.ctY().ajA(paramb.pRM);
          if (paramString != null)
          {
            this.pQV = paramString;
            this.pQH = paramb.pRM;
            cuE();
            am.cub().b(this.pQV);
            Log.i("MicroMsg.CardDetailUI", "update the mCardInfo");
            this.pZf = true;
            a(paramb);
            AppMethodBeat.o(113244);
            return;
          }
          Log.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
          com.tencent.mm.plugin.card.d.d.c(this, getString(2131757096));
          this.pZf = false;
          AppMethodBeat.o(113244);
        }
      }
      else
      {
        Log.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
        this.pZf = true;
        a(paramb);
        AppMethodBeat.o(113244);
      }
    }
    else
    {
      this.pZf = false;
      com.tencent.mm.plugin.card.d.d.c(this, getString(2131757097));
    }
    AppMethodBeat.o(113244);
  }
  
  public final void ctk()
  {
    AppMethodBeat.i(113248);
    Log.i("MicroMsg.CardDetailUI", "code change");
    if ((this.pZb.pZz instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.pZb.pZz).qdP = am.cud().getCode();
      this.pZb.cuE();
    }
    AppMethodBeat.o(113248);
  }
  
  public final void ctp()
  {
    AppMethodBeat.i(113241);
    Log.i("MicroMsg.CardDetailUI", "onVibrate");
    this.paT.vibrate(300L);
    AppMethodBeat.o(113241);
  }
  
  public final void ctq()
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
    if ((this.pQV == null) || (!this.pQV.csU().equals(paramb.csU())))
    {
      Log.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if (!this.pZb.cvO())
    {
      Log.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "onDataChange");
    this.pQV = paramb;
    this.pQH = this.pQV.csU();
    if ((this.pQV.csK()) && (am.cud().isEmpty())) {
      am.cud().aja(this.pQV.csU());
    }
    cuE();
    AppMethodBeat.o(113240);
  }
  
  public final void fq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113245);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.pQH)))
    {
      Log.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113245);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "onMarkFail()");
    this.pZf = false;
    this.pZg = false;
    ku(false);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(2131757096);
    }
    com.tencent.mm.plugin.card.d.d.c(this, paramString1);
    AppMethodBeat.o(113245);
  }
  
  public int getLayoutId()
  {
    return 2131493360;
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
    this.paT = ((Vibrator)getSystemService("vibrator"));
    this.GQ = findViewById(2131298095);
    Object localObject2;
    if (this.pZb == null)
    {
      this.pZb = new e(this, getContentView());
      localObject1 = this.pZb;
      ((e)localObject1).pZL = new j(((e)localObject1).pQZ);
      localObject2 = ((e)localObject1).pZL;
      ((j)localObject2).pWC = ((j)localObject2).qdG.getWindow().getAttributes().screenBrightness;
      if (((j)localObject2).kuK == null)
      {
        View localView = View.inflate(((j)localObject2).qdG, 2131493420, null);
        ((j)localObject2).kuM = localView.findViewById(2131306038);
        ((j)localObject2).kuL = ((ImageView)localView.findViewById(2131306037));
        ((j)localObject2).qdI = ((TextView)localView.findViewById(2131306040));
        ((j)localObject2).qdJ = ((TextView)localView.findViewById(2131306039));
        ((j)localObject2).qdK = localView.findViewById(2131306034);
        ((j)localObject2).qdL = ((ImageView)localView.findViewById(2131306033));
        ((j)localObject2).qdM = ((MMVerticalTextView)localView.findViewById(2131309708));
        ((j)localObject2).qdN = ((MMVerticalTextView)localView.findViewById(2131309709));
        localView.setOnClickListener(new j.2((j)localObject2));
        ((j)localObject2).kuK = new p(localView, -1, -1, true);
        ((j)localObject2).kuK.update();
        ((j)localObject2).kuK.setBackgroundDrawable(new ColorDrawable(16777215));
        ((j)localObject2).kuK.setOnDismissListener(new j.3((j)localObject2));
      }
      ((e)localObject1).pQZ.setMMTitle("");
      ((e)localObject1).pQZ.setActionbarColor(((e)localObject1).pQZ.getResources().getColor(2131101424));
      ((e)localObject1).pZN = new com.tencent.mm.plugin.card.b.f(((e)localObject1).pQZ);
      ((e)localObject1).pQZ.mmSetOnActivityResultCallback((MMActivity.a)localObject1);
      EventCenter.instance.addListener(((e)localObject1).pZW);
      localObject1 = this.pZb;
      if (((e)localObject1).pZt == null)
      {
        ((e)localObject1).pZt = new x();
        ((e)localObject1).pZt.a((n)localObject1);
      }
      if (((e)localObject1).pZv == null)
      {
        ((e)localObject1).pZv = new com.tencent.mm.plugin.card.ui.view.o();
        ((e)localObject1).pZv.a((n)localObject1);
      }
      if (((e)localObject1).pZw == null)
      {
        ((e)localObject1).pZw = new com.tencent.mm.plugin.card.ui.view.a();
        ((e)localObject1).pZw.a((n)localObject1);
      }
      ((e)localObject1).mListView = ((ListView)((e)localObject1).findViewById(2131298249));
      ((e)localObject1).pZA = new m(((e)localObject1).pQZ.getContext());
      ((e)localObject1).pZA.qet = ((e)localObject1).kuO;
      ((e)localObject1).mListView.setAdapter(((e)localObject1).pZA);
      ((e)localObject1).pZA.notifyDataSetChanged();
      ((e)localObject1).mListView.setOnItemClickListener(new e.1((e)localObject1));
      Log.i("MicroMsg.CardDetailUIContoller", "initMenu");
      ((e)localObject1).pQZ.addIconOptionMenu(0, 2131690843, new e.5((e)localObject1));
      ((e)localObject1).pZy = ((LinearLayout)((e)localObject1).findViewById(2131302316));
      ((e)localObject1).pZJ = new com.tencent.mm.plugin.card.ui.view.d();
      ((e)localObject1).pZJ.a((n)localObject1);
      ((e)localObject1).pZL.pQV = ((e)localObject1).pQV;
    }
    int i = getIntent().getIntExtra("key_from_scene", -1);
    Log.i("MicroMsg.CardDetailUI", "scene:%d", new Object[] { Integer.valueOf(i) });
    int j;
    if ((i == 2) || (i == 6) || (i == 5))
    {
      this.gwE = i;
      localObject1 = getIntent().getStringExtra("key_card_app_msg");
      localObject2 = com.tencent.mm.plugin.card.d.g.ajZ((String)localObject1);
      if (localObject2 != null)
      {
        this.pQH = ((com.tencent.mm.plugin.card.model.d)localObject2).eaO;
        this.pZc = ((com.tencent.mm.plugin.card.model.d)localObject2).pPy;
        this.pZe = ((com.tencent.mm.plugin.card.model.d)localObject2).eaP;
        j = ((com.tencent.mm.plugin.card.model.d)localObject2).pTo;
        Log.i("MicroMsg.CardDetailUI", "scene is " + i + ", isRecommend is " + j);
        if ((j == 1) && (i == 2)) {
          this.gwE = 23;
        }
        this.pZi = ((com.tencent.mm.plugin.card.model.d)localObject2).pTp;
        Log.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.pZi);
      }
      this.pZd = com.tencent.mm.plugin.card.d.g.aka((String)localObject1);
      cvf();
      if (!TextUtils.isEmpty(this.pQH)) {
        break label1859;
      }
      Log.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
      B(true, -1);
    }
    for (;;)
    {
      this.pZb.a(this.pQV, this.pZj, this.pRc);
      this.pZb.pZT = new e.d()
      {
        public final void ajF(String paramAnonymousString)
        {
          AppMethodBeat.i(113202);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousString);
          AppMethodBeat.o(113202);
        }
        
        public final void b(com.tencent.mm.plugin.card.base.b paramAnonymousb)
        {
          AppMethodBeat.i(113207);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousb);
          CardDetailUI.b(CardDetailUI.this, paramAnonymousb.csU());
          CardDetailUI.m(CardDetailUI.this).pQH = CardDetailUI.n(CardDetailUI.this);
          AppMethodBeat.o(113207);
        }
        
        public final void cvj()
        {
          AppMethodBeat.i(113208);
          CardDetailUI.o(CardDetailUI.this);
          AppMethodBeat.o(113208);
        }
        
        public final void cvk()
        {
          AppMethodBeat.i(113201);
          CardDetailUI.i(CardDetailUI.this);
          AppMethodBeat.o(113201);
        }
        
        public final void cvl()
        {
          AppMethodBeat.i(113203);
          CardDetailUI.j(CardDetailUI.this);
          AppMethodBeat.o(113203);
        }
        
        public final void cvm()
        {
          AppMethodBeat.i(113204);
          CardDetailUI.k(CardDetailUI.this);
          AppMethodBeat.o(113204);
        }
        
        public final void cvn()
        {
          AppMethodBeat.i(113205);
          CardDetailUI.h(CardDetailUI.this);
          AppMethodBeat.o(113205);
        }
        
        public final void cvo()
        {
          AppMethodBeat.i(113206);
          CardDetailUI.l(CardDetailUI.this);
          AppMethodBeat.o(113206);
        }
        
        public final void cvp()
        {
          AppMethodBeat.i(113209);
          Log.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
          AppMethodBeat.o(113209);
        }
        
        public final void kx(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(113210);
          Log.i("MicroMsg.CardDetailUI", "doMark()");
          CardDetailUI.p(CardDetailUI.this);
          CardDetailUI.q(CardDetailUI.this);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousBoolean);
          if (CardDetailUI.r(CardDetailUI.this).csJ())
          {
            am.cuc().V(CardDetailUI.n(CardDetailUI.this), com.tencent.mm.plugin.card.d.l.akk(CardDetailUI.r(CardDetailUI.this).csW()), 2);
            AppMethodBeat.o(113210);
            return;
          }
          am.cuc().V(CardDetailUI.n(CardDetailUI.this), com.tencent.mm.plugin.card.d.l.akk(CardDetailUI.r(CardDetailUI.this).csW()), 1);
          AppMethodBeat.o(113210);
        }
      };
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, null, null);
      Log.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      this.pXP = bool;
      if (this.pXP)
      {
        this.iOv = com.tencent.mm.modelgeo.d.bca();
        csn();
      }
      AppMethodBeat.o(113221);
      return;
      if ((com.tencent.mm.plugin.card.d.l.EI(i)) || (i == 0) || (i == 1) || (i == 3) || (i == 4) || (i == 9) || (i == 12) || (i == 15) || (i == 17) || (i == 21))
      {
        this.gwE = i;
        this.pQH = getIntent().getStringExtra("key_card_id");
        this.pZe = getIntent().getStringExtra("key_card_ext");
        this.pSh = getIntent().getBooleanExtra("key_is_share_card", false);
        this.pYI = getIntent().getIntExtra("key_stastic_scene", 0);
        this.pYL = getIntent().getStringExtra("key_consumed_card_id");
        if ((i == 7) || (i == 16))
        {
          this.pYJ = getIntent().getStringExtra("src_username");
          this.pYK = getIntent().getStringExtra("js_url");
          this.ixM = getIntent().getStringExtra("key_template_id");
          break;
        }
        if ((this.pSh) && (i == 3))
        {
          this.pRT = getIntent().getStringExtra("key_card_tp_id");
          this.pQH = com.tencent.mm.plugin.card.sharecard.a.b.fu(this.pQH, this.pRT);
          break;
        }
        if (i != 8) {
          break;
        }
        this.pZk = getIntent().getBooleanExtra("key_is_sms_add_card", false);
        break;
      }
      if ((i == 50) || (i == 27))
      {
        this.gwE = getIntent().getIntExtra("key_previous_scene", 50);
        if ((this.gwE != 26) && (this.gwE != 27)) {
          this.gwE = 3;
        }
        this.ixM = getIntent().getStringExtra("key_template_id");
        if (this.gwE == 27)
        {
          localObject1 = (com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info");
          if (localObject1 != null)
          {
            this.pQV = ((com.tencent.mm.plugin.card.base.b)localObject1);
            this.pQH = this.pQV.csU();
            cvf();
            cvi();
            if (this.pQV.csK()) {
              am.cud().aja(this.pQV.csU());
            }
            cuE();
          }
          cvg();
          com.tencent.mm.plugin.card.d.l.cxE();
        }
        else
        {
          localObject1 = getIntent().getStringExtra("card_list");
          localObject2 = getIntent().getStringExtra("key_app_id");
          localObject1 = com.tencent.mm.plugin.card.d.k.G((String)localObject1, this.gwE, (String)localObject2);
          if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
          {
            Log.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
            B(true, -1);
          }
          for (;;)
          {
            cvf();
            break;
            ku(true);
            this.pQH = ((va)((LinkedList)localObject1).get(0)).pRX;
            i = getIntent().getIntExtra("key_previous_scene", 51);
            localObject2 = new eck();
            ((eck)localObject2).NcB = this.ixM;
            Log.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.ixM });
            localObject1 = new com.tencent.mm.plugin.card.model.t((LinkedList)localObject1, (eck)localObject2, i, this.pQH);
            com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject1, 0);
          }
        }
      }
      else if (i == 51)
      {
        if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {}
        for (this.gwE = 26;; this.gwE = 3)
        {
          this.pQH = getIntent().getStringExtra("key_card_id");
          this.pQV = am.ctV().pQy;
          if (this.pQV == null) {
            this.pQV = am.ctQ().ajk(this.pQH);
          }
          cvf();
          if (this.pQV != null) {
            break label1708;
          }
          Log.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
          B(true, -1);
          break;
        }
        label1708:
        cvi();
        cuE();
        cvg();
        if (this.pQV.csK()) {
          am.cud().aja(this.pQV.csU());
        }
      }
      else
      {
        if (i == 26)
        {
          this.gwE = i;
          this.pQH = getIntent().getStringExtra("key_card_id");
          this.pZe = getIntent().getStringExtra("key_card_ext");
          break;
        }
        this.gwE = i;
        localObject1 = getIntent().getStringExtra("key_card_app_msg");
        localObject2 = com.tencent.mm.plugin.card.d.g.ajZ((String)localObject1);
        if (localObject2 != null)
        {
          this.pQH = ((com.tencent.mm.plugin.card.model.d)localObject2).eaO;
          this.pZc = ((com.tencent.mm.plugin.card.model.d)localObject2).pPy;
          this.pZe = ((com.tencent.mm.plugin.card.model.d)localObject2).eaP;
        }
        this.pZd = com.tencent.mm.plugin.card.d.g.aka((String)localObject1);
        break;
        label1859:
        if ((i == 2) || (i == 6) || ((i == 4) && (!this.pSh)) || (i == 5) || (i == 17) || (i == 21) || (i == 23)) {
          i = 1;
        }
        for (;;)
        {
          if ((i == 0) && (this.pQV != null)) {
            break label2084;
          }
          Log.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.pQH + " isShareCard is " + this.pSh);
          ku(true);
          this.GQ.setVisibility(0);
          if (!this.pSh) {
            break label2077;
          }
          cvj();
          break;
          if (i == 15)
          {
            localObject1 = am.ctV().getValue("key_accept_card_info");
            if ((localObject1 != null) && ((localObject1 instanceof CardInfo)))
            {
              this.pQV = ((CardInfo)localObject1);
              i = 0;
            }
            else
            {
              i = 1;
            }
          }
          else if (this.pSh)
          {
            this.pQV = am.ctY().ajA(this.pQH);
            i = 0;
          }
          else
          {
            this.pQV = am.ctQ().ajk(this.pQH);
            i = 0;
          }
        }
        label2077:
        cvh();
      }
    }
    label2084:
    Log.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.pQH);
    Object localObject1 = this.pQV.csT();
    if (localObject1 != null)
    {
      this.pRc = new ArrayList();
      this.pRc.add(localObject1);
    }
    cuE();
    if (this.pQV.csK()) {
      am.cud().aja(this.pQV.csU());
    }
    if (this.pSh)
    {
      this.pZl = true;
      i = 1;
      label2191:
      if (i == 0) {
        break label2327;
      }
      Log.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.pQH + " isShareCard is " + this.pSh);
      if (!this.pSh) {
        break label2320;
      }
      cvj();
    }
    for (;;)
    {
      cvg();
      break;
      if ((int)(System.currentTimeMillis() / 1000L) - this.pQV.csX() >= 86400L) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label2298;
        }
        this.pZl = true;
        i = 1;
        break;
      }
      label2298:
      if (!this.pQV.csH()) {
        break label2191;
      }
      this.pZl = true;
      i = 1;
      break label2191;
      label2320:
      cvh();
      continue;
      label2327:
      cvi();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113214);
    super.onCreate(paramBundle);
    this.mStartTime = System.currentTimeMillis();
    cvd();
    paramBundle = am.cub();
    AppCompatActivity localAppCompatActivity = getContext();
    com.tencent.mm.kernel.g.aAg().hqi.a(910, paramBundle);
    am.ctX().a(paramBundle);
    com.tencent.mm.plugin.card.b.b localb = am.ctP();
    if (localb.pQG == null) {
      localb.pQG = new ArrayList();
    }
    localb.pQG.add(new WeakReference(paramBundle));
    paramBundle.mContextRef = new WeakReference(localAppCompatActivity);
    am.cub().a(this);
    am.cuc().a(this);
    paramBundle = am.cud();
    com.tencent.mm.kernel.g.aAg().hqi.a(577, paramBundle);
    paramBundle.pQI.clear();
    paramBundle.pQJ = 0;
    am.cud().a(this);
    initView();
    AppMethodBeat.o(113214);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113218);
    am.cub().c(this);
    cve();
    am.cub().b(this);
    am.cub().release();
    am.cuc().b(this);
    am.cud().b(this);
    am.cud().release();
    Object localObject1 = this.pZb;
    Object localObject2 = ((e)localObject1).pZN;
    ((com.tencent.mm.plugin.card.b.f)localObject2).pQV = null;
    ((com.tencent.mm.plugin.card.b.f)localObject2).pRa.clear();
    ((e)localObject1).pZN = null;
    localObject2 = ((e)localObject1).pZL;
    com.tencent.mm.plugin.card.d.l.Z(((j)localObject2).qdH);
    int i = ((j)localObject2).qdO.size() - 1;
    while (i >= 0)
    {
      com.tencent.mm.plugin.card.d.l.Z((Bitmap)((j)localObject2).qdO.remove(i));
      i -= 1;
    }
    ((j)localObject2).qdO.clear();
    if (((j)localObject2).kuK.isShowing()) {
      ((j)localObject2).kuK.dismiss();
    }
    ((j)localObject2).kuK = null;
    ((j)localObject2).cwj();
    ((j)localObject2).qdG = null;
    ((j)localObject2).pQV = null;
    ((e)localObject1).pZL = null;
    if (((e)localObject1).pZx != null) {
      ((e)localObject1).pZx.release();
    }
    ((e)localObject1).pQZ.mmSetOnActivityResultCallback(null);
    EventCenter.instance.removeListener(((e)localObject1).pZW);
    ((e)localObject1).pZt.destroy();
    ((e)localObject1).pZw.destroy();
    ((e)localObject1).pZv.destroy();
    ((e)localObject1).pZJ.destroy();
    if (((e)localObject1).pZK != null) {
      ((e)localObject1).pZK.destroy();
    }
    if (((e)localObject1).pZC != null) {
      ((e)localObject1).pZC.destroy();
    }
    if (((e)localObject1).pZB != null) {
      ((e)localObject1).pZB.destroy();
    }
    if (((e)localObject1).pZD != null) {
      ((e)localObject1).pZD.destroy();
    }
    if (((e)localObject1).pZE != null) {
      ((e)localObject1).pZE.destroy();
    }
    if (((e)localObject1).pZF != null) {
      ((e)localObject1).pZF.destroy();
    }
    if (((e)localObject1).pZG != null) {
      ((e)localObject1).pZG.destroy();
    }
    if (((e)localObject1).pZH != null) {
      ((e)localObject1).pZH.destroy();
    }
    if (((e)localObject1).pZI != null) {
      ((e)localObject1).pZI.destroy();
    }
    if (((e)localObject1).pZz != null) {
      ((e)localObject1).pZz.destroy();
    }
    ((e)localObject1).pZs = null;
    localObject2 = am.cug();
    if (((com.tencent.mm.plugin.card.b.g)localObject2).pQG != null)
    {
      i = 0;
      if (i < ((com.tencent.mm.plugin.card.b.g)localObject2).pQG.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.card.b.g)localObject2).pQG.get(i);
        if (localWeakReference == null) {
          break label748;
        }
        g.a locala = (g.a)localWeakReference.get();
        if ((locala == null) || (!locala.equals(localObject1))) {
          break label748;
        }
        ((com.tencent.mm.plugin.card.b.g)localObject2).pQG.remove(localWeakReference);
      }
    }
    am.cug().release();
    this.paT.cancel();
    csp();
    long l = System.currentTimeMillis() - this.mStartTime;
    if (this.pQV != null)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(13219, new Object[] { "CardDetailView", Integer.valueOf(this.gwE), this.pQV.csV(), this.pQV.csU(), Long.valueOf(l) });
      label611:
      if (((this.pZf) || (this.pZg)) && (this.pQV != null) && (this.pQV.csw()))
      {
        if (!this.pQV.csJ()) {
          break label808;
        }
        am.cuc().cO(this.pQH, 2);
      }
      label667:
      localObject1 = this.pZp;
      Log.i("MicroMsg.CardLbsOrBluetooth", "uninit");
      if (((com.tencent.mm.plugin.card.b.i)localObject1).pRn != null)
      {
        localObject2 = ((com.tencent.mm.plugin.card.b.i)localObject1).pRn;
        if (((i.a)localObject2).lKJ != null) {
          break label822;
        }
        Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.b.i)localObject1).pRn = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).ctx();
      ((com.tencent.mm.plugin.card.b.i)localObject1).pRs = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).pRg = null;
      super.onDestroy();
      AppMethodBeat.o(113218);
      return;
      label748:
      i += 1;
      break;
      com.tencent.mm.plugin.report.service.h.CyF.a(13219, new Object[] { "CardDetailView", Integer.valueOf(this.gwE), this.pQH, this.pQH, Long.valueOf(l) });
      break label611;
      label808:
      am.cuc().cO(this.pQH, 1);
      break label667;
      label822:
      MMApplicationContext.getContext().unregisterReceiver(((i.a)localObject2).lKJ);
      ((i.a)localObject2).lKJ = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113232);
    if (paramInt == 4)
    {
      Log.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
      B(false, -1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113232);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113216);
    cve();
    super.onPause();
    this.pZb.dLD = true;
    am.cub().a(this, false);
    ScreenShotUtil.setScreenShotCallback(this, null);
    com.tencent.mm.plugin.card.b.i locali = this.pZp;
    if (locali.ctA())
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "stop");
      if (locali.pRn != null) {
        locali.pRn.ctD();
      }
      locali.ctx();
      com.tencent.mm.kernel.g.aAg().hqi.b(2574, locali);
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
        Log.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.pXP);
        if (!this.pXP)
        {
          this.pXP = true;
          cuN();
        }
        AppMethodBeat.o(113238);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131757785), false, new CardDetailUI.4(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113215);
    super.onResume();
    cvd();
    if (this.iOv != null) {
      this.iOv.a(this.gmA, true);
    }
    this.pZb.dLD = false;
    ScreenShotUtil.setScreenShotCallback(this, this);
    am.cub().a(this, true);
    Object localObject;
    int i;
    if (((this.pZf) || (this.pZg)) && (this.pQV.csw()))
    {
      if (!this.pQV.csJ()) {
        break label224;
      }
      am.cuc().cO(this.pQH, 2);
      localObject = am.cub();
      String str = this.pQH;
      localObject = (Boolean)((com.tencent.mm.plugin.card.b.d)localObject).pQU.get(str);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
        break label208;
      }
      i = 1;
      if ((i == 0) || (TextUtils.isEmpty(am.cub().pQX))) {
        break label213;
      }
      Log.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
      ajc(am.cub().pQX);
      label171:
      this.pZb.pZz.d(com.tencent.mm.plugin.card.d.c.qkR);
    }
    for (;;)
    {
      if (this.pZp.isInit) {
        this.pZp.start();
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
      am.cuc().cO(this.pQH, 1);
      localObject = this.pZb.pZz;
      if (localObject != null) {
        ((com.tencent.mm.plugin.card.ui.view.g)localObject).d(com.tencent.mm.plugin.card.d.c.qkR);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(113225);
    Log.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ku(false);
      this.GQ.setVisibility(8);
      Object localObject;
      if ((paramq instanceof aa))
      {
        paramString = ((aa)paramq).pTY;
        if (TextUtils.isEmpty(paramString))
        {
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramq = this.pQV;
        localObject = new CardInfo();
        com.tencent.mm.plugin.card.d.f.a((CardInfo)localObject, paramString);
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).csU()))
        {
          this.pQH = ((com.tencent.mm.plugin.card.base.b)localObject).csU();
          this.pQV = ((com.tencent.mm.plugin.card.base.b)localObject);
          cvi();
          if (this.gwE == 3)
          {
            if (paramq != null)
            {
              ((CardInfo)this.pQV).field_stickyAnnouncement = ((CardInfo)paramq).field_stickyAnnouncement;
              ((CardInfo)this.pQV).field_stickyEndTime = ((CardInfo)paramq).field_stickyEndTime;
              ((CardInfo)this.pQV).field_stickyIndex = ((CardInfo)paramq).field_stickyIndex;
              ((CardInfo)this.pQV).field_label_wording = ((CardInfo)paramq).field_label_wording;
              this.pQV.a(paramq.csT());
            }
            if (!this.pZl) {
              break label405;
            }
            com.tencent.mm.plugin.card.d.l.h(this.pQV);
          }
        }
        for (;;)
        {
          cuE();
          cvg();
          if (this.pQV.csK()) {
            am.cud().aja(this.pQV.csU());
          }
          this.pZp.a(this, this.pQH, this.pQV, this.gmu, this.gmv);
          AppMethodBeat.o(113225);
          return;
          if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).csU())) || (this.pQH.equals(((com.tencent.mm.plugin.card.base.b)localObject).csV()))) {
            break;
          }
          Log.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.pQH, ((com.tencent.mm.plugin.card.base.b)localObject).csV() });
          AppMethodBeat.o(113225);
          return;
          label405:
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.model.o))
      {
        if (this.pWG == 26) {
          ku(false);
        }
        localObject = ((com.tencent.mm.plugin.card.model.o)paramq).pTY;
        paramInt1 = ((com.tencent.mm.plugin.card.model.o)paramq).pTZ;
        paramq = ((com.tencent.mm.plugin.card.model.o)paramq).pUa;
        if (paramInt1 != 0) {
          c(paramInt2, paramString, paramInt1, paramq);
        }
        while (TextUtils.isEmpty((CharSequence)localObject))
        {
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
          AppMethodBeat.o(113225);
          return;
          com.tencent.mm.ui.base.h.cD(this, getResources().getString(2131756967));
        }
        this.gwE = 3;
        if (this.pQV == null) {
          this.pQV = new CardInfo();
        }
        com.tencent.mm.plugin.card.d.f.a((CardInfo)this.pQV, (String)localObject);
        if (!TextUtils.isEmpty(this.pQV.csU())) {
          this.pQH = this.pQV.csU();
        }
        if (this.pZb.cvN() == 1)
        {
          paramString = this.pZb;
          if (paramString.pZN != null)
          {
            paramString = paramString.pZN;
            if (paramString.pRb != null) {
              paramString.pRb.pSk = false;
            }
          }
        }
        if (this.pWG != 26)
        {
          cvi();
          cuE();
        }
        com.tencent.mm.plugin.card.d.l.cxE();
        paramString = this.pQV;
        if (paramString.csx())
        {
          paramq = (Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NUg, Integer.valueOf(0));
          if ((paramq == null) || (paramq.intValue() != 1))
          {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NUg, Integer.valueOf(1));
            if (!com.tencent.mm.plugin.card.d.l.cxH()) {
              break label907;
            }
            com.tencent.mm.plugin.card.d.d.c(this, 2131493440, 2131756964, paramString.csQ().pTn);
          }
          label737:
          this.pZo = this.pQV.cta();
          if ((this.pWG != 7) && (this.pWG != 16)) {
            break label929;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.pZo);
          setResult(-1, paramString);
          Er(-1);
        }
        for (;;)
        {
          if (this.pQV.csK()) {
            am.cud().aja(this.pQV.csU());
          }
          this.pZp.a(this, this.pQH, this.pQV, this.gmu, this.gmv);
          AppMethodBeat.o(113225);
          return;
          paramq = (Integer)com.tencent.mm.kernel.g.aAh().azQ().get(282884, null);
          if ((paramq != null) && (paramq.intValue() == 1)) {
            break label737;
          }
          com.tencent.mm.kernel.g.aAh().azQ().set(282884, Integer.valueOf(1));
          break;
          label907:
          com.tencent.mm.plugin.card.d.d.c(this, 2131493439, 2131756963, paramString.csQ().pTn);
          break label737;
          label929:
          if ((!this.pZk) && (this.pWG == 8)) {
            B(true, -1);
          } else if ((this.pWG == 26) && (paramInt1 == 0)) {
            B(true, -1);
          }
        }
      }
      if ((paramq instanceof v))
      {
        this.pRc = ((v)paramq).pUg;
        if ((this.pQV != null) && (this.pRc != null) && (this.pRc.size() > 0))
        {
          this.pQV.a((us)this.pRc.get(0));
          cuE();
          if (this.pQV.csw())
          {
            paramString = am.ctY().ajA(this.pQH);
            if (paramString != null)
            {
              paramString.a((us)this.pRc.get(0));
              am.ctY().update(paramString, new String[] { this.pQH });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.ctQ().ajk(this.pQH);
          if (paramString != null)
          {
            paramString.a((us)this.pRc.get(0));
            am.ctQ().update(paramString, new String[] { this.pQH });
          }
          AppMethodBeat.o(113225);
          return;
        }
        if ((this.pQV != null) && (this.pRc == null))
        {
          this.pQV.a(null);
          cuE();
          if (this.pQV.csw())
          {
            paramString = am.ctY().ajA(this.pQH);
            if (paramString != null)
            {
              paramString.a(null);
              am.ctY().update(paramString, new String[] { this.pQH });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.ctQ().ajk(this.pQH);
          if (paramString != null)
          {
            paramString.a(null);
            am.ctQ().update(paramString, new String[] { this.pQH });
          }
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramq instanceof af))
      {
        paramInt1 = ((af)paramq).pTZ;
        localObject = ((af)paramq).pUa;
        if (paramInt1 == 10000)
        {
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = getString(2131757017);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          AppMethodBeat.o(113225);
          return;
        }
        this.pZe = ((af)paramq).eaP;
        kw(true);
        paramString = this.pQV.csR();
        paramString.status = 3;
        this.pQV.a(paramString);
        com.tencent.mm.plugin.card.d.l.h(this.pQV);
        cuE();
        if (this.pWG == 3)
        {
          B(true, 2);
          AppMethodBeat.o(113225);
          return;
        }
        if (this.pWG == 15)
        {
          paramString = new um();
          EventCenter.instance.publish(paramString);
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramq instanceof r))
      {
        com.tencent.mm.ui.base.h.cD(this, getResources().getString(2131756993));
        am.ctP();
        com.tencent.mm.plugin.card.b.b.Ef(4);
        B(true, 1);
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.model.t))
      {
        paramString = (com.tencent.mm.plugin.card.model.t)paramq;
        paramq = paramString.pUe;
        if ((paramq != null) && (paramq.size() > 0))
        {
          paramq = (com.tencent.mm.plugin.card.base.b)paramq.get(0);
          if ((paramq != null) && (!this.pQH.equals(paramString.cardId)))
          {
            Log.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.pQH, paramString.cardId });
            AppMethodBeat.o(113225);
            return;
          }
          this.pQV = paramq;
          if (this.pQV != null)
          {
            this.pQH = this.pQV.csU();
            cvi();
            if (this.pQV.csK()) {
              am.cud().aja(this.pQV.csU());
            }
          }
          if (this.gwE == 26) {
            this.gwE = 3;
          }
          cuE();
        }
        cvg();
        com.tencent.mm.plugin.card.d.l.cxE();
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramq).pTY;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramq).pTZ;
        paramq = ((com.tencent.mm.plugin.card.sharecard.model.g)paramq).pUa;
        if (paramInt1 != 0)
        {
          paramString = paramq;
          if (TextUtils.isEmpty(paramq)) {
            paramString = getString(2131756955);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          Log.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", new Object[] { paramString });
          AppMethodBeat.o(113225);
          return;
        }
        com.tencent.mm.ui.base.h.cD(this, getResources().getString(2131756959));
        if (TextUtils.isEmpty(paramString))
        {
          Log.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
          AppMethodBeat.o(113225);
          return;
        }
        this.gwE = 3;
        if (this.pQV == null)
        {
          this.pQV = new ShareCardInfo();
          com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)this.pQV, paramString);
          paramq = (ShareCardInfo)this.pQV;
          if (!TextUtils.isEmpty(paramString)) {
            break label2147;
          }
          Log.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
          label1884:
          if (!TextUtils.isEmpty(this.pQV.csU())) {
            this.pQH = this.pQV.csU();
          }
          if (TextUtils.isEmpty(this.pQV.csW())) {
            ((ShareCardInfo)this.pQV).field_from_username = z.aTY();
          }
          com.tencent.mm.plugin.card.d.l.a((ShareCardInfo)this.pQV);
          cvi();
          cuE();
          com.tencent.mm.plugin.card.d.l.cxG();
          am.ctX().onChange();
          this.pZo = this.pQV.cta();
          if ((this.pWG != 7) && (this.pWG != 16)) {
            break label2239;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.pZo);
          setResult(-1, paramString);
          Er(-1);
        }
        for (;;)
        {
          for (;;)
          {
            paramString = (Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NUe, Integer.valueOf(0));
            if ((paramString == null) || (paramString.intValue() != 1))
            {
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NUe, Integer.valueOf(1));
              com.tencent.mm.plugin.card.d.d.c(this, 2131493442, 2131757157, "");
            }
            if (this.pQV.csK()) {
              am.cud().aja(this.pQV.csU());
            }
            AppMethodBeat.o(113225);
            return;
            if (!(this.pQV instanceof CardInfo)) {
              break;
            }
            this.pQV = new ShareCardInfo();
            break;
            try
            {
              label2147:
              paramString = new JSONObject(paramString).optJSONArray("card_list");
              if (paramString == null) {
                break label1884;
              }
              paramq.pSa = paramString.optJSONObject(0).optString("encrypt_code");
              Log.i("MicroMsg.CardInfoParser", "encrypt_code:" + paramq.pSa);
            }
            catch (JSONException paramString)
            {
              Log.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
              Log.e("MicroMsg.CardInfoParser", paramString.getMessage());
            }
          }
          break label1884;
          label2239:
          if ((!this.pZk) && (this.pWG == 8)) {
            B(true, -1);
          }
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.c))
      {
        paramq = ((com.tencent.mm.plugin.card.sharecard.model.c)paramq).pTY;
        if (TextUtils.isEmpty(paramq))
        {
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramString = this.pQV;
        this.pQV = new ShareCardInfo();
        localObject = (ShareCardInfo)this.pQV;
        if (TextUtils.isEmpty(paramq))
        {
          Log.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
          if (paramString != null)
          {
            if (!TextUtils.isEmpty(paramString.csW())) {
              ((ShareCardInfo)this.pQV).field_from_username = ((ShareCardInfo)paramString).field_from_username;
            }
            ((ShareCardInfo)this.pQV).field_app_id = ((ShareCardInfo)paramString).field_app_id;
            ((ShareCardInfo)this.pQV).field_consumer = ((ShareCardInfo)paramString).field_consumer;
            ((ShareCardInfo)this.pQV).field_share_time = ((ShareCardInfo)paramString).field_share_time;
            ((ShareCardInfo)this.pQV).field_updateTime = ((ShareCardInfo)paramString).field_updateTime;
            ((ShareCardInfo)this.pQV).field_begin_time = ((ShareCardInfo)paramString).field_begin_time;
            ((ShareCardInfo)this.pQV).field_end_time = ((ShareCardInfo)paramString).field_end_time;
            ((ShareCardInfo)this.pQV).field_block_mask = ((ShareCardInfo)paramString).field_block_mask;
            this.pQV.a(paramString.csT());
            ((ShareCardInfo)this.pQV).field_categoryType = ((ShareCardInfo)paramString).field_categoryType;
            ((ShareCardInfo)this.pQV).field_itemIndex = ((ShareCardInfo)paramString).field_itemIndex;
            if (((ShareCardInfo)paramString).field_status != ((ShareCardInfo)this.pQV).field_status)
            {
              Log.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo)this.pQV).field_status);
              com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.pQV);
            }
          }
          if (!TextUtils.isEmpty(this.pQV.csU())) {
            this.pQH = this.pQV.csU();
          }
          cuE();
          cvi();
          cvg();
          if (this.gwE == 3)
          {
            if (!this.pZl) {
              break label2740;
            }
            com.tencent.mm.plugin.card.d.l.h(this.pQV);
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (this.pQV.csK()) {
              am.cud().aja(this.pQV.csU());
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
        if (((com.tencent.mm.plugin.card.sharecard.model.a)paramq).pTZ != 0)
        {
          com.tencent.mm.plugin.card.d.d.c(this, getString(2131756991));
          AppMethodBeat.o(113225);
          return;
        }
        Log.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.pQV.csU());
        com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.pQV);
        com.tencent.mm.ui.base.h.cD(this, getResources().getString(2131756993));
        am.ctX().cuu();
        B(true, -1);
        AppMethodBeat.o(113225);
      }
    }
    else
    {
      Log.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " cmd:" + paramq.getType());
      ku(false);
      if (!(paramq instanceof af)) {
        break label3008;
      }
      kw(false);
      paramInt1 = ((af)paramq).pTZ;
      paramq = ((af)paramq).pUa;
      if (paramInt1 != 10000) {
        break label3065;
      }
      paramString = paramq;
      if (TextUtils.isEmpty(paramq)) {
        paramString = getString(2131757017);
      }
    }
    label3008:
    label3065:
    for (;;)
    {
      paramq = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramq = getString(2131757197);
      }
      Toast.makeText(getContext(), paramq, 0).show();
      AppMethodBeat.o(113225);
      return;
      if ((paramq instanceof com.tencent.mm.plugin.card.model.o))
      {
        Er(0);
        c(paramInt2, paramString, ((com.tencent.mm.plugin.card.model.o)paramq).pTZ, ((com.tencent.mm.plugin.card.model.o)paramq).pUa);
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
    AppMethodBeat.i(201307);
    paramString = this.pZb.pZz;
    if (paramString != null) {
      paramString.cmW();
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(16827, new Object[] { this.pQH, Long.valueOf(System.currentTimeMillis() / 1000L) });
    AppMethodBeat.o(201307);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113250);
    if ((this.pZb.pZz instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.pZb.pZz).qdP = am.cud().getCode();
      this.pZb.cuE();
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