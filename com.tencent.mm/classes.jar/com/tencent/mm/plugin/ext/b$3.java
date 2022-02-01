package com.tencent.mm.plugin.ext;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Build.VERSION;
import com.qq.wx.voice.embed.recognizer.Grammar;
import com.qq.wx.voice.embed.recognizer.b.a;
import com.qq.wx.voice.embed.recognizer.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(24336);
    Object localObject2;
    int i;
    int j;
    try
    {
      localObject2 = g.acA().getValue("VoiceRecognizeSprSoMD5");
      localObject3 = g.acA().getValue("VoiceRecognizeSprDataMD5");
      if ((localObject2 == null) || (localObject3 == null) || (q.is64BitRuntime()))
      {
        ad.i("MicroMsg.SubCoreExt", "error mMd5So:%s,  mMd5Data:%s", new Object[] { localObject2, localObject3 });
        b.e(this.rcH);
        AppMethodBeat.o(24336);
        return;
      }
      Object localObject1 = "/system/lib/";
      if (Build.VERSION.SDK_INT >= 24) {
        localObject1 = "/vendor/lib/";
      }
      ad.i("MicroMsg.SubCoreExt", "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s", new Object[] { localObject2, localObject3, localObject1 });
      l = System.currentTimeMillis();
      Object localObject5 = b.a.bVE;
      Object localObject4 = aj.getContext();
      localObject5 = ((com.qq.wx.voice.embed.recognizer.b)localObject5).bVD;
      if (((com.qq.wx.voice.embed.recognizer.e)localObject5).d) {
        i = 0;
      }
      for (;;)
      {
        localObject1 = aj.fkD();
        ad.i("MicroMsg.SubCoreExt", "checkFiles ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
        if (i != 0) {
          break label700;
        }
        l = System.currentTimeMillis();
        localObject3 = new LinkedList();
        ((List)localObject3).add("tmessage");
        ((List)localObject3).add("officialaccounts");
        ((List)localObject3).add("helper_entry");
        ba.aBQ();
        localObject2 = c.azy().aqy("@t.qq.com");
        if (localObject2 != null) {
          ((List)localObject3).add(((ca)localObject2).name);
        }
        localObject2 = new ArrayList();
        ba.aBQ();
        localObject3 = c.azp().a("@all.contact.android", null, (List)localObject3, null, true, true);
        if (localObject3 != null) {
          break;
        }
        ad.w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
        b.e(this.rcH);
        AppMethodBeat.o(24336);
        return;
        j = ((com.qq.wx.voice.embed.recognizer.e)localObject5).bVK.checkFiles((Context)localObject4, (String)localObject1, (String)localObject2, (String)localObject3);
        i = j;
        if (j >= 0)
        {
          ((com.qq.wx.voice.embed.recognizer.e)localObject5).d = true;
          i = 0;
        }
      }
      if (((Cursor)localObject3).moveToFirst()) {
        while (!((Cursor)localObject3).isAfterLast())
        {
          localObject4 = new f();
          ((f)localObject4).convertFrom((Cursor)localObject3);
          ((ArrayList)localObject2).add(new d(((f)localObject4).field_username, ((f)localObject4).field_nickname, ((f)localObject4).field_conRemark));
          ((Cursor)localObject3).moveToNext();
        }
      }
      ((Cursor)localObject3).close();
    }
    catch (Exception localException)
    {
      ad.i("MicroMsg.SubCoreExt", "initLocalVoiceControl Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(24336);
      return;
    }
    ad.i("MicroMsg.SubCoreExt", "init cusor,count:%s,use time:%s", new Object[] { Integer.valueOf(((Cursor)localObject3).getCount()), Long.valueOf(System.currentTimeMillis() - l) });
    long l = System.currentTimeMillis();
    Object localObject3 = b.a.bVE.bVD;
    if (!((com.qq.wx.voice.embed.recognizer.e)localObject3).d) {
      i = -304;
    }
    for (;;)
    {
      if (i == 0)
      {
        localException.edit().putBoolean("hasInitVoiceControlData", true).putBoolean("hasTryToInitVoiceControlData", true).commit();
        b.f(this.rcH);
        label569:
        ad.i("MicroMsg.SubCoreExt", "init ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
        b.e(this.rcH);
      }
      for (;;)
      {
        b.e(this.rcH);
        AppMethodBeat.o(24336);
        return;
        if (((com.qq.wx.voice.embed.recognizer.e)localObject3).e)
        {
          j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).bVK.update((ArrayList)localObject2);
          i = j;
          if (j < 0) {
            break;
          }
          break label741;
        }
        j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).bVK.init((ArrayList)localObject2);
        i = j;
        if (j < 0) {
          break;
        }
        ((com.qq.wx.voice.embed.recognizer.e)localObject3).e = true;
        break label741;
        localException.edit().putBoolean("hasInitVoiceControlData", false).commit();
        break label569;
        label700:
        localException.edit().putBoolean("hasInitVoiceControlData", false).putBoolean("hasTryToInitVoiceControlData", true).commit();
        b.f(this.rcH);
      }
      label741:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.3
 * JD-Core Version:    0.7.0.1
 */