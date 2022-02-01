package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Parcelable;
import android.support.v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public class IconCompatParcelizer
{
  public static IconCompat read(a parama)
  {
    AppMethodBeat.i(62496);
    IconCompat localIconCompat = new IconCompat();
    localIconCompat.mType = parama.aS(localIconCompat.mType, 1);
    localIconCompat.mData = parama.j(localIconCompat.mData);
    localIconCompat.Im = parama.a(localIconCompat.Im, 3);
    localIconCompat.In = parama.aS(localIconCompat.In, 4);
    localIconCompat.Io = parama.aS(localIconCompat.Io, 5);
    localIconCompat.Ip = ((ColorStateList)parama.a(localIconCompat.Ip, 6));
    localIconCompat.Iq = parama.N(localIconCompat.Iq);
    localIconCompat.wn = PorterDuff.Mode.valueOf(localIconCompat.Iq);
    switch (localIconCompat.mType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62496);
      return localIconCompat;
      if (localIconCompat.Im != null)
      {
        localIconCompat.Il = localIconCompat.Im;
      }
      else
      {
        parama = new IllegalArgumentException("Invalid icon");
        AppMethodBeat.o(62496);
        throw parama;
        if (localIconCompat.Im != null)
        {
          localIconCompat.Il = localIconCompat.Im;
        }
        else
        {
          localIconCompat.Il = localIconCompat.mData;
          localIconCompat.mType = 3;
          localIconCompat.In = 0;
          localIconCompat.Io = localIconCompat.mData.length;
          continue;
          localIconCompat.Il = new String(localIconCompat.mData, Charset.forName("UTF-16"));
          continue;
          localIconCompat.Il = localIconCompat.mData;
        }
      }
    }
  }
  
  public static void write(IconCompat paramIconCompat, a parama)
  {
    AppMethodBeat.i(62497);
    paramIconCompat.Iq = paramIconCompat.wn.name();
    switch (paramIconCompat.mType)
    {
    }
    for (;;)
    {
      parama.aR(paramIconCompat.mType, 1);
      parama.i(paramIconCompat.mData);
      parama.writeParcelable(paramIconCompat.Im, 3);
      parama.aR(paramIconCompat.In, 4);
      parama.aR(paramIconCompat.Io, 5);
      parama.writeParcelable(paramIconCompat.Ip, 6);
      parama.M(paramIconCompat.Iq);
      AppMethodBeat.o(62497);
      return;
      paramIconCompat.Im = ((Parcelable)paramIconCompat.Il);
      continue;
      paramIconCompat.Im = ((Parcelable)paramIconCompat.Il);
      continue;
      paramIconCompat.mData = paramIconCompat.Il.toString().getBytes(Charset.forName("UTF-16"));
      continue;
      paramIconCompat.mData = ((String)paramIconCompat.Il).getBytes(Charset.forName("UTF-16"));
      continue;
      paramIconCompat.mData = ((byte[])paramIconCompat.Il);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.core.graphics.drawable.IconCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */