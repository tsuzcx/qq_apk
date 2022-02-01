package com.tencent.mm.plugin.editor;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v4.view.t;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.as;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.editor.adapter.CollectEditorLinearLayoutManager;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.nativenote.c.e.10;
import com.tencent.mm.plugin.editor.model.nativenote.c.e.11;
import com.tencent.mm.plugin.editor.model.nativenote.c.e.12;
import com.tencent.mm.plugin.editor.model.nativenote.c.e.13;
import com.tencent.mm.plugin.editor.model.nativenote.c.e.2;
import com.tencent.mm.plugin.editor.model.nativenote.c.e.3;
import com.tencent.mm.plugin.editor.model.nativenote.c.e.4;
import com.tencent.mm.plugin.editor.model.nativenote.c.e.5;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.d.a;
import com.tencent.mm.plugin.editor.model.nativenote.manager.e.a;
import com.tencent.mm.plugin.editor.widget.a.1;
import com.tencent.mm.plugin.editor.widget.a.10;
import com.tencent.mm.plugin.editor.widget.a.11;
import com.tencent.mm.plugin.editor.widget.a.12;
import com.tencent.mm.plugin.editor.widget.a.5;
import com.tencent.mm.plugin.editor.widget.a.6;
import com.tencent.mm.plugin.editor.widget.a.7;
import com.tencent.mm.plugin.editor.widget.a.8;
import com.tencent.mm.plugin.editor.widget.a.9;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class EditorUI
  extends MMActivity
  implements com.tencent.mm.plugin.editor.model.nativenote.a, com.tencent.mm.plugin.editor.model.nativenote.b.a, d.a
{
  private g.a hhW;
  private ap iDu;
  private float jhc;
  private float jhd;
  ProgressDialog mVv;
  private com.tencent.mm.plugin.editor.model.nativenote.manager.d okA;
  private com.tencent.mm.plugin.editor.model.nativenote.manager.j okB;
  private boolean okC;
  private int okD;
  private RecyclerView.m okE;
  private boolean okF;
  private boolean okG;
  private boolean okH;
  private String okI;
  private boolean okJ;
  private int okK;
  private boolean okL;
  private afy okM;
  View.OnTouchListener okN;
  com.tencent.mm.plugin.fav.a.g okO;
  LinkedList<afy> okP;
  private ConcurrentHashMap<String, com.tencent.mm.plugin.fav.a.c> okQ;
  private ConcurrentHashMap<String, afy> okR;
  private boolean okr;
  private RecyclerView oks;
  private com.tencent.mm.plugin.editor.adapter.b okt;
  private CollectEditorLinearLayoutManager oku;
  private a okv;
  private LinearLayout okw;
  com.tencent.mm.plugin.editor.widget.a okx;
  private LinearLayout oky;
  private RelativeLayout okz;
  
  public EditorUI()
  {
    AppMethodBeat.i(181554);
    this.okr = false;
    this.okC = true;
    this.okK = -1;
    this.okN = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(181531);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          EditorUI.a(EditorUI.this, paramAnonymousMotionEvent.getX());
          EditorUI.b(EditorUI.this, paramAnonymousMotionEvent.getY());
        }
        float f1;
        float f2;
        if ((paramAnonymousMotionEvent.getAction() == 1) && (EditorUI.h(EditorUI.this).o(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()) == null))
        {
          f1 = Math.abs(EditorUI.n(EditorUI.this) - paramAnonymousMotionEvent.getX());
          f2 = Math.abs(EditorUI.o(EditorUI.this) - paramAnonymousMotionEvent.getY());
          if ((f1 < 30.0F) && (f2 < 30.0F))
          {
            if (EditorUI.b(EditorUI.this).getVisibility() == 8) {
              break label170;
            }
            if (EditorUI.a(EditorUI.this) != null) {
              EditorUI.a(EditorUI.this).onq.dismiss();
            }
            EditorUI.b(EditorUI.this).setVisibility(8);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(181531);
          return false;
          label170:
          int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().size();
          paramAnonymousView = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().Aa(i - 1);
          if (paramAnonymousView != null)
          {
            boolean bool = paramAnonymousView.omv;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSt();
            paramAnonymousView.omv = true;
            paramAnonymousView.omB = false;
            paramAnonymousView.omx = -1;
            EditorUI.g(EditorUI.this).ck(i - 1);
            EditorUI.this.e(true, 50L);
            EditorUI.this.N(1, 0L);
            if ((EditorUI.p(EditorUI.this)) && (bool))
            {
              EditorUI.q(EditorUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181530);
                  com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().jx(true);
                  com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().jw(true);
                  AppMethodBeat.o(181530);
                }
              }, 100L);
              continue;
              if (paramAnonymousMotionEvent.getAction() == 2)
              {
                f1 = Math.abs(EditorUI.n(EditorUI.this) - paramAnonymousMotionEvent.getX());
                f2 = Math.abs(EditorUI.o(EditorUI.this) - paramAnonymousMotionEvent.getY());
                if ((f1 > 120.0F) || (f2 > 120.0F)) {
                  if (EditorUI.p(EditorUI.this))
                  {
                    if (com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bSV() == 1)
                    {
                      EditorUI.this.bRF();
                      com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTb();
                    }
                  }
                  else if (!EditorUI.r(EditorUI.this)) {
                    EditorUI.this.bRF();
                  }
                }
              }
            }
          }
        }
      }
    };
    this.okP = new LinkedList();
    this.okQ = new ConcurrentHashMap();
    this.okR = new ConcurrentHashMap();
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(181537);
        if (paramAnonymousInt != 0)
        {
          ad.e("MicroMsg.EditorUI", "transfer err! startRet: %s.", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(181537);
          return 0;
        }
        paramAnonymousc = (com.tencent.mm.plugin.fav.a.c)EditorUI.s(EditorUI.this).get(paramAnonymousString);
        if (paramAnonymousc == null)
        {
          ad.e("MicroMsg.EditorUI", "cdn info is null!!!");
          AppMethodBeat.o(181537);
          return 0;
        }
        afy localafy = (afy)EditorUI.t(EditorUI.this).get(paramAnonymousString);
        if (localafy == null)
        {
          ad.e("MicroMsg.EditorUI", "data item is null!!!");
          AppMethodBeat.o(181537);
          return 0;
        }
        String str;
        Object localObject;
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode >= 0))
        {
          if (1 != paramAnonymousc.field_type) {
            break label374;
          }
          str = paramAnonymousc.field_path + ".temp";
          localObject = paramAnonymousc.field_path;
          paramAnonymousInt = paramAnonymousc.field_dataType;
          if ((str != null) && (localObject != null)) {
            break label273;
          }
          if (!paramAnonymousString.endsWith("_t")) {
            break label395;
          }
          localafy.aDo(paramAnonymousc.field_cdnKey);
          localafy.aDn(paramAnonymousc.field_cdnUrl);
          label197:
          EditorUI.s(EditorUI.this).remove(paramAnonymousc.field_dataId);
          ad.i("MicroMsg.EditorUI", "transfer done, mediaId=%s completeResult.mediaId=%s aesKey=%s completeInfo=%s", new Object[] { paramAnonymousString, paramAnonymousd.mediaId, paramAnonymousd.field_aesKey, paramAnonymousd.toString() });
          if (1 != paramAnonymousc.field_type) {
            break label462;
          }
          EditorUI.u(EditorUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(181537);
          return 0;
          label273:
          if ((paramAnonymousInt == -2) && (!EditorUI.SR(str)) && (EditorUI.eQ(str, (String)localObject)))
          {
            ad.i("MicroMsg.EditorUI", "renameAndCopyFile write amr head ok!");
            break;
          }
          com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(str);
          localObject = new com.tencent.mm.vfs.e((String)localObject);
          if (!locale.exists()) {
            break;
          }
          ad.i("MicroMsg.EditorUI", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(locale.af((com.tencent.mm.vfs.e)localObject)), str, localObject });
          break;
          label374:
          paramAnonymousc.field_cdnKey = paramAnonymousd.field_aesKey;
          paramAnonymousc.field_cdnUrl = paramAnonymousd.field_fileId;
          break;
          label395:
          localafy.aDq(paramAnonymousc.field_cdnKey);
          localafy.aDp(paramAnonymousc.field_cdnUrl);
          if ((paramAnonymousc.field_type != 0) || (!paramAnonymousc.chB())) {
            break label197;
          }
          ad.i("MicroMsg.EditorUI", "video stream, id:%s", new Object[] { paramAnonymousd.field_videoFileId });
          localafy.aDE(paramAnonymousd.field_videoFileId);
          break label197;
          label462:
          EditorUI.v(EditorUI.this);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    AppMethodBeat.o(181554);
  }
  
  private void G(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(181560);
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().eY(0, paramArrayList.size()))
    {
      bRz();
      AppMethodBeat.o(181560);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.mVv = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(181540);
        if (EditorUI.c(EditorUI.this) != null)
        {
          EditorUI.c(EditorUI.this).dismiss();
          EditorUI.d(EditorUI.this);
        }
        AppMethodBeat.o(181540);
      }
    });
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181541);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramArrayList.size())
        {
          String str = (String)paramArrayList.get(i);
          com.tencent.mm.plugin.editor.model.a.h localh = new com.tencent.mm.plugin.editor.model.a.h();
          localh.omJ = true;
          localh.type = 2;
          localh.omI = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSw();
          localh.dkb = com.tencent.mm.plugin.editor.model.b.Tb(localh.toString());
          EditorUI.a(EditorUI.this, new afy());
          EditorUI.e(EditorUI.this).aDy(localh.dkb);
          localh.omG = b.eR(str, com.tencent.mm.plugin.editor.model.b.b(EditorUI.e(EditorUI.this)));
          localh.drZ = b.eS(localh.omG, com.tencent.mm.plugin.editor.model.b.a(EditorUI.e(EditorUI.this)));
          localArrayList.add(localh);
          i += 1;
        }
        if ((EditorUI.c(EditorUI.this) != null) && (EditorUI.c(EditorUI.this).isShowing()))
        {
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().a(localArrayList, EditorUI.f(EditorUI.this).bSS(), true, false, true, false);
          EditorUI.this.e(true, 100L);
          EditorUI.this.N(1, 0L);
          AppMethodBeat.o(181541);
          return;
        }
        ad.i("MicroMsg.EditorUI", "user canceled");
        AppMethodBeat.o(181541);
      }
    });
    AppMethodBeat.o(181560);
  }
  
  private void SP(String paramString)
  {
    AppMethodBeat.i(181561);
    Object localObject = com.tencent.mm.plugin.sight.base.e.ano(paramString);
    if (localObject == null)
    {
      ad.e("MicroMsg.EditorUI", "mediaInfo is null, videoPath is %s", new Object[] { bt.nullAsNil(paramString) });
      AppMethodBeat.o(181561);
      return;
    }
    int i = ((com.tencent.mm.plugin.sight.base.a)localObject).getVideoDuration();
    localObject = new l();
    ((l)localObject).omJ = true;
    ((l)localObject).thumbPath = "";
    ((l)localObject).drZ = "";
    ((l)localObject).duration = i;
    ((l)localObject).type = 6;
    ((l)localObject).omI = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSw();
    ((l)localObject).omK = com.tencent.mm.vfs.i.RK(paramString);
    ((l)localObject).dkb = com.tencent.mm.plugin.editor.model.b.Tb(localObject.toString());
    this.okM = new afy();
    this.okM.aDy(((l)localObject).dkb);
    this.okM.aDv(((l)localObject).omK);
    a(paramString, (l)localObject, com.tencent.mm.plugin.editor.model.b.a(this.okM), com.tencent.mm.plugin.editor.model.b.b(this.okM));
    AppMethodBeat.o(181561);
  }
  
  static boolean SQ(String paramString)
  {
    AppMethodBeat.i(181600);
    boolean bool = bt.isNullOrNil(b.Ta(paramString));
    AppMethodBeat.o(181600);
    return bool;
  }
  
  /* Error */
  static boolean SR(String paramString)
  {
    // Byte code:
    //   0: ldc_w 334
    //   3: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 336	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: ldc_w 338
    //   14: invokespecial 341	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: astore_3
    //   18: aload_3
    //   19: astore_0
    //   20: bipush 6
    //   22: newarray byte
    //   24: astore 4
    //   26: aload_3
    //   27: astore_0
    //   28: aload_3
    //   29: aload 4
    //   31: iconst_0
    //   32: bipush 6
    //   34: invokevirtual 345	java/io/RandomAccessFile:read	([BII)I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpne +32 -> 72
    //   43: aload_3
    //   44: invokevirtual 348	java/io/RandomAccessFile:close	()V
    //   47: ldc_w 334
    //   50: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_0
    //   54: ireturn
    //   55: astore_0
    //   56: ldc 230
    //   58: aload_0
    //   59: ldc_w 259
    //   62: iconst_0
    //   63: anewarray 234	java/lang/Object
    //   66: invokestatic 352	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: goto -22 -> 47
    //   72: aload_3
    //   73: astore_0
    //   74: new 354	java/lang/String
    //   77: dup
    //   78: aload 4
    //   80: invokespecial 357	java/lang/String:<init>	([B)V
    //   83: astore 4
    //   85: aload_3
    //   86: astore_0
    //   87: ldc 230
    //   89: new 359	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 361
    //   96: invokespecial 363	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload 4
    //   101: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 369
    //   107: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 372	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_3
    //   117: astore_0
    //   118: aload 4
    //   120: ldc_w 374
    //   123: invokevirtual 377	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   126: istore_2
    //   127: aload_3
    //   128: invokevirtual 348	java/io/RandomAccessFile:close	()V
    //   131: ldc_w 334
    //   134: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iload_2
    //   138: ireturn
    //   139: astore_0
    //   140: ldc 230
    //   142: aload_0
    //   143: ldc_w 259
    //   146: iconst_0
    //   147: anewarray 234	java/lang/Object
    //   150: invokestatic 352	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: goto -22 -> 131
    //   156: astore 4
    //   158: aconst_null
    //   159: astore_3
    //   160: aload_3
    //   161: astore_0
    //   162: ldc 230
    //   164: aload 4
    //   166: ldc_w 259
    //   169: iconst_0
    //   170: anewarray 234	java/lang/Object
    //   173: invokestatic 352	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_3
    //   177: ifnull +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 348	java/io/RandomAccessFile:close	()V
    //   184: ldc_w 334
    //   187: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: iconst_0
    //   191: ireturn
    //   192: astore_0
    //   193: ldc 230
    //   195: aload_0
    //   196: ldc_w 259
    //   199: iconst_0
    //   200: anewarray 234	java/lang/Object
    //   203: invokestatic 352	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -22 -> 184
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_0
    //   212: aload_0
    //   213: ifnull +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 348	java/io/RandomAccessFile:close	()V
    //   220: ldc_w 334
    //   223: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_3
    //   227: athrow
    //   228: astore_0
    //   229: ldc 230
    //   231: aload_0
    //   232: ldc_w 259
    //   235: iconst_0
    //   236: anewarray 234	java/lang/Object
    //   239: invokestatic 352	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: goto -22 -> 220
    //   245: astore_3
    //   246: goto -34 -> 212
    //   249: astore 4
    //   251: goto -91 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramString	String
    //   37	4	1	i	int
    //   126	12	2	bool	boolean
    //   17	164	3	localRandomAccessFile	java.io.RandomAccessFile
    //   209	18	3	localObject1	Object
    //   245	1	3	localObject2	Object
    //   24	95	4	localObject3	Object
    //   156	9	4	localException1	Exception
    //   249	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   43	47	55	java/io/IOException
    //   127	131	139	java/io/IOException
    //   6	18	156	java/lang/Exception
    //   180	184	192	java/io/IOException
    //   6	18	209	finally
    //   216	220	228	java/io/IOException
    //   20	26	245	finally
    //   28	38	245	finally
    //   74	85	245	finally
    //   87	116	245	finally
    //   118	127	245	finally
    //   162	176	245	finally
    //   20	26	249	java/lang/Exception
    //   28	38	249	java/lang/Exception
    //   74	85	249	java/lang/Exception
    //   87	116	249	java/lang/Exception
    //   118	127	249	java/lang/Exception
  }
  
  private static int a(com.tencent.mm.plugin.fav.a.c paramc, int paramInt)
  {
    AppMethodBeat.i(181604);
    if (paramc.field_totalLen > 26214400)
    {
      paramInt = com.tencent.mm.i.a.fna;
      AppMethodBeat.o(181604);
      return paramInt;
    }
    if ((paramc.field_extFlag & 0x1) == 0)
    {
      AppMethodBeat.o(181604);
      return paramInt;
    }
    ad.w("MicroMsg.EditorUI", "NEED To Exchange Type, defType %d", new Object[] { Integer.valueOf(paramInt) });
    if (com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO == paramInt)
    {
      paramInt = com.tencent.mm.i.a.MediaType_FAVORITE_FILE;
      AppMethodBeat.o(181604);
      return paramInt;
    }
    paramInt = com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO;
    AppMethodBeat.o(181604);
    return paramInt;
  }
  
  private com.tencent.mm.plugin.fav.a.c a(afy paramafy, int paramInt)
  {
    AppMethodBeat.i(181603);
    if ((1 == paramInt) && ((bt.isNullOrNil(paramafy.Dgb)) || (bt.isNullOrNil(paramafy.DfZ))))
    {
      ad.e("MicroMsg.EditorUI", "getCdnDataInfo, type recv, cdnDataUrl must not be null!");
      AppMethodBeat.o(181603);
      return null;
    }
    if ((paramInt == 0) && (bt.isNullOrNil(com.tencent.mm.plugin.fav.a.b.d(paramafy))))
    {
      ad.e("MicroMsg.EditorUI", "getCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(181603);
      return null;
    }
    com.tencent.mm.plugin.fav.a.c localc = new com.tencent.mm.plugin.fav.a.c();
    localc.field_dataId = paramafy.dkb;
    localc.field_totalLen = ((int)paramafy.Dgu);
    localc.field_type = paramInt;
    localc.field_favLocalId = this.okO.field_localId;
    localc.field_cdnKey = paramafy.Dgb;
    localc.field_cdnUrl = paramafy.DfZ;
    localc.field_path = com.tencent.mm.plugin.fav.a.b.d(paramafy);
    if (paramafy.dataType == 3) {}
    for (localc.field_dataType = com.tencent.mm.plugin.fav.a.b.XU(paramafy.Dgo);; localc.field_dataType = paramafy.dataType)
    {
      localc.field_modifyTime = bt.eGO();
      localc.field_status = 1;
      AppMethodBeat.o(181603);
      return localc;
    }
  }
  
  private void a(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(181602);
    if (paramc == null)
    {
      AppMethodBeat.o(181602);
      return;
    }
    ad.i("MicroMsg.EditorUI", "startTransfer, md5:%s", new Object[] { paramc.field_dataId });
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fnH = this.hhW;
    localg.field_mediaId = paramc.field_dataId;
    localg.field_priority = com.tencent.mm.i.a.fmW;
    if (paramc.field_type == 0)
    {
      localg.dDS = true;
      localg.field_needStorage = true;
      localg.field_totalLen = paramc.field_totalLen;
      localg.field_aesKey = paramc.field_cdnKey;
      localg.field_fileId = paramc.field_cdnUrl;
      localg.field_isStreamMedia = paramc.chB();
      localg.field_fullpath = paramc.field_path;
      if (!com.tencent.mm.vfs.i.eK(localg.field_fullpath)) {
        ad.e("MicroMsg.EditorUI", "upload, but file not exist, filePath = %s", new Object[] { paramc.field_path });
      }
      if (paramc.chB()) {}
      for (localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
      {
        localg.field_force_aeskeycdn = true;
        localg.field_trysafecdn = false;
        com.tencent.mm.ao.f.awL().e(localg);
        AppMethodBeat.o(181602);
        return;
      }
    }
    localg.dDS = false;
    localg.field_totalLen = paramc.field_totalLen;
    localg.field_aesKey = paramc.field_cdnKey;
    localg.field_fileId = paramc.field_cdnUrl;
    localg.field_fullpath = (paramc.field_path + ".temp");
    localg.field_needStorage = true;
    localg.field_isStreamMedia = paramc.chB();
    if (paramc.chB()) {}
    for (localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
    {
      com.tencent.mm.ao.f.awL().b(localg, -1);
      AppMethodBeat.o(181602);
      return;
    }
  }
  
  private void a(final String paramString1, final l paraml, String paramString2, String paramString3)
  {
    AppMethodBeat.i(181562);
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.EditorUI", "video is null");
      AppMethodBeat.o(181562);
      return;
    }
    ad.v("MicroMsg.EditorUI", "compressNoteVideo path: %s", new Object[] { paramString1 });
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    paramString1 = new com.tencent.mm.plugin.editor.model.nativenote.manager.e(localArrayList, paramString2, paramString3, paraml, new e.a()
    {
      public final void a(String paramAnonymousString, l paramAnonymousl)
      {
        AppMethodBeat.i(181542);
        ad.i("MicroMsg.EditorUI", "compressNoteVideo onImportFinish");
        if ((!bt.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.i.eK(paramAnonymousString)) && (paramAnonymousl != null)) {
          paramAnonymousl.thumbPath = paramAnonymousString;
        }
        AppMethodBeat.o(181542);
      }
      
      public final void b(String paramAnonymousString, l paramAnonymousl)
      {
        AppMethodBeat.i(181543);
        ad.i("MicroMsg.EditorUI", "compressNoteVideo onExportFinish");
        if (EditorUI.c(EditorUI.this) != null)
        {
          EditorUI.c(EditorUI.this).dismiss();
          EditorUI.d(EditorUI.this);
        }
        if ((!bt.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.i.eK(paramAnonymousString)) && (paramAnonymousl != null) && (!paramAnonymousl.omR)) {
          if (new com.tencent.mm.vfs.e(paramAnonymousString).length() < ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(false))
          {
            paramAnonymousl.drZ = paramAnonymousString;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().a(paramAnonymousl, EditorUI.f(EditorUI.this).bSS(), false, true, false);
          }
        }
        for (;;)
        {
          EditorUI.this.e(true, 100L);
          EditorUI.this.N(1, 0L);
          AppMethodBeat.o(181543);
          return;
          Toast.makeText(EditorUI.this.getContext(), EditorUI.this.getString(2131759024), 1).show();
          continue;
          ad.i("MicroMsg.EditorUI", "file not exist or user canceled");
        }
      }
    });
    paramString2 = getContext();
    getString(2131755906);
    this.mVv = com.tencent.mm.ui.base.h.b(paramString2, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(181544);
        paramAnonymousDialogInterface = paramString1;
        paramAnonymousDialogInterface.isStop = true;
        paramAnonymousDialogInterface.interrupt();
        paraml.omR = true;
        EditorUI.this.e(true, 100L);
        EditorUI.this.N(1, 0L);
        AppMethodBeat.o(181544);
      }
    });
    com.tencent.mm.sdk.g.b.c(paramString1, "NoteEditor_importVideo");
    AppMethodBeat.o(181562);
  }
  
  private boolean bRR()
  {
    AppMethodBeat.i(181598);
    if ((this.okx != null) && (this.okx.oqS))
    {
      bRB();
      AppMethodBeat.o(181598);
      return false;
    }
    AppMethodBeat.o(181598);
    return true;
  }
  
  private void bRS()
  {
    AppMethodBeat.i(181607);
    if (this.okI.isEmpty())
    {
      ad.i("MicroMsg.EditorUI", "no need update ui by xml!!! xml is empty.");
      AppMethodBeat.o(181607);
      return;
    }
    Object localObject1 = getContext();
    getString(2131755906);
    this.mVv = com.tencent.mm.ui.base.h.b((Context)localObject1, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(181538);
        if (EditorUI.c(EditorUI.this) != null)
        {
          EditorUI.c(EditorUI.this).dismiss();
          EditorUI.d(EditorUI.this);
        }
        AppMethodBeat.o(181538);
      }
    });
    this.okO = com.tencent.mm.plugin.fav.a.b.XY(this.okI);
    if (this.okO != null)
    {
      this.okP.clear();
      this.okP.addAll(this.okO.field_favProto.mVb);
      int i = this.okP.size();
      if (i == 0)
      {
        ad.v("MicroMsg.EditorUI", "favItemInfo has no data!!!");
        AppMethodBeat.o(181607);
        return;
      }
      localObject1 = this.okO.field_favProto.mVb;
      this.okQ.clear();
      this.okR.clear();
      i -= 1;
      if (i >= 0)
      {
        afy localafy = (afy)((List)localObject1).get(i);
        Object localObject2;
        if (!bt.isNullOrNil(localafy.Dgq))
        {
          localObject2 = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.d(localafy));
          ad.i("MicroMsg.EditorUI", "dataFile: %s", new Object[] { ((com.tencent.mm.vfs.e)localObject2).getName() });
          if (((com.tencent.mm.vfs.e)localObject2).exists()) {
            break label392;
          }
          if ((bt.isNullOrNil(localafy.Dgb)) || (bt.isNullOrNil(localafy.DfZ))) {
            ad.e("MicroMsg.EditorUI", "data key or url null!!!");
          }
        }
        else
        {
          label259:
          if (!bt.isNullOrNil(localafy.DgB))
          {
            if (new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localafy)).exists()) {
              break label505;
            }
            if ((!bt.isNullOrNil(localafy.DfV)) && (!bt.isNullOrNil(localafy.gHu))) {
              break label427;
            }
            ad.w("MicroMsg.EditorUI", "thumb key or url null. favId: %d", new Object[] { Integer.valueOf(this.okO.field_id) });
          }
        }
        for (;;)
        {
          i -= 1;
          break;
          ad.d("MicroMsg.EditorUI", "local data not exist, gen cdnInfo.");
          localObject2 = a(localafy, 1);
          this.okQ.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localObject2);
          this.okR.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localafy);
          a((com.tencent.mm.plugin.fav.a.c)localObject2);
          break label259;
          label392:
          ad.d("MicroMsg.EditorUI", "file exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.okO.field_id), Integer.valueOf(i) });
          break label259;
          label427:
          ad.d("MicroMsg.EditorUI", "local thumb not exist, insert cdnInfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.okO.field_id), Integer.valueOf(i) });
          localObject2 = a(localafy, 1);
          this.okQ.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localObject2);
          this.okR.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localafy);
          a((com.tencent.mm.plugin.fav.a.c)localObject2);
          continue;
          label505:
          ad.d("MicroMsg.EditorUI", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.okO.field_id), Integer.valueOf(i) });
        }
      }
      bRT();
    }
    AppMethodBeat.o(181607);
  }
  
  private void bRT()
  {
    AppMethodBeat.i(181608);
    if (this.okQ.isEmpty())
    {
      ad.i("MicroMsg.EditorUI", "download finish, notifyUpdateUI.");
      Object localObject1 = bRU();
      if (localObject1 == null)
      {
        ad.e("MicroMsg.EditorUI", "weNoteWrapData is null!!!");
        AppMethodBeat.o(181608);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSr();
      localObject1 = ((com.tencent.mm.plugin.editor.model.a.g)localObject1).omP.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.plugin.editor.model.a.d)((Iterator)localObject1).next();
        switch (((com.tencent.mm.plugin.editor.model.a.d)localObject2).type)
        {
        case 0: 
        case 3: 
        case 5: 
        default: 
          break;
        case -1: 
          localObject2 = (com.tencent.mm.plugin.editor.model.a.i)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 1: 
          localObject2 = (com.tencent.mm.plugin.editor.model.a.j)localObject2;
          if (bt.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content)) {
            ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = "";
          }
          ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = a.SO(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content);
          if (((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.length() > 100) {
            com.tencent.mm.plugin.editor.model.nativenote.a.a.Tc(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content);
          }
          for (;;)
          {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
            break;
            if (b.SZ(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content)) {
              ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.substring(0, ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.length() - 5);
            }
          }
        case 2: 
          localObject2 = (com.tencent.mm.plugin.editor.model.a.h)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 4: 
          localObject2 = (m)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 6: 
          localObject2 = (l)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
        }
      }
      bRw();
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSw();
      if (this.mVv != null)
      {
        this.mVv.dismiss();
        this.mVv = null;
      }
    }
    AppMethodBeat.o(181608);
  }
  
  private com.tencent.mm.plugin.editor.model.a.g bRU()
  {
    AppMethodBeat.i(181609);
    com.tencent.mm.plugin.editor.model.a.g localg = new com.tencent.mm.plugin.editor.model.a.g();
    Iterator localIterator = this.okP.iterator();
    Object localObject1 = null;
    Object localObject4;
    Object localObject5;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject4 = (afy)localIterator.next();
      localObject5 = new com.tencent.mm.plugin.editor.model.a.d();
      ((com.tencent.mm.plugin.editor.model.a.d)localObject5).omI = ((afy)localObject4).Dhb;
      if (((afy)localObject4).dataType == 1) {
        ((com.tencent.mm.plugin.editor.model.a.d)localObject5).omI = "-1";
      }
      if (bt.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.d)localObject5).omI))
      {
        ad.e("MicroMsg.EditorUI", "noteItemData.localEditorId is null or nil.");
        AppMethodBeat.o(181609);
        return null;
      }
      if (((com.tencent.mm.plugin.editor.model.a.d)localObject5).omI.equals("WeNoteHtmlFile"))
      {
        localObject2 = com.tencent.mm.plugin.fav.a.b.d((afy)localObject4);
        if ((bt.isNullOrNil((String)localObject2)) || (!com.tencent.mm.vfs.i.eK((String)localObject2))) {
          break label1050;
        }
      }
    }
    label1050:
    for (;;)
    {
      for (;;)
      {
        try
        {
          for (;;)
          {
            localg.omO = com.tencent.mm.vfs.i.aMP((String)localObject2);
            localObject2 = b.SX(localg.omO);
            localObject1 = localObject2;
            try
            {
              ad.i("MicroMsg.EditorUI", "local html file exist, dataId: %s", new Object[] { ((afy)localObject4).dkb });
              ad.i("MicroMsg.EditorUI", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(bt.isNullOrNil(((afy)localObject4).DfZ)), Boolean.valueOf(bt.isNullOrNil(((afy)localObject4).Dgb)) });
            }
            catch (Exception localException1) {}
          }
        }
        catch (Exception localException2)
        {
          Object localObject3;
          Object localObject6;
          continue;
        }
        ad.printErrStackTrace("MicroMsg.EditorUI", localException1, "", new Object[0]);
        continue;
        ((com.tencent.mm.plugin.editor.model.a.d)localObject5).dkb = ((afy)localObject4).dkb;
        switch (((afy)localObject4).dataType)
        {
        default: 
          break;
        case 1: 
          if (bt.isNullOrNil(((afy)localObject4).desc)) {
            break;
          }
          if ((localg.omP.size() > 0) && (localg.omP.get(localg.omP.size() - 1) != null) && (((com.tencent.mm.plugin.editor.model.a.d)localg.omP.get(localg.omP.size() - 1)).omI.equals("-1")))
          {
            localObject3 = (com.tencent.mm.plugin.editor.model.a.e)localg.omP.get(localg.omP.size() - 1);
            ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content = ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content.concat(((afy)localObject4).desc);
            break;
          }
          localObject3 = new com.tencent.mm.plugin.editor.model.a.j();
          ((com.tencent.mm.plugin.editor.model.a.e)localObject3).omI = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).omI;
          ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content = ((afy)localObject4).desc;
          localg.omP.add(localObject3);
          break;
        case 2: 
          localObject3 = new com.tencent.mm.plugin.editor.model.a.h();
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).omI = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).omI;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).type = 2;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).dkb = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).dkb;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).omH = ((afy)localObject4);
          localObject5 = com.tencent.mm.plugin.fav.a.b.d((afy)localObject4);
          if (bt.isNullOrNil((String)localObject5)) {
            break;
          }
          localObject6 = (String)localObject5 + "_bigthumb";
          com.tencent.mm.vfs.i.eK(com.tencent.mm.plugin.fav.a.b.a((afy)localObject4));
          if (com.tencent.mm.vfs.i.eK((String)localObject5))
          {
            ((com.tencent.mm.plugin.editor.model.a.c)localObject3).omJ = true;
            b.eS((String)localObject5, (String)localObject6);
          }
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).drZ = ((String)localObject6);
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).omG = ((String)localObject5);
          localg.omP.add(localObject3);
          break;
        case 3: 
          localObject3 = new m();
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).omI = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).omI;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).type = 4;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).dkb = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).dkb;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).omH = ((afy)localObject4);
          localObject5 = com.tencent.mm.plugin.fav.a.b.d((afy)localObject4);
          if ((!bt.isNullOrNil((String)localObject5)) && (com.tencent.mm.vfs.i.eK((String)localObject5)))
          {
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).omJ = true;
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).jUR = com.tencent.mm.plugin.editor.model.a.oma;
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).length = ((int)com.tencent.mm.plugin.editor.model.b.mI(((afy)localObject4).duration));
          }
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).drZ = ((String)localObject5);
          localObject5 = getContext();
          int i = (int)com.tencent.mm.plugin.editor.model.b.mI(((afy)localObject4).duration);
          localObject6 = new gs();
          ((gs)localObject6).dkc.type = 21;
          ((gs)localObject6).dkc.context = ((Context)localObject5);
          ((gs)localObject6).dkc.dkk = i;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject6);
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).omM = ((gs)localObject6).dkd.path;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).dkk = ((afy)localObject4).duration;
          localObject5 = new gs();
          ((gs)localObject5).dkc.type = 17;
          ((gs)localObject5).dkc.dke = ((afy)localObject4);
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject5);
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).dkj = ((gs)localObject5).dkd.ret;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).omK = ((afy)localObject4).Dgo;
          localg.omP.add(localObject3);
          break;
        case 4: 
          localObject3 = new l();
          ((l)localObject3).omI = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).omI;
          ((l)localObject3).type = 6;
          ((l)localObject3).dkb = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).dkb;
          ((l)localObject3).omH = ((afy)localObject4);
          ((l)localObject3).duration = ((afy)localObject4).duration;
          ((l)localObject3).thumbPath = com.tencent.mm.plugin.fav.a.b.a((afy)localObject4);
          localObject4 = com.tencent.mm.plugin.fav.a.b.d((afy)localObject4);
          ((l)localObject3).drZ = ((String)localObject4);
          if ((!bt.isNullOrNil(((l)localObject3).thumbPath)) && (!com.tencent.mm.vfs.i.eK(((l)localObject3).thumbPath)) && (com.tencent.mm.vfs.i.eK((String)localObject4)))
          {
            localObject5 = com.tencent.mm.plugin.fav.ui.e.Yw((String)localObject4);
            if (localObject5 == null) {}
          }
          try
          {
            ad.i("MicroMsg.EditorUI", "add fav service: create thumbPath bitmap, saveBitmapToImage ");
            com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject5, 60, Bitmap.CompressFormat.JPEG, ((l)localObject3).thumbPath, true);
            if ((!bt.isNullOrNil((String)localObject4)) && (com.tencent.mm.vfs.i.eK((String)localObject4))) {
              ((l)localObject3).omJ = true;
            }
            localg.omP.add(localObject3);
          }
          catch (Exception localException3)
          {
            ad.printErrStackTrace("MicroMsg.EditorUI", localException3, "", new Object[0]);
          }
        }
      }
      if ((localObject1 != null) && (localObject1.size() > 0)) {
        com.tencent.mm.plugin.editor.model.b.a(localg.omP, localObject1);
      }
      AppMethodBeat.o(181609);
      return localg;
    }
  }
  
  private void bRV()
  {
    AppMethodBeat.i(181610);
    if (bt.isNullOrNil(b.Ta(com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSy())))
    {
      if (this.okr)
      {
        this.okr = false;
        enableOptionMenu(0, false);
        AppMethodBeat.o(181610);
      }
    }
    else if (!this.okr)
    {
      this.okr = true;
      enableOptionMenu(0, true);
    }
    AppMethodBeat.o(181610);
  }
  
  private void bRw()
  {
    AppMethodBeat.i(181568);
    try
    {
      this.okt.aql.notifyChanged();
      AppMethodBeat.o(181568);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.EditorUI", localException, "", new Object[0]);
      ad.i("MicroMsg.EditorUI", "onNotifyDataChanged error");
      AppMethodBeat.o(181568);
    }
  }
  
  /* Error */
  static boolean eQ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 984
    //   3: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 988	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_1
    //   12: iconst_0
    //   13: invokestatic 992	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   16: astore_1
    //   17: aload_1
    //   18: astore 6
    //   20: aload_0
    //   21: astore 5
    //   23: sipush 16384
    //   26: newarray byte
    //   28: astore 7
    //   30: aload_1
    //   31: astore 6
    //   33: aload_0
    //   34: astore 5
    //   36: aload_1
    //   37: ldc_w 374
    //   40: invokevirtual 996	java/lang/String:getBytes	()[B
    //   43: invokevirtual 1001	java/io/OutputStream:write	([B)V
    //   46: aload_1
    //   47: astore 6
    //   49: aload_0
    //   50: astore 5
    //   52: aload_0
    //   53: aload 7
    //   55: invokevirtual 1006	java/io/InputStream:read	([B)I
    //   58: istore_2
    //   59: iload_2
    //   60: iconst_m1
    //   61: if_icmpeq +68 -> 129
    //   64: aload_1
    //   65: astore 6
    //   67: aload_0
    //   68: astore 5
    //   70: aload_1
    //   71: aload 7
    //   73: iconst_0
    //   74: iload_2
    //   75: invokevirtual 1009	java/io/OutputStream:write	([BII)V
    //   78: goto -32 -> 46
    //   81: astore 7
    //   83: aload_1
    //   84: astore 6
    //   86: aload_0
    //   87: astore 5
    //   89: ldc 230
    //   91: aload 7
    //   93: ldc_w 259
    //   96: iconst_0
    //   97: anewarray 234	java/lang/Object
    //   100: invokestatic 352	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 1010	java/io/InputStream:close	()V
    //   111: aload_1
    //   112: ifnull +221 -> 333
    //   115: aload_1
    //   116: invokevirtual 1011	java/io/OutputStream:close	()V
    //   119: iconst_0
    //   120: istore_3
    //   121: ldc_w 984
    //   124: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iload_3
    //   128: ireturn
    //   129: iconst_1
    //   130: istore_3
    //   131: iload_3
    //   132: istore 4
    //   134: aload_0
    //   135: ifnull +10 -> 145
    //   138: aload_0
    //   139: invokevirtual 1010	java/io/InputStream:close	()V
    //   142: iload_3
    //   143: istore 4
    //   145: iload 4
    //   147: istore_3
    //   148: aload_1
    //   149: ifnull -28 -> 121
    //   152: aload_1
    //   153: invokevirtual 1011	java/io/OutputStream:close	()V
    //   156: iload 4
    //   158: istore_3
    //   159: goto -38 -> 121
    //   162: astore_0
    //   163: ldc 230
    //   165: aload_0
    //   166: ldc_w 259
    //   169: iconst_0
    //   170: anewarray 234	java/lang/Object
    //   173: invokestatic 352	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: iconst_0
    //   177: istore_3
    //   178: goto -57 -> 121
    //   181: astore_0
    //   182: ldc 230
    //   184: aload_0
    //   185: ldc_w 259
    //   188: iconst_0
    //   189: anewarray 234	java/lang/Object
    //   192: invokestatic 352	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: iconst_0
    //   196: istore 4
    //   198: goto -53 -> 145
    //   201: astore_0
    //   202: ldc 230
    //   204: aload_0
    //   205: ldc_w 259
    //   208: iconst_0
    //   209: anewarray 234	java/lang/Object
    //   212: invokestatic 352	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: goto -104 -> 111
    //   218: astore_0
    //   219: ldc 230
    //   221: aload_0
    //   222: ldc_w 259
    //   225: iconst_0
    //   226: anewarray 234	java/lang/Object
    //   229: invokestatic 352	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: iconst_0
    //   233: istore_3
    //   234: goto -113 -> 121
    //   237: astore_1
    //   238: aconst_null
    //   239: astore 6
    //   241: aconst_null
    //   242: astore_0
    //   243: aload_0
    //   244: ifnull +7 -> 251
    //   247: aload_0
    //   248: invokevirtual 1010	java/io/InputStream:close	()V
    //   251: aload 6
    //   253: ifnull +8 -> 261
    //   256: aload 6
    //   258: invokevirtual 1011	java/io/OutputStream:close	()V
    //   261: ldc_w 984
    //   264: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aload_1
    //   268: athrow
    //   269: astore_0
    //   270: ldc 230
    //   272: aload_0
    //   273: ldc_w 259
    //   276: iconst_0
    //   277: anewarray 234	java/lang/Object
    //   280: invokestatic 352	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: goto -32 -> 251
    //   286: astore_0
    //   287: ldc 230
    //   289: aload_0
    //   290: ldc_w 259
    //   293: iconst_0
    //   294: anewarray 234	java/lang/Object
    //   297: invokestatic 352	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: goto -39 -> 261
    //   303: astore_1
    //   304: aconst_null
    //   305: astore 6
    //   307: goto -64 -> 243
    //   310: astore_1
    //   311: aload 5
    //   313: astore_0
    //   314: goto -71 -> 243
    //   317: astore 7
    //   319: aconst_null
    //   320: astore_1
    //   321: aconst_null
    //   322: astore_0
    //   323: goto -240 -> 83
    //   326: astore 7
    //   328: aconst_null
    //   329: astore_1
    //   330: goto -247 -> 83
    //   333: iconst_0
    //   334: istore_3
    //   335: goto -214 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	paramString1	String
    //   0	338	1	paramString2	String
    //   58	17	2	i	int
    //   120	215	3	bool1	boolean
    //   132	65	4	bool2	boolean
    //   21	291	5	str1	String
    //   18	288	6	str2	String
    //   28	44	7	arrayOfByte	byte[]
    //   81	11	7	localException1	Exception
    //   317	1	7	localException2	Exception
    //   326	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   23	30	81	java/lang/Exception
    //   36	46	81	java/lang/Exception
    //   52	59	81	java/lang/Exception
    //   70	78	81	java/lang/Exception
    //   152	156	162	java/io/IOException
    //   138	142	181	java/io/IOException
    //   107	111	201	java/io/IOException
    //   115	119	218	java/io/IOException
    //   6	11	237	finally
    //   247	251	269	java/io/IOException
    //   256	261	286	java/io/IOException
    //   11	17	303	finally
    //   23	30	310	finally
    //   36	46	310	finally
    //   52	59	310	finally
    //   70	78	310	finally
    //   89	103	310	finally
    //   6	11	317	java/lang/Exception
    //   11	17	326	java/lang/Exception
  }
  
  public final void N(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(181579);
    if (!this.okH)
    {
      AppMethodBeat.o(181579);
      return;
    }
    this.iDu.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181525);
        ImageButton localImageButton = (ImageButton)EditorUI.j(EditorUI.this).findViewById(2131300627);
        View localView = EditorUI.j(EditorUI.this).findViewById(2131300628);
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(181525);
          return;
          EditorUI.k(EditorUI.this).setVisibility(8);
          if (!EditorUI.l(EditorUI.this).oqS)
          {
            EditorUI.j(EditorUI.this).setVisibility(8);
            AppMethodBeat.o(181525);
            return;
          }
          EditorUI.j(EditorUI.this).setVisibility(0);
          AppMethodBeat.o(181525);
          return;
          localImageButton.setImageResource(2131690086);
          localView.setVisibility(8);
          EditorUI.j(EditorUI.this).setVisibility(0);
          EditorUI.k(EditorUI.this).setVisibility(8);
          AppMethodBeat.o(181525);
          return;
          EditorUI.j(EditorUI.this).setVisibility(0);
          EditorUI.k(EditorUI.this).setVisibility(8);
          AppMethodBeat.o(181525);
          return;
          localImageButton.setImageResource(2131690085);
          localView.setVisibility(0);
          EditorUI.j(EditorUI.this).setVisibility(0);
          EditorUI.k(EditorUI.this).setVisibility(0);
        }
      }
    }, paramLong);
    AppMethodBeat.o(181579);
  }
  
  public final void a(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(181571);
    if (paramWXRTEditText != null) {
      if ((com.tencent.mm.plugin.editor.model.nativenote.manager.b.dataList == null) || (com.tencent.mm.plugin.editor.model.nativenote.manager.b.dataList.size() <= 0)) {
        break label38;
      }
    }
    label38:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(181571);
      return;
    }
    ArrayList localArrayList = com.tencent.mm.plugin.editor.model.nativenote.manager.b.bSm();
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().I(localArrayList))
    {
      bRz();
      AppMethodBeat.o(181571);
      return;
    }
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().a(localArrayList, paramWXRTEditText, true, true, false, false);
    i = paramWXRTEditText.getRecyclerItemPosition();
    int j = localArrayList.size();
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().eZ(i, j + i + 1);
    bRF();
    if (this.okC) {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTb();
    }
    AppMethodBeat.o(181571);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(181563);
    if (!this.okH)
    {
      AppMethodBeat.o(181563);
      return;
    }
    ad.d("MicroMsg.EditorUI", "onFocusChanged, poi: %s, focus: %s, editor: %s.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramWXRTEditText });
    CollectEditorLinearLayoutManager localCollectEditorLinearLayoutManager = (CollectEditorLinearLayoutManager)this.oks.getLayoutManager();
    if (localCollectEditorLinearLayoutManager != null)
    {
      if (this.okF) {
        localCollectEditorLinearLayoutManager.ole = false;
      }
    }
    else
    {
      if (!paramBoolean) {
        break label135;
      }
      if ((paramWXRTEditText == null) || (paramWXRTEditText.getEditTextType() != 1)) {
        break label124;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().Y(paramInt, true);
    }
    for (;;)
    {
      bRV();
      AppMethodBeat.o(181563);
      return;
      localCollectEditorLinearLayoutManager.ole = paramBoolean;
      break;
      label124:
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().Y(paramInt, false);
      continue;
      label135:
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().X(-1, false);
    }
  }
  
  final void a(afy paramafy, EditorUI.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(181601);
    Object localObject1;
    if (bt.isNullOrNil(paramafy.Dgb))
    {
      com.tencent.mm.ao.f.awM();
      localObject1 = com.tencent.mm.ao.a.awE();
      paramafy.aDq((String)localObject1);
      ad.i("MicroMsg.EditorUI", "local not exist cdn data key, generate %s", new Object[] { localObject1 });
    }
    if (EditorUI.b.okZ == paramb) {
      localObject1 = a(paramafy, 0);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        this.okQ.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, localObject1);
        this.okR.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, paramafy);
        a((com.tencent.mm.plugin.fav.a.c)localObject1);
      }
      AppMethodBeat.o(181601);
      return;
      localObject1 = localObject2;
      if (EditorUI.b.okY == paramb) {
        if (bt.isNullOrNil(com.tencent.mm.plugin.fav.a.b.a(paramafy)))
        {
          ad.e("MicroMsg.EditorUI", "insertCdnThumbInfo, type send, path must not be null!");
          localObject1 = localObject2;
        }
        else
        {
          paramb = com.tencent.mm.plugin.fav.a.b.XS(paramafy.dkb);
          localObject1 = new com.tencent.mm.plugin.fav.a.c();
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey = paramafy.DfV;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl = paramafy.gHu;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId = paramb;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_favLocalId = this.okO.field_localId;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen = ((int)paramafy.DgF);
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_type = 0;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 1;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path = com.tencent.mm.plugin.fav.a.b.a(paramafy);
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_modifyTime = bt.eGO();
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_attrFlag |= 1L;
        }
      }
    }
  }
  
  public final void bRA()
  {
    AppMethodBeat.i(181576);
    com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131755691), false, new EditorUI.5(this), new EditorUI.6(this));
    AppMethodBeat.o(181576);
  }
  
  public final void bRB()
  {
    AppMethodBeat.i(181580);
    com.tencent.mm.ui.base.h.c(getContext(), getString(2131762238), null, true);
    AppMethodBeat.o(181580);
  }
  
  public final void bRC()
  {
    AppMethodBeat.i(181581);
    if (this.okx != null) {
      this.okx.a(null);
    }
    AppMethodBeat.o(181581);
  }
  
  public final void bRD()
  {
    AppMethodBeat.i(181582);
    com.tencent.mm.ui.base.h.d(this, getString(2131758035), "", getString(2131758034), getString(2131758033), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(181526);
        com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTl();
        AppMethodBeat.o(181526);
      }
    }, null);
    AppMethodBeat.o(181582);
  }
  
  public final void bRE()
  {
    AppMethodBeat.i(181583);
    Toast.makeText(getContext(), getString(2131761825), 0).show();
    AppMethodBeat.o(181583);
  }
  
  public final void bRF()
  {
    AppMethodBeat.i(181584);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSs();
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().Aa(i);
    if (locala != null)
    {
      locala.omv = false;
      locala.omB = false;
      zV(i);
    }
    this.iDu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181528);
        WXRTEditText localWXRTEditText = EditorUI.f(EditorUI.this).bSQ();
        if (localWXRTEditText != null) {
          localWXRTEditText.clearFocus();
        }
        AppMethodBeat.o(181528);
      }
    });
    e(false, 0L);
    N(0, 0L);
    AppMethodBeat.o(181584);
  }
  
  public final int bRG()
  {
    AppMethodBeat.i(181585);
    if (this.okG)
    {
      int i = com.tencent.mm.compatible.util.i.ik(this);
      AppMethodBeat.o(181585);
      return i;
    }
    AppMethodBeat.o(181585);
    return 0;
  }
  
  public final int bRH()
  {
    AppMethodBeat.i(181586);
    int j = 0;
    int i = j;
    if (this.okw != null)
    {
      i = j;
      if (this.okw.getVisibility() == 0) {
        i = this.okD + 0;
      }
    }
    j = i;
    if (this.oky != null)
    {
      j = i;
      if (this.oky.getVisibility() == 0) {
        j = i + this.okD;
      }
    }
    AppMethodBeat.o(181586);
    return j;
  }
  
  public final boolean bRI()
  {
    AppMethodBeat.i(181587);
    if ((this.okB != null) && (this.okB.bSQ() != null))
    {
      AppMethodBeat.o(181587);
      return true;
    }
    AppMethodBeat.o(181587);
    return false;
  }
  
  public final RecyclerView bRJ()
  {
    return this.oks;
  }
  
  public final RecyclerView bRK()
  {
    return this.oks;
  }
  
  public final Context bRL()
  {
    AppMethodBeat.i(181588);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(181588);
    return localAppCompatActivity;
  }
  
  public final com.tencent.mm.plugin.editor.model.nativenote.b.a bRM()
  {
    return this;
  }
  
  public final void bRN()
  {
    AppMethodBeat.i(181589);
    com.tencent.mm.plugin.editor.model.a.j localj = new com.tencent.mm.plugin.editor.model.a.j();
    localj.content = "";
    localj.omv = true;
    localj.omB = false;
    localj.omx = 0;
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSr();
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().e(localj);
    bRw();
    e(true, 50L);
    N(1, 0L);
    AppMethodBeat.o(181589);
  }
  
  public final void bRO()
  {
    AppMethodBeat.i(181590);
    com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(getContext(), com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSz());
    AppMethodBeat.o(181590);
  }
  
  public final void bRP()
  {
    AppMethodBeat.i(181591);
    com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(getContext(), com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSz());
    bRN();
    AppMethodBeat.o(181591);
  }
  
  public final void bRQ()
  {
    AppMethodBeat.i(181592);
    getContext();
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.b.bSp();
    Object localObject;
    if (i == 2)
    {
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.bSo())
      {
        bRz();
        AppMethodBeat.o(181592);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSr();
      com.tencent.mm.plugin.editor.model.nativenote.manager.b.clearData();
      localObject = new com.tencent.mm.plugin.editor.model.a.j();
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).content = "";
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).omv = false;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).omB = false;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).omx = 0;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).omD = true;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().e((com.tencent.mm.plugin.editor.model.a.a)localObject);
      bRw();
      AppMethodBeat.o(181592);
      return;
    }
    if (i == 3)
    {
      localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.b.bSm();
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().I((ArrayList)localObject))
      {
        bRz();
        AppMethodBeat.o(181592);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSr();
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().a((ArrayList)localObject, null, false, false, false, false);
      bRF();
      AppMethodBeat.o(181592);
      return;
    }
    ad.d("MicroMsg.EditorUI", "no data.");
    AppMethodBeat.o(181592);
  }
  
  public final void bRW()
  {
    AppMethodBeat.i(181611);
    bRV();
    AppMethodBeat.o(181611);
  }
  
  public final void bRx()
  {
    AppMethodBeat.i(181570);
    if (!this.okx.oqS)
    {
      bRF();
      final AppCompatActivity localAppCompatActivity = getContext();
      this.iDu.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(181546);
          int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().size();
          int j = EditorUI.h(EditorUI.this).getChildCount();
          Object localObject;
          if (i == j)
          {
            float f1 = 0.0F;
            i = j - 1;
            if (i >= 0)
            {
              localObject = EditorUI.h(EditorUI.this).getChildAt(i);
              float f2 = t.ad((View)localObject);
              if (f1 > ((View)localObject).getBottom() + f2) {}
              for (;;)
              {
                i -= 1;
                break;
                f1 = ((View)localObject).getBottom() + f2;
              }
            }
            if ((f1 < com.tencent.mm.compatible.util.i.et(localAppCompatActivity)[1]) && (f1 > 0.0F))
            {
              localObject = (RelativeLayout.LayoutParams)EditorUI.b(EditorUI.this).getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject).height = ((int)f1);
              EditorUI.b(EditorUI.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
          }
          EditorUI.b(EditorUI.this).setVisibility(0);
          if (EditorUI.a(EditorUI.this) != null)
          {
            localObject = EditorUI.a(EditorUI.this);
            int[] arrayOfInt = new int[2];
            int[] tmp184_182 = arrayOfInt;
            tmp184_182[0] = 0;
            int[] tmp188_184 = tmp184_182;
            tmp188_184[1] = 0;
            tmp188_184;
            ((com.tencent.mm.plugin.editor.model.nativenote.manager.d)localObject).mParentView.getLocationOnScreen(arrayOfInt);
            ((com.tencent.mm.plugin.editor.model.nativenote.manager.d)localObject).onq.showAtLocation(((com.tencent.mm.plugin.editor.model.nativenote.manager.d)localObject).mParentView, 49, 0, arrayOfInt[1] + 50);
          }
          AppMethodBeat.o(181546);
        }
      }, 400L);
    }
    AppMethodBeat.o(181570);
  }
  
  public final void bRy()
  {
    AppMethodBeat.i(181574);
    this.iDu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181519);
        if (EditorUI.c(EditorUI.this) != null)
        {
          EditorUI.c(EditorUI.this).dismiss();
          EditorUI.d(EditorUI.this);
        }
        AppMethodBeat.o(181519);
      }
    });
    AppMethodBeat.o(181574);
  }
  
  public final void bRz()
  {
    AppMethodBeat.i(181575);
    bRF();
    if (this.okC) {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTb();
    }
    this.iDu.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181520);
        com.tencent.mm.ui.base.h.c(EditorUI.this.getContext(), EditorUI.this.getString(2131764408), null, true);
        AppMethodBeat.o(181520);
      }
    }, 100L);
    AppMethodBeat.o(181575);
  }
  
  public final void e(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181578);
    if (!this.okH)
    {
      AppMethodBeat.o(181578);
      return;
    }
    this.iDu.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181524);
        if ((paramBoolean) && (!EditorUI.i(EditorUI.this)))
        {
          EditorUI.this.showVKB();
          AppMethodBeat.o(181524);
          return;
        }
        if ((!paramBoolean) && (EditorUI.i(EditorUI.this))) {
          EditorUI.this.hideVKB();
        }
        AppMethodBeat.o(181524);
      }
    }, paramLong);
    AppMethodBeat.o(181578);
  }
  
  public final void eV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181566);
    try
    {
      this.okt.aq(paramInt1, paramInt2);
      AppMethodBeat.o(181566);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.EditorUI", localException, "", new Object[0]);
      ad.e("MicroMsg.EditorUI", "onNotifyItemRangeInserted error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(181566);
    }
  }
  
  public final void eW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181569);
    try
    {
      this.okt.ao(paramInt1, paramInt2);
      AppMethodBeat.o(181569);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.EditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(181569);
    }
  }
  
  public final void eX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181572);
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.okF = bool;
      AppMethodBeat.o(181572);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493748;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(181599);
    if (!bRR())
    {
      AppMethodBeat.o(181599);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(2131756769), "", getString(2131755939), getString(2131755831), true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(181535);
        EditorUI.this.finish();
        AppMethodBeat.o(181535);
      }
    }, null);
    AppMethodBeat.o(181599);
  }
  
  public void initView()
  {
    AppMethodBeat.i(181556);
    super.initView();
    setActionbarColor(getContext().getResources().getColor(2131101179));
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(181527);
        EditorUI.this.goBack();
        AppMethodBeat.o(181527);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755880), new MenuItem.OnMenuItemClickListener()
    {
      /* Error */
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        // Byte code:
        //   0: ldc 25
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 33
        //   7: ldc 35
        //   9: invokestatic 40	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   12: aload_0
        //   13: getfield 14	com/tencent/mm/plugin/editor/EditorUI$21:okS	Lcom/tencent/mm/plugin/editor/EditorUI;
        //   16: astore 6
        //   18: aload 6
        //   20: getfield 44	com/tencent/mm/plugin/editor/EditorUI:okx	Lcom/tencent/mm/plugin/editor/widget/a;
        //   23: aload 6
        //   25: invokevirtual 50	com/tencent/mm/plugin/editor/widget/a:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/b/a;)V
        //   28: invokestatic 56	com/tencent/mm/plugin/editor/model/nativenote/manager/c:bSq	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/c;
        //   31: invokevirtual 60	com/tencent/mm/plugin/editor/model/nativenote/manager/c:bSy	()Ljava/lang/String;
        //   34: astore_1
        //   35: aload_1
        //   36: invokestatic 64	com/tencent/mm/plugin/editor/EditorUI:SQ	(Ljava/lang/String;)Z
        //   39: ifne +64 -> 103
        //   42: aload 6
        //   44: invokevirtual 68	com/tencent/mm/plugin/editor/EditorUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
        //   47: astore 5
        //   49: aload 6
        //   51: ldc 69
        //   53: invokevirtual 73	com/tencent/mm/plugin/editor/EditorUI:getString	(I)Ljava/lang/String;
        //   56: pop
        //   57: aload 6
        //   59: aload 5
        //   61: aload 6
        //   63: ldc 74
        //   65: invokevirtual 73	com/tencent/mm/plugin/editor/EditorUI:getString	(I)Ljava/lang/String;
        //   68: iconst_1
        //   69: new 76	com/tencent/mm/plugin/editor/EditorUI$18
        //   72: dup
        //   73: aload 6
        //   75: invokespecial 78	com/tencent/mm/plugin/editor/EditorUI$18:<init>	(Lcom/tencent/mm/plugin/editor/EditorUI;)V
        //   78: invokestatic 84	com/tencent/mm/ui/base/h:b	(Landroid/content/Context;Ljava/lang/String;ZLandroid/content/DialogInterface$OnCancelListener;)Lcom/tencent/mm/ui/base/p;
        //   81: putfield 88	com/tencent/mm/plugin/editor/EditorUI:mVv	Landroid/app/ProgressDialog;
        //   84: invokestatic 56	com/tencent/mm/plugin/editor/model/nativenote/manager/c:bSq	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/c;
        //   87: aload_1
        //   88: invokevirtual 92	com/tencent/mm/plugin/editor/model/nativenote/manager/c:Te	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ago;
        //   91: astore_1
        //   92: aload_1
        //   93: ifnonnull +17 -> 110
        //   96: ldc 33
        //   98: ldc 94
        //   100: invokestatic 97	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   103: ldc 25
        //   105: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   108: iconst_1
        //   109: ireturn
        //   110: aload 6
        //   112: getfield 104	com/tencent/mm/plugin/editor/EditorUI:okP	Ljava/util/LinkedList;
        //   115: invokevirtual 109	java/util/LinkedList:clear	()V
        //   118: aload 6
        //   120: getfield 104	com/tencent/mm/plugin/editor/EditorUI:okP	Ljava/util/LinkedList;
        //   123: aload_1
        //   124: getfield 114	com/tencent/mm/protocal/protobuf/ago:mVb	Ljava/util/LinkedList;
        //   127: invokevirtual 118	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   130: pop
        //   131: aload 6
        //   133: aload 6
        //   135: getfield 104	com/tencent/mm/plugin/editor/EditorUI:okP	Ljava/util/LinkedList;
        //   138: invokestatic 124	java/lang/System:currentTimeMillis	()J
        //   141: invokestatic 129	com/tencent/mm/plugin/fav/ui/k:a	(Ljava/util/LinkedList;J)Lcom/tencent/mm/plugin/fav/a/g;
        //   144: putfield 133	com/tencent/mm/plugin/editor/EditorUI:okO	Lcom/tencent/mm/plugin/fav/a/g;
        //   147: iconst_0
        //   148: istore_2
        //   149: iload_2
        //   150: aload 6
        //   152: getfield 104	com/tencent/mm/plugin/editor/EditorUI:okP	Ljava/util/LinkedList;
        //   155: invokevirtual 137	java/util/LinkedList:size	()I
        //   158: if_icmpge -55 -> 103
        //   161: aload 6
        //   163: getfield 104	com/tencent/mm/plugin/editor/EditorUI:okP	Ljava/util/LinkedList;
        //   166: iload_2
        //   167: invokevirtual 141	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   170: checkcast 143	com/tencent/mm/protocal/protobuf/afy
        //   173: astore 7
        //   175: aload 7
        //   177: getfield 147	com/tencent/mm/protocal/protobuf/afy:dkb	Ljava/lang/String;
        //   180: invokestatic 152	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
        //   183: ifeq +25 -> 208
        //   186: aload 7
        //   188: aload 7
        //   190: invokevirtual 155	java/lang/Object:toString	()Ljava/lang/String;
        //   193: aload 6
        //   195: getfield 133	com/tencent/mm/plugin/editor/EditorUI:okO	Lcom/tencent/mm/plugin/fav/a/g;
        //   198: getfield 161	com/tencent/mm/plugin/fav/a/g:field_type	I
        //   201: invokestatic 167	com/tencent/mm/plugin/fav/a/b:cT	(Ljava/lang/String;I)Ljava/lang/String;
        //   204: invokevirtual 171	com/tencent/mm/protocal/protobuf/afy:aDy	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/afy;
        //   207: pop
        //   208: aload 7
        //   210: getfield 174	com/tencent/mm/protocal/protobuf/afy:Dgx	Ljava/lang/String;
        //   213: astore_1
        //   214: aload_1
        //   215: invokestatic 179	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
        //   218: ifeq +236 -> 454
        //   221: aload_1
        //   222: invokestatic 185	com/tencent/mm/b/g:getMD5	(Ljava/lang/String;)Ljava/lang/String;
        //   225: astore 5
        //   227: aload_1
        //   228: invokestatic 188	com/tencent/mm/b/g:dE	(Ljava/lang/String;)Ljava/lang/String;
        //   231: astore 8
        //   233: aload 7
        //   235: aload 5
        //   237: invokevirtual 191	com/tencent/mm/protocal/protobuf/afy:aDw	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/afy;
        //   240: pop
        //   241: aload 7
        //   243: aload 8
        //   245: invokevirtual 194	com/tencent/mm/protocal/protobuf/afy:aDx	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/afy;
        //   248: pop
        //   249: aload 7
        //   251: new 196	com/tencent/mm/vfs/e
        //   254: dup
        //   255: aload_1
        //   256: invokespecial 199	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
        //   259: invokevirtual 202	com/tencent/mm/vfs/e:length	()J
        //   262: invokevirtual 206	com/tencent/mm/protocal/protobuf/afy:vp	(J)Lcom/tencent/mm/protocal/protobuf/afy;
        //   265: pop
        //   266: aload 7
        //   268: invokestatic 210	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/afy;)Ljava/lang/String;
        //   271: astore 5
        //   273: aload_1
        //   274: aload 5
        //   276: invokevirtual 216	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   279: ifne +10 -> 289
        //   282: aload_1
        //   283: aload 5
        //   285: invokestatic 220	com/tencent/mm/vfs/i:lC	(Ljava/lang/String;Ljava/lang/String;)J
        //   288: pop2
        //   289: aload 6
        //   291: aload 7
        //   293: getstatic 226	com/tencent/mm/plugin/editor/EditorUI$b:okZ	Lcom/tencent/mm/plugin/editor/EditorUI$b;
        //   296: invokevirtual 229	com/tencent/mm/plugin/editor/EditorUI:a	(Lcom/tencent/mm/protocal/protobuf/afy;Lcom/tencent/mm/plugin/editor/EditorUI$b;)V
        //   299: aload 7
        //   301: getfield 232	com/tencent/mm/protocal/protobuf/afy:Dgz	Ljava/lang/String;
        //   304: astore 8
        //   306: aload 8
        //   308: invokestatic 179	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
        //   311: ifeq +224 -> 535
        //   314: aconst_null
        //   315: astore_1
        //   316: aload 8
        //   318: invokestatic 236	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
        //   321: astore 5
        //   323: aload 5
        //   325: astore_1
        //   326: aload 5
        //   328: sipush 4096
        //   331: invokestatic 239	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
        //   334: invokestatic 242	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
        //   337: astore 9
        //   339: aload 5
        //   341: astore_1
        //   342: aload 8
        //   344: invokestatic 246	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
        //   347: lstore_3
        //   348: aload 5
        //   350: astore_1
        //   351: aload 5
        //   353: invokestatic 249	com/tencent/mm/b/g:o	(Ljava/io/InputStream;)Ljava/lang/String;
        //   356: astore 10
        //   358: aload 5
        //   360: astore_1
        //   361: aload 7
        //   363: aload 9
        //   365: invokevirtual 252	com/tencent/mm/protocal/protobuf/afy:aDB	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/afy;
        //   368: pop
        //   369: aload 5
        //   371: astore_1
        //   372: aload 7
        //   374: aload 10
        //   376: invokevirtual 255	com/tencent/mm/protocal/protobuf/afy:aDC	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/afy;
        //   379: pop
        //   380: aload 5
        //   382: astore_1
        //   383: aload 7
        //   385: lload_3
        //   386: invokevirtual 258	com/tencent/mm/protocal/protobuf/afy:vq	(J)Lcom/tencent/mm/protocal/protobuf/afy;
        //   389: pop
        //   390: aload 5
        //   392: astore_1
        //   393: aload 7
        //   395: invokestatic 260	com/tencent/mm/plugin/fav/a/b:a	(Lcom/tencent/mm/protocal/protobuf/afy;)Ljava/lang/String;
        //   398: astore 9
        //   400: aload 5
        //   402: astore_1
        //   403: aload 8
        //   405: aload 9
        //   407: invokevirtual 216	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   410: ifne +14 -> 424
        //   413: aload 5
        //   415: astore_1
        //   416: aload 8
        //   418: aload 9
        //   420: invokestatic 220	com/tencent/mm/vfs/i:lC	(Ljava/lang/String;Ljava/lang/String;)J
        //   423: pop2
        //   424: aload 5
        //   426: astore_1
        //   427: aload 6
        //   429: aload 7
        //   431: getstatic 263	com/tencent/mm/plugin/editor/EditorUI$b:okY	Lcom/tencent/mm/plugin/editor/EditorUI$b;
        //   434: invokevirtual 229	com/tencent/mm/plugin/editor/EditorUI:a	(Lcom/tencent/mm/protocal/protobuf/afy;Lcom/tencent/mm/plugin/editor/EditorUI$b;)V
        //   437: aload 5
        //   439: ifnull +8 -> 447
        //   442: aload 5
        //   444: invokevirtual 268	java/io/InputStream:close	()V
        //   447: iload_2
        //   448: iconst_1
        //   449: iadd
        //   450: istore_2
        //   451: goto -302 -> 149
        //   454: ldc 33
        //   456: ldc_w 270
        //   459: iconst_2
        //   460: anewarray 4	java/lang/Object
        //   463: dup
        //   464: iconst_0
        //   465: aload 7
        //   467: getfield 273	com/tencent/mm/protocal/protobuf/afy:dataType	I
        //   470: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   473: aastore
        //   474: dup
        //   475: iconst_1
        //   476: aload_1
        //   477: aastore
        //   478: invokestatic 282	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   481: goto -182 -> 299
        //   484: astore_1
        //   485: aconst_null
        //   486: astore_1
        //   487: ldc 33
        //   489: ldc_w 284
        //   492: invokestatic 97	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   495: aload_1
        //   496: ifnull -49 -> 447
        //   499: aload_1
        //   500: invokevirtual 268	java/io/InputStream:close	()V
        //   503: goto -56 -> 447
        //   506: astore_1
        //   507: goto -60 -> 447
        //   510: astore 5
        //   512: aload_1
        //   513: astore 6
        //   515: aload 5
        //   517: astore_1
        //   518: aload 6
        //   520: ifnull +8 -> 528
        //   523: aload 6
        //   525: invokevirtual 268	java/io/InputStream:close	()V
        //   528: ldc 25
        //   530: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   533: aload_1
        //   534: athrow
        //   535: ldc 33
        //   537: ldc_w 286
        //   540: iconst_1
        //   541: anewarray 4	java/lang/Object
        //   544: dup
        //   545: iconst_0
        //   546: aload 8
        //   548: aastore
        //   549: invokestatic 282	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   552: goto -105 -> 447
        //   555: astore_1
        //   556: goto -109 -> 447
        //   559: astore 5
        //   561: goto -33 -> 528
        //   564: astore 5
        //   566: aload_1
        //   567: astore 6
        //   569: aload 5
        //   571: astore_1
        //   572: goto -54 -> 518
        //   575: astore_1
        //   576: aload 5
        //   578: astore_1
        //   579: goto -92 -> 487
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	582	0	this	21
        //   0	582	1	paramAnonymousMenuItem	MenuItem
        //   148	303	2	i	int
        //   347	39	3	l	long
        //   47	396	5	localObject1	Object
        //   510	6	5	localObject2	Object
        //   559	1	5	localException	Exception
        //   564	13	5	localObject3	Object
        //   16	552	6	localObject4	Object
        //   173	293	7	localafy	afy
        //   231	316	8	str1	String
        //   337	82	9	str2	String
        //   356	19	10	str3	String
        // Exception table:
        //   from	to	target	type
        //   316	323	484	java/io/FileNotFoundException
        //   499	503	506	java/lang/Exception
        //   316	323	510	finally
        //   326	339	510	finally
        //   342	348	510	finally
        //   351	358	510	finally
        //   361	369	510	finally
        //   372	380	510	finally
        //   383	390	510	finally
        //   393	400	510	finally
        //   403	413	510	finally
        //   416	424	510	finally
        //   427	437	510	finally
        //   442	447	555	java/lang/Exception
        //   523	528	559	java/lang/Exception
        //   487	495	564	finally
        //   326	339	575	java/io/FileNotFoundException
        //   342	348	575	java/io/FileNotFoundException
        //   351	358	575	java/io/FileNotFoundException
        //   361	369	575	java/io/FileNotFoundException
        //   372	380	575	java/io/FileNotFoundException
        //   383	390	575	java/io/FileNotFoundException
        //   393	400	575	java/io/FileNotFoundException
        //   403	413	575	java/io/FileNotFoundException
        //   416	424	575	java/io/FileNotFoundException
        //   427	437	575	java/io/FileNotFoundException
      }
    }, null, r.b.FOB);
    enableOptionMenu(0, this.okr);
    getContentView().getRootView().setBackgroundColor(getContext().getResources().getColor(2131101179));
    this.okB = new com.tencent.mm.plugin.editor.model.nativenote.manager.j(this);
    this.okB.ooL = this.okH;
    this.oks = ((RecyclerView)findViewById(2131298448));
    this.okw = ((LinearLayout)findViewById(2131298447));
    this.okx = new com.tencent.mm.plugin.editor.widget.a();
    Object localObject = this.okx;
    LinearLayout localLinearLayout = this.okw;
    ((com.tencent.mm.plugin.editor.widget.a)localObject).mXu = localLinearLayout;
    com.tencent.mm.plugin.editor.model.nativenote.manager.j.bSR().ooK = ((com.tencent.mm.plugin.editor.model.nativenote.b.b)localObject);
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqI = ((WeImageButton)localLinearLayout.findViewById(2131300627));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqJ = ((WeImageButton)localLinearLayout.findViewById(2131300631));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqK = ((WeImageButton)localLinearLayout.findViewById(2131300630));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqL = ((WeImageButton)localLinearLayout.findViewById(2131300632));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqM = ((LinearLayout)localLinearLayout.findViewById(2131300633));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqN = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).oqM.findViewById(2131307015));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqO = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).oqM.findViewById(2131307013));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqP = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).oqM.findViewById(2131307014));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqQ = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).oqM.findViewById(2131302459));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqR = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).oqM.findViewById(2131307008));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqI.setOnClickListener(new a.1((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqJ.setOnClickListener(new a.5((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqY = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqd, true);
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqK.setOnClickListener(new a.6((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqL.setOnClickListener(new a.7((com.tencent.mm.plugin.editor.widget.a)localObject, this, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqN.setOnClickListener(new a.8((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqO.setOnClickListener(new a.9((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqP.setOnClickListener(new a.10((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqQ.setOnClickListener(new a.11((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oqR.setOnClickListener(new a.12((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    this.oky = ((LinearLayout)this.okw.findViewById(2131300633));
    this.oky.setVisibility(8);
    this.okz = ((RelativeLayout)findViewById(2131306975));
    this.okz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181517);
        if (EditorUI.a(EditorUI.this) != null) {
          EditorUI.a(EditorUI.this).onq.dismiss();
        }
        EditorUI.b(EditorUI.this).setVisibility(8);
        AppMethodBeat.o(181517);
      }
    });
    this.okA = new com.tencent.mm.plugin.editor.model.nativenote.manager.d(this, this.okz);
    this.okA.onr = this;
    this.oku = new CollectEditorLinearLayoutManager();
    this.oku.old = com.tencent.mm.compatible.util.i.et(this)[1];
    this.oks.setLayoutManager(this.oku);
    this.oks.setHasFixedSize(true);
    this.okv = new a();
    this.oks.a(this.okv);
    this.okt = new com.tencent.mm.plugin.editor.adapter.b(this.okB);
    this.oks.setAdapter(this.okt);
    if (this.okH)
    {
      localObject = new com.tencent.mm.plugin.editor.model.a.j();
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).content = "";
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).omv = true;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).omB = false;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().e((com.tencent.mm.plugin.editor.model.a.a)localObject);
      e(true, 300L);
      N(1, 0L);
      this.oks.setOnTouchListener(this.okN);
    }
    for (;;)
    {
      this.oks.getItemAnimator().aqp = 0L;
      this.oks.getItemAnimator().aqs = 0L;
      this.oks.getItemAnimator().aqr = 0L;
      this.oks.getItemAnimator().aqq = 120L;
      ((as)this.oks.getItemAnimator()).atX = false;
      AppMethodBeat.o(181556);
      return;
      this.okw.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(181559);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.EditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.okK = paramInt1;
    if (paramInt2 != -1)
    {
      this.okJ = false;
      AppMethodBeat.o(181559);
      return;
    }
    this.okJ = true;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(181559);
      return;
      ad.i("MicroMsg.EditorUI", "onActivityResult back from gallery");
      Object localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        G((ArrayList)localObject);
      }
      for (;;)
      {
        localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
        String str = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        paramIntent = (Intent)localObject;
        if (!bt.isNullOrNil(str))
        {
          paramIntent = (Intent)localObject;
          if (localObject == null)
          {
            paramIntent = new ArrayList();
            paramIntent.add(str);
          }
        }
        if ((paramIntent == null) || (paramIntent.size() <= 0)) {
          break label253;
        }
        if (!com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().eY(0, paramIntent.size())) {
          break;
        }
        bRz();
        AppMethodBeat.o(181559);
        return;
        ad.i("MicroMsg.EditorUI", "no pic selected");
      }
      SP((String)paramIntent.get(0));
      AppMethodBeat.o(181559);
      return;
      label253:
      ad.i("MicroMsg.EditorUI", "no video selected");
      AppMethodBeat.o(181559);
      return;
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      if (paramIntent == null)
      {
        ad.e("MicroMsg.EditorUI", "sight capture result is null!");
        AppMethodBeat.o(181559);
        return;
      }
      localObject = paramIntent.videoPath;
      if (!bt.isNullOrNil((String)localObject)) {
        SP((String)localObject);
      }
      if ((paramIntent.vhz.booleanValue()) && (!bt.isNullOrNil(paramIntent.thumbPath)))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramIntent.thumbPath);
        G((ArrayList)localObject);
        AppMethodBeat.o(181559);
        return;
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          ad.e("MicroMsg.EditorUI", "sight capture result is null!");
          AppMethodBeat.o(181559);
          return;
        }
        localObject = paramIntent.tAR;
        if (!bt.isNullOrNil((String)localObject)) {
          SP((String)localObject);
        }
        if ((paramIntent.tAP) && (!bt.isNullOrNil(paramIntent.tAX)))
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramIntent.tAX);
          G((ArrayList)localObject);
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(181597);
    goBack();
    AppMethodBeat.o(181597);
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(181596);
    super.onCancel();
    if (this.okC)
    {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().jx(false);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().jw(false);
    }
    AppMethodBeat.o(181596);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(181555);
    customfixStatusbar(true);
    Object localObject1 = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).hIH = new ArrayList();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).onk = this;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).onl = new afy();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).onm = 0;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).onn = 0;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).ono = 0;
    super.onCreate(paramBundle);
    this.okH = getIntent().getBooleanExtra("KEY_EDITABLE", false);
    this.okI = getIntent().getStringExtra("KEY_CONTENT_XML");
    if (bt.isNullOrNil(this.okI))
    {
      this.okI = "";
      this.okr = false;
    }
    ad.i("MicroMsg.EditorUI", "mCollectEditable: %s, mCollectContentXml: %s", new Object[] { Boolean.valueOf(this.okH), this.okI });
    this.iDu = new ap();
    initView();
    this.okD = com.tencent.mm.cd.a.fromDPToPix(this, 48);
    if (this.okC)
    {
      ad.i("MicroMsg.EditorUI", "use multiselect");
      int i = getResources().getColor(2131100265);
      paramBundle = com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW();
      boolean bool = this.okH;
      ad.i("EditorSelectManager", "onInit start");
      paramBundle.opk = bool;
      paramBundle.opn = 14;
      paramBundle.opo = 32;
      paramBundle.opp = (com.tencent.mm.cd.a.fromDPToPix(this, 21) - paramBundle.opo);
      paramBundle.opq = (com.tencent.mm.cd.a.fromDPToPix(this, 40) + paramBundle.opo * 2);
      paramBundle.opr = (com.tencent.mm.cd.a.fromDPToPix(this, 240) + paramBundle.opo * 2);
      paramBundle.opl = com.tencent.mm.cd.a.fromDPToPix(this, 22);
      paramBundle.opm = com.tencent.mm.cd.a.fromDPToPix(this, 1);
      paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
      paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
      paramBundle.opv = new int[] { -1, -1 };
      paramBundle.opw = new int[] { -1, -1 };
      paramBundle.opx = new int[] { -1, -1 };
      paramBundle.opy = new int[] { -1, -1 };
      localObject1 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 2, paramBundle.opl, paramBundle.opm, i, paramBundle);
      paramBundle.opz = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.opz.setClippingEnabled(false);
      paramBundle.opz.setAnimationStyle(2131821705);
      paramBundle.opt = ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
      paramBundle.opu = com.tencent.mm.cd.a.fromDPToPix(this, 6);
      Object localObject2 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 3, paramBundle.opl, paramBundle.opm, i, paramBundle);
      paramBundle.opA = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.opA.setClippingEnabled(false);
      paramBundle.opA.setAnimationStyle(2131821704);
      localObject2 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 4, paramBundle.opl, paramBundle.opm, i, paramBundle);
      paramBundle.opB = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.opB.setClippingEnabled(false);
      paramBundle.opB.setAnimationStyle(2131821706);
      localObject2 = LayoutInflater.from(this).inflate(2131493746, null);
      ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramBundle.opC = new PopupWindow((View)localObject2, -2, -2, false);
      paramBundle.opC.setBackgroundDrawable(getResources().getDrawable(2131234275));
      paramBundle.opC.setClippingEnabled(false);
      paramBundle.opC.setAnimationStyle(2131821708);
      paramBundle.opI = ((TextView)((View)localObject2).findViewById(2131302913));
      paramBundle.opJ = ((TextView)((View)localObject2).findViewById(2131302942));
      paramBundle.opK = ((TextView)((View)localObject2).findViewById(2131302939));
      paramBundle.opL = ((TextView)((View)localObject2).findViewById(2131302938));
      paramBundle.opM = ((TextView)((View)localObject2).findViewById(2131302923));
      paramBundle.opN = ((TextView)((View)localObject2).findViewById(2131302922));
      paramBundle.opO = ((TextView)((View)localObject2).findViewById(2131302921));
      paramBundle.opP = ((TextView)((View)localObject2).findViewById(2131302934));
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.opI, paramBundle.opn);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.opJ, paramBundle.opn);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.opK, paramBundle.opn);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.opL, paramBundle.opn);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.opM, paramBundle.opn);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.opN, paramBundle.opn);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.opO, paramBundle.opn);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.opP, paramBundle.opn);
      paramBundle.opI.setOnClickListener(new e.10(paramBundle));
      paramBundle.opJ.setOnClickListener(new e.11(paramBundle));
      paramBundle.opK.setOnClickListener(new e.12(paramBundle));
      paramBundle.opL.setOnClickListener(new e.13(paramBundle));
      paramBundle.opM.setOnClickListener(new e.2(paramBundle));
      paramBundle.opN.setOnClickListener(new e.3(paramBundle));
      paramBundle.opO.setOnClickListener(new e.4(paramBundle));
      paramBundle.opP.setOnClickListener(new e.5(paramBundle));
      paramBundle.ops = ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewPadding();
      paramBundle.opD = this;
      paramBundle.opE = new com.tencent.mm.plugin.editor.model.nativenote.c.d();
      paramBundle.opF = new com.tencent.mm.plugin.editor.model.nativenote.c.b();
      paramBundle.mHandler = new ap();
      com.tencent.mm.plugin.editor.model.nativenote.c.e.mHasInit = true;
      ad.i("EditorSelectManager", "onInit end");
      this.okE = new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(181534);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if (paramAnonymousInt2 > 30)
          {
            com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTf();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTd();
          }
          localObject = com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bSY();
          if (((EditorUI.i(EditorUI.this)) || ((EditorUI.j(EditorUI.this) != null) && (EditorUI.j(EditorUI.this).getVisibility() == 0))) && (((com.tencent.mm.plugin.editor.model.nativenote.c.d)localObject).bSV() == 2) && (com.tencent.mm.plugin.editor.model.nativenote.c.f.e(paramAnonymousRecyclerView, ((com.tencent.mm.plugin.editor.model.nativenote.c.d)localObject).cWU) == null)) {
            EditorUI.this.bRF();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(181534);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(181533);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(181533);
            return;
            com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTf();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTd();
            continue;
            boolean bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTe();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().jx(bool);
            bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTc();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().jw(bool);
            com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().f(false, 50L);
          }
        }
      };
      this.oks.a(this.okE);
    }
    bRS();
    AppMethodBeat.o(181555);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(181594);
    super.onDestroy();
    if (this.okC)
    {
      if (this.oks != null) {
        this.oks.b(this.okE);
      }
      localObject = com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW();
      ad.i("EditorSelectManager", "onDestroy");
      com.tencent.mm.plugin.editor.model.nativenote.c.e.mHasInit = false;
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).opG != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).opG.stopTimer();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).opH != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).opH.stopTimer();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).opz != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).opz.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).opA != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).opA.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).opB != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).opB.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).opC != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).opC.dismiss();
      }
      com.tencent.mm.plugin.editor.model.nativenote.c.e.opj = null;
    }
    if (this.okB != null)
    {
      localObject = this.okB;
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.j.ooG == localObject) {
        com.tencent.mm.plugin.editor.model.nativenote.manager.j.ooG = null;
      }
    }
    Object localObject = com.tencent.mm.plugin.editor.widget.voiceview.a.bTH();
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).stopPlay();
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).orl = null;
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).ork = null;
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).callbacks.clear();
    com.tencent.mm.plugin.editor.widget.voiceview.a.orf = null;
    if (com.tencent.mm.plugin.editor.model.c.bSh() != null)
    {
      com.tencent.mm.plugin.editor.model.c.bSh();
      com.tencent.mm.plugin.editor.model.c.destroy();
    }
    localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).onk = null;
    if (((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).hIH != null)
    {
      localObject = ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).hIH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)((Iterator)localObject).next();
        locala.omA = null;
        locala.omy = null;
        locala.omz = null;
      }
    }
    AppMethodBeat.o(181594);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(181595);
    super.onDrag();
    if (this.okC)
    {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTf();
      com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTd();
    }
    if (this.okG)
    {
      ad.i("MicroMsg.EditorUI", "onSwipeBack close vkb");
      hideVKB();
    }
    AppMethodBeat.o(181595);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(181593);
    super.onKeyboardStateChanged();
    if (keyboardState() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.okG = bool;
      if (this.okG) {
        N(1, 0L);
      }
      if (this.okC) {
        this.iDu.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181532);
            boolean bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTe();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().jx(bool);
            bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().bTc();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.bSW().jw(bool);
            AppMethodBeat.o(181532);
          }
        }, 200L);
      }
      AppMethodBeat.o(181593);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(181558);
    super.onPause();
    if (this.okx != null) {
      this.okx.a(this);
    }
    if (com.tencent.mm.plugin.editor.widget.voiceview.a.bTH().bTK()) {
      com.tencent.mm.plugin.editor.widget.voiceview.a.bTH().stopPlay();
    }
    this.okL = this.okG;
    e(false, 0L);
    AppMethodBeat.o(181558);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(181577);
    if (paramArrayOfInt.length <= 0)
    {
      ad.i("MicroMsg.EditorUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(181577);
      return;
    }
    ad.i("MicroMsg.EditorUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(181577);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        bRA();
        AppMethodBeat.o(181577);
        return;
        if ((com.tencent.mm.ax.b.yL((String)com.tencent.mm.kernel.g.afB().afk().get(274436, null))) && (paramArrayOfInt[0] != 0)) {
          com.tencent.mm.ui.base.h.a(getContext(), getString(2131761869), getString(2131761885), getString(2131760598), getString(2131755691), false, new EditorUI.7(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(181557);
    super.onResume();
    if (this.okH) {
      switch (this.okK)
      {
      }
    }
    for (;;)
    {
      this.okK = -1;
      this.okJ = false;
      if (isSupportNavigationSwipeBack()) {
        getSwipeBackLayout().setEnableGesture(false);
      }
      AppMethodBeat.o(181557);
      return;
      if (this.okL)
      {
        e(true, 100L);
        N(1, 0L);
        continue;
        if (!this.okJ)
        {
          e(true, 100L);
          N(1, 0L);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void zV(final int paramInt)
  {
    AppMethodBeat.i(181564);
    this.iDu.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181545);
        ad.i("MicroMsg.EditorUI", "huahuastart: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        EditorUI.g(EditorUI.this).ck(paramInt);
        ad.i("MicroMsg.EditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(181545);
      }
    }, 0L);
    AppMethodBeat.o(181564);
  }
  
  public final void zW(int paramInt)
  {
    AppMethodBeat.i(181565);
    try
    {
      this.okt.cl(paramInt);
      AppMethodBeat.o(181565);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.EditorUI", localException, "", new Object[0]);
      ad.e("MicroMsg.EditorUI", "onNotifyItemInserted error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(181565);
    }
  }
  
  public final void zX(int paramInt)
  {
    AppMethodBeat.i(181567);
    try
    {
      this.okt.cm(paramInt);
      AppMethodBeat.o(181567);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.EditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(181567);
    }
  }
  
  public final void zY(int paramInt)
  {
    AppMethodBeat.i(181573);
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().size()))
    {
      AppMethodBeat.o(181573);
      return;
    }
    this.iDu.post(new EditorUI.2(this, paramInt));
    AppMethodBeat.o(181573);
  }
  
  final class a
    extends com.tencent.mm.plugin.editor.adapter.a
  {
    a() {}
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(181550);
      super.b(paramRecyclerView, paramInt);
      AppMethodBeat.o(181550);
    }
    
    public final void bRX()
    {
      AppMethodBeat.i(181547);
      EditorUI.m(EditorUI.this);
      AppMethodBeat.o(181547);
    }
    
    public final void bRY()
    {
      AppMethodBeat.i(181548);
      EditorUI.this.showActionbarLine();
      EditorUI.m(EditorUI.this);
      AppMethodBeat.o(181548);
    }
    
    public final void bRZ()
    {
      AppMethodBeat.i(181549);
      EditorUI.this.hideActionbarLine();
      AppMethodBeat.o(181549);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI
 * JD-Core Version:    0.7.0.1
 */