package androidx.compose.ui.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.CharacterIterator;

public final class b
  implements CharacterIterator
{
  private final int baK;
  private final int baL;
  private final CharSequence baM;
  private int mIndex;
  
  public b(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(205164);
    this.baM = paramCharSequence;
    this.mIndex = 0;
    this.baK = 0;
    this.baL = paramInt;
    AppMethodBeat.o(205164);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(205201);
    try
    {
      Object localObject = super.clone();
      AppMethodBeat.o(205201);
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      InternalError localInternalError = new InternalError();
      AppMethodBeat.o(205201);
      throw localInternalError;
    }
  }
  
  public final char current()
  {
    AppMethodBeat.i(205174);
    if (this.mIndex == this.baL)
    {
      AppMethodBeat.o(205174);
      return 65535;
    }
    char c = this.baM.charAt(this.mIndex);
    AppMethodBeat.o(205174);
    return c;
  }
  
  public final char first()
  {
    AppMethodBeat.i(205169);
    this.mIndex = this.baK;
    char c = current();
    AppMethodBeat.o(205169);
    return c;
  }
  
  public final int getBeginIndex()
  {
    return this.baK;
  }
  
  public final int getEndIndex()
  {
    return this.baL;
  }
  
  public final int getIndex()
  {
    return this.mIndex;
  }
  
  public final char last()
  {
    AppMethodBeat.i(205172);
    if (this.baK == this.baL)
    {
      this.mIndex = this.baL;
      AppMethodBeat.o(205172);
      return 65535;
    }
    this.mIndex = (this.baL - 1);
    char c = this.baM.charAt(this.mIndex);
    AppMethodBeat.o(205172);
    return c;
  }
  
  public final char next()
  {
    AppMethodBeat.i(205180);
    this.mIndex += 1;
    if (this.mIndex >= this.baL)
    {
      this.mIndex = this.baL;
      AppMethodBeat.o(205180);
      return 65535;
    }
    char c = this.baM.charAt(this.mIndex);
    AppMethodBeat.o(205180);
    return c;
  }
  
  public final char previous()
  {
    AppMethodBeat.i(205186);
    if (this.mIndex <= this.baK)
    {
      AppMethodBeat.o(205186);
      return 65535;
    }
    this.mIndex -= 1;
    char c = this.baM.charAt(this.mIndex);
    AppMethodBeat.o(205186);
    return c;
  }
  
  public final char setIndex(int paramInt)
  {
    AppMethodBeat.i(205189);
    if ((this.baK <= paramInt) && (paramInt <= this.baL))
    {
      this.mIndex = paramInt;
      char c = current();
      AppMethodBeat.o(205189);
      return c;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid position");
    AppMethodBeat.o(205189);
    throw localIllegalArgumentException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.b
 * JD-Core Version:    0.7.0.1
 */