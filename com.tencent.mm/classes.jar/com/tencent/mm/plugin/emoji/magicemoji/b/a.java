package com.tencent.mm.plugin.emoji.magicemoji.b;

import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.appbrand.appstorage.ac;
import com.tencent.mm.plugin.appbrand.appstorage.af;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.emoji.magicemoji.core.MagicEmojiServiceContextBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import java.util.LinkedList;

public abstract class a
  extends ac
{
  private final MagicEmojiServiceContextBase xIC;
  
  public a(MagicEmojiServiceContextBase paramMagicEmojiServiceContextBase)
  {
    super(new LinkedList());
    this.xIC = paramMagicEmojiServiceContextBase;
    Object localObject = new com.tencent.mm.vfs.u(b.bmz(), "luggage/" + paramMagicEmojiServiceContextBase.appId);
    paramMagicEmojiServiceContextBase = this.qNv;
    localObject = ah.v(((com.tencent.mm.vfs.u)localObject).jKT());
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new af(ah.v(new com.tencent.mm.vfs.u((String)localObject, "files/").jKT()), "wxfile://"));
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appstorage.u(ah.v(new com.tencent.mm.vfs.u((String)localObject, "objects/").jKT()), "default_obfuscation_key", "wxfile://"));
    paramMagicEmojiServiceContextBase.addAll(localLinkedList);
    this.qNv.add(dyU());
    Log.i("MicroMsg.MagicEmojiFileSystem", "hy: file system established");
  }
  
  protected final MagicEmojiServiceContextBase dyT()
  {
    return this.xIC;
  }
  
  protected abstract w dyU();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.b.a
 * JD-Core Version:    0.7.0.1
 */