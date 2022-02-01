package midas.x;

public final class ml
{
  private static final int[] a = { 31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017 };
  private static final ml[] b = d();
  private final int c;
  private final int[] d;
  private final b[] e;
  private final int f;
  
  private ml(int paramInt, int[] paramArrayOfInt, b... paramVarArgs)
  {
    this.c = paramInt;
    this.d = paramArrayOfInt;
    this.e = paramVarArgs;
    paramInt = 0;
    int j = paramVarArgs[0].a();
    paramArrayOfInt = paramVarArgs[0].d();
    int k = paramArrayOfInt.length;
    int i = 0;
    while (paramInt < k)
    {
      paramVarArgs = paramArrayOfInt[paramInt];
      i += paramVarArgs.a() * (paramVarArgs.b() + j);
      paramInt += 1;
    }
    this.f = i;
  }
  
  public static ml a(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 40)) {
      return b[(paramInt - 1)];
    }
    throw new IllegalArgumentException();
  }
  
  private static ml[] d()
  {
    Object localObject1 = new b(7, new a[] { new a(1, 19) });
    Object localObject2 = new b(10, new a[] { new a(1, 16) });
    Object localObject3 = new b(13, new a[] { new a(1, 13) });
    Object localObject4 = new b(17, new a[] { new a(1, 9) });
    localObject1 = new ml(1, new int[0], new b[] { localObject1, localObject2, localObject3, localObject4 });
    localObject2 = new b(10, new a[] { new a(1, 34) });
    localObject3 = new b(16, new a[] { new a(1, 28) });
    localObject4 = new b(22, new a[] { new a(1, 22) });
    Object localObject5 = new b(28, new a[] { new a(1, 16) });
    localObject2 = new ml(2, new int[] { 6, 18 }, new b[] { localObject2, localObject3, localObject4, localObject5 });
    localObject3 = new b(15, new a[] { new a(1, 55) });
    localObject4 = new b(26, new a[] { new a(1, 44) });
    localObject5 = new b(18, new a[] { new a(2, 17) });
    Object localObject6 = new b(22, new a[] { new a(2, 13) });
    localObject3 = new ml(3, new int[] { 6, 22 }, new b[] { localObject3, localObject4, localObject5, localObject6 });
    localObject4 = new b(20, new a[] { new a(1, 80) });
    localObject5 = new b(18, new a[] { new a(2, 32) });
    localObject6 = new b(26, new a[] { new a(2, 24) });
    Object localObject7 = new b(16, new a[] { new a(4, 9) });
    localObject4 = new ml(4, new int[] { 6, 26 }, new b[] { localObject4, localObject5, localObject6, localObject7 });
    localObject5 = new b(26, new a[] { new a(1, 108) });
    localObject6 = new b(24, new a[] { new a(2, 43) });
    localObject7 = new b(18, new a[] { new a(2, 15), new a(2, 16) });
    Object localObject8 = new b(22, new a[] { new a(2, 11), new a(2, 12) });
    localObject5 = new ml(5, new int[] { 6, 30 }, new b[] { localObject5, localObject6, localObject7, localObject8 });
    localObject6 = new b(18, new a[] { new a(2, 68) });
    localObject7 = new b(16, new a[] { new a(4, 27) });
    localObject8 = new b(24, new a[] { new a(4, 19) });
    Object localObject9 = new b(28, new a[] { new a(4, 15) });
    localObject6 = new ml(6, new int[] { 6, 34 }, new b[] { localObject6, localObject7, localObject8, localObject9 });
    localObject7 = new b(20, new a[] { new a(2, 78) });
    localObject8 = new b(18, new a[] { new a(4, 31) });
    localObject9 = new b(18, new a[] { new a(2, 14), new a(4, 15) });
    Object localObject10 = new b(26, new a[] { new a(4, 13), new a(1, 14) });
    localObject7 = new ml(7, new int[] { 6, 22, 38 }, new b[] { localObject7, localObject8, localObject9, localObject10 });
    localObject8 = new b(24, new a[] { new a(2, 97) });
    localObject9 = new b(22, new a[] { new a(2, 38), new a(2, 39) });
    localObject10 = new b(22, new a[] { new a(4, 18), new a(2, 19) });
    Object localObject11 = new b(26, new a[] { new a(4, 14), new a(2, 15) });
    localObject8 = new ml(8, new int[] { 6, 24, 42 }, new b[] { localObject8, localObject9, localObject10, localObject11 });
    localObject9 = new b(30, new a[] { new a(2, 116) });
    localObject10 = new b(22, new a[] { new a(3, 36), new a(2, 37) });
    localObject11 = new b(20, new a[] { new a(4, 16), new a(4, 17) });
    Object localObject12 = new b(24, new a[] { new a(4, 12), new a(4, 13) });
    localObject9 = new ml(9, new int[] { 6, 26, 46 }, new b[] { localObject9, localObject10, localObject11, localObject12 });
    localObject10 = new b(18, new a[] { new a(2, 68), new a(2, 69) });
    localObject11 = new b(26, new a[] { new a(4, 43), new a(1, 44) });
    localObject12 = new b(24, new a[] { new a(6, 19), new a(2, 20) });
    Object localObject13 = new b(28, new a[] { new a(6, 15), new a(2, 16) });
    localObject10 = new ml(10, new int[] { 6, 28, 50 }, new b[] { localObject10, localObject11, localObject12, localObject13 });
    localObject11 = new b(20, new a[] { new a(4, 81) });
    localObject12 = new b(30, new a[] { new a(1, 50), new a(4, 51) });
    localObject13 = new b(28, new a[] { new a(4, 22), new a(4, 23) });
    Object localObject14 = new b(24, new a[] { new a(3, 12), new a(8, 13) });
    localObject11 = new ml(11, new int[] { 6, 30, 54 }, new b[] { localObject11, localObject12, localObject13, localObject14 });
    localObject12 = new b(24, new a[] { new a(2, 92), new a(2, 93) });
    localObject13 = new b(22, new a[] { new a(6, 36), new a(2, 37) });
    localObject14 = new b(26, new a[] { new a(4, 20), new a(6, 21) });
    Object localObject15 = new b(28, new a[] { new a(7, 14), new a(4, 15) });
    localObject12 = new ml(12, new int[] { 6, 32, 58 }, new b[] { localObject12, localObject13, localObject14, localObject15 });
    localObject13 = new b(26, new a[] { new a(4, 107) });
    localObject14 = new b(22, new a[] { new a(8, 37), new a(1, 38) });
    localObject15 = new b(24, new a[] { new a(8, 20), new a(4, 21) });
    Object localObject16 = new b(22, new a[] { new a(12, 11), new a(4, 12) });
    localObject13 = new ml(13, new int[] { 6, 34, 62 }, new b[] { localObject13, localObject14, localObject15, localObject16 });
    localObject14 = new b(30, new a[] { new a(3, 115), new a(1, 116) });
    localObject15 = new b(24, new a[] { new a(4, 40), new a(5, 41) });
    localObject16 = new b(20, new a[] { new a(11, 16), new a(5, 17) });
    Object localObject17 = new b(24, new a[] { new a(11, 12), new a(5, 13) });
    localObject14 = new ml(14, new int[] { 6, 26, 46, 66 }, new b[] { localObject14, localObject15, localObject16, localObject17 });
    localObject15 = new b(22, new a[] { new a(5, 87), new a(1, 88) });
    localObject16 = new b(24, new a[] { new a(5, 41), new a(5, 42) });
    localObject17 = new b(30, new a[] { new a(5, 24), new a(7, 25) });
    Object localObject18 = new b(24, new a[] { new a(11, 12), new a(7, 13) });
    localObject15 = new ml(15, new int[] { 6, 26, 48, 70 }, new b[] { localObject15, localObject16, localObject17, localObject18 });
    localObject16 = new b(24, new a[] { new a(5, 98), new a(1, 99) });
    localObject17 = new b(28, new a[] { new a(7, 45), new a(3, 46) });
    localObject18 = new b(24, new a[] { new a(15, 19), new a(2, 20) });
    Object localObject19 = new b(30, new a[] { new a(3, 15), new a(13, 16) });
    localObject16 = new ml(16, new int[] { 6, 26, 50, 74 }, new b[] { localObject16, localObject17, localObject18, localObject19 });
    localObject17 = new b(28, new a[] { new a(1, 107), new a(5, 108) });
    localObject18 = new b(28, new a[] { new a(10, 46), new a(1, 47) });
    localObject19 = new b(28, new a[] { new a(1, 22), new a(15, 23) });
    Object localObject20 = new b(28, new a[] { new a(2, 14), new a(17, 15) });
    localObject17 = new ml(17, new int[] { 6, 30, 54, 78 }, new b[] { localObject17, localObject18, localObject19, localObject20 });
    localObject18 = new b(30, new a[] { new a(5, 120), new a(1, 121) });
    localObject19 = new b(26, new a[] { new a(9, 43), new a(4, 44) });
    localObject20 = new b(28, new a[] { new a(17, 22), new a(1, 23) });
    Object localObject21 = new b(28, new a[] { new a(2, 14), new a(19, 15) });
    localObject18 = new ml(18, new int[] { 6, 30, 56, 82 }, new b[] { localObject18, localObject19, localObject20, localObject21 });
    localObject19 = new b(28, new a[] { new a(3, 113), new a(4, 114) });
    localObject20 = new b(26, new a[] { new a(3, 44), new a(11, 45) });
    localObject21 = new b(26, new a[] { new a(17, 21), new a(4, 22) });
    Object localObject22 = new b(26, new a[] { new a(9, 13), new a(16, 14) });
    localObject19 = new ml(19, new int[] { 6, 30, 58, 86 }, new b[] { localObject19, localObject20, localObject21, localObject22 });
    localObject20 = new b(28, new a[] { new a(3, 107), new a(5, 108) });
    localObject21 = new b(26, new a[] { new a(3, 41), new a(13, 42) });
    localObject22 = new b(30, new a[] { new a(15, 24), new a(5, 25) });
    Object localObject23 = new b(28, new a[] { new a(15, 15), new a(10, 16) });
    localObject20 = new ml(20, new int[] { 6, 34, 62, 90 }, new b[] { localObject20, localObject21, localObject22, localObject23 });
    localObject21 = new b(28, new a[] { new a(4, 116), new a(4, 117) });
    localObject22 = new b(26, new a[] { new a(17, 42) });
    localObject23 = new b(28, new a[] { new a(17, 22), new a(6, 23) });
    Object localObject24 = new b(30, new a[] { new a(19, 16), new a(6, 17) });
    localObject21 = new ml(21, new int[] { 6, 28, 50, 72, 94 }, new b[] { localObject21, localObject22, localObject23, localObject24 });
    localObject22 = new b(28, new a[] { new a(2, 111), new a(7, 112) });
    localObject23 = new b(28, new a[] { new a(17, 46) });
    localObject24 = new b(30, new a[] { new a(7, 24), new a(16, 25) });
    Object localObject25 = new b(24, new a[] { new a(34, 13) });
    localObject22 = new ml(22, new int[] { 6, 26, 50, 74, 98 }, new b[] { localObject22, localObject23, localObject24, localObject25 });
    localObject23 = new b(30, new a[] { new a(4, 121), new a(5, 122) });
    localObject24 = new b(28, new a[] { new a(4, 47), new a(14, 48) });
    localObject25 = new b(30, new a[] { new a(11, 24), new a(14, 25) });
    Object localObject26 = new b(30, new a[] { new a(16, 15), new a(14, 16) });
    localObject23 = new ml(23, new int[] { 6, 30, 54, 78, 102 }, new b[] { localObject23, localObject24, localObject25, localObject26 });
    localObject24 = new b(30, new a[] { new a(6, 117), new a(4, 118) });
    localObject25 = new b(28, new a[] { new a(6, 45), new a(14, 46) });
    localObject26 = new b(30, new a[] { new a(11, 24), new a(16, 25) });
    Object localObject27 = new b(30, new a[] { new a(30, 16), new a(2, 17) });
    localObject24 = new ml(24, new int[] { 6, 28, 54, 80, 106 }, new b[] { localObject24, localObject25, localObject26, localObject27 });
    localObject25 = new b(26, new a[] { new a(8, 106), new a(4, 107) });
    localObject26 = new b(28, new a[] { new a(8, 47), new a(13, 48) });
    localObject27 = new b(30, new a[] { new a(7, 24), new a(22, 25) });
    Object localObject28 = new b(30, new a[] { new a(22, 15), new a(13, 16) });
    localObject25 = new ml(25, new int[] { 6, 32, 58, 84, 110 }, new b[] { localObject25, localObject26, localObject27, localObject28 });
    localObject26 = new b(28, new a[] { new a(10, 114), new a(2, 115) });
    localObject27 = new b(28, new a[] { new a(19, 46), new a(4, 47) });
    localObject28 = new b(28, new a[] { new a(28, 22), new a(6, 23) });
    Object localObject29 = new b(30, new a[] { new a(33, 16), new a(4, 17) });
    localObject26 = new ml(26, new int[] { 6, 30, 58, 86, 114 }, new b[] { localObject26, localObject27, localObject28, localObject29 });
    localObject27 = new b(30, new a[] { new a(8, 122), new a(4, 123) });
    localObject28 = new b(28, new a[] { new a(22, 45), new a(3, 46) });
    localObject29 = new b(30, new a[] { new a(8, 23), new a(26, 24) });
    Object localObject30 = new b(30, new a[] { new a(12, 15), new a(28, 16) });
    localObject27 = new ml(27, new int[] { 6, 34, 62, 90, 118 }, new b[] { localObject27, localObject28, localObject29, localObject30 });
    localObject28 = new b(30, new a[] { new a(3, 117), new a(10, 118) });
    localObject29 = new b(28, new a[] { new a(3, 45), new a(23, 46) });
    localObject30 = new b(30, new a[] { new a(4, 24), new a(31, 25) });
    Object localObject31 = new b(30, new a[] { new a(11, 15), new a(31, 16) });
    localObject28 = new ml(28, new int[] { 6, 26, 50, 74, 98, 122 }, new b[] { localObject28, localObject29, localObject30, localObject31 });
    localObject29 = new b(30, new a[] { new a(7, 116), new a(7, 117) });
    localObject30 = new b(28, new a[] { new a(21, 45), new a(7, 46) });
    localObject31 = new b(30, new a[] { new a(1, 23), new a(37, 24) });
    Object localObject32 = new b(30, new a[] { new a(19, 15), new a(26, 16) });
    localObject29 = new ml(29, new int[] { 6, 30, 54, 78, 102, 126 }, new b[] { localObject29, localObject30, localObject31, localObject32 });
    localObject30 = new b(30, new a[] { new a(5, 115), new a(10, 116) });
    localObject31 = new b(28, new a[] { new a(19, 47), new a(10, 48) });
    localObject32 = new b(30, new a[] { new a(15, 24), new a(25, 25) });
    Object localObject33 = new b(30, new a[] { new a(23, 15), new a(25, 16) });
    localObject30 = new ml(30, new int[] { 6, 26, 52, 78, 104, 130 }, new b[] { localObject30, localObject31, localObject32, localObject33 });
    localObject31 = new b(30, new a[] { new a(13, 115), new a(3, 116) });
    localObject32 = new b(28, new a[] { new a(2, 46), new a(29, 47) });
    localObject33 = new b(30, new a[] { new a(42, 24), new a(1, 25) });
    Object localObject34 = new b(30, new a[] { new a(23, 15), new a(28, 16) });
    localObject31 = new ml(31, new int[] { 6, 30, 56, 82, 108, 134 }, new b[] { localObject31, localObject32, localObject33, localObject34 });
    localObject32 = new b(30, new a[] { new a(17, 115) });
    localObject33 = new b(28, new a[] { new a(10, 46), new a(23, 47) });
    localObject34 = new b(30, new a[] { new a(10, 24), new a(35, 25) });
    Object localObject35 = new b(30, new a[] { new a(19, 15), new a(35, 16) });
    localObject32 = new ml(32, new int[] { 6, 34, 60, 86, 112, 138 }, new b[] { localObject32, localObject33, localObject34, localObject35 });
    localObject33 = new b(30, new a[] { new a(17, 115), new a(1, 116) });
    localObject34 = new b(28, new a[] { new a(14, 46), new a(21, 47) });
    localObject35 = new b(30, new a[] { new a(29, 24), new a(19, 25) });
    Object localObject36 = new b(30, new a[] { new a(11, 15), new a(46, 16) });
    localObject33 = new ml(33, new int[] { 6, 30, 58, 86, 114, 142 }, new b[] { localObject33, localObject34, localObject35, localObject36 });
    localObject34 = new b(30, new a[] { new a(13, 115), new a(6, 116) });
    localObject35 = new b(28, new a[] { new a(14, 46), new a(23, 47) });
    localObject36 = new b(30, new a[] { new a(44, 24), new a(7, 25) });
    Object localObject37 = new b(30, new a[] { new a(59, 16), new a(1, 17) });
    localObject34 = new ml(34, new int[] { 6, 34, 62, 90, 118, 146 }, new b[] { localObject34, localObject35, localObject36, localObject37 });
    localObject35 = new b(30, new a[] { new a(12, 121), new a(7, 122) });
    localObject36 = new b(28, new a[] { new a(12, 47), new a(26, 48) });
    localObject37 = new b(30, new a[] { new a(39, 24), new a(14, 25) });
    Object localObject38 = new b(30, new a[] { new a(22, 15), new a(41, 16) });
    localObject35 = new ml(35, new int[] { 6, 30, 54, 78, 102, 126, 150 }, new b[] { localObject35, localObject36, localObject37, localObject38 });
    localObject36 = new b(30, new a[] { new a(6, 121), new a(14, 122) });
    localObject37 = new b(28, new a[] { new a(6, 47), new a(34, 48) });
    localObject38 = new b(30, new a[] { new a(46, 24), new a(10, 25) });
    Object localObject39 = new b(30, new a[] { new a(2, 15), new a(64, 16) });
    localObject36 = new ml(36, new int[] { 6, 24, 50, 76, 102, 128, 154 }, new b[] { localObject36, localObject37, localObject38, localObject39 });
    localObject37 = new b(30, new a[] { new a(17, 122), new a(4, 123) });
    localObject38 = new b(28, new a[] { new a(29, 46), new a(14, 47) });
    localObject39 = new b(30, new a[] { new a(49, 24), new a(10, 25) });
    b localb1 = new b(30, new a[] { new a(24, 15), new a(46, 16) });
    localObject37 = new ml(37, new int[] { 6, 28, 54, 80, 106, 132, 158 }, new b[] { localObject37, localObject38, localObject39, localb1 });
    localObject38 = new b(30, new a[] { new a(4, 122), new a(18, 123) });
    localObject39 = new b(28, new a[] { new a(13, 46), new a(32, 47) });
    localb1 = new b(30, new a[] { new a(48, 24), new a(14, 25) });
    b localb2 = new b(30, new a[] { new a(42, 15), new a(32, 16) });
    localObject38 = new ml(38, new int[] { 6, 32, 58, 84, 110, 136, 162 }, new b[] { localObject38, localObject39, localb1, localb2 });
    localObject39 = new b(30, new a[] { new a(20, 117), new a(4, 118) });
    localb1 = new b(28, new a[] { new a(40, 47), new a(7, 48) });
    localb2 = new b(30, new a[] { new a(43, 24), new a(22, 25) });
    b localb3 = new b(30, new a[] { new a(10, 15), new a(67, 16) });
    localObject39 = new ml(39, new int[] { 6, 26, 54, 82, 110, 138, 166 }, new b[] { localObject39, localb1, localb2, localb3 });
    localb1 = new b(30, new a[] { new a(19, 118), new a(6, 119) });
    localb2 = new b(28, new a[] { new a(18, 47), new a(31, 48) });
    localb3 = new b(30, new a[] { new a(34, 24), new a(34, 25) });
    b localb4 = new b(30, new a[] { new a(20, 15), new a(61, 16) });
    return new ml[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24, localObject25, localObject26, localObject27, localObject28, localObject29, localObject30, localObject31, localObject32, localObject33, localObject34, localObject35, localObject36, localObject37, localObject38, localObject39, new ml(40, new int[] { 6, 30, 58, 86, 114, 142, 170 }, new b[] { localb1, localb2, localb3, localb4 }) };
  }
  
  public int a()
  {
    return this.c;
  }
  
  public b a(mj parammj)
  {
    return this.e[parammj.ordinal()];
  }
  
  public int b()
  {
    return this.f;
  }
  
  public int c()
  {
    return this.c * 4 + 17;
  }
  
  public String toString()
  {
    return String.valueOf(this.c);
  }
  
  public static final class a
  {
    private final int a;
    private final int b;
    
    a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
    
    public int a()
    {
      return this.a;
    }
    
    public int b()
    {
      return this.b;
    }
  }
  
  public static final class b
  {
    private final int a;
    private final ml.a[] b;
    
    b(int paramInt, ml.a... paramVarArgs)
    {
      this.a = paramInt;
      this.b = paramVarArgs;
    }
    
    public int a()
    {
      return this.a;
    }
    
    public int b()
    {
      ml.a[] arrayOfa = this.b;
      int k = arrayOfa.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        j += arrayOfa[i].a();
        i += 1;
      }
      return j;
    }
    
    public int c()
    {
      return this.a * b();
    }
    
    public ml.a[] d()
    {
      return this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ml
 * JD-Core Version:    0.7.0.1
 */