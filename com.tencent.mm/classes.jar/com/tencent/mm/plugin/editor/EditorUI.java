package com.tencent.mm.plugin.editor;

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
import androidx.core.g.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.g.g.a;
import com.tencent.mm.plugin.editor.adapter.CollectEditorLinearLayoutManager;
import com.tencent.mm.plugin.editor.model.a.i;
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
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  private g.a osH;
  private MMHandler qse;
  private float rec;
  private float ree;
  ProgressDialog vEG;
  private boolean xvA;
  private arf xvB;
  View.OnTouchListener xvC;
  com.tencent.mm.plugin.fav.a.g xvD;
  LinkedList<arf> xvE;
  private ConcurrentHashMap<String, com.tencent.mm.plugin.fav.a.c> xvF;
  private ConcurrentHashMap<String, arf> xvG;
  private boolean xvg;
  private RecyclerView xvh;
  private com.tencent.mm.plugin.editor.adapter.b xvi;
  private CollectEditorLinearLayoutManager xvj;
  private EditorUI.a xvk;
  private LinearLayout xvl;
  com.tencent.mm.plugin.editor.widget.a xvm;
  private LinearLayout xvn;
  private RelativeLayout xvo;
  private com.tencent.mm.plugin.editor.model.nativenote.manager.d xvp;
  private com.tencent.mm.plugin.editor.model.nativenote.manager.j xvq;
  private boolean xvr;
  private int xvs;
  private RecyclerView.l xvt;
  private boolean xvu;
  private boolean xvv;
  private boolean xvw;
  private String xvx;
  private boolean xvy;
  private int xvz;
  
  public EditorUI()
  {
    AppMethodBeat.i(181554);
    this.xvg = false;
    this.xvr = true;
    this.xvz = -1;
    this.xvC = new View.OnTouchListener()
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
        if ((paramAnonymousMotionEvent.getAction() == 1) && (EditorUI.h(EditorUI.this).Q(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()) == null))
        {
          f1 = Math.abs(EditorUI.n(EditorUI.this) - paramAnonymousMotionEvent.getX());
          f2 = Math.abs(EditorUI.o(EditorUI.this) - paramAnonymousMotionEvent.getY());
          if ((f1 < 30.0F) && (f2 < 30.0F))
          {
            if (EditorUI.b(EditorUI.this).getVisibility() == 8) {
              break label170;
            }
            if (EditorUI.a(EditorUI.this) != null) {
              EditorUI.a(EditorUI.this).xyX.dismiss();
            }
            EditorUI.b(EditorUI.this).setVisibility(8);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(181531);
          return false;
          label170:
          int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().size();
          paramAnonymousView = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().JL(i - 1);
          if (paramAnonymousView != null)
          {
            boolean bool = paramAnonymousView.xyb;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dwp();
            paramAnonymousView.xyb = true;
            paramAnonymousView.xyh = false;
            paramAnonymousView.xyd = -1;
            EditorUI.g(EditorUI.this).fV(i - 1);
            EditorUI.this.g(true, 50L);
            EditorUI.this.U(1, 0L);
            if ((EditorUI.p(EditorUI.this)) && (bool))
            {
              EditorUI.q(EditorUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181530);
                  com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().nV(true);
                  com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().nU(true);
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
                    if (com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().getSelectType() == 1)
                    {
                      EditorUI.this.dvB();
                      com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dwW();
                    }
                  }
                  else if (!EditorUI.r(EditorUI.this)) {
                    EditorUI.this.dvB();
                  }
                }
              }
            }
          }
        }
      }
    };
    this.xvE = new LinkedList();
    this.xvF = new ConcurrentHashMap();
    this.xvG = new ConcurrentHashMap();
    this.osH = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(181537);
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.EditorUI", "transfer err! startRet: %s.", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(181537);
          return 0;
        }
        paramAnonymousc = (com.tencent.mm.plugin.fav.a.c)EditorUI.s(EditorUI.this).get(paramAnonymousString);
        if (paramAnonymousc == null)
        {
          Log.e("MicroMsg.EditorUI", "cdn info is null!!!");
          AppMethodBeat.o(181537);
          return 0;
        }
        arf localarf = (arf)EditorUI.t(EditorUI.this).get(paramAnonymousString);
        if (localarf == null)
        {
          Log.e("MicroMsg.EditorUI", "data item is null!!!");
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
          localarf.bsr(paramAnonymousc.field_cdnKey);
          localarf.bsq(paramAnonymousc.field_cdnUrl);
          label197:
          EditorUI.s(EditorUI.this).remove(paramAnonymousc.field_dataId);
          Log.i("MicroMsg.EditorUI", "transfer done, mediaId=%s completeResult.mediaId=%s aesKey=%s completeInfo=%s", new Object[] { paramAnonymousString, paramAnonymousd.mediaId, paramAnonymousd.field_aesKey, paramAnonymousd.toString() });
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
          if ((paramAnonymousInt == -2) && (!EditorUI.anp(str)) && (EditorUI.gz(str, (String)localObject)))
          {
            Log.i("MicroMsg.EditorUI", "renameAndCopyFile write amr head ok!");
            break;
          }
          u localu = new u(str);
          localObject = new u((String)localObject);
          if (!localu.jKS()) {
            break;
          }
          Log.i("MicroMsg.EditorUI", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(localu.am((u)localObject)), str, localObject });
          break;
          label374:
          paramAnonymousc.field_cdnKey = paramAnonymousd.field_aesKey;
          paramAnonymousc.field_cdnUrl = paramAnonymousd.field_fileId;
          break;
          label395:
          localarf.bst(paramAnonymousc.field_cdnKey);
          localarf.bss(paramAnonymousc.field_cdnUrl);
          if ((paramAnonymousc.field_type != 0) || (!paramAnonymousc.dQi())) {
            break label197;
          }
          Log.i("MicroMsg.EditorUI", "video stream, id:%s", new Object[] { paramAnonymousd.field_videoFileId });
          localarf.bsH(paramAnonymousd.field_videoFileId);
          break label197;
          label462:
          EditorUI.v(EditorUI.this);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    AppMethodBeat.o(181554);
  }
  
  private void W(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(181560);
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().gK(0, paramArrayList.size()))
    {
      dvv();
      AppMethodBeat.o(181560);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(d.h.app_tip);
    this.vEG = com.tencent.mm.ui.base.k.a(localAppCompatActivity, getString(d.h.app_waiting), true, new DialogInterface.OnCancelListener()
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
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
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
          localh.xyp = true;
          localh.type = 2;
          localh.xyo = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dws();
          localh.hIQ = com.tencent.mm.plugin.editor.model.b.anz(localh.toString());
          EditorUI.a(EditorUI.this, new arf());
          EditorUI.e(EditorUI.this).bsB(localh.hIQ);
          localh.xym = b.gA(str, com.tencent.mm.plugin.editor.model.b.b(EditorUI.e(EditorUI.this)));
          localh.hTM = b.gB(localh.xym, com.tencent.mm.plugin.editor.model.b.a(EditorUI.e(EditorUI.this)));
          localArrayList.add(localh);
          i += 1;
        }
        if ((EditorUI.c(EditorUI.this) != null) && (EditorUI.c(EditorUI.this).isShowing()))
        {
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().a(localArrayList, EditorUI.f(EditorUI.this).dwN(), true, false, true, false);
          EditorUI.this.g(true, 100L);
          EditorUI.this.U(1, 0L);
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
      paramInt = com.tencent.mm.g.a.lwe;
      AppMethodBeat.o(181604);
      return paramInt;
    }
    if ((paramc.field_extFlag & 0x1) == 0)
    {
      AppMethodBeat.o(181604);
      return paramInt;
    }
    Log.w("MicroMsg.EditorUI", "NEED To Exchange Type, defType %d", new Object[] { Integer.valueOf(paramInt) });
    if (com.tencent.mm.g.a.MediaType_FAVORITE_VIDEO == paramInt)
    {
      paramInt = com.tencent.mm.g.a.MediaType_FAVORITE_FILE;
      AppMethodBeat.o(181604);
      return paramInt;
    }
    paramInt = com.tencent.mm.g.a.MediaType_FAVORITE_VIDEO;
    AppMethodBeat.o(181604);
    return paramInt;
  }
  
  private com.tencent.mm.plugin.fav.a.c a(arf paramarf, int paramInt)
  {
    AppMethodBeat.i(181603);
    if ((1 == paramInt) && ((Util.isNullOrNil(paramarf.ZyH)) || (Util.isNullOrNil(paramarf.Ysw))))
    {
      Log.e("MicroMsg.EditorUI", "getCdnDataInfo, type recv, cdnDataUrl must not be null!");
      AppMethodBeat.o(181603);
      return null;
    }
    if ((paramInt == 0) && (Util.isNullOrNil(com.tencent.mm.plugin.fav.a.b.d(paramarf))))
    {
      Log.e("MicroMsg.EditorUI", "getCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(181603);
      return null;
    }
    com.tencent.mm.plugin.fav.a.c localc = new com.tencent.mm.plugin.fav.a.c();
    localc.field_dataId = paramarf.hIQ;
    localc.field_totalLen = ((int)paramarf.Zza);
    localc.field_type = paramInt;
    localc.field_favLocalId = this.xvD.field_localId;
    localc.field_cdnKey = paramarf.ZyH;
    localc.field_cdnUrl = paramarf.Ysw;
    localc.field_path = com.tencent.mm.plugin.fav.a.b.d(paramarf);
    if (paramarf.dataType == 3) {}
    for (localc.field_dataType = com.tencent.mm.plugin.fav.a.b.atR(paramarf.ZyU);; localc.field_dataType = paramarf.dataType)
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
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.taskName = "task_EditorUI";
    localg.lwL = this.osH;
    localg.field_mediaId = paramc.field_dataId;
    localg.field_priority = com.tencent.mm.g.a.lwa;
    if (paramc.field_type == 0)
    {
      localg.ihD = true;
      localg.field_needStorage = true;
      localg.field_totalLen = paramc.field_totalLen;
      localg.field_aesKey = paramc.field_cdnKey;
      localg.field_fileId = paramc.field_cdnUrl;
      localg.field_isStreamMedia = paramc.dQi();
      localg.field_fullpath = y.n(paramc.field_path, false);
      if (!y.ZC(localg.field_fullpath)) {
        Log.e("MicroMsg.EditorUI", "upload, but file not exist, filePath = %s", new Object[] { paramc.field_path });
      }
      if (paramc.dQi()) {}
      for (localg.field_fileType = a(paramc, com.tencent.mm.g.a.MediaType_FAVORITE_VIDEO);; localg.field_fileType = a(paramc, com.tencent.mm.g.a.MediaType_FAVORITE_FILE))
      {
        localg.field_force_aeskeycdn = true;
        localg.field_trysafecdn = false;
        com.tencent.mm.modelcdntran.k.bHW().g(localg);
        AppMethodBeat.o(181602);
        return;
      }
    }
    localg.ihD = false;
    localg.field_totalLen = paramc.field_totalLen;
    localg.field_aesKey = paramc.field_cdnKey;
    localg.field_fileId = paramc.field_cdnUrl;
    localg.field_fullpath = (y.n(paramc.field_path, false) + ".temp");
    localg.field_needStorage = true;
    localg.field_isStreamMedia = paramc.dQi();
    if (paramc.dQi()) {}
    for (localg.field_fileType = a(paramc, com.tencent.mm.g.a.MediaType_FAVORITE_VIDEO);; localg.field_fileType = a(paramc, com.tencent.mm.g.a.MediaType_FAVORITE_FILE))
    {
      com.tencent.mm.modelcdntran.k.bHW().b(localg, -1);
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
        if ((!Util.isNullOrNil(paramAnonymousString)) && (y.ZC(paramAnonymousString)) && (paramAnonymousl != null)) {
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
        if ((!Util.isNullOrNil(paramAnonymousString)) && (y.ZC(paramAnonymousString)) && (paramAnonymousl != null) && (!paramAnonymousl.xyy))
        {
          u localu = new u(paramAnonymousString);
          long l = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFileSizeLimit(false);
          i = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFileSizeLimitInMB(false);
          if (localu.length() < l)
          {
            paramAnonymousl.hTM = paramAnonymousString;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().a(paramAnonymousl, EditorUI.f(EditorUI.this).dwN(), false, true, false);
          }
        }
        for (;;)
        {
          EditorUI.this.g(true, 100L);
          EditorUI.this.U(1, 0L);
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
    this.vEG = com.tencent.mm.ui.base.k.a(paramString2, getString(d.h.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(181544);
        paramAnonymousDialogInterface = paramString1;
        paramAnonymousDialogInterface.isStop = true;
        paramAnonymousDialogInterface.interrupt();
        paraml.xyy = true;
        EditorUI.this.g(true, 100L);
        EditorUI.this.U(1, 0L);
        AppMethodBeat.o(181544);
      }
    });
    ThreadPool.post(paramString1, "NoteEditor_importVideo");
    AppMethodBeat.o(181562);
  }
  
  private void ann(String paramString)
  {
    AppMethodBeat.i(181561);
    Object localObject = com.tencent.mm.plugin.sight.base.f.aVX(paramString);
    if (localObject == null)
    {
      Log.e("MicroMsg.EditorUI", "mediaInfo is null, videoPath is %s", new Object[] { Util.nullAsNil(paramString) });
      AppMethodBeat.o(181561);
      return;
    }
    int i = ((com.tencent.mm.plugin.sight.base.b)localObject).getVideoDuration();
    localObject = new l();
    ((l)localObject).xyp = true;
    ((l)localObject).thumbPath = "";
    ((l)localObject).hTM = "";
    ((l)localObject).duration = i;
    ((l)localObject).type = 6;
    ((l)localObject).xyo = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dws();
    ((l)localObject).xyq = y.alV(paramString);
    ((l)localObject).hIQ = com.tencent.mm.plugin.editor.model.b.anz(localObject.toString());
    this.xvB = new arf();
    this.xvB.bsB(((l)localObject).hIQ);
    this.xvB.bsy(((l)localObject).xyq);
    a(paramString, (l)localObject, com.tencent.mm.plugin.editor.model.b.a(this.xvB), com.tencent.mm.plugin.editor.model.b.b(this.xvB));
    AppMethodBeat.o(181561);
  }
  
  static boolean ano(String paramString)
  {
    AppMethodBeat.i(181600);
    boolean bool = Util.isNullOrNil(b.any(paramString));
    AppMethodBeat.o(181600);
    return bool;
  }
  
  /* Error */
  static boolean anp(String paramString)
  {
    // Byte code:
    //   0: ldc_w 586
    //   3: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 588	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: ldc_w 590
    //   14: invokespecial 592	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   34: invokevirtual 596	java/io/RandomAccessFile:read	([BII)I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpne +32 -> 72
    //   43: aload_3
    //   44: invokevirtual 599	java/io/RandomAccessFile:close	()V
    //   47: ldc_w 586
    //   50: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_0
    //   54: ireturn
    //   55: astore_0
    //   56: ldc 253
    //   58: aload_0
    //   59: ldc_w 528
    //   62: iconst_0
    //   63: anewarray 257	java/lang/Object
    //   66: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: goto -22 -> 47
    //   72: aload_3
    //   73: astore_0
    //   74: new 605	java/lang/String
    //   77: dup
    //   78: aload 4
    //   80: invokespecial 608	java/lang/String:<init>	([B)V
    //   83: astore 4
    //   85: aload_3
    //   86: astore_0
    //   87: ldc 253
    //   89: new 454	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 610
    //   96: invokespecial 612	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload 4
    //   101: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 614
    //   107: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 465	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 616	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_3
    //   117: astore_0
    //   118: aload 4
    //   120: ldc_w 618
    //   123: invokevirtual 621	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   126: istore_2
    //   127: aload_3
    //   128: invokevirtual 599	java/io/RandomAccessFile:close	()V
    //   131: ldc_w 586
    //   134: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iload_2
    //   138: ireturn
    //   139: astore_0
    //   140: ldc 253
    //   142: aload_0
    //   143: ldc_w 528
    //   146: iconst_0
    //   147: anewarray 257	java/lang/Object
    //   150: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: goto -22 -> 131
    //   156: astore 4
    //   158: aconst_null
    //   159: astore_3
    //   160: aload_3
    //   161: astore_0
    //   162: ldc 253
    //   164: aload 4
    //   166: ldc_w 528
    //   169: iconst_0
    //   170: anewarray 257	java/lang/Object
    //   173: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_3
    //   177: ifnull +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 599	java/io/RandomAccessFile:close	()V
    //   184: ldc_w 586
    //   187: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: iconst_0
    //   191: ireturn
    //   192: astore_0
    //   193: ldc 253
    //   195: aload_0
    //   196: ldc_w 528
    //   199: iconst_0
    //   200: anewarray 257	java/lang/Object
    //   203: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -22 -> 184
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_0
    //   212: aload_0
    //   213: ifnull +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 599	java/io/RandomAccessFile:close	()V
    //   220: ldc_w 586
    //   223: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_3
    //   227: athrow
    //   228: astore_0
    //   229: ldc 253
    //   231: aload_0
    //   232: ldc_w 528
    //   235: iconst_0
    //   236: anewarray 257	java/lang/Object
    //   239: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private boolean dvN()
  {
    AppMethodBeat.i(181598);
    if ((this.xvm != null) && (this.xvm.xCC))
    {
      dvx();
      AppMethodBeat.o(181598);
      return false;
    }
    AppMethodBeat.o(181598);
    return true;
  }
  
  private void dvO()
  {
    AppMethodBeat.i(181607);
    if (this.xvx.isEmpty())
    {
      Log.i("MicroMsg.EditorUI", "no need update ui by xml!!! xml is empty.");
      AppMethodBeat.o(181607);
      return;
    }
    Object localObject1 = getContext();
    getString(d.h.app_tip);
    this.vEG = com.tencent.mm.ui.base.k.a((Context)localObject1, getString(d.h.app_waiting), true, new DialogInterface.OnCancelListener()
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
    this.xvD = com.tencent.mm.plugin.fav.a.b.atV(this.xvx);
    if (this.xvD != null)
    {
      this.xvE.clear();
      this.xvE.addAll(this.xvD.field_favProto.vEn);
      int i = this.xvE.size();
      if (i == 0)
      {
        Log.v("MicroMsg.EditorUI", "favItemInfo has no data!!!");
        AppMethodBeat.o(181607);
        return;
      }
      localObject1 = this.xvD.field_favProto.vEn;
      this.xvF.clear();
      this.xvG.clear();
      i -= 1;
      if (i >= 0)
      {
        arf localarf = (arf)((List)localObject1).get(i);
        Object localObject2;
        if (!Util.isNullOrNil(localarf.ZyW))
        {
          localObject2 = new u(com.tencent.mm.plugin.fav.a.b.d(localarf));
          Log.i("MicroMsg.EditorUI", "dataFile: %s", new Object[] { ((u)localObject2).getName() });
          if (((u)localObject2).jKS()) {
            break label394;
          }
          if ((Util.isNullOrNil(localarf.ZyH)) || (Util.isNullOrNil(localarf.Ysw))) {
            Log.e("MicroMsg.EditorUI", "data key or url null!!!");
          }
        }
        else
        {
          label261:
          if (!Util.isNullOrNil(localarf.QJs))
          {
            if (new u(com.tencent.mm.plugin.fav.a.b.a(localarf)).jKS()) {
              break label507;
            }
            if ((!Util.isNullOrNil(localarf.ZyC)) && (!Util.isNullOrNil(localarf.nRr))) {
              break label429;
            }
            Log.w("MicroMsg.EditorUI", "thumb key or url null. favId: %d", new Object[] { Integer.valueOf(this.xvD.field_id) });
          }
        }
        for (;;)
        {
          i -= 1;
          break;
          Log.d("MicroMsg.EditorUI", "local data not exist, gen cdnInfo.");
          localObject2 = a(localarf, 1);
          this.xvF.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localObject2);
          this.xvG.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localarf);
          a((com.tencent.mm.plugin.fav.a.c)localObject2);
          break label261;
          label394:
          Log.d("MicroMsg.EditorUI", "file exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.xvD.field_id), Integer.valueOf(i) });
          break label261;
          label429:
          Log.d("MicroMsg.EditorUI", "local thumb not exist, insert cdnInfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.xvD.field_id), Integer.valueOf(i) });
          localObject2 = a(localarf, 1);
          this.xvF.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localObject2);
          this.xvG.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localarf);
          a((com.tencent.mm.plugin.fav.a.c)localObject2);
          continue;
          label507:
          Log.d("MicroMsg.EditorUI", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.xvD.field_id), Integer.valueOf(i) });
        }
      }
      dvP();
    }
    AppMethodBeat.o(181607);
  }
  
  private void dvP()
  {
    AppMethodBeat.i(181608);
    if (this.xvF.isEmpty())
    {
      Log.i("MicroMsg.EditorUI", "download finish, notifyUpdateUI.");
      Object localObject1 = dvQ();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.EditorUI", "weNoteWrapData is null!!!");
        AppMethodBeat.o(181608);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dwn();
      localObject1 = ((com.tencent.mm.plugin.editor.model.a.g)localObject1).xyw.iterator();
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
          localObject2 = (i)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 1: 
          localObject2 = (com.tencent.mm.plugin.editor.model.a.j)localObject2;
          if (Util.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content)) {
            ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = "";
          }
          ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = a.anm(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content);
          if (((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.length() > 100) {
            com.tencent.mm.plugin.editor.model.nativenote.a.a.anA(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content);
          }
          for (;;)
          {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
            break;
            if (b.anx(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content)) {
              ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.substring(0, ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.length() - 5);
            }
          }
        case 2: 
          localObject2 = (com.tencent.mm.plugin.editor.model.a.h)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 4: 
          localObject2 = (m)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 6: 
          localObject2 = (l)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
        }
      }
      dvs();
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dws();
      if (this.vEG != null)
      {
        this.vEG.dismiss();
        this.vEG = null;
      }
    }
    AppMethodBeat.o(181608);
  }
  
  private com.tencent.mm.plugin.editor.model.a.g dvQ()
  {
    AppMethodBeat.i(181609);
    com.tencent.mm.plugin.editor.model.a.g localg = new com.tencent.mm.plugin.editor.model.a.g();
    Iterator localIterator = this.xvE.iterator();
    Object localObject1 = null;
    Object localObject4;
    Object localObject5;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject4 = (arf)localIterator.next();
      localObject5 = new com.tencent.mm.plugin.editor.model.a.d();
      ((com.tencent.mm.plugin.editor.model.a.d)localObject5).xyo = ((arf)localObject4).ZzG;
      if (((arf)localObject4).dataType == 1) {
        ((com.tencent.mm.plugin.editor.model.a.d)localObject5).xyo = "-1";
      }
      if (Util.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.d)localObject5).xyo))
      {
        Log.e("MicroMsg.EditorUI", "noteItemData.localEditorId is null or nil.");
        AppMethodBeat.o(181609);
        return null;
      }
      if (((com.tencent.mm.plugin.editor.model.a.d)localObject5).xyo.equals("WeNoteHtmlFile"))
      {
        localObject2 = com.tencent.mm.plugin.fav.a.b.d((arf)localObject4);
        if ((Util.isNullOrNil((String)localObject2)) || (!y.ZC((String)localObject2))) {
          break label1044;
        }
      }
    }
    label1044:
    for (;;)
    {
      for (;;)
      {
        try
        {
          for (;;)
          {
            localg.xyv = y.bEn((String)localObject2);
            localObject2 = b.anv(localg.xyv);
            localObject1 = localObject2;
            try
            {
              Log.i("MicroMsg.EditorUI", "local html file exist, dataId: %s", new Object[] { ((arf)localObject4).hIQ });
              Log.i("MicroMsg.EditorUI", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(Util.isNullOrNil(((arf)localObject4).Ysw)), Boolean.valueOf(Util.isNullOrNil(((arf)localObject4).ZyH)) });
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
        ((com.tencent.mm.plugin.editor.model.a.d)localObject5).hIQ = ((arf)localObject4).hIQ;
        switch (((arf)localObject4).dataType)
        {
        default: 
          break;
        case 1: 
          if (Util.isNullOrNil(((arf)localObject4).desc)) {
            break;
          }
          if ((localg.xyw.size() > 0) && (localg.xyw.get(localg.xyw.size() - 1) != null) && (((com.tencent.mm.plugin.editor.model.a.d)localg.xyw.get(localg.xyw.size() - 1)).xyo.equals("-1")))
          {
            localObject3 = (com.tencent.mm.plugin.editor.model.a.e)localg.xyw.get(localg.xyw.size() - 1);
            ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content = ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content.concat(((arf)localObject4).desc);
            break;
          }
          localObject3 = new com.tencent.mm.plugin.editor.model.a.j();
          ((com.tencent.mm.plugin.editor.model.a.e)localObject3).xyo = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).xyo;
          ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content = ((arf)localObject4).desc;
          localg.xyw.add(localObject3);
          break;
        case 2: 
          localObject3 = new com.tencent.mm.plugin.editor.model.a.h();
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).xyo = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).xyo;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).type = 2;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).hIQ = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).hIQ;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).xyn = ((arf)localObject4);
          localObject5 = com.tencent.mm.plugin.fav.a.b.d((arf)localObject4);
          if (Util.isNullOrNil((String)localObject5)) {
            break;
          }
          localObject6 = (String)localObject5 + "_bigthumb";
          y.ZC(com.tencent.mm.plugin.fav.a.b.a((arf)localObject4));
          if (y.ZC((String)localObject5))
          {
            ((com.tencent.mm.plugin.editor.model.a.c)localObject3).xyp = true;
            b.gB((String)localObject5, (String)localObject6);
          }
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).hTM = ((String)localObject6);
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).xym = ((String)localObject5);
          localg.xyw.add(localObject3);
          break;
        case 3: 
          localObject3 = new m();
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).xyo = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).xyo;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).type = 4;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).hIQ = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).hIQ;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).xyn = ((arf)localObject4);
          localObject5 = com.tencent.mm.plugin.fav.a.b.d((arf)localObject4);
          if ((!Util.isNullOrNil((String)localObject5)) && (y.ZC((String)localObject5)))
          {
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).xyp = true;
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).sdM = com.tencent.mm.plugin.editor.model.a.xxG;
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).length = ((int)com.tencent.mm.plugin.editor.model.b.jh(((arf)localObject4).duration));
          }
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).hTM = ((String)localObject5);
          localObject5 = getContext();
          int i = (int)com.tencent.mm.plugin.editor.model.b.jh(((arf)localObject4).duration);
          localObject6 = new ht();
          ((ht)localObject6).hIR.type = 21;
          ((ht)localObject6).hIR.context = ((Context)localObject5);
          ((ht)localObject6).hIR.hIZ = i;
          ((ht)localObject6).publish();
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).xyt = ((ht)localObject6).hIS.path;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).hIZ = ((arf)localObject4).duration;
          localObject5 = new ht();
          ((ht)localObject5).hIR.type = 17;
          ((ht)localObject5).hIR.hIT = ((arf)localObject4);
          ((ht)localObject5).publish();
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).hIY = ((ht)localObject5).hIS.ret;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).xyq = ((arf)localObject4).ZyU;
          localg.xyw.add(localObject3);
          break;
        case 4: 
          localObject3 = new l();
          ((l)localObject3).xyo = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).xyo;
          ((l)localObject3).type = 6;
          ((l)localObject3).hIQ = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).hIQ;
          ((l)localObject3).xyn = ((arf)localObject4);
          ((l)localObject3).duration = ((arf)localObject4).duration;
          ((l)localObject3).thumbPath = com.tencent.mm.plugin.fav.a.b.a((arf)localObject4);
          localObject4 = com.tencent.mm.plugin.fav.a.b.d((arf)localObject4);
          ((l)localObject3).hTM = ((String)localObject4);
          if ((!Util.isNullOrNil(((l)localObject3).thumbPath)) && (!y.ZC(((l)localObject3).thumbPath)) && (y.ZC((String)localObject4)))
          {
            localObject5 = com.tencent.mm.plugin.fav.ui.e.auu((String)localObject4);
            if (localObject5 == null) {}
          }
          try
          {
            Log.i("MicroMsg.EditorUI", "add fav service: create thumbPath bitmap, saveBitmapToImage ");
            BitmapUtil.saveBitmapToImage((Bitmap)localObject5, 60, Bitmap.CompressFormat.JPEG, ((l)localObject3).thumbPath, true);
            if ((!Util.isNullOrNil((String)localObject4)) && (y.ZC((String)localObject4))) {
              ((l)localObject3).xyp = true;
            }
            localg.xyw.add(localObject3);
          }
          catch (Exception localException3)
          {
            Log.printErrStackTrace("MicroMsg.EditorUI", localException3, "", new Object[0]);
          }
        }
      }
      if ((localObject1 != null) && (localObject1.size() > 0)) {
        com.tencent.mm.plugin.editor.model.b.a(localg.xyw, localObject1);
      }
      AppMethodBeat.o(181609);
      return localg;
    }
  }
  
  private void dvR()
  {
    AppMethodBeat.i(181610);
    if (Util.isNullOrNil(b.any(com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dwu())))
    {
      if (this.xvg)
      {
        this.xvg = false;
        enableOptionMenu(0, false);
        AppMethodBeat.o(181610);
      }
    }
    else if (!this.xvg)
    {
      this.xvg = true;
      enableOptionMenu(0, true);
    }
    AppMethodBeat.o(181610);
  }
  
  private void dvs()
  {
    AppMethodBeat.i(181568);
    try
    {
      this.xvi.bZE.notifyChanged();
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
  
  /* Error */
  static boolean gz(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 1008
    //   3: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 1012	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_1
    //   12: iconst_0
    //   13: invokestatic 1016	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
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
    //   37: ldc_w 618
    //   40: invokevirtual 1020	java/lang/String:getBytes	()[B
    //   43: invokevirtual 1025	java/io/OutputStream:write	([B)V
    //   46: aload_1
    //   47: astore 6
    //   49: aload_0
    //   50: astore 5
    //   52: aload_0
    //   53: aload 7
    //   55: invokevirtual 1030	java/io/InputStream:read	([B)I
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
    //   75: invokevirtual 1033	java/io/OutputStream:write	([BII)V
    //   78: goto -32 -> 46
    //   81: astore 7
    //   83: aload_1
    //   84: astore 6
    //   86: aload_0
    //   87: astore 5
    //   89: ldc 253
    //   91: aload 7
    //   93: ldc_w 528
    //   96: iconst_0
    //   97: anewarray 257	java/lang/Object
    //   100: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 1034	java/io/InputStream:close	()V
    //   111: aload_1
    //   112: ifnull +221 -> 333
    //   115: aload_1
    //   116: invokevirtual 1035	java/io/OutputStream:close	()V
    //   119: iconst_0
    //   120: istore_3
    //   121: ldc_w 1008
    //   124: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iload_3
    //   128: ireturn
    //   129: iconst_1
    //   130: istore_3
    //   131: iload_3
    //   132: istore 4
    //   134: aload_0
    //   135: ifnull +10 -> 145
    //   138: aload_0
    //   139: invokevirtual 1034	java/io/InputStream:close	()V
    //   142: iload_3
    //   143: istore 4
    //   145: iload 4
    //   147: istore_3
    //   148: aload_1
    //   149: ifnull -28 -> 121
    //   152: aload_1
    //   153: invokevirtual 1035	java/io/OutputStream:close	()V
    //   156: iload 4
    //   158: istore_3
    //   159: goto -38 -> 121
    //   162: astore_0
    //   163: ldc 253
    //   165: aload_0
    //   166: ldc_w 528
    //   169: iconst_0
    //   170: anewarray 257	java/lang/Object
    //   173: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: iconst_0
    //   177: istore_3
    //   178: goto -57 -> 121
    //   181: astore_0
    //   182: ldc 253
    //   184: aload_0
    //   185: ldc_w 528
    //   188: iconst_0
    //   189: anewarray 257	java/lang/Object
    //   192: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: iconst_0
    //   196: istore 4
    //   198: goto -53 -> 145
    //   201: astore_0
    //   202: ldc 253
    //   204: aload_0
    //   205: ldc_w 528
    //   208: iconst_0
    //   209: anewarray 257	java/lang/Object
    //   212: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: goto -104 -> 111
    //   218: astore_0
    //   219: ldc 253
    //   221: aload_0
    //   222: ldc_w 528
    //   225: iconst_0
    //   226: anewarray 257	java/lang/Object
    //   229: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   248: invokevirtual 1034	java/io/InputStream:close	()V
    //   251: aload 6
    //   253: ifnull +8 -> 261
    //   256: aload 6
    //   258: invokevirtual 1035	java/io/OutputStream:close	()V
    //   261: ldc_w 1008
    //   264: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aload_1
    //   268: athrow
    //   269: astore_0
    //   270: ldc 253
    //   272: aload_0
    //   273: ldc_w 528
    //   276: iconst_0
    //   277: anewarray 257	java/lang/Object
    //   280: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: goto -32 -> 251
    //   286: astore_0
    //   287: ldc 253
    //   289: aload_0
    //   290: ldc_w 528
    //   293: iconst_0
    //   294: anewarray 257	java/lang/Object
    //   297: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void JG(final int paramInt)
  {
    AppMethodBeat.i(181564);
    this.qse.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181545);
        Log.i("MicroMsg.EditorUI", "huahuastart: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        EditorUI.g(EditorUI.this).fV(paramInt);
        Log.i("MicroMsg.EditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(181545);
      }
    }, 0L);
    AppMethodBeat.o(181564);
  }
  
  public final void JH(int paramInt)
  {
    AppMethodBeat.i(181565);
    try
    {
      this.xvi.fW(paramInt);
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
  
  public final void JI(int paramInt)
  {
    AppMethodBeat.i(181567);
    try
    {
      this.xvi.fX(paramInt);
      AppMethodBeat.o(181567);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.EditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(181567);
    }
  }
  
  public final void JJ(final int paramInt)
  {
    AppMethodBeat.i(181573);
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().size()))
    {
      AppMethodBeat.o(181573);
      return;
    }
    this.qse.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181518);
        RecyclerView localRecyclerView = EditorUI.h(EditorUI.this);
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/plugin/editor/EditorUI$11", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/editor/EditorUI$11", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(181518);
      }
    });
    AppMethodBeat.o(181573);
  }
  
  public final void U(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(181579);
    if (!this.xvw)
    {
      AppMethodBeat.o(181579);
      return;
    }
    this.qse.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181525);
        ImageButton localImageButton = (ImageButton)EditorUI.j(EditorUI.this).findViewById(d.e.xwb);
        View localView = EditorUI.j(EditorUI.this).findViewById(d.e.xwc);
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(181525);
          return;
          EditorUI.k(EditorUI.this).setVisibility(8);
          if (!EditorUI.l(EditorUI.this).xCC)
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
      if ((com.tencent.mm.plugin.editor.model.nativenote.manager.b.pUj == null) || (com.tencent.mm.plugin.editor.model.nativenote.manager.b.pUj.size() <= 0)) {
        break label38;
      }
    }
    label38:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(181571);
      return;
    }
    ArrayList localArrayList = com.tencent.mm.plugin.editor.model.nativenote.manager.b.dwi();
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().Y(localArrayList))
    {
      dvv();
      AppMethodBeat.o(181571);
      return;
    }
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().a(localArrayList, paramWXRTEditText, true, true, false, false);
    i = paramWXRTEditText.getRecyclerItemPosition();
    int j = localArrayList.size();
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().gL(i, j + i + 1);
    dvB();
    if (this.xvr) {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dwW();
    }
    AppMethodBeat.o(181571);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(181563);
    if (!this.xvw)
    {
      AppMethodBeat.o(181563);
      return;
    }
    Log.d("MicroMsg.EditorUI", "onFocusChanged, poi: %s, focus: %s, editor: %s.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramWXRTEditText });
    CollectEditorLinearLayoutManager localCollectEditorLinearLayoutManager = (CollectEditorLinearLayoutManager)this.xvh.getLayoutManager();
    if (localCollectEditorLinearLayoutManager != null)
    {
      if (this.xvu) {
        localCollectEditorLinearLayoutManager.xwK = false;
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
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().ax(paramInt, true);
    }
    for (;;)
    {
      dvR();
      AppMethodBeat.o(181563);
      return;
      localCollectEditorLinearLayoutManager.xwK = paramBoolean;
      break;
      label124:
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().ax(paramInt, false);
      continue;
      label135:
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().aw(-1, false);
    }
  }
  
  final void a(arf paramarf, EditorUI.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(181601);
    Object localObject1;
    if (Util.isNullOrNil(paramarf.ZyH))
    {
      com.tencent.mm.modelcdntran.k.bHX();
      localObject1 = com.tencent.mm.modelcdntran.d.bHI();
      paramarf.bst((String)localObject1);
      Log.i("MicroMsg.EditorUI", "local not exist cdn data key, generate %s", new Object[] { localObject1 });
    }
    if (EditorUI.b.xvO == paramb) {
      localObject1 = a(paramarf, 0);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        this.xvF.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, localObject1);
        this.xvG.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, paramarf);
        a((com.tencent.mm.plugin.fav.a.c)localObject1);
      }
      AppMethodBeat.o(181601);
      return;
      localObject1 = localObject2;
      if (EditorUI.b.xvN == paramb) {
        if (Util.isNullOrNil(com.tencent.mm.plugin.fav.a.b.a(paramarf)))
        {
          Log.e("MicroMsg.EditorUI", "insertCdnThumbInfo, type send, path must not be null!");
          localObject1 = localObject2;
        }
        else
        {
          paramb = com.tencent.mm.plugin.fav.a.b.atP(paramarf.hIQ);
          localObject1 = new com.tencent.mm.plugin.fav.a.c();
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey = paramarf.ZyC;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl = paramarf.nRr;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId = paramb;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_favLocalId = this.xvD.field_localId;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen = ((int)paramarf.Zzk);
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_type = 0;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 1;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path = com.tencent.mm.plugin.fav.a.b.a(paramarf);
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_modifyTime = Util.nowMilliSecond();
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_attrFlag |= 1L;
        }
      }
    }
  }
  
  public final void dvA()
  {
    AppMethodBeat.i(181583);
    Toast.makeText(getContext(), getString(d.h.xww), 0).show();
    AppMethodBeat.o(181583);
  }
  
  public final void dvB()
  {
    AppMethodBeat.i(181584);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dwo();
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().JL(i);
    if (locala != null)
    {
      locala.xyb = false;
      locala.xyh = false;
      JG(i);
    }
    this.qse.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181528);
        WXRTEditText localWXRTEditText = EditorUI.f(EditorUI.this).dwL();
        if (localWXRTEditText != null) {
          localWXRTEditText.clearFocus();
        }
        AppMethodBeat.o(181528);
      }
    });
    g(false, 0L);
    U(0, 0L);
    AppMethodBeat.o(181584);
  }
  
  public final int dvC()
  {
    AppMethodBeat.i(181585);
    if (this.xvv)
    {
      int i = com.tencent.mm.compatible.util.j.getKeyBordHeightPx(this);
      AppMethodBeat.o(181585);
      return i;
    }
    AppMethodBeat.o(181585);
    return 0;
  }
  
  public final int dvD()
  {
    AppMethodBeat.i(181586);
    int j = 0;
    int i = j;
    if (this.xvl != null)
    {
      i = j;
      if (this.xvl.getVisibility() == 0) {
        i = this.xvs + 0;
      }
    }
    j = i;
    if (this.xvn != null)
    {
      j = i;
      if (this.xvn.getVisibility() == 0) {
        j = i + this.xvs;
      }
    }
    AppMethodBeat.o(181586);
    return j;
  }
  
  public final boolean dvE()
  {
    AppMethodBeat.i(181587);
    if ((this.xvq != null) && (this.xvq.dwL() != null))
    {
      AppMethodBeat.o(181587);
      return true;
    }
    AppMethodBeat.o(181587);
    return false;
  }
  
  public final RecyclerView dvF()
  {
    return this.xvh;
  }
  
  public final RecyclerView dvG()
  {
    return this.xvh;
  }
  
  public final Context dvH()
  {
    AppMethodBeat.i(181588);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(181588);
    return localAppCompatActivity;
  }
  
  public final com.tencent.mm.plugin.editor.model.nativenote.b.a dvI()
  {
    return this;
  }
  
  public final void dvJ()
  {
    AppMethodBeat.i(181589);
    com.tencent.mm.plugin.editor.model.a.j localj = new com.tencent.mm.plugin.editor.model.a.j();
    localj.content = "";
    localj.xyb = true;
    localj.xyh = false;
    localj.xyd = 0;
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dwn();
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().e(localj);
    dvs();
    g(true, 50L);
    U(1, 0L);
    AppMethodBeat.o(181589);
  }
  
  public final void dvK()
  {
    AppMethodBeat.i(181590);
    com.tencent.mm.plugin.editor.model.nativenote.manager.b.d(getContext(), com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dwv());
    AppMethodBeat.o(181590);
  }
  
  public final void dvL()
  {
    AppMethodBeat.i(181591);
    com.tencent.mm.plugin.editor.model.nativenote.manager.b.d(getContext(), com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dwv());
    dvJ();
    AppMethodBeat.o(181591);
  }
  
  public final void dvM()
  {
    AppMethodBeat.i(181592);
    getContext();
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.b.dwl();
    Object localObject;
    if (i == 2)
    {
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.dwk())
      {
        dvv();
        AppMethodBeat.o(181592);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dwn();
      com.tencent.mm.plugin.editor.model.nativenote.manager.b.clearData();
      localObject = new com.tencent.mm.plugin.editor.model.a.j();
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).content = "";
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).xyb = false;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).xyh = false;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).xyd = 0;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).xyj = true;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().e((com.tencent.mm.plugin.editor.model.a.a)localObject);
      dvs();
      AppMethodBeat.o(181592);
      return;
    }
    if (i == 3)
    {
      localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.b.dwi();
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().Y((ArrayList)localObject))
      {
        dvv();
        AppMethodBeat.o(181592);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dwn();
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().a((ArrayList)localObject, null, false, false, false, false);
      dvB();
      AppMethodBeat.o(181592);
      return;
    }
    Log.d("MicroMsg.EditorUI", "no data.");
    AppMethodBeat.o(181592);
  }
  
  public final void dvS()
  {
    AppMethodBeat.i(181611);
    dvR();
    AppMethodBeat.o(181611);
  }
  
  public final void dvt()
  {
    AppMethodBeat.i(181570);
    if (!this.xvm.xCC)
    {
      dvB();
      final AppCompatActivity localAppCompatActivity = getContext();
      this.qse.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(181546);
          int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().size();
          int j = EditorUI.h(EditorUI.this).getChildCount();
          Object localObject;
          if (i == j)
          {
            float f1 = 0.0F;
            i = j - 1;
            if (i >= 0)
            {
              localObject = EditorUI.h(EditorUI.this).getChildAt(i);
              float f2 = z.Z((View)localObject);
              if (f1 > ((View)localObject).getBottom() + f2) {}
              for (;;)
              {
                i -= 1;
                break;
                f1 = ((View)localObject).getBottom() + f2;
              }
            }
            if ((f1 < com.tencent.mm.compatible.util.j.getScreenWH(localAppCompatActivity)[1]) && (f1 > 0.0F))
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
            ((com.tencent.mm.plugin.editor.model.nativenote.manager.d)localObject).xyY.getLocationOnScreen(arrayOfInt);
            ((com.tencent.mm.plugin.editor.model.nativenote.manager.d)localObject).xyX.showAtLocation(((com.tencent.mm.plugin.editor.model.nativenote.manager.d)localObject).xyY, 49, 0, arrayOfInt[1] + 50);
          }
          AppMethodBeat.o(181546);
        }
      }, 400L);
    }
    AppMethodBeat.o(181570);
  }
  
  public final void dvu()
  {
    AppMethodBeat.i(181574);
    this.qse.post(new Runnable()
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
  
  public final void dvv()
  {
    AppMethodBeat.i(181575);
    dvB();
    if (this.xvr) {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dwW();
    }
    this.qse.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181520);
        com.tencent.mm.ui.base.k.c(EditorUI.this.getContext(), EditorUI.this.getString(d.h.xwE), null, true);
        AppMethodBeat.o(181520);
      }
    }, 100L);
    AppMethodBeat.o(181575);
  }
  
  public final void dvw()
  {
    AppMethodBeat.i(181576);
    com.tencent.mm.ui.base.k.a(this, getString(d.h.permission_microphone_request_again_msg), getString(d.h.permission_tips_title), getString(d.h.jump_to_settings), getString(d.h.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(181521);
        paramAnonymousDialogInterface.dismiss();
        com.tencent.mm.pluginsdk.permission.b.lx(EditorUI.this.getContext());
        AppMethodBeat.o(181521);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(181522);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(181522);
      }
    });
    AppMethodBeat.o(181576);
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(181580);
    com.tencent.mm.ui.base.k.c(getContext(), getString(d.h.xwC), null, true);
    AppMethodBeat.o(181580);
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(181581);
    if (this.xvm != null) {
      this.xvm.a(null);
    }
    AppMethodBeat.o(181581);
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(181582);
    com.tencent.mm.ui.base.k.b(this, getString(d.h.xwv), "", getString(d.h.xwu), getString(d.h.xwt), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(181526);
        com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dxg();
        AppMethodBeat.o(181526);
      }
    }, null);
    AppMethodBeat.o(181582);
  }
  
  public final void g(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181578);
    if (!this.xvw)
    {
      AppMethodBeat.o(181578);
      return;
    }
    this.qse.postDelayed(new Runnable()
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
  
  public final void gH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181566);
    try
    {
      this.xvi.bA(paramInt1, paramInt2);
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
  
  public final void gI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181569);
    try
    {
      this.xvi.by(paramInt1, paramInt2);
      AppMethodBeat.o(181569);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.EditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(181569);
    }
  }
  
  public final void gJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181572);
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.xvu = bool;
      AppMethodBeat.o(181572);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return d.f.xwp;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(181599);
    if (!dvN())
    {
      AppMethodBeat.o(181599);
      return;
    }
    com.tencent.mm.ui.base.k.a(this, getString(d.h.xws), "", getString(d.h.app_yes), getString(d.h.app_no), true, new DialogInterface.OnClickListener()
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
    addTextOptionMenu(0, getString(d.h.app_save), new MenuItem.OnMenuItemClickListener()
    {
      /* Error */
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        // Byte code:
        //   0: ldc 25
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 33
        //   7: ldc 35
        //   9: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   12: aload_0
        //   13: getfield 14	com/tencent/mm/plugin/editor/EditorUI$21:xvH	Lcom/tencent/mm/plugin/editor/EditorUI;
        //   16: astore 6
        //   18: aload 6
        //   20: getfield 44	com/tencent/mm/plugin/editor/EditorUI:xvm	Lcom/tencent/mm/plugin/editor/widget/a;
        //   23: aload 6
        //   25: invokevirtual 50	com/tencent/mm/plugin/editor/widget/a:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/b/a;)V
        //   28: invokestatic 56	com/tencent/mm/plugin/editor/model/nativenote/manager/c:dwm	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/c;
        //   31: invokevirtual 60	com/tencent/mm/plugin/editor/model/nativenote/manager/c:dwu	()Ljava/lang/String;
        //   34: astore_1
        //   35: aload_1
        //   36: invokestatic 64	com/tencent/mm/plugin/editor/EditorUI:ano	(Ljava/lang/String;)Z
        //   39: ifne +66 -> 105
        //   42: aload 6
        //   44: invokevirtual 68	com/tencent/mm/plugin/editor/EditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
        //   47: astore 5
        //   49: aload 6
        //   51: getstatic 74	com/tencent/mm/plugin/editor/d$h:app_tip	I
        //   54: invokevirtual 78	com/tencent/mm/plugin/editor/EditorUI:getString	(I)Ljava/lang/String;
        //   57: pop
        //   58: aload 6
        //   60: aload 5
        //   62: aload 6
        //   64: getstatic 81	com/tencent/mm/plugin/editor/d$h:app_waiting	I
        //   67: invokevirtual 78	com/tencent/mm/plugin/editor/EditorUI:getString	(I)Ljava/lang/String;
        //   70: iconst_1
        //   71: new 83	com/tencent/mm/plugin/editor/EditorUI$18
        //   74: dup
        //   75: aload 6
        //   77: invokespecial 85	com/tencent/mm/plugin/editor/EditorUI$18:<init>	(Lcom/tencent/mm/plugin/editor/EditorUI;)V
        //   80: invokestatic 90	com/tencent/mm/ui/base/k:a	(Landroid/content/Context;Ljava/lang/String;ZLandroid/content/DialogInterface$OnCancelListener;)Lcom/tencent/mm/ui/base/w;
        //   83: putfield 94	com/tencent/mm/plugin/editor/EditorUI:vEG	Landroid/app/ProgressDialog;
        //   86: invokestatic 56	com/tencent/mm/plugin/editor/model/nativenote/manager/c:dwm	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/c;
        //   89: aload_1
        //   90: invokevirtual 98	com/tencent/mm/plugin/editor/model/nativenote/manager/c:anD	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/arv;
        //   93: astore_1
        //   94: aload_1
        //   95: ifnonnull +17 -> 112
        //   98: ldc 33
        //   100: ldc 100
        //   102: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   105: ldc 25
        //   107: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   110: iconst_1
        //   111: ireturn
        //   112: aload 6
        //   114: getfield 110	com/tencent/mm/plugin/editor/EditorUI:xvE	Ljava/util/LinkedList;
        //   117: invokevirtual 115	java/util/LinkedList:clear	()V
        //   120: aload 6
        //   122: getfield 110	com/tencent/mm/plugin/editor/EditorUI:xvE	Ljava/util/LinkedList;
        //   125: aload_1
        //   126: getfield 120	com/tencent/mm/protocal/protobuf/arv:vEn	Ljava/util/LinkedList;
        //   129: invokevirtual 124	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   132: pop
        //   133: aload 6
        //   135: aload 6
        //   137: getfield 110	com/tencent/mm/plugin/editor/EditorUI:xvE	Ljava/util/LinkedList;
        //   140: invokestatic 130	java/lang/System:currentTimeMillis	()J
        //   143: invokestatic 135	com/tencent/mm/plugin/fav/ui/k:a	(Ljava/util/LinkedList;J)Lcom/tencent/mm/plugin/fav/a/g;
        //   146: putfield 139	com/tencent/mm/plugin/editor/EditorUI:xvD	Lcom/tencent/mm/plugin/fav/a/g;
        //   149: iconst_0
        //   150: istore_2
        //   151: iload_2
        //   152: aload 6
        //   154: getfield 110	com/tencent/mm/plugin/editor/EditorUI:xvE	Ljava/util/LinkedList;
        //   157: invokevirtual 143	java/util/LinkedList:size	()I
        //   160: if_icmpge -55 -> 105
        //   163: aload 6
        //   165: getfield 110	com/tencent/mm/plugin/editor/EditorUI:xvE	Ljava/util/LinkedList;
        //   168: iload_2
        //   169: invokevirtual 147	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   172: checkcast 149	com/tencent/mm/protocal/protobuf/arf
        //   175: astore 7
        //   177: aload 7
        //   179: getfield 153	com/tencent/mm/protocal/protobuf/arf:hIQ	Ljava/lang/String;
        //   182: invokestatic 158	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   185: ifeq +25 -> 210
        //   188: aload 7
        //   190: aload 7
        //   192: invokevirtual 161	java/lang/Object:toString	()Ljava/lang/String;
        //   195: aload 6
        //   197: getfield 139	com/tencent/mm/plugin/editor/EditorUI:xvD	Lcom/tencent/mm/plugin/fav/a/g;
        //   200: getfield 166	com/tencent/mm/plugin/fav/a/g:field_type	I
        //   203: invokestatic 172	com/tencent/mm/plugin/fav/a/b:er	(Ljava/lang/String;I)Ljava/lang/String;
        //   206: invokevirtual 176	com/tencent/mm/protocal/protobuf/arf:bsB	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/arf;
        //   209: pop
        //   210: aload 7
        //   212: getfield 179	com/tencent/mm/protocal/protobuf/arf:Zzd	Ljava/lang/String;
        //   215: astore_1
        //   216: aload_1
        //   217: invokestatic 184	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
        //   220: ifeq +242 -> 462
        //   223: aload_1
        //   224: invokestatic 190	com/tencent/mm/b/g:getMD5	(Ljava/lang/String;)Ljava/lang/String;
        //   227: astore 5
        //   229: aload_1
        //   230: invokestatic 193	com/tencent/mm/b/g:hu	(Ljava/lang/String;)Ljava/lang/String;
        //   233: astore 8
        //   235: aload 7
        //   237: aload 5
        //   239: invokevirtual 196	com/tencent/mm/protocal/protobuf/arf:bsz	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/arf;
        //   242: pop
        //   243: aload 7
        //   245: aload 8
        //   247: invokevirtual 199	com/tencent/mm/protocal/protobuf/arf:bsA	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/arf;
        //   250: pop
        //   251: aload 7
        //   253: new 201	com/tencent/mm/vfs/u
        //   256: dup
        //   257: aload_1
        //   258: invokespecial 204	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
        //   261: invokevirtual 207	com/tencent/mm/vfs/u:length	()J
        //   264: invokevirtual 211	com/tencent/mm/protocal/protobuf/arf:yo	(J)Lcom/tencent/mm/protocal/protobuf/arf;
        //   267: pop
        //   268: aload 7
        //   270: invokestatic 215	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/arf;)Ljava/lang/String;
        //   273: astore 5
        //   275: aload_1
        //   276: aload 5
        //   278: invokevirtual 221	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   281: ifne +11 -> 292
        //   284: aload_1
        //   285: aload 5
        //   287: iconst_0
        //   288: invokestatic 225	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
        //   291: pop2
        //   292: aload 6
        //   294: aload 7
        //   296: getstatic 231	com/tencent/mm/plugin/editor/EditorUI$b:xvO	Lcom/tencent/mm/plugin/editor/EditorUI$b;
        //   299: invokevirtual 234	com/tencent/mm/plugin/editor/EditorUI:a	(Lcom/tencent/mm/protocal/protobuf/arf;Lcom/tencent/mm/plugin/editor/EditorUI$b;)V
        //   302: aload 7
        //   304: getfield 237	com/tencent/mm/protocal/protobuf/arf:Zzf	Ljava/lang/String;
        //   307: astore 8
        //   309: aload 8
        //   311: invokestatic 184	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
        //   314: ifeq +229 -> 543
        //   317: aconst_null
        //   318: astore_1
        //   319: aload 8
        //   321: invokestatic 241	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
        //   324: astore 5
        //   326: aload 5
        //   328: astore_1
        //   329: aload 5
        //   331: sipush 4096
        //   334: invokestatic 244	com/tencent/mm/b/g:e	(Ljava/io/InputStream;I)Ljava/lang/String;
        //   337: invokestatic 247	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
        //   340: astore 9
        //   342: aload 5
        //   344: astore_1
        //   345: aload 8
        //   347: invokestatic 251	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
        //   350: lstore_3
        //   351: aload 5
        //   353: astore_1
        //   354: aload 5
        //   356: iconst_0
        //   357: sipush 256
        //   360: invokestatic 255	com/tencent/mm/b/g:b	(Ljava/io/InputStream;II)Ljava/lang/String;
        //   363: astore 10
        //   365: aload 5
        //   367: astore_1
        //   368: aload 7
        //   370: aload 9
        //   372: invokevirtual 258	com/tencent/mm/protocal/protobuf/arf:bsE	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/arf;
        //   375: pop
        //   376: aload 5
        //   378: astore_1
        //   379: aload 7
        //   381: aload 10
        //   383: invokevirtual 261	com/tencent/mm/protocal/protobuf/arf:bsF	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/arf;
        //   386: pop
        //   387: aload 5
        //   389: astore_1
        //   390: aload 7
        //   392: lload_3
        //   393: invokevirtual 264	com/tencent/mm/protocal/protobuf/arf:yp	(J)Lcom/tencent/mm/protocal/protobuf/arf;
        //   396: pop
        //   397: aload 5
        //   399: astore_1
        //   400: aload 7
        //   402: invokestatic 266	com/tencent/mm/plugin/fav/a/b:a	(Lcom/tencent/mm/protocal/protobuf/arf;)Ljava/lang/String;
        //   405: astore 9
        //   407: aload 5
        //   409: astore_1
        //   410: aload 8
        //   412: aload 9
        //   414: invokevirtual 221	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   417: ifne +15 -> 432
        //   420: aload 5
        //   422: astore_1
        //   423: aload 8
        //   425: aload 9
        //   427: iconst_0
        //   428: invokestatic 225	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
        //   431: pop2
        //   432: aload 5
        //   434: astore_1
        //   435: aload 6
        //   437: aload 7
        //   439: getstatic 269	com/tencent/mm/plugin/editor/EditorUI$b:xvN	Lcom/tencent/mm/plugin/editor/EditorUI$b;
        //   442: invokevirtual 234	com/tencent/mm/plugin/editor/EditorUI:a	(Lcom/tencent/mm/protocal/protobuf/arf;Lcom/tencent/mm/plugin/editor/EditorUI$b;)V
        //   445: aload 5
        //   447: ifnull +8 -> 455
        //   450: aload 5
        //   452: invokevirtual 274	java/io/InputStream:close	()V
        //   455: iload_2
        //   456: iconst_1
        //   457: iadd
        //   458: istore_2
        //   459: goto -308 -> 151
        //   462: ldc 33
        //   464: ldc_w 276
        //   467: iconst_2
        //   468: anewarray 4	java/lang/Object
        //   471: dup
        //   472: iconst_0
        //   473: aload 7
        //   475: getfield 279	com/tencent/mm/protocal/protobuf/arf:dataType	I
        //   478: invokestatic 285	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   481: aastore
        //   482: dup
        //   483: iconst_1
        //   484: aload_1
        //   485: aastore
        //   486: invokestatic 288	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   489: goto -187 -> 302
        //   492: astore_1
        //   493: aconst_null
        //   494: astore_1
        //   495: ldc 33
        //   497: ldc_w 290
        //   500: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   503: aload_1
        //   504: ifnull -49 -> 455
        //   507: aload_1
        //   508: invokevirtual 274	java/io/InputStream:close	()V
        //   511: goto -56 -> 455
        //   514: astore_1
        //   515: goto -60 -> 455
        //   518: astore 5
        //   520: aload_1
        //   521: astore 6
        //   523: aload 5
        //   525: astore_1
        //   526: aload 6
        //   528: ifnull +8 -> 536
        //   531: aload 6
        //   533: invokevirtual 274	java/io/InputStream:close	()V
        //   536: ldc 25
        //   538: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   541: aload_1
        //   542: athrow
        //   543: ldc 33
        //   545: ldc_w 292
        //   548: iconst_1
        //   549: anewarray 4	java/lang/Object
        //   552: dup
        //   553: iconst_0
        //   554: aload 8
        //   556: aastore
        //   557: invokestatic 288	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   560: goto -105 -> 455
        //   563: astore_1
        //   564: goto -109 -> 455
        //   567: astore 5
        //   569: goto -33 -> 536
        //   572: astore 5
        //   574: aload_1
        //   575: astore 6
        //   577: aload 5
        //   579: astore_1
        //   580: goto -54 -> 526
        //   583: astore_1
        //   584: aload 5
        //   586: astore_1
        //   587: goto -92 -> 495
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	590	0	this	21
        //   0	590	1	paramAnonymousMenuItem	MenuItem
        //   150	309	2	i	int
        //   350	43	3	l	long
        //   47	404	5	localObject1	Object
        //   518	6	5	localObject2	Object
        //   567	1	5	localException	Exception
        //   572	13	5	localObject3	Object
        //   16	560	6	localObject4	Object
        //   175	299	7	localarf	arf
        //   233	322	8	str1	String
        //   340	86	9	str2	String
        //   363	19	10	str3	String
        // Exception table:
        //   from	to	target	type
        //   319	326	492	java/io/FileNotFoundException
        //   507	511	514	java/lang/Exception
        //   319	326	518	finally
        //   329	342	518	finally
        //   345	351	518	finally
        //   354	365	518	finally
        //   368	376	518	finally
        //   379	387	518	finally
        //   390	397	518	finally
        //   400	407	518	finally
        //   410	420	518	finally
        //   423	432	518	finally
        //   435	445	518	finally
        //   450	455	563	java/lang/Exception
        //   531	536	567	java/lang/Exception
        //   495	503	572	finally
        //   329	342	583	java/io/FileNotFoundException
        //   345	351	583	java/io/FileNotFoundException
        //   354	365	583	java/io/FileNotFoundException
        //   368	376	583	java/io/FileNotFoundException
        //   379	387	583	java/io/FileNotFoundException
        //   390	397	583	java/io/FileNotFoundException
        //   400	407	583	java/io/FileNotFoundException
        //   410	420	583	java/io/FileNotFoundException
        //   423	432	583	java/io/FileNotFoundException
        //   435	445	583	java/io/FileNotFoundException
      }
    }, null, y.b.adEJ);
    enableOptionMenu(0, this.xvg);
    getContentView().getRootView().setBackgroundColor(getContext().getResources().getColor(d.b.white));
    this.xvq = new com.tencent.mm.plugin.editor.model.nativenote.manager.j(this);
    this.xvq.xAu = this.xvw;
    this.xvh = ((RecyclerView)findViewById(d.e.xwa));
    this.xvl = ((LinearLayout)findViewById(d.e.xvZ));
    this.xvm = new com.tencent.mm.plugin.editor.widget.a();
    Object localObject = this.xvm;
    LinearLayout localLinearLayout = this.xvl;
    ((com.tencent.mm.plugin.editor.widget.a)localObject).uiE = localLinearLayout;
    com.tencent.mm.plugin.editor.model.nativenote.manager.j.dwM().xAt = ((com.tencent.mm.plugin.editor.model.nativenote.b.b)localObject);
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCs = ((WeImageButton)localLinearLayout.findViewById(d.e.xwb));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCt = ((WeImageButton)localLinearLayout.findViewById(d.e.xwe));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCu = ((WeImageButton)localLinearLayout.findViewById(d.e.xwd));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCv = ((WeImageButton)localLinearLayout.findViewById(d.e.xwf));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCw = ((LinearLayout)localLinearLayout.findViewById(d.e.xwg));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCx = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).xCw.findViewById(d.e.xwl));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCy = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).xCw.findViewById(d.e.xwj));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCz = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).xCw.findViewById(d.e.xwk));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCA = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).xCw.findViewById(d.e.xwh));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCB = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).xCw.findViewById(d.e.xwi));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCs.setOnClickListener(new a.1((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCt.setOnClickListener(new a.5((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCI = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVi, true);
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCu.setOnClickListener(new a.6((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCv.setOnClickListener(new a.7((com.tencent.mm.plugin.editor.widget.a)localObject, this, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCx.setOnClickListener(new a.8((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCy.setOnClickListener(new a.9((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCz.setOnClickListener(new a.10((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCA.setOnClickListener(new a.11((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).xCB.setOnClickListener(new a.12((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    this.xvn = ((LinearLayout)this.xvl.findViewById(d.e.xwg));
    this.xvn.setVisibility(8);
    this.xvo = ((RelativeLayout)findViewById(d.e.gdC));
    this.xvo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181517);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/EditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (EditorUI.a(EditorUI.this) != null) {
          EditorUI.a(EditorUI.this).xyX.dismiss();
        }
        EditorUI.b(EditorUI.this).setVisibility(8);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181517);
      }
    });
    this.xvp = new com.tencent.mm.plugin.editor.model.nativenote.manager.d(this, this.xvo);
    this.xvp.xyZ = this;
    this.xvj = new CollectEditorLinearLayoutManager();
    this.xvj.xwJ = com.tencent.mm.compatible.util.j.getScreenWH(this)[1];
    this.xvh.setLayoutManager(this.xvj);
    this.xvh.setHasFixedSize(true);
    this.xvk = new EditorUI.a(this);
    this.xvh.a(this.xvk);
    this.xvi = new com.tencent.mm.plugin.editor.adapter.b(this.xvq);
    this.xvh.setAdapter(this.xvi);
    if (this.xvw)
    {
      localObject = new com.tencent.mm.plugin.editor.model.a.j();
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).content = "";
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).xyb = true;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).xyh = false;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().e((com.tencent.mm.plugin.editor.model.a.a)localObject);
      g(true, 300L);
      U(1, 0L);
      this.xvh.setOnTouchListener(this.xvC);
    }
    for (;;)
    {
      this.xvh.getItemAnimator().bZI = 0L;
      this.xvh.getItemAnimator().bZL = 0L;
      this.xvh.getItemAnimator().bZK = 0L;
      this.xvh.getItemAnimator().bZJ = 120L;
      ((w)this.xvh.getItemAnimator()).cbd = false;
      AppMethodBeat.o(181556);
      return;
      this.xvl.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(181559);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.EditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.xvz = paramInt1;
    if (paramInt2 != -1)
    {
      this.xvy = false;
      AppMethodBeat.o(181559);
      return;
    }
    this.xvy = true;
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
        W((ArrayList)localObject);
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
        if (!com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().gK(0, paramIntent.size())) {
          break;
        }
        dvv();
        AppMethodBeat.o(181559);
        return;
        Log.i("MicroMsg.EditorUI", "no pic selected");
      }
      ann((String)paramIntent.get(0));
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
        ann((String)localObject);
      }
      if ((paramIntent.NHK.booleanValue()) && (!Util.isNullOrNil(paramIntent.thumbPath)))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramIntent.thumbPath);
        W((ArrayList)localObject);
        AppMethodBeat.o(181559);
        return;
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          Log.e("MicroMsg.EditorUI", "sight capture result is null!");
          AppMethodBeat.o(181559);
          return;
        }
        localObject = paramIntent.KTN;
        if (!Util.isNullOrNil((String)localObject)) {
          ann((String)localObject);
        }
        if ((paramIntent.KTL) && (!Util.isNullOrNil(paramIntent.KTT)))
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramIntent.KTT);
          W((ArrayList)localObject);
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
    if (this.xvr)
    {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().nV(false);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().nU(false);
    }
    AppMethodBeat.o(181596);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(181555);
    customfixStatusbar(true);
    Object localObject1 = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).mDataList = new ArrayList();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).xyR = this;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).xyS = new arf();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).xyT = 0;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).xyU = 0;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).xyV = 0;
    super.onCreate(paramBundle);
    this.xvw = getIntent().getBooleanExtra("KEY_EDITABLE", false);
    this.xvx = getIntent().getStringExtra("KEY_CONTENT_XML");
    if (Util.isNullOrNil(this.xvx))
    {
      this.xvx = "";
      this.xvg = false;
    }
    Log.i("MicroMsg.EditorUI", "mCollectEditable: %s, mCollectContentXml: %s", new Object[] { Boolean.valueOf(this.xvw), this.xvx });
    this.qse = new MMHandler();
    initView();
    this.xvs = com.tencent.mm.cd.a.fromDPToPix(this, 48);
    if (this.xvr)
    {
      Log.i("MicroMsg.EditorUI", "use multiselect");
      int i = getResources().getColor(d.b.xvS);
      paramBundle = com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ();
      boolean bool = this.xvw;
      Log.i("EditorSelectManager", "onInit start");
      paramBundle.xAT = bool;
      paramBundle.xAW = 14;
      paramBundle.xAX = 32;
      paramBundle.xAY = (com.tencent.mm.cd.a.fromDPToPix(this, 21) - paramBundle.xAX);
      paramBundle.xAZ = (com.tencent.mm.cd.a.fromDPToPix(this, 40) + paramBundle.xAX * 2);
      paramBundle.xBa = (com.tencent.mm.cd.a.fromDPToPix(this, 240) + paramBundle.xAX * 2);
      paramBundle.xAU = com.tencent.mm.cd.a.fromDPToPix(this, 22);
      paramBundle.xAV = com.tencent.mm.cd.a.fromDPToPix(this, 1);
      paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
      paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
      paramBundle.xBe = new int[] { -1, -1 };
      paramBundle.xBf = new int[] { -1, -1 };
      paramBundle.xBg = new int[] { -1, -1 };
      paramBundle.xBh = new int[] { -1, -1 };
      localObject1 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 2, paramBundle.xAU, paramBundle.xAV, i, paramBundle);
      paramBundle.xBi = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.xBi.setClippingEnabled(false);
      paramBundle.xBi.setAnimationStyle(d.i.xwG);
      paramBundle.xBc = ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
      paramBundle.xBd = com.tencent.mm.cd.a.fromDPToPix(this, 6);
      Object localObject2 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 3, paramBundle.xAU, paramBundle.xAV, i, paramBundle);
      paramBundle.xBj = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.xBj.setClippingEnabled(false);
      paramBundle.xBj.setAnimationStyle(d.i.xwF);
      localObject2 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 4, paramBundle.xAU, paramBundle.xAV, i, paramBundle);
      paramBundle.xBk = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.xBk.setClippingEnabled(false);
      paramBundle.xBk.setAnimationStyle(d.i.xwH);
      localObject2 = LayoutInflater.from(this).inflate(d.f.xwn, null);
      ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramBundle.xBl = new PopupWindow((View)localObject2, -2, -2, false);
      paramBundle.xBl.setBackgroundDrawable(getResources().getDrawable(d.d.sub_menu_bg));
      paramBundle.xBl.setClippingEnabled(false);
      paramBundle.xBl.setAnimationStyle(d.i.xwI);
      paramBundle.xBr = ((TextView)((View)localObject2).findViewById(d.e.fRM));
      paramBundle.xBs = ((TextView)((View)localObject2).findViewById(d.e.fSl));
      paramBundle.xBt = ((TextView)((View)localObject2).findViewById(d.e.fSi));
      paramBundle.xBu = ((TextView)((View)localObject2).findViewById(d.e.fSh));
      paramBundle.xBv = ((TextView)((View)localObject2).findViewById(d.e.fRW));
      paramBundle.xBw = ((TextView)((View)localObject2).findViewById(d.e.fRV));
      paramBundle.xBx = ((TextView)((View)localObject2).findViewById(d.e.fRU));
      paramBundle.xBy = ((TextView)((View)localObject2).findViewById(d.e.fSd));
      com.tencent.mm.plugin.editor.model.nativenote.c.e.j(paramBundle.xBr, paramBundle.xAW);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.j(paramBundle.xBs, paramBundle.xAW);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.j(paramBundle.xBt, paramBundle.xAW);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.j(paramBundle.xBu, paramBundle.xAW);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.j(paramBundle.xBv, paramBundle.xAW);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.j(paramBundle.xBw, paramBundle.xAW);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.j(paramBundle.xBx, paramBundle.xAW);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.j(paramBundle.xBy, paramBundle.xAW);
      paramBundle.xBr.setOnClickListener(new e.10(paramBundle));
      paramBundle.xBs.setOnClickListener(new e.11(paramBundle));
      paramBundle.xBt.setOnClickListener(new e.12(paramBundle));
      paramBundle.xBu.setOnClickListener(new e.13(paramBundle));
      paramBundle.xBv.setOnClickListener(new e.2(paramBundle));
      paramBundle.xBw.setOnClickListener(new e.3(paramBundle));
      paramBundle.xBx.setOnClickListener(new e.4(paramBundle));
      paramBundle.xBy.setOnClickListener(new e.5(paramBundle));
      paramBundle.xBb = ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewPadding();
      paramBundle.xBm = this;
      paramBundle.xBn = new com.tencent.mm.plugin.editor.model.nativenote.c.d();
      paramBundle.xBo = new com.tencent.mm.plugin.editor.model.nativenote.c.b();
      paramBundle.mHandler = new MMHandler();
      com.tencent.mm.plugin.editor.model.nativenote.c.e.mHasInit = true;
      Log.i("EditorSelectManager", "onInit end");
      this.xvt = new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(270811);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/EditorUI$24", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
            AppMethodBeat.o(270811);
            return;
            com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dxa();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dwY();
            continue;
            boolean bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dwZ();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().nV(bool);
            bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dwX();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().nU(bool);
            com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().h(false, 50L);
          }
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(270812);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/EditorUI$24", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if (paramAnonymousInt2 > 30)
          {
            com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dxa();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dwY();
          }
          localObject = com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dwT();
          if (localObject == null)
          {
            Log.e("MicroMsg.EditorUI", "on scrolled , selectinfo is null, return");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
            AppMethodBeat.o(270812);
            return;
          }
          if (((EditorUI.i(EditorUI.this)) || ((EditorUI.j(EditorUI.this) != null) && (EditorUI.j(EditorUI.this).getVisibility() == 0))) && (((com.tencent.mm.plugin.editor.model.nativenote.c.d)localObject).getSelectType() == 2) && (com.tencent.mm.plugin.editor.model.nativenote.c.f.c(paramAnonymousRecyclerView, ((com.tencent.mm.plugin.editor.model.nativenote.c.d)localObject).dIY) == null)) {
            EditorUI.this.dvB();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(270812);
        }
      };
      this.xvh.a(this.xvt);
    }
    dvO();
    AppMethodBeat.o(181555);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(181594);
    super.onDestroy();
    if (this.xvr)
    {
      if (this.xvh != null) {
        this.xvh.b(this.xvt);
      }
      localObject = com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ();
      Log.i("EditorSelectManager", "onDestroy");
      com.tencent.mm.plugin.editor.model.nativenote.c.e.mHasInit = false;
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).xBp != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).xBp.stopTimer();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).xBq != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).xBq.stopTimer();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).xBi != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).xBi.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).xBj != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).xBj.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).xBk != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).xBk.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).xBl != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).xBl.dismiss();
      }
      com.tencent.mm.plugin.editor.model.nativenote.c.e.xAS = null;
    }
    if (this.xvq != null)
    {
      localObject = this.xvq;
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.j.xAp == localObject) {
        com.tencent.mm.plugin.editor.model.nativenote.manager.j.xAp = null;
      }
    }
    Object localObject = com.tencent.mm.plugin.editor.widget.voiceview.a.dxB();
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).stopPlay();
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).xCV = null;
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).xCU = null;
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).bPE.clear();
    com.tencent.mm.plugin.editor.widget.voiceview.a.xCP = null;
    if (com.tencent.mm.plugin.editor.model.c.dwd() != null)
    {
      com.tencent.mm.plugin.editor.model.c.dwd();
      com.tencent.mm.plugin.editor.model.c.destroy();
    }
    localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).xyR = null;
    if (((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).mDataList != null)
    {
      localObject = ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).mDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)((Iterator)localObject).next();
        locala.xyg = null;
        locala.xye = null;
        locala.xyf = null;
      }
    }
    AppMethodBeat.o(181594);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(181595);
    super.onDrag();
    if (this.xvr)
    {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dxa();
      com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dwY();
    }
    if (this.xvv)
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
      this.xvv = bool;
      if (this.xvv) {
        U(1, 0L);
      }
      if (this.xvr) {
        this.qse.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181532);
            boolean bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dwZ();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().nV(bool);
            bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().dwX();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.dwQ().nU(bool);
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
    if (this.xvm != null) {
      this.xvm.a(this);
    }
    if (com.tencent.mm.plugin.editor.widget.voiceview.a.dxB().dxE()) {
      com.tencent.mm.plugin.editor.widget.voiceview.a.dxB().stopPlay();
    }
    this.xvA = this.xvv;
    g(false, 0L);
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
        dvw();
        AppMethodBeat.o(181577);
        return;
        if ((com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null))) && (paramArrayOfInt[0] != 0)) {
          com.tencent.mm.ui.base.k.a(getContext(), getString(d.h.permission_location_request_again_msg), getString(d.h.permission_tips_title), getString(d.h.jump_to_settings), getString(d.h.app_cancel), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(181523);
              com.tencent.mm.pluginsdk.permission.b.lx(EditorUI.this.getContext());
              AppMethodBeat.o(181523);
            }
          }, null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(181557);
    super.onResume();
    if (this.xvw) {
      switch (this.xvz)
      {
      }
    }
    for (;;)
    {
      this.xvz = -1;
      this.xvy = false;
      if (isSupportNavigationSwipeBack()) {
        getSwipeBackLayout().setEnableGesture(false);
      }
      AppMethodBeat.o(181557);
      return;
      if (this.xvA)
      {
        g(true, 100L);
        U(1, 0L);
        continue;
        if (!this.xvy)
        {
          g(true, 100L);
          U(1, 0L);
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