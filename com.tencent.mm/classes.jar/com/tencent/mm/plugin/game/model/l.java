package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.i;

public final class l
{
  public int mode = 1;
  public int progress = 0;
  public int status = 0;
  public c tdF;
  public boolean tdG = false;
  
  public l(c paramc)
  {
    this.tdF = paramc;
  }
  
  public final void bYH()
  {
    AppMethodBeat.i(41434);
    if (this.tdF == null)
    {
      AppMethodBeat.o(41434);
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
      ac.i("MicroMsg.GameDownloadInfo", "Updating Download Status, AppId: %s, downloadMode: %d, downloadStatus: %d", new Object[] { this.tdF.field_appId, Integer.valueOf(this.mode), Integer.valueOf(this.status) });
      AppMethodBeat.o(41434);
      return;
      FileDownloadTaskInfo localFileDownloadTaskInfo = f.bXJ().WB(this.tdF.field_appId);
      if (localFileDownloadTaskInfo.mSs != 0L)
      {
        this.progress = ((int)(localFileDownloadTaskInfo.oJm / localFileDownloadTaskInfo.mSs * 100.0D));
        label135:
        if (this.progress != 0) {
          break label228;
        }
      }
      label228:
      for (int i = 1;; i = this.progress)
      {
        this.progress = i;
        ac.d("MicroMsg.GameDownloadInfo", "status = " + localFileDownloadTaskInfo.status);
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
      if (i.eA(localFileDownloadTaskInfo.path))
      {
        this.status = 3;
      }
      else
      {
        this.status = 0;
        continue;
        if ((this.progress != 0) && (!ax.isConnected(ai.getContext()))) {
          this.status = 2;
        } else {
          this.status = 0;
        }
      }
    }
  }
  
  public final void cQn()
  {
    this.mode = 1;
    this.tdG = true;
  }
  
  public final void fu(Context paramContext)
  {
    AppMethodBeat.i(41433);
    if (this.tdF == null)
    {
      AppMethodBeat.o(41433);
      return;
    }
    int j = this.tdF.eqt;
    int i = this.tdF.eqt;
    ac.i("MicroMsg.GameDownloadInfo", "AppId: %s, Initial downloadMode: %d", new Object[] { this.tdF.field_appId, Integer.valueOf(j) });
    if (j == 2) {
      i = 3;
    }
    j = i;
    if (i == 3)
    {
      j = i;
      if (!h.t(paramContext, "wx3909f6add1206543")) {
        j = 1;
      }
    }
    i = j;
    if (j != 1)
    {
      paramContext = f.bXJ().WB(this.tdF.field_appId);
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
    ac.i("MicroMsg.GameDownloadInfo", "AppId: %s, Final downloadMode: %d", new Object[] { this.tdF.field_appId, Integer.valueOf(i) });
    AppMethodBeat.o(41433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.l
 * JD-Core Version:    0.7.0.1
 */