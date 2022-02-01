package androidx.compose.ui.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/AnnotatedString;", "", "text", "", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "annotations", "", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAnnotations$ui_text_release", "()Ljava/util/List;", "length", "", "getLength", "()I", "getParagraphStyles", "getSpanStyles", "getText", "()Ljava/lang/String;", "equals", "", "other", "get", "", "index", "getStringAnnotations", "start", "end", "tag", "getTtsAnnotations", "Landroidx/compose/ui/text/TtsAnnotation;", "hashCode", "plus", "subSequence", "range", "Landroidx/compose/ui/text/TextRange;", "subSequence-5zc-tL8", "(J)Landroidx/compose/ui/text/AnnotatedString;", "startIndex", "endIndex", "toString", "Builder", "Range", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements CharSequence
{
  public final List<a<n>> aYD;
  final List<a<l>> aYE;
  public final List<a<? extends Object>> aYF;
  public final String text;
  
  private a(String paramString, List<a<n>> paramList, List<a<l>> paramList1)
  {
    this(paramString, paramList, paramList1, (List)ab.aivy);
    AppMethodBeat.i(204934);
    AppMethodBeat.o(204934);
  }
  
  public a(String paramString, List<a<n>> paramList, List<a<l>> paramList1, List<? extends a<? extends Object>> paramList2)
  {
    AppMethodBeat.i(204931);
    this.text = paramString;
    this.aYD = paramList;
    this.aYE = paramList1;
    this.aYF = paramList2;
    paramString = this.aYE;
    int m = paramString.size() - 1;
    int i;
    int j;
    if (m >= 0)
    {
      i = 0;
      j = -1;
    }
    for (;;)
    {
      int k = i + 1;
      paramList = (a)paramString.get(i);
      if (paramList.start >= j) {}
      for (i = 1; i == 0; i = 0)
      {
        paramString = (Throwable)new IllegalArgumentException("ParagraphStyle should not overlap".toString());
        AppMethodBeat.o(204931);
        throw paramString;
      }
      if (paramList.end <= this.text.length()) {}
      for (i = 1; i == 0; i = 0)
      {
        paramString = (Throwable)new IllegalArgumentException(("ParagraphStyle range [" + paramList.start + ", " + paramList.end + ") is out of boundary").toString());
        AppMethodBeat.o(204931);
        throw paramString;
      }
      j = paramList.end;
      if (k > m)
      {
        AppMethodBeat.o(204931);
        return;
      }
      i = k;
    }
  }
  
  public final a ah(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204943);
    if (paramInt1 <= paramInt2) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException(("start (" + paramInt1 + ") should be less or equal to end (" + paramInt2 + ')').toString());
      AppMethodBeat.o(204943);
      throw ((Throwable)localObject);
    }
    if ((paramInt1 == 0) && (paramInt2 == this.text.length()))
    {
      AppMethodBeat.o(204943);
      return this;
    }
    Object localObject = this.text;
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(204943);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).substring(paramInt1, paramInt2);
    s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localObject = new a((String)localObject, b.e(this.aYD, paramInt1, paramInt2), b.e(this.aYE, paramInt1, paramInt2), b.e(this.aYF, paramInt1, paramInt2));
    AppMethodBeat.o(204943);
    return localObject;
  }
  
  public final List<a<w>> dg(int paramInt)
  {
    AppMethodBeat.i(204947);
    List localList = this.aYF;
    ArrayList localArrayList = new ArrayList(localList.size());
    int k = localList.size() - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject = localList.get(i);
      a locala = (a)localObject;
      if (((locala.aYG instanceof w)) && (b.i(0, paramInt, locala.start, locala.end))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          ((Collection)localArrayList).add(localObject);
        }
        if (j <= k) {
          break;
        }
        localList = (List)localArrayList;
        AppMethodBeat.o(204947);
        return localList;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204949);
    if (this == paramObject)
    {
      AppMethodBeat.o(204949);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(204949);
      return false;
    }
    if (!s.p(this.text, ((a)paramObject).text))
    {
      AppMethodBeat.o(204949);
      return false;
    }
    if (!s.p(this.aYD, ((a)paramObject).aYD))
    {
      AppMethodBeat.o(204949);
      return false;
    }
    if (!s.p(this.aYE, ((a)paramObject).aYE))
    {
      AppMethodBeat.o(204949);
      return false;
    }
    if (!s.p(this.aYF, ((a)paramObject).aYF))
    {
      AppMethodBeat.o(204949);
      return false;
    }
    AppMethodBeat.o(204949);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204954);
    int i = this.text.hashCode();
    int j = this.aYD.hashCode();
    int k = this.aYE.hashCode();
    int m = this.aYF.hashCode();
    AppMethodBeat.o(204954);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    return this.text;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/text/AnnotatedString$Range;", "T", "", "item", "start", "", "end", "(Ljava/lang/Object;II)V", "tag", "", "(Ljava/lang/Object;IILjava/lang/String;)V", "getEnd", "()I", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Range;", "equals", "", "other", "hashCode", "toString", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a<T>
  {
    public final T aYG;
    public final int end;
    public final int start;
    public final String tag;
    
    public a(T paramT, int paramInt1, int paramInt2)
    {
      this(paramT, paramInt1, paramInt2, "");
    }
    
    public a(T paramT, int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(205132);
      this.aYG = paramT;
      this.start = paramInt1;
      this.end = paramInt2;
      this.tag = paramString;
      if (this.start <= this.end) {}
      for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
      {
        paramT = (Throwable)new IllegalArgumentException("Reversed range is not supported".toString());
        AppMethodBeat.o(205132);
        throw paramT;
      }
      AppMethodBeat.o(205132);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(205156);
      if (this == paramObject)
      {
        AppMethodBeat.o(205156);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(205156);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.aYG, paramObject.aYG))
      {
        AppMethodBeat.o(205156);
        return false;
      }
      if (this.start != paramObject.start)
      {
        AppMethodBeat.o(205156);
        return false;
      }
      if (this.end != paramObject.end)
      {
        AppMethodBeat.o(205156);
        return false;
      }
      if (!s.p(this.tag, paramObject.tag))
      {
        AppMethodBeat.o(205156);
        return false;
      }
      AppMethodBeat.o(205156);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(205149);
      if (this.aYG == null) {}
      for (int i = 0;; i = this.aYG.hashCode())
      {
        int j = this.start;
        int k = this.end;
        int m = this.tag.hashCode();
        AppMethodBeat.o(205149);
        return ((i * 31 + j) * 31 + k) * 31 + m;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205141);
      String str = "Range(item=" + this.aYG + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
      AppMethodBeat.o(205141);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a
 * JD-Core Version:    0.7.0.1
 */