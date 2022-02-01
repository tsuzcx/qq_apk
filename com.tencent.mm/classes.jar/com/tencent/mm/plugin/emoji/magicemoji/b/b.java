package com.tencent.mm.plugin.emoji.magicemoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appstorage.ah;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.emoji.magicemoji.bean.WxaPkgRecordForME;
import com.tencent.mm.plugin.emoji.magicemoji.core.MagicEmojiServiceContextBase;
import kotlin.g.b.s;

public final class b
  extends a
{
  public b(MagicEmojiServiceContextBase paramMagicEmojiServiceContextBase)
  {
    super(paramMagicEmojiServiceContextBase);
  }
  
  protected final w dyU()
  {
    AppMethodBeat.i(269941);
    dyT();
    Object localObject = dyT().xIi;
    s.checkNotNull(localObject);
    localObject = new WxaPkg(((WxaPkgRecordForME)localObject).pkgPath);
    ((WxaPkg)localObject).cfK();
    localObject = new ah((WxaPkg)localObject);
    AppMethodBeat.o(269941);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.b.b
 * JD-Core Version:    0.7.0.1
 */