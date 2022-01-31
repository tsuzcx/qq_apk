package com.tencent.mm.plugin.expt.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class b
{
  private static String TAG = "MicroMsg.ExptManager";
  private static b mdb;
  private f<Integer, a> mbS;
  private String name;
  
  protected b()
  {
    AppMethodBeat.i(93275);
    this.mbS = new com.tencent.mm.a.h(50);
    this.name = null;
    AppMethodBeat.o(93275);
  }
  
  private int MZ(String paramString)
  {
    AppMethodBeat.i(138273);
    as localas = btk();
    if (localas == null)
    {
      AppMethodBeat.o(138273);
      return -1;
    }
    int i = localas.getInt(paramString, -1);
    AppMethodBeat.o(138273);
    return i;
  }
  
  private static void a(a parama, String paramString1, String paramString2)
  {
    AppMethodBeat.i(138275);
    e.qrI.e(15452, new Object[] { Integer.valueOf(parama.field_exptId), Integer.valueOf(parama.field_groupId), Integer.valueOf(parama.field_exptSeq), Long.valueOf(parama.field_startTime), Long.valueOf(parama.field_endTime), paramString1, paramString2 });
    AppMethodBeat.o(138275);
  }
  
  private String bau()
  {
    AppMethodBeat.i(93278);
    String str = hashCode();
    AppMethodBeat.o(93278);
    return str;
  }
  
  public static b btj()
  {
    AppMethodBeat.i(93274);
    if (mdb == null) {
      mdb = new b();
    }
    b localb = mdb;
    AppMethodBeat.o(93274);
    return localb;
  }
  
  private a vx(int paramInt)
  {
    AppMethodBeat.i(138274);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(138274);
      return null;
    }
    Object localObject = btk();
    if (localObject == null)
    {
      AppMethodBeat.o(138274);
      return null;
    }
    String str = ((as)localObject).getString(String.valueOf(paramInt), "");
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(138274);
      return null;
    }
    localObject = (a)this.mbS.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      if (bo.isEqual(str, ((a)localObject).field_exptContent))
      {
        AppMethodBeat.o(138274);
        return localObject;
      }
      this.mbS.remove(Integer.valueOf(paramInt));
    }
    localObject = new a();
    if (((a)localObject).MX(str)) {
      this.mbS.put(Integer.valueOf(paramInt), localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(138274);
      return localObject;
      localObject = null;
    }
  }
  
  public final String b(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(93277);
    int i = MZ(paramString1);
    String str;
    if (i > 0)
    {
      a locala = vx(i);
      if ((locala != null) && (locala.isReady()))
      {
        localObject = locala.bti();
        if ((localObject != null) && (!((HashMap)localObject).isEmpty()))
        {
          str = (String)((HashMap)localObject).get(paramString1);
          localObject = str;
          if (paramBoolean1) {
            a(locala, paramString1, str);
          }
        }
      }
    }
    for (Object localObject = str;; localObject = paramString2)
    {
      if (paramBoolean2) {
        ab.i(TAG, "%s get mulit expt result[%s] key[%s] def[%s]", new Object[] { bau(), localObject, paramString1, paramString2 });
      }
      AppMethodBeat.o(93277);
      return localObject;
    }
  }
  
  public final as btk()
  {
    AppMethodBeat.i(93276);
    int i = ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp()).getInt("default_uin", 0);
    if (i == 0)
    {
      AppMethodBeat.o(93276);
      return null;
    }
    Object localObject = i + "_WxExptmmkv";
    if (!bo.isEqual(this.name, (String)localObject))
    {
      ab.i(TAG, "%s get mmkv change uin old[%s] new[%s]", new Object[] { bau(), this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = as.apq(this.name);
    AppMethodBeat.o(93276);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b
 * JD-Core Version:    0.7.0.1
 */