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
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
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
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
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
  private g.a hIz;
  private float jHr;
  private float jHs;
  private ao jdu;
  ProgressDialog nxV;
  private boolean oNR;
  private RecyclerView oNS;
  private com.tencent.mm.plugin.editor.adapter.b oNT;
  private CollectEditorLinearLayoutManager oNU;
  private EditorUI.a oNV;
  private LinearLayout oNW;
  com.tencent.mm.plugin.editor.widget.a oNX;
  private LinearLayout oNY;
  private RelativeLayout oNZ;
  private com.tencent.mm.plugin.editor.model.nativenote.manager.d oOa;
  private com.tencent.mm.plugin.editor.model.nativenote.manager.j oOb;
  private boolean oOc;
  private int oOd;
  private RecyclerView.m oOe;
  private boolean oOf;
  private boolean oOg;
  private boolean oOh;
  private String oOi;
  private boolean oOj;
  private int oOk;
  private boolean oOl;
  private agx oOm;
  View.OnTouchListener oOn;
  com.tencent.mm.plugin.fav.a.g oOo;
  LinkedList<agx> oOp;
  private ConcurrentHashMap<String, com.tencent.mm.plugin.fav.a.c> oOq;
  private ConcurrentHashMap<String, agx> oOr;
  
  public EditorUI()
  {
    AppMethodBeat.i(181554);
    this.oNR = false;
    this.oOc = true;
    this.oOk = -1;
    this.oOn = new View.OnTouchListener()
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
              EditorUI.a(EditorUI.this).oQQ.dismiss();
            }
            EditorUI.b(EditorUI.this).setVisibility(8);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(181531);
          return false;
          label170:
          int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().size();
          paramAnonymousView = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().AS(i - 1);
          if (paramAnonymousView != null)
          {
            boolean bool = paramAnonymousView.oPV;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZI();
            paramAnonymousView.oPV = true;
            paramAnonymousView.oQb = false;
            paramAnonymousView.oPX = -1;
            EditorUI.g(EditorUI.this).cj(i - 1);
            EditorUI.this.e(true, 50L);
            EditorUI.this.M(1, 0L);
            if ((EditorUI.p(EditorUI.this)) && (bool))
            {
              EditorUI.q(EditorUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181530);
                  com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().ka(true);
                  com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().jZ(true);
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
                    if (com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().cak() == 1)
                    {
                      EditorUI.this.bYU();
                      com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().caq();
                    }
                  }
                  else if (!EditorUI.r(EditorUI.this)) {
                    EditorUI.this.bYU();
                  }
                }
              }
            }
          }
        }
      }
    };
    this.oOp = new LinkedList();
    this.oOq = new ConcurrentHashMap();
    this.oOr = new ConcurrentHashMap();
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(181537);
        if (paramAnonymousInt != 0)
        {
          ac.e("MicroMsg.EditorUI", "transfer err! startRet: %s.", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(181537);
          return 0;
        }
        paramAnonymousc = (com.tencent.mm.plugin.fav.a.c)EditorUI.s(EditorUI.this).get(paramAnonymousString);
        if (paramAnonymousc == null)
        {
          ac.e("MicroMsg.EditorUI", "cdn info is null!!!");
          AppMethodBeat.o(181537);
          return 0;
        }
        agx localagx = (agx)EditorUI.t(EditorUI.this).get(paramAnonymousString);
        if (localagx == null)
        {
          ac.e("MicroMsg.EditorUI", "data item is null!!!");
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
          localagx.aIF(paramAnonymousc.field_cdnKey);
          localagx.aIE(paramAnonymousc.field_cdnUrl);
          label197:
          EditorUI.s(EditorUI.this).remove(paramAnonymousc.field_dataId);
          ac.i("MicroMsg.EditorUI", "transfer done, mediaId=%s completeResult.mediaId=%s aesKey=%s completeInfo=%s", new Object[] { paramAnonymousString, paramAnonymousd.mediaId, paramAnonymousd.field_aesKey, paramAnonymousd.toString() });
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
          if ((paramAnonymousInt == -2) && (!EditorUI.Xd(str)) && (EditorUI.fd(str, (String)localObject)))
          {
            ac.i("MicroMsg.EditorUI", "renameAndCopyFile write amr head ok!");
            break;
          }
          com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(str);
          localObject = new com.tencent.mm.vfs.e((String)localObject);
          if (!locale.exists()) {
            break;
          }
          ac.i("MicroMsg.EditorUI", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(locale.ae((com.tencent.mm.vfs.e)localObject)), str, localObject });
          break;
          label374:
          paramAnonymousc.field_cdnKey = paramAnonymousd.field_aesKey;
          paramAnonymousc.field_cdnUrl = paramAnonymousd.field_fileId;
          break;
          label395:
          localagx.aIH(paramAnonymousc.field_cdnKey);
          localagx.aIG(paramAnonymousc.field_cdnUrl);
          if ((paramAnonymousc.field_type != 0) || (!paramAnonymousc.cpi())) {
            break label197;
          }
          ac.i("MicroMsg.EditorUI", "video stream, id:%s", new Object[] { paramAnonymousd.field_videoFileId });
          localagx.aIV(paramAnonymousd.field_videoFileId);
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
  
  private void L(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(181560);
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().fb(0, paramArrayList.size()))
    {
      bYO();
      AppMethodBeat.o(181560);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.nxV = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131755936), true, new DialogInterface.OnCancelListener()
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
    com.tencent.mm.kernel.g.agU().az(new Runnable()
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
          localh.oQj = true;
          localh.type = 2;
          localh.oQi = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZL();
          localh.dhw = com.tencent.mm.plugin.editor.model.b.Xn(localh.toString());
          EditorUI.a(EditorUI.this, new agx());
          EditorUI.e(EditorUI.this).aIP(localh.dhw);
          localh.oQg = b.fe(str, com.tencent.mm.plugin.editor.model.b.b(EditorUI.e(EditorUI.this)));
          localh.dpK = b.ff(localh.oQg, com.tencent.mm.plugin.editor.model.b.a(EditorUI.e(EditorUI.this)));
          localArrayList.add(localh);
          i += 1;
        }
        if ((EditorUI.c(EditorUI.this) != null) && (EditorUI.c(EditorUI.this).isShowing()))
        {
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().a(localArrayList, EditorUI.f(EditorUI.this).cah(), true, false, true, false);
          EditorUI.this.e(true, 100L);
          EditorUI.this.M(1, 0L);
          AppMethodBeat.o(181541);
          return;
        }
        ac.i("MicroMsg.EditorUI", "user canceled");
        AppMethodBeat.o(181541);
      }
    });
    AppMethodBeat.o(181560);
  }
  
  private void Xb(String paramString)
  {
    AppMethodBeat.i(181561);
    Object localObject = com.tencent.mm.plugin.sight.base.e.asx(paramString);
    if (localObject == null)
    {
      ac.e("MicroMsg.EditorUI", "mediaInfo is null, videoPath is %s", new Object[] { bs.nullAsNil(paramString) });
      AppMethodBeat.o(181561);
      return;
    }
    int i = ((com.tencent.mm.plugin.sight.base.a)localObject).getVideoDuration();
    localObject = new l();
    ((l)localObject).oQj = true;
    ((l)localObject).thumbPath = "";
    ((l)localObject).dpK = "";
    ((l)localObject).duration = i;
    ((l)localObject).type = 6;
    ((l)localObject).oQi = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZL();
    ((l)localObject).oQk = com.tencent.mm.vfs.i.VW(paramString);
    ((l)localObject).dhw = com.tencent.mm.plugin.editor.model.b.Xn(localObject.toString());
    this.oOm = new agx();
    this.oOm.aIP(((l)localObject).dhw);
    this.oOm.aIM(((l)localObject).oQk);
    a(paramString, (l)localObject, com.tencent.mm.plugin.editor.model.b.a(this.oOm), com.tencent.mm.plugin.editor.model.b.b(this.oOm));
    AppMethodBeat.o(181561);
  }
  
  static boolean Xc(String paramString)
  {
    AppMethodBeat.i(181600);
    boolean bool = bs.isNullOrNil(b.Xm(paramString));
    AppMethodBeat.o(181600);
    return bool;
  }
  
  /* Error */
  static boolean Xd(String paramString)
  {
    // Byte code:
    //   0: ldc_w 336
    //   3: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 338	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: ldc_w 340
    //   14: invokespecial 343	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   34: invokevirtual 347	java/io/RandomAccessFile:read	([BII)I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpne +32 -> 72
    //   43: aload_3
    //   44: invokevirtual 350	java/io/RandomAccessFile:close	()V
    //   47: ldc_w 336
    //   50: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_0
    //   54: ireturn
    //   55: astore_0
    //   56: ldc 231
    //   58: aload_0
    //   59: ldc_w 260
    //   62: iconst_0
    //   63: anewarray 235	java/lang/Object
    //   66: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: goto -22 -> 47
    //   72: aload_3
    //   73: astore_0
    //   74: new 356	java/lang/String
    //   77: dup
    //   78: aload 4
    //   80: invokespecial 359	java/lang/String:<init>	([B)V
    //   83: astore 4
    //   85: aload_3
    //   86: astore_0
    //   87: ldc 231
    //   89: new 361	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 363
    //   96: invokespecial 365	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload 4
    //   101: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 371
    //   107: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 374	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_3
    //   117: astore_0
    //   118: aload 4
    //   120: ldc_w 376
    //   123: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   126: istore_2
    //   127: aload_3
    //   128: invokevirtual 350	java/io/RandomAccessFile:close	()V
    //   131: ldc_w 336
    //   134: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iload_2
    //   138: ireturn
    //   139: astore_0
    //   140: ldc 231
    //   142: aload_0
    //   143: ldc_w 260
    //   146: iconst_0
    //   147: anewarray 235	java/lang/Object
    //   150: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: goto -22 -> 131
    //   156: astore 4
    //   158: aconst_null
    //   159: astore_3
    //   160: aload_3
    //   161: astore_0
    //   162: ldc 231
    //   164: aload 4
    //   166: ldc_w 260
    //   169: iconst_0
    //   170: anewarray 235	java/lang/Object
    //   173: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_3
    //   177: ifnull +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 350	java/io/RandomAccessFile:close	()V
    //   184: ldc_w 336
    //   187: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: iconst_0
    //   191: ireturn
    //   192: astore_0
    //   193: ldc 231
    //   195: aload_0
    //   196: ldc_w 260
    //   199: iconst_0
    //   200: anewarray 235	java/lang/Object
    //   203: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -22 -> 184
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_0
    //   212: aload_0
    //   213: ifnull +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 350	java/io/RandomAccessFile:close	()V
    //   220: ldc_w 336
    //   223: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_3
    //   227: athrow
    //   228: astore_0
    //   229: ldc 231
    //   231: aload_0
    //   232: ldc_w 260
    //   235: iconst_0
    //   236: anewarray 235	java/lang/Object
    //   239: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      paramInt = com.tencent.mm.i.a.fqu;
      AppMethodBeat.o(181604);
      return paramInt;
    }
    if ((paramc.field_extFlag & 0x1) == 0)
    {
      AppMethodBeat.o(181604);
      return paramInt;
    }
    ac.w("MicroMsg.EditorUI", "NEED To Exchange Type, defType %d", new Object[] { Integer.valueOf(paramInt) });
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
  
  private com.tencent.mm.plugin.fav.a.c a(agx paramagx, int paramInt)
  {
    AppMethodBeat.i(181603);
    if ((1 == paramInt) && ((bs.isNullOrNil(paramagx.Ezh)) || (bs.isNullOrNil(paramagx.Ezf))))
    {
      ac.e("MicroMsg.EditorUI", "getCdnDataInfo, type recv, cdnDataUrl must not be null!");
      AppMethodBeat.o(181603);
      return null;
    }
    if ((paramInt == 0) && (bs.isNullOrNil(com.tencent.mm.plugin.fav.a.b.d(paramagx))))
    {
      ac.e("MicroMsg.EditorUI", "getCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(181603);
      return null;
    }
    com.tencent.mm.plugin.fav.a.c localc = new com.tencent.mm.plugin.fav.a.c();
    localc.field_dataId = paramagx.dhw;
    localc.field_totalLen = ((int)paramagx.EzA);
    localc.field_type = paramInt;
    localc.field_favLocalId = this.oOo.field_localId;
    localc.field_cdnKey = paramagx.Ezh;
    localc.field_cdnUrl = paramagx.Ezf;
    localc.field_path = com.tencent.mm.plugin.fav.a.b.d(paramagx);
    if (paramagx.dataType == 3) {}
    for (localc.field_dataType = com.tencent.mm.plugin.fav.a.b.acq(paramagx.Ezu);; localc.field_dataType = paramagx.dataType)
    {
      localc.field_modifyTime = bs.eWj();
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
    ac.i("MicroMsg.EditorUI", "startTransfer, md5:%s", new Object[] { paramc.field_dataId });
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.frb = this.hIz;
    localg.field_mediaId = paramc.field_dataId;
    localg.field_priority = com.tencent.mm.i.a.fqq;
    if (paramc.field_type == 0)
    {
      localg.dBE = true;
      localg.field_needStorage = true;
      localg.field_totalLen = paramc.field_totalLen;
      localg.field_aesKey = paramc.field_cdnKey;
      localg.field_fileId = paramc.field_cdnUrl;
      localg.field_isStreamMedia = paramc.cpi();
      localg.field_fullpath = paramc.field_path;
      if (!com.tencent.mm.vfs.i.eA(localg.field_fullpath)) {
        ac.e("MicroMsg.EditorUI", "upload, but file not exist, filePath = %s", new Object[] { paramc.field_path });
      }
      if (paramc.cpi()) {}
      for (localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
      {
        localg.field_force_aeskeycdn = true;
        localg.field_trysafecdn = false;
        com.tencent.mm.an.f.aDD().f(localg);
        AppMethodBeat.o(181602);
        return;
      }
    }
    localg.dBE = false;
    localg.field_totalLen = paramc.field_totalLen;
    localg.field_aesKey = paramc.field_cdnKey;
    localg.field_fileId = paramc.field_cdnUrl;
    localg.field_fullpath = (paramc.field_path + ".temp");
    localg.field_needStorage = true;
    localg.field_isStreamMedia = paramc.cpi();
    if (paramc.cpi()) {}
    for (localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
    {
      com.tencent.mm.an.f.aDD().b(localg, -1);
      AppMethodBeat.o(181602);
      return;
    }
  }
  
  private void a(final String paramString1, final l paraml, String paramString2, String paramString3)
  {
    AppMethodBeat.i(181562);
    if (bs.isNullOrNil(paramString1))
    {
      ac.e("MicroMsg.EditorUI", "video is null");
      AppMethodBeat.o(181562);
      return;
    }
    ac.v("MicroMsg.EditorUI", "compressNoteVideo path: %s", new Object[] { paramString1 });
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    paramString1 = new com.tencent.mm.plugin.editor.model.nativenote.manager.e(localArrayList, paramString2, paramString3, paraml, new e.a()
    {
      public final void a(String paramAnonymousString, l paramAnonymousl)
      {
        AppMethodBeat.i(181542);
        ac.i("MicroMsg.EditorUI", "compressNoteVideo onImportFinish");
        if ((!bs.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.i.eA(paramAnonymousString)) && (paramAnonymousl != null)) {
          paramAnonymousl.thumbPath = paramAnonymousString;
        }
        AppMethodBeat.o(181542);
      }
      
      public final void b(String paramAnonymousString, l paramAnonymousl)
      {
        AppMethodBeat.i(181543);
        ac.i("MicroMsg.EditorUI", "compressNoteVideo onExportFinish");
        if (EditorUI.c(EditorUI.this) != null)
        {
          EditorUI.c(EditorUI.this).dismiss();
          EditorUI.d(EditorUI.this);
        }
        if ((!bs.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.i.eA(paramAnonymousString)) && (paramAnonymousl != null) && (!paramAnonymousl.oQr)) {
          if (new com.tencent.mm.vfs.e(paramAnonymousString).length() < ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(false))
          {
            paramAnonymousl.dpK = paramAnonymousString;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().a(paramAnonymousl, EditorUI.f(EditorUI.this).cah(), false, true, false);
          }
        }
        for (;;)
        {
          EditorUI.this.e(true, 100L);
          EditorUI.this.M(1, 0L);
          AppMethodBeat.o(181543);
          return;
          Toast.makeText(EditorUI.this.getContext(), EditorUI.this.getString(2131759024), 1).show();
          continue;
          ac.i("MicroMsg.EditorUI", "file not exist or user canceled");
        }
      }
    });
    paramString2 = getContext();
    getString(2131755906);
    this.nxV = com.tencent.mm.ui.base.h.b(paramString2, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(181544);
        paramAnonymousDialogInterface = paramString1;
        paramAnonymousDialogInterface.isStop = true;
        paramAnonymousDialogInterface.interrupt();
        paraml.oQr = true;
        EditorUI.this.e(true, 100L);
        EditorUI.this.M(1, 0L);
        AppMethodBeat.o(181544);
      }
    });
    com.tencent.mm.sdk.g.b.c(paramString1, "NoteEditor_importVideo");
    AppMethodBeat.o(181562);
  }
  
  private void bYL()
  {
    AppMethodBeat.i(181568);
    try
    {
      this.oNT.arg.notifyChanged();
      AppMethodBeat.o(181568);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.EditorUI", localException, "", new Object[0]);
      ac.i("MicroMsg.EditorUI", "onNotifyDataChanged error");
      AppMethodBeat.o(181568);
    }
  }
  
  private boolean bZg()
  {
    AppMethodBeat.i(181598);
    if ((this.oNX != null) && (this.oNX.oUs))
    {
      bYQ();
      AppMethodBeat.o(181598);
      return false;
    }
    AppMethodBeat.o(181598);
    return true;
  }
  
  private void bZh()
  {
    AppMethodBeat.i(181607);
    if (this.oOi.isEmpty())
    {
      ac.i("MicroMsg.EditorUI", "no need update ui by xml!!! xml is empty.");
      AppMethodBeat.o(181607);
      return;
    }
    Object localObject1 = getContext();
    getString(2131755906);
    this.nxV = com.tencent.mm.ui.base.h.b((Context)localObject1, getString(2131755936), true, new DialogInterface.OnCancelListener()
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
    this.oOo = com.tencent.mm.plugin.fav.a.b.acu(this.oOi);
    if (this.oOo != null)
    {
      this.oOp.clear();
      this.oOp.addAll(this.oOo.field_favProto.nxC);
      int i = this.oOp.size();
      if (i == 0)
      {
        ac.v("MicroMsg.EditorUI", "favItemInfo has no data!!!");
        AppMethodBeat.o(181607);
        return;
      }
      localObject1 = this.oOo.field_favProto.nxC;
      this.oOq.clear();
      this.oOr.clear();
      i -= 1;
      if (i >= 0)
      {
        agx localagx = (agx)((List)localObject1).get(i);
        Object localObject2;
        if (!bs.isNullOrNil(localagx.Ezw))
        {
          localObject2 = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.d(localagx));
          ac.i("MicroMsg.EditorUI", "dataFile: %s", new Object[] { ((com.tencent.mm.vfs.e)localObject2).getName() });
          if (((com.tencent.mm.vfs.e)localObject2).exists()) {
            break label392;
          }
          if ((bs.isNullOrNil(localagx.Ezh)) || (bs.isNullOrNil(localagx.Ezf))) {
            ac.e("MicroMsg.EditorUI", "data key or url null!!!");
          }
        }
        else
        {
          label259:
          if (!bs.isNullOrNil(localagx.EzH))
          {
            if (new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localagx)).exists()) {
              break label505;
            }
            if ((!bs.isNullOrNil(localagx.Ezb)) && (!bs.isNullOrNil(localagx.hhV))) {
              break label427;
            }
            ac.w("MicroMsg.EditorUI", "thumb key or url null. favId: %d", new Object[] { Integer.valueOf(this.oOo.field_id) });
          }
        }
        for (;;)
        {
          i -= 1;
          break;
          ac.d("MicroMsg.EditorUI", "local data not exist, gen cdnInfo.");
          localObject2 = a(localagx, 1);
          this.oOq.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localObject2);
          this.oOr.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localagx);
          a((com.tencent.mm.plugin.fav.a.c)localObject2);
          break label259;
          label392:
          ac.d("MicroMsg.EditorUI", "file exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.oOo.field_id), Integer.valueOf(i) });
          break label259;
          label427:
          ac.d("MicroMsg.EditorUI", "local thumb not exist, insert cdnInfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.oOo.field_id), Integer.valueOf(i) });
          localObject2 = a(localagx, 1);
          this.oOq.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localObject2);
          this.oOr.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localagx);
          a((com.tencent.mm.plugin.fav.a.c)localObject2);
          continue;
          label505:
          ac.d("MicroMsg.EditorUI", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.oOo.field_id), Integer.valueOf(i) });
        }
      }
      bZi();
    }
    AppMethodBeat.o(181607);
  }
  
  private void bZi()
  {
    AppMethodBeat.i(181608);
    if (this.oOq.isEmpty())
    {
      ac.i("MicroMsg.EditorUI", "download finish, notifyUpdateUI.");
      Object localObject1 = bZj();
      if (localObject1 == null)
      {
        ac.e("MicroMsg.EditorUI", "weNoteWrapData is null!!!");
        AppMethodBeat.o(181608);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZG();
      localObject1 = ((com.tencent.mm.plugin.editor.model.a.g)localObject1).oQp.iterator();
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
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 1: 
          localObject2 = (com.tencent.mm.plugin.editor.model.a.j)localObject2;
          if (bs.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content)) {
            ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = "";
          }
          ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = a.Xa(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content);
          if (((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.length() > 100) {
            com.tencent.mm.plugin.editor.model.nativenote.a.a.Xo(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content);
          }
          for (;;)
          {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
            break;
            if (b.Xl(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content)) {
              ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.substring(0, ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.length() - 5);
            }
          }
        case 2: 
          localObject2 = (com.tencent.mm.plugin.editor.model.a.h)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 4: 
          localObject2 = (m)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 6: 
          localObject2 = (l)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
        }
      }
      bYL();
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZL();
      if (this.nxV != null)
      {
        this.nxV.dismiss();
        this.nxV = null;
      }
    }
    AppMethodBeat.o(181608);
  }
  
  private com.tencent.mm.plugin.editor.model.a.g bZj()
  {
    AppMethodBeat.i(181609);
    com.tencent.mm.plugin.editor.model.a.g localg = new com.tencent.mm.plugin.editor.model.a.g();
    Iterator localIterator = this.oOp.iterator();
    Object localObject1 = null;
    Object localObject4;
    Object localObject5;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject4 = (agx)localIterator.next();
      localObject5 = new com.tencent.mm.plugin.editor.model.a.d();
      ((com.tencent.mm.plugin.editor.model.a.d)localObject5).oQi = ((agx)localObject4).EAh;
      if (((agx)localObject4).dataType == 1) {
        ((com.tencent.mm.plugin.editor.model.a.d)localObject5).oQi = "-1";
      }
      if (bs.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.d)localObject5).oQi))
      {
        ac.e("MicroMsg.EditorUI", "noteItemData.localEditorId is null or nil.");
        AppMethodBeat.o(181609);
        return null;
      }
      if (((com.tencent.mm.plugin.editor.model.a.d)localObject5).oQi.equals("WeNoteHtmlFile"))
      {
        localObject2 = com.tencent.mm.plugin.fav.a.b.d((agx)localObject4);
        if ((bs.isNullOrNil((String)localObject2)) || (!com.tencent.mm.vfs.i.eA((String)localObject2))) {
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
            localg.oQo = com.tencent.mm.vfs.i.aSr((String)localObject2);
            localObject2 = b.Xj(localg.oQo);
            localObject1 = localObject2;
            try
            {
              ac.i("MicroMsg.EditorUI", "local html file exist, dataId: %s", new Object[] { ((agx)localObject4).dhw });
              ac.i("MicroMsg.EditorUI", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(bs.isNullOrNil(((agx)localObject4).Ezf)), Boolean.valueOf(bs.isNullOrNil(((agx)localObject4).Ezh)) });
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
        ac.printErrStackTrace("MicroMsg.EditorUI", localException1, "", new Object[0]);
        continue;
        ((com.tencent.mm.plugin.editor.model.a.d)localObject5).dhw = ((agx)localObject4).dhw;
        switch (((agx)localObject4).dataType)
        {
        default: 
          break;
        case 1: 
          if (bs.isNullOrNil(((agx)localObject4).desc)) {
            break;
          }
          if ((localg.oQp.size() > 0) && (localg.oQp.get(localg.oQp.size() - 1) != null) && (((com.tencent.mm.plugin.editor.model.a.d)localg.oQp.get(localg.oQp.size() - 1)).oQi.equals("-1")))
          {
            localObject3 = (com.tencent.mm.plugin.editor.model.a.e)localg.oQp.get(localg.oQp.size() - 1);
            ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content = ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content.concat(((agx)localObject4).desc);
            break;
          }
          localObject3 = new com.tencent.mm.plugin.editor.model.a.j();
          ((com.tencent.mm.plugin.editor.model.a.e)localObject3).oQi = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).oQi;
          ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content = ((agx)localObject4).desc;
          localg.oQp.add(localObject3);
          break;
        case 2: 
          localObject3 = new com.tencent.mm.plugin.editor.model.a.h();
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).oQi = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).oQi;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).type = 2;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).dhw = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).dhw;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).oQh = ((agx)localObject4);
          localObject5 = com.tencent.mm.plugin.fav.a.b.d((agx)localObject4);
          if (bs.isNullOrNil((String)localObject5)) {
            break;
          }
          localObject6 = (String)localObject5 + "_bigthumb";
          com.tencent.mm.vfs.i.eA(com.tencent.mm.plugin.fav.a.b.a((agx)localObject4));
          if (com.tencent.mm.vfs.i.eA((String)localObject5))
          {
            ((com.tencent.mm.plugin.editor.model.a.c)localObject3).oQj = true;
            b.ff((String)localObject5, (String)localObject6);
          }
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).dpK = ((String)localObject6);
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).oQg = ((String)localObject5);
          localg.oQp.add(localObject3);
          break;
        case 3: 
          localObject3 = new m();
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).oQi = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).oQi;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).type = 4;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).dhw = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).dhw;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).oQh = ((agx)localObject4);
          localObject5 = com.tencent.mm.plugin.fav.a.b.d((agx)localObject4);
          if ((!bs.isNullOrNil((String)localObject5)) && (com.tencent.mm.vfs.i.eA((String)localObject5)))
          {
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).oQj = true;
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).kvC = com.tencent.mm.plugin.editor.model.a.oPA;
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).length = ((int)com.tencent.mm.plugin.editor.model.b.qw(((agx)localObject4).duration));
          }
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).dpK = ((String)localObject5);
          localObject5 = getContext();
          int i = (int)com.tencent.mm.plugin.editor.model.b.qw(((agx)localObject4).duration);
          localObject6 = new gt();
          ((gt)localObject6).dhx.type = 21;
          ((gt)localObject6).dhx.context = ((Context)localObject5);
          ((gt)localObject6).dhx.dhF = i;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject6);
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).oQm = ((gt)localObject6).dhy.path;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).dhF = ((agx)localObject4).duration;
          localObject5 = new gt();
          ((gt)localObject5).dhx.type = 17;
          ((gt)localObject5).dhx.dhz = ((agx)localObject4);
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject5);
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).dhE = ((gt)localObject5).dhy.ret;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).oQk = ((agx)localObject4).Ezu;
          localg.oQp.add(localObject3);
          break;
        case 4: 
          localObject3 = new l();
          ((l)localObject3).oQi = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).oQi;
          ((l)localObject3).type = 6;
          ((l)localObject3).dhw = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).dhw;
          ((l)localObject3).oQh = ((agx)localObject4);
          ((l)localObject3).duration = ((agx)localObject4).duration;
          ((l)localObject3).thumbPath = com.tencent.mm.plugin.fav.a.b.a((agx)localObject4);
          localObject4 = com.tencent.mm.plugin.fav.a.b.d((agx)localObject4);
          ((l)localObject3).dpK = ((String)localObject4);
          if ((!bs.isNullOrNil(((l)localObject3).thumbPath)) && (!com.tencent.mm.vfs.i.eA(((l)localObject3).thumbPath)) && (com.tencent.mm.vfs.i.eA((String)localObject4)))
          {
            localObject5 = com.tencent.mm.plugin.fav.ui.e.acS((String)localObject4);
            if (localObject5 == null) {}
          }
          try
          {
            ac.i("MicroMsg.EditorUI", "add fav service: create thumbPath bitmap, saveBitmapToImage ");
            com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject5, 60, Bitmap.CompressFormat.JPEG, ((l)localObject3).thumbPath, true);
            if ((!bs.isNullOrNil((String)localObject4)) && (com.tencent.mm.vfs.i.eA((String)localObject4))) {
              ((l)localObject3).oQj = true;
            }
            localg.oQp.add(localObject3);
          }
          catch (Exception localException3)
          {
            ac.printErrStackTrace("MicroMsg.EditorUI", localException3, "", new Object[0]);
          }
        }
      }
      if ((localObject1 != null) && (localObject1.size() > 0)) {
        com.tencent.mm.plugin.editor.model.b.a(localg.oQp, localObject1);
      }
      AppMethodBeat.o(181609);
      return localg;
    }
  }
  
  private void bZk()
  {
    AppMethodBeat.i(181610);
    if (bs.isNullOrNil(b.Xm(com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZN())))
    {
      if (this.oNR)
      {
        this.oNR = false;
        enableOptionMenu(0, false);
        AppMethodBeat.o(181610);
      }
    }
    else if (!this.oNR)
    {
      this.oNR = true;
      enableOptionMenu(0, true);
    }
    AppMethodBeat.o(181610);
  }
  
  /* Error */
  static boolean fd(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 990
    //   3: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 994	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_1
    //   12: iconst_0
    //   13: invokestatic 998	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/OutputStream;
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
    //   37: ldc_w 376
    //   40: invokevirtual 1002	java/lang/String:getBytes	()[B
    //   43: invokevirtual 1007	java/io/OutputStream:write	([B)V
    //   46: aload_1
    //   47: astore 6
    //   49: aload_0
    //   50: astore 5
    //   52: aload_0
    //   53: aload 7
    //   55: invokevirtual 1012	java/io/InputStream:read	([B)I
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
    //   75: invokevirtual 1015	java/io/OutputStream:write	([BII)V
    //   78: goto -32 -> 46
    //   81: astore 7
    //   83: aload_1
    //   84: astore 6
    //   86: aload_0
    //   87: astore 5
    //   89: ldc 231
    //   91: aload 7
    //   93: ldc_w 260
    //   96: iconst_0
    //   97: anewarray 235	java/lang/Object
    //   100: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 1016	java/io/InputStream:close	()V
    //   111: aload_1
    //   112: ifnull +221 -> 333
    //   115: aload_1
    //   116: invokevirtual 1017	java/io/OutputStream:close	()V
    //   119: iconst_0
    //   120: istore_3
    //   121: ldc_w 990
    //   124: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iload_3
    //   128: ireturn
    //   129: iconst_1
    //   130: istore_3
    //   131: iload_3
    //   132: istore 4
    //   134: aload_0
    //   135: ifnull +10 -> 145
    //   138: aload_0
    //   139: invokevirtual 1016	java/io/InputStream:close	()V
    //   142: iload_3
    //   143: istore 4
    //   145: iload 4
    //   147: istore_3
    //   148: aload_1
    //   149: ifnull -28 -> 121
    //   152: aload_1
    //   153: invokevirtual 1017	java/io/OutputStream:close	()V
    //   156: iload 4
    //   158: istore_3
    //   159: goto -38 -> 121
    //   162: astore_0
    //   163: ldc 231
    //   165: aload_0
    //   166: ldc_w 260
    //   169: iconst_0
    //   170: anewarray 235	java/lang/Object
    //   173: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: iconst_0
    //   177: istore_3
    //   178: goto -57 -> 121
    //   181: astore_0
    //   182: ldc 231
    //   184: aload_0
    //   185: ldc_w 260
    //   188: iconst_0
    //   189: anewarray 235	java/lang/Object
    //   192: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: iconst_0
    //   196: istore 4
    //   198: goto -53 -> 145
    //   201: astore_0
    //   202: ldc 231
    //   204: aload_0
    //   205: ldc_w 260
    //   208: iconst_0
    //   209: anewarray 235	java/lang/Object
    //   212: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: goto -104 -> 111
    //   218: astore_0
    //   219: ldc 231
    //   221: aload_0
    //   222: ldc_w 260
    //   225: iconst_0
    //   226: anewarray 235	java/lang/Object
    //   229: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   248: invokevirtual 1016	java/io/InputStream:close	()V
    //   251: aload 6
    //   253: ifnull +8 -> 261
    //   256: aload 6
    //   258: invokevirtual 1017	java/io/OutputStream:close	()V
    //   261: ldc_w 990
    //   264: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aload_1
    //   268: athrow
    //   269: astore_0
    //   270: ldc 231
    //   272: aload_0
    //   273: ldc_w 260
    //   276: iconst_0
    //   277: anewarray 235	java/lang/Object
    //   280: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: goto -32 -> 251
    //   286: astore_0
    //   287: ldc 231
    //   289: aload_0
    //   290: ldc_w 260
    //   293: iconst_0
    //   294: anewarray 235	java/lang/Object
    //   297: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void AN(final int paramInt)
  {
    AppMethodBeat.i(181564);
    this.jdu.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181545);
        ac.i("MicroMsg.EditorUI", "huahuastart: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        EditorUI.g(EditorUI.this).cj(paramInt);
        ac.i("MicroMsg.EditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(181545);
      }
    }, 0L);
    AppMethodBeat.o(181564);
  }
  
  public final void AO(int paramInt)
  {
    AppMethodBeat.i(181565);
    try
    {
      this.oNT.ck(paramInt);
      AppMethodBeat.o(181565);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.EditorUI", localException, "", new Object[0]);
      ac.e("MicroMsg.EditorUI", "onNotifyItemInserted error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(181565);
    }
  }
  
  public final void AP(int paramInt)
  {
    AppMethodBeat.i(181567);
    try
    {
      this.oNT.cl(paramInt);
      AppMethodBeat.o(181567);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.EditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(181567);
    }
  }
  
  public final void AQ(final int paramInt)
  {
    AppMethodBeat.i(181573);
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().size()))
    {
      AppMethodBeat.o(181573);
      return;
    }
    this.jdu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181518);
        RecyclerView localRecyclerView = EditorUI.h(EditorUI.this);
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/plugin/editor/EditorUI$11", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/editor/EditorUI$11", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(181518);
      }
    });
    AppMethodBeat.o(181573);
  }
  
  public final void M(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(181579);
    if (!this.oOh)
    {
      AppMethodBeat.o(181579);
      return;
    }
    this.jdu.postDelayed(new Runnable()
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
          if (!EditorUI.l(EditorUI.this).oUs)
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
    ArrayList localArrayList = com.tencent.mm.plugin.editor.model.nativenote.manager.b.bZB();
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().N(localArrayList))
    {
      bYO();
      AppMethodBeat.o(181571);
      return;
    }
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().a(localArrayList, paramWXRTEditText, true, true, false, false);
    i = paramWXRTEditText.getRecyclerItemPosition();
    int j = localArrayList.size();
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().fc(i, j + i + 1);
    bYU();
    if (this.oOc) {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().caq();
    }
    AppMethodBeat.o(181571);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(181563);
    if (!this.oOh)
    {
      AppMethodBeat.o(181563);
      return;
    }
    ac.d("MicroMsg.EditorUI", "onFocusChanged, poi: %s, focus: %s, editor: %s.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramWXRTEditText });
    CollectEditorLinearLayoutManager localCollectEditorLinearLayoutManager = (CollectEditorLinearLayoutManager)this.oNS.getLayoutManager();
    if (localCollectEditorLinearLayoutManager != null)
    {
      if (this.oOf) {
        localCollectEditorLinearLayoutManager.oOE = false;
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
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().Y(paramInt, true);
    }
    for (;;)
    {
      bZk();
      AppMethodBeat.o(181563);
      return;
      localCollectEditorLinearLayoutManager.oOE = paramBoolean;
      break;
      label124:
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().Y(paramInt, false);
      continue;
      label135:
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().X(-1, false);
    }
  }
  
  final void a(agx paramagx, EditorUI.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(181601);
    Object localObject1;
    if (bs.isNullOrNil(paramagx.Ezh))
    {
      com.tencent.mm.an.f.aDE();
      localObject1 = com.tencent.mm.an.a.aDw();
      paramagx.aIH((String)localObject1);
      ac.i("MicroMsg.EditorUI", "local not exist cdn data key, generate %s", new Object[] { localObject1 });
    }
    if (EditorUI.b.oOz == paramb) {
      localObject1 = a(paramagx, 0);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        this.oOq.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, localObject1);
        this.oOr.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, paramagx);
        a((com.tencent.mm.plugin.fav.a.c)localObject1);
      }
      AppMethodBeat.o(181601);
      return;
      localObject1 = localObject2;
      if (EditorUI.b.oOy == paramb) {
        if (bs.isNullOrNil(com.tencent.mm.plugin.fav.a.b.a(paramagx)))
        {
          ac.e("MicroMsg.EditorUI", "insertCdnThumbInfo, type send, path must not be null!");
          localObject1 = localObject2;
        }
        else
        {
          paramb = com.tencent.mm.plugin.fav.a.b.aco(paramagx.dhw);
          localObject1 = new com.tencent.mm.plugin.fav.a.c();
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey = paramagx.Ezb;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl = paramagx.hhV;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId = paramb;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_favLocalId = this.oOo.field_localId;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen = ((int)paramagx.EzL);
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_type = 0;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 1;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path = com.tencent.mm.plugin.fav.a.b.a(paramagx);
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_modifyTime = bs.eWj();
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_attrFlag |= 1L;
        }
      }
    }
  }
  
  public final void bYM()
  {
    AppMethodBeat.i(181570);
    if (!this.oNX.oUs)
    {
      bYU();
      final AppCompatActivity localAppCompatActivity = getContext();
      this.jdu.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(181546);
          int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().size();
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
            if ((f1 < com.tencent.mm.compatible.util.i.eB(localAppCompatActivity)[1]) && (f1 > 0.0F))
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
            ((com.tencent.mm.plugin.editor.model.nativenote.manager.d)localObject).oQQ.showAtLocation(((com.tencent.mm.plugin.editor.model.nativenote.manager.d)localObject).mParentView, 49, 0, arrayOfInt[1] + 50);
          }
          AppMethodBeat.o(181546);
        }
      }, 400L);
    }
    AppMethodBeat.o(181570);
  }
  
  public final void bYN()
  {
    AppMethodBeat.i(181574);
    this.jdu.post(new Runnable()
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
  
  public final void bYO()
  {
    AppMethodBeat.i(181575);
    bYU();
    if (this.oOc) {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().caq();
    }
    this.jdu.postDelayed(new Runnable()
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
  
  public final void bYP()
  {
    AppMethodBeat.i(181576);
    com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131755691), false, new EditorUI.5(this), new EditorUI.6(this));
    AppMethodBeat.o(181576);
  }
  
  public final void bYQ()
  {
    AppMethodBeat.i(181580);
    com.tencent.mm.ui.base.h.c(getContext(), getString(2131762238), null, true);
    AppMethodBeat.o(181580);
  }
  
  public final void bYR()
  {
    AppMethodBeat.i(181581);
    if (this.oNX != null) {
      this.oNX.a(null);
    }
    AppMethodBeat.o(181581);
  }
  
  public final void bYS()
  {
    AppMethodBeat.i(181582);
    com.tencent.mm.ui.base.h.d(this, getString(2131758035), "", getString(2131758034), getString(2131758033), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(181526);
        com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().caA();
        AppMethodBeat.o(181526);
      }
    }, null);
    AppMethodBeat.o(181582);
  }
  
  public final void bYT()
  {
    AppMethodBeat.i(181583);
    Toast.makeText(getContext(), getString(2131761825), 0).show();
    AppMethodBeat.o(181583);
  }
  
  public final void bYU()
  {
    AppMethodBeat.i(181584);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZH();
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().AS(i);
    if (locala != null)
    {
      locala.oPV = false;
      locala.oQb = false;
      AN(i);
    }
    this.jdu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181528);
        WXRTEditText localWXRTEditText = EditorUI.f(EditorUI.this).caf();
        if (localWXRTEditText != null) {
          localWXRTEditText.clearFocus();
        }
        AppMethodBeat.o(181528);
      }
    });
    e(false, 0L);
    M(0, 0L);
    AppMethodBeat.o(181584);
  }
  
  public final int bYV()
  {
    AppMethodBeat.i(181585);
    if (this.oOg)
    {
      int i = com.tencent.mm.compatible.util.i.iv(this);
      AppMethodBeat.o(181585);
      return i;
    }
    AppMethodBeat.o(181585);
    return 0;
  }
  
  public final int bYW()
  {
    AppMethodBeat.i(181586);
    int j = 0;
    int i = j;
    if (this.oNW != null)
    {
      i = j;
      if (this.oNW.getVisibility() == 0) {
        i = this.oOd + 0;
      }
    }
    j = i;
    if (this.oNY != null)
    {
      j = i;
      if (this.oNY.getVisibility() == 0) {
        j = i + this.oOd;
      }
    }
    AppMethodBeat.o(181586);
    return j;
  }
  
  public final boolean bYX()
  {
    AppMethodBeat.i(181587);
    if ((this.oOb != null) && (this.oOb.caf() != null))
    {
      AppMethodBeat.o(181587);
      return true;
    }
    AppMethodBeat.o(181587);
    return false;
  }
  
  public final RecyclerView bYY()
  {
    return this.oNS;
  }
  
  public final RecyclerView bYZ()
  {
    return this.oNS;
  }
  
  public final Context bZa()
  {
    AppMethodBeat.i(181588);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(181588);
    return localAppCompatActivity;
  }
  
  public final com.tencent.mm.plugin.editor.model.nativenote.b.a bZb()
  {
    return this;
  }
  
  public final void bZc()
  {
    AppMethodBeat.i(181589);
    com.tencent.mm.plugin.editor.model.a.j localj = new com.tencent.mm.plugin.editor.model.a.j();
    localj.content = "";
    localj.oPV = true;
    localj.oQb = false;
    localj.oPX = 0;
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZG();
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().e(localj);
    bYL();
    e(true, 50L);
    M(1, 0L);
    AppMethodBeat.o(181589);
  }
  
  public final void bZd()
  {
    AppMethodBeat.i(181590);
    com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(getContext(), com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZO());
    AppMethodBeat.o(181590);
  }
  
  public final void bZe()
  {
    AppMethodBeat.i(181591);
    com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(getContext(), com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZO());
    bZc();
    AppMethodBeat.o(181591);
  }
  
  public final void bZf()
  {
    AppMethodBeat.i(181592);
    getContext();
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.b.bZE();
    Object localObject;
    if (i == 2)
    {
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.bZD())
      {
        bYO();
        AppMethodBeat.o(181592);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZG();
      com.tencent.mm.plugin.editor.model.nativenote.manager.b.clearData();
      localObject = new com.tencent.mm.plugin.editor.model.a.j();
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).content = "";
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).oPV = false;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).oQb = false;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).oPX = 0;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).oQd = true;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().e((com.tencent.mm.plugin.editor.model.a.a)localObject);
      bYL();
      AppMethodBeat.o(181592);
      return;
    }
    if (i == 3)
    {
      localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.b.bZB();
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().N((ArrayList)localObject))
      {
        bYO();
        AppMethodBeat.o(181592);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZG();
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().a((ArrayList)localObject, null, false, false, false, false);
      bYU();
      AppMethodBeat.o(181592);
      return;
    }
    ac.d("MicroMsg.EditorUI", "no data.");
    AppMethodBeat.o(181592);
  }
  
  public final void bZl()
  {
    AppMethodBeat.i(181611);
    bZk();
    AppMethodBeat.o(181611);
  }
  
  public final void e(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181578);
    if (!this.oOh)
    {
      AppMethodBeat.o(181578);
      return;
    }
    this.jdu.postDelayed(new Runnable()
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
  
  public final void eY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181566);
    try
    {
      this.oNT.aq(paramInt1, paramInt2);
      AppMethodBeat.o(181566);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.EditorUI", localException, "", new Object[0]);
      ac.e("MicroMsg.EditorUI", "onNotifyItemRangeInserted error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(181566);
    }
  }
  
  public final void eZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181569);
    try
    {
      this.oNT.ao(paramInt1, paramInt2);
      AppMethodBeat.o(181569);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.EditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(181569);
    }
  }
  
  public final void fa(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181572);
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.oOf = bool;
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
    if (!bZg())
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
        //   9: invokestatic 40	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   12: aload_0
        //   13: getfield 14	com/tencent/mm/plugin/editor/EditorUI$21:oOs	Lcom/tencent/mm/plugin/editor/EditorUI;
        //   16: astore 6
        //   18: aload 6
        //   20: getfield 44	com/tencent/mm/plugin/editor/EditorUI:oNX	Lcom/tencent/mm/plugin/editor/widget/a;
        //   23: aload 6
        //   25: invokevirtual 50	com/tencent/mm/plugin/editor/widget/a:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/b/a;)V
        //   28: invokestatic 56	com/tencent/mm/plugin/editor/model/nativenote/manager/c:bZF	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/c;
        //   31: invokevirtual 60	com/tencent/mm/plugin/editor/model/nativenote/manager/c:bZN	()Ljava/lang/String;
        //   34: astore_1
        //   35: aload_1
        //   36: invokestatic 64	com/tencent/mm/plugin/editor/EditorUI:Xc	(Ljava/lang/String;)Z
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
        //   81: putfield 88	com/tencent/mm/plugin/editor/EditorUI:nxV	Landroid/app/ProgressDialog;
        //   84: invokestatic 56	com/tencent/mm/plugin/editor/model/nativenote/manager/c:bZF	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/c;
        //   87: aload_1
        //   88: invokevirtual 92	com/tencent/mm/plugin/editor/model/nativenote/manager/c:Xq	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ahn;
        //   91: astore_1
        //   92: aload_1
        //   93: ifnonnull +17 -> 110
        //   96: ldc 33
        //   98: ldc 94
        //   100: invokestatic 97	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   103: ldc 25
        //   105: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   108: iconst_1
        //   109: ireturn
        //   110: aload 6
        //   112: getfield 104	com/tencent/mm/plugin/editor/EditorUI:oOp	Ljava/util/LinkedList;
        //   115: invokevirtual 109	java/util/LinkedList:clear	()V
        //   118: aload 6
        //   120: getfield 104	com/tencent/mm/plugin/editor/EditorUI:oOp	Ljava/util/LinkedList;
        //   123: aload_1
        //   124: getfield 114	com/tencent/mm/protocal/protobuf/ahn:nxC	Ljava/util/LinkedList;
        //   127: invokevirtual 118	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   130: pop
        //   131: aload 6
        //   133: aload 6
        //   135: getfield 104	com/tencent/mm/plugin/editor/EditorUI:oOp	Ljava/util/LinkedList;
        //   138: invokestatic 124	java/lang/System:currentTimeMillis	()J
        //   141: invokestatic 129	com/tencent/mm/plugin/fav/ui/k:a	(Ljava/util/LinkedList;J)Lcom/tencent/mm/plugin/fav/a/g;
        //   144: putfield 133	com/tencent/mm/plugin/editor/EditorUI:oOo	Lcom/tencent/mm/plugin/fav/a/g;
        //   147: iconst_0
        //   148: istore_2
        //   149: iload_2
        //   150: aload 6
        //   152: getfield 104	com/tencent/mm/plugin/editor/EditorUI:oOp	Ljava/util/LinkedList;
        //   155: invokevirtual 137	java/util/LinkedList:size	()I
        //   158: if_icmpge -55 -> 103
        //   161: aload 6
        //   163: getfield 104	com/tencent/mm/plugin/editor/EditorUI:oOp	Ljava/util/LinkedList;
        //   166: iload_2
        //   167: invokevirtual 141	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   170: checkcast 143	com/tencent/mm/protocal/protobuf/agx
        //   173: astore 7
        //   175: aload 7
        //   177: getfield 147	com/tencent/mm/protocal/protobuf/agx:dhw	Ljava/lang/String;
        //   180: invokestatic 152	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
        //   183: ifeq +25 -> 208
        //   186: aload 7
        //   188: aload 7
        //   190: invokevirtual 155	java/lang/Object:toString	()Ljava/lang/String;
        //   193: aload 6
        //   195: getfield 133	com/tencent/mm/plugin/editor/EditorUI:oOo	Lcom/tencent/mm/plugin/fav/a/g;
        //   198: getfield 161	com/tencent/mm/plugin/fav/a/g:field_type	I
        //   201: invokestatic 167	com/tencent/mm/plugin/fav/a/b:cY	(Ljava/lang/String;I)Ljava/lang/String;
        //   204: invokevirtual 171	com/tencent/mm/protocal/protobuf/agx:aIP	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/agx;
        //   207: pop
        //   208: aload 7
        //   210: getfield 174	com/tencent/mm/protocal/protobuf/agx:EzD	Ljava/lang/String;
        //   213: astore_1
        //   214: aload_1
        //   215: invokestatic 179	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
        //   218: ifeq +236 -> 454
        //   221: aload_1
        //   222: invokestatic 185	com/tencent/mm/b/g:getMD5	(Ljava/lang/String;)Ljava/lang/String;
        //   225: astore 5
        //   227: aload_1
        //   228: invokestatic 188	com/tencent/mm/b/g:dt	(Ljava/lang/String;)Ljava/lang/String;
        //   231: astore 8
        //   233: aload 7
        //   235: aload 5
        //   237: invokevirtual 191	com/tencent/mm/protocal/protobuf/agx:aIN	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/agx;
        //   240: pop
        //   241: aload 7
        //   243: aload 8
        //   245: invokevirtual 194	com/tencent/mm/protocal/protobuf/agx:aIO	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/agx;
        //   248: pop
        //   249: aload 7
        //   251: new 196	com/tencent/mm/vfs/e
        //   254: dup
        //   255: aload_1
        //   256: invokespecial 199	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
        //   259: invokevirtual 202	com/tencent/mm/vfs/e:length	()J
        //   262: invokevirtual 206	com/tencent/mm/protocal/protobuf/agx:zS	(J)Lcom/tencent/mm/protocal/protobuf/agx;
        //   265: pop
        //   266: aload 7
        //   268: invokestatic 210	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/agx;)Ljava/lang/String;
        //   271: astore 5
        //   273: aload_1
        //   274: aload 5
        //   276: invokevirtual 216	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   279: ifne +10 -> 289
        //   282: aload_1
        //   283: aload 5
        //   285: invokestatic 220	com/tencent/mm/vfs/i:lZ	(Ljava/lang/String;Ljava/lang/String;)J
        //   288: pop2
        //   289: aload 6
        //   291: aload 7
        //   293: getstatic 226	com/tencent/mm/plugin/editor/EditorUI$b:oOz	Lcom/tencent/mm/plugin/editor/EditorUI$b;
        //   296: invokevirtual 229	com/tencent/mm/plugin/editor/EditorUI:a	(Lcom/tencent/mm/protocal/protobuf/agx;Lcom/tencent/mm/plugin/editor/EditorUI$b;)V
        //   299: aload 7
        //   301: getfield 232	com/tencent/mm/protocal/protobuf/agx:EzF	Ljava/lang/String;
        //   304: astore 8
        //   306: aload 8
        //   308: invokestatic 179	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
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
        //   334: invokestatic 242	com/tencent/mm/sdk/platformtools/bs:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
        //   337: astore 9
        //   339: aload 5
        //   341: astore_1
        //   342: aload 8
        //   344: invokestatic 246	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
        //   347: lstore_3
        //   348: aload 5
        //   350: astore_1
        //   351: aload 5
        //   353: invokestatic 250	com/tencent/mm/b/g:n	(Ljava/io/InputStream;)Ljava/lang/String;
        //   356: astore 10
        //   358: aload 5
        //   360: astore_1
        //   361: aload 7
        //   363: aload 9
        //   365: invokevirtual 253	com/tencent/mm/protocal/protobuf/agx:aIS	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/agx;
        //   368: pop
        //   369: aload 5
        //   371: astore_1
        //   372: aload 7
        //   374: aload 10
        //   376: invokevirtual 256	com/tencent/mm/protocal/protobuf/agx:aIT	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/agx;
        //   379: pop
        //   380: aload 5
        //   382: astore_1
        //   383: aload 7
        //   385: lload_3
        //   386: invokevirtual 259	com/tencent/mm/protocal/protobuf/agx:zT	(J)Lcom/tencent/mm/protocal/protobuf/agx;
        //   389: pop
        //   390: aload 5
        //   392: astore_1
        //   393: aload 7
        //   395: invokestatic 261	com/tencent/mm/plugin/fav/a/b:a	(Lcom/tencent/mm/protocal/protobuf/agx;)Ljava/lang/String;
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
        //   420: invokestatic 220	com/tencent/mm/vfs/i:lZ	(Ljava/lang/String;Ljava/lang/String;)J
        //   423: pop2
        //   424: aload 5
        //   426: astore_1
        //   427: aload 6
        //   429: aload 7
        //   431: getstatic 264	com/tencent/mm/plugin/editor/EditorUI$b:oOy	Lcom/tencent/mm/plugin/editor/EditorUI$b;
        //   434: invokevirtual 229	com/tencent/mm/plugin/editor/EditorUI:a	(Lcom/tencent/mm/protocal/protobuf/agx;Lcom/tencent/mm/plugin/editor/EditorUI$b;)V
        //   437: aload 5
        //   439: ifnull +8 -> 447
        //   442: aload 5
        //   444: invokevirtual 269	java/io/InputStream:close	()V
        //   447: iload_2
        //   448: iconst_1
        //   449: iadd
        //   450: istore_2
        //   451: goto -302 -> 149
        //   454: ldc 33
        //   456: ldc_w 271
        //   459: iconst_2
        //   460: anewarray 4	java/lang/Object
        //   463: dup
        //   464: iconst_0
        //   465: aload 7
        //   467: getfield 274	com/tencent/mm/protocal/protobuf/agx:dataType	I
        //   470: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   473: aastore
        //   474: dup
        //   475: iconst_1
        //   476: aload_1
        //   477: aastore
        //   478: invokestatic 283	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   481: goto -182 -> 299
        //   484: astore_1
        //   485: aconst_null
        //   486: astore_1
        //   487: ldc 33
        //   489: ldc_w 285
        //   492: invokestatic 97	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   495: aload_1
        //   496: ifnull -49 -> 447
        //   499: aload_1
        //   500: invokevirtual 269	java/io/InputStream:close	()V
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
        //   525: invokevirtual 269	java/io/InputStream:close	()V
        //   528: ldc 25
        //   530: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   533: aload_1
        //   534: athrow
        //   535: ldc 33
        //   537: ldc_w 287
        //   540: iconst_1
        //   541: anewarray 4	java/lang/Object
        //   544: dup
        //   545: iconst_0
        //   546: aload 8
        //   548: aastore
        //   549: invokestatic 283	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   173	293	7	localagx	agx
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
    }, null, s.b.Hom);
    enableOptionMenu(0, this.oNR);
    getContentView().getRootView().setBackgroundColor(getContext().getResources().getColor(2131101179));
    this.oOb = new com.tencent.mm.plugin.editor.model.nativenote.manager.j(this);
    this.oOb.oSl = this.oOh;
    this.oNS = ((RecyclerView)findViewById(2131298448));
    this.oNW = ((LinearLayout)findViewById(2131298447));
    this.oNX = new com.tencent.mm.plugin.editor.widget.a();
    Object localObject = this.oNX;
    LinearLayout localLinearLayout = this.oNW;
    ((com.tencent.mm.plugin.editor.widget.a)localObject).nzT = localLinearLayout;
    com.tencent.mm.plugin.editor.model.nativenote.manager.j.cag().oSk = ((com.tencent.mm.plugin.editor.model.nativenote.b.b)localObject);
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUi = ((WeImageButton)localLinearLayout.findViewById(2131300627));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUj = ((WeImageButton)localLinearLayout.findViewById(2131300631));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUk = ((WeImageButton)localLinearLayout.findViewById(2131300630));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUl = ((WeImageButton)localLinearLayout.findViewById(2131300632));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUm = ((LinearLayout)localLinearLayout.findViewById(2131300633));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUn = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).oUm.findViewById(2131307015));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUo = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).oUm.findViewById(2131307013));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUp = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).oUm.findViewById(2131307014));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUq = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).oUm.findViewById(2131302459));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUr = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).oUm.findViewById(2131307008));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUi.setOnClickListener(new a.1((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUj.setOnClickListener(new a.5((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUy = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTO, true);
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUk.setOnClickListener(new a.6((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUl.setOnClickListener(new a.7((com.tencent.mm.plugin.editor.widget.a)localObject, this, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUn.setOnClickListener(new a.8((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUo.setOnClickListener(new a.9((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUp.setOnClickListener(new a.10((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUq.setOnClickListener(new a.11((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).oUr.setOnClickListener(new a.12((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    this.oNY = ((LinearLayout)this.oNW.findViewById(2131300633));
    this.oNY.setVisibility(8);
    this.oNZ = ((RelativeLayout)findViewById(2131306975));
    this.oNZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181517);
        if (EditorUI.a(EditorUI.this) != null) {
          EditorUI.a(EditorUI.this).oQQ.dismiss();
        }
        EditorUI.b(EditorUI.this).setVisibility(8);
        AppMethodBeat.o(181517);
      }
    });
    this.oOa = new com.tencent.mm.plugin.editor.model.nativenote.manager.d(this, this.oNZ);
    this.oOa.oQR = this;
    this.oNU = new CollectEditorLinearLayoutManager();
    this.oNU.oOD = com.tencent.mm.compatible.util.i.eB(this)[1];
    this.oNS.setLayoutManager(this.oNU);
    this.oNS.setHasFixedSize(true);
    this.oNV = new EditorUI.a(this);
    this.oNS.a(this.oNV);
    this.oNT = new com.tencent.mm.plugin.editor.adapter.b(this.oOb);
    this.oNS.setAdapter(this.oNT);
    if (this.oOh)
    {
      localObject = new com.tencent.mm.plugin.editor.model.a.j();
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).content = "";
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).oPV = true;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).oQb = false;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().e((com.tencent.mm.plugin.editor.model.a.a)localObject);
      e(true, 300L);
      M(1, 0L);
      this.oNS.setOnTouchListener(this.oOn);
    }
    for (;;)
    {
      this.oNS.getItemAnimator().ark = 0L;
      this.oNS.getItemAnimator().arn = 0L;
      this.oNS.getItemAnimator().arm = 0L;
      this.oNS.getItemAnimator().arl = 120L;
      ((as)this.oNS.getItemAnimator()).auS = false;
      AppMethodBeat.o(181556);
      return;
      this.oNW.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(181559);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.EditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.oOk = paramInt1;
    if (paramInt2 != -1)
    {
      this.oOj = false;
      AppMethodBeat.o(181559);
      return;
    }
    this.oOj = true;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(181559);
      return;
      ac.i("MicroMsg.EditorUI", "onActivityResult back from gallery");
      Object localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        L((ArrayList)localObject);
      }
      for (;;)
      {
        localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
        String str = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        paramIntent = (Intent)localObject;
        if (!bs.isNullOrNil(str))
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
        if (!com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().fb(0, paramIntent.size())) {
          break;
        }
        bYO();
        AppMethodBeat.o(181559);
        return;
        ac.i("MicroMsg.EditorUI", "no pic selected");
      }
      Xb((String)paramIntent.get(0));
      AppMethodBeat.o(181559);
      return;
      label253:
      ac.i("MicroMsg.EditorUI", "no video selected");
      AppMethodBeat.o(181559);
      return;
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      if (paramIntent == null)
      {
        ac.e("MicroMsg.EditorUI", "sight capture result is null!");
        AppMethodBeat.o(181559);
        return;
      }
      localObject = paramIntent.videoPath;
      if (!bs.isNullOrNil((String)localObject)) {
        Xb((String)localObject);
      }
      if ((paramIntent.wql.booleanValue()) && (!bs.isNullOrNil(paramIntent.thumbPath)))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramIntent.thumbPath);
        L((ArrayList)localObject);
        AppMethodBeat.o(181559);
        return;
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          ac.e("MicroMsg.EditorUI", "sight capture result is null!");
          AppMethodBeat.o(181559);
          return;
        }
        localObject = paramIntent.uJo;
        if (!bs.isNullOrNil((String)localObject)) {
          Xb((String)localObject);
        }
        if ((paramIntent.uJm) && (!bs.isNullOrNil(paramIntent.uJu)))
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramIntent.uJu);
          L((ArrayList)localObject);
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
    if (this.oOc)
    {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().ka(false);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().jZ(false);
    }
    AppMethodBeat.o(181596);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(181555);
    customfixStatusbar(true);
    Object localObject1 = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).ijj = new ArrayList();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).oQK = this;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).oQL = new agx();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).oQM = 0;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).oQN = 0;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).oQO = 0;
    super.onCreate(paramBundle);
    this.oOh = getIntent().getBooleanExtra("KEY_EDITABLE", false);
    this.oOi = getIntent().getStringExtra("KEY_CONTENT_XML");
    if (bs.isNullOrNil(this.oOi))
    {
      this.oOi = "";
      this.oNR = false;
    }
    ac.i("MicroMsg.EditorUI", "mCollectEditable: %s, mCollectContentXml: %s", new Object[] { Boolean.valueOf(this.oOh), this.oOi });
    this.jdu = new ao();
    initView();
    this.oOd = com.tencent.mm.cc.a.fromDPToPix(this, 48);
    if (this.oOc)
    {
      ac.i("MicroMsg.EditorUI", "use multiselect");
      int i = getResources().getColor(2131100265);
      paramBundle = com.tencent.mm.plugin.editor.model.nativenote.c.e.cal();
      boolean bool = this.oOh;
      ac.i("EditorSelectManager", "onInit start");
      paramBundle.oSK = bool;
      paramBundle.oSN = 14;
      paramBundle.oSO = 32;
      paramBundle.oSP = (com.tencent.mm.cc.a.fromDPToPix(this, 21) - paramBundle.oSO);
      paramBundle.oSQ = (com.tencent.mm.cc.a.fromDPToPix(this, 40) + paramBundle.oSO * 2);
      paramBundle.oSR = (com.tencent.mm.cc.a.fromDPToPix(this, 240) + paramBundle.oSO * 2);
      paramBundle.oSL = com.tencent.mm.cc.a.fromDPToPix(this, 22);
      paramBundle.oSM = com.tencent.mm.cc.a.fromDPToPix(this, 1);
      paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
      paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
      paramBundle.oSV = new int[] { -1, -1 };
      paramBundle.oSW = new int[] { -1, -1 };
      paramBundle.oSX = new int[] { -1, -1 };
      paramBundle.oSY = new int[] { -1, -1 };
      localObject1 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 2, paramBundle.oSL, paramBundle.oSM, i, paramBundle);
      paramBundle.oSZ = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.oSZ.setClippingEnabled(false);
      paramBundle.oSZ.setAnimationStyle(2131821705);
      paramBundle.oST = ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
      paramBundle.oSU = com.tencent.mm.cc.a.fromDPToPix(this, 6);
      Object localObject2 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 3, paramBundle.oSL, paramBundle.oSM, i, paramBundle);
      paramBundle.oTa = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.oTa.setClippingEnabled(false);
      paramBundle.oTa.setAnimationStyle(2131821704);
      localObject2 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 4, paramBundle.oSL, paramBundle.oSM, i, paramBundle);
      paramBundle.oTb = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.oTb.setClippingEnabled(false);
      paramBundle.oTb.setAnimationStyle(2131821706);
      localObject2 = LayoutInflater.from(this).inflate(2131493746, null);
      ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramBundle.oTc = new PopupWindow((View)localObject2, -2, -2, false);
      paramBundle.oTc.setBackgroundDrawable(getResources().getDrawable(2131234275));
      paramBundle.oTc.setClippingEnabled(false);
      paramBundle.oTc.setAnimationStyle(2131821708);
      paramBundle.oTi = ((TextView)((View)localObject2).findViewById(2131302913));
      paramBundle.oTj = ((TextView)((View)localObject2).findViewById(2131302942));
      paramBundle.oTk = ((TextView)((View)localObject2).findViewById(2131302939));
      paramBundle.oTl = ((TextView)((View)localObject2).findViewById(2131302938));
      paramBundle.oTm = ((TextView)((View)localObject2).findViewById(2131302923));
      paramBundle.oTn = ((TextView)((View)localObject2).findViewById(2131302922));
      paramBundle.oTo = ((TextView)((View)localObject2).findViewById(2131302921));
      paramBundle.oTp = ((TextView)((View)localObject2).findViewById(2131302934));
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.oTi, paramBundle.oSN);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.oTj, paramBundle.oSN);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.oTk, paramBundle.oSN);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.oTl, paramBundle.oSN);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.oTm, paramBundle.oSN);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.oTn, paramBundle.oSN);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.oTo, paramBundle.oSN);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.oTp, paramBundle.oSN);
      paramBundle.oTi.setOnClickListener(new e.10(paramBundle));
      paramBundle.oTj.setOnClickListener(new e.11(paramBundle));
      paramBundle.oTk.setOnClickListener(new e.12(paramBundle));
      paramBundle.oTl.setOnClickListener(new e.13(paramBundle));
      paramBundle.oTm.setOnClickListener(new e.2(paramBundle));
      paramBundle.oTn.setOnClickListener(new e.3(paramBundle));
      paramBundle.oTo.setOnClickListener(new e.4(paramBundle));
      paramBundle.oTp.setOnClickListener(new e.5(paramBundle));
      paramBundle.oSS = ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewPadding();
      paramBundle.oTd = this;
      paramBundle.oTe = new com.tencent.mm.plugin.editor.model.nativenote.c.d();
      paramBundle.oTf = new com.tencent.mm.plugin.editor.model.nativenote.c.b();
      paramBundle.mHandler = new ao();
      com.tencent.mm.plugin.editor.model.nativenote.c.e.mHasInit = true;
      ac.i("EditorSelectManager", "onInit end");
      this.oOe = new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(181534);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if (paramAnonymousInt2 > 30)
          {
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().cau();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().cas();
          }
          localObject = com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().can();
          if (((EditorUI.i(EditorUI.this)) || ((EditorUI.j(EditorUI.this) != null) && (EditorUI.j(EditorUI.this).getVisibility() == 0))) && (((com.tencent.mm.plugin.editor.model.nativenote.c.d)localObject).cak() == 2) && (com.tencent.mm.plugin.editor.model.nativenote.c.f.e(paramAnonymousRecyclerView, ((com.tencent.mm.plugin.editor.model.nativenote.c.d)localObject).cUq) == null)) {
            EditorUI.this.bYU();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(181534);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(181533);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bb(paramAnonymousRecyclerView);
          localb.lS(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(181533);
            return;
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().cau();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().cas();
            continue;
            boolean bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().cat();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().ka(bool);
            bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().car();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().jZ(bool);
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().f(false, 50L);
          }
        }
      };
      this.oNS.a(this.oOe);
    }
    bZh();
    AppMethodBeat.o(181555);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(181594);
    super.onDestroy();
    if (this.oOc)
    {
      if (this.oNS != null) {
        this.oNS.b(this.oOe);
      }
      localObject = com.tencent.mm.plugin.editor.model.nativenote.c.e.cal();
      ac.i("EditorSelectManager", "onDestroy");
      com.tencent.mm.plugin.editor.model.nativenote.c.e.mHasInit = false;
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).oTg != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).oTg.stopTimer();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).oTh != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).oTh.stopTimer();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).oSZ != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).oSZ.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).oTa != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).oTa.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).oTb != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).oTb.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).oTc != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).oTc.dismiss();
      }
      com.tencent.mm.plugin.editor.model.nativenote.c.e.oSJ = null;
    }
    if (this.oOb != null)
    {
      localObject = this.oOb;
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.j.oSg == localObject) {
        com.tencent.mm.plugin.editor.model.nativenote.manager.j.oSg = null;
      }
    }
    Object localObject = com.tencent.mm.plugin.editor.widget.voiceview.a.caV();
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).stopPlay();
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).oUL = null;
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).oUK = null;
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).callbacks.clear();
    com.tencent.mm.plugin.editor.widget.voiceview.a.oUF = null;
    if (com.tencent.mm.plugin.editor.model.c.bZw() != null)
    {
      com.tencent.mm.plugin.editor.model.c.bZw();
      com.tencent.mm.plugin.editor.model.c.destroy();
    }
    localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).oQK = null;
    if (((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).ijj != null)
    {
      localObject = ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).ijj.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)((Iterator)localObject).next();
        locala.oQa = null;
        locala.oPY = null;
        locala.oPZ = null;
      }
    }
    AppMethodBeat.o(181594);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(181595);
    super.onDrag();
    if (this.oOc)
    {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().cau();
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().cas();
    }
    if (this.oOg)
    {
      ac.i("MicroMsg.EditorUI", "onSwipeBack close vkb");
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
      this.oOg = bool;
      if (this.oOg) {
        M(1, 0L);
      }
      if (this.oOc) {
        this.jdu.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181532);
            boolean bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().cat();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().ka(bool);
            bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().car();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cal().jZ(bool);
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
    if (this.oNX != null) {
      this.oNX.a(this);
    }
    if (com.tencent.mm.plugin.editor.widget.voiceview.a.caV().caY()) {
      com.tencent.mm.plugin.editor.widget.voiceview.a.caV().stopPlay();
    }
    this.oOl = this.oOg;
    e(false, 0L);
    AppMethodBeat.o(181558);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(181577);
    if (paramArrayOfInt.length <= 0)
    {
      ac.i("MicroMsg.EditorUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(181577);
      return;
    }
    ac.i("MicroMsg.EditorUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(181577);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        bYP();
        AppMethodBeat.o(181577);
        return;
        if ((com.tencent.mm.aw.b.CQ((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null))) && (paramArrayOfInt[0] != 0)) {
          com.tencent.mm.ui.base.h.a(getContext(), getString(2131761869), getString(2131761885), getString(2131760598), getString(2131755691), false, new EditorUI.7(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(181557);
    super.onResume();
    if (this.oOh) {
      switch (this.oOk)
      {
      }
    }
    for (;;)
    {
      this.oOk = -1;
      this.oOj = false;
      if (isSupportNavigationSwipeBack()) {
        getSwipeBackLayout().setEnableGesture(false);
      }
      AppMethodBeat.o(181557);
      return;
      if (this.oOl)
      {
        e(true, 100L);
        M(1, 0L);
        continue;
        if (!this.oOj)
        {
          e(true, 100L);
          M(1, 0L);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI
 * JD-Core Version:    0.7.0.1
 */