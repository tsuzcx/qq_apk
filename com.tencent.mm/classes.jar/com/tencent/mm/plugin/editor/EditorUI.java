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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.g.w;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
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
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class EditorUI
  extends MMActivity
  implements com.tencent.mm.plugin.editor.model.nativenote.a, com.tencent.mm.plugin.editor.model.nativenote.b.a, d.a
{
  private g.a lPx;
  private MMHandler ntw;
  private float odl;
  private float odm;
  ProgressDialog syZ;
  private boolean uoJ;
  private RecyclerView uoK;
  private com.tencent.mm.plugin.editor.adapter.b uoL;
  private CollectEditorLinearLayoutManager uoM;
  private EditorUI.a uoN;
  private LinearLayout uoO;
  com.tencent.mm.plugin.editor.widget.a uoP;
  private LinearLayout uoQ;
  private RelativeLayout uoR;
  private com.tencent.mm.plugin.editor.model.nativenote.manager.d uoS;
  private com.tencent.mm.plugin.editor.model.nativenote.manager.j uoT;
  private boolean uoU;
  private int uoV;
  private RecyclerView.l uoW;
  private boolean uoX;
  private boolean uoY;
  private boolean uoZ;
  private String upa;
  private boolean upb;
  private int upc;
  private boolean upd;
  private anm upe;
  View.OnTouchListener upf;
  com.tencent.mm.plugin.fav.a.g upg;
  LinkedList<anm> uph;
  private ConcurrentHashMap<String, com.tencent.mm.plugin.fav.a.c> upi;
  private ConcurrentHashMap<String, anm> upj;
  
  public EditorUI()
  {
    AppMethodBeat.i(181554);
    this.uoJ = false;
    this.uoU = true;
    this.upc = -1;
    this.upf = new View.OnTouchListener()
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
        if ((paramAnonymousMotionEvent.getAction() == 1) && (EditorUI.h(EditorUI.this).h(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()) == null))
        {
          f1 = Math.abs(EditorUI.n(EditorUI.this) - paramAnonymousMotionEvent.getX());
          f2 = Math.abs(EditorUI.o(EditorUI.this) - paramAnonymousMotionEvent.getY());
          if ((f1 < 30.0F) && (f2 < 30.0F))
          {
            if (EditorUI.b(EditorUI.this).getVisibility() == 8) {
              break label170;
            }
            if (EditorUI.a(EditorUI.this) != null) {
              EditorUI.a(EditorUI.this).usB.dismiss();
            }
            EditorUI.b(EditorUI.this).setVisibility(8);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(181531);
          return false;
          label170:
          int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().size();
          paramAnonymousView = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().Jd(i - 1);
          if (paramAnonymousView != null)
          {
            boolean bool = paramAnonymousView.urG;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cRW();
            paramAnonymousView.urG = true;
            paramAnonymousView.urM = false;
            paramAnonymousView.urI = -1;
            EditorUI.g(EditorUI.this).cL(i - 1);
            EditorUI.this.e(true, 50L);
            EditorUI.this.Q(1, 0L);
            if ((EditorUI.p(EditorUI.this)) && (bool))
            {
              EditorUI.q(EditorUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181530);
                  com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().mz(true);
                  com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().my(true);
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
                    if (com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().getSelectType() == 1)
                    {
                      EditorUI.this.cRi();
                      com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSE();
                    }
                  }
                  else if (!EditorUI.r(EditorUI.this)) {
                    EditorUI.this.cRi();
                  }
                }
              }
            }
          }
        }
      }
    };
    this.uph = new LinkedList();
    this.upi = new ConcurrentHashMap();
    this.upj = new ConcurrentHashMap();
    this.lPx = new EditorUI.19(this);
    AppMethodBeat.o(181554);
  }
  
  private void S(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(181560);
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().fT(0, paramArrayList.size()))
    {
      cRc();
      AppMethodBeat.o(181560);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(d.h.app_tip);
    this.syZ = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(d.h.app_waiting), true, new EditorUI.22(this));
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
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
          localh.urU = true;
          localh.type = 2;
          localh.urT = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cRZ();
          localh.fEa = com.tencent.mm.plugin.editor.model.b.atK(localh.toString());
          EditorUI.a(EditorUI.this, new anm());
          EditorUI.e(EditorUI.this).bsK(localh.fEa);
          localh.urR = b.fX(str, com.tencent.mm.plugin.editor.model.b.b(EditorUI.e(EditorUI.this)));
          localh.fNU = b.fY(localh.urR, com.tencent.mm.plugin.editor.model.b.a(EditorUI.e(EditorUI.this)));
          localArrayList.add(localh);
          i += 1;
        }
        if ((EditorUI.c(EditorUI.this) != null) && (EditorUI.c(EditorUI.this).isShowing()))
        {
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().a(localArrayList, EditorUI.f(EditorUI.this).cSv(), true, false, true, false);
          EditorUI.this.e(true, 100L);
          EditorUI.this.Q(1, 0L);
          AppMethodBeat.o(181541);
          return;
        }
        Log.i("MicroMsg.EditorUI", "user canceled");
        AppMethodBeat.o(181541);
      }
    });
    AppMethodBeat.o(181560);
  }
  
  private static int a(com.tencent.mm.plugin.fav.a.c paramc, int paramInt)
  {
    AppMethodBeat.i(181604);
    if (paramc.field_totalLen > 26214400)
    {
      paramInt = com.tencent.mm.i.a.iTZ;
      AppMethodBeat.o(181604);
      return paramInt;
    }
    if ((paramc.field_extFlag & 0x1) == 0)
    {
      AppMethodBeat.o(181604);
      return paramInt;
    }
    Log.w("MicroMsg.EditorUI", "NEED To Exchange Type, defType %d", new Object[] { Integer.valueOf(paramInt) });
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
  
  private com.tencent.mm.plugin.fav.a.c a(anm paramanm, int paramInt)
  {
    AppMethodBeat.i(181603);
    if ((1 == paramInt) && ((Util.isNullOrNil(paramanm.SxP)) || (Util.isNullOrNil(paramanm.Rwb))))
    {
      Log.e("MicroMsg.EditorUI", "getCdnDataInfo, type recv, cdnDataUrl must not be null!");
      AppMethodBeat.o(181603);
      return null;
    }
    if ((paramInt == 0) && (Util.isNullOrNil(com.tencent.mm.plugin.fav.a.b.d(paramanm))))
    {
      Log.e("MicroMsg.EditorUI", "getCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(181603);
      return null;
    }
    com.tencent.mm.plugin.fav.a.c localc = new com.tencent.mm.plugin.fav.a.c();
    localc.field_dataId = paramanm.fEa;
    localc.field_totalLen = ((int)paramanm.Syi);
    localc.field_type = paramInt;
    localc.field_favLocalId = this.upg.field_localId;
    localc.field_cdnKey = paramanm.SxP;
    localc.field_cdnUrl = paramanm.Rwb;
    localc.field_path = com.tencent.mm.plugin.fav.a.b.d(paramanm);
    if (paramanm.dataType == 3) {}
    for (localc.field_dataType = com.tencent.mm.plugin.fav.a.b.azL(paramanm.Syc);; localc.field_dataType = paramanm.dataType)
    {
      localc.field_modifyTime = Util.nowMilliSecond();
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
    Log.i("MicroMsg.EditorUI", "startTransfer, md5:%s", new Object[] { paramc.field_dataId });
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_EditorUI";
    localg.iUG = this.lPx;
    localg.field_mediaId = paramc.field_dataId;
    localg.field_priority = com.tencent.mm.i.a.iTV;
    if (paramc.field_type == 0)
    {
      localg.gbt = true;
      localg.field_needStorage = true;
      localg.field_totalLen = paramc.field_totalLen;
      localg.field_aesKey = paramc.field_cdnKey;
      localg.field_fileId = paramc.field_cdnUrl;
      localg.field_isStreamMedia = paramc.djx();
      localg.field_fullpath = u.n(paramc.field_path, false);
      if (!u.agG(localg.field_fullpath)) {
        Log.e("MicroMsg.EditorUI", "upload, but file not exist, filePath = %s", new Object[] { paramc.field_path });
      }
      if (paramc.djx()) {}
      for (localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
      {
        localg.field_force_aeskeycdn = true;
        localg.field_trysafecdn = false;
        com.tencent.mm.aq.f.bkg().f(localg);
        AppMethodBeat.o(181602);
        return;
      }
    }
    localg.gbt = false;
    localg.field_totalLen = paramc.field_totalLen;
    localg.field_aesKey = paramc.field_cdnKey;
    localg.field_fileId = paramc.field_cdnUrl;
    localg.field_fullpath = (u.n(paramc.field_path, false) + ".temp");
    localg.field_needStorage = true;
    localg.field_isStreamMedia = paramc.djx();
    if (paramc.djx()) {}
    for (localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
    {
      com.tencent.mm.aq.f.bkg().b(localg, -1);
      AppMethodBeat.o(181602);
      return;
    }
  }
  
  private void a(final String paramString1, final l paraml, String paramString2, String paramString3)
  {
    AppMethodBeat.i(181562);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.EditorUI", "video is null");
      AppMethodBeat.o(181562);
      return;
    }
    Log.v("MicroMsg.EditorUI", "compressNoteVideo path: %s", new Object[] { paramString1 });
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    paramString1 = new com.tencent.mm.plugin.editor.model.nativenote.manager.e(localArrayList, paramString2, paramString3, paraml, new e.a()
    {
      public final void a(String paramAnonymousString, l paramAnonymousl)
      {
        AppMethodBeat.i(181542);
        Log.i("MicroMsg.EditorUI", "compressNoteVideo onImportFinish");
        if ((!Util.isNullOrNil(paramAnonymousString)) && (u.agG(paramAnonymousString)) && (paramAnonymousl != null)) {
          paramAnonymousl.thumbPath = paramAnonymousString;
        }
        AppMethodBeat.o(181542);
      }
      
      public final void b(String paramAnonymousString, l paramAnonymousl)
      {
        AppMethodBeat.i(181543);
        Log.i("MicroMsg.EditorUI", "compressNoteVideo onExportFinish");
        if (EditorUI.c(EditorUI.this) != null)
        {
          EditorUI.c(EditorUI.this).dismiss();
          EditorUI.d(EditorUI.this);
        }
        int i;
        if ((!Util.isNullOrNil(paramAnonymousString)) && (u.agG(paramAnonymousString)) && (paramAnonymousl != null) && (!paramAnonymousl.usc))
        {
          q localq = new q(paramAnonymousString);
          long l = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimit(false);
          i = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimitInMB(false);
          if (localq.length() < l)
          {
            paramAnonymousl.fNU = paramAnonymousString;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().a(paramAnonymousl, EditorUI.f(EditorUI.this).cSv(), false, true, false);
          }
        }
        for (;;)
        {
          EditorUI.this.e(true, 100L);
          EditorUI.this.Q(1, 0L);
          AppMethodBeat.o(181543);
          return;
          Toast.makeText(EditorUI.this.getContext(), EditorUI.this.getString(d.h.favorite_too_large_format, new Object[] { Integer.valueOf(i) }), 1).show();
          continue;
          Log.i("MicroMsg.EditorUI", "file not exist or user canceled");
        }
      }
    });
    paramString2 = getContext();
    getString(d.h.app_tip);
    this.syZ = com.tencent.mm.ui.base.h.a(paramString2, getString(d.h.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(181544);
        paramAnonymousDialogInterface = paramString1;
        paramAnonymousDialogInterface.isStop = true;
        paramAnonymousDialogInterface.interrupt();
        paraml.usc = true;
        EditorUI.this.e(true, 100L);
        EditorUI.this.Q(1, 0L);
        AppMethodBeat.o(181544);
      }
    });
    ThreadPool.post(paramString1, "NoteEditor_importVideo");
    AppMethodBeat.o(181562);
  }
  
  /* Error */
  static boolean atA(String paramString)
  {
    // Byte code:
    //   0: ldc_w 488
    //   3: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 490	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: ldc_w 492
    //   14: invokespecial 494	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   34: invokevirtual 498	java/io/RandomAccessFile:read	([BII)I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpne +32 -> 72
    //   43: aload_3
    //   44: invokevirtual 501	java/io/RandomAccessFile:close	()V
    //   47: ldc_w 488
    //   50: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_0
    //   54: ireturn
    //   55: astore_0
    //   56: ldc 235
    //   58: aload_0
    //   59: ldc_w 503
    //   62: iconst_0
    //   63: anewarray 239	java/lang/Object
    //   66: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: goto -22 -> 47
    //   72: aload_3
    //   73: astore_0
    //   74: new 509	java/lang/String
    //   77: dup
    //   78: aload 4
    //   80: invokespecial 512	java/lang/String:<init>	([B)V
    //   83: astore 4
    //   85: aload_3
    //   86: astore_0
    //   87: ldc 235
    //   89: new 436	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 514
    //   96: invokespecial 517	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload 4
    //   101: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 519
    //   107: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 447	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 521	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_3
    //   117: astore_0
    //   118: aload 4
    //   120: ldc_w 523
    //   123: invokevirtual 526	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   126: istore_2
    //   127: aload_3
    //   128: invokevirtual 501	java/io/RandomAccessFile:close	()V
    //   131: ldc_w 488
    //   134: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iload_2
    //   138: ireturn
    //   139: astore_0
    //   140: ldc 235
    //   142: aload_0
    //   143: ldc_w 503
    //   146: iconst_0
    //   147: anewarray 239	java/lang/Object
    //   150: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: goto -22 -> 131
    //   156: astore 4
    //   158: aconst_null
    //   159: astore_3
    //   160: aload_3
    //   161: astore_0
    //   162: ldc 235
    //   164: aload 4
    //   166: ldc_w 503
    //   169: iconst_0
    //   170: anewarray 239	java/lang/Object
    //   173: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_3
    //   177: ifnull +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 501	java/io/RandomAccessFile:close	()V
    //   184: ldc_w 488
    //   187: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: iconst_0
    //   191: ireturn
    //   192: astore_0
    //   193: ldc 235
    //   195: aload_0
    //   196: ldc_w 503
    //   199: iconst_0
    //   200: anewarray 239	java/lang/Object
    //   203: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -22 -> 184
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_0
    //   212: aload_0
    //   213: ifnull +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 501	java/io/RandomAccessFile:close	()V
    //   220: ldc_w 488
    //   223: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_3
    //   227: athrow
    //   228: astore_0
    //   229: ldc 235
    //   231: aload_0
    //   232: ldc_w 503
    //   235: iconst_0
    //   236: anewarray 239	java/lang/Object
    //   239: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private void aty(String paramString)
  {
    AppMethodBeat.i(181561);
    Object localObject = com.tencent.mm.plugin.sight.base.f.aYg(paramString);
    if (localObject == null)
    {
      Log.e("MicroMsg.EditorUI", "mediaInfo is null, videoPath is %s", new Object[] { Util.nullAsNil(paramString) });
      AppMethodBeat.o(181561);
      return;
    }
    int i = ((com.tencent.mm.plugin.sight.base.b)localObject).getVideoDuration();
    localObject = new l();
    ((l)localObject).urU = true;
    ((l)localObject).thumbPath = "";
    ((l)localObject).fNU = "";
    ((l)localObject).duration = i;
    ((l)localObject).type = 6;
    ((l)localObject).urT = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cRZ();
    ((l)localObject).urV = u.asq(paramString);
    ((l)localObject).fEa = com.tencent.mm.plugin.editor.model.b.atK(localObject.toString());
    this.upe = new anm();
    this.upe.bsK(((l)localObject).fEa);
    this.upe.bsH(((l)localObject).urV);
    a(paramString, (l)localObject, com.tencent.mm.plugin.editor.model.b.a(this.upe), com.tencent.mm.plugin.editor.model.b.b(this.upe));
    AppMethodBeat.o(181561);
  }
  
  static boolean atz(String paramString)
  {
    AppMethodBeat.i(181600);
    boolean bool = Util.isNullOrNil(b.atJ(paramString));
    AppMethodBeat.o(181600);
    return bool;
  }
  
  private void cQZ()
  {
    AppMethodBeat.i(181568);
    try
    {
      this.uoL.alc.notifyChanged();
      AppMethodBeat.o(181568);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.EditorUI", localException, "", new Object[0]);
      Log.i("MicroMsg.EditorUI", "onNotifyDataChanged error");
      AppMethodBeat.o(181568);
    }
  }
  
  private boolean cRu()
  {
    AppMethodBeat.i(181598);
    if ((this.uoP != null) && (this.uoP.uwd))
    {
      cRe();
      AppMethodBeat.o(181598);
      return false;
    }
    AppMethodBeat.o(181598);
    return true;
  }
  
  private void cRv()
  {
    AppMethodBeat.i(181607);
    if (this.upa.isEmpty())
    {
      Log.i("MicroMsg.EditorUI", "no need update ui by xml!!! xml is empty.");
      AppMethodBeat.o(181607);
      return;
    }
    Object localObject1 = getContext();
    getString(d.h.app_tip);
    this.syZ = com.tencent.mm.ui.base.h.a((Context)localObject1, getString(d.h.app_waiting), true, new EditorUI.20(this));
    this.upg = com.tencent.mm.plugin.fav.a.b.azP(this.upa);
    if (this.upg != null)
    {
      this.uph.clear();
      this.uph.addAll(this.upg.field_favProto.syG);
      int i = this.uph.size();
      if (i == 0)
      {
        Log.v("MicroMsg.EditorUI", "favItemInfo has no data!!!");
        AppMethodBeat.o(181607);
        return;
      }
      localObject1 = this.upg.field_favProto.syG;
      this.upi.clear();
      this.upj.clear();
      i -= 1;
      if (i >= 0)
      {
        anm localanm = (anm)((List)localObject1).get(i);
        Object localObject2;
        if (!Util.isNullOrNil(localanm.Sye))
        {
          localObject2 = new q(com.tencent.mm.plugin.fav.a.b.d(localanm));
          Log.i("MicroMsg.EditorUI", "dataFile: %s", new Object[] { ((q)localObject2).getName() });
          if (((q)localObject2).ifE()) {
            break label394;
          }
          if ((Util.isNullOrNil(localanm.SxP)) || (Util.isNullOrNil(localanm.Rwb))) {
            Log.e("MicroMsg.EditorUI", "data key or url null!!!");
          }
        }
        else
        {
          label261:
          if (!Util.isNullOrNil(localanm.Kll))
          {
            if (new q(com.tencent.mm.plugin.fav.a.b.a(localanm)).ifE()) {
              break label507;
            }
            if ((!Util.isNullOrNil(localanm.SxK)) && (!Util.isNullOrNil(localanm.lmm))) {
              break label429;
            }
            Log.w("MicroMsg.EditorUI", "thumb key or url null. favId: %d", new Object[] { Integer.valueOf(this.upg.field_id) });
          }
        }
        for (;;)
        {
          i -= 1;
          break;
          Log.d("MicroMsg.EditorUI", "local data not exist, gen cdnInfo.");
          localObject2 = a(localanm, 1);
          this.upi.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localObject2);
          this.upj.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localanm);
          a((com.tencent.mm.plugin.fav.a.c)localObject2);
          break label261;
          label394:
          Log.d("MicroMsg.EditorUI", "file exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.upg.field_id), Integer.valueOf(i) });
          break label261;
          label429:
          Log.d("MicroMsg.EditorUI", "local thumb not exist, insert cdnInfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.upg.field_id), Integer.valueOf(i) });
          localObject2 = a(localanm, 1);
          this.upi.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localObject2);
          this.upj.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localanm);
          a((com.tencent.mm.plugin.fav.a.c)localObject2);
          continue;
          label507:
          Log.d("MicroMsg.EditorUI", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.upg.field_id), Integer.valueOf(i) });
        }
      }
      cRw();
    }
    AppMethodBeat.o(181607);
  }
  
  private void cRw()
  {
    AppMethodBeat.i(181608);
    if (this.upi.isEmpty())
    {
      Log.i("MicroMsg.EditorUI", "download finish, notifyUpdateUI.");
      Object localObject1 = cRx();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.EditorUI", "weNoteWrapData is null!!!");
        AppMethodBeat.o(181608);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cRU();
      localObject1 = ((com.tencent.mm.plugin.editor.model.a.g)localObject1).usa.iterator();
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
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 1: 
          localObject2 = (com.tencent.mm.plugin.editor.model.a.j)localObject2;
          if (Util.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content)) {
            ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = "";
          }
          ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = a.atx(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content);
          if (((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.length() > 100) {
            com.tencent.mm.plugin.editor.model.nativenote.a.a.atL(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content);
          }
          for (;;)
          {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
            break;
            if (b.atI(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content)) {
              ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.substring(0, ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.length() - 5);
            }
          }
        case 2: 
          localObject2 = (com.tencent.mm.plugin.editor.model.a.h)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 4: 
          localObject2 = (m)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 6: 
          localObject2 = (l)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
        }
      }
      cQZ();
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cRZ();
      if (this.syZ != null)
      {
        this.syZ.dismiss();
        this.syZ = null;
      }
    }
    AppMethodBeat.o(181608);
  }
  
  private com.tencent.mm.plugin.editor.model.a.g cRx()
  {
    AppMethodBeat.i(181609);
    com.tencent.mm.plugin.editor.model.a.g localg = new com.tencent.mm.plugin.editor.model.a.g();
    Iterator localIterator = this.uph.iterator();
    Object localObject1 = null;
    Object localObject4;
    Object localObject5;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject4 = (anm)localIterator.next();
      localObject5 = new com.tencent.mm.plugin.editor.model.a.d();
      ((com.tencent.mm.plugin.editor.model.a.d)localObject5).urT = ((anm)localObject4).SyO;
      if (((anm)localObject4).dataType == 1) {
        ((com.tencent.mm.plugin.editor.model.a.d)localObject5).urT = "-1";
      }
      if (Util.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.d)localObject5).urT))
      {
        Log.e("MicroMsg.EditorUI", "noteItemData.localEditorId is null or nil.");
        AppMethodBeat.o(181609);
        return null;
      }
      if (((com.tencent.mm.plugin.editor.model.a.d)localObject5).urT.equals("WeNoteHtmlFile"))
      {
        localObject2 = com.tencent.mm.plugin.fav.a.b.d((anm)localObject4);
        if ((Util.isNullOrNil((String)localObject2)) || (!u.agG((String)localObject2))) {
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
            localg.urZ = u.bBS((String)localObject2);
            localObject2 = b.atG(localg.urZ);
            localObject1 = localObject2;
            try
            {
              Log.i("MicroMsg.EditorUI", "local html file exist, dataId: %s", new Object[] { ((anm)localObject4).fEa });
              Log.i("MicroMsg.EditorUI", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(Util.isNullOrNil(((anm)localObject4).Rwb)), Boolean.valueOf(Util.isNullOrNil(((anm)localObject4).SxP)) });
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
        Log.printErrStackTrace("MicroMsg.EditorUI", localException1, "", new Object[0]);
        continue;
        ((com.tencent.mm.plugin.editor.model.a.d)localObject5).fEa = ((anm)localObject4).fEa;
        switch (((anm)localObject4).dataType)
        {
        default: 
          break;
        case 1: 
          if (Util.isNullOrNil(((anm)localObject4).desc)) {
            break;
          }
          if ((localg.usa.size() > 0) && (localg.usa.get(localg.usa.size() - 1) != null) && (((com.tencent.mm.plugin.editor.model.a.d)localg.usa.get(localg.usa.size() - 1)).urT.equals("-1")))
          {
            localObject3 = (com.tencent.mm.plugin.editor.model.a.e)localg.usa.get(localg.usa.size() - 1);
            ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content = ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content.concat(((anm)localObject4).desc);
            break;
          }
          localObject3 = new com.tencent.mm.plugin.editor.model.a.j();
          ((com.tencent.mm.plugin.editor.model.a.e)localObject3).urT = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).urT;
          ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content = ((anm)localObject4).desc;
          localg.usa.add(localObject3);
          break;
        case 2: 
          localObject3 = new com.tencent.mm.plugin.editor.model.a.h();
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).urT = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).urT;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).type = 2;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).fEa = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).fEa;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).urS = ((anm)localObject4);
          localObject5 = com.tencent.mm.plugin.fav.a.b.d((anm)localObject4);
          if (Util.isNullOrNil((String)localObject5)) {
            break;
          }
          localObject6 = (String)localObject5 + "_bigthumb";
          u.agG(com.tencent.mm.plugin.fav.a.b.a((anm)localObject4));
          if (u.agG((String)localObject5))
          {
            ((com.tencent.mm.plugin.editor.model.a.c)localObject3).urU = true;
            b.fY((String)localObject5, (String)localObject6);
          }
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).fNU = ((String)localObject6);
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).urR = ((String)localObject5);
          localg.usa.add(localObject3);
          break;
        case 3: 
          localObject3 = new m();
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).urT = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).urT;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).type = 4;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).fEa = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).fEa;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).urS = ((anm)localObject4);
          localObject5 = com.tencent.mm.plugin.fav.a.b.d((anm)localObject4);
          if ((!Util.isNullOrNil((String)localObject5)) && (u.agG((String)localObject5)))
          {
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).urU = true;
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).oYm = com.tencent.mm.plugin.editor.model.a.urk;
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).length = ((int)com.tencent.mm.plugin.editor.model.b.GW(((anm)localObject4).duration));
          }
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).fNU = ((String)localObject5);
          localObject5 = getContext();
          int i = (int)com.tencent.mm.plugin.editor.model.b.GW(((anm)localObject4).duration);
          localObject6 = new hi();
          ((hi)localObject6).fEb.type = 21;
          ((hi)localObject6).fEb.context = ((Context)localObject5);
          ((hi)localObject6).fEb.fEj = i;
          EventCenter.instance.publish((IEvent)localObject6);
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).urX = ((hi)localObject6).fEc.path;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).fEj = ((anm)localObject4).duration;
          localObject5 = new hi();
          ((hi)localObject5).fEb.type = 17;
          ((hi)localObject5).fEb.fEd = ((anm)localObject4);
          EventCenter.instance.publish((IEvent)localObject5);
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).fEi = ((hi)localObject5).fEc.ret;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).urV = ((anm)localObject4).Syc;
          localg.usa.add(localObject3);
          break;
        case 4: 
          localObject3 = new l();
          ((l)localObject3).urT = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).urT;
          ((l)localObject3).type = 6;
          ((l)localObject3).fEa = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).fEa;
          ((l)localObject3).urS = ((anm)localObject4);
          ((l)localObject3).duration = ((anm)localObject4).duration;
          ((l)localObject3).thumbPath = com.tencent.mm.plugin.fav.a.b.a((anm)localObject4);
          localObject4 = com.tencent.mm.plugin.fav.a.b.d((anm)localObject4);
          ((l)localObject3).fNU = ((String)localObject4);
          if ((!Util.isNullOrNil(((l)localObject3).thumbPath)) && (!u.agG(((l)localObject3).thumbPath)) && (u.agG((String)localObject4)))
          {
            localObject5 = com.tencent.mm.plugin.fav.ui.e.aAn((String)localObject4);
            if (localObject5 == null) {}
          }
          try
          {
            Log.i("MicroMsg.EditorUI", "add fav service: create thumbPath bitmap, saveBitmapToImage ");
            BitmapUtil.saveBitmapToImage((Bitmap)localObject5, 60, Bitmap.CompressFormat.JPEG, ((l)localObject3).thumbPath, true);
            if ((!Util.isNullOrNil((String)localObject4)) && (u.agG((String)localObject4))) {
              ((l)localObject3).urU = true;
            }
            localg.usa.add(localObject3);
          }
          catch (Exception localException3)
          {
            Log.printErrStackTrace("MicroMsg.EditorUI", localException3, "", new Object[0]);
          }
        }
      }
      if ((localObject1 != null) && (localObject1.size() > 0)) {
        com.tencent.mm.plugin.editor.model.b.a(localg.usa, localObject1);
      }
      AppMethodBeat.o(181609);
      return localg;
    }
  }
  
  private void cRy()
  {
    AppMethodBeat.i(181610);
    if (Util.isNullOrNil(b.atJ(com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cSb())))
    {
      if (this.uoJ)
      {
        this.uoJ = false;
        enableOptionMenu(0, false);
        AppMethodBeat.o(181610);
      }
    }
    else if (!this.uoJ)
    {
      this.uoJ = true;
      enableOptionMenu(0, true);
    }
    AppMethodBeat.o(181610);
  }
  
  /* Error */
  static boolean fW(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 997
    //   3: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 1001	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_1
    //   12: invokestatic 1005	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   15: astore_1
    //   16: aload_1
    //   17: astore 6
    //   19: aload_0
    //   20: astore 5
    //   22: sipush 16384
    //   25: newarray byte
    //   27: astore 7
    //   29: aload_1
    //   30: astore 6
    //   32: aload_0
    //   33: astore 5
    //   35: aload_1
    //   36: ldc_w 523
    //   39: invokevirtual 1009	java/lang/String:getBytes	()[B
    //   42: invokevirtual 1014	java/io/OutputStream:write	([B)V
    //   45: aload_1
    //   46: astore 6
    //   48: aload_0
    //   49: astore 5
    //   51: aload_0
    //   52: aload 7
    //   54: invokevirtual 1019	java/io/InputStream:read	([B)I
    //   57: istore_2
    //   58: iload_2
    //   59: iconst_m1
    //   60: if_icmpeq +68 -> 128
    //   63: aload_1
    //   64: astore 6
    //   66: aload_0
    //   67: astore 5
    //   69: aload_1
    //   70: aload 7
    //   72: iconst_0
    //   73: iload_2
    //   74: invokevirtual 1022	java/io/OutputStream:write	([BII)V
    //   77: goto -32 -> 45
    //   80: astore 7
    //   82: aload_1
    //   83: astore 6
    //   85: aload_0
    //   86: astore 5
    //   88: ldc 235
    //   90: aload 7
    //   92: ldc_w 503
    //   95: iconst_0
    //   96: anewarray 239	java/lang/Object
    //   99: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_0
    //   103: ifnull +7 -> 110
    //   106: aload_0
    //   107: invokevirtual 1023	java/io/InputStream:close	()V
    //   110: aload_1
    //   111: ifnull +221 -> 332
    //   114: aload_1
    //   115: invokevirtual 1024	java/io/OutputStream:close	()V
    //   118: iconst_0
    //   119: istore_3
    //   120: ldc_w 997
    //   123: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iload_3
    //   127: ireturn
    //   128: iconst_1
    //   129: istore_3
    //   130: iload_3
    //   131: istore 4
    //   133: aload_0
    //   134: ifnull +10 -> 144
    //   137: aload_0
    //   138: invokevirtual 1023	java/io/InputStream:close	()V
    //   141: iload_3
    //   142: istore 4
    //   144: iload 4
    //   146: istore_3
    //   147: aload_1
    //   148: ifnull -28 -> 120
    //   151: aload_1
    //   152: invokevirtual 1024	java/io/OutputStream:close	()V
    //   155: iload 4
    //   157: istore_3
    //   158: goto -38 -> 120
    //   161: astore_0
    //   162: ldc 235
    //   164: aload_0
    //   165: ldc_w 503
    //   168: iconst_0
    //   169: anewarray 239	java/lang/Object
    //   172: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: iconst_0
    //   176: istore_3
    //   177: goto -57 -> 120
    //   180: astore_0
    //   181: ldc 235
    //   183: aload_0
    //   184: ldc_w 503
    //   187: iconst_0
    //   188: anewarray 239	java/lang/Object
    //   191: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: iconst_0
    //   195: istore 4
    //   197: goto -53 -> 144
    //   200: astore_0
    //   201: ldc 235
    //   203: aload_0
    //   204: ldc_w 503
    //   207: iconst_0
    //   208: anewarray 239	java/lang/Object
    //   211: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: goto -104 -> 110
    //   217: astore_0
    //   218: ldc 235
    //   220: aload_0
    //   221: ldc_w 503
    //   224: iconst_0
    //   225: anewarray 239	java/lang/Object
    //   228: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: iconst_0
    //   232: istore_3
    //   233: goto -113 -> 120
    //   236: astore_1
    //   237: aconst_null
    //   238: astore 6
    //   240: aconst_null
    //   241: astore_0
    //   242: aload_0
    //   243: ifnull +7 -> 250
    //   246: aload_0
    //   247: invokevirtual 1023	java/io/InputStream:close	()V
    //   250: aload 6
    //   252: ifnull +8 -> 260
    //   255: aload 6
    //   257: invokevirtual 1024	java/io/OutputStream:close	()V
    //   260: ldc_w 997
    //   263: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_1
    //   267: athrow
    //   268: astore_0
    //   269: ldc 235
    //   271: aload_0
    //   272: ldc_w 503
    //   275: iconst_0
    //   276: anewarray 239	java/lang/Object
    //   279: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: goto -32 -> 250
    //   285: astore_0
    //   286: ldc 235
    //   288: aload_0
    //   289: ldc_w 503
    //   292: iconst_0
    //   293: anewarray 239	java/lang/Object
    //   296: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: goto -39 -> 260
    //   302: astore_1
    //   303: aconst_null
    //   304: astore 6
    //   306: goto -64 -> 242
    //   309: astore_1
    //   310: aload 5
    //   312: astore_0
    //   313: goto -71 -> 242
    //   316: astore 7
    //   318: aconst_null
    //   319: astore_1
    //   320: aconst_null
    //   321: astore_0
    //   322: goto -240 -> 82
    //   325: astore 7
    //   327: aconst_null
    //   328: astore_1
    //   329: goto -247 -> 82
    //   332: iconst_0
    //   333: istore_3
    //   334: goto -214 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	paramString1	String
    //   0	337	1	paramString2	String
    //   57	17	2	i	int
    //   119	215	3	bool1	boolean
    //   131	65	4	bool2	boolean
    //   20	291	5	str1	String
    //   17	288	6	str2	String
    //   27	44	7	arrayOfByte	byte[]
    //   80	11	7	localException1	Exception
    //   316	1	7	localException2	Exception
    //   325	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   22	29	80	java/lang/Exception
    //   35	45	80	java/lang/Exception
    //   51	58	80	java/lang/Exception
    //   69	77	80	java/lang/Exception
    //   151	155	161	java/io/IOException
    //   137	141	180	java/io/IOException
    //   106	110	200	java/io/IOException
    //   114	118	217	java/io/IOException
    //   6	11	236	finally
    //   246	250	268	java/io/IOException
    //   255	260	285	java/io/IOException
    //   11	16	302	finally
    //   22	29	309	finally
    //   35	45	309	finally
    //   51	58	309	finally
    //   69	77	309	finally
    //   88	102	309	finally
    //   6	11	316	java/lang/Exception
    //   11	16	325	java/lang/Exception
  }
  
  public final void IY(final int paramInt)
  {
    AppMethodBeat.i(181564);
    this.ntw.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181545);
        Log.i("MicroMsg.EditorUI", "huahuastart: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        EditorUI.g(EditorUI.this).cL(paramInt);
        Log.i("MicroMsg.EditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(181545);
      }
    }, 0L);
    AppMethodBeat.o(181564);
  }
  
  public final void IZ(int paramInt)
  {
    AppMethodBeat.i(181565);
    try
    {
      this.uoL.cM(paramInt);
      AppMethodBeat.o(181565);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.EditorUI", localException, "", new Object[0]);
      Log.e("MicroMsg.EditorUI", "onNotifyItemInserted error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(181565);
    }
  }
  
  public final void Ja(int paramInt)
  {
    AppMethodBeat.i(181567);
    try
    {
      this.uoL.cN(paramInt);
      AppMethodBeat.o(181567);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.EditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(181567);
    }
  }
  
  public final void Jb(int paramInt)
  {
    AppMethodBeat.i(181573);
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().size()))
    {
      AppMethodBeat.o(181573);
      return;
    }
    this.ntw.post(new EditorUI.2(this, paramInt));
    AppMethodBeat.o(181573);
  }
  
  public final void Q(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(181579);
    if (!this.uoZ)
    {
      AppMethodBeat.o(181579);
      return;
    }
    this.ntw.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181525);
        ImageButton localImageButton = (ImageButton)EditorUI.j(EditorUI.this).findViewById(d.e.upE);
        View localView = EditorUI.j(EditorUI.this).findViewById(d.e.upF);
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(181525);
          return;
          EditorUI.k(EditorUI.this).setVisibility(8);
          if (!EditorUI.l(EditorUI.this).uwd)
          {
            EditorUI.j(EditorUI.this).setVisibility(8);
            AppMethodBeat.o(181525);
            return;
          }
          EditorUI.j(EditorUI.this).setVisibility(0);
          AppMethodBeat.o(181525);
          return;
          localImageButton.setImageResource(d.g.editor_style_unpress);
          localView.setVisibility(8);
          EditorUI.j(EditorUI.this).setVisibility(0);
          EditorUI.k(EditorUI.this).setVisibility(8);
          AppMethodBeat.o(181525);
          return;
          EditorUI.j(EditorUI.this).setVisibility(0);
          EditorUI.k(EditorUI.this).setVisibility(8);
          AppMethodBeat.o(181525);
          return;
          localImageButton.setImageResource(d.g.editor_style_press);
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
      if ((com.tencent.mm.plugin.editor.model.nativenote.manager.b.mXB == null) || (com.tencent.mm.plugin.editor.model.nativenote.manager.b.mXB.size() <= 0)) {
        break label38;
      }
    }
    label38:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(181571);
      return;
    }
    ArrayList localArrayList = com.tencent.mm.plugin.editor.model.nativenote.manager.b.cRP();
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().U(localArrayList))
    {
      cRc();
      AppMethodBeat.o(181571);
      return;
    }
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().a(localArrayList, paramWXRTEditText, true, true, false, false);
    i = paramWXRTEditText.getRecyclerItemPosition();
    int j = localArrayList.size();
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().fU(i, j + i + 1);
    cRi();
    if (this.uoU) {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSE();
    }
    AppMethodBeat.o(181571);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(181563);
    if (!this.uoZ)
    {
      AppMethodBeat.o(181563);
      return;
    }
    Log.d("MicroMsg.EditorUI", "onFocusChanged, poi: %s, focus: %s, editor: %s.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramWXRTEditText });
    CollectEditorLinearLayoutManager localCollectEditorLinearLayoutManager = (CollectEditorLinearLayoutManager)this.uoK.getLayoutManager();
    if (localCollectEditorLinearLayoutManager != null)
    {
      if (this.uoX) {
        localCollectEditorLinearLayoutManager.uqn = false;
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
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().ag(paramInt, true);
    }
    for (;;)
    {
      cRy();
      AppMethodBeat.o(181563);
      return;
      localCollectEditorLinearLayoutManager.uqn = paramBoolean;
      break;
      label124:
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().ag(paramInt, false);
      continue;
      label135:
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().af(-1, false);
    }
  }
  
  final void a(anm paramanm, EditorUI.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(181601);
    Object localObject1;
    if (Util.isNullOrNil(paramanm.SxP))
    {
      com.tencent.mm.aq.f.bkh();
      localObject1 = com.tencent.mm.aq.a.bjV();
      paramanm.bsC((String)localObject1);
      Log.i("MicroMsg.EditorUI", "local not exist cdn data key, generate %s", new Object[] { localObject1 });
    }
    if (EditorUI.b.upr == paramb) {
      localObject1 = a(paramanm, 0);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        this.upi.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, localObject1);
        this.upj.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, paramanm);
        a((com.tencent.mm.plugin.fav.a.c)localObject1);
      }
      AppMethodBeat.o(181601);
      return;
      localObject1 = localObject2;
      if (EditorUI.b.upq == paramb) {
        if (Util.isNullOrNil(com.tencent.mm.plugin.fav.a.b.a(paramanm)))
        {
          Log.e("MicroMsg.EditorUI", "insertCdnThumbInfo, type send, path must not be null!");
          localObject1 = localObject2;
        }
        else
        {
          paramb = com.tencent.mm.plugin.fav.a.b.azJ(paramanm.fEa);
          localObject1 = new com.tencent.mm.plugin.fav.a.c();
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey = paramanm.SxK;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl = paramanm.lmm;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId = paramb;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_favLocalId = this.upg.field_localId;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen = ((int)paramanm.Sys);
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_type = 0;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 1;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path = com.tencent.mm.plugin.fav.a.b.a(paramanm);
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_modifyTime = Util.nowMilliSecond();
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_attrFlag |= 1L;
        }
      }
    }
  }
  
  public final void cRa()
  {
    AppMethodBeat.i(181570);
    if (!this.uoP.uwd)
    {
      cRi();
      final AppCompatActivity localAppCompatActivity = getContext();
      this.ntw.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(181546);
          int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().size();
          int j = EditorUI.h(EditorUI.this).getChildCount();
          Object localObject;
          if (i == j)
          {
            float f1 = 0.0F;
            i = j - 1;
            if (i >= 0)
            {
              localObject = EditorUI.h(EditorUI.this).getChildAt(i);
              float f2 = w.N((View)localObject);
              if (f1 > ((View)localObject).getBottom() + f2) {}
              for (;;)
              {
                i -= 1;
                break;
                f1 = ((View)localObject).getBottom() + f2;
              }
            }
            if ((f1 < com.tencent.mm.compatible.util.i.getScreenWH(localAppCompatActivity)[1]) && (f1 > 0.0F))
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
            ((com.tencent.mm.plugin.editor.model.nativenote.manager.d)localObject).usB.showAtLocation(((com.tencent.mm.plugin.editor.model.nativenote.manager.d)localObject).mParentView, 49, 0, arrayOfInt[1] + 50);
          }
          AppMethodBeat.o(181546);
        }
      }, 400L);
    }
    AppMethodBeat.o(181570);
  }
  
  public final void cRb()
  {
    AppMethodBeat.i(181574);
    this.ntw.post(new EditorUI.3(this));
    AppMethodBeat.o(181574);
  }
  
  public final void cRc()
  {
    AppMethodBeat.i(181575);
    cRi();
    if (this.uoU) {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSE();
    }
    this.ntw.postDelayed(new EditorUI.4(this), 100L);
    AppMethodBeat.o(181575);
  }
  
  public final void cRd()
  {
    AppMethodBeat.i(181576);
    com.tencent.mm.ui.base.h.a(this, getString(d.h.permission_microphone_request_again_msg), getString(d.h.permission_tips_title), getString(d.h.jump_to_settings), getString(d.h.app_cancel), false, new EditorUI.5(this), new EditorUI.6(this));
    AppMethodBeat.o(181576);
  }
  
  public final void cRe()
  {
    AppMethodBeat.i(181580);
    com.tencent.mm.ui.base.h.c(getContext(), getString(d.h.uqf), null, true);
    AppMethodBeat.o(181580);
  }
  
  public final void cRf()
  {
    AppMethodBeat.i(181581);
    if (this.uoP != null) {
      this.uoP.a(null);
    }
    AppMethodBeat.o(181581);
  }
  
  public final void cRg()
  {
    AppMethodBeat.i(181582);
    com.tencent.mm.ui.base.h.c(this, getString(d.h.upY), "", getString(d.h.upX), getString(d.h.upW), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(181526);
        com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSO();
        AppMethodBeat.o(181526);
      }
    }, null);
    AppMethodBeat.o(181582);
  }
  
  public final void cRh()
  {
    AppMethodBeat.i(181583);
    Toast.makeText(getContext(), getString(d.h.upZ), 0).show();
    AppMethodBeat.o(181583);
  }
  
  public final void cRi()
  {
    AppMethodBeat.i(181584);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cRV();
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().Jd(i);
    if (locala != null)
    {
      locala.urG = false;
      locala.urM = false;
      IY(i);
    }
    this.ntw.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181528);
        WXRTEditText localWXRTEditText = EditorUI.f(EditorUI.this).cSt();
        if (localWXRTEditText != null) {
          localWXRTEditText.clearFocus();
        }
        AppMethodBeat.o(181528);
      }
    });
    e(false, 0L);
    Q(0, 0L);
    AppMethodBeat.o(181584);
  }
  
  public final int cRj()
  {
    AppMethodBeat.i(181585);
    if (this.uoY)
    {
      int i = com.tencent.mm.compatible.util.i.getKeyBordHeightPx(this);
      AppMethodBeat.o(181585);
      return i;
    }
    AppMethodBeat.o(181585);
    return 0;
  }
  
  public final int cRk()
  {
    AppMethodBeat.i(181586);
    int j = 0;
    int i = j;
    if (this.uoO != null)
    {
      i = j;
      if (this.uoO.getVisibility() == 0) {
        i = this.uoV + 0;
      }
    }
    j = i;
    if (this.uoQ != null)
    {
      j = i;
      if (this.uoQ.getVisibility() == 0) {
        j = i + this.uoV;
      }
    }
    AppMethodBeat.o(181586);
    return j;
  }
  
  public final boolean cRl()
  {
    AppMethodBeat.i(181587);
    if ((this.uoT != null) && (this.uoT.cSt() != null))
    {
      AppMethodBeat.o(181587);
      return true;
    }
    AppMethodBeat.o(181587);
    return false;
  }
  
  public final RecyclerView cRm()
  {
    return this.uoK;
  }
  
  public final RecyclerView cRn()
  {
    return this.uoK;
  }
  
  public final Context cRo()
  {
    AppMethodBeat.i(181588);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(181588);
    return localAppCompatActivity;
  }
  
  public final com.tencent.mm.plugin.editor.model.nativenote.b.a cRp()
  {
    return this;
  }
  
  public final void cRq()
  {
    AppMethodBeat.i(181589);
    com.tencent.mm.plugin.editor.model.a.j localj = new com.tencent.mm.plugin.editor.model.a.j();
    localj.content = "";
    localj.urG = true;
    localj.urM = false;
    localj.urI = 0;
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cRU();
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().e(localj);
    cQZ();
    e(true, 50L);
    Q(1, 0L);
    AppMethodBeat.o(181589);
  }
  
  public final void cRr()
  {
    AppMethodBeat.i(181590);
    com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(getContext(), com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cSc());
    AppMethodBeat.o(181590);
  }
  
  public final void cRs()
  {
    AppMethodBeat.i(181591);
    com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(getContext(), com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cSc());
    cRq();
    AppMethodBeat.o(181591);
  }
  
  public final void cRt()
  {
    AppMethodBeat.i(181592);
    getContext();
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.b.cRS();
    Object localObject;
    if (i == 2)
    {
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.cRR())
      {
        cRc();
        AppMethodBeat.o(181592);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cRU();
      com.tencent.mm.plugin.editor.model.nativenote.manager.b.clearData();
      localObject = new com.tencent.mm.plugin.editor.model.a.j();
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).content = "";
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).urG = false;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).urM = false;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).urI = 0;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).urO = true;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().e((com.tencent.mm.plugin.editor.model.a.a)localObject);
      cQZ();
      AppMethodBeat.o(181592);
      return;
    }
    if (i == 3)
    {
      localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.b.cRP();
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().U((ArrayList)localObject))
      {
        cRc();
        AppMethodBeat.o(181592);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cRU();
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().a((ArrayList)localObject, null, false, false, false, false);
      cRi();
      AppMethodBeat.o(181592);
      return;
    }
    Log.d("MicroMsg.EditorUI", "no data.");
    AppMethodBeat.o(181592);
  }
  
  public final void cRz()
  {
    AppMethodBeat.i(181611);
    cRy();
    AppMethodBeat.o(181611);
  }
  
  public final void e(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181578);
    if (!this.uoZ)
    {
      AppMethodBeat.o(181578);
      return;
    }
    this.ntw.postDelayed(new Runnable()
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
  
  public final void fQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181566);
    try
    {
      this.uoL.aG(paramInt1, paramInt2);
      AppMethodBeat.o(181566);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.EditorUI", localException, "", new Object[0]);
      Log.e("MicroMsg.EditorUI", "onNotifyItemRangeInserted error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(181566);
    }
  }
  
  public final void fR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181569);
    try
    {
      this.uoL.aE(paramInt1, paramInt2);
      AppMethodBeat.o(181569);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.EditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(181569);
    }
  }
  
  public final void fS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181572);
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.uoX = bool;
      AppMethodBeat.o(181572);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return d.f.upS;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(181599);
    if (!cRu())
    {
      AppMethodBeat.o(181599);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(d.h.upV), "", getString(d.h.app_yes), getString(d.h.app_no), true, new DialogInterface.OnClickListener()
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
    setActionbarColor(getContext().getResources().getColor(d.b.white));
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
    addTextOptionMenu(0, getString(d.h.app_save), new EditorUI.21(this), null, w.b.Wao);
    enableOptionMenu(0, this.uoJ);
    getContentView().getRootView().setBackgroundColor(getContext().getResources().getColor(d.b.white));
    this.uoT = new com.tencent.mm.plugin.editor.model.nativenote.manager.j(this);
    this.uoT.utX = this.uoZ;
    this.uoK = ((RecyclerView)findViewById(d.e.upD));
    this.uoO = ((LinearLayout)findViewById(d.e.upC));
    this.uoP = new com.tencent.mm.plugin.editor.widget.a();
    Object localObject = this.uoP;
    LinearLayout localLinearLayout = this.uoO;
    ((com.tencent.mm.plugin.editor.widget.a)localObject).sBm = localLinearLayout;
    com.tencent.mm.plugin.editor.model.nativenote.manager.j.cSu().utW = ((com.tencent.mm.plugin.editor.model.nativenote.b.b)localObject);
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvT = ((WeImageButton)localLinearLayout.findViewById(d.e.upE));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvU = ((WeImageButton)localLinearLayout.findViewById(d.e.upH));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvV = ((WeImageButton)localLinearLayout.findViewById(d.e.upG));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvW = ((WeImageButton)localLinearLayout.findViewById(d.e.upI));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvX = ((LinearLayout)localLinearLayout.findViewById(d.e.upJ));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvY = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).uvX.findViewById(d.e.upO));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvZ = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).uvX.findViewById(d.e.upM));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uwa = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).uvX.findViewById(d.e.upN));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uwb = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).uvX.findViewById(d.e.upK));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uwc = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).uvX.findViewById(d.e.upL));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvT.setOnClickListener(new a.1((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvU.setOnClickListener(new a.5((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uwj = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFJ, true);
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvV.setOnClickListener(new a.6((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvW.setOnClickListener(new a.7((com.tencent.mm.plugin.editor.widget.a)localObject, this, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvY.setOnClickListener(new a.8((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uvZ.setOnClickListener(new a.9((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uwa.setOnClickListener(new a.10((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uwb.setOnClickListener(new a.11((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uwc.setOnClickListener(new a.12((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    this.uoQ = ((LinearLayout)this.uoO.findViewById(d.e.upJ));
    this.uoQ.setVisibility(8);
    this.uoR = ((RelativeLayout)findViewById(d.e.eaY));
    this.uoR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181517);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/EditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (EditorUI.a(EditorUI.this) != null) {
          EditorUI.a(EditorUI.this).usB.dismiss();
        }
        EditorUI.b(EditorUI.this).setVisibility(8);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181517);
      }
    });
    this.uoS = new com.tencent.mm.plugin.editor.model.nativenote.manager.d(this, this.uoR);
    this.uoS.usC = this;
    this.uoM = new CollectEditorLinearLayoutManager();
    this.uoM.uqm = com.tencent.mm.compatible.util.i.getScreenWH(this)[1];
    this.uoK.setLayoutManager(this.uoM);
    this.uoK.setHasFixedSize(true);
    this.uoN = new EditorUI.a(this);
    this.uoK.a(this.uoN);
    this.uoL = new com.tencent.mm.plugin.editor.adapter.b(this.uoT);
    this.uoK.setAdapter(this.uoL);
    if (this.uoZ)
    {
      localObject = new com.tencent.mm.plugin.editor.model.a.j();
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).content = "";
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).urG = true;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).urM = false;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().e((com.tencent.mm.plugin.editor.model.a.a)localObject);
      e(true, 300L);
      Q(1, 0L);
      this.uoK.setOnTouchListener(this.upf);
    }
    for (;;)
    {
      this.uoK.getItemAnimator().alg = 0L;
      this.uoK.getItemAnimator().alj = 0L;
      this.uoK.getItemAnimator().ali = 0L;
      this.uoK.getItemAnimator().alh = 120L;
      ((y)this.uoK.getItemAnimator()).amD = false;
      AppMethodBeat.o(181556);
      return;
      this.uoO.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(181559);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.EditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.upc = paramInt1;
    if (paramInt2 != -1)
    {
      this.upb = false;
      AppMethodBeat.o(181559);
      return;
    }
    this.upb = true;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(181559);
      return;
      Log.i("MicroMsg.EditorUI", "onActivityResult back from gallery");
      Object localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        S((ArrayList)localObject);
      }
      for (;;)
      {
        localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
        String str = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        paramIntent = (Intent)localObject;
        if (!Util.isNullOrNil(str))
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
        if (!com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().fT(0, paramIntent.size())) {
          break;
        }
        cRc();
        AppMethodBeat.o(181559);
        return;
        Log.i("MicroMsg.EditorUI", "no pic selected");
      }
      aty((String)paramIntent.get(0));
      AppMethodBeat.o(181559);
      return;
      label253:
      Log.i("MicroMsg.EditorUI", "no video selected");
      AppMethodBeat.o(181559);
      return;
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      if (paramIntent == null)
      {
        Log.e("MicroMsg.EditorUI", "sight capture result is null!");
        AppMethodBeat.o(181559);
        return;
      }
      localObject = paramIntent.videoPath;
      if (!Util.isNullOrNil((String)localObject)) {
        aty((String)localObject);
      }
      if ((paramIntent.HKM.booleanValue()) && (!Util.isNullOrNil(paramIntent.thumbPath)))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramIntent.thumbPath);
        S((ArrayList)localObject);
        AppMethodBeat.o(181559);
        return;
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          Log.e("MicroMsg.EditorUI", "sight capture result is null!");
          AppMethodBeat.o(181559);
          return;
        }
        localObject = paramIntent.EYb;
        if (!Util.isNullOrNil((String)localObject)) {
          aty((String)localObject);
        }
        if ((paramIntent.EXZ) && (!Util.isNullOrNil(paramIntent.EYh)))
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramIntent.EYh);
          S((ArrayList)localObject);
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
    if (this.uoU)
    {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().mz(false);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().my(false);
    }
    AppMethodBeat.o(181596);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(181555);
    customfixStatusbar(true);
    Object localObject1 = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).mDataList = new ArrayList();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).usv = this;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).usw = new anm();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).usx = 0;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).usy = 0;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).usz = 0;
    super.onCreate(paramBundle);
    this.uoZ = getIntent().getBooleanExtra("KEY_EDITABLE", false);
    this.upa = getIntent().getStringExtra("KEY_CONTENT_XML");
    if (Util.isNullOrNil(this.upa))
    {
      this.upa = "";
      this.uoJ = false;
    }
    Log.i("MicroMsg.EditorUI", "mCollectEditable: %s, mCollectContentXml: %s", new Object[] { Boolean.valueOf(this.uoZ), this.upa });
    this.ntw = new MMHandler();
    initView();
    this.uoV = com.tencent.mm.ci.a.fromDPToPix(this, 48);
    if (this.uoU)
    {
      Log.i("MicroMsg.EditorUI", "use multiselect");
      int i = getResources().getColor(d.b.upv);
      paramBundle = com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy();
      boolean bool = this.uoZ;
      Log.i("EditorSelectManager", "onInit start");
      paramBundle.uuw = bool;
      paramBundle.uuz = 14;
      paramBundle.uuA = 32;
      paramBundle.uuB = (com.tencent.mm.ci.a.fromDPToPix(this, 21) - paramBundle.uuA);
      paramBundle.uuC = (com.tencent.mm.ci.a.fromDPToPix(this, 40) + paramBundle.uuA * 2);
      paramBundle.uuD = (com.tencent.mm.ci.a.fromDPToPix(this, 240) + paramBundle.uuA * 2);
      paramBundle.uux = com.tencent.mm.ci.a.fromDPToPix(this, 22);
      paramBundle.uuy = com.tencent.mm.ci.a.fromDPToPix(this, 1);
      paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
      paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
      paramBundle.uuH = new int[] { -1, -1 };
      paramBundle.uuI = new int[] { -1, -1 };
      paramBundle.uuJ = new int[] { -1, -1 };
      paramBundle.uuK = new int[] { -1, -1 };
      localObject1 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 2, paramBundle.uux, paramBundle.uuy, i, paramBundle);
      paramBundle.uuL = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.uuL.setClippingEnabled(false);
      paramBundle.uuL.setAnimationStyle(d.i.uqj);
      paramBundle.uuF = ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
      paramBundle.uuG = com.tencent.mm.ci.a.fromDPToPix(this, 6);
      Object localObject2 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 3, paramBundle.uux, paramBundle.uuy, i, paramBundle);
      paramBundle.uuM = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.uuM.setClippingEnabled(false);
      paramBundle.uuM.setAnimationStyle(d.i.uqi);
      localObject2 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 4, paramBundle.uux, paramBundle.uuy, i, paramBundle);
      paramBundle.uuN = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.uuN.setClippingEnabled(false);
      paramBundle.uuN.setAnimationStyle(d.i.uqk);
      localObject2 = LayoutInflater.from(this).inflate(d.f.upQ, null);
      ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramBundle.uuO = new PopupWindow((View)localObject2, -2, -2, false);
      paramBundle.uuO.setBackgroundDrawable(getResources().getDrawable(d.d.sub_menu_bg));
      paramBundle.uuO.setClippingEnabled(false);
      paramBundle.uuO.setAnimationStyle(d.i.uql);
      paramBundle.uuU = ((TextView)((View)localObject2).findViewById(d.e.dPH));
      paramBundle.uuV = ((TextView)((View)localObject2).findViewById(d.e.dQg));
      paramBundle.uuW = ((TextView)((View)localObject2).findViewById(d.e.dQd));
      paramBundle.uuX = ((TextView)((View)localObject2).findViewById(d.e.dQc));
      paramBundle.uuY = ((TextView)((View)localObject2).findViewById(d.e.dPR));
      paramBundle.uuZ = ((TextView)((View)localObject2).findViewById(d.e.dPQ));
      paramBundle.uva = ((TextView)((View)localObject2).findViewById(d.e.dPP));
      paramBundle.uvb = ((TextView)((View)localObject2).findViewById(d.e.dPY));
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.uuU, paramBundle.uuz);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.uuV, paramBundle.uuz);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.uuW, paramBundle.uuz);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.uuX, paramBundle.uuz);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.uuY, paramBundle.uuz);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.uuZ, paramBundle.uuz);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.uva, paramBundle.uuz);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.uvb, paramBundle.uuz);
      paramBundle.uuU.setOnClickListener(new e.10(paramBundle));
      paramBundle.uuV.setOnClickListener(new e.11(paramBundle));
      paramBundle.uuW.setOnClickListener(new e.12(paramBundle));
      paramBundle.uuX.setOnClickListener(new e.13(paramBundle));
      paramBundle.uuY.setOnClickListener(new e.2(paramBundle));
      paramBundle.uuZ.setOnClickListener(new e.3(paramBundle));
      paramBundle.uva.setOnClickListener(new e.4(paramBundle));
      paramBundle.uvb.setOnClickListener(new e.5(paramBundle));
      paramBundle.uuE = ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewPadding();
      paramBundle.uuP = this;
      paramBundle.uuQ = new com.tencent.mm.plugin.editor.model.nativenote.c.d();
      paramBundle.uuR = new com.tencent.mm.plugin.editor.model.nativenote.c.b();
      paramBundle.mHandler = new MMHandler();
      com.tencent.mm.plugin.editor.model.nativenote.c.e.mHasInit = true;
      Log.i("EditorSelectManager", "onInit end");
      this.uoW = new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(187742);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/EditorUI$24", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
            AppMethodBeat.o(187742);
            return;
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSI();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSG();
            continue;
            boolean bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSH();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().mz(bool);
            bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSF();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().my(bool);
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().f(false, 50L);
          }
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(187743);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/EditorUI$24", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if (paramAnonymousInt2 > 30)
          {
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSI();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSG();
          }
          localObject = com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSB();
          if (((EditorUI.i(EditorUI.this)) || ((EditorUI.j(EditorUI.this) != null) && (EditorUI.j(EditorUI.this).getVisibility() == 0))) && (((com.tencent.mm.plugin.editor.model.nativenote.c.d)localObject).getSelectType() == 2) && (com.tencent.mm.plugin.editor.model.nativenote.c.f.c(paramAnonymousRecyclerView, ((com.tencent.mm.plugin.editor.model.nativenote.c.d)localObject).bPt) == null)) {
            EditorUI.this.cRi();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(187743);
        }
      };
      this.uoK.a(this.uoW);
    }
    cRv();
    AppMethodBeat.o(181555);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(181594);
    super.onDestroy();
    if (this.uoU)
    {
      if (this.uoK != null) {
        this.uoK.b(this.uoW);
      }
      localObject = com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy();
      Log.i("EditorSelectManager", "onDestroy");
      com.tencent.mm.plugin.editor.model.nativenote.c.e.mHasInit = false;
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).uuS != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).uuS.stopTimer();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).uuT != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).uuT.stopTimer();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).uuL != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).uuL.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).uuM != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).uuM.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).uuN != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).uuN.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).uuO != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).uuO.dismiss();
      }
      com.tencent.mm.plugin.editor.model.nativenote.c.e.uuv = null;
    }
    if (this.uoT != null)
    {
      localObject = this.uoT;
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.j.utS == localObject) {
        com.tencent.mm.plugin.editor.model.nativenote.manager.j.utS = null;
      }
    }
    Object localObject = com.tencent.mm.plugin.editor.widget.voiceview.a.cTi();
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).stopPlay();
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).uww = null;
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).uwv = null;
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).callbacks.clear();
    com.tencent.mm.plugin.editor.widget.voiceview.a.uwq = null;
    if (com.tencent.mm.plugin.editor.model.c.cRK() != null)
    {
      com.tencent.mm.plugin.editor.model.c.cRK();
      com.tencent.mm.plugin.editor.model.c.destroy();
    }
    localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).usv = null;
    if (((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).mDataList != null)
    {
      localObject = ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).mDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)((Iterator)localObject).next();
        locala.urL = null;
        locala.urJ = null;
        locala.urK = null;
      }
    }
    AppMethodBeat.o(181594);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(181595);
    super.onDrag();
    if (this.uoU)
    {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSI();
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSG();
    }
    if (this.uoY)
    {
      Log.i("MicroMsg.EditorUI", "onSwipeBack close vkb");
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
      this.uoY = bool;
      if (this.uoY) {
        Q(1, 0L);
      }
      if (this.uoU) {
        this.ntw.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181532);
            boolean bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSH();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().mz(bool);
            bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().cSF();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cSy().my(bool);
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
    if (this.uoP != null) {
      this.uoP.a(this);
    }
    if (com.tencent.mm.plugin.editor.widget.voiceview.a.cTi().cTl()) {
      com.tencent.mm.plugin.editor.widget.voiceview.a.cTi().stopPlay();
    }
    this.upd = this.uoY;
    e(false, 0L);
    AppMethodBeat.o(181558);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(181577);
    if (paramArrayOfInt.length <= 0)
    {
      Log.i("MicroMsg.EditorUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(181577);
      return;
    }
    Log.i("MicroMsg.EditorUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(181577);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        cRd();
        AppMethodBeat.o(181577);
        return;
        if ((com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null))) && (paramArrayOfInt[0] != 0)) {
          com.tencent.mm.ui.base.h.a(getContext(), getString(d.h.permission_location_request_again_msg), getString(d.h.permission_tips_title), getString(d.h.jump_to_settings), getString(d.h.app_cancel), false, new EditorUI.7(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(181557);
    super.onResume();
    if (this.uoZ) {
      switch (this.upc)
      {
      }
    }
    for (;;)
    {
      this.upc = -1;
      this.upb = false;
      if (isSupportNavigationSwipeBack()) {
        getSwipeBackLayout().setEnableGesture(false);
      }
      AppMethodBeat.o(181557);
      return;
      if (this.upd)
      {
        e(true, 100L);
        Q(1, 0L);
        continue;
        if (!this.upb)
        {
          e(true, 100L);
          Q(1, 0L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI
 * JD-Core Version:    0.7.0.1
 */