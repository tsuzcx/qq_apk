package android.support.v7.widget;

import android.support.v4.e.k.a;
import android.support.v4.e.k.b;

final class bg$a
{
  static k.a<a> apN = new k.b(20);
  RecyclerView.f.c apL;
  RecyclerView.f.c apM;
  int flags;
  
  static void a(a parama)
  {
    parama.flags = 0;
    parama.apL = null;
    parama.apM = null;
    apN.release(parama);
  }
  
  static a lb()
  {
    a locala2 = (a)apN.acquire();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    return locala1;
  }
  
  static void lc()
  {
    while (apN.acquire() != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.bg.a
 * JD-Core Version:    0.7.0.1
 */