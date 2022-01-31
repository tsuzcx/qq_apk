package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.FileSystemManager.a;
import com.tencent.mm.vfs.MigrationFileSystem;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mm.vfs.RawFileSystem;
import com.tencent.mm.vfs.a;
import java.util.Map;

public class PluginAvatar
  extends f
  implements b
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(79058);
    if (paramg.SD())
    {
      paramg = new a((byte)0);
      Object localObject = new MigrationFileSystem(new RawFileSystem("${data}/MicroMsg/${account}/avatar", (byte)0), new FileSystem[] { new RawFileSystem("${storage}/tencent/MicroMsg/${account}/avatar") });
      ((MigrationFileSystem)localObject).a("avatarMigration", paramg);
      localObject = new QuotaFileSystem((FileSystem)localObject);
      ((QuotaFileSystem)localObject).a("avatarQuota", paramg);
      FileSystemManager.dQE().erS().a("avatar", (FileSystem)localObject).iD("${data}/MicroMsg/${account}/avatar", "avatar").rM(false);
    }
    AppMethodBeat.o(79058);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(79059);
    if (paramg.SD()) {
      pin(c.aSD());
    }
    AppMethodBeat.o(79059);
  }
  
  static final class a
    implements a
  {
    private static void dD(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(79056);
      e.qrI.idkeyStat(857L, paramInt1, paramInt2, false);
      AppMethodBeat.o(79056);
    }
    
    public final void b(String paramString, int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(79057);
      if (paramInt == 4)
      {
        dD(1, 1);
        AppMethodBeat.o(79057);
        return;
      }
      if (paramInt == 5)
      {
        dD(2, 1);
        AppMethodBeat.o(79057);
        return;
      }
      Integer localInteger;
      if (paramInt == 1)
      {
        if (paramString.equals("avatarQuota"))
        {
          dD(0, 1);
          AppMethodBeat.o(79057);
        }
      }
      else if (paramInt == 3)
      {
        if (paramString.equals("avatarQuota"))
        {
          dD(6, 1);
          AppMethodBeat.o(79057);
          return;
        }
        if (!paramString.equals("avatarMigration")) {
          break label276;
        }
        dD(3, 1);
        paramString = (Integer)paramMap.get("filesCopied");
        localInteger = (Integer)paramMap.get("filesFailed");
        paramMap = (Long)paramMap.get("sizeCopied");
        if (paramString == null) {
          break label282;
        }
      }
      label276:
      label282:
      for (paramInt = paramString.intValue() + 0;; paramInt = 0)
      {
        int i = paramInt;
        if (localInteger != null) {
          i = paramInt + localInteger.intValue();
        }
        if (i > 0)
        {
          dD(7, 1);
          dD(13, i);
        }
        if (paramMap != null) {
          dD(15, (int)paramMap.longValue());
        }
        AppMethodBeat.o(79057);
        return;
        if (((paramInt == 2) || (paramInt == 6)) && (paramString.equals("avatarQuota")))
        {
          paramString = (Integer)paramMap.get("fileCount");
          paramMap = (Long)paramMap.get("totalSize");
          if (paramString != null) {
            dD(9, paramString.intValue());
          }
          if (paramMap != null) {
            dD(11, (int)paramMap.longValue());
          }
        }
        AppMethodBeat.o(79057);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.PluginAvatar
 * JD-Core Version:    0.7.0.1
 */