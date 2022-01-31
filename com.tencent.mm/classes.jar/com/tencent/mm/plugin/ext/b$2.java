package com.tencent.mm.plugin.ext;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Build.VERSION;
import com.qq.wx.voice.embed.recognizer.Grammar;
import com.qq.wx.voice.embed.recognizer.b.a;
import com.qq.wx.voice.embed.recognizer.d;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
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
    Object localObject2;
    Object localObject4;
    int i;
    int j;
    for (;;)
    {
      Object localObject5;
      try
      {
        localObject2 = g.AA().getValue("VoiceRecognizeSprSoMD5");
        localObject3 = g.AA().getValue("VoiceRecognizeSprDataMD5");
        if ((localObject2 == null) || (localObject3 == null))
        {
          y.i("MicroMsg.SubCoreExt", "error mMd5So:%s,  mMd5Data:%s", new Object[] { localObject2, localObject3 });
          b.e(this.jJF);
          return;
        }
        Object localObject1 = "/system/lib/";
        if (Build.VERSION.SDK_INT >= 24) {
          localObject1 = "/vendor/lib/";
        }
        y.i("MicroMsg.SubCoreExt", "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s", new Object[] { localObject2, localObject3, localObject1 });
        l = System.currentTimeMillis();
        localObject5 = b.a.aVq;
        localObject4 = ae.getContext();
        localObject5 = ((com.qq.wx.voice.embed.recognizer.b)localObject5).aVp;
        if (((com.qq.wx.voice.embed.recognizer.e)localObject5).d)
        {
          i = 0;
          localObject1 = ae.cqS();
          y.i("MicroMsg.SubCoreExt", "checkFiles ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
          if (i != 0) {
            break label663;
          }
          l = System.currentTimeMillis();
          localObject3 = new LinkedList();
          ((List)localObject3).add("tmessage");
          ((List)localObject3).add("officialaccounts");
          ((List)localObject3).add("helper_entry");
          au.Hx();
          localObject2 = c.FE().Ic("@t.qq.com");
          if (localObject2 != null) {
            ((List)localObject3).add(((bq)localObject2).name);
          }
          localObject2 = new ArrayList();
          au.Hx();
          localObject3 = c.Fw().a("@all.contact.android", null, (List)localObject3, null, true, true);
          if (localObject3 != null) {
            break;
          }
          y.w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
          b.e(this.jJF);
          return;
        }
      }
      catch (Exception localException)
      {
        y.i("MicroMsg.SubCoreExt", "initLocalVoiceControl Exception:%s", new Object[] { localException.getMessage() });
        return;
      }
      j = ((com.qq.wx.voice.embed.recognizer.e)localObject5).aVw.checkFiles((Context)localObject4, localException, (String)localObject2, (String)localObject3);
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
        ((f)localObject4).d((Cursor)localObject3);
        ((ArrayList)localObject2).add(new d(((f)localObject4).field_username, ((f)localObject4).field_nickname, ((f)localObject4).field_conRemark));
        ((Cursor)localObject3).moveToNext();
      }
    }
    ((Cursor)localObject3).close();
    y.i("MicroMsg.SubCoreExt", "init cusor,count:%s,use time:%s", new Object[] { Integer.valueOf(((Cursor)localObject3).getCount()), Long.valueOf(System.currentTimeMillis() - l) });
    long l = System.currentTimeMillis();
    Object localObject3 = b.a.aVq.aVp;
    if (!((com.qq.wx.voice.embed.recognizer.e)localObject3).d) {
      i = -304;
    }
    for (;;)
    {
      if (i == 0)
      {
        localException.edit().putBoolean("hasInitVoiceControlData", true).putBoolean("hasTryToInitVoiceControlData", true).commit();
        b.f(this.jJF);
        label538:
        y.i("MicroMsg.SubCoreExt", "init ret:%s,use time:%s", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
        b.e(this.jJF);
      }
      for (;;)
      {
        b.e(this.jJF);
        return;
        if (((com.qq.wx.voice.embed.recognizer.e)localObject3).e)
        {
          j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).aVw.update((ArrayList)localObject2);
          i = j;
          if (j < 0) {
            break;
          }
          break label703;
        }
        j = ((com.qq.wx.voice.embed.recognizer.e)localObject3).aVw.init((ArrayList)localObject2);
        i = j;
        if (j < 0) {
          break;
        }
        ((com.qq.wx.voice.embed.recognizer.e)localObject3).e = true;
        break label703;
        localException.edit().putBoolean("hasInitVoiceControlData", false).commit();
        break label538;
        label663:
        localException.edit().putBoolean("hasInitVoiceControlData", false).putBoolean("hasTryToInitVoiceControlData", true).commit();
        b.f(this.jJF);
      }
      label703:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.2
 * JD-Core Version:    0.7.0.1
 */