package com.tencent.mm.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.NoRomSpaceDexUI;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StartBlocker
{
  private static final List<a> sBlockers;
  
  static
  {
    AppMethodBeat.i(239074);
    ArrayList localArrayList = new ArrayList();
    sBlockers = localArrayList;
    localArrayList.add(new a()
    {
      public final PendingIntent shouldBlock(Context paramAnonymousContext)
      {
        AppMethodBeat.i(239068);
        if ((BuildInfo.IS_ARM64) && (!Build.CPU_ABI.equals("arm64-v8a")))
        {
          paramAnonymousContext = PendingIntent.getActivity(paramAnonymousContext, 0, new Intent(paramAnonymousContext, NoRomSpaceDexUI.class).addFlags(268435456).putExtra("titleRes", 2131756385).putExtra("messageRes", 2131756384).putExtra("buttonRes", 2131756383).putExtra("action", PendingIntent.getActivity(paramAnonymousContext, 0, new Intent("android.intent.action.VIEW", Uri.parse("http://" + WeChatHosts.domainString(2131763776) + "/")).addFlags(268435456), 0)), 0);
          AppMethodBeat.o(239068);
          return paramAnonymousContext;
        }
        AppMethodBeat.o(239068);
        return null;
      }
    });
    sBlockers.add(new a()
    {
      public final PendingIntent shouldBlock(Context paramAnonymousContext)
      {
        AppMethodBeat.i(239071);
        StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
        long l = localStatFs.getAvailableBlocks();
        if (localStatFs.getBlockSize() * l < 52428800L)
        {
          paramAnonymousContext = PendingIntent.getActivity(paramAnonymousContext, 0, new Intent(paramAnonymousContext, NoRomSpaceDexUI.class).setFlags(268435456), 0);
          AppMethodBeat.o(239071);
          return paramAnonymousContext;
        }
        AppMethodBeat.o(239071);
        return null;
      }
    });
    AppMethodBeat.o(239074);
  }
  
  public static PendingIntent shouldBlock(Context paramContext)
  {
    AppMethodBeat.i(239072);
    Iterator localIterator = sBlockers.iterator();
    for (;;)
    {
      Object localObject;
      if (localIterator.hasNext()) {
        localObject = (a)localIterator.next();
      }
      try
      {
        localObject = ((a)localObject).shouldBlock(paramContext);
        if (localObject == null) {
          continue;
        }
        AppMethodBeat.o(239072);
        return localObject;
      }
      catch (Exception localException) {}
      AppMethodBeat.o(239072);
      return null;
    }
  }
  
  static abstract interface a
  {
    public abstract PendingIntent shouldBlock(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.StartBlocker
 * JD-Core Version:    0.7.0.1
 */