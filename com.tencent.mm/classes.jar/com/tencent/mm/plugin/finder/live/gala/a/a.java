package com.tencent.mm.plugin.finder.live.gala.a;

import android.view.View;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/data/ViewPagerItemSelect;", "Lcom/tencent/mm/plugin/finder/live/gala/viewpager/ICommentViewSelect;", "groupId", "", "groupName", "lastEnterTimeStamp", "", "commentView", "(Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mm/plugin/finder/live/gala/viewpager/ICommentViewSelect;)V", "getCommentView", "()Lcom/tencent/mm/plugin/finder/live/gala/viewpager/ICommentViewSelect;", "getGroupId", "()Ljava/lang/String;", "getGroupName", "getLastEnterTimeStamp", "()J", "attachBoxId", "", "boxId", "param", "Landroid/os/Bundle;", "changeMaxSize", "maxHeight", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getCommentRootView", "Landroid/view/View;", "hashCode", "onSelected", "isSelected", "toString", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.finder.live.gala.viewpager.a
{
  public static final a adlB;
  public final String abwL;
  private final long adlC;
  private final com.tencent.mm.plugin.finder.live.gala.viewpager.a adlD;
  public final String groupId;
  
  static
  {
    AppMethodBeat.i(371140);
    adlB = new a((byte)0);
    AppMethodBeat.o(371140);
  }
  
  public a(String paramString1, String paramString2, long paramLong, com.tencent.mm.plugin.finder.live.gala.viewpager.a parama)
  {
    AppMethodBeat.i(371136);
    this.groupId = paramString1;
    this.abwL = paramString2;
    this.adlC = paramLong;
    this.adlD = parama;
    AppMethodBeat.o(371136);
  }
  
  public final void aql(int paramInt)
  {
    AppMethodBeat.i(371151);
    this.adlD.aql(paramInt);
    AppMethodBeat.o(371151);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(371175);
    if (this == paramObject)
    {
      AppMethodBeat.o(371175);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(371175);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.groupId, paramObject.groupId))
    {
      AppMethodBeat.o(371175);
      return false;
    }
    if (!s.p(this.abwL, paramObject.abwL))
    {
      AppMethodBeat.o(371175);
      return false;
    }
    if (this.adlC != paramObject.adlC)
    {
      AppMethodBeat.o(371175);
      return false;
    }
    if (!s.p(this.adlD, paramObject.adlD))
    {
      AppMethodBeat.o(371175);
      return false;
    }
    AppMethodBeat.o(371175);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(371168);
    int i = this.groupId.hashCode();
    int j = this.abwL.hashCode();
    int k = q.a..ExternalSyntheticBackport0.m(this.adlC);
    int m = this.adlD.hashCode();
    AppMethodBeat.o(371168);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final View ivt()
  {
    AppMethodBeat.i(371146);
    View localView = this.adlD.ivt();
    AppMethodBeat.o(371146);
    return localView;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(371161);
    String str = "ViewPagerItemSelect(groupId=" + this.groupId + ", groupName=" + this.abwL + ", lastEnterTimeStamp=" + this.adlC + ", commentView=" + this.adlD + ')';
    AppMethodBeat.o(371161);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/data/ViewPagerItemSelect$Companion;", "", "()V", "MAX_LENGTH", "", "TAG", "", "convertToGroupItemData", "Lcom/tencent/mm/plugin/finder/live/gala/data/ViewPagerItemSelect;", "context", "Landroid/content/Context;", "msgInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxMsgInfo;", "commentView", "Lcom/tencent/mm/plugin/finder/live/gala/viewpager/ICommentViewSelect;", "getValidGroupName", "text", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String aza(String paramString)
    {
      AppMethodBeat.i(371141);
      Object localObject1 = Charset.forName("GBK");
      s.s(localObject1, "Charset.forName(charsetName)");
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(371141);
        throw paramString;
      }
      localObject1 = paramString.getBytes((Charset)localObject1);
      s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
      Log.i("ViewPagerItemSelect", s.X("getValidGroupName: ", Integer.valueOf(localObject1.length)));
      localObject1 = new StringBuilder();
      int m = paramString.length() - 1;
      int i;
      int j;
      if (m >= 0)
      {
        i = 0;
        j = 0;
      }
      for (;;)
      {
        int k = i + 1;
        Object localObject2 = new StringBuilder("index: ").append(i).append(" , currentSize: ").append(j).append(" byte: ");
        Object localObject3 = String.valueOf(paramString.charAt(i));
        Charset localCharset = Charset.forName("GBK");
        s.s(localCharset, "Charset.forName(charsetName)");
        if (localObject3 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(371141);
          throw paramString;
        }
        localObject3 = ((String)localObject3).getBytes(localCharset);
        s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
        Log.i("ViewPagerItemSelect", localObject3.length + " c: " + paramString.charAt(i));
        localObject2 = String.valueOf(paramString.charAt(i));
        localObject3 = Charset.forName("GBK");
        s.s(localObject3, "Charset.forName(charsetName)");
        if (localObject2 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(371141);
          throw paramString;
        }
        localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
        s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
        j += localObject2.length;
        if (j <= 12)
        {
          ((StringBuilder)localObject1).append(paramString.charAt(i));
          if (k > m)
          {
            paramString = ((StringBuilder)localObject1).toString();
            s.s(paramString, "stringBuilder.toString()");
            AppMethodBeat.o(371141);
            return paramString;
          }
        }
        else
        {
          ((StringBuilder)localObject1).append("...");
          paramString = ((StringBuilder)localObject1).toString();
          s.s(paramString, "stringBuilder.toString()");
          AppMethodBeat.o(371141);
          return paramString;
        }
        i = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.gala.a.a
 * JD-Core Version:    0.7.0.1
 */