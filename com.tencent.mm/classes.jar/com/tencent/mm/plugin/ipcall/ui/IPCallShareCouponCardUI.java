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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.plugin.ipcall.model.f.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.protocal.protobuf.cfz;
import com.tencent.mm.protocal.protobuf.fhb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.q.a.a;
import com.tencent.mm.ui.q.a.c;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallShareCouponCardUI
  extends MMActivity
  implements com.tencent.mm.an.i, a.a, com.tencent.mm.ui.q.a.b
{
  private ProgressDialog Apv;
  private ProgressDialog DUF;
  private TextView DXI;
  private TextView DXJ;
  private TextView DXK;
  private TextView DXL;
  private Button DXM;
  private ImageView DXN;
  private com.tencent.mm.ui.q.a DXO;
  private i DXP;
  private ImageView DXQ;
  private ProgressBar DXR;
  private e DXS;
  private String DXT;
  private String DXU;
  private String DXV;
  private String DXW;
  private String DXX;
  private String DXY;
  private String DXZ;
  private String DYa;
  private fhb DYb;
  private String DYc;
  private View DYd;
  private ProgressDialog iXX;
  private String mDesc;
  private int mFrom;
  private String mTitle;
  private String mWording;
  private View qPO;
  
  public IPCallShareCouponCardUI()
  {
    AppMethodBeat.i(25917);
    this.DXO = new com.tencent.mm.ui.q.a();
    this.iXX = null;
    this.Apv = null;
    this.DXP = null;
    this.DUF = null;
    this.DXQ = null;
    this.DXR = null;
    this.DXS = new e();
    this.DXT = null;
    this.mDesc = null;
    this.DXU = null;
    this.mTitle = null;
    this.mWording = null;
    this.DXV = null;
    this.DXW = null;
    this.DXX = null;
    this.DXY = null;
    this.DXZ = null;
    this.DYa = null;
    this.DYb = null;
    this.DYc = null;
    this.mFrom = 0;
    AppMethodBeat.o(25917);
  }
  
  private void H(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(25930);
    this.DYd = View.inflate(getContext(), R.i.confirm_dialog_item, null);
    final EditText localEditText = (EditText)this.DYd.findViewById(R.h.confirm_dialog_text_et);
    this.DXQ = ((ImageView)this.DYd.findViewById(R.h.confirm_dialog_imageview));
    this.DXR = ((ProgressBar)this.DYd.findViewById(R.h.loading_pb));
    localEditText.setText(paramString1);
    Object localObject = eKq();
    if (localObject == null)
    {
      localObject = z.bcZ();
      bh.beI();
      localObject = new com.tencent.mm.bf.a((String)localObject, Util.nullAsNil((Integer)com.tencent.mm.model.c.aHp().b(66561, null)));
      bh.aGY().a((q)localObject, 0);
      this.DXR.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.pluginsdk.ui.applet.o.a(this.mController, paramString2, this.DYd, getResources().getString(R.l.app_send), new y.b()
      {
        public final void tD(boolean paramAnonymousBoolean)
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
              IPCallShareCouponCardUI.this.getString(R.l.app_tip);
              IPCallShareCouponCardUI.b(localIPCallShareCouponCardUI1, com.tencent.mm.ui.base.h.a(localIPCallShareCouponCardUI2, IPCallShareCouponCardUI.this.getString(R.l.app_sending), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(25905);
                  bh.aGY().a(this.DYh);
                  AppMethodBeat.o(25905);
                }
              }));
              bh.aGY().a((q)localObject, 0);
              AppMethodBeat.o(25906);
              return;
            }
          }
          AppMethodBeat.o(25906);
        }
      });
      AppMethodBeat.o(25930);
      return;
      if (this.DXQ != null) {
        this.DXQ.setImageBitmap((Bitmap)localObject);
      }
    }
  }
  
  public static int Vw(int paramInt)
  {
    AppMethodBeat.i(25924);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), Integer.valueOf(R.k.bottomsheet_copy));
    localHashMap.put(Integer.valueOf(0), Integer.valueOf(R.k.bottomsheet_repost));
    localHashMap.put(Integer.valueOf(1), Integer.valueOf(R.k.bottomsheet_moment));
    localHashMap.put(Integer.valueOf(3), Integer.valueOf(R.k.bottomsheet_email));
    localHashMap.put(Integer.valueOf(2), Integer.valueOf(R.k.bottomsheet_sms));
    localHashMap.put(Integer.valueOf(5), Integer.valueOf(R.k.bottomsheet_twitter));
    localHashMap.put(Integer.valueOf(4), Integer.valueOf(R.k.bottomsheet_whatsapp));
    localHashMap.put(Integer.valueOf(6), Integer.valueOf(R.k.bottomsheet_facebook));
    localHashMap.put(Integer.valueOf(7), Integer.valueOf(R.k.bottomsheet_messenger));
    if (localHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramInt = ((Integer)localHashMap.get(Integer.valueOf(paramInt))).intValue();
      AppMethodBeat.o(25924);
      return paramInt;
    }
    AppMethodBeat.o(25924);
    return -1;
  }
  
  private void Vx(int paramInt)
  {
    AppMethodBeat.i(25927);
    com.tencent.mm.ui.base.h.a(getContext(), paramInt, R.l.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(25927);
  }
  
  public static String aB(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(25923);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), paramContext.getString(R.l.eJi));
    localHashMap.put(Integer.valueOf(0), paramContext.getString(R.l.eVQ));
    localHashMap.put(Integer.valueOf(1), paramContext.getString(R.l.eJn));
    localHashMap.put(Integer.valueOf(3), paramContext.getString(R.l.eJj));
    localHashMap.put(Integer.valueOf(2), paramContext.getString(R.l.eJm));
    localHashMap.put(Integer.valueOf(5), paramContext.getString(R.l.eJo));
    localHashMap.put(Integer.valueOf(4), paramContext.getString(R.l.eJp));
    localHashMap.put(Integer.valueOf(6), paramContext.getString(R.l.eJl));
    localHashMap.put(Integer.valueOf(7), paramContext.getString(R.l.eJk));
    if (localHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramContext = (String)localHashMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(25923);
      return paramContext;
    }
    AppMethodBeat.o(25923);
    return null;
  }
  
  /* Error */
  private static byte[] aMv(String paramString)
  {
    // Byte code:
    //   0: sipush 25929
    //   3: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 204	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 735	com/tencent/mm/model/c:bbW	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 204	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 738	com/tencent/mm/model/c:bbX	()Ljava/lang/String;
    //   22: ldc_w 740
    //   25: aload_0
    //   26: invokevirtual 744	java/lang/String:getBytes	()[B
    //   29: invokestatic 750	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   32: ldc_w 752
    //   35: iconst_1
    //   36: invokestatic 758	com/tencent/mm/sdk/platformtools/FilePathGenerator:defGenPathWithOld	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   39: astore_0
    //   40: aload_0
    //   41: invokestatic 762	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   44: ifeq +20 -> 64
    //   47: ldc_w 345
    //   50: ldc_w 764
    //   53: invokestatic 685	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: sipush 25929
    //   59: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aconst_null
    //   63: areturn
    //   64: aload_0
    //   65: iconst_0
    //   66: invokestatic 770	com/tencent/mm/vfs/u:dO	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 776	java/io/RandomAccessFile:length	()J
    //   76: l2i
    //   77: newarray byte
    //   79: astore_2
    //   80: aload_1
    //   81: astore_0
    //   82: aload_1
    //   83: aload_2
    //   84: invokevirtual 780	java/io/RandomAccessFile:read	([B)I
    //   87: pop
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 783	java/io/RandomAccessFile:close	()V
    //   96: sipush 25929
    //   99: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_2
    //   103: areturn
    //   104: astore_2
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: astore_0
    //   109: ldc_w 345
    //   112: aload_2
    //   113: ldc_w 538
    //   116: iconst_0
    //   117: anewarray 465	java/lang/Object
    //   120: invokestatic 787	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 783	java/io/RandomAccessFile:close	()V
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
    //   147: invokevirtual 783	java/io/RandomAccessFile:close	()V
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
  
  private static Bitmap eKq()
  {
    AppMethodBeat.i(25928);
    Object localObject = aMv(z.bcZ());
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
    if (this.Apv != null) {
      this.Apv.cancel();
    }
    switch (IPCallShareCouponCardUI.8.DYl[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25926);
      return;
      Vx(R.l.twitterlogin_success);
      AppMethodBeat.o(25926);
      return;
      AppMethodBeat.o(25926);
      return;
      Vx(R.l.twitterlogin_failed);
    }
  }
  
  public final void b(a.c paramc) {}
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.ehP;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(25931);
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      if (!Util.isNullOrNil(paramIntent)) {
        com.tencent.mm.pluginsdk.ui.applet.o.a(getController(), this.mTitle, this.DXU, this.mDesc, true, getResources().getString(R.l.app_send), new y.a()
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
              m.a((k.b)localObject, null, null, paramIntent, "", null, null);
              if (!Util.isNullOrNil(paramAnonymousString))
              {
                localObject = new uz();
                ((uz)localObject).fUn.fcD = paramIntent;
                ((uz)localObject).fUn.content = paramAnonymousString;
                ((uz)localObject).fUn.type = ab.QZ(paramIntent);
                ((uz)localObject).fUn.flags = 0;
                EventCenter.instance.publish((IEvent)localObject);
              }
              com.tencent.mm.ui.base.h.cO(IPCallShareCouponCardUI.this.getContext(), IPCallShareCouponCardUI.this.getResources().getString(R.l.app_shared));
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
    setMMTitle(R.l.eKi);
    setBackBtn(new IPCallShareCouponCardUI.1(this));
    this.qPO = findViewById(R.h.layout);
    this.DXI = ((TextView)findViewById(R.h.dCR));
    this.DXJ = ((TextView)findViewById(R.h.dDC));
    this.DXK = ((TextView)findViewById(R.h.dCQ));
    this.DXL = ((TextView)findViewById(R.h.dCS));
    this.DXM = ((Button)findViewById(R.h.dUY));
    this.DXN = ((ImageView)findViewById(R.h.header_icon));
    this.qPO.setVisibility(8);
    com.tencent.mm.pluginsdk.ui.a.b.a(this.DXN, z.bcZ(), 0.5F, false);
    paramBundle = getContext();
    getString(R.l.app_tip);
    this.DUF = com.tencent.mm.ui.base.h.a(paramBundle, getString(R.l.eIQ), true, new IPCallShareCouponCardUI.9(this));
    com.tencent.mm.plugin.ipcall.model.g.b.eJS().tA(false);
    this.mFrom = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
    bh.aGY().a(257, this);
    bh.aGY().a(1804, this);
    AppMethodBeat.o(25918);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25920);
    super.onDestroy();
    bh.aGY().b(257, this);
    bh.aGY().b(1804, this);
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
        this.qPO.setVisibility(0);
        paramString = com.tencent.mm.plugin.ipcall.a.c.eKP();
        if (paramString != null)
        {
          this.DXT = paramString.Tnh;
          this.mDesc = paramString.CMB;
          this.DXU = paramString.Tni;
          this.mTitle = paramString.fwr;
          this.mWording = paramString.CNP;
          this.DXV = paramString.Tnj;
          this.DXX = paramString.Tnk;
          this.DXY = paramString.Tnl;
          this.DXZ = paramString.Tnm;
          this.DYa = paramString.Tno;
          this.DYb = paramString.Tnn;
          this.DYc = paramString.Tnp;
        }
        this.DXI.setText(this.DYa);
        this.DXJ.setText(String.format(getContext().getString(R.l.eKd), new Object[] { this.DXT }));
        this.DXM.setOnClickListener(new IPCallShareCouponCardUI.11(this));
        this.DXK.setText(String.format(getString(R.l.eKf), new Object[] { this.DYa }));
        paramq = this.DXL;
        str = String.format(getString(R.l.eKe), new Object[] { this.DYa });
        localObject1 = getString(R.l.eKh);
        if (Util.isNullOrNil((String)localObject1))
        {
          paramq.setText(str);
          if ((this.DUF != null) && (this.DUF.isShowing())) {
            this.DUF.dismiss();
          }
          AppMethodBeat.o(25921);
          return;
        }
        paramString = getString(R.l.eKj);
        localObject2 = paramq.getPaint();
        float f1 = ((TextPaint)localObject2).measureText(str);
        float f2 = ((TextPaint)localObject2).measureText(paramString);
        paramInt1 = com.tencent.mm.ci.a.kr(getContext());
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
          ((TextView)paramAnonymousView).setHighlightColor(IPCallShareCouponCardUI.this.getResources().getColor(R.e.transparent));
          com.tencent.mm.plugin.report.service.h.IzE.a(13340, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1) });
          com.tencent.mm.ui.base.h.c(IPCallShareCouponCardUI.this.getContext(), this.DYj, IPCallShareCouponCardUI.this.getString(R.l.eKk), true).a(R.l.eIB, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(25907);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(25908);
          paramAnonymousTextPaint.setColor(IPCallShareCouponCardUI.this.getResources().getColor(R.e.link_color));
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
      if ((this.DUF != null) && (this.DUF.isShowing()))
      {
        this.DUF.dismiss();
        com.tencent.mm.ui.base.h.d(getContext(), getString(R.l.eIO), getString(R.l.ip_call_func_name), new IPCallShareCouponCardUI.10(this));
        AppMethodBeat.o(25921);
        return;
        if ((paramq instanceof com.tencent.mm.modelmulti.h))
        {
          if (this.iXX != null)
          {
            this.iXX.dismiss();
            this.iXX = null;
          }
          if (com.tencent.mm.plugin.subapp.b.mIH.b(getContext(), paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(25921);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            com.tencent.mm.ui.base.h.p(getContext(), R.l.sendrequest_send_fail, R.l.app_tip);
            AppMethodBeat.o(25921);
            return;
          }
          com.tencent.mm.ui.base.h.cO(this, getResources().getString(R.l.confirm_dialog_sent));
          AppMethodBeat.o(25921);
          return;
        }
        if ((paramq instanceof com.tencent.mm.bf.a))
        {
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            AppMethodBeat.o(25921);
            return;
          }
          if (this.DXQ != null)
          {
            if (this.DXR != null) {
              this.DXR.setVisibility(8);
            }
            this.DXQ.setImageBitmap(eKq());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI
 * JD-Core Version:    0.7.0.1
 */