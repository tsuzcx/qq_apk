package com.tencent.mm.plugin.car_license_plate.ui;

import android.text.SpannableStringBuilder;
import android.text.style.WrapTogetherSpan;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/TimestampSpan;", "Landroid/text/style/WrapTogetherSpan;", "timestamp", "", "(J)V", "getTimestamp", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements WrapTogetherSpan
{
  public static final a wdw;
  final long timestamp;
  
  static
  {
    AppMethodBeat.i(277687);
    wdw = new a((byte)0);
    AppMethodBeat.o(277687);
  }
  
  public e(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof e)) {
        return false;
      }
      paramObject = (e)paramObject;
    } while (this.timestamp == paramObject.timestamp);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(277700);
    int i = q.a..ExternalSyntheticBackport0.m(this.timestamp);
    AppMethodBeat.o(277700);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277694);
    String str = "TimestampSpan(timestamp=" + this.timestamp + ')';
    AppMethodBeat.o(277694);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/TimestampSpan$Companion;", "", "()V", "findLargestTimestamp", "", "source", "", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static long Z(CharSequence paramCharSequence)
    {
      int j = 1;
      AppMethodBeat.i(277733);
      s.u(paramCharSequence, "source");
      if ((paramCharSequence instanceof SpannableStringBuilder))
      {
        e[] arrayOfe = (e[])((SpannableStringBuilder)paramCharSequence).getSpans(0, paramCharSequence.length(), e.class);
        if (arrayOfe != null)
        {
          int i;
          if (arrayOfe.length == 0)
          {
            i = 1;
            if (i == 0) {
              break label76;
            }
            paramCharSequence = null;
          }
          for (;;)
          {
            if (paramCharSequence == null)
            {
              AppMethodBeat.o(277733);
              return 0L;
              i = 0;
              break;
              label76:
              Object localObject = arrayOfe[0];
              int k = k.ad(arrayOfe);
              paramCharSequence = (CharSequence)localObject;
              if (k != 0)
              {
                l1 = ((e)localObject).timestamp;
                paramCharSequence = (CharSequence)localObject;
                if (k > 0)
                {
                  i = j;
                  for (;;)
                  {
                    paramCharSequence = arrayOfe[i];
                    long l3 = paramCharSequence.timestamp;
                    long l2 = l1;
                    if (l1 < l3)
                    {
                      l2 = l3;
                      localObject = paramCharSequence;
                    }
                    paramCharSequence = (CharSequence)localObject;
                    if (i == k) {
                      break;
                    }
                    i += 1;
                    l1 = l2;
                  }
                }
              }
            }
          }
          long l1 = paramCharSequence.timestamp;
          AppMethodBeat.o(277733);
          return l1;
        }
      }
      AppMethodBeat.o(277733);
      return 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.e
 * JD-Core Version:    0.7.0.1
 */