package com.tencent.mm.plugin.flash.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;

public final class d
  implements a
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2, h paramh)
  {
    AppMethodBeat.i(264642);
    paramString3 = new Bundle();
    paramString3.putString("err_msg", "ok");
    paramString3.putString("key_pic_cdn_id", paramString1);
    paramString3.putString("key_cdn_aes_key", paramString2);
    paramString3.putString("k_bio_id", String.valueOf(paramLong));
    paramString3.putInt("check_alive_type", paramInt1);
    paramString3.putBoolean("selfHandle", true);
    paramString1 = new a();
    paramString1.result = paramString3;
    paramh.onSceneEnd(0, 0, "ok", paramString1);
    AppMethodBeat.o(264642);
  }
  
  public final String fuT()
  {
    return "faceverify_ticket";
  }
  
  public final int getType()
  {
    return 0;
  }
  
  public static final class a
    extends p
  {
    public Bundle result;
    
    public final int doScene(g paramg, h paramh)
    {
      return 0;
    }
    
    public final int getType()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.e.d
 * JD-Core Version:    0.7.0.1
 */