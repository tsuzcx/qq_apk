package androidx.core.e;

import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class a
{
  static final d LL;
  private static final String LM;
  private static final String LN;
  static final a LO;
  static final a LP;
  private final boolean LR;
  private final d LS;
  private final int cN;
  
  static
  {
    AppMethodBeat.i(251207);
    LL = e.Mm;
    LM = Character.toString('‎');
    LN = Character.toString('‏');
    LO = new a(false, 2, LL);
    LP = new a(true, 2, LL);
    AppMethodBeat.o(251207);
  }
  
  private a(boolean paramBoolean, int paramInt, d paramd)
  {
    this.LR = paramBoolean;
    this.cN = paramInt;
    this.LS = paramd;
  }
  
  static boolean a(Locale paramLocale)
  {
    AppMethodBeat.i(251202);
    if (f.d(paramLocale) == 1)
    {
      AppMethodBeat.o(251202);
      return true;
    }
    AppMethodBeat.o(251202);
    return false;
  }
  
  public static a gI()
  {
    AppMethodBeat.i(251198);
    Object localObject = new a();
    if ((((a)localObject).cN == 2) && (((a)localObject).LT == LL))
    {
      if (((a)localObject).LR)
      {
        localObject = LP;
        AppMethodBeat.o(251198);
        return localObject;
      }
      localObject = LO;
      AppMethodBeat.o(251198);
      return localObject;
    }
    localObject = new a(((a)localObject).LR, ((a)localObject).cN, ((a)localObject).LT);
    AppMethodBeat.o(251198);
    return localObject;
  }
  
  private static int q(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(251204);
    int i = new b(paramCharSequence).gK();
    AppMethodBeat.o(251204);
    return i;
  }
  
  private static int r(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(251206);
    int i = new b(paramCharSequence).gJ();
    AppMethodBeat.o(251206);
    return i;
  }
  
  public final CharSequence p(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(251201);
    Object localObject = this.LS;
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(251201);
      return null;
    }
    boolean bool1 = ((d)localObject).a(paramCharSequence, paramCharSequence.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int k;
    label72:
    boolean bool2;
    if ((this.cN & 0x2) != 0)
    {
      k = 1;
      if (k != 0)
      {
        if (!bool1) {
          break label232;
        }
        localObject = e.Ml;
        bool2 = ((d)localObject).a(paramCharSequence, paramCharSequence.length());
        if ((this.LR) || ((!bool2) && (r(paramCharSequence) != 1))) {
          break label240;
        }
        localObject = LM;
        label113:
        localSpannableStringBuilder.append((CharSequence)localObject);
      }
      if (bool1 == this.LR) {
        break label282;
      }
      if (!bool1) {
        break label275;
      }
      int i = 8235;
      label139:
      localSpannableStringBuilder.append(i);
      localSpannableStringBuilder.append(paramCharSequence);
      localSpannableStringBuilder.append('‬');
      label162:
      if (!bool1) {
        break label292;
      }
      localObject = e.Ml;
      label172:
      bool1 = ((d)localObject).a(paramCharSequence, paramCharSequence.length());
      if ((this.LR) || ((!bool1) && (q(paramCharSequence) != 1))) {
        break label300;
      }
      paramCharSequence = LM;
    }
    for (;;)
    {
      localSpannableStringBuilder.append(paramCharSequence);
      AppMethodBeat.o(251201);
      return localSpannableStringBuilder;
      k = 0;
      break;
      label232:
      localObject = e.Mk;
      break label72;
      label240:
      if ((this.LR) && ((!bool2) || (r(paramCharSequence) == -1)))
      {
        localObject = LN;
        break label113;
      }
      localObject = "";
      break label113;
      label275:
      int j = 8234;
      break label139;
      label282:
      localSpannableStringBuilder.append(paramCharSequence);
      break label162;
      label292:
      localObject = e.Mk;
      break label172;
      label300:
      if ((this.LR) && ((!bool1) || (q(paramCharSequence) == -1))) {
        paramCharSequence = LN;
      } else {
        paramCharSequence = "";
      }
    }
  }
  
  public static final class a
  {
    boolean LR;
    d LT;
    int cN;
    
    public a()
    {
      AppMethodBeat.i(251169);
      this.LR = a.a(Locale.getDefault());
      this.LT = a.LL;
      this.cN = 2;
      AppMethodBeat.o(251169);
    }
  }
  
  static final class b
  {
    private static final byte[] LU;
    private final CharSequence LV;
    private final boolean LW;
    private int LX;
    private char LY;
    private final int length;
    
    static
    {
      AppMethodBeat.i(251195);
      LU = new byte[1792];
      int i = 0;
      while (i < 1792)
      {
        LU[i] = Character.getDirectionality(i);
        i += 1;
      }
      AppMethodBeat.o(251195);
    }
    
    b(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(251177);
      this.LV = paramCharSequence;
      this.LW = false;
      this.length = paramCharSequence.length();
      AppMethodBeat.o(251177);
    }
    
    private static byte a(char paramChar)
    {
      AppMethodBeat.i(251182);
      if (paramChar < '܀')
      {
        b = LU[paramChar];
        AppMethodBeat.o(251182);
        return b;
      }
      byte b = Character.getDirectionality(paramChar);
      AppMethodBeat.o(251182);
      return b;
    }
    
    private byte gL()
    {
      AppMethodBeat.i(251184);
      this.LY = this.LV.charAt(this.LX);
      if (Character.isHighSurrogate(this.LY))
      {
        int i = Character.codePointAt(this.LV, this.LX);
        this.LX += Character.charCount(i);
        b1 = Character.getDirectionality(i);
        AppMethodBeat.o(251184);
        return b1;
      }
      this.LX += 1;
      byte b2 = a(this.LY);
      byte b1 = b2;
      if (this.LW)
      {
        if (this.LY != '<') {
          break label117;
        }
        b1 = gN();
      }
      for (;;)
      {
        AppMethodBeat.o(251184);
        return b1;
        label117:
        b1 = b2;
        if (this.LY == '&') {
          b1 = gP();
        }
      }
    }
    
    private byte gM()
    {
      AppMethodBeat.i(251185);
      this.LY = this.LV.charAt(this.LX - 1);
      if (Character.isLowSurrogate(this.LY))
      {
        int i = Character.codePointBefore(this.LV, this.LX);
        this.LX -= Character.charCount(i);
        b1 = Character.getDirectionality(i);
        AppMethodBeat.o(251185);
        return b1;
      }
      this.LX -= 1;
      byte b2 = a(this.LY);
      byte b1 = b2;
      if (this.LW)
      {
        if (this.LY != '>') {
          break label119;
        }
        b1 = gO();
      }
      for (;;)
      {
        AppMethodBeat.o(251185);
        return b1;
        label119:
        b1 = b2;
        if (this.LY == ';') {
          b1 = gQ();
        }
      }
    }
    
    private byte gN()
    {
      AppMethodBeat.i(251188);
      int j = this.LX;
      for (;;)
      {
        if (this.LX >= this.length) {
          break label145;
        }
        CharSequence localCharSequence = this.LV;
        int k = this.LX;
        this.LX = (k + 1);
        this.LY = localCharSequence.charAt(k);
        if (this.LY == '>')
        {
          AppMethodBeat.o(251188);
          return 12;
        }
        if ((this.LY == '"') || (this.LY == '\''))
        {
          k = this.LY;
          if (this.LX < this.length)
          {
            localCharSequence = this.LV;
            int m = this.LX;
            this.LX = (m + 1);
            int i = localCharSequence.charAt(m);
            this.LY = i;
            if (i != k) {
              break;
            }
          }
        }
      }
      label145:
      this.LX = j;
      this.LY = '<';
      AppMethodBeat.o(251188);
      return 13;
    }
    
    private byte gO()
    {
      AppMethodBeat.i(251189);
      int j = this.LX;
      for (;;)
      {
        if (this.LX <= 0) {
          break label146;
        }
        CharSequence localCharSequence = this.LV;
        int k = this.LX - 1;
        this.LX = k;
        this.LY = localCharSequence.charAt(k);
        if (this.LY == '<')
        {
          AppMethodBeat.o(251189);
          return 12;
        }
        if (this.LY == '>') {
          break label146;
        }
        if ((this.LY == '"') || (this.LY == '\''))
        {
          k = this.LY;
          if (this.LX > 0)
          {
            localCharSequence = this.LV;
            int m = this.LX - 1;
            this.LX = m;
            int i = localCharSequence.charAt(m);
            this.LY = i;
            if (i != k) {
              break;
            }
          }
        }
      }
      label146:
      this.LX = j;
      this.LY = '>';
      AppMethodBeat.o(251189);
      return 13;
    }
    
    private byte gP()
    {
      AppMethodBeat.i(251192);
      char c;
      do
      {
        if (this.LX >= this.length) {
          break;
        }
        CharSequence localCharSequence = this.LV;
        int i = this.LX;
        this.LX = (i + 1);
        c = localCharSequence.charAt(i);
        this.LY = c;
      } while (c != ';');
      AppMethodBeat.o(251192);
      return 12;
    }
    
    private byte gQ()
    {
      AppMethodBeat.i(251193);
      int i = this.LX;
      do
      {
        if (this.LX <= 0) {
          break;
        }
        CharSequence localCharSequence = this.LV;
        int j = this.LX - 1;
        this.LX = j;
        this.LY = localCharSequence.charAt(j);
        if (this.LY == '&')
        {
          AppMethodBeat.o(251193);
          return 12;
        }
      } while (this.LY != ';');
      this.LX = i;
      this.LY = ';';
      AppMethodBeat.o(251193);
      return 13;
    }
    
    final int gJ()
    {
      AppMethodBeat.i(251179);
      this.LX = 0;
      int j = 0;
      int k = 0;
      int i = 0;
      while ((this.LX < this.length) && (j == 0)) {
        switch (gL())
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          j = i;
          break;
        case 14: 
        case 15: 
          i += 1;
          k = -1;
          break;
        case 16: 
        case 17: 
          i += 1;
          k = 1;
          break;
        case 18: 
          i -= 1;
          k = 0;
          break;
        case 0: 
          if (i == 0)
          {
            AppMethodBeat.o(251179);
            return -1;
          }
          j = i;
          break;
        case 1: 
        case 2: 
          if (i == 0)
          {
            AppMethodBeat.o(251179);
            return 1;
          }
          j = i;
        }
      }
      if (j == 0)
      {
        AppMethodBeat.o(251179);
        return 0;
      }
      if (k != 0)
      {
        AppMethodBeat.o(251179);
        return k;
      }
      while (this.LX > 0) {
        switch (gM())
        {
        default: 
          break;
        case 14: 
        case 15: 
          if (j == i)
          {
            AppMethodBeat.o(251179);
            return -1;
          }
          i -= 1;
          break;
        case 16: 
        case 17: 
          if (j == i)
          {
            AppMethodBeat.o(251179);
            return 1;
          }
          i -= 1;
          break;
        case 18: 
          i += 1;
        }
      }
      AppMethodBeat.o(251179);
      return 0;
    }
    
    final int gK()
    {
      AppMethodBeat.i(251180);
      this.LX = this.length;
      int j = 0;
      int i = 0;
      while (this.LX > 0) {
        switch (gM())
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          if (j == 0) {
            j = i;
          }
          break;
        case 0: 
          if (i == 0)
          {
            AppMethodBeat.o(251180);
            return -1;
          }
          if (j == 0) {
            j = i;
          }
          break;
        case 14: 
        case 15: 
          if (j == i)
          {
            AppMethodBeat.o(251180);
            return -1;
          }
          i -= 1;
          break;
        case 1: 
        case 2: 
          if (i == 0)
          {
            AppMethodBeat.o(251180);
            return 1;
          }
          if (j == 0) {
            j = i;
          }
          break;
        case 16: 
        case 17: 
          if (j == i)
          {
            AppMethodBeat.o(251180);
            return 1;
          }
          i -= 1;
          break;
        case 18: 
          i += 1;
        }
      }
      AppMethodBeat.o(251180);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.e.a
 * JD-Core Version:    0.7.0.1
 */