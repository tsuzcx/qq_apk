package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.q;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static d ovq;
  public boolean ovr;
  private Pattern ovs;
  
  public d()
  {
    AppMethodBeat.i(108423);
    this.ovr = false;
    this.ovs = Pattern.compile("_\\d");
    AppMethodBeat.o(108423);
  }
  
  public static d bUB()
  {
    AppMethodBeat.i(108424);
    if (ovq == null) {}
    try
    {
      ovq = new d();
      d locald = ovq;
      AppMethodBeat.o(108424);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(108424);
    }
  }
  
  public final void Tx(String paramString)
  {
    AppMethodBeat.i(108425);
    paramString = new com.tencent.mm.vfs.e(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.fhW();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (this.ovr)
          {
            if (localObject.isDirectory()) {
              Tx(q.B(localObject.mUri));
            }
            for (;;)
            {
              i += 1;
              break;
              String str = localObject.getName();
              if ((this.ovs.matcher(str).find()) || (str.startsWith("temp"))) {
                localObject.delete();
              }
            }
          }
          ad.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
          AppMethodBeat.o(108425);
          return;
        }
      }
    }
    AppMethodBeat.o(108425);
  }
  
  public final void Ty(String paramString)
  {
    AppMethodBeat.i(108426);
    paramString = new com.tencent.mm.vfs.e(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.fhW();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (localObject.isDirectory()) {
            Ty(q.B(localObject.mUri));
          }
          for (;;)
          {
            i += 1;
            break;
            localObject.getName();
            localObject.delete();
          }
        }
      }
    }
    AppMethodBeat.o(108426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.d
 * JD-Core Version:    0.7.0.1
 */