package com.tencent.mm.app;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d.a;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.Map;

final class WorkerProfile$32
  implements d.a
{
  final Map<String, Integer> hkc;
  final Map<String, Integer> map;
  
  WorkerProfile$32(Context paramContext)
  {
    AppMethodBeat.i(239047);
    this.map = new HashMap();
    this.hkc = new HashMap();
    AppMethodBeat.o(239047);
  }
  
  public final String iF(String paramString)
  {
    AppMethodBeat.i(239051);
    if (this.map.containsKey(paramString))
    {
      String str2 = this.val$context.getString(((Integer)this.map.get(paramString)).intValue());
      String str1 = str2;
      if (au.bwJ(paramString)) {
        str1 = c.a(this.val$context, "weixin", new SpannableString(str2)).toString();
      }
      AppMethodBeat.o(239051);
      return str1;
    }
    AppMethodBeat.o(239051);
    return null;
  }
  
  public final String iG(String paramString)
  {
    AppMethodBeat.i(239058);
    if (this.hkc.containsKey(paramString))
    {
      paramString = this.val$context.getString(((Integer)this.hkc.get(paramString)).intValue());
      AppMethodBeat.o(239058);
      return paramString;
    }
    AppMethodBeat.o(239058);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.32
 * JD-Core Version:    0.7.0.1
 */