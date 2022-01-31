package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.h.c.r;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

public final class l
{
  public d kOM;
  public boolean kON = false;
  public int mode = 1;
  public int progress = 0;
  public int status = 0;
  
  public l(d paramd)
  {
    this.kOM = paramd;
  }
  
  public final void aGu()
  {
    if (this.kOM == null) {
      return;
    }
    switch (this.mode)
    {
    default: 
      this.status = 0;
    }
    for (;;)
    {
      label37:
      y.i("MicroMsg.GameDownloadInfo", "Updating Download Status, AppId: %s, downloadMode: %d, downloadStatus: %d", new Object[] { this.kOM.field_appId, Integer.valueOf(this.mode), Integer.valueOf(this.status) });
      return;
      FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.d.aFP().zL(this.kOM.field_appId);
      if (localFileDownloadTaskInfo.hFz != 0L) {}
      for (this.progress = ((int)(localFileDownloadTaskInfo.iPM / localFileDownloadTaskInfo.hFz * 100.0D));; this.progress = 0)
      {
        y.d("MicroMsg.GameDownloadInfo", "status = " + localFileDownloadTaskInfo.status);
        switch (localFileDownloadTaskInfo.status)
        {
        default: 
          this.status = 0;
          break label37;
        }
      }
      this.status = 1;
      continue;
      this.status = 2;
      continue;
      this.status = 0;
      continue;
      if (e.bK(localFileDownloadTaskInfo.path))
      {
        this.status = 3;
      }
      else
      {
        this.status = 0;
        continue;
        if ((this.progress != 0) && (!aq.isConnected(ae.getContext()))) {
          this.status = 2;
        } else {
          this.status = 0;
        }
      }
    }
  }
  
  public final void aZk()
  {
    this.mode = 1;
    this.kON = true;
  }
  
  public final void dz(Context paramContext)
  {
    if (this.kOM == null) {
      return;
    }
    int j = this.kOM.cvH;
    int i = this.kOM.cvH;
    y.i("MicroMsg.GameDownloadInfo", "AppId: %s, Initial downloadMode: %d", new Object[] { this.kOM.field_appId, Integer.valueOf(j) });
    if (j == 2) {
      i = 3;
    }
    j = i;
    if (i == 3)
    {
      j = i;
      if (!g.o(paramContext, "wx3909f6add1206543")) {
        j = 1;
      }
    }
    i = j;
    if (j != 1)
    {
      paramContext = com.tencent.mm.plugin.downloader.model.d.aFP().zL(this.kOM.field_appId);
      if ((paramContext.status != 1) && (paramContext.status != 2))
      {
        i = j;
        if (paramContext.status != 3) {}
      }
      else
      {
        i = 1;
      }
    }
    this.mode = i;
    y.i("MicroMsg.GameDownloadInfo", "AppId: %s, Final downloadMode: %d", new Object[] { this.kOM.field_appId, Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.l
 * JD-Core Version:    0.7.0.1
 */