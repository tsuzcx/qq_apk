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
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(20261);
    Object localObject2;
    int i;
    int j;
    try
    {
      localObject2 = g.Nq().getValue("VoiceRecognizeSprSoMD5");
      localObject3 = g.Nq().getValue("VoiceRecognizeSprDataMD5");
      if ((localObject2 == null) || (localObject3 == null))
      {
        ab.i("MicroMsg.SubCoreExt", "error mMd5So:%s,  mMd5Data:%s", new Object[] { localObject2, localObject3 });
        b.e(this.mdJ);
        AppMethodBeat.o(20261);
        return;
      }
      Object localObject1 = "/system/lib/";
      if (Build.VERSION.SDK_INT >= 24) {
        localObject1 = "/vendor/lib/";
      }
      ab.i("MicroMsg.SubCoreExt", "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s", new Object[] { localObject2, localObject3, localObject1 });
      l = System.currentTimeMillis();
      Object localObject5 = b.a.blY;
      Object localObject4 = ah.getContext();
      localObject5 = ((com.qq.wx.voice.embed.recognizer.b)localObject5).blX;
      if (((com.qq.wx.voice.embed.recognizer.e)localObject5).d) {
        i = 0;
      }
      for (;;)
      {
        localObject1 = ah.dsQ();
        ab.i("MicroMsg.SubCoreExt", "checkFiles ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
        if (i != 0) {
          break label694;
        }
        l = System.currentTimeMillis();
        localObject3 = new LinkedList();
        ((List)localObject3).add("tmessage");
        ((List)localObject3).add("officialaccounts");
        ((List)localObject3).add("helper_entry");
        aw.aaz();
        localObject2 = c.YI().TL("@t.qq.com");
        if (localObject2 != null) {
          ((List)localObject3).add(((bq)localObject2).name);
        }
        localObject2 = new ArrayList();
        aw.aaz();
        localObject3 = c.YA().a("@all.contact.android", null, (List)localObject3, null, true, true);
        if (localObject3 != null) {
          break;
        }
        ab.w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
        b.e(this.mdJ);
        AppMethodBeat.o(20261);
        return;
        j = ((com.qq.wx.voice.embed.recognizer.e)localObject5).bme.checkFiles((Context)localObject4, (String)localObject1, (String)localObject2, (String)localObject3);
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
      ab.i("MicroMsg.SubCoreExt", "initLocalVoiceControl Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(20261);
      return;
    }
    ab.i("MicroMsg.SubCoreExt", "init cusor,count:%s,use time:%s", new Object[] { Integer.valueOf(((Cursor)localObject3).getCount()), Long.valueOf(System.currentTimeMillis() - l) });
    long l = System.currentTimeMillis();
    Object localObject3 = b.a.blY.blX;
    if (!((com.qq.wx.voice.embed.recognizer.e)localObject3).d) {
      i = -304;
    }
    for (;;)
    {
      if (i == 0)
      {
        localException.edit().putBoolean("hasInitVoiceControlData", true).putBoolean("hasTryToInitVoiceControlData", true).commit();
        b.f(this.mdJ);
        label563:
        ab.i("MicroMsg.SubCoreExt", "init ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
        b.e(this.mdJ);
      }
      for (;;)
      {
        b.e(this.mdJ);
        AppMethodBeat.o(20261);
        return;
        if (((com.qq.wx.voice.embed.recognizer.e)localObject3).e)
        {
          j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).bme.update((ArrayList)localObject2);
          i = j;
          if (j < 0) {
            break;
          }
          break label735;
        }
        j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).bme.init((ArrayList)localObject2);
        i = j;
        if (j < 0) {
          break;
        }
        ((com.qq.wx.voice.embed.recognizer.e)localObject3).e = true;
        break label735;
        localException.edit().putBoolean("hasInitVoiceControlData", false).commit();
        break label563;
        label694:
        localException.edit().putBoolean("hasInitVoiceControlData", false).putBoolean("hasTryToInitVoiceControlData", true).commit();
        b.f(this.mdJ);
      }
      label735:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.2
 * JD-Core Version:    0.7.0.1
 */