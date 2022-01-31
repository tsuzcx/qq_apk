package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.t;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.vfs.e;

public final class k
{
  public int mode = 1;
  public c nmJ;
  public boolean nmK = false;
  public int progress = 0;
  public int status = 0;
  
  public k(c paramc)
  {
    this.nmJ = paramc;
  }
  
  public final void bGk()
  {
    this.mode = 1;
    this.nmK = true;
  }
  
  public final void bjZ()
  {
    AppMethodBeat.i(111272);
    if (this.nmJ == null)
    {
      AppMethodBeat.o(111272);
      return;
    }
    switch (this.mode)
    {
    default: 
      this.status = 0;
    }
    for (;;)
    {
      label45:
      ab.i("MicroMsg.GameDownloadInfo", "Updating Download Status, AppId: %s, downloadMode: %d, downloadStatus: %d", new Object[] { this.nmJ.field_appId, Integer.valueOf(this.mode), Integer.valueOf(this.status) });
      AppMethodBeat.o(111272);
      return;
      FileDownloadTaskInfo localFileDownloadTaskInfo = f.bjl().JH(this.nmJ.field_appId);
      if (localFileDownloadTaskInfo.jyU != 0L)
      {
        this.progress = ((int)(localFileDownloadTaskInfo.kYX / localFileDownloadTaskInfo.jyU * 100.0D));
        label135:
        if (this.progress != 0) {
          break label228;
        }
      }
      label228:
      for (int i = 1;; i = this.progress)
      {
        this.progress = i;
        ab.d("MicroMsg.GameDownloadInfo", "status = " + localFileDownloadTaskInfo.status);
        switch (localFileDownloadTaskInfo.status)
        {
        default: 
          this.status = 0;
          break label45;
          this.progress = 0;
          break label135;
        }
      }
      this.status = 1;
      continue;
      this.status = 2;
      continue;
      this.status = 0;
      continue;
      if (e.cN(localFileDownloadTaskInfo.path))
      {
        this.status = 3;
      }
      else
      {
        this.status = 0;
        continue;
        if ((this.progress != 0) && (!at.isConnected(ah.getContext()))) {
          this.status = 2;
        } else {
          this.status = 0;
        }
      }
    }
  }
  
  public final void em(Context paramContext)
  {
    AppMethodBeat.i(111271);
    if (this.nmJ == null)
    {
      AppMethodBeat.o(111271);
      return;
    }
    int j = this.nmJ.djS;
    int i = this.nmJ.djS;
    ab.i("MicroMsg.GameDownloadInfo", "AppId: %s, Initial downloadMode: %d", new Object[] { this.nmJ.field_appId, Integer.valueOf(j) });
    if (j == 2) {
      i = 3;
    }
    j = i;
    if (i == 3)
    {
      j = i;
      if (!g.u(paramContext, "wx3909f6add1206543")) {
        j = 1;
      }
    }
    i = j;
    if (j != 1)
    {
      paramContext = f.bjl().JH(this.nmJ.field_appId);
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
    ab.i("MicroMsg.GameDownloadInfo", "AppId: %s, Final downloadMode: %d", new Object[] { this.nmJ.field_appId, Integer.valueOf(i) });
    AppMethodBeat.o(111271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.k
 * JD-Core Version:    0.7.0.1
 */