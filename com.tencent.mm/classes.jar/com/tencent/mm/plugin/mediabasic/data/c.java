package com.tencent.mm.plugin.mediabasic.data;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mediabasic/data/MediaOutputInfo;", "", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "outputs", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mediabasic/data/MediaSingleInfo;", "Lkotlin/collections/ArrayList;", "extra", "Landroid/os/Bundle;", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;Ljava/util/ArrayList;Landroid/os/Bundle;)V", "getExtra", "()Landroid/os/Bundle;", "setExtra", "(Landroid/os/Bundle;)V", "getOutputs", "()Ljava/util/ArrayList;", "setOutputs", "(Ljava/util/ArrayList;)V", "getVideoParams", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setVideoParams", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "getDuration", "", "getImagePath", "", "getThumbPath", "getVideoPath", "hashCode", "", "toString", "Companion", "plugin-basic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a KOJ;
  private ArrayList<MediaSingleInfo> KOK;
  public VideoTransPara nLH;
  private Bundle oSS;
  
  static
  {
    AppMethodBeat.i(269632);
    KOJ = new c.a((byte)0);
    AppMethodBeat.o(269632);
  }
  
  private c(VideoTransPara paramVideoTransPara, ArrayList<MediaSingleInfo> paramArrayList)
  {
    AppMethodBeat.i(269624);
    this.nLH = paramVideoTransPara;
    this.KOK = paramArrayList;
    this.oSS = null;
    AppMethodBeat.o(269624);
  }
  
  public final String bud()
  {
    AppMethodBeat.i(269649);
    Iterator localIterator = ((Iterable)this.KOK).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((MediaSingleInfo)localObject).KON == a.KOC)
      {
        i = 1;
        label49:
        if (i == 0) {
          break label72;
        }
      }
    }
    for (;;)
    {
      localObject = (MediaSingleInfo)localObject;
      if (localObject != null) {
        break label79;
      }
      AppMethodBeat.o(269649);
      return null;
      i = 0;
      break label49;
      label72:
      break;
      localObject = null;
    }
    label79:
    Object localObject = ((MediaSingleInfo)localObject).path;
    AppMethodBeat.o(269649);
    return localObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(269663);
    if (this == paramObject)
    {
      AppMethodBeat.o(269663);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(269663);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.nLH, paramObject.nLH))
    {
      AppMethodBeat.o(269663);
      return false;
    }
    if (!s.p(this.KOK, paramObject.KOK))
    {
      AppMethodBeat.o(269663);
      return false;
    }
    if (!s.p(this.oSS, paramObject.oSS))
    {
      AppMethodBeat.o(269663);
      return false;
    }
    AppMethodBeat.o(269663);
    return true;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(269653);
    Iterator localIterator = ((Iterable)this.KOK).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((MediaSingleInfo)localObject).KON == a.KOz)
      {
        i = 1;
        label54:
        if (i == 0) {
          break label80;
        }
      }
    }
    for (;;)
    {
      localObject = (MediaSingleInfo)localObject;
      if (localObject != null) {
        break label88;
      }
      AppMethodBeat.o(269653);
      return 0L;
      i = 0;
      break label54;
      label80:
      break;
      localObject = null;
    }
    label88:
    Object localObject = ((MediaSingleInfo)localObject).KOO;
    long l1 = ((MediaDurationInfo)localObject).endMs;
    long l2 = ((MediaDurationInfo)localObject).startMs;
    AppMethodBeat.o(269653);
    return l1 - l2;
  }
  
  public final String getVideoPath()
  {
    AppMethodBeat.i(269642);
    Iterator localIterator = ((Iterable)this.KOK).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((MediaSingleInfo)localObject).KON == a.KOz)
      {
        i = 1;
        label49:
        if (i == 0) {
          break label72;
        }
      }
    }
    for (;;)
    {
      localObject = (MediaSingleInfo)localObject;
      if (localObject != null) {
        break label79;
      }
      AppMethodBeat.o(269642);
      return null;
      i = 0;
      break label49;
      label72:
      break;
      localObject = null;
    }
    label79:
    Object localObject = ((MediaSingleInfo)localObject).path;
    AppMethodBeat.o(269642);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(269658);
    int j = this.nLH.hashCode();
    int k = this.KOK.hashCode();
    if (this.oSS == null) {}
    for (int i = 0;; i = this.oSS.hashCode())
    {
      AppMethodBeat.o(269658);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269656);
    String str = "MediaOutputInfo(videoParams=" + this.nLH + ", outputs=" + this.KOK + ", extra=" + this.oSS + ')';
    AppMethodBeat.o(269656);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mediabasic.data.c
 * JD-Core Version:    0.7.0.1
 */