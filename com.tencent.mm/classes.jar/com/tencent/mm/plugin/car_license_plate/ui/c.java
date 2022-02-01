package com.tencent.mm.plugin.car_license_plate.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract;", "", "CharViewContract", "CharViewType", "Companion", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
{
  public static final c wcA = c.wcU;
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewContract;", "", "keyboardId", "", "getKeyboardId", "()I", "keyboardLayout", "", "", "getKeyboardLayout", "()[Ljava/lang/CharSequence;", "legalChars", "getLegalChars", "()Ljava/lang/CharSequence;", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract CharSequence diR();
    
    public abstract CharSequence[] diS();
    
    public abstract int diT();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewContract;", "(Ljava/lang/String;I)V", "PROVINCE", "ORG", "LETTER", "LETTER_6", "LETTER_7_8", "Companion", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract enum b
    implements c.a
  {
    public static final a wcB = new a((byte)0);
    
    private b() {}
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType$Companion;", "", "()V", "indexToType", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "index", "", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static c.b Ie(int paramInt)
      {
        int j = 1;
        AppMethodBeat.i(277776);
        int i;
        if (paramInt >= 0) {
          if (paramInt < 8) {
            i = 1;
          }
        }
        while (i == 0)
        {
          localObject = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(277776);
          throw ((Throwable)localObject);
          i = 0;
          continue;
          i = 0;
        }
        if (paramInt == 0)
        {
          localObject = c.b.wcC;
          AppMethodBeat.o(277776);
          return localObject;
        }
        if (paramInt == 1)
        {
          localObject = c.b.wcD;
          AppMethodBeat.o(277776);
          return localObject;
        }
        if (2 <= paramInt) {
          if (paramInt <= 4) {
            i = 1;
          }
        }
        while (i != 0)
        {
          localObject = c.b.wcE;
          AppMethodBeat.o(277776);
          return localObject;
          i = 0;
          continue;
          i = 0;
        }
        if (paramInt == 5)
        {
          localObject = c.b.wcF;
          AppMethodBeat.o(277776);
          return localObject;
        }
        if (6 <= paramInt) {
          if (paramInt <= 7) {
            paramInt = j;
          }
        }
        while (paramInt != 0)
        {
          localObject = c.b.wcG;
          AppMethodBeat.o(277776);
          return localObject;
          paramInt = 0;
          continue;
          paramInt = 0;
        }
        Object localObject = (Throwable)new IllegalStateException("Invalid index".toString());
        AppMethodBeat.o(277776);
        throw ((Throwable)localObject);
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType$LETTER;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "keyboardId", "", "getKeyboardId", "()I", "keyboardLayout", "", "", "getKeyboardLayout", "()[Ljava/lang/CharSequence;", "[Ljava/lang/CharSequence;", "legalChars", "getLegalChars", "()Ljava/lang/CharSequence;", "legalChars$delegate", "Lkotlin/Lazy;", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class b
      extends c.b
    {
      private final j wcI;
      private final CharSequence[] wcJ;
      private final int wcK;
      
      b()
      {
        super(2, (byte)0);
        AppMethodBeat.i(277779);
        this.wcI = k.cm((a)a.wcL);
        Object localObject = c.wcA;
        this.wcJ = c.c.diU();
        localObject = c.wcA;
        this.wcK = c.c.diV();
        AppMethodBeat.o(277779);
      }
      
      public final CharSequence diR()
      {
        AppMethodBeat.i(277783);
        CharSequence localCharSequence = (CharSequence)this.wcI.getValue();
        AppMethodBeat.o(277783);
        return localCharSequence;
      }
      
      public final CharSequence[] diS()
      {
        return this.wcJ;
      }
      
      public final int diT()
      {
        return this.wcK;
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements a<String>
      {
        public static final a wcL;
        
        static
        {
          AppMethodBeat.i(277787);
          wcL = new a();
          AppMethodBeat.o(277787);
        }
        
        a()
        {
          super();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType$LETTER_6;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "keyboardId", "", "getKeyboardId", "()I", "keyboardLayout", "", "", "getKeyboardLayout", "()[Ljava/lang/CharSequence;", "[Ljava/lang/CharSequence;", "legalChars", "getLegalChars", "()Ljava/lang/CharSequence;", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class c
      extends c.b
    {
      private final CharSequence[] wcJ;
      private final int wcK;
      private final CharSequence wcM;
      
      c()
      {
        super(3, (byte)0);
        AppMethodBeat.i(277759);
        this.wcM = c.b.wcE.diR();
        Object localObject = c.wcA;
        this.wcJ = c.c.diU();
        localObject = c.wcA;
        this.wcK = c.c.diV();
        AppMethodBeat.o(277759);
      }
      
      public final CharSequence diR()
      {
        return this.wcM;
      }
      
      public final CharSequence[] diS()
      {
        return this.wcJ;
      }
      
      public final int diT()
      {
        return this.wcK;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType$LETTER_7_8;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "keyboardId", "", "getKeyboardId", "()I", "keyboardLayout", "", "", "getKeyboardLayout", "()[Ljava/lang/CharSequence;", "[Ljava/lang/CharSequence;", "legalChars", "getLegalChars", "()Ljava/lang/CharSequence;", "legalChars$delegate", "Lkotlin/Lazy;", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class d
      extends c.b
    {
      private final j wcI;
      private final CharSequence[] wcJ;
      private final int wcK;
      
      d()
      {
        super(4, (byte)0);
        AppMethodBeat.i(277757);
        this.wcI = k.cm((a)a.wcN);
        Object localObject = c.wcA;
        this.wcJ = c.c.diU();
        localObject = c.wcA;
        this.wcK = c.c.diV();
        AppMethodBeat.o(277757);
      }
      
      public final CharSequence diR()
      {
        AppMethodBeat.i(277766);
        Object localObject = this.wcI.getValue();
        s.s(localObject, "<get-legalChars>(...)");
        localObject = (CharSequence)localObject;
        AppMethodBeat.o(277766);
        return localObject;
      }
      
      public final CharSequence[] diS()
      {
        return this.wcJ;
      }
      
      public final int diT()
      {
        return this.wcK;
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements a<String>
      {
        public static final a wcN;
        
        static
        {
          AppMethodBeat.i(277764);
          wcN = new a();
          AppMethodBeat.o(277764);
        }
        
        a()
        {
          super();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType$ORG;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "keyboardId", "", "getKeyboardId", "()I", "keyboardLayout", "", "", "getKeyboardLayout", "()[Ljava/lang/CharSequence;", "[Ljava/lang/CharSequence;", "legalChars", "getLegalChars", "()Ljava/lang/CharSequence;", "legalChars$delegate", "Lkotlin/Lazy;", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class e
      extends c.b
    {
      private final j wcI;
      private final CharSequence[] wcJ;
      private final int wcK;
      
      e()
      {
        super(1, (byte)0);
        AppMethodBeat.i(277763);
        this.wcI = k.cm((a)a.wcO);
        Object localObject = c.wcA;
        this.wcJ = c.c.diU();
        localObject = c.wcA;
        this.wcK = c.c.diV();
        AppMethodBeat.o(277763);
      }
      
      public final CharSequence diR()
      {
        AppMethodBeat.i(277772);
        CharSequence localCharSequence = (CharSequence)this.wcI.getValue();
        AppMethodBeat.o(277772);
        return localCharSequence;
      }
      
      public final CharSequence[] diS()
      {
        return this.wcJ;
      }
      
      public final int diT()
      {
        return this.wcK;
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements a<String>
      {
        public static final a wcO;
        
        static
        {
          AppMethodBeat.i(277629);
          wcO = new a();
          AppMethodBeat.o(277629);
        }
        
        a()
        {
          super();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType$PROVINCE;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "keyboardId", "", "getKeyboardId", "()I", "keyboardId$delegate", "Lkotlin/Lazy;", "keyboardLayout", "", "", "getKeyboardLayout", "()[Ljava/lang/CharSequence;", "keyboardLayout$delegate", "legalChars", "getLegalChars", "()Ljava/lang/CharSequence;", "legalChars$delegate", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class f
      extends c.b
    {
      private final j wcI;
      private final j wcP;
      private final j wcQ;
      
      f()
      {
        super(0, (byte)0);
        AppMethodBeat.i(277753);
        this.wcI = k.cm((a)c.wcT);
        this.wcP = k.cm((a)b.wcS);
        this.wcQ = k.cm((a)new a(this));
        AppMethodBeat.o(277753);
      }
      
      public final CharSequence diR()
      {
        AppMethodBeat.i(277762);
        CharSequence localCharSequence = (CharSequence)this.wcI.getValue();
        AppMethodBeat.o(277762);
        return localCharSequence;
      }
      
      public final CharSequence[] diS()
      {
        AppMethodBeat.i(277769);
        CharSequence[] arrayOfCharSequence = (CharSequence[])this.wcP.getValue();
        AppMethodBeat.o(277769);
        return arrayOfCharSequence;
      }
      
      public final int diT()
      {
        AppMethodBeat.i(277777);
        int i = ((Number)this.wcQ.getValue()).intValue();
        AppMethodBeat.o(277777);
        return i;
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements a<Integer>
      {
        a(c.b.f paramf)
        {
          super();
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", "", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class b
        extends u
        implements a<CharSequence[]>
      {
        public static final b wcS;
        
        static
        {
          AppMethodBeat.i(277713);
          wcS = new b();
          AppMethodBeat.o(277713);
        }
        
        b()
        {
          super();
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class c
        extends u
        implements a<String>
      {
        public static final c wcT;
        
        static
        {
          AppMethodBeat.i(277709);
          wcT = new c();
          AppMethodBeat.o(277709);
        }
        
        c()
        {
          super();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$Companion;", "", "()V", "DEFAULT_KEYBOARD_ID", "", "getDEFAULT_KEYBOARD_ID", "()I", "DEFAULT_KEYBOARD_LAYOUT", "", "", "getDEFAULT_KEYBOARD_LAYOUT", "()[Ljava/lang/CharSequence;", "[Ljava/lang/CharSequence;", "PLATE_TEXT_LENGTH_MAX", "PLATE_TEXT_LENGTH_MIN", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    private static final CharSequence[] wcV;
    private static final int wcW;
    
    static
    {
      AppMethodBeat.i(277775);
      wcU = new c();
      CharSequence[] arrayOfCharSequence = new CharSequence[5];
      arrayOfCharSequence[0] = ((CharSequence)"1234567890");
      arrayOfCharSequence[1] = ((CharSequence)"QWERTYUP");
      arrayOfCharSequence[2] = ((CharSequence)"ASDFGHJKL");
      arrayOfCharSequence[3] = ((CharSequence)"ZXCVBNM");
      arrayOfCharSequence[4] = ((CharSequence)"港澳学挂");
      wcV = arrayOfCharSequence;
      wcW = arrayOfCharSequence.hashCode();
      AppMethodBeat.o(277775);
    }
    
    public static CharSequence[] diU()
    {
      return wcV;
    }
    
    public static int diV()
    {
      return wcW;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.c
 * JD-Core Version:    0.7.0.1
 */