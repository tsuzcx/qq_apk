package androidx.compose.ui.m.a;

import android.text.Layout.Alignment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/TextAlignmentAdapter;", "", "()V", "ALIGN_LEFT_FRAMEWORK", "Landroid/text/Layout$Alignment;", "ALIGN_RIGHT_FRAMEWORK", "get", "value", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m bbp;
  private static final Layout.Alignment bbq;
  private static final Layout.Alignment bbr;
  
  static
  {
    AppMethodBeat.i(205191);
    bbp = new m();
    Layout.Alignment[] arrayOfAlignment = Layout.Alignment.values();
    Object localObject1 = Layout.Alignment.ALIGN_NORMAL;
    Object localObject2 = Layout.Alignment.ALIGN_NORMAL;
    int i = 0;
    int k = arrayOfAlignment.length;
    while (i < k)
    {
      Layout.Alignment localAlignment = arrayOfAlignment[i];
      int j = i + 1;
      if (s.p(localAlignment.name(), "ALIGN_LEFT"))
      {
        localObject1 = localAlignment;
        i = j;
      }
      else
      {
        i = j;
        if (s.p(localAlignment.name(), "ALIGN_RIGHT"))
        {
          localObject2 = localAlignment;
          i = j;
        }
      }
    }
    bbq = (Layout.Alignment)localObject1;
    bbr = (Layout.Alignment)localObject2;
    AppMethodBeat.o(205191);
  }
  
  public static Layout.Alignment dq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Layout.Alignment.ALIGN_NORMAL;
    case 3: 
      return bbq;
    case 4: 
      return bbr;
    case 2: 
      return Layout.Alignment.ALIGN_CENTER;
    case 1: 
      return Layout.Alignment.ALIGN_OPPOSITE;
    }
    return Layout.Alignment.ALIGN_NORMAL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.m
 * JD-Core Version:    0.7.0.1
 */