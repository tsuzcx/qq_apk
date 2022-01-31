package com.tencent.mm.plugin.emojicapture.ui;

import a.h.l;
import a.h.l.a;
import a.h.l.b;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mm.f.b.g.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.a.e;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.c.a.b;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.model.c.a;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.ttpic.baseutils.SourcePathUtil;

@com.tencent.mm.ui.base.a(3)
public final class EmojiCaptureUI
  extends MMActivity
{
  public static final EmojiCaptureUI.a jor = new EmojiCaptureUI.a((byte)0);
  private final String TAG = "MicroMsg.EmojiCaptureUI";
  private CaptureContainer jom;
  private CaptureEditorContainer jon;
  private com.tencent.mm.plugin.emojicapture.c.a.a joo;
  private b.a jop;
  private final EmojiCaptureUI.e joq = new EmojiCaptureUI.e(this);
  private int state;
  
  public final void finish()
  {
    super.finish();
    c.a locala = com.tencent.mm.plugin.emojicapture.model.c.jko;
    com.tencent.mm.vfs.e.bL(c.a.aKe());
    overridePendingTransition(-1, com.tencent.mm.plugin.emojicapture.a.a.anim_emoji_capture_exit);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.e.emoji_capture_ui;
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i(this.TAG, "onActivityResult " + paramInt1 + ", " + paramInt2);
    Object localObject2;
    Object localObject1;
    switch (paramInt1)
    {
    default: 
      return;
    case 1001: 
      switch (paramInt2)
      {
      case 0: 
      case 1: 
      default: 
        paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
        com.tencent.mm.plugin.emojicapture.f.a.a.cG(8, 1);
        return;
      case -1: 
        if (paramIntent != null)
        {
          localObject2 = paramIntent.getStringExtra("extra_id");
          localObject1 = paramIntent.getStringExtra("activityId");
          paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
          paramIntent = (Intent)localObject2;
          if (localObject2 == null) {
            paramIntent = "";
          }
          com.tencent.mm.plugin.emojicapture.f.a.Bl(paramIntent);
          paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
          if (localObject1 != null) {
            break label1225;
          }
        }
        break;
      }
      break;
    }
    label545:
    label553:
    label1219:
    label1225:
    for (paramIntent = "";; paramIntent = (Intent)localObject1)
    {
      com.tencent.mm.plugin.emojicapture.f.a.Bm(paramIntent);
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.dB(System.currentTimeMillis());
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      long l1 = com.tencent.mm.plugin.emojicapture.f.a.aKu();
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.dG(l1 - com.tencent.mm.plugin.emojicapture.f.a.aKt());
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      l1 = com.tencent.mm.plugin.emojicapture.f.a.aKu();
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.dE(l1 - com.tencent.mm.plugin.emojicapture.f.a.aKo());
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.a.a(18, com.tencent.mm.plugin.emojicapture.f.a.aKx(), 0L, 0L);
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
      l1 = com.tencent.mm.plugin.emojicapture.f.a.aKo();
      long l2 = com.tencent.mm.plugin.emojicapture.f.a.aKx();
      long l3 = com.tencent.mm.plugin.emojicapture.f.a.aKv();
      long l4 = com.tencent.mm.plugin.emojicapture.f.a.aKw();
      long l5 = com.tencent.mm.plugin.emojicapture.f.a.aKy();
      long l6 = com.tencent.mm.plugin.emojicapture.f.a.aKz();
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.aKA();
      Object localObject3;
      int j;
      if (paramIntent != null)
      {
        a.d.b.g.k(paramIntent, "$receiver");
        a.d.b.g.k(",", "oldValue");
        a.d.b.g.k(" ", "newValue");
        paramIntent = (CharSequence)paramIntent;
        localObject2 = new String[1];
        localObject2[0] = ",";
        a.d.b.g.k(paramIntent, "$receiver");
        a.d.b.g.k(localObject2, "delimiters");
        localObject2 = (a.g.a)new a.h.d(paramIntent, (a.d.a.c)new l.a(a.a.a.asList((Object[])localObject2)));
        paramIntent = (a.d.a.b)new l.b(paramIntent);
        a.d.b.g.k(localObject2, "$receiver");
        a.d.b.g.k(paramIntent, "transform");
        paramIntent = (a.g.a)new a.g.e((a.g.a)localObject2, paramIntent);
        localObject2 = (CharSequence)" ";
        localObject3 = (CharSequence)"";
        CharSequence localCharSequence1 = (CharSequence)"";
        CharSequence localCharSequence2 = (CharSequence)"...";
        a.d.b.g.k(paramIntent, "$receiver");
        a.d.b.g.k(localObject2, "separator");
        a.d.b.g.k(localObject3, "prefix");
        a.d.b.g.k(localCharSequence1, "postfix");
        a.d.b.g.k(localCharSequence2, "truncated");
        paramIntent = ((StringBuilder)a.g.b.a(paramIntent, (Appendable)new StringBuilder(), (CharSequence)localObject2, (CharSequence)localObject3, localCharSequence1, localCharSequence2)).toString();
        a.d.b.g.j(paramIntent, "joinTo(StringBuilder(), …ed, transform).toString()");
        localObject2 = Integer.toHexString(com.tencent.mm.plugin.emojicapture.f.a.aKB() & 0xFFFFFF);
        if (!com.tencent.mm.plugin.emojicapture.f.a.aKC()) {
          break label714;
        }
        paramInt1 = 1;
        if (!com.tencent.mm.plugin.emojicapture.f.a.aKD()) {
          break label719;
        }
        paramInt2 = 1;
        j = com.tencent.mm.plugin.emojicapture.f.a.aKE();
        if (!com.tencent.mm.plugin.emojicapture.f.a.aKF()) {
          break label724;
        }
      }
      label714:
      label719:
      label724:
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(15989, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), paramIntent, localObject2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.emojicapture.f.a.aKG()), com.tencent.mm.plugin.emojicapture.f.a.aKH(), com.tencent.mm.plugin.emojicapture.f.a.aKI(), com.tencent.mm.plugin.emojicapture.f.a.aKJ() });
        finish();
        return;
        paramIntent = null;
        break;
        paramInt1 = 0;
        break label545;
        paramInt2 = 0;
        break label553;
      }
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.a.cG(6, 1);
      return;
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.a.cG(7, 1);
      return;
      if (paramIntent == null) {
        break;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("CropImageMode", 3);
      ((Intent)localObject1).putExtra("CropImage_OutputPath", com.tencent.mm.plugin.emoji.h.b.FL());
      ((Intent)localObject1).setClassName((Context)czi(), "com.tencent.mm.ui.tools.CropImageNewUI");
      com.tencent.mm.ui.tools.a.a((Activity)czi(), paramIntent, (Intent)localObject1, com.tencent.mm.plugin.emoji.h.b.aJL(), 1003);
      paramIntent = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.a.a(8, 0L, 0L, 0L);
      return;
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getStringExtra("CropImage_OutputPath");
        label848:
        if (paramIntent == null) {
          break label1141;
        }
        paramIntent = Integer.valueOf(paramIntent.getIntExtra("emoji_type", 0));
        label864:
        paramInt2 = (int)com.tencent.mm.vfs.e.aeQ((String)localObject1);
        if (localObject1 == null) {
          break;
        }
        if (((CharSequence)localObject1).length() != 0) {
          break label1146;
        }
        paramInt1 = 1;
        label891:
        if (paramInt1 != 0) {
          break label1149;
        }
        localObject2 = (CharSequence)localObject1;
        paramInt1 = a.h.e.Y((CharSequence)localObject2);
        a.d.b.g.k(localObject2, "$receiver");
        if ((localObject2 instanceof String)) {
          break label1156;
        }
        localObject3 = new char[1];
        localObject3[0] = 47;
        a.d.b.g.k(localObject2, "$receiver");
        a.d.b.g.k(localObject3, "chars");
        localObject2 = l.a((CharSequence)localObject2, (char[])localObject3, paramInt1, true);
        if (localObject2 == null) {
          break label1151;
        }
        localObject2 = (Integer)((a.g)localObject2).first;
        if (localObject2 == null) {
          break label1151;
        }
        paramInt1 = ((Integer)localObject2).intValue();
        label986:
        localObject2 = ((String)localObject1).substring(paramInt1 + 1);
        a.d.b.g.j(localObject2, "(this as java.lang.String).substring(startIndex)");
        localObject1 = com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class);
        a.d.b.g.j(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)localObject1).getProvider().At((String)localObject2);
        if (localObject1 != null) {
          break label1219;
        }
        if (paramIntent != null) {
          break label1171;
        }
        paramIntent = com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class);
        a.d.b.g.j(paramIntent, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramIntent = ((com.tencent.mm.plugin.emoji.b.d)paramIntent).getProvider().h((String)localObject2, EmojiGroupInfo.uCT, EmojiInfo.uDb, paramInt2);
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class);
        a.d.b.g.j(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)localObject1).getProvider().a((Context)czi(), paramIntent, 1, 1004, false, null, null, null);
        return;
        localObject1 = null;
        break label848;
        label1141:
        paramIntent = null;
        break label864;
        label1146:
        paramInt1 = 0;
        break label891;
        label1149:
        break;
        label1151:
        paramInt1 = -1;
        break label986;
        paramInt1 = ((String)localObject2).lastIndexOf('/', paramInt1);
        break label986;
        if (paramIntent.intValue() != 0) {
          break label1048;
        }
        paramIntent = com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class);
        a.d.b.g.j(paramIntent, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramIntent = ((com.tencent.mm.plugin.emoji.b.d)paramIntent).getProvider().h((String)localObject2, EmojiGroupInfo.uCT, EmojiInfo.uDa, paramInt2);
        continue;
        paramIntent = (Intent)localObject1;
      }
    }
  }
  
  public final void onBackPressed()
  {
    b.a locala = this.jop;
    if (locala == null) {
      a.d.b.g.ahh("editorPresenter");
    }
    if (!locala.rG()) {
      this.joq.exit();
    }
  }
  
  @SuppressLint({"InlinedApi"})
  public final void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(com.tencent.mm.plugin.emojicapture.a.a.anim_emoji_capture_enter, -1);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.emojicapture.model.c.jko;
    com.tencent.mm.plugin.emojicapture.model.a.aJZ();
    SourcePathUtil.loadBgCutSo();
    if (!SourcePathUtil.isLoadBgCutSo())
    {
      paramBundle = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.a.cG(18, 1);
    }
    paramBundle = com.tencent.mm.bw.a.uav;
    if (com.tencent.mm.bw.a.NF()) {
      SourcePathUtil.loadBeautySo();
    }
    label172:
    Object localObject2;
    String str;
    Object localObject1;
    boolean bool;
    if (com.tencent.mm.an.b.NC().NF())
    {
      com.tencent.mm.plugin.report.service.h.nFQ.fy(0L);
      y.i(this.TAG, "PT SO loaded %s, %s", new Object[] { Boolean.valueOf(SourcePathUtil.isLoadBeautySo()), Boolean.valueOf(SourcePathUtil.isLoadBgCutSo()) });
      long l = getIntent().getLongExtra("key_enter_time", 0L);
      paramBundle = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.dv(l);
      paramBundle = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.a.cG(0, 1);
      FS(8);
      getWindow().addFlags(2097280);
      if (!com.tencent.mm.compatible.util.d.gF(19)) {
        break label633;
      }
      getWindow().setFlags(67109888, 67109888);
      j.biT();
      g.b.uv();
      localObject2 = (VideoTransPara)getIntent().getParcelableExtra("key_video_params");
      str = getIntent().getStringExtra("key_video_path");
      localObject1 = getIntent().getStringExtra("key_imitated_md5");
      paramBundle = com.tencent.mm.plugin.emojicapture.model.c.jko;
      bool = com.tencent.mm.plugin.emojicapture.model.c.aKb();
      int i = getIntent().getIntExtra("key_capture_max_duration", 5);
      paramBundle = com.tencent.mm.plugin.emojicapture.model.c.jko;
      com.tencent.mm.plugin.emojicapture.model.c.qh(i);
      paramBundle = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      if (localObject1 != null) {
        break label649;
      }
    }
    label649:
    for (paramBundle = "";; paramBundle = (Bundle)localObject1)
    {
      com.tencent.mm.plugin.emojicapture.f.a.Bk(paramBundle);
      paramBundle = findViewById(a.d.capture_container);
      a.d.b.g.j(paramBundle, "findViewById(R.id.capture_container)");
      this.jom = ((CaptureContainer)paramBundle);
      paramBundle = (Context)this;
      Object localObject3 = this.jom;
      if (localObject3 == null) {
        a.d.b.g.ahh("captureContainer");
      }
      localObject3 = (a.b)localObject3;
      a.d.b.g.j(localObject2, "videoPara");
      a.d.b.g.j(str, "videoFilePath");
      com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class);
      a.d.b.g.j(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
      this.joo = ((com.tencent.mm.plugin.emojicapture.c.a.a)new com.tencent.mm.plugin.emojicapture.e.a(paramBundle, (a.b)localObject3, (VideoTransPara)localObject2, str, ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().At((String)localObject1), (EmojiCaptureUI.b)this.joq));
      paramBundle = this.jom;
      if (paramBundle == null) {
        a.d.b.g.ahh("captureContainer");
      }
      localObject2 = this.joo;
      if (localObject2 == null) {
        a.d.b.g.ahh("capturePresenter");
      }
      paramBundle.setPresenter((com.tencent.mm.plugin.emojicapture.c.a.a)localObject2);
      paramBundle = findViewById(a.d.editor_container);
      a.d.b.g.j(paramBundle, "findViewById(R.id.editor_container)");
      this.jon = ((CaptureEditorContainer)paramBundle);
      paramBundle = (Context)this;
      localObject2 = this.jon;
      if (localObject2 == null) {
        a.d.b.g.ahh("editorContainer");
      }
      this.jop = ((b.a)new com.tencent.mm.plugin.emojicapture.e.c(paramBundle, (b.b)localObject2, bool, (EmojiCaptureUI.b)this.joq, (String)localObject1));
      paramBundle = this.jon;
      if (paramBundle == null) {
        a.d.b.g.ahh("editorContainer");
      }
      localObject1 = this.jop;
      if (localObject1 == null) {
        a.d.b.g.ahh("editorPresenter");
      }
      paramBundle.setPresenter((b.a)localObject1);
      bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)this, "android.permission.CAMERA", 129, "", "");
      paramBundle = this.joo;
      if (paramBundle == null) {
        a.d.b.g.ahh("capturePresenter");
      }
      paramBundle.fp(bool);
      if (bool)
      {
        paramBundle = this.joo;
        if (paramBundle == null) {
          a.d.b.g.ahh("capturePresenter");
        }
        paramBundle.aJN();
        com.tencent.mm.pluginsdk.permission.a.a((Activity)this, "android.permission.RECORD_AUDIO", 130, "", "");
      }
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.fy(1L);
      break;
      label633:
      getWindow().setFlags(1024, 1024);
      break label172;
    }
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.joo;
    if (localObject == null) {
      a.d.b.g.ahh("capturePresenter");
    }
    ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject).destroy();
    localObject = this.jop;
    if (localObject == null) {
      a.d.b.g.ahh("editorPresenter");
    }
    ((b.a)localObject).destroy();
  }
  
  protected final void onPause()
  {
    super.onPause();
    if (this.state == 0)
    {
      localObject = this.joo;
      if (localObject == null) {
        a.d.b.g.ahh("capturePresenter");
      }
      ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject).pause();
      return;
    }
    Object localObject = this.jop;
    if (localObject == null) {
      a.d.b.g.ahh("editorPresenter");
    }
    ((b.a)localObject).pause();
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    a.d.b.g.k(paramArrayOfString, "permissions");
    a.d.b.g.k(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramArrayOfInt.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label121;
      }
    }
    label121:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (paramArrayOfInt[0] != 0)) {
        break label127;
      }
      if (paramInt == 129)
      {
        paramArrayOfString = this.joo;
        if (paramArrayOfString == null) {
          a.d.b.g.ahh("capturePresenter");
        }
        paramArrayOfString.fp(true);
        paramArrayOfString = this.joo;
        if (paramArrayOfString == null) {
          a.d.b.g.ahh("capturePresenter");
        }
        paramArrayOfString.aJN();
        com.tencent.mm.pluginsdk.permission.a.a((Activity)this, "android.permission.RECORD_AUDIO", 130, "", "");
      }
      return;
      i = 0;
      break;
    }
    label127:
    i = a.f.permission_camera_request_again_msg;
    if (paramInt == 130) {
      i = a.f.permission_microphone_request_again_msg;
    }
    com.tencent.mm.ui.base.h.a((Context)this, i, a.f.permission_tips_title, a.f.jump_to_settings, a.f.app_cancel, false, (DialogInterface.OnClickListener)new EmojiCaptureUI.c(this), (DialogInterface.OnClickListener)new EmojiCaptureUI.d(this));
  }
  
  protected final void onResume()
  {
    super.onResume();
    if (this.state == 0)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.a.j((Context)this, "android.permission.CAMERA");
      localObject = this.joo;
      if (localObject == null) {
        a.d.b.g.ahh("capturePresenter");
      }
      ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject).fp(bool);
      localObject = this.joo;
      if (localObject == null) {
        a.d.b.g.ahh("capturePresenter");
      }
      ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject).resume();
      return;
    }
    Object localObject = this.jop;
    if (localObject == null) {
      a.d.b.g.ahh("editorPresenter");
    }
    ((b.a)localObject).resume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI
 * JD-Core Version:    0.7.0.1
 */