package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.plugin.ipcall.model.f.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.ewp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.o.a.a;
import com.tencent.mm.ui.o.a.c;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallShareCouponCardUI
  extends MMActivity
  implements com.tencent.mm.ak.i, a.a, com.tencent.mm.ui.o.a.b
{
  private ProgressDialog gtM;
  private String mDesc;
  private int mFrom;
  private String mTitle;
  private String mWording;
  private View nNt;
  private ProgressDialog vIA;
  private ProgressDialog yuB;
  private TextView yxE;
  private TextView yxF;
  private TextView yxG;
  private TextView yxH;
  private Button yxI;
  private ImageView yxJ;
  private com.tencent.mm.ui.o.a yxK;
  private i yxL;
  private ImageView yxM;
  private ProgressBar yxN;
  private e yxO;
  private String yxP;
  private String yxQ;
  private String yxR;
  private String yxS;
  private String yxT;
  private String yxU;
  private String yxV;
  private String yxW;
  private ewp yxX;
  private String yxY;
  private View yxZ;
  
  public IPCallShareCouponCardUI()
  {
    AppMethodBeat.i(25917);
    this.yxK = new com.tencent.mm.ui.o.a();
    this.gtM = null;
    this.vIA = null;
    this.yxL = null;
    this.yuB = null;
    this.yxM = null;
    this.yxN = null;
    this.yxO = new e();
    this.yxP = null;
    this.mDesc = null;
    this.yxQ = null;
    this.mTitle = null;
    this.mWording = null;
    this.yxR = null;
    this.yxS = null;
    this.yxT = null;
    this.yxU = null;
    this.yxV = null;
    this.yxW = null;
    this.yxX = null;
    this.yxY = null;
    this.mFrom = 0;
    AppMethodBeat.o(25917);
  }
  
  private void E(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(25930);
    this.yxZ = View.inflate(getContext(), 2131493703, null);
    final EditText localEditText = (EditText)this.yxZ.findViewById(2131299004);
    this.yxM = ((ImageView)this.yxZ.findViewById(2131299001));
    this.yxN = ((ProgressBar)this.yxZ.findViewById(2131303709));
    localEditText.setText(paramString1);
    Object localObject = ebs();
    if (localObject == null)
    {
      localObject = z.aTY();
      bg.aVF();
      localObject = new com.tencent.mm.bc.a((String)localObject, Util.nullAsNil((Integer)com.tencent.mm.model.c.azQ().get(66561, null)));
      bg.azz().a((q)localObject, 0);
      this.yxN.setVisibility(0);
    }
    for (;;)
    {
      o.a(this.mController, paramString2, this.yxZ, getResources().getString(2131755976), new y.b()
      {
        public final void qB(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(25906);
          if (paramAnonymousBoolean)
          {
            if (localEditText == null) {}
            for (Object localObject = paramString1;; localObject = localEditText.getText().toString())
            {
              localObject = new com.tencent.mm.modelmulti.h(paramInt, (String)localObject);
              IPCallShareCouponCardUI localIPCallShareCouponCardUI1 = IPCallShareCouponCardUI.this;
              IPCallShareCouponCardUI localIPCallShareCouponCardUI2 = IPCallShareCouponCardUI.this;
              IPCallShareCouponCardUI.this.getString(2131755998);
              IPCallShareCouponCardUI.b(localIPCallShareCouponCardUI1, com.tencent.mm.ui.base.h.a(localIPCallShareCouponCardUI2, IPCallShareCouponCardUI.this.getString(2131755978), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(25905);
                  bg.azz().a(this.yyd);
                  AppMethodBeat.o(25905);
                }
              }));
              bg.azz().a((q)localObject, 0);
              AppMethodBeat.o(25906);
              return;
            }
          }
          AppMethodBeat.o(25906);
        }
      });
      AppMethodBeat.o(25930);
      return;
      if (this.yxM != null) {
        this.yxM.setImageBitmap((Bitmap)localObject);
      }
    }
  }
  
  public static int Pn(int paramInt)
  {
    AppMethodBeat.i(25924);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), Integer.valueOf(2131689802));
    localHashMap.put(Integer.valueOf(0), Integer.valueOf(2131689852));
    localHashMap.put(Integer.valueOf(1), Integer.valueOf(2131689851));
    localHashMap.put(Integer.valueOf(3), Integer.valueOf(2131689803));
    localHashMap.put(Integer.valueOf(2), Integer.valueOf(2131689853));
    localHashMap.put(Integer.valueOf(5), Integer.valueOf(2131689854));
    localHashMap.put(Integer.valueOf(4), Integer.valueOf(2131689855));
    localHashMap.put(Integer.valueOf(6), Integer.valueOf(2131689804));
    localHashMap.put(Integer.valueOf(7), Integer.valueOf(2131689850));
    if (localHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramInt = ((Integer)localHashMap.get(Integer.valueOf(paramInt))).intValue();
      AppMethodBeat.o(25924);
      return paramInt;
    }
    AppMethodBeat.o(25924);
    return -1;
  }
  
  private void Po(int paramInt)
  {
    AppMethodBeat.i(25927);
    com.tencent.mm.ui.base.h.a(getContext(), paramInt, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(25927);
  }
  
  public static void a(Context paramContext, int paramInt, TextView paramTextView, ImageView paramImageView)
  {
    AppMethodBeat.i(25922);
    paramContext = ak(paramContext, paramInt);
    if (paramContext != null) {
      paramTextView.setText(paramContext);
    }
    paramInt = Pn(paramInt);
    if (paramInt != -1) {
      paramImageView.setImageResource(paramInt);
    }
    AppMethodBeat.o(25922);
  }
  
  /* Error */
  private static byte[] aCo(String paramString)
  {
    // Byte code:
    //   0: sipush 25929
    //   3: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 192	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 659	com/tencent/mm/model/c:aSY	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 192	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 662	com/tencent/mm/model/c:aSZ	()Ljava/lang/String;
    //   22: ldc_w 664
    //   25: aload_0
    //   26: invokevirtual 668	java/lang/String:getBytes	()[B
    //   29: invokestatic 674	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   32: ldc_w 676
    //   35: iconst_1
    //   36: invokestatic 682	com/tencent/mm/sdk/platformtools/FilePathGenerator:defGenPathWithOld	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   39: astore_0
    //   40: aload_0
    //   41: invokestatic 686	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   44: ifeq +20 -> 64
    //   47: ldc_w 306
    //   50: ldc_w 688
    //   53: invokestatic 645	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: sipush 25929
    //   59: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aconst_null
    //   63: areturn
    //   64: aload_0
    //   65: iconst_0
    //   66: invokestatic 694	com/tencent/mm/vfs/s:dB	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 700	java/io/RandomAccessFile:length	()J
    //   76: l2i
    //   77: newarray byte
    //   79: astore_2
    //   80: aload_1
    //   81: astore_0
    //   82: aload_1
    //   83: aload_2
    //   84: invokevirtual 704	java/io/RandomAccessFile:read	([B)I
    //   87: pop
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 707	java/io/RandomAccessFile:close	()V
    //   96: sipush 25929
    //   99: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_2
    //   103: areturn
    //   104: astore_2
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: astore_0
    //   109: ldc_w 306
    //   112: aload_2
    //   113: ldc_w 507
    //   116: iconst_0
    //   117: anewarray 436	java/lang/Object
    //   120: invokestatic 711	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 707	java/io/RandomAccessFile:close	()V
    //   131: sipush 25929
    //   134: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_0
    //   142: aload_0
    //   143: ifnull +7 -> 150
    //   146: aload_0
    //   147: invokevirtual 707	java/io/RandomAccessFile:close	()V
    //   150: sipush 25929
    //   153: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: athrow
    //   158: astore_0
    //   159: goto -63 -> 96
    //   162: astore_0
    //   163: goto -32 -> 131
    //   166: astore_0
    //   167: goto -17 -> 150
    //   170: astore_1
    //   171: goto -29 -> 142
    //   174: astore_2
    //   175: goto -68 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramString	String
    //   13	115	1	localObject1	Object
    //   139	18	1	localObject2	Object
    //   170	1	1	localObject3	Object
    //   79	24	2	arrayOfByte	byte[]
    //   104	9	2	localException1	java.lang.Exception
    //   174	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   64	70	104	java/lang/Exception
    //   64	70	139	finally
    //   92	96	158	java/lang/Exception
    //   127	131	162	java/lang/Exception
    //   146	150	166	java/lang/Exception
    //   72	80	170	finally
    //   82	88	170	finally
    //   109	123	170	finally
    //   72	80	174	java/lang/Exception
    //   82	88	174	java/lang/Exception
  }
  
  public static String ak(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(25923);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), paramContext.getString(2131761930));
    localHashMap.put(Integer.valueOf(0), paramContext.getString(2131768664));
    localHashMap.put(Integer.valueOf(1), paramContext.getString(2131761935));
    localHashMap.put(Integer.valueOf(3), paramContext.getString(2131761931));
    localHashMap.put(Integer.valueOf(2), paramContext.getString(2131761934));
    localHashMap.put(Integer.valueOf(5), paramContext.getString(2131761936));
    localHashMap.put(Integer.valueOf(4), paramContext.getString(2131761937));
    localHashMap.put(Integer.valueOf(6), paramContext.getString(2131761933));
    localHashMap.put(Integer.valueOf(7), paramContext.getString(2131761932));
    if (localHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramContext = (String)localHashMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(25923);
      return paramContext;
    }
    AppMethodBeat.o(25923);
    return null;
  }
  
  private static boolean checkApkExist(Context paramContext, String paramString)
  {
    AppMethodBeat.i(25925);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25925);
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      AppMethodBeat.o(25925);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(25925);
    }
    return false;
  }
  
  private static Bitmap ebs()
  {
    AppMethodBeat.i(25928);
    Object localObject = aCo(z.aTY());
    if (localObject == null)
    {
      AppMethodBeat.o(25928);
      return null;
    }
    localObject = BitmapUtil.decodeByteArray((byte[])localObject);
    AppMethodBeat.o(25928);
    return localObject;
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(25926);
    if (this.vIA != null) {
      this.vIA.cancel();
    }
    switch (IPCallShareCouponCardUI.8.yyh[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25926);
      return;
      Po(2131766888);
      AppMethodBeat.o(25926);
      return;
      AppMethodBeat.o(25926);
      return;
      Po(2131766887);
    }
  }
  
  public final void b(a.c paramc) {}
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495096;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(25931);
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      if (!Util.isNullOrNil(paramIntent)) {
        o.a(getController(), this.mTitle, this.yxQ, this.mDesc, true, getResources().getString(2131755976), new y.a()
        {
          public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(25909);
            if (paramAnonymousBoolean)
            {
              Object localObject = new k.b();
              ((k.b)localObject).title = IPCallShareCouponCardUI.d(IPCallShareCouponCardUI.this);
              ((k.b)localObject).url = IPCallShareCouponCardUI.e(IPCallShareCouponCardUI.this);
              ((k.b)localObject).description = IPCallShareCouponCardUI.f(IPCallShareCouponCardUI.this);
              ((k.b)localObject).thumburl = IPCallShareCouponCardUI.g(IPCallShareCouponCardUI.this);
              ((k.b)localObject).type = 5;
              com.tencent.mm.pluginsdk.model.app.m.a((k.b)localObject, null, null, paramIntent, "", null, null);
              if (!Util.isNullOrNil(paramAnonymousString))
              {
                localObject = new tw();
                ((tw)localObject).eaq.dkV = paramIntent;
                ((tw)localObject).eaq.content = paramAnonymousString;
                ((tw)localObject).eaq.type = ab.JG(paramIntent);
                ((tw)localObject).eaq.flags = 0;
                EventCenter.instance.publish((IEvent)localObject);
              }
              com.tencent.mm.ui.base.h.cD(IPCallShareCouponCardUI.this.getContext(), IPCallShareCouponCardUI.this.getResources().getString(2131755986));
              AppMethodBeat.o(25909);
              return;
            }
            AppMethodBeat.o(25909);
          }
        });
      }
    }
    AppMethodBeat.o(25931);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25918);
    super.onCreate(paramBundle);
    setMMTitle(2131762003);
    setBackBtn(new IPCallShareCouponCardUI.1(this));
    this.nNt = findViewById(2131303060);
    this.yxE = ((TextView)findViewById(2131299274));
    this.yxF = ((TextView)findViewById(2131299411));
    this.yxG = ((TextView)findViewById(2131299273));
    this.yxH = ((TextView)findViewById(2131299275));
    this.yxI = ((Button)findViewById(2131307797));
    this.yxJ = ((ImageView)findViewById(2131302292));
    this.nNt.setVisibility(8);
    com.tencent.mm.pluginsdk.ui.a.b.a(this.yxJ, z.aTY(), 0.5F, false);
    paramBundle = getContext();
    getString(2131755998);
    this.yuB = com.tencent.mm.ui.base.h.a(paramBundle, getString(2131761902), true, new IPCallShareCouponCardUI.9(this));
    com.tencent.mm.plugin.ipcall.model.g.b.eaU().qy(false);
    this.mFrom = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
    bg.azz().a(257, this);
    bg.azz().a(1804, this);
    AppMethodBeat.o(25918);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25920);
    super.onDestroy();
    bg.azz().b(257, this);
    bg.azz().b(1804, this);
    AppMethodBeat.o(25920);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25919);
    super.onResume();
    AppMethodBeat.o(25919);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25921);
    String str;
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof g)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.nNt.setVisibility(0);
        paramString = com.tencent.mm.plugin.ipcall.a.c.ebR();
        if (paramString != null)
        {
          this.yxP = paramString.MdG;
          this.mDesc = paramString.Desc;
          this.yxQ = paramString.MdH;
          this.mTitle = paramString.Title;
          this.mWording = paramString.xJH;
          this.yxR = paramString.MdI;
          this.yxT = paramString.MdJ;
          this.yxU = paramString.MdK;
          this.yxV = paramString.MdL;
          this.yxW = paramString.MdN;
          this.yxX = paramString.MdM;
          this.yxY = paramString.MdO;
        }
        this.yxE.setText(this.yxW);
        this.yxF.setText(String.format(getContext().getString(2131761996), new Object[] { this.yxP }));
        this.yxI.setOnClickListener(new IPCallShareCouponCardUI.11(this));
        this.yxG.setText(String.format(getString(2131761998), new Object[] { this.yxW }));
        paramq = this.yxH;
        str = String.format(getString(2131761997), new Object[] { this.yxW });
        localObject1 = getString(2131762002);
        if (Util.isNullOrNil((String)localObject1))
        {
          paramq.setText(str);
          if ((this.yuB != null) && (this.yuB.isShowing())) {
            this.yuB.dismiss();
          }
          AppMethodBeat.o(25921);
          return;
        }
        paramString = getString(2131762005);
        localObject2 = paramq.getPaint();
        float f1 = ((TextPaint)localObject2).measureText(str);
        float f2 = ((TextPaint)localObject2).measureText(paramString);
        paramInt1 = com.tencent.mm.cb.a.jn(getContext());
        paramInt2 = ((LinearLayout.LayoutParams)paramq.getLayoutParams()).leftMargin;
        paramInt1 -= ((LinearLayout.LayoutParams)paramq.getLayoutParams()).rightMargin + paramInt2;
        paramInt2 = (int)Math.ceil(f1 / paramInt1);
        int i = (int)Math.ceil((f1 + f2) / paramInt1);
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = 1;
        }
        if (i <= paramInt1) {
          break label743;
        }
        paramString = "\n".concat(String.valueOf(paramString));
      }
    }
    label743:
    for (;;)
    {
      paramq.setGravity(17);
      localObject2 = Spannable.Factory.getInstance().newSpannable(str + paramString);
      localObject1 = new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25907);
          ((TextView)paramAnonymousView).setHighlightColor(IPCallShareCouponCardUI.this.getResources().getColor(2131101287));
          com.tencent.mm.plugin.report.service.h.CyF.a(13340, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1) });
          com.tencent.mm.ui.base.h.c(IPCallShareCouponCardUI.this.getContext(), this.yyf, IPCallShareCouponCardUI.this.getString(2131762006), true).a(2131761878, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(25907);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(25908);
          paramAnonymousTextPaint.setColor(IPCallShareCouponCardUI.this.getResources().getColor(2131100685));
          paramAnonymousTextPaint.setUnderlineText(false);
          AppMethodBeat.o(25908);
        }
      };
      paramInt1 = str.length();
      paramInt2 = str.length();
      ((Spannable)localObject2).setSpan(localObject1, paramInt1, paramString.length() + paramInt2, 33);
      paramq.setText((CharSequence)localObject2);
      paramq.setMovementMethod(LinkMovementMethod.getInstance());
      break;
      if ((this.yuB != null) && (this.yuB.isShowing()))
      {
        this.yuB.dismiss();
        com.tencent.mm.ui.base.h.d(getContext(), getString(2131761900), getString(2131761893), new IPCallShareCouponCardUI.10(this));
        AppMethodBeat.o(25921);
        return;
        if ((paramq instanceof com.tencent.mm.modelmulti.h))
        {
          if (this.gtM != null)
          {
            this.gtM.dismiss();
            this.gtM = null;
          }
          if (com.tencent.mm.plugin.subapp.b.jRu.b(getContext(), paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(25921);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            com.tencent.mm.ui.base.h.n(getContext(), 2131765235, 2131755998);
            AppMethodBeat.o(25921);
            return;
          }
          com.tencent.mm.ui.base.h.cD(this, getResources().getString(2131757788));
          AppMethodBeat.o(25921);
          return;
        }
        if ((paramq instanceof com.tencent.mm.bc.a))
        {
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            AppMethodBeat.o(25921);
            return;
          }
          if (this.yxM != null)
          {
            if (this.yxN != null) {
              this.yxN.setVisibility(8);
            }
            this.yxM.setImageBitmap(ebs());
          }
        }
      }
      AppMethodBeat.o(25921);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI
 * JD-Core Version:    0.7.0.1
 */