package com.tencent.mm.plugin.avatar;

import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.FileSystemManager.a;
import com.tencent.mm.vfs.MigrationFileSystem;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mm.vfs.RawFileSystem;
import java.util.Map;

public class PluginAvatar
  extends com.tencent.mm.kernel.b.f
  implements a
{
  public void configure(g paramg)
  {
    if (paramg.Ex())
    {
      paramg = new a((byte)0);
      Object localObject = new MigrationFileSystem(new RawFileSystem("${data}/MicroMsg/${account}/avatar", (byte)0), new FileSystem[] { new RawFileSystem("${storage}/tencent/MicroMsg/${account}/avatar") });
      ((MigrationFileSystem)localObject).a("avatarMigration", paramg);
      localObject = new QuotaFileSystem((FileSystem)localObject);
      ((QuotaFileSystem)localObject).a("avatarQuota", paramg);
      FileSystemManager.cVw().cVy().a("avatar", (FileSystem)localObject).gA("${data}/MicroMsg/${account}/avatar", "avatar").oc(false);
    }
  }
  
  public void execute(g paramg)
  {
    if (paramg.Ex()) {
      pin(b.atf());
    }
  }
  
  private static final class a
    implements com.tencent.mm.vfs.a
  {
    private static void co(int paramInt1, int paramInt2)
    {
      com.tencent.mm.plugin.report.f.nEG.a(857L, paramInt1, paramInt2, false);
    }
    
    public final void b(String paramString, int paramInt, Map<String, Object> paramMap)
    {
      if (paramInt == 4) {
        co(1, 1);
      }
      do
      {
        do
        {
          return;
          if (paramInt == 5)
          {
            co(2, 1);
            return;
          }
          if (paramInt != 1) {
            break;
          }
        } while (!paramString.equals("avatarQuota"));
        co(0, 1);
        return;
        if (paramInt != 3) {
          break;
        }
        if (paramString.equals("avatarQuota"))
        {
          co(6, 1);
          return;
        }
      } while (!paramString.equals("avatarMigration"));
      co(3, 1);
      paramString = (Integer)paramMap.get("filesCopied");
      Integer localInteger = (Integer)paramMap.get("filesFailed");
      paramMap = (Long)paramMap.get("sizeCopied");
      if (paramString != null) {}
      for (paramInt = paramString.intValue() + 0;; paramInt = 0)
      {
        int i = paramInt;
        if (localInteger != null) {
          i = paramInt + localInteger.intValue();
        }
        if (i > 0)
        {
          co(7, 1);
          co(13, i);
        }
        if (paramMap == null) {
          break;
        }
        co(15, (int)paramMap.longValue());
        return;
        if (((paramInt != 2) && (paramInt != 6)) || (!paramString.equals("avatarQuota"))) {
          break;
        }
        paramString = (Integer)paramMap.get("fileCount");
        paramMap = (Long)paramMap.get("totalSize");
        if (paramString != null) {
          co(9, paramString.intValue());
        }
        if (paramMap == null) {
          break;
        }
        co(11, (int)paramMap.longValue());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.PluginAvatar
 * JD-Core Version:    0.7.0.1
 */