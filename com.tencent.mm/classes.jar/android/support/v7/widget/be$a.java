package android.support.v7.widget;

import android.support.v4.f.k.a;
import android.support.v4.f.k.b;

final class be$a
{
  static k.a<a> anw = new k.b(20);
  RecyclerView.f.c anu;
  RecyclerView.f.c anv;
  int flags;
  
  static void a(a parama)
  {
    parama.flags = 0;
    parama.anu = null;
    parama.anv = null;
    anw.D(parama);
  }
  
  static a jg()
  {
    a locala2 = (a)anw.de();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    return locala1;
  }
  
  static void jh()
  {
    while (anw.de() != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.be.a
 * JD-Core Version:    0.7.0.1
 */