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
import android.support.v4.view.u;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.as;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
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
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
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
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
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
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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
  private g.a iZc;
  private MMHandler kAn;
  private float liD;
  private float liE;
  ProgressDialog pqa;
  private EditorUI.a qNA;
  private LinearLayout qNB;
  com.tencent.mm.plugin.editor.widget.a qNC;
  private LinearLayout qND;
  private RelativeLayout qNE;
  private com.tencent.mm.plugin.editor.model.nativenote.manager.d qNF;
  private com.tencent.mm.plugin.editor.model.nativenote.manager.j qNG;
  private boolean qNH;
  private int qNI;
  private RecyclerView.l qNJ;
  private boolean qNK;
  private boolean qNL;
  private boolean qNM;
  private String qNN;
  private boolean qNO;
  private int qNP;
  private boolean qNQ;
  private aml qNR;
  View.OnTouchListener qNS;
  com.tencent.mm.plugin.fav.a.g qNT;
  LinkedList<aml> qNU;
  private ConcurrentHashMap<String, com.tencent.mm.plugin.fav.a.c> qNV;
  private ConcurrentHashMap<String, aml> qNW;
  private boolean qNw;
  private RecyclerView qNx;
  private com.tencent.mm.plugin.editor.adapter.b qNy;
  private CollectEditorLinearLayoutManager qNz;
  
  public EditorUI()
  {
    AppMethodBeat.i(181554);
    this.qNw = false;
    this.qNH = true;
    this.qNP = -1;
    this.qNS = new View.OnTouchListener()
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
              EditorUI.a(EditorUI.this).qQv.dismiss();
            }
            EditorUI.b(EditorUI.this).setVisibility(8);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(181531);
          return false;
          label170:
          int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().size();
          paramAnonymousView = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(i - 1);
          if (paramAnonymousView != null)
          {
            boolean bool = paramAnonymousView.qPA;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDr();
            paramAnonymousView.qPA = true;
            paramAnonymousView.qPG = false;
            paramAnonymousView.qPC = -1;
            EditorUI.g(EditorUI.this).ci(i - 1);
            EditorUI.this.e(true, 50L);
            EditorUI.this.Q(1, 0L);
            if ((EditorUI.p(EditorUI.this)) && (bool))
            {
              EditorUI.q(EditorUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181530);
                  com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().ln(true);
                  com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().lm(true);
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
                    if (com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().getSelectType() == 1)
                    {
                      EditorUI.this.cCD();
                      com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cDY();
                    }
                  }
                  else if (!EditorUI.r(EditorUI.this)) {
                    EditorUI.this.cCD();
                  }
                }
              }
            }
          }
        }
      }
    };
    this.qNU = new LinkedList();
    this.qNV = new ConcurrentHashMap();
    this.qNW = new ConcurrentHashMap();
    this.iZc = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
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
        aml localaml = (aml)EditorUI.t(EditorUI.this).get(paramAnonymousString);
        if (localaml == null)
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
          localaml.bgi(paramAnonymousc.field_cdnKey);
          localaml.bgh(paramAnonymousc.field_cdnUrl);
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
          if ((paramAnonymousInt == -2) && (!EditorUI.alH(str)) && (EditorUI.fI(str, (String)localObject)))
          {
            Log.i("MicroMsg.EditorUI", "renameAndCopyFile write amr head ok!");
            break;
          }
          o localo = new o(str);
          localObject = new o((String)localObject);
          if (!localo.exists()) {
            break;
          }
          Log.i("MicroMsg.EditorUI", "rename file suc:%b, old:%s, new:%s", new Object[] { Boolean.valueOf(localo.am((o)localObject)), str, localObject });
          break;
          label374:
          paramAnonymousc.field_cdnKey = paramAnonymousd.field_aesKey;
          paramAnonymousc.field_cdnUrl = paramAnonymousd.field_fileId;
          break;
          label395:
          localaml.bgk(paramAnonymousc.field_cdnKey);
          localaml.bgj(paramAnonymousc.field_cdnUrl);
          if ((paramAnonymousc.field_type != 0) || (!paramAnonymousc.cUr())) {
            break label197;
          }
          Log.i("MicroMsg.EditorUI", "video stream, id:%s", new Object[] { paramAnonymousd.field_videoFileId });
          localaml.bgy(paramAnonymousd.field_videoFileId);
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
  
  private void S(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(181560);
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().fw(0, paramArrayList.size()))
    {
      cCx();
      AppMethodBeat.o(181560);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755998);
    this.pqa = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(2131756029), true, new DialogInterface.OnCancelListener()
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
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
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
          localh.qPO = true;
          localh.type = 2;
          localh.qPN = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDu();
          localh.dLl = com.tencent.mm.plugin.editor.model.b.alR(localh.toString());
          EditorUI.a(EditorUI.this, new aml());
          EditorUI.e(EditorUI.this).bgs(localh.dLl);
          localh.qPL = b.fJ(str, com.tencent.mm.plugin.editor.model.b.b(EditorUI.e(EditorUI.this)));
          localh.dUs = b.fK(localh.qPL, com.tencent.mm.plugin.editor.model.b.a(EditorUI.e(EditorUI.this)));
          localArrayList.add(localh);
          i += 1;
        }
        if ((EditorUI.c(EditorUI.this) != null) && (EditorUI.c(EditorUI.this).isShowing()))
        {
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a(localArrayList, EditorUI.f(EditorUI.this).cDQ(), true, false, true, false);
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
      paramInt = com.tencent.mm.i.a.gpR;
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
  
  private com.tencent.mm.plugin.fav.a.c a(aml paramaml, int paramInt)
  {
    AppMethodBeat.i(181603);
    if ((1 == paramInt) && ((Util.isNullOrNil(paramaml.Lvp)) || (Util.isNullOrNil(paramaml.KuR))))
    {
      Log.e("MicroMsg.EditorUI", "getCdnDataInfo, type recv, cdnDataUrl must not be null!");
      AppMethodBeat.o(181603);
      return null;
    }
    if ((paramInt == 0) && (Util.isNullOrNil(com.tencent.mm.plugin.fav.a.b.d(paramaml))))
    {
      Log.e("MicroMsg.EditorUI", "getCdnDataInfo, type send, path must not be null!");
      AppMethodBeat.o(181603);
      return null;
    }
    com.tencent.mm.plugin.fav.a.c localc = new com.tencent.mm.plugin.fav.a.c();
    localc.field_dataId = paramaml.dLl;
    localc.field_totalLen = ((int)paramaml.LvI);
    localc.field_type = paramInt;
    localc.field_favLocalId = this.qNT.field_localId;
    localc.field_cdnKey = paramaml.Lvp;
    localc.field_cdnUrl = paramaml.KuR;
    localc.field_path = com.tencent.mm.plugin.fav.a.b.d(paramaml);
    if (paramaml.dataType == 3) {}
    for (localc.field_dataType = com.tencent.mm.plugin.fav.a.b.arK(paramaml.LvC);; localc.field_dataType = paramaml.dataType)
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
    localg.gqy = this.iZc;
    localg.field_mediaId = paramc.field_dataId;
    localg.field_priority = com.tencent.mm.i.a.gpN;
    if (paramc.field_type == 0)
    {
      localg.ehd = true;
      localg.field_needStorage = true;
      localg.field_totalLen = paramc.field_totalLen;
      localg.field_aesKey = paramc.field_cdnKey;
      localg.field_fileId = paramc.field_cdnUrl;
      localg.field_isStreamMedia = paramc.cUr();
      localg.field_fullpath = paramc.field_path;
      if (!s.YS(localg.field_fullpath)) {
        Log.e("MicroMsg.EditorUI", "upload, but file not exist, filePath = %s", new Object[] { paramc.field_path });
      }
      if (paramc.cUr()) {}
      for (localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
      {
        localg.field_force_aeskeycdn = true;
        localg.field_trysafecdn = false;
        com.tencent.mm.an.f.baQ().f(localg);
        AppMethodBeat.o(181602);
        return;
      }
    }
    localg.ehd = false;
    localg.field_totalLen = paramc.field_totalLen;
    localg.field_aesKey = paramc.field_cdnKey;
    localg.field_fileId = paramc.field_cdnUrl;
    localg.field_fullpath = (paramc.field_path + ".temp");
    localg.field_needStorage = true;
    localg.field_isStreamMedia = paramc.cUr();
    if (paramc.cUr()) {}
    for (localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; localg.field_fileType = a(paramc, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
    {
      com.tencent.mm.an.f.baQ().b(localg, -1);
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
        if ((!Util.isNullOrNil(paramAnonymousString)) && (s.YS(paramAnonymousString)) && (paramAnonymousl != null)) {
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
        if ((!Util.isNullOrNil(paramAnonymousString)) && (s.YS(paramAnonymousString)) && (paramAnonymousl != null) && (!paramAnonymousl.qPW)) {
          if (new o(paramAnonymousString).length() < ((af)com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(false))
          {
            paramAnonymousl.dUs = paramAnonymousString;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a(paramAnonymousl, EditorUI.f(EditorUI.this).cDQ(), false, true, false);
          }
        }
        for (;;)
        {
          EditorUI.this.e(true, 100L);
          EditorUI.this.Q(1, 0L);
          AppMethodBeat.o(181543);
          return;
          Toast.makeText(EditorUI.this.getContext(), EditorUI.this.getString(2131759350), 1).show();
          continue;
          Log.i("MicroMsg.EditorUI", "file not exist or user canceled");
        }
      }
    });
    paramString2 = getContext();
    getString(2131755998);
    this.pqa = com.tencent.mm.ui.base.h.a(paramString2, getString(2131756029), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(181544);
        paramAnonymousDialogInterface = paramString1;
        paramAnonymousDialogInterface.isStop = true;
        paramAnonymousDialogInterface.interrupt();
        paraml.qPW = true;
        EditorUI.this.e(true, 100L);
        EditorUI.this.Q(1, 0L);
        AppMethodBeat.o(181544);
      }
    });
    ThreadPool.post(paramString1, "NoteEditor_importVideo");
    AppMethodBeat.o(181562);
  }
  
  private void alF(String paramString)
  {
    AppMethodBeat.i(181561);
    Object localObject = com.tencent.mm.plugin.sight.base.e.aNx(paramString);
    if (localObject == null)
    {
      Log.e("MicroMsg.EditorUI", "mediaInfo is null, videoPath is %s", new Object[] { Util.nullAsNil(paramString) });
      AppMethodBeat.o(181561);
      return;
    }
    int i = ((com.tencent.mm.plugin.sight.base.a)localObject).getVideoDuration();
    localObject = new l();
    ((l)localObject).qPO = true;
    ((l)localObject).thumbPath = "";
    ((l)localObject).dUs = "";
    ((l)localObject).duration = i;
    ((l)localObject).type = 6;
    ((l)localObject).qPN = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDu();
    ((l)localObject).qPP = s.akC(paramString);
    ((l)localObject).dLl = com.tencent.mm.plugin.editor.model.b.alR(localObject.toString());
    this.qNR = new aml();
    this.qNR.bgs(((l)localObject).dLl);
    this.qNR.bgp(((l)localObject).qPP);
    a(paramString, (l)localObject, com.tencent.mm.plugin.editor.model.b.a(this.qNR), com.tencent.mm.plugin.editor.model.b.b(this.qNR));
    AppMethodBeat.o(181561);
  }
  
  static boolean alG(String paramString)
  {
    AppMethodBeat.i(181600);
    boolean bool = Util.isNullOrNil(b.alQ(paramString));
    AppMethodBeat.o(181600);
    return bool;
  }
  
  /* Error */
  static boolean alH(String paramString)
  {
    // Byte code:
    //   0: ldc_w 564
    //   3: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 566	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: ldc_w 568
    //   14: invokespecial 570	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   34: invokevirtual 574	java/io/RandomAccessFile:read	([BII)I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpne +32 -> 72
    //   43: aload_3
    //   44: invokevirtual 577	java/io/RandomAccessFile:close	()V
    //   47: ldc_w 564
    //   50: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_0
    //   54: ireturn
    //   55: astore_0
    //   56: ldc 235
    //   58: aload_0
    //   59: ldc_w 506
    //   62: iconst_0
    //   63: anewarray 239	java/lang/Object
    //   66: invokestatic 581	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: goto -22 -> 47
    //   72: aload_3
    //   73: astore_0
    //   74: new 583	java/lang/String
    //   77: dup
    //   78: aload 4
    //   80: invokespecial 586	java/lang/String:<init>	([B)V
    //   83: astore 4
    //   85: aload_3
    //   86: astore_0
    //   87: ldc 235
    //   89: new 432	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 588
    //   96: invokespecial 590	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload 4
    //   101: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 592
    //   107: invokevirtual 437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 443	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 594	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_3
    //   117: astore_0
    //   118: aload 4
    //   120: ldc_w 596
    //   123: invokevirtual 599	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   126: istore_2
    //   127: aload_3
    //   128: invokevirtual 577	java/io/RandomAccessFile:close	()V
    //   131: ldc_w 564
    //   134: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iload_2
    //   138: ireturn
    //   139: astore_0
    //   140: ldc 235
    //   142: aload_0
    //   143: ldc_w 506
    //   146: iconst_0
    //   147: anewarray 239	java/lang/Object
    //   150: invokestatic 581	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: goto -22 -> 131
    //   156: astore 4
    //   158: aconst_null
    //   159: astore_3
    //   160: aload_3
    //   161: astore_0
    //   162: ldc 235
    //   164: aload 4
    //   166: ldc_w 506
    //   169: iconst_0
    //   170: anewarray 239	java/lang/Object
    //   173: invokestatic 581	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_3
    //   177: ifnull +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 577	java/io/RandomAccessFile:close	()V
    //   184: ldc_w 564
    //   187: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: iconst_0
    //   191: ireturn
    //   192: astore_0
    //   193: ldc 235
    //   195: aload_0
    //   196: ldc_w 506
    //   199: iconst_0
    //   200: anewarray 239	java/lang/Object
    //   203: invokestatic 581	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -22 -> 184
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_0
    //   212: aload_0
    //   213: ifnull +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 577	java/io/RandomAccessFile:close	()V
    //   220: ldc_w 564
    //   223: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_3
    //   227: athrow
    //   228: astore_0
    //   229: ldc 235
    //   231: aload_0
    //   232: ldc_w 506
    //   235: iconst_0
    //   236: anewarray 239	java/lang/Object
    //   239: invokestatic 581	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private boolean cCP()
  {
    AppMethodBeat.i(181598);
    if ((this.qNC != null) && (this.qNC.qTX))
    {
      cCz();
      AppMethodBeat.o(181598);
      return false;
    }
    AppMethodBeat.o(181598);
    return true;
  }
  
  private void cCQ()
  {
    AppMethodBeat.i(181607);
    if (this.qNN.isEmpty())
    {
      Log.i("MicroMsg.EditorUI", "no need update ui by xml!!! xml is empty.");
      AppMethodBeat.o(181607);
      return;
    }
    Object localObject1 = getContext();
    getString(2131755998);
    this.pqa = com.tencent.mm.ui.base.h.a((Context)localObject1, getString(2131756029), true, new DialogInterface.OnCancelListener()
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
    this.qNT = com.tencent.mm.plugin.fav.a.b.arO(this.qNN);
    if (this.qNT != null)
    {
      this.qNU.clear();
      this.qNU.addAll(this.qNT.field_favProto.ppH);
      int i = this.qNU.size();
      if (i == 0)
      {
        Log.v("MicroMsg.EditorUI", "favItemInfo has no data!!!");
        AppMethodBeat.o(181607);
        return;
      }
      localObject1 = this.qNT.field_favProto.ppH;
      this.qNV.clear();
      this.qNW.clear();
      i -= 1;
      if (i >= 0)
      {
        aml localaml = (aml)((List)localObject1).get(i);
        Object localObject2;
        if (!Util.isNullOrNil(localaml.LvE))
        {
          localObject2 = new o(com.tencent.mm.plugin.fav.a.b.d(localaml));
          Log.i("MicroMsg.EditorUI", "dataFile: %s", new Object[] { ((o)localObject2).getName() });
          if (((o)localObject2).exists()) {
            break label392;
          }
          if ((Util.isNullOrNil(localaml.Lvp)) || (Util.isNullOrNil(localaml.KuR))) {
            Log.e("MicroMsg.EditorUI", "data key or url null!!!");
          }
        }
        else
        {
          label259:
          if (!Util.isNullOrNil(localaml.LvP))
          {
            if (new o(com.tencent.mm.plugin.fav.a.b.a(localaml)).exists()) {
              break label505;
            }
            if ((!Util.isNullOrNil(localaml.Lvk)) && (!Util.isNullOrNil(localaml.iwX))) {
              break label427;
            }
            Log.w("MicroMsg.EditorUI", "thumb key or url null. favId: %d", new Object[] { Integer.valueOf(this.qNT.field_id) });
          }
        }
        for (;;)
        {
          i -= 1;
          break;
          Log.d("MicroMsg.EditorUI", "local data not exist, gen cdnInfo.");
          localObject2 = a(localaml, 1);
          this.qNV.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localObject2);
          this.qNW.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localaml);
          a((com.tencent.mm.plugin.fav.a.c)localObject2);
          break label259;
          label392:
          Log.d("MicroMsg.EditorUI", "file exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.qNT.field_id), Integer.valueOf(i) });
          break label259;
          label427:
          Log.d("MicroMsg.EditorUI", "local thumb not exist, insert cdnInfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.qNT.field_id), Integer.valueOf(i) });
          localObject2 = a(localaml, 1);
          this.qNV.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localObject2);
          this.qNW.put(((com.tencent.mm.plugin.fav.a.c)localObject2).field_dataId, localaml);
          a((com.tencent.mm.plugin.fav.a.c)localObject2);
          continue;
          label505:
          Log.d("MicroMsg.EditorUI", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(this.qNT.field_id), Integer.valueOf(i) });
        }
      }
      cCR();
    }
    AppMethodBeat.o(181607);
  }
  
  private void cCR()
  {
    AppMethodBeat.i(181608);
    if (this.qNV.isEmpty())
    {
      Log.i("MicroMsg.EditorUI", "download finish, notifyUpdateUI.");
      Object localObject1 = cCS();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.EditorUI", "weNoteWrapData is null!!!");
        AppMethodBeat.o(181608);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDp();
      localObject1 = ((com.tencent.mm.plugin.editor.model.a.g)localObject1).qPU.iterator();
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
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 1: 
          localObject2 = (com.tencent.mm.plugin.editor.model.a.j)localObject2;
          if (Util.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content)) {
            ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = "";
          }
          ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = a.alE(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content);
          if (((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.length() > 100) {
            com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content);
          }
          for (;;)
          {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
            break;
            if (b.alP(((com.tencent.mm.plugin.editor.model.a.j)localObject2).content)) {
              ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content = ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.substring(0, ((com.tencent.mm.plugin.editor.model.a.j)localObject2).content.length() - 5);
            }
          }
        case 2: 
          localObject2 = (com.tencent.mm.plugin.editor.model.a.h)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 4: 
          localObject2 = (m)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
          break;
        case 6: 
          localObject2 = (l)localObject2;
          com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e((com.tencent.mm.plugin.editor.model.a.a)localObject2);
        }
      }
      cCu();
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDu();
      if (this.pqa != null)
      {
        this.pqa.dismiss();
        this.pqa = null;
      }
    }
    AppMethodBeat.o(181608);
  }
  
  private com.tencent.mm.plugin.editor.model.a.g cCS()
  {
    AppMethodBeat.i(181609);
    com.tencent.mm.plugin.editor.model.a.g localg = new com.tencent.mm.plugin.editor.model.a.g();
    Iterator localIterator = this.qNU.iterator();
    Object localObject1 = null;
    Object localObject4;
    Object localObject5;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject4 = (aml)localIterator.next();
      localObject5 = new com.tencent.mm.plugin.editor.model.a.d();
      ((com.tencent.mm.plugin.editor.model.a.d)localObject5).qPN = ((aml)localObject4).Lwp;
      if (((aml)localObject4).dataType == 1) {
        ((com.tencent.mm.plugin.editor.model.a.d)localObject5).qPN = "-1";
      }
      if (Util.isNullOrNil(((com.tencent.mm.plugin.editor.model.a.d)localObject5).qPN))
      {
        Log.e("MicroMsg.EditorUI", "noteItemData.localEditorId is null or nil.");
        AppMethodBeat.o(181609);
        return null;
      }
      if (((com.tencent.mm.plugin.editor.model.a.d)localObject5).qPN.equals("WeNoteHtmlFile"))
      {
        localObject2 = com.tencent.mm.plugin.fav.a.b.d((aml)localObject4);
        if ((Util.isNullOrNil((String)localObject2)) || (!s.YS((String)localObject2))) {
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
            localg.qPT = s.boY((String)localObject2);
            localObject2 = b.alN(localg.qPT);
            localObject1 = localObject2;
            try
            {
              Log.i("MicroMsg.EditorUI", "local html file exist, dataId: %s", new Object[] { ((aml)localObject4).dLl });
              Log.i("MicroMsg.EditorUI", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(Util.isNullOrNil(((aml)localObject4).KuR)), Boolean.valueOf(Util.isNullOrNil(((aml)localObject4).Lvp)) });
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
        ((com.tencent.mm.plugin.editor.model.a.d)localObject5).dLl = ((aml)localObject4).dLl;
        switch (((aml)localObject4).dataType)
        {
        default: 
          break;
        case 1: 
          if (Util.isNullOrNil(((aml)localObject4).desc)) {
            break;
          }
          if ((localg.qPU.size() > 0) && (localg.qPU.get(localg.qPU.size() - 1) != null) && (((com.tencent.mm.plugin.editor.model.a.d)localg.qPU.get(localg.qPU.size() - 1)).qPN.equals("-1")))
          {
            localObject3 = (com.tencent.mm.plugin.editor.model.a.e)localg.qPU.get(localg.qPU.size() - 1);
            ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content = ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content.concat(((aml)localObject4).desc);
            break;
          }
          localObject3 = new com.tencent.mm.plugin.editor.model.a.j();
          ((com.tencent.mm.plugin.editor.model.a.e)localObject3).qPN = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).qPN;
          ((com.tencent.mm.plugin.editor.model.a.e)localObject3).content = ((aml)localObject4).desc;
          localg.qPU.add(localObject3);
          break;
        case 2: 
          localObject3 = new com.tencent.mm.plugin.editor.model.a.h();
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).qPN = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).qPN;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).type = 2;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).dLl = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).dLl;
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).qPM = ((aml)localObject4);
          localObject5 = com.tencent.mm.plugin.fav.a.b.d((aml)localObject4);
          if (Util.isNullOrNil((String)localObject5)) {
            break;
          }
          localObject6 = (String)localObject5 + "_bigthumb";
          s.YS(com.tencent.mm.plugin.fav.a.b.a((aml)localObject4));
          if (s.YS((String)localObject5))
          {
            ((com.tencent.mm.plugin.editor.model.a.c)localObject3).qPO = true;
            b.fK((String)localObject5, (String)localObject6);
          }
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).dUs = ((String)localObject6);
          ((com.tencent.mm.plugin.editor.model.a.c)localObject3).qPL = ((String)localObject5);
          localg.qPU.add(localObject3);
          break;
        case 3: 
          localObject3 = new m();
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).qPN = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).qPN;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).type = 4;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).dLl = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).dLl;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).qPM = ((aml)localObject4);
          localObject5 = com.tencent.mm.plugin.fav.a.b.d((aml)localObject4);
          if ((!Util.isNullOrNil((String)localObject5)) && (s.YS((String)localObject5)))
          {
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).qPO = true;
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).mav = com.tencent.mm.plugin.editor.model.a.qPf;
            ((com.tencent.mm.plugin.editor.model.a.f)localObject3).length = ((int)com.tencent.mm.plugin.editor.model.b.AO(((aml)localObject4).duration));
          }
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).dUs = ((String)localObject5);
          localObject5 = getContext();
          int i = (int)com.tencent.mm.plugin.editor.model.b.AO(((aml)localObject4).duration);
          localObject6 = new hb();
          ((hb)localObject6).dLm.type = 21;
          ((hb)localObject6).dLm.context = ((Context)localObject5);
          ((hb)localObject6).dLm.dLu = i;
          EventCenter.instance.publish((IEvent)localObject6);
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).qPR = ((hb)localObject6).dLn.path;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).dLu = ((aml)localObject4).duration;
          localObject5 = new hb();
          ((hb)localObject5).dLm.type = 17;
          ((hb)localObject5).dLm.dLo = ((aml)localObject4);
          EventCenter.instance.publish((IEvent)localObject5);
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).dLt = ((hb)localObject5).dLn.ret;
          ((com.tencent.mm.plugin.editor.model.a.f)localObject3).qPP = ((aml)localObject4).LvC;
          localg.qPU.add(localObject3);
          break;
        case 4: 
          localObject3 = new l();
          ((l)localObject3).qPN = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).qPN;
          ((l)localObject3).type = 6;
          ((l)localObject3).dLl = ((com.tencent.mm.plugin.editor.model.a.d)localObject5).dLl;
          ((l)localObject3).qPM = ((aml)localObject4);
          ((l)localObject3).duration = ((aml)localObject4).duration;
          ((l)localObject3).thumbPath = com.tencent.mm.plugin.fav.a.b.a((aml)localObject4);
          localObject4 = com.tencent.mm.plugin.fav.a.b.d((aml)localObject4);
          ((l)localObject3).dUs = ((String)localObject4);
          if ((!Util.isNullOrNil(((l)localObject3).thumbPath)) && (!s.YS(((l)localObject3).thumbPath)) && (s.YS((String)localObject4)))
          {
            localObject5 = com.tencent.mm.plugin.fav.ui.e.asm((String)localObject4);
            if (localObject5 == null) {}
          }
          try
          {
            Log.i("MicroMsg.EditorUI", "add fav service: create thumbPath bitmap, saveBitmapToImage ");
            BitmapUtil.saveBitmapToImage((Bitmap)localObject5, 60, Bitmap.CompressFormat.JPEG, ((l)localObject3).thumbPath, true);
            if ((!Util.isNullOrNil((String)localObject4)) && (s.YS((String)localObject4))) {
              ((l)localObject3).qPO = true;
            }
            localg.qPU.add(localObject3);
          }
          catch (Exception localException3)
          {
            Log.printErrStackTrace("MicroMsg.EditorUI", localException3, "", new Object[0]);
          }
        }
      }
      if ((localObject1 != null) && (localObject1.size() > 0)) {
        com.tencent.mm.plugin.editor.model.b.a(localg.qPU, localObject1);
      }
      AppMethodBeat.o(181609);
      return localg;
    }
  }
  
  private void cCT()
  {
    AppMethodBeat.i(181610);
    if (Util.isNullOrNil(b.alQ(com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDw())))
    {
      if (this.qNw)
      {
        this.qNw = false;
        enableOptionMenu(0, false);
        AppMethodBeat.o(181610);
      }
    }
    else if (!this.qNw)
    {
      this.qNw = true;
      enableOptionMenu(0, true);
    }
    AppMethodBeat.o(181610);
  }
  
  private void cCu()
  {
    AppMethodBeat.i(181568);
    try
    {
      this.qNy.atj.notifyChanged();
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
  static boolean fI(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 991
    //   3: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 995	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_1
    //   12: iconst_0
    //   13: invokestatic 999	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
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
    //   37: ldc_w 596
    //   40: invokevirtual 1003	java/lang/String:getBytes	()[B
    //   43: invokevirtual 1008	java/io/OutputStream:write	([B)V
    //   46: aload_1
    //   47: astore 6
    //   49: aload_0
    //   50: astore 5
    //   52: aload_0
    //   53: aload 7
    //   55: invokevirtual 1013	java/io/InputStream:read	([B)I
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
    //   75: invokevirtual 1016	java/io/OutputStream:write	([BII)V
    //   78: goto -32 -> 46
    //   81: astore 7
    //   83: aload_1
    //   84: astore 6
    //   86: aload_0
    //   87: astore 5
    //   89: ldc 235
    //   91: aload 7
    //   93: ldc_w 506
    //   96: iconst_0
    //   97: anewarray 239	java/lang/Object
    //   100: invokestatic 581	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 1017	java/io/InputStream:close	()V
    //   111: aload_1
    //   112: ifnull +221 -> 333
    //   115: aload_1
    //   116: invokevirtual 1018	java/io/OutputStream:close	()V
    //   119: iconst_0
    //   120: istore_3
    //   121: ldc_w 991
    //   124: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iload_3
    //   128: ireturn
    //   129: iconst_1
    //   130: istore_3
    //   131: iload_3
    //   132: istore 4
    //   134: aload_0
    //   135: ifnull +10 -> 145
    //   138: aload_0
    //   139: invokevirtual 1017	java/io/InputStream:close	()V
    //   142: iload_3
    //   143: istore 4
    //   145: iload 4
    //   147: istore_3
    //   148: aload_1
    //   149: ifnull -28 -> 121
    //   152: aload_1
    //   153: invokevirtual 1018	java/io/OutputStream:close	()V
    //   156: iload 4
    //   158: istore_3
    //   159: goto -38 -> 121
    //   162: astore_0
    //   163: ldc 235
    //   165: aload_0
    //   166: ldc_w 506
    //   169: iconst_0
    //   170: anewarray 239	java/lang/Object
    //   173: invokestatic 581	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: iconst_0
    //   177: istore_3
    //   178: goto -57 -> 121
    //   181: astore_0
    //   182: ldc 235
    //   184: aload_0
    //   185: ldc_w 506
    //   188: iconst_0
    //   189: anewarray 239	java/lang/Object
    //   192: invokestatic 581	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: iconst_0
    //   196: istore 4
    //   198: goto -53 -> 145
    //   201: astore_0
    //   202: ldc 235
    //   204: aload_0
    //   205: ldc_w 506
    //   208: iconst_0
    //   209: anewarray 239	java/lang/Object
    //   212: invokestatic 581	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: goto -104 -> 111
    //   218: astore_0
    //   219: ldc 235
    //   221: aload_0
    //   222: ldc_w 506
    //   225: iconst_0
    //   226: anewarray 239	java/lang/Object
    //   229: invokestatic 581	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   248: invokevirtual 1017	java/io/InputStream:close	()V
    //   251: aload 6
    //   253: ifnull +8 -> 261
    //   256: aload 6
    //   258: invokevirtual 1018	java/io/OutputStream:close	()V
    //   261: ldc_w 991
    //   264: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aload_1
    //   268: athrow
    //   269: astore_0
    //   270: ldc 235
    //   272: aload_0
    //   273: ldc_w 506
    //   276: iconst_0
    //   277: anewarray 239	java/lang/Object
    //   280: invokestatic 581	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: goto -32 -> 251
    //   286: astore_0
    //   287: ldc 235
    //   289: aload_0
    //   290: ldc_w 506
    //   293: iconst_0
    //   294: anewarray 239	java/lang/Object
    //   297: invokestatic 581	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void Fr(final int paramInt)
  {
    AppMethodBeat.i(181564);
    this.kAn.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181545);
        Log.i("MicroMsg.EditorUI", "huahuastart: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        EditorUI.g(EditorUI.this).ci(paramInt);
        Log.i("MicroMsg.EditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(181545);
      }
    }, 0L);
    AppMethodBeat.o(181564);
  }
  
  public final void Fs(int paramInt)
  {
    AppMethodBeat.i(181565);
    try
    {
      this.qNy.cj(paramInt);
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
  
  public final void Ft(int paramInt)
  {
    AppMethodBeat.i(181567);
    try
    {
      this.qNy.ck(paramInt);
      AppMethodBeat.o(181567);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.EditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(181567);
    }
  }
  
  public final void Fu(int paramInt)
  {
    AppMethodBeat.i(181573);
    if ((paramInt < 0) || (paramInt >= com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().size()))
    {
      AppMethodBeat.o(181573);
      return;
    }
    this.kAn.post(new EditorUI.2(this, paramInt));
    AppMethodBeat.o(181573);
  }
  
  public final void Q(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(181579);
    if (!this.qNM)
    {
      AppMethodBeat.o(181579);
      return;
    }
    this.kAn.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181525);
        ImageButton localImageButton = (ImageButton)EditorUI.j(EditorUI.this).findViewById(2131302182);
        View localView = EditorUI.j(EditorUI.this).findViewById(2131302183);
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(181525);
          return;
          EditorUI.k(EditorUI.this).setVisibility(8);
          if (!EditorUI.l(EditorUI.this).qTX)
          {
            EditorUI.j(EditorUI.this).setVisibility(8);
            AppMethodBeat.o(181525);
            return;
          }
          EditorUI.j(EditorUI.this).setVisibility(0);
          AppMethodBeat.o(181525);
          return;
          localImageButton.setImageResource(2131690118);
          localView.setVisibility(8);
          EditorUI.j(EditorUI.this).setVisibility(0);
          EditorUI.k(EditorUI.this).setVisibility(8);
          AppMethodBeat.o(181525);
          return;
          EditorUI.j(EditorUI.this).setVisibility(0);
          EditorUI.k(EditorUI.this).setVisibility(8);
          AppMethodBeat.o(181525);
          return;
          localImageButton.setImageResource(2131690117);
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
      if ((com.tencent.mm.plugin.editor.model.nativenote.manager.b.kgc == null) || (com.tencent.mm.plugin.editor.model.nativenote.manager.b.kgc.size() <= 0)) {
        break label38;
      }
    }
    label38:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(181571);
      return;
    }
    ArrayList localArrayList = com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDk();
    if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().U(localArrayList))
    {
      cCx();
      AppMethodBeat.o(181571);
      return;
    }
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a(localArrayList, paramWXRTEditText, true, true, false, false);
    i = paramWXRTEditText.getRecyclerItemPosition();
    int j = localArrayList.size();
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().fx(i, j + i + 1);
    cCD();
    if (this.qNH) {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cDY();
    }
    AppMethodBeat.o(181571);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(181563);
    if (!this.qNM)
    {
      AppMethodBeat.o(181563);
      return;
    }
    Log.d("MicroMsg.EditorUI", "onFocusChanged, poi: %s, focus: %s, editor: %s.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramWXRTEditText });
    CollectEditorLinearLayoutManager localCollectEditorLinearLayoutManager = (CollectEditorLinearLayoutManager)this.qNx.getLayoutManager();
    if (localCollectEditorLinearLayoutManager != null)
    {
      if (this.qNK) {
        localCollectEditorLinearLayoutManager.qOj = false;
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
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().ag(paramInt, true);
    }
    for (;;)
    {
      cCT();
      AppMethodBeat.o(181563);
      return;
      localCollectEditorLinearLayoutManager.qOj = paramBoolean;
      break;
      label124:
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().ag(paramInt, false);
      continue;
      label135:
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().af(-1, false);
    }
  }
  
  final void a(aml paramaml, EditorUI.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(181601);
    Object localObject1;
    if (Util.isNullOrNil(paramaml.Lvp))
    {
      com.tencent.mm.an.f.baR();
      localObject1 = com.tencent.mm.an.a.baG();
      paramaml.bgk((String)localObject1);
      Log.i("MicroMsg.EditorUI", "local not exist cdn data key, generate %s", new Object[] { localObject1 });
    }
    if (EditorUI.b.qOe == paramb) {
      localObject1 = a(paramaml, 0);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        this.qNV.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, localObject1);
        this.qNW.put(((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId, paramaml);
        a((com.tencent.mm.plugin.fav.a.c)localObject1);
      }
      AppMethodBeat.o(181601);
      return;
      localObject1 = localObject2;
      if (EditorUI.b.qOd == paramb) {
        if (Util.isNullOrNil(com.tencent.mm.plugin.fav.a.b.a(paramaml)))
        {
          Log.e("MicroMsg.EditorUI", "insertCdnThumbInfo, type send, path must not be null!");
          localObject1 = localObject2;
        }
        else
        {
          paramb = com.tencent.mm.plugin.fav.a.b.arI(paramaml.dLl);
          localObject1 = new com.tencent.mm.plugin.fav.a.c();
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnKey = paramaml.Lvk;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_cdnUrl = paramaml.iwX;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_dataId = paramb;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_favLocalId = this.qNT.field_localId;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen = ((int)paramaml.LvT);
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_type = 0;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_status = 1;
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_path = com.tencent.mm.plugin.fav.a.b.a(paramaml);
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_modifyTime = Util.nowMilliSecond();
          ((com.tencent.mm.plugin.fav.a.c)localObject1).field_attrFlag |= 1L;
        }
      }
    }
  }
  
  public final void cCA()
  {
    AppMethodBeat.i(181581);
    if (this.qNC != null) {
      this.qNC.a(null);
    }
    AppMethodBeat.o(181581);
  }
  
  public final void cCB()
  {
    AppMethodBeat.i(181582);
    com.tencent.mm.ui.base.h.c(this, getString(2131758287), "", getString(2131758286), getString(2131758285), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(181526);
        com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEi();
        AppMethodBeat.o(181526);
      }
    }, null);
    AppMethodBeat.o(181582);
  }
  
  public final void cCC()
  {
    AppMethodBeat.i(181583);
    Toast.makeText(getContext(), getString(2131763804), 0).show();
    AppMethodBeat.o(181583);
  }
  
  public final void cCD()
  {
    AppMethodBeat.i(181584);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDq();
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(i);
    if (locala != null)
    {
      locala.qPA = false;
      locala.qPG = false;
      Fr(i);
    }
    this.kAn.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181528);
        WXRTEditText localWXRTEditText = EditorUI.f(EditorUI.this).cDO();
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
  
  public final int cCE()
  {
    AppMethodBeat.i(181585);
    if (this.qNL)
    {
      int i = com.tencent.mm.compatible.util.i.getKeyBordHeightPx(this);
      AppMethodBeat.o(181585);
      return i;
    }
    AppMethodBeat.o(181585);
    return 0;
  }
  
  public final int cCF()
  {
    AppMethodBeat.i(181586);
    int j = 0;
    int i = j;
    if (this.qNB != null)
    {
      i = j;
      if (this.qNB.getVisibility() == 0) {
        i = this.qNI + 0;
      }
    }
    j = i;
    if (this.qND != null)
    {
      j = i;
      if (this.qND.getVisibility() == 0) {
        j = i + this.qNI;
      }
    }
    AppMethodBeat.o(181586);
    return j;
  }
  
  public final boolean cCG()
  {
    AppMethodBeat.i(181587);
    if ((this.qNG != null) && (this.qNG.cDO() != null))
    {
      AppMethodBeat.o(181587);
      return true;
    }
    AppMethodBeat.o(181587);
    return false;
  }
  
  public final RecyclerView cCH()
  {
    return this.qNx;
  }
  
  public final RecyclerView cCI()
  {
    return this.qNx;
  }
  
  public final Context cCJ()
  {
    AppMethodBeat.i(181588);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(181588);
    return localAppCompatActivity;
  }
  
  public final com.tencent.mm.plugin.editor.model.nativenote.b.a cCK()
  {
    return this;
  }
  
  public final void cCL()
  {
    AppMethodBeat.i(181589);
    com.tencent.mm.plugin.editor.model.a.j localj = new com.tencent.mm.plugin.editor.model.a.j();
    localj.content = "";
    localj.qPA = true;
    localj.qPG = false;
    localj.qPC = 0;
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDp();
    com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e(localj);
    cCu();
    e(true, 50L);
    Q(1, 0L);
    AppMethodBeat.o(181589);
  }
  
  public final void cCM()
  {
    AppMethodBeat.i(181590);
    com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(getContext(), com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDx());
    AppMethodBeat.o(181590);
  }
  
  public final void cCN()
  {
    AppMethodBeat.i(181591);
    com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(getContext(), com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDx());
    cCL();
    AppMethodBeat.o(181591);
  }
  
  public final void cCO()
  {
    AppMethodBeat.i(181592);
    getContext();
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDn();
    Object localObject;
    if (i == 2)
    {
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDm())
      {
        cCx();
        AppMethodBeat.o(181592);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDp();
      com.tencent.mm.plugin.editor.model.nativenote.manager.b.clearData();
      localObject = new com.tencent.mm.plugin.editor.model.a.j();
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).content = "";
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).qPA = false;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).qPG = false;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).qPC = 0;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).qPI = true;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e((com.tencent.mm.plugin.editor.model.a.a)localObject);
      cCu();
      AppMethodBeat.o(181592);
      return;
    }
    if (i == 3)
    {
      localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDk();
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().U((ArrayList)localObject))
      {
        cCx();
        AppMethodBeat.o(181592);
        return;
      }
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDp();
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a((ArrayList)localObject, null, false, false, false, false);
      cCD();
      AppMethodBeat.o(181592);
      return;
    }
    Log.d("MicroMsg.EditorUI", "no data.");
    AppMethodBeat.o(181592);
  }
  
  public final void cCU()
  {
    AppMethodBeat.i(181611);
    cCT();
    AppMethodBeat.o(181611);
  }
  
  public final void cCv()
  {
    AppMethodBeat.i(181570);
    if (!this.qNC.qTX)
    {
      cCD();
      final AppCompatActivity localAppCompatActivity = getContext();
      this.kAn.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(181546);
          int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().size();
          int j = EditorUI.h(EditorUI.this).getChildCount();
          Object localObject;
          if (i == j)
          {
            float f1 = 0.0F;
            i = j - 1;
            if (i >= 0)
            {
              localObject = EditorUI.h(EditorUI.this).getChildAt(i);
              float f2 = u.ae((View)localObject);
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
            ((com.tencent.mm.plugin.editor.model.nativenote.manager.d)localObject).qQv.showAtLocation(((com.tencent.mm.plugin.editor.model.nativenote.manager.d)localObject).mParentView, 49, 0, arrayOfInt[1] + 50);
          }
          AppMethodBeat.o(181546);
        }
      }, 400L);
    }
    AppMethodBeat.o(181570);
  }
  
  public final void cCw()
  {
    AppMethodBeat.i(181574);
    this.kAn.post(new Runnable()
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
  
  public final void cCx()
  {
    AppMethodBeat.i(181575);
    cCD();
    if (this.qNH) {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cDY();
    }
    this.kAn.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181520);
        com.tencent.mm.ui.base.h.c(EditorUI.this.getContext(), EditorUI.this.getString(2131766710), null, true);
        AppMethodBeat.o(181520);
      }
    }, 100L);
    AppMethodBeat.o(181575);
  }
  
  public final void cCy()
  {
    AppMethodBeat.i(181576);
    com.tencent.mm.ui.base.h.a(this, getString(2131763876), getString(2131763890), getString(2131762043), getString(2131755761), false, new EditorUI.5(this), new EditorUI.6(this));
    AppMethodBeat.o(181576);
  }
  
  public final void cCz()
  {
    AppMethodBeat.i(181580);
    com.tencent.mm.ui.base.h.c(getContext(), getString(2131764269), null, true);
    AppMethodBeat.o(181580);
  }
  
  public final void e(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(181578);
    if (!this.qNM)
    {
      AppMethodBeat.o(181578);
      return;
    }
    this.kAn.postDelayed(new Runnable()
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
  
  public final void ft(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181566);
    try
    {
      this.qNy.as(paramInt1, paramInt2);
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
  
  public final void fu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181569);
    try
    {
      this.qNy.aq(paramInt1, paramInt2);
      AppMethodBeat.o(181569);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.EditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(181569);
    }
  }
  
  public final void fv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181572);
    if (Math.abs(paramInt2 - paramInt1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.qNK = bool;
      AppMethodBeat.o(181572);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493890;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(181599);
    if (!cCP())
    {
      AppMethodBeat.o(181599);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(2131756932), "", getString(2131756033), getString(2131755917), true, new EditorUI.17(this), null);
    AppMethodBeat.o(181599);
  }
  
  public void initView()
  {
    AppMethodBeat.i(181556);
    super.initView();
    setActionbarColor(getContext().getResources().getColor(2131101424));
    setMMTitle("");
    setBackBtn(new EditorUI.11(this));
    addTextOptionMenu(0, getString(2131755970), new MenuItem.OnMenuItemClickListener()
    {
      /* Error */
      public final boolean onMenuItemClick(android.view.MenuItem paramAnonymousMenuItem)
      {
        // Byte code:
        //   0: ldc 25
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 33
        //   7: ldc 35
        //   9: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   12: aload_0
        //   13: getfield 14	com/tencent/mm/plugin/editor/EditorUI$21:qNX	Lcom/tencent/mm/plugin/editor/EditorUI;
        //   16: astore 6
        //   18: aload 6
        //   20: getfield 44	com/tencent/mm/plugin/editor/EditorUI:qNC	Lcom/tencent/mm/plugin/editor/widget/a;
        //   23: aload 6
        //   25: invokevirtual 50	com/tencent/mm/plugin/editor/widget/a:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/b/a;)V
        //   28: invokestatic 56	com/tencent/mm/plugin/editor/model/nativenote/manager/c:cDo	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/c;
        //   31: invokevirtual 60	com/tencent/mm/plugin/editor/model/nativenote/manager/c:cDw	()Ljava/lang/String;
        //   34: astore_1
        //   35: aload_1
        //   36: invokestatic 64	com/tencent/mm/plugin/editor/EditorUI:alG	(Ljava/lang/String;)Z
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
        //   78: invokestatic 83	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;ZLandroid/content/DialogInterface$OnCancelListener;)Lcom/tencent/mm/ui/base/q;
        //   81: putfield 87	com/tencent/mm/plugin/editor/EditorUI:pqa	Landroid/app/ProgressDialog;
        //   84: invokestatic 56	com/tencent/mm/plugin/editor/model/nativenote/manager/c:cDo	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/c;
        //   87: aload_1
        //   88: invokevirtual 91	com/tencent/mm/plugin/editor/model/nativenote/manager/c:alU	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/anb;
        //   91: astore_1
        //   92: aload_1
        //   93: ifnonnull +17 -> 110
        //   96: ldc 33
        //   98: ldc 93
        //   100: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   103: ldc 25
        //   105: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   108: iconst_1
        //   109: ireturn
        //   110: aload 6
        //   112: getfield 103	com/tencent/mm/plugin/editor/EditorUI:qNU	Ljava/util/LinkedList;
        //   115: invokevirtual 108	java/util/LinkedList:clear	()V
        //   118: aload 6
        //   120: getfield 103	com/tencent/mm/plugin/editor/EditorUI:qNU	Ljava/util/LinkedList;
        //   123: aload_1
        //   124: getfield 113	com/tencent/mm/protocal/protobuf/anb:ppH	Ljava/util/LinkedList;
        //   127: invokevirtual 117	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
        //   130: pop
        //   131: aload 6
        //   133: aload 6
        //   135: getfield 103	com/tencent/mm/plugin/editor/EditorUI:qNU	Ljava/util/LinkedList;
        //   138: invokestatic 123	java/lang/System:currentTimeMillis	()J
        //   141: invokestatic 128	com/tencent/mm/plugin/fav/ui/k:a	(Ljava/util/LinkedList;J)Lcom/tencent/mm/plugin/fav/a/g;
        //   144: putfield 132	com/tencent/mm/plugin/editor/EditorUI:qNT	Lcom/tencent/mm/plugin/fav/a/g;
        //   147: iconst_0
        //   148: istore_2
        //   149: iload_2
        //   150: aload 6
        //   152: getfield 103	com/tencent/mm/plugin/editor/EditorUI:qNU	Ljava/util/LinkedList;
        //   155: invokevirtual 136	java/util/LinkedList:size	()I
        //   158: if_icmpge -55 -> 103
        //   161: aload 6
        //   163: getfield 103	com/tencent/mm/plugin/editor/EditorUI:qNU	Ljava/util/LinkedList;
        //   166: iload_2
        //   167: invokevirtual 140	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   170: checkcast 142	com/tencent/mm/protocal/protobuf/aml
        //   173: astore 7
        //   175: aload 7
        //   177: getfield 146	com/tencent/mm/protocal/protobuf/aml:dLl	Ljava/lang/String;
        //   180: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   183: ifeq +25 -> 208
        //   186: aload 7
        //   188: aload 7
        //   190: invokevirtual 154	java/lang/Object:toString	()Ljava/lang/String;
        //   193: aload 6
        //   195: getfield 132	com/tencent/mm/plugin/editor/EditorUI:qNT	Lcom/tencent/mm/plugin/fav/a/g;
        //   198: getfield 160	com/tencent/mm/plugin/fav/a/g:field_type	I
        //   201: invokestatic 166	com/tencent/mm/plugin/fav/a/b:ds	(Ljava/lang/String;I)Ljava/lang/String;
        //   204: invokevirtual 170	com/tencent/mm/protocal/protobuf/aml:bgs	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aml;
        //   207: pop
        //   208: aload 7
        //   210: getfield 173	com/tencent/mm/protocal/protobuf/aml:LvL	Ljava/lang/String;
        //   213: astore_1
        //   214: aload_1
        //   215: invokestatic 178	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
        //   218: ifeq +240 -> 458
        //   221: aload_1
        //   222: invokestatic 184	com/tencent/mm/b/g:getMD5	(Ljava/lang/String;)Ljava/lang/String;
        //   225: astore 5
        //   227: aload_1
        //   228: invokestatic 187	com/tencent/mm/b/g:fb	(Ljava/lang/String;)Ljava/lang/String;
        //   231: astore 8
        //   233: aload 7
        //   235: aload 5
        //   237: invokevirtual 190	com/tencent/mm/protocal/protobuf/aml:bgq	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aml;
        //   240: pop
        //   241: aload 7
        //   243: aload 8
        //   245: invokevirtual 193	com/tencent/mm/protocal/protobuf/aml:bgr	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aml;
        //   248: pop
        //   249: aload 7
        //   251: new 195	com/tencent/mm/vfs/o
        //   254: dup
        //   255: aload_1
        //   256: invokespecial 198	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
        //   259: invokevirtual 201	com/tencent/mm/vfs/o:length	()J
        //   262: invokevirtual 205	com/tencent/mm/protocal/protobuf/aml:Mu	(J)Lcom/tencent/mm/protocal/protobuf/aml;
        //   265: pop
        //   266: aload 7
        //   268: invokestatic 209	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/aml;)Ljava/lang/String;
        //   271: astore 5
        //   273: aload_1
        //   274: aload 5
        //   276: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   279: ifne +10 -> 289
        //   282: aload_1
        //   283: aload 5
        //   285: invokestatic 219	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
        //   288: pop2
        //   289: aload 6
        //   291: aload 7
        //   293: getstatic 225	com/tencent/mm/plugin/editor/EditorUI$b:qOe	Lcom/tencent/mm/plugin/editor/EditorUI$b;
        //   296: invokevirtual 228	com/tencent/mm/plugin/editor/EditorUI:a	(Lcom/tencent/mm/protocal/protobuf/aml;Lcom/tencent/mm/plugin/editor/EditorUI$b;)V
        //   299: aload 7
        //   301: getfield 231	com/tencent/mm/protocal/protobuf/aml:LvN	Ljava/lang/String;
        //   304: astore 8
        //   306: aload 8
        //   308: invokestatic 178	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
        //   311: ifeq +228 -> 539
        //   314: aconst_null
        //   315: astore_1
        //   316: aload 8
        //   318: invokestatic 235	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
        //   321: astore 5
        //   323: aload 5
        //   325: astore_1
        //   326: aload 5
        //   328: sipush 4096
        //   331: invokestatic 239	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
        //   334: invokestatic 242	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
        //   337: astore 9
        //   339: aload 5
        //   341: astore_1
        //   342: aload 8
        //   344: invokestatic 246	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
        //   347: lstore_3
        //   348: aload 5
        //   350: astore_1
        //   351: aload 5
        //   353: iconst_0
        //   354: sipush 256
        //   357: invokestatic 249	com/tencent/mm/b/g:a	(Ljava/io/InputStream;II)Ljava/lang/String;
        //   360: astore 10
        //   362: aload 5
        //   364: astore_1
        //   365: aload 7
        //   367: aload 9
        //   369: invokevirtual 252	com/tencent/mm/protocal/protobuf/aml:bgv	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aml;
        //   372: pop
        //   373: aload 5
        //   375: astore_1
        //   376: aload 7
        //   378: aload 10
        //   380: invokevirtual 255	com/tencent/mm/protocal/protobuf/aml:bgw	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aml;
        //   383: pop
        //   384: aload 5
        //   386: astore_1
        //   387: aload 7
        //   389: lload_3
        //   390: invokevirtual 258	com/tencent/mm/protocal/protobuf/aml:Mv	(J)Lcom/tencent/mm/protocal/protobuf/aml;
        //   393: pop
        //   394: aload 5
        //   396: astore_1
        //   397: aload 7
        //   399: invokestatic 260	com/tencent/mm/plugin/fav/a/b:a	(Lcom/tencent/mm/protocal/protobuf/aml;)Ljava/lang/String;
        //   402: astore 9
        //   404: aload 5
        //   406: astore_1
        //   407: aload 8
        //   409: aload 9
        //   411: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   414: ifne +14 -> 428
        //   417: aload 5
        //   419: astore_1
        //   420: aload 8
        //   422: aload 9
        //   424: invokestatic 219	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
        //   427: pop2
        //   428: aload 5
        //   430: astore_1
        //   431: aload 6
        //   433: aload 7
        //   435: getstatic 263	com/tencent/mm/plugin/editor/EditorUI$b:qOd	Lcom/tencent/mm/plugin/editor/EditorUI$b;
        //   438: invokevirtual 228	com/tencent/mm/plugin/editor/EditorUI:a	(Lcom/tencent/mm/protocal/protobuf/aml;Lcom/tencent/mm/plugin/editor/EditorUI$b;)V
        //   441: aload 5
        //   443: ifnull +8 -> 451
        //   446: aload 5
        //   448: invokevirtual 268	java/io/InputStream:close	()V
        //   451: iload_2
        //   452: iconst_1
        //   453: iadd
        //   454: istore_2
        //   455: goto -306 -> 149
        //   458: ldc 33
        //   460: ldc_w 270
        //   463: iconst_2
        //   464: anewarray 4	java/lang/Object
        //   467: dup
        //   468: iconst_0
        //   469: aload 7
        //   471: getfield 273	com/tencent/mm/protocal/protobuf/aml:dataType	I
        //   474: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   477: aastore
        //   478: dup
        //   479: iconst_1
        //   480: aload_1
        //   481: aastore
        //   482: invokestatic 282	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   485: goto -186 -> 299
        //   488: astore_1
        //   489: aconst_null
        //   490: astore_1
        //   491: ldc 33
        //   493: ldc_w 284
        //   496: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   499: aload_1
        //   500: ifnull -49 -> 451
        //   503: aload_1
        //   504: invokevirtual 268	java/io/InputStream:close	()V
        //   507: goto -56 -> 451
        //   510: astore_1
        //   511: goto -60 -> 451
        //   514: astore 5
        //   516: aload_1
        //   517: astore 6
        //   519: aload 5
        //   521: astore_1
        //   522: aload 6
        //   524: ifnull +8 -> 532
        //   527: aload 6
        //   529: invokevirtual 268	java/io/InputStream:close	()V
        //   532: ldc 25
        //   534: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   537: aload_1
        //   538: athrow
        //   539: ldc 33
        //   541: ldc_w 286
        //   544: iconst_1
        //   545: anewarray 4	java/lang/Object
        //   548: dup
        //   549: iconst_0
        //   550: aload 8
        //   552: aastore
        //   553: invokestatic 282	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   556: goto -105 -> 451
        //   559: astore_1
        //   560: goto -109 -> 451
        //   563: astore 5
        //   565: goto -33 -> 532
        //   568: astore 5
        //   570: aload_1
        //   571: astore 6
        //   573: aload 5
        //   575: astore_1
        //   576: goto -54 -> 522
        //   579: astore_1
        //   580: aload 5
        //   582: astore_1
        //   583: goto -92 -> 491
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	586	0	this	21
        //   0	586	1	paramAnonymousMenuItem	android.view.MenuItem
        //   148	307	2	i	int
        //   347	43	3	l	long
        //   47	400	5	localObject1	Object
        //   514	6	5	localObject2	Object
        //   563	1	5	localException	Exception
        //   568	13	5	localObject3	Object
        //   16	556	6	localObject4	Object
        //   173	297	7	localaml	aml
        //   231	320	8	str1	String
        //   337	86	9	str2	String
        //   360	19	10	str3	String
        // Exception table:
        //   from	to	target	type
        //   316	323	488	java/io/FileNotFoundException
        //   503	507	510	java/lang/Exception
        //   316	323	514	finally
        //   326	339	514	finally
        //   342	348	514	finally
        //   351	362	514	finally
        //   365	373	514	finally
        //   376	384	514	finally
        //   387	394	514	finally
        //   397	404	514	finally
        //   407	417	514	finally
        //   420	428	514	finally
        //   431	441	514	finally
        //   446	451	559	java/lang/Exception
        //   527	532	563	java/lang/Exception
        //   491	499	568	finally
        //   326	339	579	java/io/FileNotFoundException
        //   342	348	579	java/io/FileNotFoundException
        //   351	362	579	java/io/FileNotFoundException
        //   365	373	579	java/io/FileNotFoundException
        //   376	384	579	java/io/FileNotFoundException
        //   387	394	579	java/io/FileNotFoundException
        //   397	404	579	java/io/FileNotFoundException
        //   407	417	579	java/io/FileNotFoundException
        //   420	428	579	java/io/FileNotFoundException
        //   431	441	579	java/io/FileNotFoundException
      }
    }, null, t.b.OGU);
    enableOptionMenu(0, this.qNw);
    getContentView().getRootView().setBackgroundColor(getContext().getResources().getColor(2131101424));
    this.qNG = new com.tencent.mm.plugin.editor.model.nativenote.manager.j(this);
    this.qNG.qRR = this.qNM;
    this.qNx = ((RecyclerView)findViewById(2131298860));
    this.qNB = ((LinearLayout)findViewById(2131298859));
    this.qNC = new com.tencent.mm.plugin.editor.widget.a();
    Object localObject = this.qNC;
    LinearLayout localLinearLayout = this.qNB;
    ((com.tencent.mm.plugin.editor.widget.a)localObject).psf = localLinearLayout;
    com.tencent.mm.plugin.editor.model.nativenote.manager.j.cDP().qRQ = ((com.tencent.mm.plugin.editor.model.nativenote.b.b)localObject);
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTN = ((WeImageButton)localLinearLayout.findViewById(2131302182));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTO = ((WeImageButton)localLinearLayout.findViewById(2131302186));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTP = ((WeImageButton)localLinearLayout.findViewById(2131302185));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTQ = ((WeImageButton)localLinearLayout.findViewById(2131302187));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTR = ((LinearLayout)localLinearLayout.findViewById(2131302188));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTS = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).qTR.findViewById(2131310539));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTT = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).qTR.findViewById(2131310537));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTU = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).qTR.findViewById(2131310538));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTV = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).qTR.findViewById(2131304866));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTW = ((LinearLayout)((com.tencent.mm.plugin.editor.widget.a)localObject).qTR.findViewById(2131310532));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTN.setOnClickListener(new a.1((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTO.setOnClickListener(new a.5((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qUd = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYM, true);
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTP.setOnClickListener(new a.6((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTQ.setOnClickListener(new a.7((com.tencent.mm.plugin.editor.widget.a)localObject, this, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTS.setOnClickListener(new a.8((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTT.setOnClickListener(new a.9((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTU.setOnClickListener(new a.10((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTV.setOnClickListener(new a.11((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    ((com.tencent.mm.plugin.editor.widget.a)localObject).qTW.setOnClickListener(new a.12((com.tencent.mm.plugin.editor.widget.a)localObject, this));
    this.qND = ((LinearLayout)this.qNB.findViewById(2131302188));
    this.qND.setVisibility(8);
    this.qNE = ((RelativeLayout)findViewById(2131310475));
    this.qNE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181517);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/EditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (EditorUI.a(EditorUI.this) != null) {
          EditorUI.a(EditorUI.this).qQv.dismiss();
        }
        EditorUI.b(EditorUI.this).setVisibility(8);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181517);
      }
    });
    this.qNF = new com.tencent.mm.plugin.editor.model.nativenote.manager.d(this, this.qNE);
    this.qNF.qQw = this;
    this.qNz = new CollectEditorLinearLayoutManager();
    this.qNz.qOi = com.tencent.mm.compatible.util.i.getScreenWH(this)[1];
    this.qNx.setLayoutManager(this.qNz);
    this.qNx.setHasFixedSize(true);
    this.qNA = new EditorUI.a(this);
    this.qNx.a(this.qNA);
    this.qNy = new com.tencent.mm.plugin.editor.adapter.b(this.qNG);
    this.qNx.setAdapter(this.qNy);
    if (this.qNM)
    {
      localObject = new com.tencent.mm.plugin.editor.model.a.j();
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).content = "";
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).qPA = true;
      ((com.tencent.mm.plugin.editor.model.a.j)localObject).qPG = false;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e((com.tencent.mm.plugin.editor.model.a.a)localObject);
      e(true, 300L);
      Q(1, 0L);
      this.qNx.setOnTouchListener(this.qNS);
    }
    for (;;)
    {
      this.qNx.getItemAnimator().atn = 0L;
      this.qNx.getItemAnimator().atq = 0L;
      this.qNx.getItemAnimator().atp = 0L;
      this.qNx.getItemAnimator().ato = 120L;
      ((as)this.qNx.getItemAnimator()).awI = false;
      AppMethodBeat.o(181556);
      return;
      this.qNB.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(181559);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.EditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.qNP = paramInt1;
    if (paramInt2 != -1)
    {
      this.qNO = false;
      AppMethodBeat.o(181559);
      return;
    }
    this.qNO = true;
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
        if (!com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().fw(0, paramIntent.size())) {
          break;
        }
        cCx();
        AppMethodBeat.o(181559);
        return;
        Log.i("MicroMsg.EditorUI", "no pic selected");
      }
      alF((String)paramIntent.get(0));
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
        alF((String)localObject);
      }
      if ((paramIntent.BOe.booleanValue()) && (!Util.isNullOrNil(paramIntent.thumbPath)))
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
        localObject = paramIntent.zsA;
        if (!Util.isNullOrNil((String)localObject)) {
          alF((String)localObject);
        }
        if ((paramIntent.zsy) && (!Util.isNullOrNil(paramIntent.zsG)))
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramIntent.zsG);
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
    if (this.qNH)
    {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().ln(false);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().lm(false);
    }
    AppMethodBeat.o(181596);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(181555);
    customfixStatusbar(true);
    Object localObject1 = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).mDataList = new ArrayList();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).qQp = this;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).qQq = new aml();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).qQr = 0;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).qQs = 0;
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject1).qQt = 0;
    super.onCreate(paramBundle);
    this.qNM = getIntent().getBooleanExtra("KEY_EDITABLE", false);
    this.qNN = getIntent().getStringExtra("KEY_CONTENT_XML");
    if (Util.isNullOrNil(this.qNN))
    {
      this.qNN = "";
      this.qNw = false;
    }
    Log.i("MicroMsg.EditorUI", "mCollectEditable: %s, mCollectContentXml: %s", new Object[] { Boolean.valueOf(this.qNM), this.qNN });
    this.kAn = new MMHandler();
    initView();
    this.qNI = com.tencent.mm.cb.a.fromDPToPix(this, 48);
    if (this.qNH)
    {
      Log.i("MicroMsg.EditorUI", "use multiselect");
      int i = getResources().getColor(2131100299);
      paramBundle = com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT();
      boolean bool = this.qNM;
      Log.i("EditorSelectManager", "onInit start");
      paramBundle.qSq = bool;
      paramBundle.qSt = 14;
      paramBundle.qSu = 32;
      paramBundle.qSv = (com.tencent.mm.cb.a.fromDPToPix(this, 21) - paramBundle.qSu);
      paramBundle.qSw = (com.tencent.mm.cb.a.fromDPToPix(this, 40) + paramBundle.qSu * 2);
      paramBundle.qSx = (com.tencent.mm.cb.a.fromDPToPix(this, 240) + paramBundle.qSu * 2);
      paramBundle.qSr = com.tencent.mm.cb.a.fromDPToPix(this, 22);
      paramBundle.qSs = com.tencent.mm.cb.a.fromDPToPix(this, 1);
      paramBundle.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
      paramBundle.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
      paramBundle.qSB = new int[] { -1, -1 };
      paramBundle.qSC = new int[] { -1, -1 };
      paramBundle.qSD = new int[] { -1, -1 };
      paramBundle.qSE = new int[] { -1, -1 };
      localObject1 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 2, paramBundle.qSr, paramBundle.qSs, i, paramBundle);
      paramBundle.qSF = new PopupWindow((View)localObject1, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.qSF.setClippingEnabled(false);
      paramBundle.qSF.setAnimationStyle(2131821753);
      paramBundle.qSz = ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getOffsetForCursorMid();
      paramBundle.qSA = com.tencent.mm.cb.a.fromDPToPix(this, 6);
      Object localObject2 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 3, paramBundle.qSr, paramBundle.qSs, i, paramBundle);
      paramBundle.qSG = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.qSG.setClippingEnabled(false);
      paramBundle.qSG.setAnimationStyle(2131821752);
      localObject2 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 4, paramBundle.qSr, paramBundle.qSs, i, paramBundle);
      paramBundle.qSH = new PopupWindow((View)localObject2, ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject2).getViewWidth(), ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewHeight(), false);
      paramBundle.qSH.setClippingEnabled(false);
      paramBundle.qSH.setAnimationStyle(2131821754);
      localObject2 = LayoutInflater.from(this).inflate(2131493888, null);
      ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramBundle.qSI = new PopupWindow((View)localObject2, -2, -2, false);
      paramBundle.qSI.setBackgroundDrawable(getResources().getDrawable(2131235152));
      paramBundle.qSI.setClippingEnabled(false);
      paramBundle.qSI.setAnimationStyle(2131821756);
      paramBundle.qSO = ((TextView)((View)localObject2).findViewById(2131305500));
      paramBundle.qSP = ((TextView)((View)localObject2).findViewById(2131305529));
      paramBundle.qSQ = ((TextView)((View)localObject2).findViewById(2131305526));
      paramBundle.qSR = ((TextView)((View)localObject2).findViewById(2131305525));
      paramBundle.qSS = ((TextView)((View)localObject2).findViewById(2131305510));
      paramBundle.qST = ((TextView)((View)localObject2).findViewById(2131305509));
      paramBundle.qSU = ((TextView)((View)localObject2).findViewById(2131305508));
      paramBundle.qSV = ((TextView)((View)localObject2).findViewById(2131305521));
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.qSO, paramBundle.qSt);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.qSP, paramBundle.qSt);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.qSQ, paramBundle.qSt);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.qSR, paramBundle.qSt);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.qSS, paramBundle.qSt);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.qST, paramBundle.qSt);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.qSU, paramBundle.qSt);
      com.tencent.mm.plugin.editor.model.nativenote.c.e.i(paramBundle.qSV, paramBundle.qSt);
      paramBundle.qSO.setOnClickListener(new e.10(paramBundle));
      paramBundle.qSP.setOnClickListener(new e.11(paramBundle));
      paramBundle.qSQ.setOnClickListener(new e.12(paramBundle));
      paramBundle.qSR.setOnClickListener(new e.13(paramBundle));
      paramBundle.qSS.setOnClickListener(new e.2(paramBundle));
      paramBundle.qST.setOnClickListener(new e.3(paramBundle));
      paramBundle.qSU.setOnClickListener(new e.4(paramBundle));
      paramBundle.qSV.setOnClickListener(new e.5(paramBundle));
      paramBundle.qSy = ((com.tencent.mm.plugin.editor.model.nativenote.c.a)localObject1).getViewPadding();
      paramBundle.qSJ = this;
      paramBundle.qSK = new com.tencent.mm.plugin.editor.model.nativenote.c.d();
      paramBundle.qSL = new com.tencent.mm.plugin.editor.model.nativenote.c.b();
      paramBundle.mHandler = new MMHandler();
      com.tencent.mm.plugin.editor.model.nativenote.c.e.mHasInit = true;
      Log.i("EditorSelectManager", "onInit end");
      this.qNJ = new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(181533);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(181533);
            return;
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEc();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEa();
            continue;
            boolean bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEb();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().ln(bool);
            bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cDZ();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().lm(bool);
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().f(false, 50L);
          }
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(181534);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if (paramAnonymousInt2 > 30)
          {
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEc();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEa();
          }
          localObject = com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cDV();
          if (((EditorUI.i(EditorUI.this)) || ((EditorUI.j(EditorUI.this) != null) && (EditorUI.j(EditorUI.this).getVisibility() == 0))) && (((com.tencent.mm.plugin.editor.model.nativenote.c.d)localObject).getSelectType() == 2) && (com.tencent.mm.plugin.editor.model.nativenote.c.f.d(paramAnonymousRecyclerView, ((com.tencent.mm.plugin.editor.model.nativenote.c.d)localObject).bNu) == null)) {
            EditorUI.this.cCD();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(181534);
        }
      };
      this.qNx.a(this.qNJ);
    }
    cCQ();
    AppMethodBeat.o(181555);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(181594);
    super.onDestroy();
    if (this.qNH)
    {
      if (this.qNx != null) {
        this.qNx.b(this.qNJ);
      }
      localObject = com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT();
      Log.i("EditorSelectManager", "onDestroy");
      com.tencent.mm.plugin.editor.model.nativenote.c.e.mHasInit = false;
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).qSM != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).qSM.stopTimer();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).qSN != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).qSN.stopTimer();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).qSF != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).qSF.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).qSG != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).qSG.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).qSH != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).qSH.dismiss();
      }
      if (((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).qSI != null) {
        ((com.tencent.mm.plugin.editor.model.nativenote.c.e)localObject).qSI.dismiss();
      }
      com.tencent.mm.plugin.editor.model.nativenote.c.e.qSp = null;
    }
    if (this.qNG != null)
    {
      localObject = this.qNG;
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.j.qRM == localObject) {
        com.tencent.mm.plugin.editor.model.nativenote.manager.j.qRM = null;
      }
    }
    Object localObject = com.tencent.mm.plugin.editor.widget.voiceview.a.cEC();
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).stopPlay();
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).qUq = null;
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).qUp = null;
    ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject).callbacks.clear();
    com.tencent.mm.plugin.editor.widget.voiceview.a.qUk = null;
    if (com.tencent.mm.plugin.editor.model.c.cDf() != null)
    {
      com.tencent.mm.plugin.editor.model.c.cDf();
      com.tencent.mm.plugin.editor.model.c.destroy();
    }
    localObject = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo();
    ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).qQp = null;
    if (((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).mDataList != null)
    {
      localObject = ((com.tencent.mm.plugin.editor.model.nativenote.manager.c)localObject).mDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.editor.model.a.a locala = (com.tencent.mm.plugin.editor.model.a.a)((Iterator)localObject).next();
        locala.qPF = null;
        locala.qPD = null;
        locala.qPE = null;
      }
    }
    AppMethodBeat.o(181594);
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(181595);
    super.onDrag();
    if (this.qNH)
    {
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEc();
      com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEa();
    }
    if (this.qNL)
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
      this.qNL = bool;
      if (this.qNL) {
        Q(1, 0L);
      }
      if (this.qNH) {
        this.kAn.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181532);
            boolean bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEb();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().ln(bool);
            bool = com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cDZ();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().lm(bool);
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
    if (this.qNC != null) {
      this.qNC.a(this);
    }
    if (com.tencent.mm.plugin.editor.widget.voiceview.a.cEC().cEF()) {
      com.tencent.mm.plugin.editor.widget.voiceview.a.cEC().stopPlay();
    }
    this.qNQ = this.qNL;
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
        cCy();
        AppMethodBeat.o(181577);
        return;
        if ((com.tencent.mm.aw.b.Pi((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null))) && (paramArrayOfInt[0] != 0)) {
          com.tencent.mm.ui.base.h.a(getContext(), getString(2131763874), getString(2131763890), getString(2131762043), getString(2131755761), false, new EditorUI.7(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(181557);
    super.onResume();
    if (this.qNM) {
      switch (this.qNP)
      {
      }
    }
    for (;;)
    {
      this.qNP = -1;
      this.qNO = false;
      if (isSupportNavigationSwipeBack()) {
        getSwipeBackLayout().setEnableGesture(false);
      }
      AppMethodBeat.o(181557);
      return;
      if (this.qNQ)
      {
        e(true, 100L);
        Q(1, 0L);
        continue;
        if (!this.qNO)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI
 * JD-Core Version:    0.7.0.1
 */