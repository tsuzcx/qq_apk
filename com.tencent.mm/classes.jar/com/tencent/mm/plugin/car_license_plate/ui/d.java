package com.tencent.mm.plugin.car_license_plate.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract;", "", "CharViewContract", "CharViewType", "Companion", "plugin-car-license-plate_release"})
public abstract interface d
{
  public static final c sYh = c.sYD;
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewContract;", "", "keyboardId", "", "getKeyboardId", "()I", "keyboardLayout", "", "", "getKeyboardLayout", "()[Ljava/lang/CharSequence;", "legalChars", "getLegalChars", "()Ljava/lang/CharSequence;", "plugin-car-license-plate_release"})
  public static abstract interface a
  {
    public abstract int cFA();
    
    public abstract CharSequence cFy();
    
    public abstract CharSequence[] cFz();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewContract;", "(Ljava/lang/String;I)V", "PROVINCE", "ORG", "LETTER", "LETTER_6", "LETTER_7_8", "Companion", "plugin-car-license-plate_release"})
  public static abstract enum b
    implements d.a
  {
    public static final a sYo = new a((byte)0);
    
    static
    {
      f localf = new f("PROVINCE");
      sYi = localf;
      e locale = new e("ORG");
      sYj = locale;
      b localb = new b("LETTER");
      sYk = localb;
      c localc = new c("LETTER_6");
      sYl = localc;
      d locald = new d("LETTER_7_8");
      sYm = locald;
      sYn = new b[] { localf, locale, localb, localc, locald };
    }
    
    private b() {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType$Companion;", "", "()V", "indexToType", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "index", "", "plugin-car-license-plate_release"})
    public static final class a
    {
      public static d.b HD(int paramInt)
      {
        AppMethodBeat.i(187834);
        if (paramInt < 0) {}
        for (int i = 0;; i = 1)
        {
          if (i != 0) {
            break label49;
          }
          localObject = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(187834);
          throw ((Throwable)localObject);
          if (8 <= paramInt) {
            break;
          }
        }
        label49:
        if (paramInt == 0)
        {
          localObject = d.b.sYi;
          AppMethodBeat.o(187834);
          return localObject;
        }
        if (paramInt == 1)
        {
          localObject = d.b.sYj;
          AppMethodBeat.o(187834);
          return localObject;
        }
        if (2 > paramInt) {}
        while (paramInt == 5)
        {
          localObject = d.b.sYl;
          AppMethodBeat.o(187834);
          return localObject;
          if (4 >= paramInt)
          {
            localObject = d.b.sYk;
            AppMethodBeat.o(187834);
            return localObject;
          }
        }
        if (6 > paramInt) {}
        while (7 < paramInt)
        {
          localObject = (Throwable)new IllegalStateException("Invalid index".toString());
          AppMethodBeat.o(187834);
          throw ((Throwable)localObject);
        }
        Object localObject = d.b.sYm;
        AppMethodBeat.o(187834);
        return localObject;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType$LETTER;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "keyboardId", "", "getKeyboardId", "()I", "keyboardLayout", "", "", "getKeyboardLayout", "()[Ljava/lang/CharSequence;", "[Ljava/lang/CharSequence;", "legalChars", "getLegalChars", "()Ljava/lang/CharSequence;", "legalChars$delegate", "Lkotlin/Lazy;", "plugin-car-license-plate_release"})
    static final class b
      extends d.b
    {
      private final f sYp;
      private final CharSequence[] sYq;
      private final int sYr;
      
      b()
      {
        super(2, (byte)0);
        AppMethodBeat.i(187472);
        this.sYp = g.ar((a)a.sYs);
        Object localObject = d.sYh;
        this.sYq = d.c.cFB();
        localObject = d.sYh;
        this.sYr = d.c.cFC();
        AppMethodBeat.o(187472);
      }
      
      public final int cFA()
      {
        return this.sYr;
      }
      
      public final CharSequence cFy()
      {
        AppMethodBeat.i(187470);
        CharSequence localCharSequence = (CharSequence)this.sYp.getValue();
        AppMethodBeat.o(187470);
        return localCharSequence;
      }
      
      public final CharSequence[] cFz()
      {
        return this.sYq;
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class a
        extends q
        implements a<String>
      {
        public static final a sYs;
        
        static
        {
          AppMethodBeat.i(186364);
          sYs = new a();
          AppMethodBeat.o(186364);
        }
        
        a()
        {
          super();
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType$LETTER_6;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "keyboardId", "", "getKeyboardId", "()I", "keyboardLayout", "", "", "getKeyboardLayout", "()[Ljava/lang/CharSequence;", "[Ljava/lang/CharSequence;", "legalChars", "getLegalChars", "()Ljava/lang/CharSequence;", "plugin-car-license-plate_release"})
    static final class c
      extends d.b
    {
      private final CharSequence[] sYq;
      private final int sYr;
      private final CharSequence sYt;
      
      c()
      {
        super(3, (byte)0);
        AppMethodBeat.i(186391);
        this.sYt = d.b.sYk.cFy();
        Object localObject = d.sYh;
        this.sYq = d.c.cFB();
        localObject = d.sYh;
        this.sYr = d.c.cFC();
        AppMethodBeat.o(186391);
      }
      
      public final int cFA()
      {
        return this.sYr;
      }
      
      public final CharSequence cFy()
      {
        return this.sYt;
      }
      
      public final CharSequence[] cFz()
      {
        return this.sYq;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType$LETTER_7_8;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "keyboardId", "", "getKeyboardId", "()I", "keyboardLayout", "", "", "getKeyboardLayout", "()[Ljava/lang/CharSequence;", "[Ljava/lang/CharSequence;", "legalChars", "getLegalChars", "()Ljava/lang/CharSequence;", "legalChars$delegate", "Lkotlin/Lazy;", "plugin-car-license-plate_release"})
    static final class d
      extends d.b
    {
      private final f sYp;
      private final CharSequence[] sYq;
      private final int sYr;
      
      d()
      {
        super(4, (byte)0);
        AppMethodBeat.i(187590);
        this.sYp = g.ar((a)a.sYu);
        Object localObject = d.sYh;
        this.sYq = d.c.cFB();
        localObject = d.sYh;
        this.sYr = d.c.cFC();
        AppMethodBeat.o(187590);
      }
      
      public final int cFA()
      {
        return this.sYr;
      }
      
      public final CharSequence cFy()
      {
        AppMethodBeat.i(187586);
        CharSequence localCharSequence = (CharSequence)this.sYp.getValue();
        AppMethodBeat.o(187586);
        return localCharSequence;
      }
      
      public final CharSequence[] cFz()
      {
        return this.sYq;
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
      static final class a
        extends q
        implements a<String>
      {
        public static final a sYu;
        
        static
        {
          AppMethodBeat.i(187076);
          sYu = new a();
          AppMethodBeat.o(187076);
        }
        
        a()
        {
          super();
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType$ORG;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "keyboardId", "", "getKeyboardId", "()I", "keyboardLayout", "", "", "getKeyboardLayout", "()[Ljava/lang/CharSequence;", "[Ljava/lang/CharSequence;", "legalChars", "getLegalChars", "()Ljava/lang/CharSequence;", "legalChars$delegate", "Lkotlin/Lazy;", "plugin-car-license-plate_release"})
    static final class e
      extends d.b
    {
      private final f sYp;
      private final CharSequence[] sYq;
      private final int sYr;
      
      e()
      {
        super(1, (byte)0);
        AppMethodBeat.i(187872);
        this.sYp = g.ar((a)a.sYv);
        Object localObject = d.sYh;
        this.sYq = d.c.cFB();
        localObject = d.sYh;
        this.sYr = d.c.cFC();
        AppMethodBeat.o(187872);
      }
      
      public final int cFA()
      {
        return this.sYr;
      }
      
      public final CharSequence cFy()
      {
        AppMethodBeat.i(187868);
        CharSequence localCharSequence = (CharSequence)this.sYp.getValue();
        AppMethodBeat.o(187868);
        return localCharSequence;
      }
      
      public final CharSequence[] cFz()
      {
        return this.sYq;
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class a
        extends q
        implements a<String>
      {
        public static final a sYv;
        
        static
        {
          AppMethodBeat.i(186421);
          sYv = new a();
          AppMethodBeat.o(186421);
        }
        
        a()
        {
          super();
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType$PROVINCE;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "keyboardId", "", "getKeyboardId", "()I", "keyboardId$delegate", "Lkotlin/Lazy;", "keyboardLayout", "", "", "getKeyboardLayout", "()[Ljava/lang/CharSequence;", "keyboardLayout$delegate", "legalChars", "getLegalChars", "()Ljava/lang/CharSequence;", "legalChars$delegate", "plugin-car-license-plate_release"})
    static final class f
      extends d.b
    {
      private final f sYp;
      private final f sYw;
      private final f sYx;
      
      f()
      {
        super(0, (byte)0);
        AppMethodBeat.i(186534);
        this.sYp = g.ar((a)c.sYA);
        this.sYw = g.ar((a)b.sYz);
        this.sYx = g.ar((a)new a(this));
        AppMethodBeat.o(186534);
      }
      
      public final int cFA()
      {
        AppMethodBeat.i(186532);
        int i = ((Number)this.sYx.getValue()).intValue();
        AppMethodBeat.o(186532);
        return i;
      }
      
      public final CharSequence cFy()
      {
        AppMethodBeat.i(186528);
        CharSequence localCharSequence = (CharSequence)this.sYp.getValue();
        AppMethodBeat.o(186528);
        return localCharSequence;
      }
      
      public final CharSequence[] cFz()
      {
        AppMethodBeat.i(186529);
        CharSequence[] arrayOfCharSequence = (CharSequence[])this.sYw.getValue();
        AppMethodBeat.o(186529);
        return arrayOfCharSequence;
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class a
        extends q
        implements a<Integer>
      {
        a(d.b.f paramf)
        {
          super();
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "invoke", "()[Ljava/lang/CharSequence;"})
      static final class b
        extends q
        implements a<CharSequence[]>
      {
        public static final b sYz;
        
        static
        {
          AppMethodBeat.i(186793);
          sYz = new b();
          AppMethodBeat.o(186793);
        }
        
        b()
        {
          super();
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class c
        extends q
        implements a<String>
      {
        public static final c sYA;
        
        static
        {
          AppMethodBeat.i(186753);
          sYA = new c();
          AppMethodBeat.o(186753);
        }
        
        c()
        {
          super();
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$Companion;", "", "()V", "DEFAULT_KEYBOARD_ID", "", "getDEFAULT_KEYBOARD_ID", "()I", "DEFAULT_KEYBOARD_LAYOUT", "", "", "getDEFAULT_KEYBOARD_LAYOUT", "()[Ljava/lang/CharSequence;", "[Ljava/lang/CharSequence;", "PLATE_TEXT_LENGTH_MAX", "PLATE_TEXT_LENGTH_MIN", "plugin-car-license-plate_release"})
  public static final class c
  {
    private static final CharSequence[] sYB;
    private static final int sYC;
    
    static
    {
      AppMethodBeat.i(186461);
      sYD = new c();
      CharSequence[] arrayOfCharSequence = new CharSequence[5];
      arrayOfCharSequence[0] = ((CharSequence)"1234567890");
      arrayOfCharSequence[1] = ((CharSequence)"QWERTYUP");
      arrayOfCharSequence[2] = ((CharSequence)"ASDFGHJKL");
      arrayOfCharSequence[3] = ((CharSequence)"ZXCVBNM");
      arrayOfCharSequence[4] = ((CharSequence)"港澳学挂");
      sYB = arrayOfCharSequence;
      sYC = arrayOfCharSequence.hashCode();
      AppMethodBeat.o(186461);
    }
    
    public static CharSequence[] cFB()
    {
      return sYB;
    }
    
    public static int cFC()
    {
      return sYC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.d
 * JD-Core Version:    0.7.0.1
 */