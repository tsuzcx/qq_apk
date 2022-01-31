package com.d.a.a;

import java.lang.ref.WeakReference;

final class t$a
  implements m
{
  public final void a(p paramp)
  {
    switch (paramp.what)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                  } while (t.pw() == null);
                  localObject = (t.b)t.pw().get();
                } while (localObject == null);
                paramp = (n.a)paramp;
                ((t.b)localObject).onLocationUpdate(paramp.lat, paramp.lng, paramp.aYk, paramp.aYl, paramp.aYm);
                return;
              } while (t.px() == null);
              localObject = (t.d)t.px().get();
            } while (localObject == null);
            paramp = (n.b)paramp;
            ((t.d)localObject).onMessage(paramp.code, paramp.message);
            return;
          } while (t.py() == null);
          localObject = (t.c)t.py().get();
        } while (localObject == null);
        ((t.c)localObject).onRefAdded(((s.e)paramp).aZs);
        return;
      } while (t.py() == null);
      localObject = (t.c)t.py().get();
    } while (localObject == null);
    ((t.c)localObject).onTrackProcessed(((s.g)paramp).aZt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.a.t.a
 * JD-Core Version:    0.7.0.1
 */