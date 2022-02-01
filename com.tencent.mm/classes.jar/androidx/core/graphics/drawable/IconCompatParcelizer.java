package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PorterDuff.Mode;
import android.os.Parcelable;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

public class IconCompatParcelizer
{
  public static IconCompat read(a parama)
  {
    AppMethodBeat.i(196191);
    IconCompat localIconCompat = new IconCompat();
    localIconCompat.mType = parama.bT(localIconCompat.mType, 1);
    localIconCompat.mData = parama.q(localIconCompat.mData);
    localIconCompat.bqV = parama.b(localIconCompat.bqV, 3);
    localIconCompat.bqW = parama.bT(localIconCompat.bqW, 4);
    localIconCompat.bqX = parama.bT(localIconCompat.bqX, 5);
    localIconCompat.kz = ((ColorStateList)parama.b(localIconCompat.kz, 6));
    localIconCompat.bqZ = parama.m(localIconCompat.bqZ, 7);
    localIconCompat.bra = parama.m(localIconCompat.bra, 8);
    localIconCompat.kA = PorterDuff.Mode.valueOf(localIconCompat.bqZ);
    switch (localIconCompat.mType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196191);
      return localIconCompat;
      if (localIconCompat.bqV != null)
      {
        localIconCompat.bqU = localIconCompat.bqV;
      }
      else
      {
        parama = new IllegalArgumentException("Invalid icon");
        AppMethodBeat.o(196191);
        throw parama;
        if (localIconCompat.bqV != null)
        {
          localIconCompat.bqU = localIconCompat.bqV;
        }
        else
        {
          localIconCompat.bqU = localIconCompat.mData;
          localIconCompat.mType = 3;
          localIconCompat.bqW = 0;
          localIconCompat.bqX = localIconCompat.mData.length;
          continue;
          localIconCompat.bqU = new String(localIconCompat.mData, Charset.forName("UTF-16"));
          if ((localIconCompat.mType == 2) && (localIconCompat.bra == null))
          {
            localIconCompat.bra = ((String)localIconCompat.bqU).split(":", -1)[0];
            continue;
            localIconCompat.bqU = localIconCompat.mData;
          }
        }
      }
    }
  }
  
  public static void write(IconCompat paramIconCompat, a parama)
  {
    AppMethodBeat.i(196205);
    boolean bool = a.Mi();
    paramIconCompat.bqZ = paramIconCompat.kA.name();
    switch (paramIconCompat.mType)
    {
    }
    for (;;)
    {
      if (-1 != paramIconCompat.mType) {
        parama.bS(paramIconCompat.mType, 1);
      }
      if (paramIconCompat.mData != null) {
        parama.p(paramIconCompat.mData);
      }
      if (paramIconCompat.bqV != null) {
        parama.a(paramIconCompat.bqV, 3);
      }
      if (paramIconCompat.bqW != 0) {
        parama.bS(paramIconCompat.bqW, 4);
      }
      if (paramIconCompat.bqX != 0) {
        parama.bS(paramIconCompat.bqX, 5);
      }
      if (paramIconCompat.kz != null) {
        parama.a(paramIconCompat.kz, 6);
      }
      if (paramIconCompat.bqZ != null) {
        parama.l(paramIconCompat.bqZ, 7);
      }
      if (paramIconCompat.bra != null) {
        parama.l(paramIconCompat.bra, 8);
      }
      AppMethodBeat.o(196205);
      return;
      if (bool)
      {
        paramIconCompat = new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        AppMethodBeat.o(196205);
        throw paramIconCompat;
      }
      paramIconCompat.bqV = ((Parcelable)paramIconCompat.bqU);
      continue;
      if (bool)
      {
        Bitmap localBitmap = (Bitmap)paramIconCompat.bqU;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.PNG, 90, localByteArrayOutputStream);
        paramIconCompat.mData = localByteArrayOutputStream.toByteArray();
      }
      else
      {
        paramIconCompat.bqV = ((Parcelable)paramIconCompat.bqU);
        continue;
        paramIconCompat.mData = paramIconCompat.bqU.toString().getBytes(Charset.forName("UTF-16"));
        continue;
        paramIconCompat.mData = ((String)paramIconCompat.bqU).getBytes(Charset.forName("UTF-16"));
        continue;
        paramIconCompat.mData = ((byte[])paramIconCompat.bqU);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.graphics.drawable.IconCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */