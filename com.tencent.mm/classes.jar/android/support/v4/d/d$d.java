package android.support.v4.d;

abstract class d$d
  implements c
{
  private final d.c EC;
  
  d$d(d.c paramc)
  {
    this.EC = paramc;
  }
  
  public final boolean a(CharSequence paramCharSequence, int paramInt)
  {
    if ((paramCharSequence == null) || (paramInt < 0) || (paramCharSequence.length() - paramInt < 0)) {
      throw new IllegalArgumentException();
    }
    if (this.EC == null) {
      return du();
    }
    switch (this.EC.b(paramCharSequence, paramInt))
    {
    default: 
      return du();
    case 0: 
      return true;
    }
    return false;
  }
  
  protected abstract boolean du();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.d.d.d
 * JD-Core Version:    0.7.0.1
 */