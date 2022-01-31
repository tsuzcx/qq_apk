package android.support.v4.e;

abstract class c$d
  implements b
{
  private final c.c DN;
  
  c$d(c.c paramc)
  {
    this.DN = paramc;
  }
  
  public final boolean a(CharSequence paramCharSequence, int paramInt)
  {
    if ((paramCharSequence == null) || (paramInt < 0) || (paramCharSequence.length() - paramInt < 0)) {
      throw new IllegalArgumentException();
    }
    if (this.DN == null) {
      return cV();
    }
    switch (this.DN.b(paramCharSequence, paramInt))
    {
    default: 
      return cV();
    case 0: 
      return true;
    }
    return false;
  }
  
  protected abstract boolean cV();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.e.c.d
 * JD-Core Version:    0.7.0.1
 */