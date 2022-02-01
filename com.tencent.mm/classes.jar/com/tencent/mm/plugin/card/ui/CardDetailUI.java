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
import com.tencent.mm.g.a.sw;
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
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bg.a;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  implements com.tencent.mm.ak.g, c.a, d.a, j.a, bg.a
{
  private View EP;
  private final String TAG;
  private float fmX;
  private float fmY;
  private b.a fnd;
  private int fwc;
  private p fxw;
  private String hiK;
  private com.tencent.mm.modelgeo.d hxT;
  ao mHandler;
  private long mStartTime;
  private String nTb;
  private com.tencent.mm.plugin.card.base.b nTp;
  private ArrayList<rr> nTw;
  private boolean nUB;
  private String nUn;
  private int nYW;
  private boolean nZj;
  private Vibrator njY;
  private int oaY;
  private String oaZ;
  private boolean oaf;
  private e.a obA;
  private boolean obB;
  private boolean obC;
  private boolean obD;
  private boolean obE;
  private String obF;
  private com.tencent.mm.plugin.card.b.i obG;
  private String oba;
  private String obb;
  e obs;
  private String obt;
  private String obu;
  private String obv;
  private boolean obw;
  private boolean obx;
  private boolean oby;
  private String obz;
  
  public CardDetailUI()
  {
    AppMethodBeat.i(113213);
    this.TAG = "MicroMsg.CardDetailUI";
    this.fxw = null;
    this.nTb = "";
    this.nUn = "";
    this.obt = "";
    this.obu = "";
    this.obv = "";
    this.oaZ = "";
    this.oba = "";
    this.obb = "";
    this.nUB = false;
    this.obw = false;
    this.obx = false;
    this.oby = false;
    this.hiK = "";
    this.obz = "";
    this.nZj = false;
    this.mHandler = new ao();
    this.fwc = 3;
    this.oaY = 0;
    this.nYW = -1;
    this.obB = false;
    this.obC = true;
    this.mStartTime = 0L;
    this.obD = false;
    this.oaf = false;
    this.obE = false;
    this.fmX = -85.0F;
    this.fmY = -1000.0F;
    this.obF = "";
    this.obG = new com.tencent.mm.plugin.card.b.i();
    this.fnd = new b.a()
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
          am.bQo().L(CardDetailUI.a(CardDetailUI.this), CardDetailUI.b(CardDetailUI.this));
        }
        com.tencent.mm.plugin.card.b.i locali = CardDetailUI.c(CardDetailUI.this);
        paramAnonymousFloat1 = CardDetailUI.b(CardDetailUI.this);
        paramAnonymousFloat2 = CardDetailUI.a(CardDetailUI.this);
        synchronized (locali.cXD)
        {
          locali.fmX = paramAnonymousFloat2;
          locali.fmY = paramAnonymousFloat1;
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
  
  /* Error */
  private void Uw(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 175
    //   4: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 127	com/tencent/mm/plugin/card/ui/CardDetailUI:nZj	Z
    //   11: ifeq +18 -> 29
    //   14: ldc 91
    //   16: ldc 177
    //   18: invokestatic 183	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 175
    //   23: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: ldc 91
    //   31: ldc 185
    //   33: invokestatic 187	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 127	com/tencent/mm/plugin/card/ui/CardDetailUI:nZj	Z
    //   41: new 189	android/content/Intent
    //   44: dup
    //   45: aload_0
    //   46: ldc 191
    //   48: invokespecial 194	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   51: astore_2
    //   52: aload_2
    //   53: ldc 196
    //   55: aload_0
    //   56: getfield 198	com/tencent/mm/plugin/card/ui/CardDetailUI:nTp	Lcom/tencent/mm/plugin/card/base/b;
    //   59: invokeinterface 204 1 0
    //   64: invokevirtual 208	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   67: pop
    //   68: aload_2
    //   69: ldc 210
    //   71: aload_1
    //   72: invokevirtual 208	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   75: pop
    //   76: aload_2
    //   77: ldc 212
    //   79: aload_0
    //   80: getfield 198	com/tencent/mm/plugin/card/ui/CardDetailUI:nTp	Lcom/tencent/mm/plugin/card/base/b;
    //   83: invokeinterface 216 1 0
    //   88: getfield 221	com/tencent/mm/protocal/protobuf/ry:hiu	Ljava/lang/String;
    //   91: invokevirtual 208	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   94: pop
    //   95: aload_2
    //   96: ldc 223
    //   98: aload_0
    //   99: getfield 134	com/tencent/mm/plugin/card/ui/CardDetailUI:fwc	I
    //   102: invokevirtual 226	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   105: pop
    //   106: aload_2
    //   107: ldc 228
    //   109: iconst_0
    //   110: invokevirtual 226	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   113: pop
    //   114: new 230	com/tencent/mm/hellhoundlib/b/a
    //   117: dup
    //   118: invokespecial 231	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   121: aload_2
    //   122: invokevirtual 235	com/tencent/mm/hellhoundlib/b/a:ba	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   125: astore_1
    //   126: aload_0
    //   127: aload_1
    //   128: invokevirtual 239	com/tencent/mm/hellhoundlib/b/a:aeD	()[Ljava/lang/Object;
    //   131: ldc 240
    //   133: ldc 242
    //   135: ldc 243
    //   137: ldc 245
    //   139: ldc 247
    //   141: ldc 249
    //   143: invokestatic 255	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_0
    //   147: aload_1
    //   148: iconst_0
    //   149: invokevirtual 259	com/tencent/mm/hellhoundlib/b/a:lR	(I)Ljava/lang/Object;
    //   152: checkcast 189	android/content/Intent
    //   155: invokevirtual 261	com/tencent/mm/plugin/card/ui/CardDetailUI:startActivity	(Landroid/content/Intent;)V
    //   158: aload_0
    //   159: ldc 240
    //   161: ldc 242
    //   163: ldc 243
    //   165: ldc 245
    //   167: ldc 247
    //   169: ldc 249
    //   171: invokestatic 264	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   174: ldc 175
    //   176: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: goto -153 -> 26
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	CardDetailUI
    //   0	187	1	paramString	String
    //   51	71	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   2	26	182	finally
    //   29	179	182	finally
  }
  
  private void a(j.b paramb)
  {
    AppMethodBeat.i(113247);
    if (this.obs.dhO)
    {
      ac.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
      AppMethodBeat.o(113247);
      return;
    }
    ac.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
    this.obs.a(this.oby, paramb, true);
    AppMethodBeat.o(113247);
  }
  
  private void bOF()
  {
    AppMethodBeat.i(113235);
    if (this.hxT == null) {
      this.hxT = com.tencent.mm.modelgeo.d.aEL();
    }
    this.hxT.a(this.fnd, true);
    AppMethodBeat.o(113235);
  }
  
  private void bOH()
  {
    AppMethodBeat.i(113236);
    if (this.hxT != null) {
      this.hxT.c(this.fnd);
    }
    AppMethodBeat.o(113236);
  }
  
  private void bQT()
  {
    AppMethodBeat.i(113224);
    this.obA.fwc = this.fwc;
    this.obA.nYW = this.nYW;
    this.obA.nTb = this.nTb;
    this.obs.a(this.nTp, this.obA, this.nTw);
    this.obs.bQT();
    am.bQt().nTp = this.nTp;
    AppMethodBeat.o(113224);
  }
  
  private void bRd()
  {
    AppMethodBeat.i(113237);
    this.hxT = com.tencent.mm.modelgeo.d.aEL();
    bOF();
    AppMethodBeat.o(113237);
  }
  
  private void bRt()
  {
    AppMethodBeat.i(113219);
    com.tencent.mm.kernel.g.agQ().ghe.a(1057, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1037, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1058, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1045, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1077, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1099, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(902, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1051, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1163, this);
    AppMethodBeat.o(113219);
  }
  
  private void bRu()
  {
    AppMethodBeat.i(113220);
    com.tencent.mm.kernel.g.agQ().ghe.b(1057, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1037, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1058, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1045, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1077, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1099, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(902, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1051, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1163, this);
    AppMethodBeat.o(113220);
  }
  
  private void bRv()
  {
    AppMethodBeat.i(113222);
    this.nYW = this.fwc;
    this.obA = new e.a();
    this.obA.fwc = this.fwc;
    this.obA.nYW = this.nYW;
    this.obA.nTb = this.nTb;
    this.obA.obt = this.obt;
    this.obA.obv = this.obv;
    this.obA.obu = this.obu;
    this.obA.oaZ = this.oaZ;
    this.obA.oba = this.oba;
    this.obA.nUB = this.nUB;
    this.obA.ocr = getIntent().getIntExtra("key_from_appbrand_type", 0);
    AppMethodBeat.o(113222);
  }
  
  private void bRw()
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113223);
    if ((this.obD) || (this.nTp == null))
    {
      AppMethodBeat.o(113223);
      return;
    }
    this.obD = true;
    if (this.nUB)
    {
      localh = com.tencent.mm.plugin.report.service.h.wUl;
      j = this.nTp.bPi().lRv;
      str1 = this.nTp.bPn();
      str2 = this.nTp.bPm();
      k = this.nYW;
      str3 = this.obt;
      if (this.nTp.bPg()) {}
      for (;;)
      {
        localh.f(11324, new Object[] { "ShareCardDetailUI", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
        AppMethodBeat.o(113223);
        return;
        i = 0;
      }
    }
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
    int k = this.nTp.bPi().lRv;
    String str1 = this.nTp.bPn();
    String str2 = this.nTp.bPm();
    int m = this.nYW;
    String str3 = this.obt;
    if (this.nTp.bPg()) {}
    for (i = j;; i = 0)
    {
      localh.f(11324, new Object[] { "CardDetailView", Integer.valueOf(k), str1, str2, Integer.valueOf(0), Integer.valueOf(m), str3, Integer.valueOf(i), "" });
      AppMethodBeat.o(113223);
      return;
    }
  }
  
  private void bRx()
  {
    AppMethodBeat.i(113229);
    Object localObject = new dcq();
    ((dcq)localObject).FMm = this.hiK;
    ((dcq)localObject).nVM = this.obz;
    ac.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", new Object[] { this.hiK });
    localObject = new aa(this.nTb, this.fwc, this.obt, this.obv, this.oaZ, this.oba, this.oaY, this.obb, (dcq)localObject);
    com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject, 0);
    AppMethodBeat.o(113229);
  }
  
  private void bRy()
  {
    AppMethodBeat.i(113230);
    Object localObject;
    if (!TextUtils.isEmpty(this.nTp.bPn())) {
      localObject = this.nTp.bPn();
    }
    while ((this.nTp != null) && (this.nTp.bPi().Eku == 1))
    {
      float f2 = this.fmX;
      float f3 = this.fmY;
      float f1;
      if (f2 != -85.0F)
      {
        f1 = f3;
        if (f3 != -1000.0F) {}
      }
      else
      {
        f2 = am.bQo().fmX;
        f1 = am.bQo().fmY;
      }
      localObject = new v((String)localObject, f1, f2, this.nTp.bPm());
      com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject, 0);
      AppMethodBeat.o(113230);
      return;
      if (!TextUtils.isEmpty(this.nTb))
      {
        localObject = this.nTb;
      }
      else
      {
        ac.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
        AppMethodBeat.o(113230);
        return;
      }
    }
    if ((this.nTp != null) && (this.nTp.bPi().Eku > 1))
    {
      if ((this.fmX != -85.0F) && (this.fmY != -1000.0F))
      {
        this.obE = false;
        localObject = new v((String)localObject, this.fmY, this.fmX, this.nTp.bPm());
        com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject, 0);
        AppMethodBeat.o(113230);
        return;
      }
      if (!this.obE)
      {
        this.obE = true;
        if (this.oaf)
        {
          bOF();
          AppMethodBeat.o(113230);
        }
      }
    }
    else if (this.nTp != null)
    {
      this.nTp.a(null);
      bQT();
      if (this.nTp.bOO())
      {
        localObject = am.bQq().UV(this.nTb);
        if (localObject != null)
        {
          ((ShareCardInfo)localObject).a(null);
          am.bQq().update((com.tencent.mm.sdk.e.c)localObject, new String[] { this.nTb });
        }
        AppMethodBeat.o(113230);
        return;
      }
      localObject = am.bQi().UF(this.nTb);
      if (localObject != null)
      {
        ((CardInfo)localObject).a(null);
        am.bQi().update((com.tencent.mm.sdk.e.c)localObject, new String[] { this.nTb });
      }
    }
    AppMethodBeat.o(113230);
  }
  
  private void bRz()
  {
    AppMethodBeat.i(113231);
    com.tencent.mm.plugin.card.sharecard.model.c localc = new com.tencent.mm.plugin.card.sharecard.model.c(this.nTb);
    com.tencent.mm.kernel.g.agQ().ghe.a(localc, 0);
    AppMethodBeat.o(113231);
  }
  
  private void c(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(113226);
    ac.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + paramInt1 + " errMsg = " + paramString1 + " ret_code:" + paramInt2 + " ret_msg:" + paramString2);
    if (paramInt2 == 10000)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = getString(2131756791);
      }
      this.nTp.bPj().status = 4;
      bQT();
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
        this.nTp.bPj().status = 5;
        bQT();
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
  
  private void ji(boolean paramBoolean)
  {
    AppMethodBeat.i(113227);
    if (paramBoolean)
    {
      this.fxw = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(113227);
      return;
    }
    if ((this.fxw != null) && (this.fxw.isShowing()))
    {
      this.fxw.dismiss();
      this.fxw = null;
    }
    AppMethodBeat.o(113227);
  }
  
  private void jk(boolean paramBoolean)
  {
    AppMethodBeat.i(113228);
    if (paramBoolean) {
      com.tencent.mm.plugin.card.d.l.eW(this.obs.ocg, this.obs.ocf);
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
      localIntent.putExtra("key_code", this.obF);
      localIntent.putExtra("key_card_id", this.nTb);
      localIntent.putExtra("key_finish_action", paramInt);
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.nYW == 7) || (this.nYW == 8) || (this.nYW == 16) || (this.nYW == 26)) && (this.fwc == 3))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.obF);
      if (paramInt > 0)
      {
        localIntent.putExtra("key_card_id", this.nTb);
        localIntent.putExtra("key_finish_action", paramInt);
      }
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.nYW == 7) && (this.fwc == 7)) || ((this.nYW == 16) && (this.fwc == 16)) || ((this.nYW == 8) && (this.fwc == 8)) || ((this.nYW == 26) && (this.fwc == 26)))
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
  
  private void zR(int paramInt)
  {
    AppMethodBeat.i(113234);
    if ((this.nYW != 7) && (this.nYW != 16))
    {
      ac.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
      AppMethodBeat.o(113234);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new com.tencent.mm.plugin.card.model.e();
    ((com.tencent.mm.plugin.card.model.e)localObject).nUr = this.nTp.bPn();
    ((com.tencent.mm.plugin.card.model.e)localObject).dvP = this.obv;
    ((com.tencent.mm.plugin.card.model.e)localObject).code = this.obF;
    localLinkedList.add(localObject);
    localObject = new com.tencent.mm.g.a.b();
    ((com.tencent.mm.g.a.b)localObject).cYi.bPH = paramInt;
    if (paramInt == -1) {}
    for (((com.tencent.mm.g.a.b)localObject).cYi.cYj = com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.nYW);; ((com.tencent.mm.g.a.b)localObject).cYi.cYj = com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.nYW))
    {
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(113234);
      return;
    }
  }
  
  public final void Q(String paramString, long paramLong)
  {
    AppMethodBeat.i(206432);
    paramString = this.obs.obQ;
    if (paramString != null) {
      paramString.bTQ();
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(16827, new Object[] { this.nTb, Long.valueOf(System.currentTimeMillis() / 1000L) });
    AppMethodBeat.o(206432);
  }
  
  public final void UA(String paramString)
  {
    AppMethodBeat.i(113246);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.nTb)))
    {
      ac.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113246);
      return;
    }
    this.obw = false;
    AppMethodBeat.o(113246);
  }
  
  public final void Uu(String paramString)
  {
    AppMethodBeat.i(113249);
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    }
    AppMethodBeat.o(113249);
  }
  
  public final void Ux(final String paramString)
  {
    AppMethodBeat.i(113243);
    if (!this.obs.bSe())
    {
      ac.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
      AppMethodBeat.o(113243);
      return;
    }
    ac.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
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
  
  public final void b(String paramString, j.b paramb)
  {
    AppMethodBeat.i(113244);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.nTb)))
    {
      ac.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113244);
      return;
    }
    ji(false);
    ac.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
    ac.i("MicroMsg.CardDetailUI", "markSucc:" + paramb.nUf + " markCardId: " + paramb.nUg);
    this.obx = false;
    if (paramb.nUf == 1)
    {
      if ((!TextUtils.isEmpty(paramb.nUg)) && (!this.nTp.bPm().equals(paramb.nUg)))
      {
        ac.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
        if (this.nTp.bOO())
        {
          paramString = am.bQq().UV(paramb.nUg);
          if (paramString != null)
          {
            this.nTp = paramString;
            this.nTb = paramb.nUg;
            bQT();
            am.bQt().b(this.nTp);
            ac.i("MicroMsg.CardDetailUI", "update the mCardInfo");
            this.obw = true;
            a(paramb);
            AppMethodBeat.o(113244);
            return;
          }
          ac.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
          com.tencent.mm.plugin.card.d.d.c(this, getString(2131756926));
          this.obw = false;
          AppMethodBeat.o(113244);
        }
      }
      else
      {
        ac.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
        this.obw = true;
        a(paramb);
        AppMethodBeat.o(113244);
      }
    }
    else
    {
      this.obw = false;
      com.tencent.mm.plugin.card.d.d.c(this, getString(2131756927));
    }
    AppMethodBeat.o(113244);
  }
  
  public final void bPC()
  {
    AppMethodBeat.i(113248);
    ac.i("MicroMsg.CardDetailUI", "code change");
    if ((this.obs.obQ instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.obs.obQ).ogg = am.bQv().getCode();
      this.obs.bQT();
    }
    AppMethodBeat.o(113248);
  }
  
  public final void bPH()
  {
    AppMethodBeat.i(113241);
    ac.i("MicroMsg.CardDetailUI", "onVibrate");
    this.njY.vibrate(300L);
    AppMethodBeat.o(113241);
  }
  
  public final void bPI()
  {
    AppMethodBeat.i(113242);
    ac.i("MicroMsg.CardDetailUI", "onFinishUI");
    AppMethodBeat.o(113242);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113240);
    if (paramb == null)
    {
      ac.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if ((this.nTp == null) || (!this.nTp.bPm().equals(paramb.bPm())))
    {
      ac.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if (!this.obs.bSe())
    {
      ac.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    ac.i("MicroMsg.CardDetailUI", "onDataChange");
    this.nTp = paramb;
    this.nTb = this.nTp.bPm();
    if ((this.nTp.bPc()) && (am.bQv().isEmpty())) {
      am.bQv().Uv(this.nTp.bPm());
    }
    bQT();
    AppMethodBeat.o(113240);
  }
  
  public final void eL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113245);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.nTb)))
    {
      ac.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113245);
      return;
    }
    ac.i("MicroMsg.CardDetailUI", "onMarkFail()");
    this.obw = false;
    this.obx = false;
    ji(false);
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
    this.njY = ((Vibrator)getSystemService("vibrator"));
    this.EP = findViewById(2131297780);
    Object localObject2;
    if (this.obs == null)
    {
      this.obs = new e(this, getContentView());
      localObject1 = this.obs;
      ((e)localObject1).occ = new j(((e)localObject1).nTt);
      localObject2 = ((e)localObject1).occ;
      ((j)localObject2).nYS = ((j)localObject2).ofX.getWindow().getAttributes().screenBrightness;
      if (((j)localObject2).jat == null)
      {
        View localView = View.inflate(((j)localObject2).ofX, 2131493329, null);
        ((j)localObject2).jav = localView.findViewById(2131303351);
        ((j)localObject2).jau = ((ImageView)localView.findViewById(2131303350));
        ((j)localObject2).ofZ = ((TextView)localView.findViewById(2131303353));
        ((j)localObject2).oga = ((TextView)localView.findViewById(2131303352));
        ((j)localObject2).ogb = localView.findViewById(2131303347);
        ((j)localObject2).ogc = ((ImageView)localView.findViewById(2131303346));
        ((j)localObject2).ogd = ((MMVerticalTextView)localView.findViewById(2131306295));
        ((j)localObject2).oge = ((MMVerticalTextView)localView.findViewById(2131306296));
        localView.setOnClickListener(new j.2((j)localObject2));
        ((j)localObject2).jat = new com.tencent.mm.ui.base.o(localView, -1, -1, true);
        ((j)localObject2).jat.update();
        ((j)localObject2).jat.setBackgroundDrawable(new ColorDrawable(16777215));
        ((j)localObject2).jat.setOnDismissListener(new j.3((j)localObject2));
      }
      ((e)localObject1).nTt.setMMTitle("");
      ((e)localObject1).nTt.setActionbarColor(((e)localObject1).nTt.getResources().getColor(2131101179));
      ((e)localObject1).oce = new com.tencent.mm.plugin.card.b.f(((e)localObject1).nTt);
      ((e)localObject1).nTt.mmSetOnActivityResultCallback((MMActivity.a)localObject1);
      com.tencent.mm.sdk.b.a.GpY.c(((e)localObject1).ocn);
      localObject1 = this.obs;
      if (((e)localObject1).obK == null)
      {
        ((e)localObject1).obK = new x();
        ((e)localObject1).obK.a((n)localObject1);
      }
      if (((e)localObject1).obM == null)
      {
        ((e)localObject1).obM = new com.tencent.mm.plugin.card.ui.view.o();
        ((e)localObject1).obM.a((n)localObject1);
      }
      if (((e)localObject1).obN == null)
      {
        ((e)localObject1).obN = new com.tencent.mm.plugin.card.ui.view.a();
        ((e)localObject1).obN.a((n)localObject1);
      }
      ((e)localObject1).mListView = ((ListView)((e)localObject1).findViewById(2131297930));
      ((e)localObject1).obR = new m(((e)localObject1).nTt.getContext());
      ((e)localObject1).obR.ogK = ((e)localObject1).jax;
      ((e)localObject1).mListView.setAdapter(((e)localObject1).obR);
      ((e)localObject1).obR.notifyDataSetChanged();
      ((e)localObject1).mListView.setOnItemClickListener(new e.1((e)localObject1));
      ac.i("MicroMsg.CardDetailUIContoller", "initMenu");
      ((e)localObject1).nTt.addIconOptionMenu(0, 2131690603, new e.5((e)localObject1));
      ((e)localObject1).obP = ((LinearLayout)((e)localObject1).findViewById(2131300735));
      ((e)localObject1).oca = new com.tencent.mm.plugin.card.ui.view.d();
      ((e)localObject1).oca.a((n)localObject1);
      ((e)localObject1).occ.nTp = ((e)localObject1).nTp;
    }
    int i = getIntent().getIntExtra("key_from_scene", -1);
    ac.i("MicroMsg.CardDetailUI", "scene:%d", new Object[] { Integer.valueOf(i) });
    int j;
    if ((i == 2) || (i == 6) || (i == 5))
    {
      this.fwc = i;
      localObject1 = getIntent().getStringExtra("key_card_app_msg");
      localObject2 = com.tencent.mm.plugin.card.d.g.Vt((String)localObject1);
      if (localObject2 != null)
      {
        this.nTb = ((com.tencent.mm.plugin.card.model.d)localObject2).dvO;
        this.obt = ((com.tencent.mm.plugin.card.model.d)localObject2).nVI;
        this.obv = ((com.tencent.mm.plugin.card.model.d)localObject2).dvP;
        j = ((com.tencent.mm.plugin.card.model.d)localObject2).nVL;
        ac.i("MicroMsg.CardDetailUI", "scene is " + i + ", isRecommend is " + j);
        if ((j == 1) && (i == 2)) {
          this.fwc = 23;
        }
        this.obz = ((com.tencent.mm.plugin.card.model.d)localObject2).nVM;
        ac.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.obz);
      }
      this.obu = com.tencent.mm.plugin.card.d.g.Vu((String)localObject1);
      bRv();
      if (!TextUtils.isEmpty(this.nTb)) {
        break label1847;
      }
      ac.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
      z(true, -1);
    }
    for (;;)
    {
      this.obs.a(this.nTp, this.obA, this.nTw);
      this.obs.ock = new e.d()
      {
        public final void Va(String paramAnonymousString)
        {
          AppMethodBeat.i(113202);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousString);
          AppMethodBeat.o(113202);
        }
        
        public final void b(com.tencent.mm.plugin.card.base.b paramAnonymousb)
        {
          AppMethodBeat.i(113207);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousb);
          CardDetailUI.b(CardDetailUI.this, paramAnonymousb.bPm());
          CardDetailUI.m(CardDetailUI.this).nTb = CardDetailUI.n(CardDetailUI.this);
          AppMethodBeat.o(113207);
        }
        
        public final void bRA()
        {
          AppMethodBeat.i(113201);
          CardDetailUI.i(CardDetailUI.this);
          AppMethodBeat.o(113201);
        }
        
        public final void bRB()
        {
          AppMethodBeat.i(113203);
          CardDetailUI.j(CardDetailUI.this);
          AppMethodBeat.o(113203);
        }
        
        public final void bRC()
        {
          AppMethodBeat.i(113204);
          CardDetailUI.k(CardDetailUI.this);
          AppMethodBeat.o(113204);
        }
        
        public final void bRD()
        {
          AppMethodBeat.i(113205);
          CardDetailUI.h(CardDetailUI.this);
          AppMethodBeat.o(113205);
        }
        
        public final void bRE()
        {
          AppMethodBeat.i(113206);
          CardDetailUI.l(CardDetailUI.this);
          AppMethodBeat.o(113206);
        }
        
        public final void bRF()
        {
          AppMethodBeat.i(113209);
          ac.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
          AppMethodBeat.o(113209);
        }
        
        public final void bRz()
        {
          AppMethodBeat.i(113208);
          CardDetailUI.o(CardDetailUI.this);
          AppMethodBeat.o(113208);
        }
        
        public final void jl(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(113210);
          ac.i("MicroMsg.CardDetailUI", "doMark()");
          CardDetailUI.p(CardDetailUI.this);
          CardDetailUI.q(CardDetailUI.this);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousBoolean);
          if (CardDetailUI.r(CardDetailUI.this).bPb())
          {
            am.bQu().S(CardDetailUI.n(CardDetailUI.this), com.tencent.mm.plugin.card.d.l.VE(CardDetailUI.r(CardDetailUI.this).bPo()), 2);
            AppMethodBeat.o(113210);
            return;
          }
          am.bQu().S(CardDetailUI.n(CardDetailUI.this), com.tencent.mm.plugin.card.d.l.VE(CardDetailUI.r(CardDetailUI.this).bPo()), 1);
          AppMethodBeat.o(113210);
        }
      };
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
      ac.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      this.oaf = bool;
      if (this.oaf)
      {
        this.hxT = com.tencent.mm.modelgeo.d.aEL();
        bOF();
      }
      AppMethodBeat.o(113221);
      return;
      if ((com.tencent.mm.plugin.card.d.l.Af(i)) || (i == 0) || (i == 1) || (i == 3) || (i == 4) || (i == 9) || (i == 12) || (i == 15) || (i == 17) || (i == 21))
      {
        this.fwc = i;
        this.nTb = getIntent().getStringExtra("key_card_id");
        this.obv = getIntent().getStringExtra("key_card_ext");
        this.nUB = getIntent().getBooleanExtra("key_is_share_card", false);
        this.oaY = getIntent().getIntExtra("key_stastic_scene", 0);
        this.obb = getIntent().getStringExtra("key_consumed_card_id");
        if ((i == 7) || (i == 16))
        {
          this.oaZ = getIntent().getStringExtra("src_username");
          this.oba = getIntent().getStringExtra("js_url");
          this.hiK = getIntent().getStringExtra("key_template_id");
          break;
        }
        if ((this.nUB) && (i == 3))
        {
          this.nUn = getIntent().getStringExtra("key_card_tp_id");
          this.nTb = com.tencent.mm.plugin.card.sharecard.a.b.eP(this.nTb, this.nUn);
          break;
        }
        if (i != 8) {
          break;
        }
        this.obB = getIntent().getBooleanExtra("key_is_sms_add_card", false);
        break;
      }
      if ((i == 50) || (i == 27))
      {
        this.fwc = getIntent().getIntExtra("key_previous_scene", 50);
        if ((this.fwc != 26) && (this.fwc != 27)) {
          this.fwc = 3;
        }
        this.hiK = getIntent().getStringExtra("key_template_id");
        if (this.fwc == 27)
        {
          localObject1 = (com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info");
          if (localObject1 != null)
          {
            this.nTp = ((com.tencent.mm.plugin.card.base.b)localObject1);
            this.nTb = this.nTp.bPm();
            bRv();
            bRy();
            if (this.nTp.bPc()) {
              am.bQv().Uv(this.nTp.bPm());
            }
            bQT();
          }
          bRw();
          com.tencent.mm.plugin.card.d.l.bTV();
        }
        else
        {
          localObject1 = getIntent().getStringExtra("card_list");
          localObject2 = getIntent().getStringExtra("key_app_id");
          localObject1 = com.tencent.mm.plugin.card.d.k.v((String)localObject1, this.fwc, (String)localObject2);
          if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
          {
            ac.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
            z(true, -1);
          }
          for (;;)
          {
            bRv();
            break;
            ji(true);
            this.nTb = ((rz)((LinkedList)localObject1).get(0)).nUr;
            i = getIntent().getIntExtra("key_previous_scene", 51);
            localObject2 = new dcq();
            ((dcq)localObject2).FMm = this.hiK;
            ac.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.hiK });
            localObject1 = new t((LinkedList)localObject1, (dcq)localObject2, i, this.nTb);
            com.tencent.mm.kernel.g.agQ().ghe.a((com.tencent.mm.ak.n)localObject1, 0);
          }
        }
      }
      else if (i == 51)
      {
        if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {}
        for (this.fwc = 26;; this.fwc = 3)
        {
          this.nTb = getIntent().getStringExtra("key_card_id");
          this.nTp = am.bQn().nSS;
          if (this.nTp == null) {
            this.nTp = am.bQi().UF(this.nTb);
          }
          bRv();
          if (this.nTp != null) {
            break label1695;
          }
          ac.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
          z(true, -1);
          break;
        }
        label1695:
        bRy();
        bQT();
        bRw();
        if (this.nTp.bPc()) {
          am.bQv().Uv(this.nTp.bPm());
        }
      }
      else
      {
        if (i == 26)
        {
          this.fwc = i;
          this.nTb = getIntent().getStringExtra("key_card_id");
          this.obv = getIntent().getStringExtra("key_card_ext");
          break;
        }
        this.fwc = i;
        localObject1 = getIntent().getStringExtra("key_card_app_msg");
        localObject2 = com.tencent.mm.plugin.card.d.g.Vt((String)localObject1);
        if (localObject2 != null)
        {
          this.nTb = ((com.tencent.mm.plugin.card.model.d)localObject2).dvO;
          this.obt = ((com.tencent.mm.plugin.card.model.d)localObject2).nVI;
          this.obv = ((com.tencent.mm.plugin.card.model.d)localObject2).dvP;
        }
        this.obu = com.tencent.mm.plugin.card.d.g.Vu((String)localObject1);
        break;
        label1847:
        if ((i == 2) || (i == 6) || ((i == 4) && (!this.nUB)) || (i == 5) || (i == 17) || (i == 21) || (i == 23)) {
          i = 1;
        }
        for (;;)
        {
          if ((i == 0) && (this.nTp != null)) {
            break label2072;
          }
          ac.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.nTb + " isShareCard is " + this.nUB);
          ji(true);
          this.EP.setVisibility(0);
          if (!this.nUB) {
            break label2065;
          }
          bRz();
          break;
          if (i == 15)
          {
            localObject1 = am.bQn().getValue("key_accept_card_info");
            if ((localObject1 != null) && ((localObject1 instanceof CardInfo)))
            {
              this.nTp = ((CardInfo)localObject1);
              i = 0;
            }
            else
            {
              i = 1;
            }
          }
          else if (this.nUB)
          {
            this.nTp = am.bQq().UV(this.nTb);
            i = 0;
          }
          else
          {
            this.nTp = am.bQi().UF(this.nTb);
            i = 0;
          }
        }
        label2065:
        bRx();
      }
    }
    label2072:
    ac.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.nTb);
    Object localObject1 = this.nTp.bPl();
    if (localObject1 != null)
    {
      this.nTw = new ArrayList();
      this.nTw.add(localObject1);
    }
    bQT();
    if (this.nTp.bPc()) {
      am.bQv().Uv(this.nTp.bPm());
    }
    if (this.nUB)
    {
      this.obC = true;
      i = 1;
      label2179:
      if (i == 0) {
        break label2315;
      }
      ac.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.nTb + " isShareCard is " + this.nUB);
      if (!this.nUB) {
        break label2308;
      }
      bRz();
    }
    for (;;)
    {
      bRw();
      break;
      if ((int)(System.currentTimeMillis() / 1000L) - this.nTp.bPp() >= 86400L) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label2286;
        }
        this.obC = true;
        i = 1;
        break;
      }
      label2286:
      if (!this.nTp.bOZ()) {
        break label2179;
      }
      this.obC = true;
      i = 1;
      break label2179;
      label2308:
      bRx();
      continue;
      label2315:
      bRy();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113214);
    super.onCreate(paramBundle);
    this.mStartTime = System.currentTimeMillis();
    bRt();
    paramBundle = am.bQt();
    AppCompatActivity localAppCompatActivity = getContext();
    com.tencent.mm.kernel.g.agQ().ghe.a(910, paramBundle);
    am.bQp().a(paramBundle);
    com.tencent.mm.plugin.card.b.b localb = am.bQh();
    if (localb.nTa == null) {
      localb.nTa = new ArrayList();
    }
    localb.nTa.add(new WeakReference(paramBundle));
    paramBundle.mContextRef = new WeakReference(localAppCompatActivity);
    am.bQt().a(this);
    am.bQu().a(this);
    paramBundle = am.bQv();
    com.tencent.mm.kernel.g.agQ().ghe.a(577, paramBundle);
    paramBundle.nTc.clear();
    paramBundle.nTd = 0;
    am.bQv().a(this);
    initView();
    AppMethodBeat.o(113214);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113218);
    am.bQt().c(this);
    bRu();
    am.bQt().b(this);
    am.bQt().release();
    am.bQu().b(this);
    am.bQv().b(this);
    am.bQv().release();
    Object localObject1 = this.obs;
    Object localObject2 = ((e)localObject1).oce;
    ((com.tencent.mm.plugin.card.b.f)localObject2).nTp = null;
    ((com.tencent.mm.plugin.card.b.f)localObject2).nTu.clear();
    ((e)localObject1).oce = null;
    localObject2 = ((e)localObject1).occ;
    com.tencent.mm.plugin.card.d.l.T(((j)localObject2).ofY);
    int i = ((j)localObject2).ogf.size() - 1;
    while (i >= 0)
    {
      com.tencent.mm.plugin.card.d.l.T((Bitmap)((j)localObject2).ogf.remove(i));
      i -= 1;
    }
    ((j)localObject2).ogf.clear();
    if (((j)localObject2).jat.isShowing()) {
      ((j)localObject2).jat.dismiss();
    }
    ((j)localObject2).jat = null;
    ((j)localObject2).bSz();
    ((j)localObject2).ofX = null;
    ((j)localObject2).nTp = null;
    ((e)localObject1).occ = null;
    if (((e)localObject1).obO != null) {
      ((e)localObject1).obO.release();
    }
    ((e)localObject1).nTt.mmSetOnActivityResultCallback(null);
    com.tencent.mm.sdk.b.a.GpY.d(((e)localObject1).ocn);
    ((e)localObject1).obK.destroy();
    ((e)localObject1).obN.destroy();
    ((e)localObject1).obM.destroy();
    ((e)localObject1).oca.destroy();
    if (((e)localObject1).ocb != null) {
      ((e)localObject1).ocb.destroy();
    }
    if (((e)localObject1).obT != null) {
      ((e)localObject1).obT.destroy();
    }
    if (((e)localObject1).obS != null) {
      ((e)localObject1).obS.destroy();
    }
    if (((e)localObject1).obU != null) {
      ((e)localObject1).obU.destroy();
    }
    if (((e)localObject1).obV != null) {
      ((e)localObject1).obV.destroy();
    }
    if (((e)localObject1).obW != null) {
      ((e)localObject1).obW.destroy();
    }
    if (((e)localObject1).obX != null) {
      ((e)localObject1).obX.destroy();
    }
    if (((e)localObject1).obY != null) {
      ((e)localObject1).obY.destroy();
    }
    if (((e)localObject1).obZ != null) {
      ((e)localObject1).obZ.destroy();
    }
    if (((e)localObject1).obQ != null) {
      ((e)localObject1).obQ.destroy();
    }
    ((e)localObject1).obJ = null;
    localObject2 = am.bQy();
    if (((com.tencent.mm.plugin.card.b.g)localObject2).nTa != null)
    {
      i = 0;
      if (i < ((com.tencent.mm.plugin.card.b.g)localObject2).nTa.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.card.b.g)localObject2).nTa.get(i);
        if (localWeakReference == null) {
          break label748;
        }
        g.a locala = (g.a)localWeakReference.get();
        if ((locala == null) || (!locala.equals(localObject1))) {
          break label748;
        }
        ((com.tencent.mm.plugin.card.b.g)localObject2).nTa.remove(localWeakReference);
      }
    }
    am.bQy().release();
    this.njY.cancel();
    bOH();
    long l = System.currentTimeMillis() - this.mStartTime;
    if (this.nTp != null)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(13219, new Object[] { "CardDetailView", Integer.valueOf(this.fwc), this.nTp.bPn(), this.nTp.bPm(), Long.valueOf(l) });
      label611:
      if (((this.obw) || (this.obx)) && (this.nTp != null) && (this.nTp.bOO()))
      {
        if (!this.nTp.bPb()) {
          break label808;
        }
        am.bQu().cB(this.nTb, 2);
      }
      label667:
      localObject1 = this.obG;
      ac.i("MicroMsg.CardLbsOrBluetooth", "uninit");
      if (((com.tencent.mm.plugin.card.b.i)localObject1).nTH != null)
      {
        localObject2 = ((com.tencent.mm.plugin.card.b.i)localObject1).nTH;
        if (((i.a)localObject2).kia != null) {
          break label822;
        }
        ac.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.b.i)localObject1).nTH = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).bPP();
      ((com.tencent.mm.plugin.card.b.i)localObject1).nTM = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).nTA = null;
      super.onDestroy();
      AppMethodBeat.o(113218);
      return;
      label748:
      i += 1;
      break;
      com.tencent.mm.plugin.report.service.h.wUl.f(13219, new Object[] { "CardDetailView", Integer.valueOf(this.fwc), this.nTb, this.nTb, Long.valueOf(l) });
      break label611;
      label808:
      am.bQu().cB(this.nTb, 1);
      break label667;
      label822:
      ai.getContext().unregisterReceiver(((i.a)localObject2).kia);
      ((i.a)localObject2).kia = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113232);
    if (paramInt == 4)
    {
      ac.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
      z(false, -1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113232);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113216);
    bRu();
    super.onPause();
    this.obs.dhO = true;
    am.bQt().a(this, false);
    bg.a(this, null);
    com.tencent.mm.plugin.card.b.i locali = this.obG;
    if (locali.bPS())
    {
      ac.i("MicroMsg.CardLbsOrBluetooth", "stop");
      if (locali.nTH != null) {
        locali.nTH.bPV();
      }
      locali.bPP();
      com.tencent.mm.kernel.g.agQ().ghe.b(2574, locali);
    }
    AppMethodBeat.o(113216);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(113238);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(113238);
      return;
    }
    ac.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113238);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ac.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.oaf);
        if (!this.oaf)
        {
          this.oaf = true;
          bRd();
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
    bRt();
    if (this.hxT != null) {
      this.hxT.a(this.fnd, true);
    }
    this.obs.dhO = false;
    bg.a(this, this);
    am.bQt().a(this, true);
    Object localObject;
    int i;
    if (((this.obw) || (this.obx)) && (this.nTp.bOO()))
    {
      if (!this.nTp.bPb()) {
        break label224;
      }
      am.bQu().cB(this.nTb, 2);
      localObject = am.bQt();
      String str = this.nTb;
      localObject = (Boolean)((com.tencent.mm.plugin.card.b.d)localObject).nTo.get(str);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
        break label208;
      }
      i = 1;
      if ((i == 0) || (TextUtils.isEmpty(am.bQt().nTr))) {
        break label213;
      }
      ac.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
      Ux(am.bQt().nTr);
      label171:
      this.obs.obQ.d(com.tencent.mm.plugin.card.d.c.oma);
    }
    for (;;)
    {
      if (this.obG.cqf) {
        this.obG.start();
      }
      AppMethodBeat.o(113215);
      return;
      label208:
      i = 0;
      break;
      label213:
      ac.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
      break label171;
      label224:
      am.bQu().cB(this.nTb, 1);
      localObject = this.obs.obQ;
      if (localObject != null) {
        ((com.tencent.mm.plugin.card.ui.view.g)localObject).d(com.tencent.mm.plugin.card.d.c.oma);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(113225);
    ac.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ji(false);
      this.EP.setVisibility(8);
      Object localObject;
      if ((paramn instanceof aa))
      {
        paramString = ((aa)paramn).nWw;
        if (TextUtils.isEmpty(paramString))
        {
          ac.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramn = this.nTp;
        localObject = new CardInfo();
        com.tencent.mm.plugin.card.d.f.a((CardInfo)localObject, paramString);
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bPm()))
        {
          this.nTb = ((com.tencent.mm.plugin.card.base.b)localObject).bPm();
          this.nTp = ((com.tencent.mm.plugin.card.base.b)localObject);
          bRy();
          if (this.fwc == 3)
          {
            if (paramn != null)
            {
              ((CardInfo)this.nTp).field_stickyAnnouncement = ((CardInfo)paramn).field_stickyAnnouncement;
              ((CardInfo)this.nTp).field_stickyEndTime = ((CardInfo)paramn).field_stickyEndTime;
              ((CardInfo)this.nTp).field_stickyIndex = ((CardInfo)paramn).field_stickyIndex;
              ((CardInfo)this.nTp).field_label_wording = ((CardInfo)paramn).field_label_wording;
              this.nTp.a(paramn.bPl());
            }
            if (!this.obC) {
              break label405;
            }
            com.tencent.mm.plugin.card.d.l.h(this.nTp);
          }
        }
        for (;;)
        {
          bQT();
          bRw();
          if (this.nTp.bPc()) {
            am.bQv().Uv(this.nTp.bPm());
          }
          this.obG.a(this, this.nTb, this.nTp, this.fmX, this.fmY);
          AppMethodBeat.o(113225);
          return;
          if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bPm())) || (this.nTb.equals(((com.tencent.mm.plugin.card.base.b)localObject).bPn()))) {
            break;
          }
          ac.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.nTb, ((com.tencent.mm.plugin.card.base.b)localObject).bPn() });
          AppMethodBeat.o(113225);
          return;
          label405:
          ac.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.o))
      {
        if (this.nYW == 26) {
          ji(false);
        }
        localObject = ((com.tencent.mm.plugin.card.model.o)paramn).nWw;
        paramInt1 = ((com.tencent.mm.plugin.card.model.o)paramn).nWx;
        paramn = ((com.tencent.mm.plugin.card.model.o)paramn).nWy;
        if (paramInt1 != 0) {
          c(paramInt2, paramString, paramInt1, paramn);
        }
        while (TextUtils.isEmpty((CharSequence)localObject))
        {
          ac.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
          AppMethodBeat.o(113225);
          return;
          com.tencent.mm.ui.base.h.cg(this, getResources().getString(2131756802));
        }
        this.fwc = 3;
        if (this.nTp == null) {
          this.nTp = new CardInfo();
        }
        com.tencent.mm.plugin.card.d.f.a((CardInfo)this.nTp, (String)localObject);
        if (!TextUtils.isEmpty(this.nTp.bPm())) {
          this.nTb = this.nTp.bPm();
        }
        if (this.obs.bSd() == 1)
        {
          paramString = this.obs;
          if (paramString.oce != null)
          {
            paramString = paramString.oce;
            if (paramString.nTv != null) {
              paramString.nTv.nUE = false;
            }
          }
        }
        if (this.nYW != 26)
        {
          bRy();
          bQT();
        }
        com.tencent.mm.plugin.card.d.l.bTV();
        paramString = this.nTp;
        if (paramString.bOP())
        {
          paramn = (Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFq, Integer.valueOf(0));
          if ((paramn == null) || (paramn.intValue() != 1))
          {
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFq, Integer.valueOf(1));
            if (!com.tencent.mm.plugin.card.d.l.bTY()) {
              break label908;
            }
            com.tencent.mm.plugin.card.d.d.c(this, 2131493349, 2131756799, paramString.bPi().nVJ);
          }
          label737:
          this.obF = this.nTp.bPs();
          if ((this.nYW != 7) && (this.nYW != 16)) {
            break label930;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.obF);
          setResult(-1, paramString);
          zR(-1);
        }
        for (;;)
        {
          if (this.nTp.bPc()) {
            am.bQv().Uv(this.nTp.bPm());
          }
          this.obG.a(this, this.nTb, this.nTp, this.fmX, this.fmY);
          AppMethodBeat.o(113225);
          return;
          paramn = (Integer)com.tencent.mm.kernel.g.agR().agA().get(282884, null);
          if ((paramn != null) && (paramn.intValue() == 1)) {
            break label737;
          }
          com.tencent.mm.kernel.g.agR().agA().set(282884, Integer.valueOf(1));
          break;
          label908:
          com.tencent.mm.plugin.card.d.d.c(this, 2131493348, 2131756798, paramString.bPi().nVJ);
          break label737;
          label930:
          if ((!this.obB) && (this.nYW == 8)) {
            z(true, -1);
          } else if ((this.nYW == 26) && (paramInt1 == 0)) {
            z(true, -1);
          }
        }
      }
      if ((paramn instanceof v))
      {
        this.nTw = ((v)paramn).nWE;
        if ((this.nTp != null) && (this.nTw != null) && (this.nTw.size() > 0))
        {
          this.nTp.a((rr)this.nTw.get(0));
          bQT();
          if (this.nTp.bOO())
          {
            paramString = am.bQq().UV(this.nTb);
            if (paramString != null)
            {
              paramString.a((rr)this.nTw.get(0));
              am.bQq().update(paramString, new String[] { this.nTb });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.bQi().UF(this.nTb);
          if (paramString != null)
          {
            paramString.a((rr)this.nTw.get(0));
            am.bQi().update(paramString, new String[] { this.nTb });
          }
          AppMethodBeat.o(113225);
          return;
        }
        if ((this.nTp != null) && (this.nTw == null))
        {
          this.nTp.a(null);
          bQT();
          if (this.nTp.bOO())
          {
            paramString = am.bQq().UV(this.nTb);
            if (paramString != null)
            {
              paramString.a(null);
              am.bQq().update(paramString, new String[] { this.nTb });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.bQi().UF(this.nTb);
          if (paramString != null)
          {
            paramString.a(null);
            am.bQi().update(paramString, new String[] { this.nTb });
          }
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof af))
      {
        paramInt1 = ((af)paramn).nWx;
        localObject = ((af)paramn).nWy;
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
        this.obv = ((af)paramn).dvP;
        jk(true);
        paramString = this.nTp.bPj();
        paramString.status = 3;
        this.nTp.a(paramString);
        com.tencent.mm.plugin.card.d.l.h(this.nTp);
        bQT();
        if (this.nYW == 3)
        {
          z(true, 2);
          AppMethodBeat.o(113225);
          return;
        }
        if (this.nYW == 15)
        {
          paramString = new sw();
          com.tencent.mm.sdk.b.a.GpY.l(paramString);
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof r))
      {
        com.tencent.mm.ui.base.h.cg(this, getResources().getString(2131756828));
        am.bQh();
        com.tencent.mm.plugin.card.b.b.zF(4);
        z(true, 1);
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof t))
      {
        paramString = (t)paramn;
        paramn = paramString.nWC;
        if ((paramn != null) && (paramn.size() > 0))
        {
          paramn = (com.tencent.mm.plugin.card.base.b)paramn.get(0);
          if ((paramn != null) && (!this.nTb.equals(paramString.cardId)))
          {
            ac.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.nTb, paramString.cardId });
            AppMethodBeat.o(113225);
            return;
          }
          this.nTp = paramn;
          if (this.nTp != null)
          {
            this.nTb = this.nTp.bPm();
            bRy();
            if (this.nTp.bPc()) {
              am.bQv().Uv(this.nTp.bPm());
            }
          }
          if (this.fwc == 26) {
            this.fwc = 3;
          }
          bQT();
        }
        bRw();
        com.tencent.mm.plugin.card.d.l.bTV();
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).nWw;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).nWx;
        paramn = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).nWy;
        if (paramInt1 != 0)
        {
          paramString = paramn;
          if (TextUtils.isEmpty(paramn)) {
            paramString = getString(2131756790);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          ac.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", new Object[] { paramString });
          AppMethodBeat.o(113225);
          return;
        }
        com.tencent.mm.ui.base.h.cg(this, getResources().getString(2131756794));
        if (TextUtils.isEmpty(paramString))
        {
          ac.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
          AppMethodBeat.o(113225);
          return;
        }
        this.fwc = 3;
        if (this.nTp == null)
        {
          this.nTp = new ShareCardInfo();
          com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)this.nTp, paramString);
          paramn = (ShareCardInfo)this.nTp;
          if (!TextUtils.isEmpty(paramString)) {
            break label2149;
          }
          ac.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
          label1885:
          if (!TextUtils.isEmpty(this.nTp.bPm())) {
            this.nTb = this.nTp.bPm();
          }
          if (TextUtils.isEmpty(this.nTp.bPo())) {
            ((ShareCardInfo)this.nTp).field_from_username = u.axw();
          }
          com.tencent.mm.plugin.card.d.l.a((ShareCardInfo)this.nTp);
          bRy();
          bQT();
          com.tencent.mm.plugin.card.d.l.bTX();
          am.bQp().onChange();
          this.obF = this.nTp.bPs();
          if ((this.nYW != 7) && (this.nYW != 16)) {
            break label2241;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.obF);
          setResult(-1, paramString);
          zR(-1);
        }
        for (;;)
        {
          for (;;)
          {
            paramString = (Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFo, Integer.valueOf(0));
            if ((paramString == null) || (paramString.intValue() != 1))
            {
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFo, Integer.valueOf(1));
              com.tencent.mm.plugin.card.d.d.c(this, 2131493351, 2131756987, "");
            }
            if (this.nTp.bPc()) {
              am.bQv().Uv(this.nTp.bPm());
            }
            AppMethodBeat.o(113225);
            return;
            if (!(this.nTp instanceof CardInfo)) {
              break;
            }
            this.nTp = new ShareCardInfo();
            break;
            try
            {
              label2149:
              paramString = new JSONObject(paramString).optJSONArray("card_list");
              if (paramString == null) {
                break label1885;
              }
              paramn.nUu = paramString.optJSONObject(0).optString("encrypt_code");
              ac.i("MicroMsg.CardInfoParser", "encrypt_code:" + paramn.nUu);
            }
            catch (JSONException paramString)
            {
              ac.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
              ac.e("MicroMsg.CardInfoParser", paramString.getMessage());
            }
          }
          break label1885;
          label2241:
          if ((!this.obB) && (this.nYW == 8)) {
            z(true, -1);
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.c))
      {
        paramn = ((com.tencent.mm.plugin.card.sharecard.model.c)paramn).nWw;
        if (TextUtils.isEmpty(paramn))
        {
          ac.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramString = this.nTp;
        this.nTp = new ShareCardInfo();
        localObject = (ShareCardInfo)this.nTp;
        if (TextUtils.isEmpty(paramn))
        {
          ac.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
          if (paramString != null)
          {
            if (!TextUtils.isEmpty(paramString.bPo())) {
              ((ShareCardInfo)this.nTp).field_from_username = ((ShareCardInfo)paramString).field_from_username;
            }
            ((ShareCardInfo)this.nTp).field_app_id = ((ShareCardInfo)paramString).field_app_id;
            ((ShareCardInfo)this.nTp).field_consumer = ((ShareCardInfo)paramString).field_consumer;
            ((ShareCardInfo)this.nTp).field_share_time = ((ShareCardInfo)paramString).field_share_time;
            ((ShareCardInfo)this.nTp).field_updateTime = ((ShareCardInfo)paramString).field_updateTime;
            ((ShareCardInfo)this.nTp).field_begin_time = ((ShareCardInfo)paramString).field_begin_time;
            ((ShareCardInfo)this.nTp).field_end_time = ((ShareCardInfo)paramString).field_end_time;
            ((ShareCardInfo)this.nTp).field_block_mask = ((ShareCardInfo)paramString).field_block_mask;
            this.nTp.a(paramString.bPl());
            ((ShareCardInfo)this.nTp).field_categoryType = ((ShareCardInfo)paramString).field_categoryType;
            ((ShareCardInfo)this.nTp).field_itemIndex = ((ShareCardInfo)paramString).field_itemIndex;
            if (((ShareCardInfo)paramString).field_status != ((ShareCardInfo)this.nTp).field_status)
            {
              ac.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo)this.nTp).field_status);
              com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.nTp);
            }
          }
          if (!TextUtils.isEmpty(this.nTp.bPm())) {
            this.nTb = this.nTp.bPm();
          }
          bQT();
          bRy();
          bRw();
          if (this.fwc == 3)
          {
            if (!this.obC) {
              break label2742;
            }
            com.tencent.mm.plugin.card.d.l.h(this.nTp);
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (this.nTp.bPc()) {
              am.bQv().Uv(this.nTp.bPm());
            }
            AppMethodBeat.o(113225);
            return;
            try
            {
              com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)localObject, new JSONObject(paramn));
            }
            catch (JSONException paramn)
            {
              ac.printErrStackTrace("MicroMsg.CardInfoParser", paramn, "", new Object[0]);
            }
          }
          break;
          label2742:
          ac.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.a))
      {
        if (((com.tencent.mm.plugin.card.sharecard.model.a)paramn).nWx != 0)
        {
          com.tencent.mm.plugin.card.d.d.c(this, getString(2131756826));
          AppMethodBeat.o(113225);
          return;
        }
        ac.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.nTp.bPm());
        com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.nTp);
        com.tencent.mm.ui.base.h.cg(this, getResources().getString(2131756828));
        am.bQp().bQJ();
        z(true, -1);
        AppMethodBeat.o(113225);
      }
    }
    else
    {
      ac.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " cmd:" + paramn.getType());
      ji(false);
      if (!(paramn instanceof af)) {
        break label3010;
      }
      jk(false);
      paramInt1 = ((af)paramn).nWx;
      paramn = ((af)paramn).nWy;
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
        zR(0);
        c(paramInt2, paramString, ((com.tencent.mm.plugin.card.model.o)paramn).nWx, ((com.tencent.mm.plugin.card.model.o)paramn).nWy);
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
    if ((this.obs.obQ instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.obs.obQ).ogg = am.bQv().getCode();
      this.obs.bQT();
    }
    ac.i("MicroMsg.CardDetailUI", "code get success");
    AppMethodBeat.o(113250);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI
 * JD-Core Version:    0.7.0.1
 */