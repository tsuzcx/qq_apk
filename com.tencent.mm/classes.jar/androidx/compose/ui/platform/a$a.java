package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "()V", "segment", "", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getRange", "start", "", "end", "initialize", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a$a
  implements a.f
{
  public static final int Ue = 8;
  private final int[] aQz = new int[2];
  protected String text;
  
  protected final int[] af(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 == paramInt2)) {
      return null;
    }
    this.aQz[0] = paramInt1;
    this.aQz[1] = paramInt2;
    return this.aQz;
  }
  
  public void al(String paramString)
  {
    s.u(paramString, "text");
    setText(paramString);
  }
  
  protected final String getText()
  {
    String str = this.text;
    if (str != null) {
      return str;
    }
    s.bIx("text");
    return null;
  }
  
  protected final void setText(String paramString)
  {
    s.u(paramString, "<set-?>");
    this.text = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.a.a
 * JD-Core Version:    0.7.0.1
 */